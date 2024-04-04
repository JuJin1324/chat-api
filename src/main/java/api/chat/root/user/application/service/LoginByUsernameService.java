package api.chat.root.user.application.service;

import api.chat.root.user.application.port.in.LoginByUsernameUseCase;
import api.chat.root.user.application.port.in.command.LoginByUsernameCommand;
import api.chat.root.user.application.port.out.LoadUsernameAuthenticationPort;
import api.chat.root.user.application.port.out.LoadUserByUsernamePort;
import api.chat.root.user.application.port.out.MatchPasswordPort;
import api.chat.root.user.application.port.out.PersistUserPort;
import api.chat.root.user.domain.User;
import api.chat.root.user.domain.authentication.AuthenticatedUser;
import lombok.RequiredArgsConstructor;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 3/31/24
 */

@RequiredArgsConstructor
public class LoginByUsernameService implements LoginByUsernameUseCase {
	private final LoadUsernameAuthenticationPort loadUsernameAuthenticationPort;
	private final MatchPasswordPort matchPasswordPort;
	private final LoadUserByUsernamePort loadUserByUsernamePort;
	private final PersistUserPort persistUserPort;

	@Override
	public AuthenticatedUser login(LoginByUsernameCommand command) {
		var usernameAuthentication = loadUsernameAuthenticationPort.load(command.username());

		var user = loadUserByUsernamePort.load(command.username());
		user.authenticate(command.password(), usernameAuthentication, matchPasswordPort);
		persistUserPort.persist(user);

		return mapUserToAuthenticatedUser(user);
	}

	private AuthenticatedUser mapUserToAuthenticatedUser(User user) {
		return new AuthenticatedUser(user.getNickname(), user.getProfileImageUrl(), user.getAccessToken());
	}
}
