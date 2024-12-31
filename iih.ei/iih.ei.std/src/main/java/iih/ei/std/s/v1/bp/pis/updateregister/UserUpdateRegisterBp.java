package iih.ei.std.s.v1.bp.pis.updateregister;

import org.apache.commons.beanutils.BeanUtils;

import iih.ei.std.d.v1.pis.pisreturn.d.PisReturnDTO;
import iih.ei.std.d.v1.pis.userreg.d.UserRegDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.pis.mbw.dto.pismbwuserdto.d.PismbwUserDTO;
import iih.pis.mbw.i.IPisMbwMaintanceService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

public class UserUpdateRegisterBp extends IIHServiceBaseBP<UserRegDTO, PisReturnDTO> {

	@Override
	protected void checkParam(UserRegDTO param) throws BizException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected PisReturnDTO process(UserRegDTO param) throws BizException {
		IPisMbwMaintanceService pisMbwMaintance = ServiceFinder.find(IPisMbwMaintanceService.class);
		PismbwUserDTO userDTO = new PismbwUserDTO();
		PisReturnDTO returnDTO = new PisReturnDTO();
		String message = "";
		returnDTO.setCode("1");
		try {
			// 将param的同名属性赋值到userDTO中
			BeanUtils.copyProperties(userDTO, param);
		} catch (Exception e) {
			returnDTO.setCode("0");
			message += e.getMessage();
			System.out.println(e.getMessage());
		}
		try {
			pisMbwMaintance.userUpdateRegister(userDTO);
		} catch (Exception e) {
			returnDTO.setCode("0");
			message += e.getMessage();
			System.out.println(e.getMessage());
		}
		returnDTO.setMsg(message);
		return returnDTO;
	}

}
