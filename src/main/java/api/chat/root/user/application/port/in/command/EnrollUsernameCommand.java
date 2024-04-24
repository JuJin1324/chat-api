package api.chat.root.user.application.port.in.command;

import java.util.UUID;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 4/24/24
 */
public record EnrollUsernameCommand(
	UUID userId,
	String username,
	String password
) {
}
