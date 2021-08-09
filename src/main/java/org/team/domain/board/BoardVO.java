package org.team.domain.board;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data //bean
public class BoardVO {
	 
	private long bno;
	private String title;
	private String content;
	private String writer;
	private String writerName;
	private Date regdate;
	private Date updateDate; 
	
	private int replyCnt;
	
	private String fileName;
//	private MultipartFile file;
	
	private int like_cnt;
	private int dislike_cnt;
}
