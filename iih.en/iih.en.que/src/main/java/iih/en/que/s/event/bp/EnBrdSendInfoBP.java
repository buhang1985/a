package iih.en.que.s.event.bp;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.bd.fc.quesite.i.IQuesiteRService;
import iih.en.comm.util.EnLogUtil;
import iih.en.comm.validator.EnValidator;
import iih.en.que.board.d.BrdStatusEnum;
import iih.en.que.board.d.EnBrdCallDO;
import iih.en.que.board.d.EnBrdSiteDO;
import iih.en.que.dto.d.OpQue4EsDTO;
import iih.en.que.s.bp.op.SetBrdOfflineBP;
import iih.en.que.s.listener.bp.SendBrdMsgBP;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 发送IIH系统大屏消息
 * @author fanlq
 *
 */
public class EnBrdSendInfoBP {

	/***
	 * 发送大屏消息
	 * @author fanlq 2017年12月27日
	 * @param opQue4EsDTO
	 * @param eventType
	 * @throws BizException
	 */
	public void sendBrdInfo(OpQue4EsDTO opQue4EsDTO, String eventType)
			throws BizException {
		EnLogUtil logUtil =EnLogUtil.getInstance();
		try{
			logUtil.logInfo("上屏事件： " + eventType);
			Boolean res = false;
			switch (eventType) {
		case IEnEventConst.EVENT_EN_OP_DOC_ONLINE:// 医生上线
		case IEnEventConst.EVENT_EN_OP_SIGNIN:// 到诊
		case IEnEventConst.EVENT_EN_OP_CANC_SIGNIN:// 取消到诊
		case IEnEventConst.EVENT_EN_OP_TRIAGE:// 分诊
		case IEnEventConst.EVENT_EN_OP_CANC_TRIAGE:// 取消分诊	
		case IEnEventConst.EVENT_EN_OP_PASSNUM:// 过号		
		case IEnEventConst.EVENT_EN_OP_DOC_ACPT:// 接诊
		case IEnEventConst.EVENT_EN_OP_DOC_CANC_ACPT:// 取消接诊
		case IEnEventConst.EVENT_EN_OP_DOC_OFFLINE:// 医生下线
		case IEnEventConst.EVENT_EN_OP_CANC_REG://退号
		case IEnEventConst.EVENT_EN_OP_DIAGEND:// 诊毕
		case IEnEventConst.EVENT_EN_OP_DIAGNOSECONTINUE://待回诊
		case IEnEventConst.EVENT_EN_OP_CANC_CALLNUM:// 取消叫号
			logUtil.logInfo("调用一次分诊大屏");
			logUtil.logInfo("siteInfo:"+opQue4EsDTO);
			res = this.sendBrdInfomation(opQue4EsDTO,eventType);
			logUtil.logInfo("调用一次分诊大屏结果：" + res);
			if(!res){
				logUtil.logError("调用一次分诊大屏");
				logUtil.logError("siteInfo:");
				logUtil.logError("调用一次分诊大屏结果：" + res);
			}	
			break;
		case IEnEventConst.EVENT_EN_OP_CALLNUM:// 叫号		
			logUtil.logInfo("调用叫号");
			logUtil.logInfo("callInfo:"+opQue4EsDTO);
			res = this.sendBrdCallInfomation(opQue4EsDTO,eventType);
			logUtil.logInfo("调用叫号结果：" + res);
			if(!res){
				logUtil.logError("调用叫号");
				logUtil.logError("callInfo:"+opQue4EsDTO);
				logUtil.logError("调用叫号结果：" + res);
			}
			logUtil.logInfo("调用一次分诊大屏");
			logUtil.logInfo("siteInfo:"+opQue4EsDTO);
			res = this.sendBrdInfomation(opQue4EsDTO,eventType);
			logUtil.logInfo("调用一次分诊大屏结果：" + res);
			if(!res){
				logUtil.logError("调用一次分诊大屏");
				logUtil.logError("siteInfo:"+opQue4EsDTO);
				logUtil.logError("调用一次分诊大屏结果：" + res);
			}	
			break;
		}
		}catch(Exception e){
			try{
				//如果下线出错，则强制下屏
				this.setBrdOfflineBP(opQue4EsDTO,eventType);
			}catch(Exception e0)
			{
				logUtil.logError("强制下线出错！");
			}
			logUtil.logError("上屏出错:出错事件编码/"+eventType+"/t返回值/"+e+"/站点id/"+opQue4EsDTO.getId_que_site()+"/队列id/"+opQue4EsDTO.getId_que());
		}
	}
	/***
	 * 强制下屏
	 * @param opQue4EsDTO
	 * @param eventType
	 * @throws BizException
	 */
	private void setBrdOfflineBP(OpQue4EsDTO opQue4EsDTO, String eventType) throws BizException{
		if(IEnEventConst.EVENT_EN_OP_DOC_OFFLINE.equals(eventType) && !EnValidator.isEmpty(opQue4EsDTO.getId_que_site())){
			IQuesiteRService service = ServiceFinder.find(IQuesiteRService.class);
			QueSiteDO queSiteDO = service.findById(opQue4EsDTO.getId_que_site());
			EnBrdSiteDO brdSiteDO = new EnBrdSiteDO();
			brdSiteDO.setCode(queSiteDO.getCode());
			brdSiteDO.setEu_status(BrdStatusEnum.DEL);
			SetBrdOfflineBP bp = new SetBrdOfflineBP();
			bp.exec(brdSiteDO);
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
	private Boolean sendBrdInfomation(OpQue4EsDTO opQue4EsDTO,String eventType) throws BizException {
		WrapObj2OpQue4EnBrdBP bp = new WrapObj2OpQue4EnBrdBP();
		EnBrdSiteDO[] enBrdSiteDOs = bp.setBrdSiteInfo(opQue4EsDTO,eventType);
		new SendBrdMsgBP().sendSiteMsg(enBrdSiteDOs);
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
	private Boolean sendBrdCallInfomation(OpQue4EsDTO opQue4EsDTO,String eventType) throws BizException {
		WrapObj2OpQue4EnBrdBP bp = new WrapObj2OpQue4EnBrdBP();
		EnBrdCallDO[] enBrdCallDOs = bp.setBrdCallInfo(opQue4EsDTO,eventType);
		new SendBrdMsgBP().sendCallMsg(enBrdCallDOs);
		return true;
	}
	
}
