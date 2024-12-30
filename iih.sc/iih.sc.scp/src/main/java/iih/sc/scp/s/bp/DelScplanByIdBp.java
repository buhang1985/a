package iih.sc.scp.s.bp;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import iih.sc.scp.scplan.d.ScPlanDO;
import iih.sc.scp.scplan.i.IScplanCudService;
import iih.sc.scp.scplan.i.IScplanRService;
import iih.sc.scp.scplweek.d.ScplweekAggDO;
import iih.sc.scp.scplweek.i.IScplweekCudService;
import iih.sc.scp.scplweek.i.IScplweekRService;

/**
 * 删除排班计划及相关周计划
 * @author zhouliming
 */
public class DelScplanByIdBp {

	/**
	 * 根据排班计划id删除排班计划及相关周计划
	 * @param id_scpl
	 * @throws BizException 
	 */
	public void exec(String id_scpl) throws BizException{
		//删除排班计划
		IScplanRService planRSrv = ServiceFinder.find(IScplanRService.class);
		IScplanCudService planCudSrv = ServiceFinder.find(IScplanCudService.class);
		ScPlanDO scplanDO = planRSrv.findById(id_scpl);
		if(scplanDO == null) return;
		planCudSrv.delete(new ScPlanDO[]{scplanDO});
	}
}
