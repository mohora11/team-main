package org.team.domain.help;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HelpCriteria {

	private int pageNum;
	private int amount;

	private String type;
	private String keyword;

	public HelpCriteria() {
		this(1, 10);
	}

	public HelpCriteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}

	public int getFrom() {
		return amount * (pageNum - 1);
	}

	public String[] getTypeArr() {
		if (type == null) {
			return new String[] {};
		} else {
			String[] types = type.split("");
			return types;
		}
	}
}
