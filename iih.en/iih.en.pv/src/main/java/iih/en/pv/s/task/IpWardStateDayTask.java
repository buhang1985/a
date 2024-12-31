package iih.en.pv.s.task;

import iih.bd.base.utils.AppUtils;
import iih.en.comm.util.EnLogUtil;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.s.task.bp.IpBedUseStateBP;
import iih.en.pv.s.task.bp.IpWardStateDayTaskBP;

import java.util.Map;

//import iih.en.pv.s.task.bp.IpWardStateDayTaskBP;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;

public class IpWardStateDayTask  implements IBackgroundWorkPlugin{
	/**
	 * 执行任务
	 */
	@Override
	public PreAlertObject executeTask(BgWorkingContext ctx) throws BizException {
		//传入参数
		Map<String, Object> map = ctx.getKeyMap();
		String dateStr = (String)map.get("date");
		FDate date = null ;
		if(EnValidator.isEmpty(dateStr)){
			date = AppUtils.getServerDateTime().getBeginDate().getDateBefore(1);
		}else{
			date = new FDate().getDate(dateStr);
		}
		//日志
		EnLogUtil.getInstance().logInfo("病区日流水定时任务，统计日期："+date);
		IpWardStateDayTaskBP bp = new IpWardStateDayTaskBP();
		bp.exec(date);
		EnLogUtil.getInstance().logInfo("病区日流水定时任务，统计日期："+date);
		IpBedUseStateBP bedbp = new IpBedUseStateBP();
		bedbp.exec(date);
		PreAlertObject obj = new PreAlertObject();
        return obj;
	}
}
