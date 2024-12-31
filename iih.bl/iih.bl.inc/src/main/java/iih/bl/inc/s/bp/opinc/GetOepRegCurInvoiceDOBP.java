package iih.bl.inc.s.bp.opinc;

import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bl.inc.blinciss.d.BlIncIssDO;
import iih.bl.inc.s.bp.inc.GetCurInvoiceDOBP;
import iih.bl.params.BlParams;
import xap.mw.core.data.BizException;

/**
 * 获取门诊挂号当前票信息
 * @author ly 2019/11/01
 *
 */
public class GetOepRegCurInvoiceDOBP {

	/**
	 * 获取门诊挂号当前票信息
	 * @param empId
	 * @param hostId
	 * @return
	 * @throws BizException
	 * @author ly 2019/11/01
	 */
	public BlIncIssDO exec(String empId, String hostId) throws BizException{
	
		String regIncvoiceTp = BlParams.BLINC0026();
		GetCurInvoiceDOBP bp = new GetCurInvoiceDOBP();
		return bp.exec(empId, hostId, IBdPpCodeTypeConst.SD_OUTPATIENT_INVOICE.equals(regIncvoiceTp) ? 
				IBdPpCodeTypeConst.ID_OUTPATIENT_INVOICE : IBdPpCodeTypeConst.ID_OUTREGISTER_INVIOCE);
	}
}
