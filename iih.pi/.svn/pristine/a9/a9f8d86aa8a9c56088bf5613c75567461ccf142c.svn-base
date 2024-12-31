package iih.pi.reg.s.bp.util;

import iih.bd.utils.UdidocUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.xbd.udi.d.UdidocDO;

public class GetUdidocDOUtil {

	/**
	 * 获取自定义档案
	 * @param type
	 * @param code
	 * @return
	 */
	public static UdidocDO getDoc(String type,String code){
		if(StringUtil.isEmpty(code))
			return null;
		
		UdidocDO doc = null;
		try {
			 doc = UdidocUtils.getUdidocByCode(type,code);
		} catch (BizException e) {
		}
		
		return doc;
	}
	
	/**
	 * 根据类型编码和IE编码获取档案信息
	 * @param type
	 * @param ieCode
	 * @return
	 */
	public static UdidocDO getDocByIE(String type,String ieCode){
		
		if(StringUtil.isEmpty(ieCode))
			return null;
		
		UdidocDO doc = null;
		try {
			 doc = UdidocUtils.getUdidocByIECode(type,ieCode);
		} catch (BizException e) {
		}
		
		return doc;
	}
}
