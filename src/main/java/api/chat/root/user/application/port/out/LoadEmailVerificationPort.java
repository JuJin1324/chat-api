package api.chat.root.user.application.port.out;

import api.chat.root.user.domain.verification.EmailVerification;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 4/4/24
 */
public interface LoadEmailVerificationPort {
	EmailVerification load(String emailAddress);
}
