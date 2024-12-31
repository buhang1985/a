package iih.ei.std.s.v1.bp.pis.addpatient;

import org.apache.commons.beanutils.BeanUtils;

import iih.ei.std.d.v1.pis.patreg.d.PatRegDTO;
import iih.ei.std.d.v1.pis.pisreturn.d.PisReturnDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.pis.mbw.dto.pismbwpatdto.d.PismbwPatDTO;
import iih.pis.mbw.i.IPisMbwMaintanceService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

public class AddPatientBp extends IIHServiceBaseBP<PatRegDTO, PisReturnDTO> {

	@Override
	protected void checkParam(PatRegDTO param) throws BizException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected PisReturnDTO process(PatRegDTO param) throws BizException {
		IPisMbwMaintanceService pisMbwMaintance = ServiceFinder.find(IPisMbwMaintanceService.class);
		PismbwPatDTO patDTO = new PismbwPatDTO();
		PisReturnDTO returnDTO = new PisReturnDTO();
		String message = "";
		returnDTO.setCode("1");
		try {
			// 将param的同名属性赋值到patDTO中
			BeanUtils.copyProperties(patDTO, param);
		} catch (Exception e) {
			returnDTO.setCode("0");
			message += e.getMessage();
			System.out.println(e.getMessage());
		}
		try {
			pisMbwMaintance.addPatient(patDTO);
		} catch (Exception e) {
			returnDTO.setCode("0");
			message += e.getMessage();
			System.out.println(e.getMessage());
		}
		returnDTO.setMsg(message);
		return returnDTO;
	}

}
