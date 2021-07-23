package org.team.domain.help;

import java.util.Date;

import lombok.Data;

@Data
public class HelpVO {
	
	private long hno;
	private String htitle;
	private String hcontent;
	private String hwriter;
	private Date hregdate;
	
	private int replyCnt;
	
	private String fileName;
	
	
}
