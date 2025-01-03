package iih.bl.inc.s.bp.inc;

import iih.bl.inc.s.bp.inc.base.NextInvoiceNoBaseBP;
import xap.mw.core.data.BizException;

/**
 * 票据包过号
 * @author ly 2015/05/23
 *
 */
public class NextInvoiceNoOldBP extends NextInvoiceNoBaseBP{

	/**
	 * 票据包过号
	 * @param empId 人员id
	 * @param inccaId 票据分类id
	 * @param hostId PCid
	 * @throws BizException
	 * @return 过号前的当前号
	 */
	public String exec(String empId, String hostId, String inccaId) throws BizException{
		super.newInvioce(empId, hostId, inccaId);
		return super.oldIncnoCur;
	}
}
