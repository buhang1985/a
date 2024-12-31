package iih.en.que.s.event.bp;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.en.comm.util.EnLogUtil;
import iih.en.comm.validator.EnValidator;
import iih.en.que.dto.d.OpQue4DispDTO;
import iih.en.que.dto.d.OpQue4EsDTO;
import xap.mw.core.annotation.Reference;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

import com.wafersystems.ph.yf.webservice.IWaferServicePortType;
/***
 * 发送威发大屏消息
 * @author Administrator
 *
 */
public class WaferSendInfoBP {
	
	@Reference(binding = Binding.WS)
	IWaferServicePortType waferService;
	
	/**
	 * 发送上屏消息
	 * 
	 * @param opQue4EsDTO
	 * @param eventType
	 * @throws BizException
	 */
	public void sendWfInfo(OpQue4EsDTO opQue4EsDTO, String eventType)
			throws BizException {
		WrapObj2OpQue4DispBP wrapBp = new WrapObj2OpQue4DispBP();
		OpQue4DispDTO displayDTO = wrapBp.wrap(opQue4EsDTO, eventType);
		try {
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
			case IEnEventConst.EVENT_EN_OP_CANC_REG:// 退号
				// 监听诊毕事件，fanlq，2017-08-18
			case IEnEventConst.EVENT_EN_OP_DIAGEND:// 诊毕
				// 监听待回诊事件，fanlq，2017-09-01
			case IEnEventConst.EVENT_EN_OP_DIAGNOSECONTINUE:// 待回诊
				sendInfo(wrapBp, displayDTO, eventType);
				sendSecondInfo(wrapBp, displayDTO, eventType);
				break;
			case IEnEventConst.EVENT_EN_OP_CALLNUM:// 叫号
			case IEnEventConst.EVENT_EN_OP_CANC_CALLNUM:// 取消叫号
				sendCallInfo(wrapBp, displayDTO, eventType);
				sendInfo(wrapBp, displayDTO, eventType);
				sendSecondInfo(wrapBp, displayDTO, eventType);
				break;
			}
		} catch (Exception e) {
			EnLogUtil logUtil = EnLogUtil.getInstance();
			logUtil.logError("上屏出错:", e);
		}
	}
	/**
	 * 更新分诊信息
	 * 
	 * @param displayDTO
	 * @param eventType
	 */
	private void sendInfo(WrapObj2OpQue4DispBP wrapBp, OpQue4DispDTO displayDTO, String eventType){
		String[] siteInfos = wrapBp.toInfomation(displayDTO, eventType);
		if(EnValidator.isEmpty(siteInfos))
			return;
		EnLogUtil logUtil = EnLogUtil.getInstance();
		for (String siteInfo : siteInfos) {
			logUtil.displayInfo("调用一次分诊大屏【" + siteInfo + "】");
			Boolean res = waferService.setInfomation(siteInfo);
			logUtil.displayInfo("调用一次分诊大屏结果【" + res+ "】");
			
		}
	}
	/**
	 * 更新二次分诊信息
	 * 
	 * @param displayDTO
	 * @param eventType
	 */
	private void sendSecondInfo(WrapObj2OpQue4DispBP wrapBp, OpQue4DispDTO displayDTO, String eventType){
		if (!wrapBp.isSecond(displayDTO))
			return;
		String[] siteInfos = wrapBp.toSecondInfomation(displayDTO,
				eventType);
		if(EnValidator.isEmpty(siteInfos))
			return;
		EnLogUtil logUtil = EnLogUtil.getInstance();
		for (String siteInfo : siteInfos) {
			logUtil.displayInfo("调用二次分诊大屏【" + siteInfo + "】");
			Boolean res = waferService.setSecondInfomation(siteInfo);
			logUtil.displayInfo("调用二次分诊大屏结果【" + res+ "】");		
		}
	}
	/**
	 * 更新二次分诊信息
	 * 
	 * @param displayDTO
	 * @param eventType
	 */
	private void sendCallInfo(WrapObj2OpQue4DispBP wrapBp, OpQue4DispDTO displayDTO, String eventType){
		String[] callInfos = wrapBp.toCallInfomation(displayDTO, eventType);
		if(EnValidator.isEmpty(callInfos))
			return;
		EnLogUtil logUtil = EnLogUtil.getInstance();
		for (String callInfo : callInfos) {
			logUtil.displayInfo("调用叫号【" + callInfo + "】");
			Boolean res = waferService.setInfomation(callInfo);
			logUtil.displayInfo("调用叫号结果【" + res+ "】");

		}
	}
}
