package iih.sc.comm;

import iih.sc.apt.dto.d.MtApt4SmsDTO;
import iih.sc.apt.dto.d.OpApt4SmsDTO;
import xap.lui.message.messageconfig.i.SendMessageService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 预约短信消息帮助类
 * @author yank
 *
 */
public class ScSmsMsgUtils {
	/**
	 * 生成消息
	 * @param template 消息模板编码
	 * @param aptDTO 预约DTO
	 * @return
	 * @throws BizException
	 */
	public static String generateMsg(String template,OpApt4SmsDTO aptDTO) throws BizException{
//		Object result = XapMsgTplAPI.tplTranslatorWithCode(template, null, aptDTO);
		//采用新方式
		SendMessageService sendMsgSv = ServiceFinder.find(SendMessageService.class);
		String msg = sendMsgSv.getMessage(template, null, new OpApt4SmsDTO[]{aptDTO});
		return msg;
	}
	
	/**
	 * 生成消息
	 * @param template 消息模板编码
	 * @param aptDTO 预约DTO
	 * @return
	 * @throws BizException
	 */
	public static String generateMsg(String template,MtApt4SmsDTO aptDTO) throws BizException{
//		Object result = XapMsgTplAPI.tplTranslatorWithCode(template, null, aptDTO);
		//采用新方式
		SendMessageService sendMsgSv = ServiceFinder.find(SendMessageService.class);
		String msg = sendMsgSv.getMessage(template, null, new MtApt4SmsDTO[]{aptDTO});
		return msg;
	}
}
