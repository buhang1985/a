package iih.ei.std.s.v1;

import iih.ei.std.d.v1.pis.patreg.d.PatRegDTO;
import iih.ei.std.d.v1.pis.pisreturn.d.PisReturnDTO;
import iih.ei.std.d.v1.pis.userreg.d.UserRegDTO;
import iih.ei.std.i.v1.IPisApiService;
import iih.ei.std.s.v1.bp.pis.addpatient.AddPatientBp;
import iih.ei.std.s.v1.bp.pis.deletepatient.DeletePatientBp;
import iih.ei.std.s.v1.bp.pis.updateopenid.UpdateUserOpenidBp;
import iih.ei.std.s.v1.bp.pis.updatepatient.UpdatePatientBp;
import iih.ei.std.s.v1.bp.pis.userreg.UserRegisterBp;
import xap.mw.core.data.BizException;

/**
 * 
* @ClassName: PixApiServiceImpl
* @Description: IIH微信公众号标准对外接口
* @date 2020年4月18日
*
 */
public class PisApiServiceImpl implements IPisApiService{

	@Override
	public PisReturnDTO userRegister(UserRegDTO param) throws BizException {
		return new UserRegisterBp().exec(param);
	}

	@Override
	public PisReturnDTO userCancelRegister(UserRegDTO param) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PisReturnDTO userUpdateRegister(UserRegDTO param) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PisReturnDTO updateUserOpenid(UserRegDTO param) throws BizException {
		return new UpdateUserOpenidBp().exec(param);
	}

	@Override
	public PisReturnDTO addPatient(PatRegDTO param) throws BizException {
		return new AddPatientBp().exec(param);		
	}

	@Override
	public PisReturnDTO updatePatient(PatRegDTO param) throws BizException {
		return new UpdatePatientBp().exec(param);
	}

	@Override
	public PisReturnDTO deletePatient(PatRegDTO param) throws BizException {
		return new DeletePatientBp().exec(param);
	}



}
