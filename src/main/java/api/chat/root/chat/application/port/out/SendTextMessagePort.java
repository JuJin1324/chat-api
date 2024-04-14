package api.chat.root.chat.application.port.out;

import java.util.List;

import api.chat.root.chat.domain.PushToken;
import api.chat.root.chat.domain.message.TextMessage;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 4/14/24
 */
public interface SendTextMessagePort {
	void sendTextMessage(List<PushToken> tokens, TextMessage textMessage);
}
