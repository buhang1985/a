package iih.sc.sch.s.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.comm.IScMsgConst;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.scsch.i.IScschMDOCudService;
import iih.sc.sch.scticks.d.ScSchTicksDO;
import iih.sc.sch.scticks.i.IScticksCudService;
import iih.sc.scp.scplan.d.ScPlanDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 新增或修改排班
 * @author ccj
 *
 */
public class SaveSchBp {
	
	/**
	 * 新增或修改排班
	 * @param schDO  排班do
	 * @throws BizException
	 */
	public void exec(ScSchDO schDO)throws BizException{
		IScschMDOCudService srv = ServiceFinder.find(IScschMDOCudService.class);
		Integer state = schDO.getStatus();	//排班状态
		// 判断是是否为修改操作
		srv.save(new ScSchDO[]{schDO});
		GetScplanBySchBp getScplanBySchBp = new GetScplanBySchBp();
		ScPlanDO planDO = getScplanBySchBp.exec(schDO); 
		if(planDO == null) throw new BizException(IScMsgConst.SC_SCH_SCPLAN_ISEMPY);
		if(IScDictCodeConst.SD_TICKMD_TICK.equals(planDO.getSd_tickmd())){
			//号位
			SaveTickBySchBp bySchBp = new SaveTickBySchBp();
			bySchBp.exec(schDO,state);
		}else if(IScDictCodeConst.SD_TICKMD_TICKS.equals(planDO.getSd_tickmd())){
			//号段
			SaveSchTicksBp saveSchTicksBp = new SaveSchTicksBp();
			ScSchTicksDO[] ticksDOs = saveSchTicksBp.exec(schDO, state);
			IScticksCudService ticksCudSrv = ServiceFinder.find(IScticksCudService.class);
			ScSchTicksDO[] newTicks = ticksCudSrv.save(ticksDOs);
		    GetSdSchruleByIdSchBp byIdSchBp = new GetSdSchruleByIdSchBp();
		    String sd_schrule = byIdSchBp.exec(schDO.getId_sch()); // 预约规则
			//保存号段后生成对应的号位
		    SaveTickByTicksBp byTicksBp = new SaveTickByTicksBp();
			byTicksBp.exec(newTicks, sd_schrule);
		}
	}
}
