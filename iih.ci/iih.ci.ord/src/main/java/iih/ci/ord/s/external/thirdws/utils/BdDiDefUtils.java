package iih.ci.ord.s.external.thirdws.utils;

import iih.bd.srv.diagdef.d.DiagDefDO;
import iih.bd.srv.diagdef.i.IDiagdefMDORService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 诊断工具类
 * @author zhangwq
 *
 */
public class BdDiDefUtils {
	/**
	 * 查询诊断信息
	 * @param dicode
	 * @return
	 * @throws BizException
	 */
	public static DiagDefDO getDiagDefDOByCode(String dicode) throws BizException{
		IDiagdefMDORService service = ServiceFinder.find(IDiagdefMDORService.class);
		DiagDefDO[] diags = service.findByAttrValString(DiagDefDO.CODE, dicode);
		if(diags!=null && diags.length>0){
			return diags[0];
		}
		return null;
	}
}
