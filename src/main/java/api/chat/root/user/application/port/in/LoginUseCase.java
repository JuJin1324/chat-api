package api.chat.root.user.application.port.in;

import api.chat.root.user.application.port.in.command.LoginCommand;
import api.chat.root.user.domain.verification.VerifiedUser;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 3/31/24
 */
public interface LoginUseCase {
	VerifiedUser login(LoginCommand command);
}
