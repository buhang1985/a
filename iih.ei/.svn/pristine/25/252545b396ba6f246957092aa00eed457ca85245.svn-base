package iih.ei.std.s.v1.bp.pis.updateopenid;

import iih.ei.std.d.v1.pis.pisreturn.d.PisReturnDTO;
import iih.ei.std.d.v1.pis.userreg.d.UserRegDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.pis.mbw.i.IPisMbwMaintanceService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 用户注册
 * @author chen.zhao
 */
public class UpdateUserOpenidBp extends IIHServiceBaseBP<UserRegDTO, PisReturnDTO> {

	@Override
	protected void checkParam(UserRegDTO param) throws BizException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected PisReturnDTO process(UserRegDTO param) throws BizException {
		IPisMbwMaintanceService pisMbwMaintance = ServiceFinder.find(IPisMbwMaintanceService.class);
		PisReturnDTO returnDTO = new PisReturnDTO();
		String message = "";
		returnDTO.setCode("1");
		try {
			pisMbwMaintance.updateUserOpenid(param.getOpenid());
		} catch (Exception e) {
			returnDTO.setCode("0");
			message += e.getMessage();
			System.out.println(e.getMessage());
		}
		returnDTO.setMsg(message);
		return returnDTO;
	}

}
