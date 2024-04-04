package api.chat.root.user.adapter.in;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import api.chat.root.user.application.port.in.LoginUseCase;
import api.chat.root.user.application.port.in.command.LoginCommand;
import api.chat.root.user.domain.verification.VerifiedUser;
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
public class LoginController {
	private final LoginUseCase loginUseCase;

	@PostMapping("/users/login")
	public VerifiedUser login(LoginRequest request) {
		var command = mapRequestToCommand(request);
		return loginUseCase.login(command);
	}

	private LoginCommand mapRequestToCommand(LoginRequest request) {
		return new LoginCommand(request.getUsername(), request.getPassword());
	}

	@NoArgsConstructor
	@AllArgsConstructor
	@Getter
	public static class LoginRequest {
		private String username;
		private String password;
	}
}
