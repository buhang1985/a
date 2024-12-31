package iih.bl.st.s.bp.oepcharge.base;

import xap.mw.core.data.BizException;
import iih.bl.st.dto.bloepcharge.d.BlOepChargeInputDTO;

/**
 * 门诊调入公用处理类
 * @author ly 2018/12/25
 *
 */
public class GetOepCostInfoBaseBP {

	
	/**
	 * 获取医嘱未交费数据
	 * @param orsrvIds
	 * @return
	 * @throws BizException
	 */
	protected BlOepChargeInputDTO[] getOrUnchargeInfo(String[] orsrvIds) throws BizException{
		
		return null;
	}
	
	/**
	 * 获取费用记账数据
	 * @param cgIds
	 * @return
	 * @throws BizException
	 */
	protected BlOepChargeInputDTO[] getBlCgInfo(String[] cgIds) throws BizException{
		
		return null;
	}
	
}
