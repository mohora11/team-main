package org.team.mapper.product;

import org.apache.ibatis.annotations.Param;
import org.team.domain.product.ProductLikeVO;

public interface ProductLikeMapper {

	public int like(ProductLikeVO vo);

	public int dislike(ProductLikeVO vo);

	public void plusCnt(ProductLikeVO vo);

	public void minusCnt(ProductLikeVO vo);

	// xml에 각각 #{id}, #{userid}를 사용하기 위함
	public ProductLikeVO read(@Param("id") String id, @Param("userid") String userid);

}
