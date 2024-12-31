package iih.en.pv.s.bp.op.st;

import iih.bl.inc.blincquerydto.d.BlIncItmVsTypeDTO;
import iih.en.comm.util.EnCollectionUtils;
import iih.en.pv.outpatient.dto.d.RegInfoDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;

/**
 * 重新结算（退费+结算）
 * @author yank
 *
 */
public class ResettleBP {
	/**
	 * 重新结算（退费+结算）
	 * @param regInfo
	 * @return
	 * @throws BizException
	 */
	public RegInfoDTO exec(RegInfoDTO regInfo) throws BizException{
		RefundBP refundBP = new RefundBP();
		BlIncItmVsTypeDTO[] incItms = refundBP.exec(regInfo.getId_ent(), regInfo.getId_cg(), FBoolean.TRUE, regInfo.getSd_pttp(), FBoolean.FALSE);
		FArrayList invoiceInfo = EnCollectionUtils.toFArrayList(incItms);
		regInfo.setInvoiceinfo(invoiceInfo);
		return regInfo;
	}
}
