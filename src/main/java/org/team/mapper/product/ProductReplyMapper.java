package org.team.mapper.product;

import java.util.List;

import org.team.domain.product.ProductReplyVO;

public interface ProductReplyMapper {

	public int insert(ProductReplyVO vo);

	public List<ProductReplyVO> getList(Long product_id);

	public ProductReplyVO read(Long id);

	public int update(ProductReplyVO vo);

	public int delete(Long id);

	public void deleteByPid(Long id);

}
