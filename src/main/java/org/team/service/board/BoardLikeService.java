package org.team.service.board;

import org.team.domain.board.BoardLikeVO;

public interface BoardLikeService {

	public int like(BoardLikeVO vo);
	public void plusCnt(BoardLikeVO vo);
	public int cancelLike(BoardLikeVO vo);
	public void minusCnt(BoardLikeVO vo);

	public int dislike(BoardLikeVO vo);
	public void displusCnt(BoardLikeVO vo);
	public int cancelDislike(BoardLikeVO vo);
	public void disminusCnt(BoardLikeVO vo);
	
	public BoardLikeVO get(String bno, String userid);
	public BoardLikeVO getDislike(String bno, String userid);

}
