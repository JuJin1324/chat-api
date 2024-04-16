package api.chat.root.friend.application.port.out;

import api.chat.root.friend.domain.Friend;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 4/16/24
 */
public interface PersistFriendPort {
	void persist(Friend friend);
}
