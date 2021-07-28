package org.team.mapper.help;

import org.apache.ibatis.annotations.Select;

public interface HTimeMapper {
	
	@Select("SELECT now()")
	public String getTime();
	
	public String getTime2();
}
