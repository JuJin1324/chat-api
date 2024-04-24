package api.chat.root.user.application.port.in.command;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 4/4/24
 */
public record LoginByUsernameCommand(
	String username,
	String password
) {
}
