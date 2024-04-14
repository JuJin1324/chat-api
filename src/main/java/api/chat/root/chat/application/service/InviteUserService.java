package api.chat.root.chat.application.service;

import api.chat.root.chat.application.port.in.InviteUserUseCase;
import api.chat.root.chat.application.port.in.command.InviteUserCommand;
import api.chat.root.chat.application.port.out.LoadChatRoomPort;
import api.chat.root.chat.application.port.out.PersistChatRoomPort;
import api.chat.root.chat.application.port.out.RetrieveUserQuery;
import lombok.RequiredArgsConstructor;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 4/14/24
 */

@RequiredArgsConstructor
public class InviteUserService implements InviteUserUseCase {
	private final LoadChatRoomPort loadChatRoomPort;
	private final RetrieveUserQuery retrieveUserQuery;
	private final PersistChatRoomPort persistChatRoomPort;

	@Override
	public void inviteUser(InviteUserCommand command) {
		var chatRoom = loadChatRoomPort.load(command.chatRoomId());
		var user = retrieveUserQuery.retrieve(command.userId());

		chatRoom.invite(user, command.actor());
		persistChatRoomPort.persist(chatRoom);
	}
}
