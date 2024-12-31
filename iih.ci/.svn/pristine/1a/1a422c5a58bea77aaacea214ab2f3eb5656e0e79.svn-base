package iih.ci.ord.s.bp.task;

import java.util.List;
import java.util.Map;

import iih.ci.ord.i.mqmsg.meta.IMQMsgTypeConst;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.base.BaseMsgReceiveController;
import xap.mw.core.data.BizException;
/**
 * 
 * @author F
 *
 * @date 2020年2月13日下午5:41:05
 *
 * @classpath iih.ci.ord.s.bp.task.UnDiagSignController
 */
public class UnDiagSignController extends BaseMsgReceiveController{
	@Override
	public String getContent(Map<String, Object> arg0) throws BizException {
		List<String> lst=getMessageDataInfo(arg0);
		if(CiOrdUtils.isEmpty(lst)) {
			return null;
		}
		String string="";
		for(String s:lst) {
			string+=s+",";
		}
		if(string!=null && string!="") {
			return string.substring(0,string.length()-1);
		}
		return null;
	}
	@Override
	public String[] getRecipient(Map<String, Object> arg0) throws BizException {
		String id_dept=getDept(arg0);
		if(CiOrdUtils.isEmpty(id_dept)) {
			return null;
		}
		String [] strings= {id_dept};
		return strings;
	}
	@Override
	public String getTitle(Map<String, Object> arg0) throws BizException {
		//组织标题
		return "提示！存在患者入院三天未诊断签署，患者需要进行会诊流程";
	}
	@SuppressWarnings("unchecked")
	protected List<String> getMessageDataInfo(Map<String, Object> arg0) {
		if (arg0 != null && arg0.size() > 0 && arg0.containsKey(IMQMsgTypeConst.CI_MSG_UN_DIAG_SIGN)) {
			return (List<String>) arg0.get(IMQMsgTypeConst.CI_MSG_UN_DIAG_SIGN);
		}
		return null;
	}
	protected String getDept(Map<String, Object> arg0) {
		if (arg0 != null && arg0.size() > 0 && arg0.containsKey(IMQMsgTypeConst.CI_MSG_UN_DIAG_SIGN)) {
			return (String) arg0.get("id_dep");
		}
		return null;
	}
}
