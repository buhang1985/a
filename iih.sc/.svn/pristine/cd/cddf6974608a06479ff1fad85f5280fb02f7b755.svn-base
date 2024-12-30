package iih.sc.apt.s.listener.bp;

import com.sms.i.ISendSMSService;

import iih.sc.comm.ScValidator;
import iih.sc.pub.ResultBean;
import xap.lui.message.messageconfig.i.SendMessageService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 发送短信BP
 * @author yank
 *
 */
public class SendSmsMsgBP {
	/**
	 * 向一组手机号发送短信
	 * @param mobiles 一个或者多个手机号，用逗号分开
	 * @param msgCode 消息编码（标识）
	 * @param msg 消息内容	 
	 * @throws BizException
	 */
	public ResultBean exec(String mobiles,String msgCode,String msg) throws BizException{
		if(ScValidator.isEmptyIgnoreBlank(mobiles))
			return null;
		ISendSMSService sendService = ServiceFinder.find(ISendSMSService.class);
		int result = sendService.sendMessage(mobiles, msg, msgCode);
		return parseResult(result);
	}
	
	/***
	 * 修改短信接口
	 * @author fanlq 
	 * @param mobiles
	 * @param message
	 * @param sysid
	 * @param patient_id
	 * @param admiss_times
	 * @param admiss_dept
	 * @param doctor_id
	 * @param is_mz_flag
	 * @param remarks
	 * @return
	 * @throws BizException
	 */
	public String exec1(String mobiles, String message, String sysid,
			String patient_id, String admiss_times,String admiss_dept,String doctor_id, String is_mz_flag, String remarks) throws BizException{
		if(ScValidator.isEmptyIgnoreBlank(mobiles))
			return null;
		SendMessageService service = ServiceFinder.find(SendMessageService.class);
		String result = service.sendMessageToPatient(mobiles, message, sysid, patient_id, admiss_times, admiss_dept, doctor_id, is_mz_flag, remarks);
		return result;
	}
	/**
	 * 
	 * 0: 成功
	 * 1: 部分号码失败
	 * 2：参数不正确
	 * 3：短信内容太长，不能少于5个字，不能超过1000字
	 * 4：场景ID不匹配或者场景被禁用
	 * 5：发送短信时间段不符合
	 * 6：该场景调用接口过频
	 * 7：该场景发送短信过频
	 * 8：该场景向某一手机号发送短信过频
	 * 9：该场景当天发送短信过量
	 * 10:未指定医院
	 * -1:其它错误
	 */
	private ResultBean parseResult(int result){	
		String msg = "";
		switch(result){
		case 0:
			msg = "成功";
			break;
		case 1:
			msg = "部分号码失败";
			break;
		case 2:
			msg = "参数不正确";
			break;
		case 3:
			msg= "短信内容太长，不能少于5个字，不能超过1000字";
			break;
		case 4:
			msg = "场景ID不匹配或者场景被禁用";
			break;
		case 5:
			msg = "发送短信时间段不符合";
			break;
		case 6:
			msg = "该场景调用接口过频";
			break;
		case 7:
			msg = "该场景发送短信过频";
			break;
		case 8:
			msg = "该场景向某一手机号发送短信过频";
			break;
		case 9:
			msg = "该场景当天发送短信过量";
			break;
		case 10:
			msg = "未指定医院";
			break;
		case -1:
			msg = "其它错误";
			break;
		default:
			msg = "其它错误";
			break;
		}
		
		ResultBean resultBean = new ResultBean();
		resultBean.setFlag(String.valueOf(result));
		resultBean.setMsg(msg);
		return resultBean;
	}
}
