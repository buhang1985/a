package iih.en.pv.s.task;

import iih.en.pv.s.task.bp.OpAptCfm4SmsBP;
import iih.en.pv.s.task.bp.OpReg4SmsBP;

import java.util.Map;

import xap.mw.core.data.BizException;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;

/**
 * 预约取号短信通知和挂号短信通知
 * 
 * @author fanliqin
 *
 */
public class OpAptCfmAndReg4SmsTask implements IBackgroundWorkPlugin {
	/**
	 * 执行任务
	 */
	@Override
	public PreAlertObject executeTask(BgWorkingContext ctx) throws BizException {
		// 预约取号短信通知BP
		OpAptCfm4SmsBP opAptCfmVip4SmsBP = new OpAptCfm4SmsBP();
		Map<String, Object> map = ctx.getKeyMap();
		if (map.containsKey("orgId")) {
			opAptCfmVip4SmsBP.exec(String.valueOf(map.get("orgId")));
		}
		// 门诊挂号短信通知BP
		OpReg4SmsBP opRegVip4SmsBP = new OpReg4SmsBP();
		opRegVip4SmsBP.exec();

		PreAlertObject obj = new PreAlertObject();
//		obj.setReturnType(PreAlertReturnType.RETURNNOTHING);
		return obj;
	}

}
