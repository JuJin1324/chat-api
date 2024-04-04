package api.chat.root.user.domain.authentication;

import api.chat.root.user.domain.VerificationCode;
import lombok.Getter;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 4/1/24
 */

@Getter
public class PhoneAuthentication extends CodeAuthentication {
	private final String phoneNumber;

	protected PhoneAuthentication(VerificationCode verificationCode, String phoneNumber) {
		super(verificationCode);
		this.phoneNumber = phoneNumber;
	}

	public static PhoneAuthentication generate(String phoneNumber) {
		return new PhoneAuthentication(VerificationCode.generate(), phoneNumber);
	}
}
