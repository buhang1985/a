package iih.en.pv.s.task;

import iih.en.pv.s.task.bp.OpReVisit4SmsBP;

import java.util.Map;

import xap.mw.core.data.BizException;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;

/**
 * 复诊短信通知
 * @author yankan
 *
 */
public class OpReVisit4SmsTask implements IBackgroundWorkPlugin{

	/**
	 * 执行任务
	 */
	@Override
	public PreAlertObject executeTask(BgWorkingContext ctx) throws BizException {
		OpReVisit4SmsBP revisitBP = new OpReVisit4SmsBP();
		Map<String, Object> map = ctx.getKeyMap();
		if(map.containsKey("orgId")){
			revisitBP.exec(String.valueOf(map.get("orgId")));
		}
		
		PreAlertObject obj = new PreAlertObject();
//        obj.setReturnType(PreAlertReturnType.RETURNNOTHING);
        return obj;
	}
}

