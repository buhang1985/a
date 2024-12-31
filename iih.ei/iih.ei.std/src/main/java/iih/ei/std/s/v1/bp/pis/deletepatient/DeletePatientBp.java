package iih.ei.std.s.v1.bp.pis.deletepatient;

import iih.ei.std.d.v1.pis.patreg.d.PatRegDTO;
import iih.ei.std.d.v1.pis.pisreturn.d.PisReturnDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.pis.mbw.i.IPisMbwMaintanceService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

public class DeletePatientBp extends IIHServiceBaseBP<PatRegDTO, PisReturnDTO> {

	@Override
	protected void checkParam(PatRegDTO param) throws BizException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected PisReturnDTO process(PatRegDTO param) throws BizException {
		IPisMbwMaintanceService pisMbwMaintance = ServiceFinder.find(IPisMbwMaintanceService.class);
		PisReturnDTO returnDTO = new PisReturnDTO();
		String message = "";
		returnDTO.setCode("1");
		try {
			pisMbwMaintance.deletePatient(param.getId_mbw_pat());
		} catch (Exception e) {
			returnDTO.setCode("0");
			message += e.getMessage();
			System.out.println(e.getMessage());
		}
		returnDTO.setMsg(message);
		return returnDTO;
	}

}
