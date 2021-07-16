package org.team.mapper.product;

import java.util.List;

import org.team.domain.product.ProductVO;

public interface WebnovelMapper {

	public List<ProductVO> getList();

	public ProductVO get(Long id);
}
