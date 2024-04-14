package api.chat.root.chat.domain;

import java.util.UUID;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 4/14/24
 */
public record Member(
	UUID userId,
	String nickname,
	String profileImageUrl,
	PushToken pushToken
) {
}
