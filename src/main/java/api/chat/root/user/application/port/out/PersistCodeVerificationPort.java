package api.chat.root.user.application.port.out;

import api.chat.root.user.domain.verification.CodeVerification;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 4/4/24
 */
public interface PersistCodeVerificationPort {
	void persist(CodeVerification codeVerification);
}
