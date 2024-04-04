package api.chat.root.user.adapter.in;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import api.chat.root.user.application.port.in.LoginByPhoneUseCase;
import api.chat.root.user.application.port.in.command.LoginByPhoneCommand;
import api.chat.root.user.domain.authentication.AuthenticatedUser;
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
public class LoginByPhoneController {
	private final LoginByPhoneUseCase loginByPhoneUseCase;

	@PostMapping("/users/login-by-phone")
	public AuthenticatedUser login(LoginByPhoneRequest request) {
		var command = mapRequestToCommand(request);
		return loginByPhoneUseCase.login(command);
	}

	private LoginByPhoneCommand mapRequestToCommand(LoginByPhoneRequest request) {
		return new LoginByPhoneCommand(request.getPhoneNumber(), request.getCode());
	}

	@NoArgsConstructor
	@AllArgsConstructor
	@Getter
	public static class LoginByPhoneRequest {
		private String phoneNumber;
		private String code;
	}
}
