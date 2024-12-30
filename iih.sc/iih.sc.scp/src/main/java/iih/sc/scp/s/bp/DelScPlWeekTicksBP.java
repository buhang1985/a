package iih.sc.scp.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.sc.scp.scplticks.d.ScPlanWeekTicksDO;
import iih.sc.scp.scplticks.i.IScplticksCudService;
import iih.sc.scp.scplticks.i.IScplticksRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 删除对应周计划下的所有号段
 * @author zhouliming
 *
 */
public class DelScPlWeekTicksBP {
	/**
	 * 删除对应周计划下的所有号段
	 * @param id_scplweek
	 * @throws BizException
	 */
	public void exec(String id_scplweek) throws BizException{
		if(StringUtils.isBlank(id_scplweek)) return;
		
		IScplticksCudService tickssrv = ServiceFinder.find(IScplticksCudService.class);
		IScplticksRService ticksRsrv = ServiceFinder.find(IScplticksRService.class);
		ScPlanWeekTicksDO[] ticksOldDOs = ticksRsrv.find("id_scplweek = '"+id_scplweek+"'", "", FBoolean.FALSE);
		tickssrv.delete(ticksOldDOs);//删除旧数据
	}
}
