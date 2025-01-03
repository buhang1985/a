package iih.en.que.s.listener;

import org.springframework.transaction.TransactionStatus;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.util.EnLogUtil;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.pub.listener.IEnAllQue4DisplayListener;
import iih.en.que.board.d.BrdtpEnum;
import iih.en.que.board.d.EnBrdCallDO;
import iih.en.que.board.d.EnBrdDO;
import iih.en.que.board.d.EnBrdSiteDO;
import iih.en.que.board.i.IEnbrddoMDORService;
import iih.en.que.board.i.IEnbrdsitedoCudService;
import iih.en.que.board.i.IEnbrdsitedoRService;
import iih.en.que.dto.d.AllQue4EsDTO;
import iih.en.que.s.event.bp.WrapObj2AllQue4EnBrdBP;
import iih.en.que.s.listener.bp.SendBrdMsgBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.appfw.businessevent.IBusinessEvent;

@Service(serviceInterfaces={IEnAllQue4DisplayListener.class}, binding=Binding.JSONRPC)
public class EnAllQue4DisplayListener implements IEnAllQue4DisplayListener {
	/**
	 * 执行
	 */
	public void doAction(IBusinessEvent event) throws BizException {
		EnLogUtil.getInstance().displayInfo("接收事件: " + event.getEventType()); 
		//1、验证事件，是否匹配
		this.validate(event);
		//2、包装显示所需结构
		BusinessUserObj bizUserObj = (BusinessUserObj)event.getUserObject();
		AllQue4EsDTO eventSourceDTO = (AllQue4EsDTO)bizUserObj.getUserObj();
		//3.发送上屏消息
		this.sendWfInfo(eventSourceDTO, event.getEventType());	
	}
	/**
	 * 发送上屏消息
	 * 
	 * @param opQue4EsDTO
	 * @param eventType
	 * @throws BizException
	 */
	@Override
	public void sendWfInfo(AllQue4EsDTO allQue4EsDTO, String eventType)
			throws BizException {
		Integer brdType = this.getBrdType(allQue4EsDTO);
		if(brdType != null && BrdtpEnum.DRUGBRD.equals(brdType)){
			this.setDrugAllQueBrd(allQue4EsDTO, eventType);
		}else{
			EnLogUtil logUtil =EnLogUtil.getInstance();
			try{
				logUtil.logInfo("通用队列上屏事件： " + eventType);
				Boolean res = false;
				switch (eventType) {
			case IEnEventConst.EVENT_EN_ALL_DOC_ONLINE:// 医生上线
			case IEnEventConst.EVENT_EN_ALL_DOC_OFFLINE:// 医生下线
			case IEnEventConst.EVENT_EN_ALL_DOC_PAUSE:// 暂停
			case IEnEventConst.EVENT_EN_ALL_DOC_CONTINUE:// 继续
			case IEnEventConst.EVENT_EN_ALL_TRIAGE:// 分诊
			case IEnEventConst.EVENT_EN_ALL_CANC_TRIAGE:// 取消分诊	
			case IEnEventConst.EVENT_EN_ALL_PASSNUM:// 过号		
			case IEnEventConst.EVENT_EN_ALL_DOC_ACPT:// 处置
			case IEnEventConst.EVENT_EN_ALL_DOC_CANC_ACPT:// 取消处置
			case IEnEventConst.EVENT_EN_ALL_DIAGEND:// 处置完成
				logUtil.logInfo("调用一次通用队列分诊大屏");
				logUtil.logInfo("allsiteInfo:");
				res = this.sendBrdInfomation(allQue4EsDTO,eventType);
				logUtil.logInfo("调用一次通用队列分诊大屏结果：" + res);
				if(!res){
					logUtil.logError("调用一次通用队列分诊大屏");
					logUtil.logError("allsiteInfo:");
					logUtil.logError("调用一次通用队列分诊大屏结果：" + res);
				}	
				break;
			case IEnEventConst.EVENT_EN_ALL_CALLNUM:// 叫号
			case IEnEventConst.EVENT_EN_ALL_SELECTED_CALLNUM://选择叫号
				logUtil.logInfo("调用通用队列叫号");
				logUtil.logInfo("allcallInfo:");
				res = this.sendBrdCallInfomation(allQue4EsDTO,eventType);
				logUtil.logInfo("调用通用队列叫号结果：" + res);
				if(!res){
					logUtil.logError("调用通用队列叫号");
					logUtil.logError("allcallInfo:");
					logUtil.logError("调用通用队列叫号结果：" + res);
				}
				logUtil.logInfo("调用一次通用队列分诊大屏");
				logUtil.logInfo("allsiteInfo:");
				res = this.sendBrdInfomation(allQue4EsDTO,eventType);
				logUtil.logInfo("调用一次通用队列分诊大屏结果：" + res);
				if(!res){
					logUtil.logError("调用一次通用队列分诊大屏");
					logUtil.logError("allsiteInfo:");
					logUtil.logError("调用一次通用队列分诊大屏结果：" + res);
				}
				break;
			}
				}catch(Exception e){
				logUtil.logError("上屏出错:"+e);
			}
		}
	}
	
	private void setDrugAllQueBrd(AllQue4EsDTO allQue4EsDTO, String eventType) throws BizException{
		EnLogUtil logUtil =EnLogUtil.getInstance();
		try{
			logUtil.logInfo("通用队列上屏事件： " + eventType);
			Boolean res = false;
			switch (eventType) {
			case IEnEventConst.EVENT_EN_ALL_SIGNIN:// 到诊
			case IEnEventConst.EVENT_EN_ALL_CANC_SIGNIN:// 取消到诊
			case IEnEventConst.EVENT_EN_ALL_TRIAGE:// 分诊
			case IEnEventConst.EVENT_EN_ALL_CANC_TRIAGE:// 取消分诊	
			case IEnEventConst.EVENT_EN_ALL_PASSNUM:// 过号		
			case IEnEventConst.EVENT_EN_ALL_DOC_ACPT:// 处置
			case IEnEventConst.EVENT_EN_ALL_DOC_CANC_ACPT:// 取消处置
			case IEnEventConst.EVENT_EN_ALL_DIAGEND:// 处置完成
				logUtil.logInfo("调用一次通用队列分诊大屏");
				logUtil.logInfo("allsiteInfo:");
				res = this.sendBrdInfomation(allQue4EsDTO,eventType);
				logUtil.logInfo("调用一次通用队列分诊大屏结果：" + res);
				if(!res){
					logUtil.logError("调用一次通用队列分诊大屏");
					logUtil.logError("allsiteInfo:");
					logUtil.logError("调用一次通用队列分诊大屏结果：" + res);
				}	
				break;
			case IEnEventConst.EVENT_EN_ALL_CALLNUM:// 叫号
				res = this.sendBrdCallInfomation(allQue4EsDTO,eventType);
				break;
			case IEnEventConst.EVENT_EN_ALL_SELECTED_CALLNUM://选择叫号
				res = this.sendBrdInfomation(allQue4EsDTO,IEnEventConst.EVENT_DRUG_ONLIN);
				res = this.sendBrdCallInfomation(allQue4EsDTO,eventType);
				res = this.sendBrdInfomation(allQue4EsDTO,IEnEventConst.EVENT_DRUG_OFFLIN);
			}
		}catch(Exception e){
			logUtil.logError("上屏出错:"+e);
		}
	}
	/***
	 * 发送大屏站点信息
	 * @param allQue4EsDTO
	 * @param infoType -信息类型
	 * @return
	 * @throws BizException
	 */
	private Boolean sendBrdInfomation(AllQue4EsDTO allQue4EsDTO,String eventType) throws BizException {
		Integer brdType = this.getBrdType(allQue4EsDTO);
		if(brdType != null && BrdtpEnum.DRUGBRD.equals(brdType)){
			this.sendDrugBrdSiteInfo(allQue4EsDTO,eventType);
		}else{
			WrapObj2AllQue4EnBrdBP bp = new WrapObj2AllQue4EnBrdBP();
			EnBrdSiteDO[] enBrdSiteDOs = bp.setBrdSiteInfo(allQue4EsDTO,eventType);
			this.updateAllDataArrived(enBrdSiteDOs);//修改所有数据的到诊患者列表
			SendBrdMsgBP brdbp = new SendBrdMsgBP();
				brdbp.sendSiteMsg(enBrdSiteDOs);
			}
		return true;
	}
	/***
	 * 发送大屏叫号信息 
	 * @param allQue4EsDTO
	 * @param infoType -信息类型
	 * @return
	 * @throws BizException
	 */
	private Boolean sendBrdCallInfomation(AllQue4EsDTO allQue4EsDTO,String eventType) throws BizException {
		WrapObj2AllQue4EnBrdBP bp = new WrapObj2AllQue4EnBrdBP();
		EnBrdCallDO[] enBrdCallDOs = bp.setBrdCallInfo(allQue4EsDTO,eventType);
		SendBrdMsgBP brdbp = new SendBrdMsgBP();
		Integer brdType = this.getBrdType(allQue4EsDTO);
		if(brdType != null && BrdtpEnum.DRUGBRD.equals(brdType)){
			this.sendDrugBrdCallInfo(allQue4EsDTO,eventType);
		}else{
			brdbp.sendCallMsg(enBrdCallDOs);
		}
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
	
	/***
	 * 通用分诊上药房大屏-站点
	 * @param allQue4EsDTO
	 * @param eventType
	 * @throws BizException
	 */
	private void sendDrugBrdSiteInfo(AllQue4EsDTO allQue4EsDTO,String eventType) throws BizException{
		DrugQue4DisplayListener bp = new DrugQue4DisplayListener();
		bp.sendBrdInfomation(allQue4EsDTO,eventType);
	}
	/***
	 * 通用分诊上药房大屏-叫号
	 * @param allQue4EsDTO
	 * @param eventType
	 * @throws BizException
	 */
	private void sendDrugBrdCallInfo(AllQue4EsDTO allQue4EsDTO,String eventType) throws BizException{
		DrugQue4DisplayListener bp = new DrugQue4DisplayListener();
		bp.sendBrdCallInfomation(allQue4EsDTO,eventType);
	}
	/***
	 * 
	 * 获取大屏站点类型
	 * @param allQue4EsDTO
	 * @return
	 * @throws BizException
	 */
	private Integer getBrdType(AllQue4EsDTO allQue4EsDTO) throws BizException{
		if(allQue4EsDTO != null && EnValidator.isEmpty(allQue4EsDTO.getAddr_board_ben())){
			return null;
		}
		IEnbrddoMDORService service = ServiceFinder.find(IEnbrddoMDORService.class);
		EnBrdDO[] enBrdDOs = service.find("addr = '"+allQue4EsDTO.getAddr_board_ben()+"'",null, FBoolean.FALSE);
		if(enBrdDOs != null && enBrdDOs.length > 0){
			EnBrdDO enBrdDO = enBrdDOs[0];
			return enBrdDO.getEu_brdtpc();
		}
		return null;
	}

	private Object updateAllDataArrived(final EnBrdSiteDO[] enBrdSiteDOs){
		return TransactionExecutor.executeNewTransaction(new TransactionalOperation<EnBrdSiteDO>() {
			@Override
			public EnBrdSiteDO doInTransaction(TransactionStatus arg0) {
				try {
					if(!EnValidator.isEmpty(enBrdSiteDOs) && !EnValidator.isEmpty(enBrdSiteDOs[0].getAddr_brd()) ){
						IEnbrdsitedoRService rservice = ServiceFinder.find(IEnbrdsitedoRService.class);
						EnBrdSiteDO[] enBrdSites = rservice.find("ADDR_BRD = '"+enBrdSiteDOs[0].getAddr_brd()+"' ", null, FBoolean.FALSE);
						IEnbrdsitedoCudService service = ServiceFinder.find(IEnbrdsitedoCudService.class);
						if(!EnValidator.isEmpty(enBrdSites)){
							for(EnBrdSiteDO rtn : enBrdSites){
								rtn.setNos_arrived(enBrdSiteDOs[0].getNos_arrived());
								rtn.setStatus(DOStatus.UPDATED);
							}
							service.save(enBrdSiteDOs);
						}
					}
				} catch (BizException e) {
					return null;
				}
				return null;
			}
		});
	}
}
