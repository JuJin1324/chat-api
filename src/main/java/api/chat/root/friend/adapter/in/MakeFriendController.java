package api.chat.root.friend.adapter.in;

import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import api.chat.root.friend.application.port.in.MakeFriendUseCase;
import api.chat.root.friend.application.port.in.command.MakeFriendCommand;
import lombok.RequiredArgsConstructor;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 4/14/24
 */

@RestController
@RequiredArgsConstructor
public class MakeFriendController {
	private final MakeFriendUseCase makeFriendUseCase;

	@PostMapping("/friends")
	public void makeFriend(UUID actor, MakeFriendRequest request) {
		makeFriendUseCase.makeFriend(commandOf(actor, request));
	}

	private MakeFriendCommand commandOf(UUID actor, MakeFriendRequest request) {
		return new MakeFriendCommand(actor, request.userId());
	}

	private record MakeFriendRequest(
		UUID userId
	) {
	}
}
