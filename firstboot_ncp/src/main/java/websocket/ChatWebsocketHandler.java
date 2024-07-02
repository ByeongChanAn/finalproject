package websocket;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

@Component
public class ChatWebsocketHandler implements WebSocketHandler{

	List<WebSocketSession> list = new ArrayList();//웹소켓연결클라이언트 모음
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		//웹소켓연결시점 1번 실행
		//웹소켓연결클라이언트 list add
		list.add(session);
		System.out.println("추가후 클라이언트수 = " +  list.size() + " - " + session.getRemoteAddress() + " ip에서 접속중");
		
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
			String str_message = String.valueOf(message.getPayload());
			
			for(WebSocketSession socket : list) {
				WebSocketMessage<String> sendmsg = new TextMessage(str_message);
				socket.sendMessage(message);//클라이언트로 전송
			}
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		// 웹소켓해제시점 1번 실행
		list.remove(session);
		System.out.println("삭제후 클라이언트수 = " +  list.size() + " - " + session.getRemoteAddress() + " ip에서 접속해제");
	}
	
	
	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		//오류처리용도. 사용x
		
	}


	@Override
	public boolean supportsPartialMessages() {
		//부가정보생성용도. 사용x
		return false;
	}

}
