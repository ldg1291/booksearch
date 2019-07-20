package com.donggyo.demo.enums;

import lombok.Getter;

@Getter
public enum SortType {
	ACCURACY("accuracy"),
	LATEST("latest");

	private String desc;

	SortType(String desc) {
		this.desc = desc;
	}

	public static String findByName(String name) {
		return SortType.valueOf(name).desc;
	}
}
