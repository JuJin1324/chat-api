package api.chat.root.user.domain.authentication;

import api.chat.root.user.application.port.out.MatchPasswordPort;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 4/1/24
 */

@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public abstract class PasswordAuthentication {
	private String password;

	public AccessToken authenticate(String inputPassword, MatchPasswordPort matchPasswordPort) {
		if (!matchPasswordPort.matches(this.password, inputPassword)) {
			throw new RuntimeException();
		}
		return AccessToken.generate();
	}
}
