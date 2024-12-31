package iih.en.pv.s.bp.op;

import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.OpEP;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.s.bp.op.st.LoadResPriceFromCgBP;
import iih.sc.sch.reg.dto.d.RegResDTO;
import xap.mw.core.data.BizException;

/**
 * 加载资源价格信息--为预约
 * @author yank
 *
 */
public class LoadResPri4AptBP {
	/**
	 * 加载资源价格信息--为预约
	 * @param entId 就诊id
	 * @param resDTO 挂号资源
	 * @return
	 * @throws BizException
	 */
	public RegResDTO exec(String entId,RegResDTO resDTO) throws BizException{
		OutpatientDO opDO = new OpEP().getOpByEntId(entId);
		if(opDO==null){
			throw new BizException(IEnMsgConst.ERROR_OP_OPINFO_NOT_EXISTS);
		}		
		
		//已支付，从费用加载
		LoadResPriceFromCgBP loadPriBP = new LoadResPriceFromCgBP();
		resDTO = loadPriBP.exec(resDTO, opDO.getId_cg());
		return resDTO;
	}
}
