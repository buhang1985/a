package iih.ci.ord.s.bp.ems;

import java.io.UnsupportedEncodingException;

import iih.bd.srv.emsqry.d.EmsFunclassKVDTO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import xap.mw.core.base64.Base64;
import xap.mw.core.data.BizException;
import xap.mw.log.logging.Logger;
import xap.sie.common.utils.StringUtils;
/**
 * 医疗单驱动处理类
 * @author zhangwq
 *
 */
public class EmsFunclassKVBP {
	public String exec(CiOrderDO order) throws BizException{
		String funcclassstr = order.getFuncclassstr();
		if(StringUtils.isEmpty(funcclassstr)){
			return null;
		}
		try {
			String utf8Str = new String(Base64.decode(funcclassstr.getBytes("UTF-8")),"UTF-8");
			EmsFunclassKVDTO  emsFunclassKVDTO = parseJsonDriver(utf8Str);
			return emsFunclassKVDTO.getEmstype();
		} catch (BizException e) {
			Logger.error(e.getMessage());
			return null;
		} catch (UnsupportedEncodingException e) {
			Logger.error(e.getMessage());
			return null;
		} 
	}
	public EmsFunclassKVDTO parseJsonDriver(String utf8Str) throws BizException {
		EmsFunclassKVDTO funclassDTO = new EmsFunclassKVDTO();
		funclassDTO.deSerializeJson(utf8Str);
		return funclassDTO;	
	}
}
