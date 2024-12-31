package iih.mi.inst.bizbase.bp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FType;

/**
 * 反序列化业务逻辑
 * 
 * @author hao_wu
 *
 * @param <T>
 */
public class DeserializeBp<T extends BaseDO> {

	/**
	 * 分隔符
	 */
	private String _regex = "\t";

	private String[] _propNames;

	public DeserializeBp() {
	}

	public DeserializeBp(String regex) {
		this();
		this._regex = regex;
	}

	public DeserializeBp(String regex, String[] propNames) {
		this(regex);
		this._propNames = propNames;
	}

	public DeserializeBp(String[] propNames) {
		this();
		this._propNames = propNames;
	}

	public T exec(String str, Class<T> clazz) throws BizException {
		T newData = Deserialize(str, clazz);
		return newData;
	}

	private T Deserialize(String str, Class<T> clazz) throws BizException {
		T newData = this.Deserialize(str, clazz, this._propNames);
		return newData;
	}

	@SuppressWarnings({ "unchecked", "unused" })
	private T[] exec(InputStream fileStream, Class<T> clazz, String[] propNames) throws BizException {
		ArrayList<T> dataList = new ArrayList<T>();

		BufferedReader reader = new BufferedReader(new InputStreamReader(fileStream));
		try {
			String lineStr = reader.readLine();
			while (StringUtils.isNotEmpty(lineStr)) {
				T newData = Deserialize(lineStr, clazz, propNames);
				if (newData != null) {
					dataList.add(newData);
				}
				lineStr = reader.readLine();
			}

		} catch (IOException e) {
			throw new BizException(e);
		}

		return (T[]) dataList.toArray();
	}

	/**
	 * 反序列化行数据到数据模型
	 * 
	 * @param lineStr
	 * @param clazz
	 * @param propNames
	 * @return
	 * @throws BizException
	 */
	private T Deserialize(String lineStr, Class<T> clazz, String[] propNames) throws BizException {
		T newData = CreateNewData(clazz);
		String[] values = lineStr.split(_regex);
		for (int i = 0; i < values.length && i < propNames.length; i++) {
			FType javaType = newData.getDODesc().getAttrDesc(propNames[i]).getJavaType();
			String val = ConvertAttrVal(values[i], javaType);
			newData.setAttrVal(propNames[i], val);
		}
		return newData;
	}

	/**
	 * 根据属性类型转换属性值
	 * 
	 * @param value
	 * @param attrType
	 * @return
	 */
	private String ConvertAttrVal(String value, FType attrType) {
		if (FType.FDateTime.equals(attrType) && value.length() == 14) {
			String newValue = String.format("%s/%s/%s %s:%s:%s", value.substring(0, 4), value.substring(4, 6),
					value.substring(6, 8), value.substring(8, 10), value.substring(10, 12), value.substring(12, 14));
			return newValue;
		} else if (FType.FDateTime.equals(attrType) && StringUtils.isBlank(value)) {
			return null;
		}
		return value;
	}

	/**
	 * 创建新数据
	 * 
	 * @param clazz
	 * @return
	 * @throws BizException
	 */
	private T CreateNewData(Class<T> clazz) throws BizException {
		try {
			T newData = clazz.newInstance();
			return newData;
		} catch (InstantiationException | IllegalAccessException e) {
			throw new BizException(e);
		}
	}

}
