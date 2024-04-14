package api.chat.root.user.adapter.in;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import api.chat.root.user.application.port.in.EmailVerificationUseCase;
import api.chat.root.user.application.port.in.command.EmailVerificationCommand;
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
		var verified = emailVerificationUseCase.verify(request.toCommand());
		return new EmailVerificationResponse(verified);
	}
	
	public record EmailVerificationRequest(String emailAddress, String code) {
		public EmailVerificationCommand toCommand() {
			return new EmailVerificationCommand(emailAddress, code);
		}
	}

	public record EmailVerificationResponse(boolean isVerified) {
	}
}
