package iih.sc.scp.s.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.scp.scplweek.d.ScplweekAggDO;
import iih.sc.scp.scplweek.i.IScplweekCudService;
import iih.sc.scp.scplweek.i.IScplweekRService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
/**
 * 删除一条周计划
 * @author zhouliming
 */
public class DelPlanWeekBP {
	/**
	 * 删除一条周计划
	 * @param palnweekid
	 * @param Sd_tickmd
	 * @throws BizException
	 */
	public void exec(String planweekid, String Sd_tickmd)throws BizException {
		IScplweekRService sr = ServiceFinder.find(IScplweekRService.class);
		IScplweekCudService sc = ServiceFinder.find(IScplweekCudService.class);
		ScplweekAggDO aggDO = sr.findById(planweekid);
		sc.delete( new ScplweekAggDO[]{aggDO});
		
		DelScPlWeekTickBP tickBP = new DelScPlWeekTickBP();
		DelScPlWeekTicksBP ticksBP = new DelScPlWeekTicksBP();
		
		if (Sd_tickmd.equals(IScDictCodeConst.SD_TICKMD_TICK)) {// 号位模式
			tickBP.exec(planweekid);
		} else if (Sd_tickmd.equals(IScDictCodeConst.SD_TICKMD_TICKS)){// 号段模式
			ticksBP.exec(planweekid);
		}
	}
}
