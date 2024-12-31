package iih.ci.ord.s.bp.task;

import java.util.Map;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.mp.nr.foreign.i.IForeignService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;
/**
 * 根据医嘱的停止时间设置定时任务，到停止时间时启动任务将医嘱设置为完成状态
 * @author zhangwq
 *
 */
public class CompleteStatusTask   implements IBackgroundWorkPlugin{

	@Override
	public PreAlertObject executeTask(BgWorkingContext arg0)
			throws BizException {
		String idor = null;
		String dtlast = null;
				
		Map<String,Object> variableValueMap = arg0.getKeyMap();
		idor = (String) variableValueMap.get("idor");
		IForeignService service=ServiceFinder.find(IForeignService.class);
		service.UpdateOrderStatus(new String[]{idor});
//		CiOrderDO order = CiOrdAppUtils.getOrQryService().findById(idor);
//		if(order!=null){
//			//医嘱完成时，组装数据,并调用费用停止计费
//			IBlOutCmdService blOutCmdService = ServiceFinder.find(IBlOutCmdService.class);
//			blOutCmdService.chargePrnOrd(order.getId_pat(), new String[]{order.getId_or()}, order.getDt_end());
//		}
		return null;
	}

}
