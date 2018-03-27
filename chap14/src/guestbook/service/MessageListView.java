package guestbook.service;

import java.util.List;

import guestbook.model.Message;

public class MessageListView {
	private int messageTotalcount; 
	private int currentPageNumber; 
	private List<Message> messageList;
	private int pageTotalCount;
	private int messageCountPerPage;
	private int firstRow;
	private int endRow;
	public MessageListView(List<Message> messageList, int messageTotalcount, int currentPageNumber,  
			int messageCountPerPage, int firstRow, int endRow) {
		super();
		this.messageTotalcount = messageTotalcount;
		this.currentPageNumber = currentPageNumber;
		this.messageList = messageList;
		this.pageTotalCount = pageTotalCount;
		this.messageCountPerPage = messageCountPerPage;
		this.firstRow = firstRow;
		this.endRow = endRow;
		
		calculatePageTotalCount();
	}

	private void calculatePageTotalCount() {
		if(messageTotalcount==0) {
			pageTotalCount=0;
		}else {
			pageTotalCount = messageTotalcount/messageCountPerPage;
			if(messageTotalcount%messageCountPerPage > 0) {
				pageTotalCount++;
			}
		}
	}

	public int getMessageTotalcount() {
		return messageTotalcount;
	}

	public int getCurrentPageNumber() {
		return currentPageNumber;
	}

	public List<Message> getMessageList() {
		return messageList;
	}

	public int getPageTotalCount() {
		return pageTotalCount;
	}

	public int getMessageCountPerPage() {
		return messageCountPerPage;
	}

	public int getFirstRow() {
		return firstRow;
	}

	public int getEndRow() {
		return endRow;
	}
	
	public boolean isEmpty() {
		return messageTotalcount==0;
	}
	
}
