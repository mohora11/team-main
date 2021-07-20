package org.team.service.product;

import java.util.List;

import org.team.domain.product.ProductReplyVO;

public interface ProductReplyService {

	public List<ProductReplyVO> getList(Long product_id);

	public int register(ProductReplyVO vo);

	public ProductReplyVO get(Long id);

	public int modify(ProductReplyVO vo);

	public int remove(Long id);

}
