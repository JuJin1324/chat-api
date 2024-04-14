package api.chat.root.chat.application.service;

import api.chat.root.chat.application.port.in.CreateChatRoomUseCase;
import api.chat.root.chat.application.port.in.command.CreateChatRoomCommand;
import api.chat.root.chat.application.port.out.ListUsersQuery;
import api.chat.root.chat.application.port.out.PersistChatRoomPort;
import api.chat.root.chat.domain.ChatRoom;
import lombok.RequiredArgsConstructor;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 4/14/24
 */

@RequiredArgsConstructor
public class CreateChatRoomService implements CreateChatRoomUseCase {
	private final ListUsersQuery listUsersQuery;
	private final PersistChatRoomPort persistChatRoomPort;

	@Override
	public void createChatRoom(CreateChatRoomCommand command) {
		var users = listUsersQuery.getList(command.userIds());
		var chatRoom = new ChatRoom(users);
		persistChatRoomPort.persist(chatRoom);
	}
}
