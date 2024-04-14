package api.chat.root.user.adapter.in;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import api.chat.root.user.application.port.in.PhoneVerificationUseCase;
import api.chat.root.user.application.port.in.command.PhoneVerificationCommand;
import lombok.RequiredArgsConstructor;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 3/31/24
 */

@RestController
@RequiredArgsConstructor
public class PhoneVerificationController {
	private final PhoneVerificationUseCase phoneVerificationUseCase;

	@PostMapping("/users/verification/phone")
	public PhoneVerificationResponse verifyPhone(PhoneVerificationRequest request) {
		var verified = phoneVerificationUseCase.verify(request.toCommand());
		return new PhoneVerificationResponse(verified);
	}

	public record PhoneVerificationRequest(String phoneNumber, String code) {
		public PhoneVerificationCommand toCommand() {
			return new PhoneVerificationCommand(phoneNumber, code);
		}
	}

	public record PhoneVerificationResponse(boolean isVerified) {
	}
}
