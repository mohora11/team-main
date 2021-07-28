package org.team.domain.help;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data //bean
public class HBoardVO {
	 
	private long hno;
	private String title;
	private String content;
	private String writer;
	private String writerName;
	private Date regdate;
	private Date updateDate; 
	
	private int replyCnt;
	
	private String fileName;
//	private MultipartFile file;
}
