package org.team.domain.product;

import lombok.Data;

@Data
public class ProductLikeVO {

	private Long id;
	private Long product_id;
	private String user_id;
	private int check_like;
	
}
