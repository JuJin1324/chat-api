package api.chat.root.user.application.service;

import api.chat.root.user.application.port.in.EmailVerificationUseCase;
import api.chat.root.user.application.port.in.command.EmailVerificationCommand;
import api.chat.root.user.application.port.out.LoadEmailVerificationPort;
import api.chat.root.user.application.port.out.PersistEmailVerificationPort;
import lombok.RequiredArgsConstructor;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 3/31/24
 */

@RequiredArgsConstructor
public class EmailVerificationService implements EmailVerificationUseCase {
	private final LoadEmailVerificationPort loadEmailVerificationPort;
	private final PersistEmailVerificationPort persistEmailVerificationPort;

	@Override
	public boolean verify(EmailVerificationCommand command) {
		var emailVerification = loadEmailVerificationPort.load(command.emailAddress());
		emailVerification.verify(command.code());
		persistEmailVerificationPort.persist(emailVerification);

		return emailVerification.isVerified();
	}
}
