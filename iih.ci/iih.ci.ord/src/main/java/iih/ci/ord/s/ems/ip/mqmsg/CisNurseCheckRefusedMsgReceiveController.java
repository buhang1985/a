package iih.ci.ord.s.ems.ip.mqmsg;

import java.util.List;
import java.util.Map;

import iih.ci.ord.i.mqmsg.meta.NurseCheckRefusedMsgDTO;
import iih.ci.ord.s.ems.base.BaseMsgReceiveController;
import iih.ci.ord.s.ems.meta.StringList;
import iih.ci.ord.s.ems.cache.BDUserInfoCache;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;

public class CisNurseCheckRefusedMsgReceiveController extends BaseMsgReceiveController {

	@Override
	public String getContent(Map<String, Object> arg0) throws BizException {
		// TODO:组织消息内容
		List<NurseCheckRefusedMsgDTO> msgList = getMessageDataInfo(arg0);
		if(msgList != null && msgList.size() > 0){
			FArrayList objList = new FArrayList();
			objList.addAll(msgList);
			return objList.serializeJson();
		}
		
		return null;
	}

	@Override
	public String getDep(Map<String, Object> arg0) throws BizException {
		// TODO:返回消息接收科室
		List<NurseCheckRefusedMsgDTO> msgList = getMessageDataInfo(arg0);
		if(msgList != null && msgList.size() > 0){
			return msgList.get(0).getId_dep_or();
		}
		return null;
	}

	@Override
	public String[] getRecipient(Map<String, Object> arg0) throws BizException {
		// TODO : 消息接收用户ID数组
		StringList userList = new StringList();
		List<NurseCheckRefusedMsgDTO> msgList = getMessageDataInfo(arg0);
		if(msgList != null && msgList.size() > 0){
			for(NurseCheckRefusedMsgDTO msgInfo : msgList){
				userList.add(msgInfo.getId_emp_or());
			}
		}
		if(userList.size() > 0){
			return BDUserInfoCache.GetUserIDsOfSysUserInfoWithPsnIDs(userList.asArray());
			
		}
		return null;
	}

	@Override
	public String getTitle(Map<String, Object> arg0) throws BizException {
		// TODO : 组织标题
		return "护士核对【拒绝医嘱确认】消息";
	}

	protected List<NurseCheckRefusedMsgDTO> getMessageDataInfo(Map<String, Object> arg0){
		if(arg0 != null && arg0.size() > 0 && arg0.containsKey("CIS_MSG_NURSECHECK_REFUSED")){
			return (List<NurseCheckRefusedMsgDTO>)arg0.get("CIS_MSG_NURSECHECK_REFUSED");
		}
		return null;
	}
}
