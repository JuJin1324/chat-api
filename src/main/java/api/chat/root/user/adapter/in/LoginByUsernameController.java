package api.chat.root.user.adapter.in;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import api.chat.root.user.application.port.in.LoginByUsernameUseCase;
import api.chat.root.user.application.port.in.command.LoginByUsernameCommand;
import api.chat.root.user.domain.authentication.AuthenticatedUser;
import lombok.RequiredArgsConstructor;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 3/31/24
 */

@RestController
@RequiredArgsConstructor
public class LoginByUsernameController {
	private final LoginByUsernameUseCase loginByUsernameUseCase;

	@PostMapping("/users/login-by-username")
	public AuthenticatedUser login(LoginByUsernameRequest request) {
		return loginByUsernameUseCase.login(request.toCommand());
	}

	public record LoginByUsernameRequest(String username, String password) {
		public LoginByUsernameCommand toCommand() {
			return new LoginByUsernameCommand(username, password);
		}
	}
}
