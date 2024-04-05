package api.chat.root.user.adapter.in;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import api.chat.root.user.application.port.in.EmailVerificationUseCase;
import api.chat.root.user.application.port.in.command.EmailVerificationCommand;
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
public class EmailVerificationController {
	private final EmailVerificationUseCase emailVerificationUseCase;

	@PostMapping("/users/verification/email")
	public EmailVerificationResponse verifyPhone(EmailVerificationRequest request) {
		var command = mapRequestToCommand(request);
		var verified = emailVerificationUseCase.verify(command);
		return new EmailVerificationResponse(verified);
	}

	private EmailVerificationCommand mapRequestToCommand(EmailVerificationRequest request) {
		return new EmailVerificationCommand(request.getEmailAddress(), request.getCode());
	}

	@NoArgsConstructor
	@AllArgsConstructor
	@Getter
	public static class EmailVerificationRequest {
		private String emailAddress;
		private String code;
	}

	@NoArgsConstructor
	@AllArgsConstructor
	@Getter
	public static class EmailVerificationResponse {
		private boolean isVerified;
	}
}
