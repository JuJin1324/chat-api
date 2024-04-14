package api.chat.root.friend.domain;

import java.util.UUID;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 4/14/24
 */

public record Friend(
	UUID userId,
	UUID ownerUserId,
	boolean favorite,
	boolean blocked
) {
	public Friend favorite(boolean favorite) {
		return new Friend(this.userId, this.ownerUserId, favorite, this.blocked);
	}

	public Friend block(boolean blocked) {
		return new Friend(this.userId, this.ownerUserId, this.favorite, blocked);
	}
}
