package iih.sc.scp.s.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.scp.scpltick.d.ScPlanWeekTickDO;
import iih.sc.scp.scpltick.i.IScpltickCudService;
import iih.sc.scp.scpltick.i.IScpltickRService;
import iih.sc.scp.scplticks.d.ScPlanWeekTicksDO;
import iih.sc.scp.scplticks.i.IScplticksCudService;
import iih.sc.scp.scplticks.i.IScplticksRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 根据周计划id集合和票号模式删除号位或号段
 * @author zhouliming
 *
 */
public class DelScPlTickOrTicksBp {
	
	/**
	 * 根据周计划id集合和票号模式删除号位或号段
	 * @param scPlweekIdSets
	 * @param Sd_tickmd
	 * @throws BizException 
	 */
	public void exec(String scPlweekIdSets,String Sd_tickmd) throws BizException{
		//删除号位或号段
		if (Sd_tickmd.equals(IScDictCodeConst.SD_TICKMD_TICK)) {// 号位模式
			IScpltickRService tickRSrv = ServiceFinder.find(IScpltickRService.class);
			IScpltickCudService tickCudSrv = ServiceFinder.find(IScpltickCudService.class);
			ScPlanWeekTickDO[] tickDOs = tickRSrv.find("id_scplweek in "+scPlweekIdSets, "", FBoolean.FALSE);
			if(tickDOs != null && tickDOs.length > 0){
				tickCudSrv.delete(tickDOs);
			}
		}else if(Sd_tickmd.equals(IScDictCodeConst.SD_TICKMD_TICKS)){// 号段模式
			IScplticksRService ticksRSrv = ServiceFinder.find(IScplticksRService.class);
			IScplticksCudService ticksCudSrv = ServiceFinder.find(IScplticksCudService.class);
			ScPlanWeekTicksDO[] ticksDOs = ticksRSrv.find("id_scplweek in "+scPlweekIdSets, "", FBoolean.FALSE);
			if(ticksDOs != null && ticksDOs.length > 0){
				ticksCudSrv.delete(ticksDOs);
			}
		}
	}
}
