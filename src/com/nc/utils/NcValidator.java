package com.nc.utils;

import org.apache.commons.lang3.ObjectUtils;

public class NcValidator {
	/**
	 * 所有对象均不得为空，否则不通过
	 * @param obj
	 */
	public static void AllNotNull(Object... obj) {
		if(!ObjectUtils.allNotNull(obj)) {
			throw new RuntimeException("不得有空值");
		}
	}
	
	/**
	 * 只要有一个有值就通过，全为null才不通过
	 * @param obj
	 */
	public static void AnyNotNull(Object... obj) {
		if(ObjectUtils.anyNotNull(obj)) {
			throw new RuntimeException("必须有一个值");
		}
	}
}
