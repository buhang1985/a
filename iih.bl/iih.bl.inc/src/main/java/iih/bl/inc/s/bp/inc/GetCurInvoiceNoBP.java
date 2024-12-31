package iih.bl.inc.s.bp.inc;

import iih.bl.inc.blinciss.d.BlIncIssDO;
import xap.mw.core.data.BizException;

/**
 * 获取当前票据号
 * @author ly 2018/05/19
 *
 */
public class GetCurInvoiceNoBP {

	/**
	 * 获取当前票据号
	 * @param empId 人员id
	 * @param hostId PCid
	 * @param inccaId 票据分类id
	 * @return
	 * @throws BizException
	 */
	public String exec(String empId, String hostId, String inccaId) throws BizException {
		
		GetCurInvoiceDOBP bp = new GetCurInvoiceDOBP();
		BlIncIssDO issDO = bp.exec(empId, hostId, inccaId);
		String incno = null;
		if(issDO != null){
			incno = issDO.getIncno_cur();
		}
		return incno;
	}
}
