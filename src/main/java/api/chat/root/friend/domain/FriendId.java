package api.chat.root.friend.domain;

import java.util.UUID;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 4/14/24
 */
public record FriendId(UUID value) {
	public static FriendId generate() {
		return new FriendId(UUID.randomUUID());
	}
}
