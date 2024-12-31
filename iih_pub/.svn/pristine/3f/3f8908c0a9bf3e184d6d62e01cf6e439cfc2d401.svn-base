package iih.mm.pl.stockplan.i.ds;

import iih.bd.bc.udi.pub.IMmDictCodeConst;
import iih.mm.pl.stockplan.d.StockPlanFormAggDO;
import iih.mm.pl.stockplan.i.IStockplanCudService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.wf.af.context.NextTaskInfoCtx;
import xap.wf.af.context.WfFlowInfoCtx;
import xap.wf.af.dftimpl.DefaultFormOper;
import xap.wf.af.runtime.TaskInstance;
import xap.wf.af.server.WfFormInfoCtx;
import xap.wf.af.utils.WfTaskUtil;
import xap.mw.log.logging.Logger;

public class StockPlanFormOperator  extends  DefaultFormOper{
	
	@Override
	public WfFormInfoCtx[] write(WfFlowInfoCtx flowInfo, WfFormInfoCtx... billInfo) {
//		if(flowInfo instanceof NextTaskInfoCtx){
//			NextTaskInfoCtx nextInfo=(NextTaskInfoCtx)flowInfo;
//			String taskPk=nextInfo.getTaskPk();
//	    	TaskInstance taskIns=WfTaskUtil.getTaskByTaskPk(taskPk);
//		    taskIns.getProcessInstance().getId_proins();
//		}
		
		
//		String proDefId = flowInfo.getProDef().getId_prodef();
//		String proInsId = 
		
		WfFormInfoCtx inner = billInfo[0];
		if (inner instanceof StockPlanFormAggDO) {
			//如果是[审核通过]或[审核驳回]状态，需要回写单据
			String status = ((StockPlanFormAggDO) inner).getParentDO().getSd_su_pl();
			if (IMmDictCodeConst.SD_SU_PL_CONFIRM_PASS.equals(status)
					|| IMmDictCodeConst.SD_SU_PL_CONFIRM_REFUSE.equals(status)) {
				StockPlanFormAggDO billDo = (StockPlanFormAggDO) inner;
				IStockplanCudService service=ServiceFinder.find(IStockplanCudService.class);
			    try {
					service.update(new StockPlanFormAggDO[]{billDo});
				} catch (BizException e) {
					Logger.error(e);
				}
			}
		}
		return new WfFormInfoCtx[]{inner};
	}
}
