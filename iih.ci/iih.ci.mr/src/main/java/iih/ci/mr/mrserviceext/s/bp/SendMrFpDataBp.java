package iih.ci.mr.mrserviceext.s.bp;

import iih.ci.mr.cmis.s.CMISSendServiceImpl;
import iih.ci.mr.cmisnew.common.XmlFbPortType;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

public class SendMrFpDataBp {
	/**
	 * 发送病案首页数据
	 * @param id_ents
	 * @throws Exception_Exception
	 * @throws BizException
	 */
	public String sendCMISMsg(String id_ent) throws BizException {
		String res = "";
		CMISSendServiceImpl _service = new CMISSendServiceImpl();		
		String msg=_service.getCimrfpdto(id_ent);;
		
		if (msg == null)
			return "false";
		msg = msg.replace("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>", "");
		XmlFbPortType fbService=ServiceFinder.find(XmlFbPortType.class);
		res = fbService.xpServiceFb(msg, "1048");// 首页信息填写1048，门诊工作量信息填写1049，住院工作量信息填写1050
		return res;
	}
}
