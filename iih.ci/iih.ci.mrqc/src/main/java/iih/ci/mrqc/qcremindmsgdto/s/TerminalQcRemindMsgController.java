package iih.ci.mrqc.qcremindmsgdto.s;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import iih.ci.mr.s.bp.common.CiMrParamUtils;
import iih.ci.mrqc.qcremindmsgdto.d.QcRemindMsgDTO;
import iih.ci.mrqc.qcremindmsgdto.s.bp.QcMsgGetPsnBp;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FMap;
import xap.sys.message.message.i.IGenerateRouserMsg;

public class TerminalQcRemindMsgController implements IGenerateRouserMsg {

	private static CiMrParamUtils util = new CiMrParamUtils();
	private static QcMsgGetPsnBp bp = new QcMsgGetPsnBp();

	@Override
	public String getContent(Map<String, Object> arg0) throws BizException {
		// 消息内容
		QcRemindMsgDTO msgdto = getMessageDataInfo(arg0);

		if (msgdto != null) {

			String idRevision = msgdto.getId_qcremind();
			String msg = "收到" + msgdto.getDep_phy_name() + "患者：" + msgdto.getPat_name() + "  就诊号：" + msgdto.getId_ent()
					+ "的" + "<a funcode='46504015' idrevision='" + idRevision + "'>终末质控缺陷整改通知书</a>" + "，请及时处理！";

			return msg;
		}
		return null;
	}

	@Override
	public String getContents(BaseDO[] arg0, BaseDTO[] arg1) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDep(Map<String, Object> arg0) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getRecipient(Map<String, Object> arg0) throws BizException {
		// 消息接收用户
		QcRemindMsgDTO msgdto = getMessageDataInfo(arg0);
		FMap map = msgdto.getCreator();
		// 科室
		String id_dep=msgdto.getId_dep_phy();
		if (map == null)
			return null;
		List<String> list = new ArrayList<String>();
		// 添加用户---整改人（创建人）
		for (String key : map.keySet()) {
			list.add(key);
		}
		@SuppressWarnings("static-access")
		Boolean isFlag = util.GetSysParamMrQcMsgToPsns(Context.get().getOrgId());
		if (true == isFlag && null != list && list.size() > 0) {
			// 添加用户---整改人（创建人）所在诊疗组人员的用户
			list = bp.getUserIdToMsg(list,id_dep);
		}
		if (msgdto.getId_psn() != null)
			//// 添加用户---责任医师
			list.add(msgdto.getId_psn());
		list = bp.removeEqual(list);
		return (String[]) list.toArray(new String[list.size()]);
	}

	@Override
	public String[] getRecipients(BaseDO[] arg0, BaseDTO[] arg1) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTitle(Map<String, Object> arg0) throws BizException {
		return "提示！终末质控整改通知";	
	}

	@Override
	public String getTitles(BaseDO[] arg0, BaseDTO[] arg1) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public URI getURI() throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	public QcRemindMsgDTO getMessageDataInfo(Map<String, Object> arg0) {

		if (arg0 != null && arg0.size() > 0 && arg0.containsKey("CIMRTERMINALQC")) {
			return (QcRemindMsgDTO) arg0.get("CIMRTERMINALQC");
		}
		return null;
	}
}
