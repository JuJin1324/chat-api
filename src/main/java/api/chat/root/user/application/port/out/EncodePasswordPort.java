package api.chat.root.user.application.port.out;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 4/24/24
 */
public interface EncodePasswordPort {
    String encode(String rawPassword);
}
