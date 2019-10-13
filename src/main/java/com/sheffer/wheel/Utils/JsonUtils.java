package com.sheffer.wheel.Utils;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

public class JsonUtils {

	private final static Logger logger = LoggerFactory.getLogger(JsonUtils.class);

	public static JSONObject getJsonObject(List<String> keyList, List<String> valueList) {
		JSONObject jsonObject = new JSONObject();
		if (keyList.size() != valueList.size()) {
			logger.error("input keyList size is not equals to valueList size");
			return null;
		}
		for (int i = 0; i < keyList.size(); i++) {
			jsonObject.put(keyList.get(i), valueList.get(i));
		}
		return jsonObject;
	}
}
