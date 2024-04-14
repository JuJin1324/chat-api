package api.chat.root.chat.domain;

import java.util.UUID;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 4/14/24
 */
public record User(
	UUID userId,
	String nickname,
	String profileImageUrl,
	String pushToken
) {
	public Member toMember() {
		return new Member(userId, nickname, profileImageUrl, new PushToken(pushToken));
	}
}
