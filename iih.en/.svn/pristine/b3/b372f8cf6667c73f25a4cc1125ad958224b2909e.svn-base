package iih.en.er.bp.inouttransmgr;

import iih.en.er.dto.d.EuUrgInOutTransMgrType;
import xap.mw.core.data.BizException;

/**
 * 急诊入出转操作工厂类
 * 
 * @author liubin
 *
 */
public class InOutTransMgrFactory {
	/**
	 * 获取操作接口
	 * 
	 * @param euUrgInOutTransMgrType
	 * @return
	 */
	public IInOutTransMgr get(String euUrgInOutTransMgrType) throws BizException{
		switch (euUrgInOutTransMgrType) {
		//入科
		case EuUrgInOutTransMgrType.ENTRYDEPT:
			return new InOutTransOfEntryDepBP();
		case EuUrgInOutTransMgrType.CANCENTRYDEPT:
			return new InOutTransOfCancEntryDepBP();
		case EuUrgInOutTransMgrType.TRANSDEPT:
			return new InOutTransOfTransDepBP();
		case EuUrgInOutTransMgrType.LVHOS:
			return new InOutTransOfLvHosBP();
		case EuUrgInOutTransMgrType.RECALL:
			return new InOutTransOfReCallBP();
		case EuUrgInOutTransMgrType.FLOWTOFSTAID:
			return new InOutTransOfFlowToFstaidBP();
		default:
			break;
		}
		throw new BizException("急诊入出转操作类型错误:" + euUrgInOutTransMgrType);
	}
}
