package org.team.domain.help;

import java.util.Date;

import lombok.Data;

@Data
public class HReplyVO {
	private Long hrno;
	private Long hno;
	
	private String reply;
	private String replyer;
	private Date replyDate;
	private Date updateDate;
	
	private String replyerName;
	 
}
