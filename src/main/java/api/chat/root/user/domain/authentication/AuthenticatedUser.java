package api.chat.root.user.domain.authentication;

import api.chat.root.user.domain.User;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 3/31/24
 */

public record AuthenticatedUser(
	String nickname,
	String profileImageUrl,
	AccessToken accessToken
) {
	public static AuthenticatedUser from(User user) {
		return new AuthenticatedUser(user.getNickname(), user.getProfileImageUrl(), user.getAccessToken());
	}
}
