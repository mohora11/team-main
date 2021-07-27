package org.team.mapper.main;

import java.util.List;

import org.team.domain.product.ProductCriteria;
import org.team.domain.product.ProductVO;

public interface MainMapper {

	public List<ProductVO> getList();
	
	public List<ProductVO> getSearchList(ProductCriteria cri);

	public List<ProductVO> getRank();

}
