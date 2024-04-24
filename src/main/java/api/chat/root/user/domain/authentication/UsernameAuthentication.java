package api.chat.root.user.domain.authentication;

import api.chat.root.user.application.port.out.EncodePasswordPort;
import lombok.Getter;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 4/1/24
 */

@Getter
public class UsernameAuthentication extends PasswordAuthentication {
	private final String username;

	protected UsernameAuthentication(String password, EncodePasswordPort encodePasswordPort, String username) {
		super(password, encodePasswordPort);
		this.username = username;
	}

	public static UsernameAuthentication of(String username, String password, EncodePasswordPort encodePasswordPort) {
		return new UsernameAuthentication(password, encodePasswordPort, username);
	}
}
