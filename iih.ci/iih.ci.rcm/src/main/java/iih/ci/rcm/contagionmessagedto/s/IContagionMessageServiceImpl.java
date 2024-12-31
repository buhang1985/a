package iih.ci.rcm.contagionmessagedto.s;

import com.sms.i.ISendSMSService;
import iih.ci.rcm.contagion.d.ContagionDO;
import iih.ci.rcm.contagion.dto.d.EntDto;
import iih.ci.rcm.contagionmessage.d.ContagionMessageDTO;
import iih.ci.rcm.contagionmessage.i.IContagionMessageService;
import iih.ci.rcm.contagionmessagedto.s.bp.ReportFillinMsgBP;
import iih.ci.rcm.s.bp.common.CiRcmParamUtils;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.service.constant.Binding;
import xap.mw.sf.core.util.ServiceFinder;

@Service(serviceInterfaces = { IContagionMessageService.class }, binding = Binding.JSONRPC)
public class IContagionMessageServiceImpl implements IContagionMessageService {

	public int sentMessage(ContagionDO condo) throws BizException {
		ContagionMessageDTO dto = new ContagionMessageDTO();
		ISendSMSService service=ServiceFinder.find(ISendSMSService.class);
		if (condo == null) {
			return -1;
		}
		String mobiles = CiRcmParamUtils
				.GetSysParamCardContagionSendMobile(Context.get().getOrgId());
		dto.setSave_time(condo.getSv().toString().substring(0, 16));
		dto.setReport_dep(condo.getReport_unit_name());
		dto.setReport_doc(condo.getName_emp_entry());
		dto.setName_pat(condo.getName());
		if (condo.getEu_jlcrb_name() != null) {
			dto.setName_disease(condo.getEu_jlcrb_name());
		} else if (condo.getEu_ylcrb_name() != null) {
			dto.setName_disease(condo.getEu_ylcrb_name());
		} else if (condo.getEu_blcrb_name() != null) {
			dto.setName_disease(condo.getEu_blcrb_name());
		} else if (condo.getName_other_diseases() != null) {
			dto.setName_disease(condo.getName_other_diseases());
		} else {
			dto.setName_disease("");
		}
		
		String message = service.getMessage("CIMRCARD0005", null,
				new BaseDTO[] { dto });
		int result = service.sendMessage(mobiles, message, "CIMRCARD0005");
		return result;
	}

	@Override
	public void sendReportFillinMsg(EntDto[] entarr) throws BizException{
		ReportFillinMsgBP bp=new ReportFillinMsgBP();
		bp.sendReportFillinMsg(entarr);	
		
	}
}
