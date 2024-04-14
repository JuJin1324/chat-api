package api.chat.root.friend.repository;

import api.chat.root.friend.domain.Friend;
import api.chat.root.friend.domain.FriendId;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 4/14/24
 */
public interface FriendRepository {
	Friend findById(FriendId id);

	Friend save(Friend friend);
}
