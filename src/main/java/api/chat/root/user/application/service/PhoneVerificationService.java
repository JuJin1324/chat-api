package api.chat.root.user.application.service;

import api.chat.root.user.application.port.in.PhoneVerificationUseCase;
import api.chat.root.user.application.port.in.command.PhoneVerificationCommand;
import api.chat.root.user.application.port.out.LoadCodeVerificationByPhonePort;
import api.chat.root.user.application.port.out.LoadUserByPhonePort;
import api.chat.root.user.domain.verification.VerifiedUser;
import lombok.RequiredArgsConstructor;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 3/31/24
 */

@RequiredArgsConstructor
public class PhoneVerificationService implements PhoneVerificationUseCase {
	private final LoadCodeVerificationByPhonePort loadCodeVerificationByPhonePort;
	private final LoadUserByPhonePort loadUserByPhonePort;

	@Override
	public VerifiedUser verify(PhoneVerificationCommand command) {
		var codeVerification = loadCodeVerificationByPhonePort.loadByPhone(command.phoneNumber());
		codeVerification.verify(command.code());

		var user = loadUserByPhonePort.load(command.phoneNumber());

		return new VerifiedUser(user.getNickname(), user.getProfileImageUrl(), codeVerification.getVerificationToken());
	}
}
