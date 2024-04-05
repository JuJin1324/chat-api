package api.chat.root.user.domain;

import api.chat.root.user.application.port.out.MatchPasswordPort;
import api.chat.root.user.domain.authentication.AccessToken;
import api.chat.root.user.domain.authentication.CodeAuthentication;
import api.chat.root.user.domain.authentication.PasswordAuthentication;
import api.chat.root.user.domain.verification.CodeVerification;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 3/31/24
 */

@AllArgsConstructor
@Getter
public class User {
	private final UserId id;
	private String nickname;
	private String profileImageUrl;
	private String phoneNumber;
	private String emailAddress;
	private final String username;
	private AccessToken accessToken;

	public static User ofPhone(String nickname, String profileImageUrl, String phoneNumber,
		CodeVerification codeVerification) {

		requireCodeVerification(codeVerification);

		return new User(UserId.generate(), nickname, profileImageUrl, phoneNumber, null,
			null, null);
	}

	public static User ofEmail(String nickname, String profileImageUrl, String emailAddress,
		CodeVerification codeVerification) {

		requireCodeVerification(codeVerification);

		return new User(UserId.generate(), nickname, profileImageUrl, null, emailAddress,
			null, null);
	}

	private static void requireCodeVerification(CodeVerification codeVerification) {
		if (!codeVerification.isVerified()) {
			throw new RuntimeException();
		}
	}

	public void authenticate(String code, CodeAuthentication codeAuthentication) {
		this.accessToken = codeAuthentication.authenticate(code);
	}

	public void authenticate(String password, PasswordAuthentication passwordAuthentication,
		MatchPasswordPort matchPasswordPort) {

		this.accessToken = passwordAuthentication.authenticate(password, matchPasswordPort);
	}
}
