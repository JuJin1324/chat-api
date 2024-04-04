package api.chat.root.user.application.service;

import api.chat.root.user.application.port.in.LoginUseCase;
import api.chat.root.user.application.port.in.command.LoginCommand;
import api.chat.root.user.application.port.out.LoadUserByUsernamePort;
import api.chat.root.user.application.port.out.VerifyPasswordPort;
import api.chat.root.user.domain.verification.VerifiedUser;
import lombok.RequiredArgsConstructor;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 3/31/24
 */

@RequiredArgsConstructor
public class LoginService implements LoginUseCase {
	private final LoadUserByUsernamePort loadUserByUsernamePort;
	private final VerifyPasswordPort verifyPasswordPort;

	@Override
	public VerifiedUser login(LoginCommand command) {
		var username = command.username();
		var password = command.password();

		var user = loadUserByUsernamePort.load(username);
		var matches = verifyPasswordPort.matches(user.getPassword(), password);
		if (!matches) {
			throw new RuntimeException();
		}
		var authenticationToken = user.verifyCode(password);
		return new VerifiedUser(user.getNickname(), user.getProfileImageUrl(), authenticationToken);
	}
}
