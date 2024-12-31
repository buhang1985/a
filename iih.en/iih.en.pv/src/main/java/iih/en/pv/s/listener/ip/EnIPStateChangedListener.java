package iih.en.pv.s.listener.ip;

import iih.en.comm.IEnMsgConst;
import iih.en.comm.util.EnLogUtil;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.pub.listener.IEnIPStateChangedListener;
import iih.en.pv.s.listener.bp.UpdateIpPatStateBP;
import iih.mp.mpbd.mpskdevent.d.NmrEventDTO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
/***
 * 护理就诊状况修改后修改就诊这边的就诊状况监听
 * 
 * @author fanlq
 *
 */
@Service(serviceInterfaces={IEnIPStateChangedListener.class}, binding=Binding.JSONRPC)
public class EnIPStateChangedListener implements IBusinessListener {
	
	/**
	 * 执行
	 */
	public void doAction(IBusinessEvent event) throws BizException {
		EnLogUtil.getInstance().displayInfo("接收事件: " + event.getEventType());
		//1、校验事件是否匹配
		this.validate(event);
		//2、包装显示所需结构
		BusinessUserObj bizUserObj = (BusinessUserObj)event.getUserObject();
		NmrEventDTO eventSourceDTO = (NmrEventDTO)bizUserObj.getUserObj();
		//3、修改患者的就诊状况
		this.updatePatState(eventSourceDTO,event.getEventType());
	}
	
	/***
	 * 修改患者的就诊状况
	 * @param nmrEventDTO
	 * @param eventType
	 * @throws BizException 
	 */
	private void updatePatState(NmrEventDTO nmrEventDTO,String eventType) throws BizException{
		if(nmrEventDTO != null && !EnValidator.isEmpty(nmrEventDTO.getId_enstate())){
			//2.修改就诊的就诊状况
			UpdateIpPatStateBP bp = new UpdateIpPatStateBP();
			bp.exec(nmrEventDTO,eventType);
		}
	}
	
	/**
	 * 验证事件
	 * @param event 事件
	 * @throws BizException
	 */
	private void validate(IBusinessEvent event) throws BizException{
		if(!"iih.mp.mpbd.mpskdevent.d.NmrEventDTO".equalsIgnoreCase(event.getSourceID())){
			throw new BizException(IEnMsgConst.ERROR_LISTENER_NOT_MATCH_EVENT);
		}		
	}
}
