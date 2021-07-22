package org.team.mapper.help;

import org.apache.ibatis.annotations.Select;

public interface HelpTimeMapper {

	@Select("SELECT now()")
	public String getTime();
	public String getTime2();
}
