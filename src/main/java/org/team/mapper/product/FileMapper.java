package org.team.mapper.product;

import org.team.domain.product.CoverVO;
import org.team.domain.product.FileVO;

public interface FileMapper {

	public int insertCover(CoverVO vo);

	public int insertFile(FileVO vo);

}
