package iih.ci.mr.s.bp;

import java.util.HashMap;
import java.util.Map;

import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.ci.mrm.recallmsgdto.d.RecallMsgDTO;
import iih.ci.mrqc.cimrrecall.d.CiMrRecallDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.message.message.i.IGenerateMessageExtdService;
import xap.sys.permfw.user.d.UserDO;
import xap.sys.permfw.user.i.IUserRService;

public class InHospitalRecallMsgBP {

	public void recallAuditMsg(CiMrRecallDO ciMrRecallDO)
	{
		if(ciMrRecallDO == null)
		{
			return;
		}
		RecallMsgDTO dto = getRecallMsgDTO(ciMrRecallDO);
		generateMessageAndMap("CI_MR_RECALL_AUDIT",dto);
	}
	
	public void recallApplyMsg(CiMrRecallDO ciMrRecallDO)
	{
		if(ciMrRecallDO == null)
		{
			return;
		}
		RecallMsgDTO dto = getRecallMsgDTO(ciMrRecallDO);
		generateMessageAndMap("CI_MRM_RECALL_APPLY",dto);
	}
	public void rejectMrfpMsg(PatiVisitDO patiVisitDO) throws BizException
	{
		if(patiVisitDO == null)
		{
			return;
		}
		IUserRService iUserRService = ServiceFinder
				.find(IUserRService.class);
		UserDO[] userDos = iUserRService.find("id_psn = '"+ patiVisitDO.getId_emp_phy() +"'", "", FBoolean.FALSE);
		if(userDos.length == 0){
			return;
		}
		RecallMsgDTO dto = new RecallMsgDTO();
		dto.setName_pat(patiVisitDO.getName_pat());
		dto.setId_doc(userDos[0].getId_user());
		generateMessageAndMap("CI_MRM_REJECT",dto);
	}
	private void generateMessageAndMap(String code_msg,RecallMsgDTO dto)
	{
		Map<String, Object> msgMap = new HashMap<String, Object>();
		msgMap.put(code_msg, dto);

		IGenerateMessageExtdService msgService = ServiceFinder.find(IGenerateMessageExtdService.class);
		// 此处调用方法，为Map参数，因此在后台接收，也应该实现Map参数的接口方法
		try {
			msgService.GenerateMessageAndMap(code_msg, msgMap, null);
		} catch (BizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private RecallMsgDTO getRecallMsgDTO(CiMrRecallDO ciMrRecallDO)
	{
		RecallMsgDTO recallMsgDTO = new RecallMsgDTO();
		recallMsgDTO.setId_recall(ciMrRecallDO.getId_ci_mr_recall());
		recallMsgDTO.setId_ent(ciMrRecallDO.getId_ent());
		recallMsgDTO.setId_dept(ciMrRecallDO.getId_dep_apply());
		recallMsgDTO.setCode_dept(ciMrRecallDO.getCode_dep_apply());
		recallMsgDTO.setName_dept(ciMrRecallDO.getName_dep_apply());
		recallMsgDTO.setId_doc(ciMrRecallDO.getId_psn_apply());
		IUserRService userService = ServiceFinder.find(IUserRService.class);
		UserDO[] userDos = null;
		try {
			userDos = userService.find(" a0.id_psn = '" + recallMsgDTO.getId_doc() +"'", null, FBoolean.FALSE);
		} catch (BizException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(userDos != null && userDos.length > 0)
		{
			recallMsgDTO.setId_doc(userDos[0].getId_user());
		}
		recallMsgDTO.setCode_doc(ciMrRecallDO.getCode_psn_apply());
		recallMsgDTO.setName_doc(ciMrRecallDO.getName_psn_apply());
		recallMsgDTO.setReason(ciMrRecallDO.getApply_reson());
		recallMsgDTO.setDt_apply(ciMrRecallDO.getDt_apply());
		IPativisitRService entService = ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO patiVisitDO = new PatiVisitDO();
		try {
			patiVisitDO = entService.findById(ciMrRecallDO.getId_ent());
		} catch (BizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		recallMsgDTO.setId_pat(patiVisitDO.getId_pat());
		recallMsgDTO.setCode_pat(patiVisitDO.getCode_pat());
		recallMsgDTO.setName_pat(patiVisitDO.getName_pat());
		recallMsgDTO.setId_state(ciMrRecallDO.getId_state());
		recallMsgDTO.setCode_state(ciMrRecallDO.getSd_state());
		recallMsgDTO.setName_state(ciMrRecallDO.getName_sate());
		if(ICiMrDictCodeConst.SD_CIMRRECALL_STATUS_AUDIT.equals(recallMsgDTO.getCode_state()))
		{
			recallMsgDTO.setDt_audit(ciMrRecallDO.getDt_audit());
		}
		if(ICiMrDictCodeConst.SD_CIMRRECALL_STATUS_REJECT.equals(recallMsgDTO.getCode_state()))
		{
			recallMsgDTO.setDt_audit(ciMrRecallDO.getDt_reject());
			recallMsgDTO.setReason(ciMrRecallDO.getReject_reson());
		}
		return recallMsgDTO;
	}
}
