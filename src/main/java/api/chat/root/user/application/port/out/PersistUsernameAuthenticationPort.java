package api.chat.root.user.application.port.out;

import api.chat.root.user.domain.authentication.UsernameAuthentication;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 4/24/24
 */
public interface PersistUsernameAuthenticationPort {
    void persist(UsernameAuthentication usernameAuthentication);
}
