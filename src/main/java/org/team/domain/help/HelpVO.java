package org.team.domain.help;

import lombok.Data;

@Data
public class HelpVO {
	
	private long hno;
	private String htitle;
	private String hcontent;
	private String hwriter;
	private String hregdate;
	
	private int replyCnt;
	
	private String fileName;
	
	
}
