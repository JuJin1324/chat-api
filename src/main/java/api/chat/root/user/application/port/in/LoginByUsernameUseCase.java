package api.chat.root.user.application.port.in;

import api.chat.root.user.application.port.in.command.LoginByUsernameCommand;
import api.chat.root.user.domain.authentication.AuthenticatedUser;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 3/31/24
 */
public interface LoginByUsernameUseCase {
	AuthenticatedUser login(LoginByUsernameCommand command);
}
