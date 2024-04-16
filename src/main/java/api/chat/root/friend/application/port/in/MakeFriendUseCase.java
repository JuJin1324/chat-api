package api.chat.root.friend.application.port.in;

import api.chat.root.friend.application.port.in.command.MakeFriendCommand;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 4/14/24
 */
public interface MakeFriendUseCase {
	void makeFriend(MakeFriendCommand command);
}
