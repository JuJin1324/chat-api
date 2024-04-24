package api.chat.root.user.domain.authentication;

import api.chat.root.user.application.port.out.EncodePasswordPort;
import api.chat.root.user.application.port.out.MatchPasswordPort;
import lombok.Getter;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 4/1/24
 */

@Getter
public abstract class PasswordAuthentication {
	private final String password;

	protected PasswordAuthentication(String password, EncodePasswordPort encodePasswordPort) {
		this.password = encodePasswordPort.encode(password);
	}

	public AccessToken authenticate(String inputPassword, MatchPasswordPort matchPasswordPort) {
		if (!matchPasswordPort.matches(this.password, inputPassword)) {
			throw new RuntimeException();
		}
		return AccessToken.generate();
	}
}
