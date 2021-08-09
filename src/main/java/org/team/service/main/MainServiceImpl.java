package org.team.service.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.team.domain.product.ProductCriteria;
import org.team.domain.product.ProductVO;
import org.team.mapper.main.MainMapper;

import lombok.Setter;

@Service
public class MainServiceImpl implements MainService {

	@Setter(onMethod_ = @Autowired)
	private MainMapper mapper;
	
	@Override
	public List<ProductVO> getList() {
		return mapper.getList();
	}
	
	@Override
	public List<ProductVO> getSearchList(ProductCriteria cri) {
		return mapper.getSearchList(cri);
	}

	@Override
	public List<ProductVO> getRank() {
		return mapper.getRank();
	}
	
	@Override
	public void insertKeyword(ProductCriteria cri) {
		mapper.insertKeyword(cri);
	}
	
	@Override
	public List<ProductCriteria> getSearchRank() {
		return mapper.getSearchRank();
	}
	
	@Override
	public String getCnt() {
		return mapper.getCnt();
	}
	
	@Override
	public List<ProductVO> getToday() {
		return mapper.getToday();
	}
	
	@Override
	public String getTodayCnt() {
		return mapper.getTodayCnt();
	}

}
