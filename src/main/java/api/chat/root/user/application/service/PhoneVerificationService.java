package api.chat.root.user.application.service;

import api.chat.root.user.application.port.in.PhoneVerificationUseCase;
import api.chat.root.user.application.port.in.command.PhoneVerificationCommand;
import api.chat.root.user.application.port.out.LoadPhoneVerificationPort;
import api.chat.root.user.application.port.out.PersistPhoneVerificationPort;
import lombok.RequiredArgsConstructor;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 3/31/24
 */

@RequiredArgsConstructor
public class PhoneVerificationService implements PhoneVerificationUseCase {
	private final LoadPhoneVerificationPort loadPhoneVerificationPort;
	private final PersistPhoneVerificationPort persistPhoneVerificationPort;

	@Override
	public boolean verify(PhoneVerificationCommand command) {
		var phoneVerification = loadPhoneVerificationPort.load(command.phoneNumber());
		phoneVerification.verify(command.code());
		persistPhoneVerificationPort.persist(phoneVerification);

		return phoneVerification.isVerified();
	}
}
