package iih.ci.ord.s.ems.base;

import iih.bd.base.utils.StringCodingUtils;
import iih.bd.srv.emsqry.d.EmsFunclassKVDTO;
import iih.ci.ord.i.common.EmsDriverInfo;
import xap.mw.core.data.BizException;

/**
 * 
 * @author wangqingzhu
 *
 */
public class BaseEmsDriverDecode {

	/**
	 * 驱动信息转化为对象
	 * @param jsonDriver
	 * @return
	 * @throws BizException
	 */
	public EmsDriverInfo parseJsonDriver(String jsonDriver) 
			throws BizException {
		EmsFunclassKVDTO funclassDTO =  new EmsFunclassKVDTO();
		if(!jsonDriver.startsWith("{")){
			String utf8Str = StringCodingUtils.Utf8_Base64_Decode(jsonDriver);
			funclassDTO.deSerializeJson(utf8Str);
		}
		else{
			funclassDTO.deSerializeJson(jsonDriver);
		}
		
		
		
		EmsDriverInfo driverInfo = new EmsDriverInfo(funclassDTO);
		driverInfo.setJsonDriver(jsonDriver);
		return driverInfo;
    }
}
