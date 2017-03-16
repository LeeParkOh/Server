package first.noticeboard.politics.NB_PoliticsMgt.service.vo;

import java.io.Serializable;

public class PoliticsBoardInfoVO  implements Serializable{

	private static final long serialVersionUID = 2365756071727584570L;
	private int headSeq;
	private String userId;
	private String boardId;
	private String boardTitle;
	private String boardBodyFg;
	private String regDt;
	private String lstChgDt;
	private String boardActiveFg;
	
	private int bodySeq;
	private String boardBody1;
	private String boardBody2;
	
	private int detailSeq;
	private int boardSearchCnt;
	private int boardBestCnt;
	
	public int getHeadSeq() {
		return headSeq;
	}
	public void setHeadSeq(int headSeq) {
		this.headSeq = headSeq;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getBoardId() {
		return boardId;
	}
	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardBodyFg() {
		return boardBodyFg;
	}
	public void setBoardBodyFg(String boardBodyFg) {
		this.boardBodyFg = boardBodyFg;
	}
	public String getRegDt() {
		return regDt;
	}
	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}
	public String getLstChgDt() {
		return lstChgDt;
	}
	public void setLstChgDt(String lstChgDt) {
		this.lstChgDt = lstChgDt;
	}
	public String getBoardActiveFg() {
		return boardActiveFg;
	}
	public void setBoardActiveFg(String boardActiveFg) {
		this.boardActiveFg = boardActiveFg;
	}
	public int getBodySeq() {
		return bodySeq;
	}
	public void setBodySeq(int bodySeq) {
		this.bodySeq = bodySeq;
	}
	public String getBoardBody1() {
		return boardBody1;
	}
	public void setBoardBody1(String boardBody1) {
		this.boardBody1 = boardBody1;
	}
	public String getBoardBody2() {
		return boardBody2;
	}
	public void setBoardBody2(String boardBody2) {
		this.boardBody2 = boardBody2;
	}
	public int getDetailSeq() {
		return detailSeq;
	}
	public void setDetailSeq(int detailSeq) {
		this.detailSeq = detailSeq;
	}
	public int getBoardSearchCnt() {
		return boardSearchCnt;
	}
	public void setBoardSearchCnt(int boardSearchCnt) {
		this.boardSearchCnt = boardSearchCnt;
	}
	public int getBoardBestCnt() {
		return boardBestCnt;
	}
	public void setBoardBestCnt(int boardBestCnt) {
		this.boardBestCnt = boardBestCnt;
	}
	public String getUserOs() {
		return userOs;
	}
	public void setUserOs(String userOs) {
		this.userOs = userOs;
	}
	public String getUserHw() {
		return userHw;
	}
	public void setUserHw(String userHw) {
		this.userHw = userHw;
	}
	public String getDropDt() {
		return dropDt;
	}
	public void setDropDt(String dropDt) {
		this.dropDt = dropDt;
	}
	public String getUserActiveFg() {
		return userActiveFg;
	}
	public void setUserActiveFg(String userActiveFg) {
		this.userActiveFg = userActiveFg;
	}
	private String userOs;
	private String userHw;
	private String dropDt;
	private String userActiveFg;
}
