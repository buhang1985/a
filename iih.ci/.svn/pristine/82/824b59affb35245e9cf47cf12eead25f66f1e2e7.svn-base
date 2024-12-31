package iih.ci.ord.s.ems.biz.ip.mqmsg;

import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.i.ICiOrdCustomSysParamConst;
import iih.ci.ord.i.mqmsg.meta.IMQMsgTypeConst;
import iih.ci.ord.i.mqmsg.meta.NurseWaitConfirmMsgDTO;
import iih.ci.ord.s.ems.base.BaseMsgReceiveController;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.sie.common.utils.StringUtils;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * @author li_zheng
 */
public class CisNurseWaitConfirmMsgReceiveController extends BaseMsgReceiveController{
		
		@Override
		public String getContent(Map<String, Object> arg0) throws BizException {

			List<NurseWaitConfirmMsgDTO> msgList = getMessageDataInfo(arg0);
			StringBuilder msgSb = new StringBuilder();
			int index = 1;
			if (msgList != null && msgList.size() > 0) {
				for (NurseWaitConfirmMsgDTO o : msgList) {
					if(index == 1) {
						//病区 | 床号 | 患者 
						msgSb.append(String.format("病区：%s，床号： %s，患者: %s", o.getName_dep_ns(), o.getCode_bed(),o.getName_pat()));
						//根据消息类型拼接
						switch (o.getWait_config_msgtype()) {
						case ICiDictCodeConst.SD_SU_SIGN:
							msgSb.append(" 有增医嘱，请做   <a funcode='47302005' >签署确认</a>！").append(System.lineSeparator());	
							break;
						case ICiDictCodeConst.SD_SU_CANCEL:
							msgSb.append(" 有废医嘱，请做   <a funcode='47302005' >作废确认</a>！").append(System.lineSeparator());	
							break;
						default:
							msgSb.append(" 有停医嘱，请做   <a funcode='47302005' >停止确认</a>！").append(System.lineSeparator());	
							break;
						}
					}
					msgSb.append(String.format("(%d) ", index++)).append(this.getWaitConfirmMsg(o)).append(System.lineSeparator());
				}
				return msgSb.toString();
			}
			return null;
		}

		@Override
		public String getDep(Map<String, Object> arg0) throws BizException {
			// TODO:返回消息接收科室
			List<NurseWaitConfirmMsgDTO> msgList = getMessageDataInfo(arg0);
			if (msgList != null && msgList.size() > 0) {
				return msgList.get(0).getId_dep_ns();
			}
			return null;
		}

		@Override
		public String[] getRecipient(Map<String, Object> arg0) throws BizException {
			String id_deps = ParamsetQryUtil.getParaString(Context.get().getOrgId(), ICiOrdCustomSysParamConst.LL_PARAM_MSGRECEIVE_DEPS);
			// TODO : 消息接收用户ID数组
			List<NurseWaitConfirmMsgDTO> msgList = getMessageDataInfo(arg0);//0001Z8100000000007PO 0001Z8100000000007R0
			if(StringUtils.isEmpty(id_deps)||!id_deps.contains(msgList.get(0).getId_dep_ns())){
				return null;
			}
			if (msgList != null && msgList.size() > 0) {
				return new String[]{msgList.get(0).getId_dep_ns()};			
			}
			
			return null;
		}

		@Override
		public String getTitle(Map<String, Object> arg0) throws BizException {
			
			List<NurseWaitConfirmMsgDTO> msgList = getMessageDataInfo(arg0);		
			// TODO : 组织标题
			return "提示！有需要确认的医嘱";
		}

		protected List<NurseWaitConfirmMsgDTO> getMessageDataInfo(Map<String, Object> arg0) {
			
			if (arg0 != null && arg0.size() > 0 && arg0.containsKey(IMQMsgTypeConst.CIS_MSG_NURSE_WAIT_CONFIRM)) {
				return (List<NurseWaitConfirmMsgDTO>) arg0.get(IMQMsgTypeConst.CIS_MSG_NURSE_WAIT_CONFIRM);
			}
			return null;
		}

		private String getWaitConfirmMsg(NurseWaitConfirmMsgDTO o) {
			// 序号| 医嘱号 | 医嘱内容
			return String.format("医嘱号: %s,  医嘱内容: %s",o.getCode_or(),o.getName_or());
		}
	}

