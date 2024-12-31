package iih.bl.st.s.bp.oepcharge;

import iih.bd.base.utils.AppUtils;
import iih.bl.st.dto.bloepcharge.d.BlOepChargeCommonCondDTO;
import iih.bl.st.dto.bloepcharge.d.BlOepChargeInputDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 
 * 门诊调入(多条件)
 * @author ly 2019/07/03
 *
 */
public class GetOepCostInfoCommonCondBP {
	 
	/**
	 * 门诊调入(多条件)
	 * @param condDto 条件
	 * @return 调入结果
	 * @throws BizException
	 */
	public BlOepChargeInputDTO[] exec(BlOepChargeCommonCondDTO condDto) throws BizException{
		
		if(condDto.getDt_begin() == null){
			condDto.setDt_begin(AppUtils.getServerDate().asBegin());
		}
		
		if(condDto.getDt_end() == null){
			condDto.setDt_end(condDto.getDt_begin().asBegin());
		}
		
		FBoolean fgCheckValid = FBoolean.TRUE;
		if(condDto.getDt_begin().equals(condDto.getDt_end())){
			fgCheckValid = FBoolean.FALSE;
		}
		
		GetOepCostInfoBP bp = new GetOepCostInfoBP();
		return bp.exec(condDto, fgCheckValid);
	}
}
