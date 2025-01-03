package iih.en.que.s.listener;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.util.DateTimeUtils;
import iih.en.comm.util.EnLogUtil;
import iih.en.pv.pub.listener.IDrugQue4DisplayListener;
import iih.en.que.board.d.EnBrdCallDO;
import iih.en.que.board.d.EnBrdSiteDO;
import iih.en.que.dto.d.AllQue4EsDTO;
import iih.en.que.s.event.bp.SendDrugSynthesizeInfoBP;
import iih.en.que.s.event.bp.WrapObj2DrugQue4BrdBP;
import iih.en.que.s.listener.bp.SendDrugBrdMsgBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.appfw.businessevent.IBusinessEvent;
/***
 * 药房窗口上屏集成平台监听器
 * @author fanlq
 *
 */
@Service(serviceInterfaces={IDrugQue4DisplayListener.class}, binding=Binding.JSONRPC)
public class DrugQue4DisplayListener implements IDrugQue4DisplayListener{

	/**
	 * 执行
	 */
	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		EnLogUtil.getInstance().displayInfo("接收事件: " + event.getEventType()); 
		//1、验证事件，是否匹配
		this.validate(event);

		//2、包装显示所需结构
		BusinessUserObj bizUserObj = (BusinessUserObj)event.getUserObject();
		AllQue4EsDTO eventSourceDTO = (AllQue4EsDTO)bizUserObj.getUserObj();
		//3.发送上屏消息
		this.sendBrdInfo(eventSourceDTO, event.getEventType());	
	}
	/***
	 * 发送大屏消息
	 * @author fanlq 
	 * @param opQue4EsDTO
	 * @param eventType
	 * @throws BizException
	 */
	@Override
	public void sendBrdInfo(AllQue4EsDTO allQue4EsDTO,String eventType)
			throws BizException {
		EnLogUtil logUtil =EnLogUtil.getInstance();
		String nowDate = DateTimeUtils.getNow();
		SendDrugSynthesizeInfoBP bp = new SendDrugSynthesizeInfoBP();
		try{
			logUtil.logInfo("上屏事件： " + eventType);
			Boolean res = false;
			switch (eventType) {
		//case IEnEventConst.EVENT_DRUG_ONLIN:// 上线
	    //case IEnEventConst.EVENT_DRUG_OFFLIN:// 下线
		case IEnEventConst.EVENT_DRUG_SIGNIN:// 分派窗口
		case IEnEventConst.EVENT_DRUG_DISPENSING:// 发药
		case IEnEventConst.EVENT_DRUG_CALLNOARRIVAL:// 叫号未到
		case IEnEventConst.EVENT_DRUG_DOSAGE:// 配药
			logUtil.logInfo("调用一次药房窗口大屏，时间："+nowDate);
			logUtil.logInfo("drugsiteInfo:");
			logUtil.logInfo("接收到的药房消息："+allQue4EsDTO);
			res = this.sendBrdInfomation(allQue4EsDTO,eventType);
			logUtil.logInfo("调用一次药房窗口结果：" + res);
			if(!res){
				logUtil.logError("调用药房大屏");
				logUtil.logError("drugsiteInfo:");
				logUtil.logError("调用药房窗口大屏结果：" + res);
			}
			//调用药房综合大屏站点消息
			res = bp.sendDrugSiteMsg(allQue4EsDTO,eventType);
			logUtil.logInfo("调用一次药房综合大屏站点消息结果：" + res);
			break;
		case IEnEventConst.EVENT_DRUG_ONLIN:// 上线
	    case IEnEventConst.EVENT_DRUG_OFFLIN:// 下线
			//调用药房综合大屏站点消息
			res = bp.sendDrugSiteMsg(allQue4EsDTO,eventType);
			logUtil.logInfo("调用一次药房综合大屏站点消息结果：" + res);
	    	break;
		case IEnEventConst.EVENT_DRUG_CALLNUM:// 叫号
			logUtil.logInfo("调用一次药房窗口大屏，时间："+nowDate);
			logUtil.logInfo("drugsiteInfo:");
			logUtil.logInfo("接收到的药房消息："+allQue4EsDTO);
			res = this.sendBrdInfomation(allQue4EsDTO,eventType);
			logUtil.logInfo("调用一次药房窗口结果：" + res);
			if(!res){
				logUtil.logError("调用药房大屏");
				logUtil.logError("drugsiteInfo:");
				logUtil.logError("调用药房窗口大屏结果：" + res);
			}
			logUtil.logInfo("调用药房窗口叫号，时间："+nowDate);
			logUtil.logInfo("drugcallInfo:");
			logUtil.logInfo("接收到的药房消息："+allQue4EsDTO);
			res = this.sendBrdCallInfomation(allQue4EsDTO,eventType);
			logUtil.logInfo("调用药房窗口叫号结果：" + res);
			if(!res){
				logUtil.logError("调用药房窗口叫号");
				logUtil.logError("drugcallInfo:");
				logUtil.logError("调用药房窗口叫号结果：" + res);
			}
			//调用药房综合大屏叫号消息
			res = bp.sendDrugCallMsg(allQue4EsDTO,eventType);
			logUtil.logInfo("调用一次药房综合大屏叫号消息结果：" + res);
			//调用药房综合大屏站点消息
			res = bp.sendDrugSiteMsg(allQue4EsDTO,eventType);
			logUtil.logInfo("调用一次药房综合大屏站点消息结果：" + res);
			break;
		}
		}catch(Exception e){
			logUtil.logError("上屏出错:"+e);
		}
	}

	/***
	 * 发送大屏站点信息
	 * @author fanlq 2017年12月27日
	 * @param opQue4EsDTO
	 * @param infoType -信息类型
	 * @return
	 * @throws BizException
	 */
	public Boolean sendBrdInfomation(AllQue4EsDTO allQue4EsDTO,String eventType) throws BizException {
		WrapObj2DrugQue4BrdBP bp = new WrapObj2DrugQue4BrdBP();
		EnBrdSiteDO[] enBrdSiteDOs = bp.setBrdSiteInfo(allQue4EsDTO,eventType);
		//setEmptyString(enBrdSiteDOs);
		new SendDrugBrdMsgBP().sendSiteMsg(enBrdSiteDOs);
		return true;
	}

	/***
	 * 发送大屏叫号信息
	 * @author fanlq 2017年12月27日
	 * @param opQue4EsDTO
	 * @param infoType -信息类型
	 * @return
	 * @throws BizException
	 */
	public Boolean sendBrdCallInfomation(AllQue4EsDTO allQue4EsDTO,String eventType) throws BizException {
		WrapObj2DrugQue4BrdBP bp = new WrapObj2DrugQue4BrdBP();
		EnBrdCallDO[] enBrdCallDOs = bp.setBrdCallInfo(allQue4EsDTO,eventType);
		new SendDrugBrdMsgBP().sendCallMsg(enBrdCallDOs);
		return true;
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
	/****
	 * 将NULL字符串转为空白字符串，防止屏幕上显示null
	 * @param enBrdSiteDOs
	 */
	private void setEmptyString(EnBrdSiteDO[] enBrdSiteDOs){
		if(enBrdSiteDOs != null && enBrdSiteDOs.length > 0 ){
			for(EnBrdSiteDO enBrdSiteDO : enBrdSiteDOs ){
				if(enBrdSiteDO.getAddr_brd() == null){
					enBrdSiteDO.setAddr_brd("");
				}
				if(enBrdSiteDO.getEu_status() == null){
					enBrdSiteDO.setEu_status(5);
				}
				if(enBrdSiteDO.getName_curpat() == null){
					enBrdSiteDO.setName_curpat("");
				}
				if(enBrdSiteDO.getNo_curpat()== null){
					enBrdSiteDO.setNo_curpat("");
				}
			}
		}
	}
}
