package iih.sc.scp.s.bp.common;

import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScValidator;
import iih.sc.scp.s.ep.ScplWeekEP;
import iih.sc.scp.scplweek.d.ScPlanWeekDO;
import iih.sc.scp.scplweek.d.ScplweekAggDO;

import java.util.HashSet;
import java.util.Set;

import xap.mw.core.data.BizException;

/**
 * 删除计划周模板
 * （包括号段或号位）
 * 
 * @author liubin
 *
 */
public class DelPlWeekBP {
	
	/**
	 * 删除周计划
	 * 
	 * @param scplId
	 * @param tickmd
	 * @throws BizException
	 */
	public void deletePlWeek(String scplId, String tickmd) throws BizException{
		if(ScValidator.isEmptyIgnoreBlank(scplId))
			return;
		ScplWeekEP ep = new ScplWeekEP();
		ScPlanWeekDO[] weeks = ep.getPlWeekByPlId(scplId);
		this.deletePlWeeksByParent(weeks, tickmd);
	}
	
	/**
	 * 删除计划周模板
	 * @param weekAggs 计划周模板集合
	 * @param tickmd 号位号段模式
	 * @throws BizException 
	 */
	public void deletePlWeeks(ScplweekAggDO[] weekAggs, String tickmd) throws BizException{
		if(ScValidator.isNullOrEmpty(weekAggs))
			return;
		String[] plWeekIds = ScplWeekEP.getPlWeekIds(weekAggs);
		DelPlWeekTickOrTicksBP tickOrTicksBP = new DelPlWeekTickOrTicksBP();
		tickOrTicksBP.exec(plWeekIds, tickmd);
		ScplWeekEP weekEP = new ScplWeekEP();
		weekEP.deleteAgg(weekAggs);
	}
	/**
	 * 删除计划周模板
	 * @param weekAggs 计划周模板集合
	 * @param tickmd 号位号段模式
	 * @throws BizException 
	 */
	public void deletePlWeeksByParent(ScPlanWeekDO[] weeks, String tickmd) throws BizException{
		if(ScValidator.isNullOrEmpty(weeks))
			return;
		String[] plWeekIds = ScplWeekEP.getPlWeekIds(weeks);
		DelPlWeekTickOrTicksBP tickOrTicksBP = new DelPlWeekTickOrTicksBP();
		tickOrTicksBP.exec(plWeekIds, tickmd);
		ScplWeekEP weekEP = new ScplWeekEP();
		weekEP.deleteByParentDO(weeks);
	}
}
