/*
 * Copyright © 2014 YAOCHEN Corporation, All Rights Reserved
 */
package com.ys.spring.cloud.alibaba.agateway.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.commons.lang3.SerializationException;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Killer
 */
public final class JsonUtil {

	final static SerializerFeature[] STANDARD_FEATURES = new SerializerFeature[] {
		SerializerFeature.DisableCircularReferenceDetect
	};
	
	private static final FastJsonUtil FJU = new FastJsonUtil();
	
	/**
	 * TODO 目前因为fastjson丢复杂的json时，使用了"$ref"无法正常解析，因此这里禁用了这个优化
	 * 如果fastjson修复了，则应该立即启用
	 * 
	 * @param object
	 * @return
	 */
	public static String seriazileAsString(Object object) {
		return FJU.seriazileAsString(object, STANDARD_FEATURES);
	}
	
	/**
	 * 标准的序列化接口
	 */
	public static String seriazileAsStringWithStandard(Object object) {
		return FJU.seriazileAsString(object, STANDARD_FEATURES);
	}
	
	public static <T> T deserializeAsObject(String jsonString, Type clazz) {
		return FJU.deserializeAsObject(jsonString, clazz);
	}
	
	/**
	 * 将一个对象，转换成对象
	 * @param obj 只能是Object或者Map，不能是数组类型
	 * @return
	 */
	public static Map<String, Object> toJsonMap(Object obj){
		if(obj == null)
			return null;
		String objString = JSON.toJSONString(obj);
		return JSON.parseObject(objString, getType());
	}
	
	public static Map<String, Object> toJsonMap(String s){
		if(s == null)
			return null;
		return JSON.parseObject(s, getType());
	}
	
	private static Type getType(){
		return new TypeReference<Map<String, Object>>(){}.getType();
	}
	
   
	
	/**
	 * 扩展fastjson序列化
	 */
	private static class FastJsonUtil{
		
		/**
		 * java-object as json-string
		 * 
		 * @param object
		 * @return
		 */
		public String seriazileAsString(Object object, SerializerFeature... features) {
			if (object == null) {
				return "";
			}
			try {
				return JSON.toJSONString(object, features);
			} catch (Exception ex) {
				throw new SerializationException("Could not write JSON: "
						+ ex.getMessage(), ex);
			}
		}

		/**
		 * json-string to java-object
		 * 
		 * @param jsonString
		 * @return
		 */
		public <T> T deserializeAsObject(String jsonString, Type clazz) {
			if (jsonString == null || clazz == null) {
				return null;
			}
			try {
				return JSON.parseObject(jsonString, clazz);
			} catch (Exception ex) {
				throw new SerializationException("Could not write JSON: "
						+ ex.getMessage(), ex);
			}
		}
	}
	
	public static <T> List<T> deserializeAsList(String jsonString,Class<T> clazz){
		if (jsonString == null || clazz == null) {
			return null;
		}
		try {
			return JSON.parseArray(jsonString, clazz);
		} catch (Exception ex) {
			throw new SerializationException("Could not write JSON: "
					+ ex.getMessage(), ex);
		}
	}
}
