package api.chat.root.chat.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

import api.chat.root.chat.application.port.out.SendTextMessagePort;
import api.chat.root.chat.domain.message.TextMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 4/14/24
 */

@AllArgsConstructor
@Getter
public class ChatRoom {
	private final ChatRoomId id;
	private String title;
	private List<Member> members;
	private boolean favorite;

	public ChatRoom(List<User> users) {
		this.id = ChatRoomId.generate();
		this.members = users
			.stream()
			.map(User::toMember)
			.toList();
		this.title = titleFromMembers(this.members);
		this.favorite = false;
	}

	public void invite(User user, UUID actor) {
		if (!isMember(actor)) {
			throw new RuntimeException();
		}

		this.members = addMember(this.members, user);
		this.title = titleFromMembers(this.members);
	}

	public void sendOut(User user) {
		if (!isMember(user)) {
			throw new RuntimeException();
		}

		this.members = removeMember(this.members, user);
		this.title = titleFromMembers(this.members);
	}

	public void sendTextMessage(TextMessage textMessage, SendTextMessagePort messageSender) {
		if (!isMember(textMessage.sendUserId())) {
			throw new RuntimeException();
		}

		messageSender.sendTextMessage(pushTokensFrom(this.members), textMessage);
	}

	private static List<Member> addMember(List<Member> members, User user) {
		var mutableList = new ArrayList<>(members);
		mutableList.add(user.toMember());
		return Collections.unmodifiableList(mutableList);
	}

	private static List<Member> removeMember(List<Member> members, User user) {
		var mutableList = new ArrayList<>(members);
		mutableList.removeIf(member -> Objects.equals(member, user.toMember()));
		return Collections.unmodifiableList(mutableList);
	}

	private static String titleFromMembers(List<Member> members) {
		return members
			.stream()
			.map(Member::nickname)
			.collect(Collectors.joining(","));
	}

	private boolean isMember(User user) {
		return this.members
			.stream()
			.anyMatch(member -> member.equals(user.toMember()));
	}

	private boolean isMember(UUID userId) {
		return this.members
			.stream()
			.anyMatch(member -> member.userId().equals(userId));
	}

	private static List<PushToken> pushTokensFrom(List<Member> members) {
		return members
			.stream()
			.map(Member::pushToken)
			.toList();
	}
}
