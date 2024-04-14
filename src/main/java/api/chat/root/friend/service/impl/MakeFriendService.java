package api.chat.root.friend.service.impl;

import api.chat.root.friend.domain.Friend;
import api.chat.root.friend.repository.FriendRepository;
import api.chat.root.friend.service.MakeFriendUseCase;
import api.chat.root.friend.service.command.MakeFriendCommand;
import lombok.RequiredArgsConstructor;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 4/14/24
 */

@RequiredArgsConstructor
public class MakeFriendService implements MakeFriendUseCase {
	private final FriendRepository friendRepository;

	@Override
	public void makeFriend(MakeFriendCommand command) {
		var friend = new Friend(command.userId(), command.actor(), false, false);
		friendRepository.save(friend);
	}
}
