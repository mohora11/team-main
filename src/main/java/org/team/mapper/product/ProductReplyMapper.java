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

	public void deleteDetailByPid(Long id);

	public int insertDetail(ProductReplyVO vo);

	public List<ProductReplyVO> getListDetail(Long product_id);

	public ProductReplyVO readDetail(Long id);

	public int updateDetail(ProductReplyVO vo);

	public int deleteDetail(Long id);

}
