package iih.bl.st.s.bp.oepcharge;

import iih.bl.comm.util.BlFlowParamLoader;
import iih.bl.st.dto.bloepcharge.d.BlOepChargeCommonCondDTO;
import iih.bl.st.dto.bloepcharge.d.BlOepChargeInputDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;

/**
 * 门诊调入(默认时间费用)
 * @author ly 2018/12/05
 *
 */
public class GetOepCostInfoPeriodBP {

	 /**
     * 门诊调入(时间段)
     * @param patId
     * @param days
     * @return
     * @throws BizException
     */
	public BlOepChargeInputDTO[] exec(String patId, FDate dtBegin, FDate dtEnd) throws BizException{
		
		//加载默认时间及校验参数
		BlFlowParamLoader paramLoader = new BlFlowParamLoader();
		paramLoader.loadOepCostParam();
		
		GetOepCostInfoBP bp = new GetOepCostInfoBP();
		
		BlOepChargeCommonCondDTO cond = new BlOepChargeCommonCondDTO();
		cond.setId_pat(patId);
		cond.setDt_begin(dtBegin);
		cond.setDt_end(dtEnd);
		
		return bp.exec(cond, FBoolean.TRUE);
	}
}
