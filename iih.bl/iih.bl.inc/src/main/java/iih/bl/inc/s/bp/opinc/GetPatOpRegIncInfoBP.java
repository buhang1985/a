package iih.bl.inc.s.bp.opinc;

import iih.bd.base.exception.ArgumentNullException;
import iih.bl.inc.dto.d.RePrintInvoiceInfoDTO;
import iih.bl.inc.s.bp.opinc.qry.PatOpRegIncInfoQry;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 获取患者门诊挂号发票信息
 * @author ly 2018/04/04
 *
 */
public class GetPatOpRegIncInfoBP {

	/**
	 * 获取患者门诊挂号发票信息
	 * @param patId
	 * @param incno
	 * @return
	 * @throws BizException
	 */
	public RePrintInvoiceInfoDTO exec(String patId,String incno) throws BizException{
		
		if(StringUtil.isEmpty(patId)){
			throw new ArgumentNullException("获取患者门诊挂号发票信息", "患者id");
		}
		
		if(StringUtil.isEmpty(incno)){
			throw new ArgumentNullException("获取患者门诊挂号发票信息", "发票号");
		}
		
		//获取患者门诊挂号发票信息
		RePrintInvoiceInfoDTO[] dtos = (RePrintInvoiceInfoDTO[]) AppFwUtil
				.getDORstWithDao(new PatOpRegIncInfoQry(patId, incno), RePrintInvoiceInfoDTO.class);

		if (ArrayUtil.isEmpty(dtos))
			return null;

		return dtos[0];
	}
}
