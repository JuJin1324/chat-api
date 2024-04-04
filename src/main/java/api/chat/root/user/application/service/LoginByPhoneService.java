package api.chat.root.user.application.service;

import api.chat.root.user.application.port.in.LoginByPhoneUseCase;
import api.chat.root.user.application.port.in.command.LoginByPhoneCommand;
import api.chat.root.user.application.port.out.LoadCodeAuthenticationByPhonePort;
import api.chat.root.user.application.port.out.LoadUserByPhonePort;
import api.chat.root.user.application.port.out.PersistCodeAuthenticationPort;
import api.chat.root.user.domain.authentication.AuthenticatedUser;
import lombok.RequiredArgsConstructor;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 3/31/24
 */

@RequiredArgsConstructor
public class LoginByPhoneService implements LoginByPhoneUseCase {
	private final LoadCodeAuthenticationByPhonePort loadCodeAuthenticationByPhonePort;
	private final PersistCodeAuthenticationPort persistCodeAuthenticationPort;
	private final LoadUserByPhonePort loadUserByPhonePort;

	@Override
	public AuthenticatedUser login(LoginByPhoneCommand command) {
		var codeAuthentication = loadCodeAuthenticationByPhonePort.loadByPhone(command.phoneNumber());
		codeAuthentication.verify(command.code());
		persistCodeAuthenticationPort.persist(codeAuthentication);

		var user = loadUserByPhonePort.load(command.phoneNumber());

		return new AuthenticatedUser(user.getNickname(), user.getProfileImageUrl(),
			codeAuthentication.getAccessToken());
	}
}
