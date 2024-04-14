package api.chat.root.chat.application.port.in;

import api.chat.root.chat.application.port.in.command.SendTextMessageCommand;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 4/14/24
 */
public interface SendTextMessageUseCase {
	void sendTextMessage(SendTextMessageCommand command);
}
