package api.chat.root.user.domain;

import java.util.UUID;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 3/31/24
 */

public record UserId(UUID value) {
	public static UserId generate() {
		return new UserId(UUID.randomUUID());
	}
}
