package iih.sc.scp.s.bp.mt;

import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScValidator;
import iih.sc.scp.s.bp.common.DelPlWeekBP;
import iih.sc.scp.s.ep.ScplEp;
import iih.sc.scp.s.ep.ScplWeekEP;
import iih.sc.scp.scplan.d.ScPlanDO;
import iih.sc.scp.scplweek.d.ScPlanWeekDO;
import iih.sc.scp.scplweek.d.desc.ScPlanWeekDODesc;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
/**
 * 删除周计划
 * @author 
 *
 */
public class DeleteMtWkPlsBP {
	 /**
	  * 删除周计划
	  * @param is_scpl  计划id
	  * @param idx_week 周序号
	  * @param sv 版本标识
	  * @throws BizException
	  */
	public void exec(String id_scpl,Integer idx_week ,FDateTime sv) throws BizException{
		ScValidator.validateParam("id_scpl", id_scpl);
		ScValidator.validateParam("idx_week", idx_week);
		ScplEp scplEp = new ScplEp();
		ScPlanDO pl = scplEp.getScPl(id_scpl);
		if(pl == null)
			throw new BizException(IScMsgConst.SC_SCP_SCPLAN_SCPLANNULL);
		String condition = String.format("%s.%s = '%s' and %s.%s = '%s'", 
				ScPlanWeekDODesc.TABLE_ALIAS_NAME, ScPlanWeekDO.ID_SCPL, id_scpl, 
				ScPlanWeekDODesc.TABLE_ALIAS_NAME, ScPlanWeekDO.IDX_WEEK, idx_week);
		ScplWeekEP weekEP = new ScplWeekEP();
		ScPlanWeekDO[] weeks = weekEP.getPlWeekByCond(condition, null);
		if(ScValidator.isNullOrEmpty(weeks))
			throw new BizException(IScMsgConst.SC_SCP_SCPLAN_SCPLWEEKNULL);
		DelPlWeekBP plWeekBP = new DelPlWeekBP();
		plWeekBP.deletePlWeeksByParent(weeks, pl.getSd_tickmd());
	}
}
