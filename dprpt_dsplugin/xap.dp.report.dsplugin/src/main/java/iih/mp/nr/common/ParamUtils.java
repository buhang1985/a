package iih.mp.nr.common;

import iih.mp.nr.dto.wardprint.d.ParamQryDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;


/**
 * 查询参数信息
 */

public class ParamUtils<T> {

	private T t;
	
	public ParamUtils(){
		
	}
	
	@SuppressWarnings("unchecked")
	public T paramValue(String id_org, String paramcode) throws BizException{
		if(StringUtil.isEmptyWithTrim(id_org))
			return null;
		if(StringUtil.isEmptyWithTrim(paramcode))
			return null;
		ParamQryDTO[] array = ParamQueryUtils.paramsqry(id_org, paramcode);
		if(null==array||array.length<1)
			return null;
		t = (T) array[0].getParam_value();
		return t;
	}
}
