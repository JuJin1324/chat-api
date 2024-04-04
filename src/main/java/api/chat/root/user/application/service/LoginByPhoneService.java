package api.chat.root.user.application.service;

import api.chat.root.user.application.port.in.LoginByPhoneUseCase;
import api.chat.root.user.application.port.in.command.LoginByPhoneCommand;
import api.chat.root.user.application.port.out.LoadPhoneAuthenticationPort;
import api.chat.root.user.application.port.out.LoadUserByPhonePort;
import api.chat.root.user.application.port.out.PersistCodeAuthenticationPort;
import api.chat.root.user.application.port.out.PersistUserPort;
import api.chat.root.user.domain.User;
import api.chat.root.user.domain.authentication.AuthenticatedUser;
import lombok.RequiredArgsConstructor;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 3/31/24
 */

@RequiredArgsConstructor
public class LoginByPhoneService implements LoginByPhoneUseCase {
	private final LoadPhoneAuthenticationPort loadPhoneAuthenticationPort;
	private final PersistCodeAuthenticationPort persistCodeAuthenticationPort;
	private final LoadUserByPhonePort loadUserByPhonePort;
	private final PersistUserPort persistUserPort;

	@Override
	public AuthenticatedUser login(LoginByPhoneCommand command) {
		var phoneAuthentication = loadPhoneAuthenticationPort.load(command.phoneNumber());

		var user = loadUserByPhonePort.load(command.phoneNumber());
		user.authenticate(command.code(), phoneAuthentication);

		persistCodeAuthenticationPort.persist(phoneAuthentication);
		persistUserPort.persist(user);

		return mapUserToAuthenticatedUser(user);
	}

	private AuthenticatedUser mapUserToAuthenticatedUser(User user) {
		return new AuthenticatedUser(user.getNickname(), user.getProfileImageUrl(), user.getAccessToken());
	}
}
