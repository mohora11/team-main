package org.team.mapper.product;

import org.apache.ibatis.annotations.Param;
import org.team.domain.product.ProductPaidVO;
import org.team.domain.product.ProductVO;

public interface ProductPaidMapper {

	public ProductPaidVO getPaid(@Param("id") String id, @Param("userid") String userid);

	public int buy(ProductPaidVO vo);

	public ProductVO readPrice(ProductPaidVO vo);

}
