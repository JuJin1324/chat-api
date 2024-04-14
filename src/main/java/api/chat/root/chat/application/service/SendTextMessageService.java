package api.chat.root.chat.application.service;

import api.chat.root.chat.application.port.in.SendTextMessageUseCase;
import api.chat.root.chat.application.port.in.command.SendTextMessageCommand;
import api.chat.root.chat.application.port.out.LoadChatRoomPort;
import api.chat.root.chat.application.port.out.SendTextMessagePort;
import api.chat.root.chat.domain.message.TextMessage;
import lombok.RequiredArgsConstructor;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 4/14/24
 */

@RequiredArgsConstructor
public class SendTextMessageService implements SendTextMessageUseCase {
	private final LoadChatRoomPort loadChatRoomPort;
	private final SendTextMessagePort sendTextMessagePort;

	@Override
	public void sendTextMessage(SendTextMessageCommand command) {
		var chatRoom = loadChatRoomPort.load(command.chatRoomId());
		var textMessage = new TextMessage(chatRoom.getId(), command.content(), command.actor());
		chatRoom.sendTextMessage(textMessage, sendTextMessagePort);
	}
}
