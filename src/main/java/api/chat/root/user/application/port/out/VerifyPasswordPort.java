package api.chat.root.user.application.port.out;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 1/18/24
 */
public interface VerifyPasswordPort {
	boolean matches(String accountsPw, String inputPw);
}
