package org.team.domain.product;

import java.util.Date;

import lombok.Data;

@Data
public class ProductReplyVO {

	private Long id;
	private Long product_id;
	private String replyer;
	private String reply;
	private Date reply_date;
	private Date update_date;
	
	private String replyer_name;
}
