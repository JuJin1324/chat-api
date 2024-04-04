package api.chat.root.user.application.port.in;

import api.chat.root.user.application.port.in.command.LoginByPhoneCommand;
import api.chat.root.user.domain.authentication.AuthenticatedUser;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 3/31/24
 */
public interface LoginByPhoneUseCase {
	AuthenticatedUser login(LoginByPhoneCommand command);
}
