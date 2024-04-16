package api.chat.root.friend.application.port.out;

import api.chat.root.friend.domain.Friend;
import api.chat.root.friend.domain.FriendId;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 4/16/24
 */
public interface LoadFriendPort {
    Friend load(FriendId id);
}
