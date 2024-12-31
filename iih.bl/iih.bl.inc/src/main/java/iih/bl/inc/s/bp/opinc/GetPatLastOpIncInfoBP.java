package iih.bl.inc.s.bp.opinc;

import iih.bd.base.exception.ArgumentNullException;
import iih.bl.inc.dto.d.RePrintInvoiceInfoDTO;
import iih.bl.inc.s.bp.opinc.qry.PatLastOpIncQry;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 获取患者上次门诊发票信息
 * @author ly 2018/04/04
 *
 */
public class GetPatLastOpIncInfoBP {

	/**
	 * 获取患者上次门诊发票信息
	 * @param patId 患者id
	 * @return
	 * @throws BizException
	 */
	public RePrintInvoiceInfoDTO[] exec(String patId) throws BizException {
		
		if(StringUtil.isEmpty(patId)){
			throw new ArgumentNullException("获取患者上次门诊发票信息", "患者id");
		}
		
		//查询患者上次门诊发票信息
		RePrintInvoiceInfoDTO[] dtos = (RePrintInvoiceInfoDTO[]) AppFwUtil
				.getDORstWithDao(new PatLastOpIncQry(patId), RePrintInvoiceInfoDTO.class);
		
		if(ArrayUtil.isEmpty(dtos))
			return null;
		
		return dtos;
	}
}
