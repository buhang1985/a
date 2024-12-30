package iih.sc.scp.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.sc.scp.scpltick.d.ScPlanWeekTickDO;
import iih.sc.scp.scpltick.i.IScpltickCudService;
import iih.sc.scp.scpltick.i.IScpltickRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 删除对应周计划下的所有号位
 * @author zhouliming
 */
public class DelScPlWeekTickBP {
	/**
	 * 删除对应周计划下的所有号位
	 * @param id_scplweek
	 * @throws BizException
	 */
	public void exec(String id_scplweek) throws BizException{
		if(StringUtils.isBlank(id_scplweek)) return;
		IScpltickCudService ticksrv = ServiceFinder.find(IScpltickCudService.class);
		IScpltickRService tickRsrv = ServiceFinder.find(IScpltickRService.class);
		ScPlanWeekTickDO[] tickOldDOs = tickRsrv.find("id_scplweek = '"+id_scplweek+"'", "", FBoolean.FALSE);
		ticksrv.delete(tickOldDOs);//删除旧数据
	}
}
