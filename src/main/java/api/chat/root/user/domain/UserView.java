package api.chat.root.user.domain;

import java.util.UUID;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 4/14/24
 */
public record UserView(
	UUID userId,
	String nickname,
	String profileImageUrl,
	String phoneNumber
) {
}
