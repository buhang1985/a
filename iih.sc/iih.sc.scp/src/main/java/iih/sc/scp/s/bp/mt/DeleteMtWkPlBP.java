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
 * 删除天计划
 * @author 
 *
 */
public class DeleteMtWkPlBP {
	 /**
	  * 删除天计划
	  * @param id_scplWeek 天计划id
	  * @param sv  版本标识
	  * @throws BizException
	  */
	 public void exec(String id_scplWeek,FDateTime sv) throws BizException{
		 ScValidator.validateParam("id_scplWeek", id_scplWeek);
		 ScplWeekEP ep = new ScplWeekEP();
		 ScPlanWeekDO week = ep.getPlWeekById(id_scplWeek);
		 if(week == null)
			 throw new BizException(IScMsgConst.SC_SCP_SCPLAN_SCPLWEEKNULL);
		//获取排班计划
		ScplEp scplEp = new ScplEp();
		ScPlanDO pl = scplEp.getScPl(week.getId_scpl());
		if(pl == null)
			throw new BizException(IScMsgConst.SC_SCP_SCPLAN_SCPLANNULL);
		DelPlWeekBP plWeekBP = new DelPlWeekBP();
		plWeekBP.deletePlWeeksByParent(new ScPlanWeekDO[] { week }, pl.getSd_tickmd());
	 }
}
