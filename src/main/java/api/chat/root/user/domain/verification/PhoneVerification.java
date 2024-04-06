package api.chat.root.user.domain.verification;

import java.time.LocalDateTime;

import lombok.Getter;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 4/1/24
 */

@Getter
public class PhoneVerification extends CodeVerification {
	private final String phoneNumber;

	protected PhoneVerification(VerificationCode verificationCode, boolean verified, LocalDateTime expirationTime,
		String phoneNumber) {

		super(verificationCode, verified, expirationTime);
		this.phoneNumber = phoneNumber;
	}

	public static PhoneVerification generate(String phoneNumber) {
		return new PhoneVerification(VerificationCode.generate(), false, null, phoneNumber);
	}
}
