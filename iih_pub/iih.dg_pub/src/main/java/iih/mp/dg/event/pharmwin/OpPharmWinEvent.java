package iih.mp.dg.event.pharmwin;

import org.apache.commons.lang.StringUtils;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.bd.bc.event.pub.IMpEventConst;
import iih.en.que.dto.d.AllQue4EsDTO;
import iih.mp.dg.i.IMpDgLogService;
import iih.mp.dg.op.dispdrug.d.PharmacyWindowDTO;
import xap.mw.core.data.BizException;
import xap.mw.log.logging.Level;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 门诊药房窗口事件
 * 
 * @author hao_wu 2018年8月17日
 *
 */
public class OpPharmWinEvent {
	/***
	 * 药房队列事件
	 * 
	 * @param quesiteId
	 * @param queId
	 * @param event
	 * @throws BizException
	 */
	public static void invoke(String quesiteId, String eventTp) throws BizException {
		if (StringUtils.isEmpty(eventTp))
			return;
		PharmacyWindowDTO pharmacyWindowDTO = new PharmacyWindowDTO();
		pharmacyWindowDTO.setId_site(quesiteId);

		invokeEvent(eventTp, pharmacyWindowDTO);
	}

	/**
	 * 调用事件
	 * 
	 * @param eventTp
	 * @param pharmacyWindowDTO
	 * @throws BizException
	 */
	private static void invokeEvent(String eventTp, PharmacyWindowDTO pharmacyWindowDTO) throws BizException {

		writeLog(eventTp, pharmacyWindowDTO);

		AllQue4EsDTO allQue4EsDTO = new AllQue4EsDTO();
		allQue4EsDTO.setId_quesite(pharmacyWindowDTO.getId_site());

		eventTp = convertToEnEventTp(eventTp);

	}

	/**
	 * 转换到就诊事件类型
	 * 
	 * @param eventTp
	 * @return
	 */
	private static String convertToEnEventTp(String eventTp) {
		String enEventTp = eventTp;
		switch (eventTp) {
		case IMpEventConst.EVENTTP_PHARMWIN_ONLINE:
			enEventTp = IEnEventConst.EVENT_DRUG_ONLIN;
			break;
		case IMpEventConst.EVENTTP_PHARMWIN_OFFLINE:
			enEventTp = IEnEventConst.EVENT_DRUG_OFFLIN;
			break;
		case IMpEventConst.EVENTTP_PHARMWIN_CALLNUM:
			enEventTp = IEnEventConst.EVENT_DRUG_CALLNUM;
			break;
		case IMpEventConst.EVENTTP_PHARMWIN_GETPRES:
			enEventTp = IEnEventConst.EVENT_DRUG_SIGNIN;
			break;
		case IMpEventConst.EVENTTP_PHARMWIN_DISP:
			enEventTp = IEnEventConst.EVENT_DRUG_DISPENSING;
			break;

		default:
			enEventTp = null;
			break;
		}
		return enEventTp;
	}

	/**
	 * 写日志
	 * 
	 * @param eventTp
	 * @param pharmacyWindowDTO
	 */
	private static void writeLog(String eventTp, PharmacyWindowDTO pharmacyWindowDTO) {
		String log = String.format("发送药房窗口队列事件: %s;发送数据：%s.", eventTp, pharmacyWindowDTO);

		IMpDgLogService logService = ServiceFinder.find(IMpDgLogService.class);
		logService.log(log, Level.INFO);
	}
}
