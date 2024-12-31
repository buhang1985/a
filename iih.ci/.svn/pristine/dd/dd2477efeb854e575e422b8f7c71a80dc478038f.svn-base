package iih.ci.rcm.hosreminder.s.bp;

import java.util.HashMap;
import java.util.Map;

import iih.ci.rcm.hospitalsenmonitordto.d.HospitalSenMonitorDTO;
import iih.ci.rcm.hosremindermsgdto.d.HosReminderMsgDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.message.message.i.IGenerateMessageExtdService;
import xap.sys.permfw.user.d.UserDO;
import xap.sys.permfw.user.i.IUserRService;

public class HosReminderMsgBP {

	// 发送消息
	public void sendHosReminderMsg(HospitalSenMonitorDTO senMonitorDto)  throws BizException{
		
		HosReminderMsgDTO msgDto = getHosReminderMsgDTO(senMonitorDto);
		// 组织消息参数
		Map<String, Object> msgMap = new HashMap<String, Object>();		
		msgMap.put("CIRCMFILLINHOS",msgDto);
		
		IGenerateMessageExtdService msgService = ServiceFinder.find(IGenerateMessageExtdService.class);
		msgService.GenerateMessageAndMap("CIRCMFILLINHOS", msgMap, null);

	}
	
	
	// 构建消息
	public HosReminderMsgDTO getHosReminderMsgDTO(HospitalSenMonitorDTO senMonitorDto)  throws BizException{
		if(senMonitorDto==null) return null;
		IUserRService service=ServiceFinder.find(IUserRService.class);
		UserDO[] user=service.find("id_psn='"+senMonitorDto.getId_doc()+"'","",FBoolean.FALSE);
		HosReminderMsgDTO msgDto=new HosReminderMsgDTO();
		msgDto.setId_pat(senMonitorDto.getId_pat());
		msgDto.setName_pat(senMonitorDto.getName_pat());
		msgDto.setId_ent(senMonitorDto.getId_ent());
		msgDto.setId_bed(senMonitorDto.getId_bed());
		msgDto.setName_bed(senMonitorDto.getName_bed());
		msgDto.setId_dept(senMonitorDto.getId_dept());
		msgDto.setCode_dept(senMonitorDto.getCode_dept());
		msgDto.setName_dept(senMonitorDto.getName_dept());
		msgDto.setId_doc(user[0].getId_user());
		msgDto.setCode_doc(senMonitorDto.getCode_doc());
		msgDto.setName_doc(senMonitorDto.getName_doc());
		
		return msgDto;
	}
}
