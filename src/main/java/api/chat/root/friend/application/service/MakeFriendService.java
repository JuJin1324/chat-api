package api.chat.root.friend.application.service;

import api.chat.root.friend.application.port.in.MakeFriendUseCase;
import api.chat.root.friend.application.port.in.command.MakeFriendCommand;
import api.chat.root.friend.application.port.out.PersistFriendPort;
import api.chat.root.friend.domain.Friend;
import lombok.RequiredArgsConstructor;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 4/14/24
 */

@RequiredArgsConstructor
public class MakeFriendService implements MakeFriendUseCase {
	private final PersistFriendPort persistFriendPort;

	@Override
	public void makeFriend(MakeFriendCommand command) {
		var friend = new Friend(command.userId(), command.actor(), false, false);
		persistFriendPort.persist(friend);
	}
}
