package iih.en.que.s.listener;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.util.EnLogUtil;
import iih.en.que.board.d.EnBrdSiteDO;
import iih.en.que.dto.d.AllQue4EsDTO;
import iih.en.que.s.listener.bp.SendBrdMsgBP;
import iih.en.que.s.listener.bp.WrapAllQueMsgInfoBP;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
/***
 * 通用分诊集成平台监听器
 * @author fanlq
 * @date: 2019年12月10日 下午7:05:41
 */
public class EnAllQue4DisplayNewListener implements IBusinessListener {

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		EnLogUtil.getInstance().displayInfo("接收事件: " + event.getEventType());
		//1、验证事件，是否匹配
		this.validate(event);
		//2、包装显示所需结构
		BusinessUserObj bizUserObj = (BusinessUserObj)event.getUserObject();
		AllQue4EsDTO eventSourceDTO = (AllQue4EsDTO)bizUserObj.getUserObj();
		this.OnSendMsg(eventSourceDTO,event.getEventType());
	}
	/***
	 * @Description:发送通用队列消息
	 * @param allQue4EsDTO
	 * @param eventType
	 * @throws BizException 
	 */
	private void OnSendMsg(AllQue4EsDTO allQue4EsDTO, String eventType) throws BizException{
		WrapAllQueMsgInfoBP wrapBP = new WrapAllQueMsgInfoBP();
		SendBrdMsgBP brdBP = new SendBrdMsgBP();
		AllQue4EsDTO dispDTO = wrapBP.wrap(allQue4EsDTO);
		try {
			switch (eventType) {
				case IEnEventConst.EVENT_EN_ALL_SIGNIN:// 到诊
				case IEnEventConst.EVENT_EN_ALL_CANC_SIGNIN:// 取消到诊
					sendInfo(wrapBP,brdBP,dispDTO,eventType);
					break;
			}
		} catch (Exception e) {
			EnLogUtil logUtil = EnLogUtil.getInstance();
			logUtil.logError("上屏出错:", e);
		}
	}
	
	/**
	 * 更新站点信息
	 * 
	 * @param displayDTO
	 * @param eventType
	 * @throws BizException 
	 */
	private void sendInfo(WrapAllQueMsgInfoBP wrapBp,SendBrdMsgBP brdBP, AllQue4EsDTO allQue4EsDTO, String eventType) throws BizException{
		EnBrdSiteDO[] siteInfos = wrapBp.wrapSiteMsgInfo(allQue4EsDTO);
		EnLogUtil logUtil = EnLogUtil.getInstance();
		if(ArrayUtil.isEmpty(siteInfos)){
			logUtil.displayInfo("调用一次通用分诊大屏,发送数据为空：allQue4EsDTO："+allQue4EsDTO+",事件："+eventType);
			return;
		}
		logUtil.displayInfo("调用一次通用分诊大屏【" + siteInfos + "】");
		brdBP.sendSiteMsg(siteInfos);
	}
	
	/**
	 * 验证事件
	 * @param event 事件
	 * @throws BizException
	 */
	private void validate(IBusinessEvent event) throws BizException{
		if(!IEnEventConst.EVENT_SOURCE_EN_ALL_QUE.equalsIgnoreCase(event.getSourceID())){
			throw new BizException(IEnMsgConst.ERROR_LISTENER_NOT_MATCH_EVENT);
		}		
	}
}
