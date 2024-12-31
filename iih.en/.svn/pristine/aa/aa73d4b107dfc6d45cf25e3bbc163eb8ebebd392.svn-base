package iih.en.pv.s.bp.op.st;

import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.OpEP;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.d.OutpatientDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 退费
 * @author yank
 *
 */
public class RefundByEntBP {
	/**
	 * 退费
	 * @param entId 就诊ID
	 * @param sd_pttp 收付款终端类型编码
	 * @throws BizException
	 * @author yank
	 */
	public void exec(String entId, String sd_pttp, FBoolean fgRealpay) throws BizException{
		if(EnValidator.isEmpty(sd_pttp))
			throw new BizException("退费时收付款终端类型编码为空！");
		OpEP opEP = new OpEP();
		OutpatientDO opDO = opEP.getOpByEntIdWithOutRef(entId);
		if(opDO==null){
			throw new BizException(IEnMsgConst.ERROR_OP_OPINFO_NOT_EXISTS);
		}
		
		RefundBP refundBP = new RefundBP();
		refundBP.exec(entId, opDO.getId_cg(), FBoolean.FALSE, sd_pttp, fgRealpay);		
	}
}
