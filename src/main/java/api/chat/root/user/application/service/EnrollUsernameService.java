package api.chat.root.user.application.service;

import api.chat.root.user.application.port.in.EnrollUsernameUseCase;
import api.chat.root.user.application.port.in.command.EnrollUsernameCommand;
import api.chat.root.user.application.port.out.EncodePasswordPort;
import api.chat.root.user.application.port.out.LoadUserByUsernamePort;
import api.chat.root.user.application.port.out.PersistUsernameAuthenticationPort;
import api.chat.root.user.domain.authentication.UsernameAuthentication;
import lombok.RequiredArgsConstructor;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 4/24/24
 */

@RequiredArgsConstructor
public class EnrollUsernameService implements EnrollUsernameUseCase {
	private final LoadUserByUsernamePort loadUserByUsernamePort;
	private final EncodePasswordPort encodePasswordPort;
	private final PersistUsernameAuthenticationPort persistUsernameAuthenticationPort;

	@Override
	public void enrollUsername(EnrollUsernameCommand command) {
		if (existsUserOf(command.username())) {
			throw new RuntimeException();
		}
		var usernameAuthentication = UsernameAuthentication.of(
			command.username(),
			command.password(),
			encodePasswordPort
		);
		persistUsernameAuthenticationPort.persist(usernameAuthentication);
	}

	private boolean existsUserOf(String username) {
		return loadUserByUsernamePort.load(username) != null;
	}
}
