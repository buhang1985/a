package iih.bd.utils;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import xap.dp.dmengine.d.PropertyDO;
import xap.dp.dmengine.s.MdCachePoolProxy;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FTypeManager;

public class JsonSerializeUtils {

	/**
	 * 序列化
	 * 
	 * @param obj 需序列化对象
	 * @return
	 */
	public static String serialize(Object obj) {
		try {
			String jsonStr = null;
			if (obj instanceof BaseDO) {
				jsonStr = serializeBaseDo((BaseDO) obj);
			} else {
				jsonStr = JSON.toJSONString(obj);
			}
			return jsonStr;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 反序列化
	 * 
	 * @param xml
	 * @param objClass
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T deSerialize(String jsonStr, Class<T> objClass) {
		try {
			T data = null;
			if (BaseDO.class.isAssignableFrom(objClass)) {
				data = (T) deSerializeBaseDo(jsonStr, (Class<BaseDO>) objClass);
			} else {
				data = JSON.parseObject(jsonStr, objClass);
			}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 序列化DO
	 * 
	 * @param baseDo
	 * @return
	 * @throws Exception
	 */
	public static String serializeBaseDo(BaseDO baseDo) throws Exception {
		JSONObject jsonObject = convertToJsonObject(baseDo);
		return jsonObject.toJSONString();
	}

	private static JSONObject convertToJsonObject(BaseDO dataObj) throws BizException {
		String fullClassName = dataObj.getClass().getName();
		PropertyDO[] propDos = MdCachePoolProxy.getInstance().getPropertyDOsByEntityName(fullClassName);

		JSONObject jsonObject = new JSONObject();
		for (PropertyDO propDo : propDos) {
			if (FBoolean.TRUE.equals(propDo.getIsnotserialize())) {
				continue;
			}
			String propName = propDo.getName();
			String attrName = String.format("%s%s", propName.substring(0, 1).toUpperCase(),
					propName.substring(1, propName.length()));
			Object attrVal = dataObj.getAttrVal(attrName);
			if (attrVal == null) {
				continue;
			}
			if (attrVal instanceof BaseDO) {
				JSONObject subJsonObj = convertToJsonObject((BaseDO) attrVal);
				jsonObject.put(attrName, subJsonObj);
			} else if (attrVal instanceof FArrayList) {
				JSONArray jsonArray = convertToJsonArray((FArrayList) attrVal);
				jsonObject.put(attrName, jsonArray);
			} else {
				jsonObject.put(attrName, attrVal.toString());
			}
		}
		return jsonObject;
	}

	private static JSONArray convertToJsonArray(FArrayList dataList) throws BizException {
		JSONArray jsonArray = new JSONArray();
		if (dataList.isEmpty()) {
			return jsonArray;
		}

		for (Object object : dataList) {
			JSONObject jsonObject = convertToJsonObject((BaseDO) object);
			jsonArray.add(jsonObject);
		}
		return jsonArray;
	}

	/**
	 * 反序列化DO
	 * 
	 * @param jsonStr
	 * @param objClass
	 * @return
	 * @throws Exception
	 */
	public static <T extends BaseDO> T deSerializeBaseDo(String jsonStr, Class<T> objClass) throws Exception {
		JSONObject jsonObject = JSONObject.parseObject(jsonStr);
		T data = deSerializeBaseDo(jsonObject, objClass);
		return data;
	}

	@SuppressWarnings("unchecked")
	private static <T extends BaseDO> T deSerializeBaseDo(JSONObject jsonObject, Class<T> objClass) throws Exception {
		T data = objClass.newInstance();
		if (jsonObject.isEmpty()) {
			return data;
		}

		for (String key : jsonObject.keySet()) {
			String attrName = key;
			String propName = attrName.toLowerCase();

			Object valueObj = jsonObject.get(key);
			String subFullClassName = MdCachePoolProxy.getInstance()
					.getSubFullClassNameByEntityProperty(objClass.getName(), propName);
			Class<? extends BaseDO> attrValClass = (Class<? extends BaseDO>) Class.forName(subFullClassName);
			if (valueObj instanceof JSONObject) {
				Object subData = deSerializeBaseDo((JSONObject) valueObj, attrValClass);
				data.setAttrVal(attrName, subData);
			} else if (valueObj instanceof JSONArray) {
				JSONArray jsonArray = (JSONArray) valueObj;
				FArrayList list = deSerializeBaseDoList(jsonArray, attrValClass);
				data.setAttrVal(attrName, list);
			} else {
				String attrVal = (String) valueObj;

				if (StringUtils.isBlank(attrVal)) {
					data.setAttrVal(attrName, null);
					continue;
				}

				if (attrValClass == null) {
					continue;
				}
				Object attValObj = FTypeManager.convert2FType2(attrValClass, attrVal);
				data.setAttrVal(attrName, attValObj);
			}
		}
		return data;
	}

	@SuppressWarnings("unchecked")
	private static <T extends BaseDO> FArrayList deSerializeBaseDoList(JSONArray jsonArray, Class<T> objClass)
			throws Exception {
		FArrayList list = new FArrayList();
		if (jsonArray.isEmpty()) {
			return list;
		}
		for (Object object : jsonArray) {
			T data = deSerializeBaseDo((JSONObject) object, objClass);
			list.add(data);
		}
		return list;
	}
}
