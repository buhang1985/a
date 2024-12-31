package iih.bl.comm.s.bp;

import com.sms.i.ISendSMSService;

import iih.bl.comm.log.BLThirdItfLogger;
import iih.bl.itf.dto.blsendsmsdto.d.BlSendSmsDTO;
import iih.sc.pub.ResultBean;
import xap.lui.message.messageconfig.i.SendMessageService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 发生短信模板消息
 * @author zhangxin
 * @date 2019年8月1日
 */
public class BlSendSmsMsgBP {
	/**
	 * 发生短信模板通知
	 * @param mobiles 手机号
	 * @param msgCode 消息编码
	 * @param smsDto  内容dto
	 * @return
	 * @throws BizException
	 */
	public ResultBean exec(String mobiles,String msgCode, BlSendSmsDTO smsDto) throws BizException {
		//验证输入参数
		this.validator(mobiles,msgCode, smsDto);
		BLThirdItfLogger.info("短信消息 前  手机号:"+mobiles+"消息id:"+msgCode+"内容:"+smsDto.serializeJson());
	    //获取消息内容
		SendMessageService sendMsgSv = ServiceFinder.find(SendMessageService.class);
		String msg = sendMsgSv.getMessage(msgCode, null, new BlSendSmsDTO[]{smsDto});
		//发生消息
		ISendSMSService sendService = ServiceFinder.find(ISendSMSService.class);
		int result = sendService.sendMessage(mobiles, msg, msgCode);
		ResultBean resultBean = parseResult(result);
		BLThirdItfLogger.info("短信消息 后  手机号:"+mobiles+"消息id:"+msgCode+"内容:"+msg+"结果："+resultBean.getMsg());
		//转化返回值
		return resultBean;
	}
    /**
     * 验证
     * @param mobiles
     * @param msgCode
     * @param smsDto
     * @throws BizException
     */
	private void validator(String mobiles, String msgCode, BlSendSmsDTO smsDto) throws BizException {
		if(StringUtil.isEmpty(mobiles)){
			throw new BizException("发生短信消息手机号为空");
		}
		if(StringUtil.isEmpty(msgCode)){
			throw new BizException("发生短信消息手消息模板为空");
		}
		if(smsDto==null){
			throw new BizException("发生短信消息手消息内容dto为空");
		}
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
