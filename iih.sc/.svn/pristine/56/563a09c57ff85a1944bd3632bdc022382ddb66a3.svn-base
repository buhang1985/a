package iih.sc.apt.s.listener.bp;

import iih.sc.apt.dto.d.OpApt4SmsDTO;
import iih.sc.comm.ScSmsMsgUtils;
import iih.sc.pub.IScSmsConst;
import iih.sc.pub.ResultBean;
import xap.mw.core.data.BizException;
import xap.mw.log.logging.Logger;

/**
 * 发送门诊短信通知
 * 
 * @author yank
 *
 */
public class SendOpSmsMsgBP {
	/**
	 * 短信通知
	 * 
	 * @param mobiles 手机号码，多个中间用逗号隔开
	 * @param msgCode 消息编码
	 * @param aptDTO 门诊预约信息DTO
	 * @throws BizException
	 * @author yank
	 */
	public ResultBean exec(String mobiles,String msgCode, OpApt4SmsDTO aptDTO) throws BizException {
		String msg = ScSmsMsgUtils.generateMsg(msgCode, aptDTO);
		Logger.info("短信消息——" + msg);
		SendSmsMsgBP sendBP = new SendSmsMsgBP();
		return sendBP.exec(mobiles,msgCode, msg);
	}

	/****
	 * 发送短信接口修改
	 * 
	 * @author fanlq 
	 * @param mobiles 手机号码，多个中间用逗号隔开
	 * @param message 消息
	 * @param sysid 系统id = KD68J0
	 * @param patient_id 患者id
	 * @param admiss_times 就诊次数
	 * @param admiss_dept 就诊科室编码
	 * @param doctor_id 接诊医生工号
	 * @param is_mz_flag 门诊/住院标识
	 * @param remarks 扩展字段
	 * @return
	 * @throws BizException
	 */
	public String exec1(String mobiles,String msgCode, OpApt4SmsDTO aptDTO) throws BizException {
		String msg = ScSmsMsgUtils.generateMsg(msgCode, aptDTO);
		Logger.info("短信消息——" + msg);
		String time_op = null;
		if(aptDTO != null){
			if(aptDTO.getTime_op() != null){
				time_op = aptDTO.getTime_op().toString();
			}
			SendSmsMsgBP sendBP = new SendSmsMsgBP();
			return sendBP.exec1(mobiles, msg,msgCode, aptDTO.getCode_pat(), time_op, aptDTO.getCode_dep(), aptDTO.getCode_doc(), aptDTO.getCode_enttp(), null);		
		}else 
			return null;
		}
}
