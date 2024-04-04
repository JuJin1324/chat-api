package api.chat.root.user.domain.authentication;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 3/31/24
 */

public record AuthenticatedUser(
	String nickname,
	String profileImageUrl,
	AccessToken accessToken
) {
}
