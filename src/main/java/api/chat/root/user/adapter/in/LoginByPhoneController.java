package api.chat.root.user.adapter.in;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import api.chat.root.user.application.port.in.LoginByPhoneUseCase;
import api.chat.root.user.application.port.in.command.LoginByPhoneCommand;
import api.chat.root.user.domain.authentication.AuthenticatedUser;
import lombok.RequiredArgsConstructor;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 3/31/24
 */

@RestController
@RequiredArgsConstructor
public class LoginByPhoneController {
	private final LoginByPhoneUseCase loginByPhoneUseCase;

	@PostMapping("/users/login-by-phone")
	public AuthenticatedUser login(LoginByPhoneRequest request) {
		return loginByPhoneUseCase.login(request.toCommand());
	}

	public record LoginByPhoneRequest(String phoneNumber, String code) {
		public LoginByPhoneCommand toCommand() {
			return new LoginByPhoneCommand(phoneNumber, code);
		}
	}
}
