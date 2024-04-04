package api.chat.root.user.application.port.in.command;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 3/31/24
 */

public record EmailVerificationCommand(String emailAddress, String code) {
}
