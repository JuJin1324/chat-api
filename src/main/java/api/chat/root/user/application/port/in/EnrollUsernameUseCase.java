package api.chat.root.user.application.port.in;

import api.chat.root.user.application.port.in.command.EnrollUsernameCommand;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 4/24/24
 */
public interface EnrollUsernameUseCase {
    void enrollUsername(EnrollUsernameCommand command);
}
