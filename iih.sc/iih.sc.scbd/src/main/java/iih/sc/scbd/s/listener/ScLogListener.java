package iih.sc.scbd.s.listener;

import iih.bd.bc.event.pub.IScEventConst;
import iih.sc.scbd.dto.d.ScLogEventDTO;
import iih.sc.scbd.log.s.bp.CreateLogBP;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;

/**
 * DO日志记录监听器
 * 
 * @author liubin
 *
 */
public class ScLogListener implements IBusinessListener {

	@Override
	public void doAction(IBusinessEvent event)
			throws BizException {
		//验证事件源
		if(!this.volidate(event))
			return;
		BusinessUserObj bizUserObj = (BusinessUserObj)event.getUserObject();
		ScLogEventDTO eventDTO = (ScLogEventDTO)bizUserObj.getUserObj();
		if(eventDTO == null)
			return;
		CreateLogBP createBP = new CreateLogBP();
		createBP.exec(convertToArrays(eventDTO.getNewobjs()), convertToArrays(eventDTO.getOldobjs()), eventDTO.getEuopertp(), eventDTO.getId_psn());
	}
	/**
	 * 验证事件源
	 * 
	 * @param event
	 * @return
	 */
	private boolean volidate(IBusinessEvent event){
		if(!IScEventConst.EVENT_SOURCE_SC_LOG.equalsIgnoreCase(event.getSourceID())
				|| !IScEventConst.EVENT_SC_LOG_BASEDO.equals(event.getEventType()))
			return false;
		return true;
	}
	/**
	 * 把FAarrayList转成数组
	 * 
	 * @param fList
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private static <T extends BaseDO> T[] convertToArrays(FArrayList fList){
		return fList == null ? null : (T[])fList.toArray(new BaseDO[0]);
	}
}
