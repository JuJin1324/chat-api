package api.chat.root.user.application.service;

import api.chat.root.user.application.port.in.EmailVerificationUseCase;
import api.chat.root.user.application.port.in.command.EmailVerificationCommand;
import api.chat.root.user.application.port.out.LoadCodeVerificationByEmailPort;
import api.chat.root.user.application.port.out.LoadUserByEmailPort;
import api.chat.root.user.domain.verification.VerifiedUser;
import lombok.RequiredArgsConstructor;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 3/31/24
 */

@RequiredArgsConstructor
public class EmailVerificationService implements EmailVerificationUseCase {
	private final LoadCodeVerificationByEmailPort loadCodeVerificationByEmailPort;
	private final LoadUserByEmailPort loadUserByEmailPort;

	@Override
	public VerifiedUser verify(EmailVerificationCommand command) {
		var codeVerification = loadCodeVerificationByEmailPort.loadByEmail(command.emailAddress());
		codeVerification.verify(command.code());

		var user = loadUserByEmailPort.load(command.emailAddress());

		return new VerifiedUser(user.getNickname(), user.getProfileImageUrl(), codeVerification.getVerificationToken());
	}
}
