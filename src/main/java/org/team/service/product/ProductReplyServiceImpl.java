package org.team.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.team.domain.product.ProductReplyVO;
import org.team.mapper.product.ProductReplyMapper;

import lombok.Setter;

@Service
public class ProductReplyServiceImpl implements ProductReplyService {

	@Setter(onMethod_ = @Autowired)
	private ProductReplyMapper mapper;
	
	@Override
	public List<ProductReplyVO> getList(Long product_id) {
		return mapper.getList(product_id);
	}
	
	@Override
	public int register(ProductReplyVO vo) {
		return mapper.insert(vo);
	}

	@Override
	public ProductReplyVO get(Long id) {
		return mapper.read(id);
	}

	@Override
	public int modify(ProductReplyVO vo) {
		return mapper.update(vo);
	}

	@Override
	public int remove(Long id) {
		return mapper.delete(id);
	}

}
