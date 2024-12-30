package iih.sc.scp.s.bp.mt;

import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScValidator;
import iih.sc.scp.s.bp.common.DelPlWeekBP;
import iih.sc.scp.s.ep.ScplEp;
import iih.sc.scp.s.ep.ScplWeekEP;
import iih.sc.scp.scplan.d.ScPlanDO;
import iih.sc.scp.scplweek.d.ScPlanWeekDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
/**
 * 删除医技计划
 * 
 * @author liubin
 *
 */
public class DeleteMtPlBP {
	/**
	 * 删除医技计划
	 * @param scpl
	 * @param sv
	 * @throws BizException
	 */
	public void exec(String scpl,FDateTime sv)throws BizException {
		ScValidator.validateParam("scpl", scpl);
		//获取排班计划
		ScplEp scplEp = new ScplEp();
		ScPlanDO pl = scplEp.getScPl(scpl);
		if(pl == null)
			throw new BizException(IScMsgConst.SC_SCP_SCPLAN_SCPLANNULL);
		//删除周计划(包括计划号位或号段)
		this.deleteWeek(pl);
		//删除计划
		scplEp.delate(new ScPlanDO[] { pl });
	}
	/**
	 * 删除周计划(包括计划号位或号段)
	 * 
	 * @param pl
	 * @throws BizException 
	 */
	private void deleteWeek(ScPlanDO pl) throws BizException{
		if(pl == null)
			return;
		ScplWeekEP ep = new ScplWeekEP();
		ScPlanWeekDO[] weeks = ep.getPlWeekByPlId(pl.getId_scpl());
		if(ScValidator.isNullOrEmpty(weeks))
			return;
		DelPlWeekBP delPlWeekBP = new DelPlWeekBP();
		delPlWeekBP.deletePlWeeksByParent(weeks, pl.getSd_tickmd());
	}
}
