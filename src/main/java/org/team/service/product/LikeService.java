package org.team.service.product;

import org.team.domain.product.ProductLikeVO;

public interface LikeService {

	public int like(ProductLikeVO vo);

	public int dislike(ProductLikeVO vo);

}
