package api.chat.root.user.application.service;

import api.chat.root.user.application.port.in.EmailVerificationUseCase;
import api.chat.root.user.application.port.in.command.EmailVerificationCommand;
import api.chat.root.user.application.port.out.LoadCodeVerificationByEmailPort;
import api.chat.root.user.application.port.out.PersistCodeVerificationPort;
import api.chat.root.user.domain.verification.VerificationToken;
import lombok.RequiredArgsConstructor;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 3/31/24
 */

@RequiredArgsConstructor
public class EmailVerificationService implements EmailVerificationUseCase {
	private final LoadCodeVerificationByEmailPort loadCodeVerificationByEmailPort;
	private final PersistCodeVerificationPort persistCodeVerificationPort;

	@Override
	public VerificationToken verify(EmailVerificationCommand command) {
		var codeVerification = loadCodeVerificationByEmailPort.load(command.emailAddress());
		codeVerification.verify(command.code());
		persistCodeVerificationPort.persist(codeVerification);

		return codeVerification.getVerificationToken();
	}
}
