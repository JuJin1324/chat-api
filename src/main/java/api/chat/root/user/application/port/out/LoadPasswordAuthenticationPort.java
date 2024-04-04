package api.chat.root.user.application.port.out;

import api.chat.root.user.domain.authentication.PasswordAuthentication;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 4/4/24
 */
public interface LoadPasswordAuthenticationPort {
	PasswordAuthentication load(String username);
}
