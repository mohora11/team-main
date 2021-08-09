package org.team.domain.board;

import lombok.Data;

@Data
public class BoardLikeVO {

	private Long id;
	private Long bno;
	private String writer;
	private int check_like;
	private int check_dislike;
}
