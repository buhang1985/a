package iih.en.pv.s.task;

import iih.en.pv.s.task.bp.OpReg4SmsBP;
import xap.mw.core.data.BizException;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;

/**
 * 门诊挂号短信通知
 * @author fanliqin
 *
*/
	public class OpReg4SmsTask  implements IBackgroundWorkPlugin{
		/**
		 * 执行任务
		 */
		@Override
		public PreAlertObject executeTask(BgWorkingContext ctx) throws BizException {
			OpReg4SmsBP opRegVip4SmsBP = new OpReg4SmsBP();
			opRegVip4SmsBP.exec();
			
			PreAlertObject obj = new PreAlertObject();
//	        obj.setReturnType(PreAlertReturnType.RETURNNOTHING);
	        return obj;
		}	
	}

