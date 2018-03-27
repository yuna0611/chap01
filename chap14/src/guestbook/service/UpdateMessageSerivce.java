package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;

import guestbook.dao.MessageDao;
import guestbook.model.Message;
import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;

public class UpdateMessageSerivce {
	private static UpdateMessageSerivce instance = new UpdateMessageSerivce();

	public static UpdateMessageSerivce getInstance() {
		return instance;
	}
	
	private UpdateMessageSerivce() {}

	public Message updateMessage(int messageId) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			MessageDao messageDao = MessageDao.getInstance();
			return messageDao.select(conn, messageId);
		} catch (SQLException ex) {
			throw new ServiceException("메시지 블러오기 실패 : "+ex.getMessage(),ex);
		}finally {
			JdbcUtil.close(conn);
		}
	}

	
	public void updateMessage(Message message) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			MessageDao messageDao = MessageDao.getInstance();
			
			Message messageDB = messageDao.select(conn, message.getId());
			if(messageDB==null) {
				throw new MessageNotFoundException("메시지 없음");
			}
			if(!message.matchPassword(message.getPassword())) {
				throw new InvalidPasswordException("bad password");
			}
			messageDao.update(conn,message);
		} catch (SQLException ex) {
			throw new ServiceException("메시지 수정 실패 : "+ex.getMessage(),ex);
		}finally {
			JdbcUtil.close(conn);
		}
	}
}
