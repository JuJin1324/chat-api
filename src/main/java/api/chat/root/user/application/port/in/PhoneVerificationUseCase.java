package api.chat.root.user.application.port.in;

import api.chat.root.user.application.port.in.command.PhoneVerificationCommand;
import api.chat.root.user.domain.verification.VerificationToken;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 3/31/24
 */
public interface PhoneVerificationUseCase {
	VerificationToken verify(PhoneVerificationCommand command);
}
