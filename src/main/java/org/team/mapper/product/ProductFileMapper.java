package org.team.mapper.product;

import org.team.domain.product.CoverVO;
import org.team.domain.product.ProductFileVO;

public interface ProductFileMapper {

	public int insertCover(CoverVO vo);

	public int insertFile(ProductFileVO vo);

}
