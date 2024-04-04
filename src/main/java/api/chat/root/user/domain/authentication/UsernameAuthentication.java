package api.chat.root.user.domain.authentication;

import lombok.Getter;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 4/1/24
 */

@Getter
public class UsernameAuthentication extends PasswordAuthentication {
	private final String username;

	protected UsernameAuthentication(String password, String username) {
		super(password);
		this.username = username;
	}

	public static UsernameAuthentication of(String username, String password) {
		return new UsernameAuthentication(password, username);
	}
}
