package iih.bl.st.s.bp.oepcharge;

import iih.bd.base.utils.AppUtils;
import iih.bl.st.dto.bloepcharge.d.BlOepChargeCommonCondDTO;
import iih.bl.st.dto.bloepcharge.d.BlOepChargeInputDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;

/**
 * 门诊调入(一日)
 * @author ly 2018/12/07
 *
 */
public class GetOepCostInfoOneDayBP {
	
	 /**
     * 门诊调入(一日费用)
     * @param patId 患者id
     * @return 待收费信息
     * @throws BizException
     */
	public BlOepChargeInputDTO[] exec(String patId) throws BizException{
		
		GetOepCostInfoBP bp = new GetOepCostInfoBP();
		
		FDate dtBegin = AppUtils.getServerDate();
		FDate dtEnd = dtBegin.asBegin();
		
		BlOepChargeCommonCondDTO cond = new BlOepChargeCommonCondDTO();
		cond.setId_pat(patId);
		cond.setDt_begin(dtBegin);
		cond.setDt_end(dtEnd);
		
		return bp.exec(cond, FBoolean.FALSE);
	}
}
