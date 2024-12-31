package iih.ci.ord.s.external.thirdws.utils;

import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.measdoc.d.MeasDocDO;
import xap.sys.xbd.measdoc.i.IMeasdocRService;
/**
 * 计量单位查询工具类
 * @author zhangwq
 *
 */
public class BdMeasdocUtils {
	/**
	 * 通过编码查询计量单位
	 * @param code
	 * @return
	 * @throws BizException
	 */
	public static MeasDocDO getMeasDocDOByCode(String code) throws BizException{
		IMeasdocRService service = ServiceFinder.find(IMeasdocRService.class);
		MeasDocDO[] measdocs = service.findByAttrValString(MeasDocDO.CODE, code);
		if(measdocs!=null && measdocs.length>0){
			return measdocs[0];
		}
		return null;
	}
}
