package api.chat.root.user.application.service;

import api.chat.root.user.application.port.in.PhoneVerificationUseCase;
import api.chat.root.user.application.port.in.command.PhoneVerificationCommand;
import api.chat.root.user.application.port.out.LoadCodeVerificationByPhonePort;
import api.chat.root.user.application.port.out.PersistCodeVerificationPort;
import api.chat.root.user.domain.verification.VerificationToken;
import lombok.RequiredArgsConstructor;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 3/31/24
 */

@RequiredArgsConstructor
public class PhoneVerificationService implements PhoneVerificationUseCase {
	private final LoadCodeVerificationByPhonePort loadCodeVerificationByPhonePort;
	private final PersistCodeVerificationPort persistCodeVerificationPort;

	@Override
	public VerificationToken verify(PhoneVerificationCommand command) {
		var codeVerification = loadCodeVerificationByPhonePort.load(command.phoneNumber());
		codeVerification.verify(command.code());
		persistCodeVerificationPort.persist(codeVerification);

		return codeVerification.getVerificationToken();
	}
}
