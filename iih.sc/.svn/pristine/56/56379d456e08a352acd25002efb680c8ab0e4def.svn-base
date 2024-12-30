package iih.sc.scp.s.bp.common;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.comm.ScValidator;
import iih.sc.scp.s.ep.ScplWeekTickEP;
import iih.sc.scp.s.ep.ScplWeekTicksEP;
import xap.mw.core.data.BizException;

/**
 * 删除周计划号段或号位
 * 
 * @author liubin
 *
 */
public class DelPlWeekTickOrTicksBP {
	
	/**
	 * 删除号段或号位
	 * 
	 * @param scplWeekIds 周计划ID集合
	 * @param tickmd 号段号位模式
	 * @throws BizException 
	 */
	public void exec(String[] scplWeekIds, String tickmd) throws BizException{
		if(ScValidator.isNullOrEmpty(scplWeekIds) || ScValidator.isEmptyIgnoreBlank(tickmd))
			return;
		if(IScDictCodeConst.SD_TICKMD_TICK.equals(tickmd)){
			this.delTick(scplWeekIds);
		}else if(IScDictCodeConst.SD_TICKMD_TICKS.equals(tickmd)){
			this.delTicks(scplWeekIds);
			this.delTick(scplWeekIds);//号段模式删除号位指定渠道列表
		}
	}
	
	/**
	 * 删除周计划号位
	 * @param scplWeekIds
	 * @throws BizException 
	 */
	private void delTick(String[] scplWeekIds) throws BizException{
		ScplWeekTickEP ep = new ScplWeekTickEP();
		ep.delete(scplWeekIds);
	}
	
	/**
	 * 删除周计划号段
	 * @param scplWeekIds
	 * @throws BizException 
	 */
	private void delTicks(String[] scplWeekIds) throws BizException{
		ScplWeekTicksEP ep = new ScplWeekTicksEP();
		ep.delete(scplWeekIds);
	}
}
