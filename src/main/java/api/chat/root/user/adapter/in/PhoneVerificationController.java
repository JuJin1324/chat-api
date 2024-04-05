package api.chat.root.user.adapter.in;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import api.chat.root.user.application.port.in.PhoneVerificationUseCase;
import api.chat.root.user.application.port.in.command.PhoneVerificationCommand;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
		var command = mapRequestToCommand(request);
		var verified = phoneVerificationUseCase.verify(command);
		return new PhoneVerificationResponse(verified);
	}

	private PhoneVerificationCommand mapRequestToCommand(PhoneVerificationRequest request) {
		return new PhoneVerificationCommand(request.getPhoneNumber(), request.getCode());
	}

	@NoArgsConstructor
	@AllArgsConstructor
	@Getter
	public static class PhoneVerificationRequest {
		private String phoneNumber;
		private String code;
	}

	@NoArgsConstructor
	@AllArgsConstructor
	@Getter
	public static class PhoneVerificationResponse {
		private boolean isVerified;
	}
}
