package iih.en.que.s.listener;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.bd.fc.quesite.i.IQuesiteRService;
import iih.en.comm.util.EnLogUtil;
import iih.en.que.dto.d.OpQue4EsDTO;
import iih.en.que.dto.d.TriageBenInfoDTO;
import iih.en.que.i.IEnQueCmdService;
import iih.en.que.i.IEnQueQryService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
/**
 * 门诊队列 器监听医生上线 开启自动分诊
 * @author li.wm
 *
 */
public class EnOpQueAutoTriageListener implements IBusinessListener {

	@Override
	public void doAction(IBusinessEvent arg0) throws BizException {
		EnLogUtil.getInstance().displayInfo("接收事件: " + arg0.getEventType()); 
		//1、验证事件，是否匹配
		if(!this.validate(arg0))
			return;
		//2、包装显示所需结构
		BusinessUserObj bizUserObj = (BusinessUserObj)arg0.getUserObject();
		OpQue4EsDTO opQue4EsDTO = (OpQue4EsDTO)bizUserObj.getUserObj();
		//3.发送自动分诊消息
		this.autoTriageMsg(opQue4EsDTO, arg0.getEventType());
	}

	public void autoTriageMsg(OpQue4EsDTO opQue4EsDTO, String eventType) throws BizException {
		// TODO Auto-generated method stub
		IEnQueCmdService enQueCmdService = ServiceFinder.find(IEnQueCmdService.class);
		IEnQueQryService enQueQryService = ServiceFinder.find(IEnQueQryService.class);
		IQuesiteRService quesiteRService = ServiceFinder.find(IQuesiteRService.class);
		
		QueSiteDO queSite = quesiteRService.findById(opQue4EsDTO.getId_que_site());
		if(null == queSite)
			return;
		TriageBenInfoDTO triageBenInfo = enQueQryService.getTriageBenInfo(queSite.getId_queben(),IBdFcDictCodeConst.SD_CODE_ENTP_OP);
		if(null == triageBenInfo)
			return;
		enQueCmdService.autoTriage(triageBenInfo);

	}
	/**
	 * 验证事件
	 * @param event 事件
	 * @throws BizException
	 */
	private boolean validate(IBusinessEvent event) throws BizException{
		if(!IEnEventConst.EVENT_SOURCE_EN_OP_QUE.equalsIgnoreCase(event.getSourceID())
			|| !IEnEventConst.EVENT_EN_OP_DOC_ONLINE.equals(event.getEventType())){
			return false;
		}
		return true;
	}

}
