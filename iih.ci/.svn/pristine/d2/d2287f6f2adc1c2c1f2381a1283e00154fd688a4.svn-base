package iih.ci.ord.s.ems.biz.ip.mqmsg;

import java.util.List;
import java.util.Map;

import iih.ci.ord.i.mqmsg.meta.ExecDepWaitConfirmMsgDTO;
import iih.ci.ord.i.mqmsg.meta.IMQMsgTypeConst;
import iih.ci.ord.s.ems.base.BaseMsgReceiveController;
import xap.mw.core.data.BizException;

/**
 * @author daixb
 */
public class CiOrderExecDepMsgReceiveController extends BaseMsgReceiveController{
		
		@Override
		public String getContent(Map<String, Object> arg0) throws BizException {

			List<ExecDepWaitConfirmMsgDTO> msgList = getMessageDataInfo(arg0);
			StringBuilder msgSb = new StringBuilder();
			int index = 1;
			if (msgList != null && msgList.size() > 0) {
				for (ExecDepWaitConfirmMsgDTO o : msgList) {
					if(index == 1) {
						//患者姓名 | 年龄 | 住院号 
						msgSb.append(String.format("患者姓名：%s，年龄： %s，住院号: %s",o.getName_pat(), o.getAge(), o.getCode_amr_ip()));
					}
					if(msgList.size() == 1){
						msgSb.append("，").append(this.getWaitConfirmMsg(o)).append(System.lineSeparator());
					}else{
						msgSb.append(String.format("，(%d) ", index++)).append(this.getWaitConfirmMsg(o)).append(System.lineSeparator());
					}
				}
				return msgSb.toString();
			}
			return null;
		}

		@Override
		public String getDep(Map<String, Object> arg0) throws BizException {
			// TODO:返回消息接收科室
			List<ExecDepWaitConfirmMsgDTO> msgList = getMessageDataInfo(arg0);
			if (msgList != null && msgList.size() > 0) {
				return msgList.get(0).getId_dep_mp();
			}
			return null;
		}

		@Override
		public String[] getRecipient(Map<String, Object> arg0) throws BizException {
			// TODO : 消息接收用户ID数组
			List<ExecDepWaitConfirmMsgDTO> msgList = getMessageDataInfo(arg0);
			if (msgList != null && msgList.size() > 0) {
				return new String[]{msgList.get(0).getId_dep_mp()};			
			}
			
			return null;
		}

		@Override
		public String getTitle(Map<String, Object> arg0) throws BizException {
			
			//List<ExecDepWaitConfirmMsgDTO> msgList = getMessageDataInfo(arg0);		
			// TODO : 组织标题
			return "提示！有已签署的手术医嘱";
		}

		@SuppressWarnings("unchecked")
		protected List<ExecDepWaitConfirmMsgDTO> getMessageDataInfo(Map<String, Object> arg0) {
			
			if (arg0 != null && arg0.size() > 0 && arg0.containsKey(IMQMsgTypeConst.CI_MSG_IP_OPR_CONFIRM)) {
				return (List<ExecDepWaitConfirmMsgDTO>) arg0.get(IMQMsgTypeConst.CI_MSG_IP_OPR_CONFIRM);
			}
			return null;
		}

		private String getWaitConfirmMsg(ExecDepWaitConfirmMsgDTO o) {
			// 序号| 医嘱号 | 医嘱内容
			return String.format("手术医嘱编码: %s,  手术名称: %s,  已签署确认",o.getCode_or(),o.getName_or());
		}
	}

