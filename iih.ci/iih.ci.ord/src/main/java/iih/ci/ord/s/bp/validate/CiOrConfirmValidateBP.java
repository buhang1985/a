package iih.ci.ord.s.bp.validate;

import java.util.ArrayList;
import java.util.List;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.dto.ordercheckdto.CheckConfirmRstDTO;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

public class CiOrConfirmValidateBP {

	public CiOrConfirmValidateBP() {

	}

	public CheckConfirmRstDTO exec(CiOrderDO[] ciorders, String method) throws BizException {
		CheckConfirmRstDTO flag = null;
		switch (method) {
		case MethodConstants.CHECK_VALIDATE:
			flag = this.checkValidate(ciorders);
			break;
		case MethodConstants.CANCEL_VALIDATE:
			flag = this.cancelValidate(ciorders);
			break;
		case MethodConstants.SIGN_VALIDATE:
			flag = this.signValidate(ciorders);
			break;
		case MethodConstants.CANCEL_SIGN_VALIDATE:
			flag = this.cancelSignValidate(ciorders);
			break;
		case MethodConstants.STOP_VALIDATE:
			flag = this.stopValidate(ciorders);
			break;

		case MethodConstants.DELETE_VALIDATE:
			flag = this.deleteValidate(ciorders);
			break;
		default:
			break;
		}
		return flag;

	}

	public CheckConfirmRstDTO checkValidate(CiOrderDO[] ciorders) throws BizException {
		CheckConfirmRstDTO resDTO = new CheckConfirmRstDTO();
		resDTO.setSuccessful(false); 
		
		for (CiOrderDO cido : ciorders) {
			//已签署未签署确认
			if ((FBoolean.TRUE.equals(cido.getFg_sign()) && FBoolean.FALSE.equals(cido.getFg_chk()))) {
				resDTO.setSuccessful(true); 
			
			//已作废未作废确认
			} else if ((FBoolean.FALSE.equals(cido.getFg_chk_canc()) && FBoolean.TRUE.equals(cido.getFg_canc()))) {
				resDTO.setSuccessful(true); 
				
			//未作废已停止未停止确认	
			} else if ((FBoolean.FALSE.equals(cido.getFg_chk_stop()) && FBoolean.FALSE.equals( cido.getFg_canc())
					&& FBoolean.TRUE.equals(cido.getFg_stop()))) {
				resDTO.setSuccessful(true); 
			}
			if (!resDTO.isSuccessful()) 
				resDTO.setErrorMessage(("医嘱名称："+cido.getName_or()+" 医嘱Id_or:"+cido.getId_or()+
						" 当医嘱的签署标志Fg_sign为Y，核对确认标志Fg_chk为N，才能签署确认！/r"
						+ "当医嘱的作废标志Fg_canc()为Y，确认作废标志Fg_chk_canc为N，才能作废确认！/r"
						+ " 当医嘱的停止标志为Y，核对停止标志为N，作废标志为N，才能停止确认！/r"));
			if (!resDTO.isSuccessful()) 
				break;
		}

		// 返回
		return resDTO;

	}

	// 作废校验
	public CheckConfirmRstDTO cancelValidate(CiOrderDO[] ciorders) throws BizException {
		CheckConfirmRstDTO resDTO = new CheckConfirmRstDTO();
		resDTO.setSuccessful(true); 
		for (CiOrderDO cido : ciorders) {
			if (!(FBoolean.TRUE.equals(cido.getFg_chk()) && cido.getSd_su_mp().equals("0")
					&& FBoolean.FALSE.equals(cido.getFg_canc()))) {
				resDTO.setSuccessful(false); 
				resDTO.setErrorMessage("医嘱：【"+cido.getName_or()+"】作废失败，请管理员查看数据，当作废标志Fg_chk为N,不可作废标志Fg_canc为N，且医嘱状态Sd_su_mp为0不能作废确认。");
				break;
			}
		}
		// 返回
		return resDTO;
	}

	// 签署校验
	public CheckConfirmRstDTO signValidate(CiOrderDO[] ciorders) throws BizException {
		CheckConfirmRstDTO resDTO = new CheckConfirmRstDTO();
		resDTO.setSuccessful(true); 
		for (CiOrderDO cido : ciorders) {
			if (FBoolean.FALSE.equals(cido.getFg_sign())) {
				resDTO.setSuccessful(false); 
				resDTO.setErrorMessage("医嘱：【"+cido.getName_or()+"】签署失败，请管理员查看数据，当签署标志Fg_sign为Y的医嘱才能签署确认。");
				break;
			}
		}
		// 返回
		return resDTO;
	}

	// 撤回签署校验
	public CheckConfirmRstDTO cancelSignValidate(CiOrderDO[] ciorders) throws BizException {
		CheckConfirmRstDTO resDTO = new CheckConfirmRstDTO();
		resDTO.setSuccessful(true); 
		for (CiOrderDO cido : ciorders) {
			if (!(FBoolean.TRUE.equals(cido.getFg_sign()) && FBoolean.FALSE.equals(cido.getFg_chk()))) {
				resDTO.setSuccessful(false); 
				resDTO.setErrorMessage("医嘱：【"+cido.getName_or()+"】签署确认失败，请管理员查看数据，当签署标志Fg_sign为Y，核对标志为N的医嘱才能签署确认。");
				break;
			}
		}
		// 返回
		return resDTO;
	}
	
	// 停止校验
	public CheckConfirmRstDTO stopValidate(CiOrderDO[] ciorders) throws BizException {
		CheckConfirmRstDTO resDTO = new CheckConfirmRstDTO();
		resDTO.setSuccessful(true); 
		for (CiOrderDO cido : ciorders) {
			if (!(FBoolean.TRUE.equals(cido.getFg_long()) && cido.getFg_chk() == FBoolean.TRUE
					&& FBoolean.FALSE.equals(cido.getFg_canc()) && cido.getDt_end().before(new FDateTime()))) {
				resDTO.setSuccessful(false); 
				resDTO.setErrorMessage("医嘱：【"+cido.getName_or()+"】停止确认失败，请管理员查看数据，当Fg_long为N，Fg_chk =Y，Fg_canc=N 的医嘱才能停止确认。");
				break;
			}
		}
		// 返回
		return resDTO;
	}

	// 删除校验
	public CheckConfirmRstDTO deleteValidate(CiOrderDO[] ciorders) throws BizException {
		CheckConfirmRstDTO resDTO = new CheckConfirmRstDTO();
		resDTO.setSuccessful(true); 
		for (CiOrderDO cido : ciorders) {
			if (FBoolean.TRUE.equals(cido.getFg_sign())) {
				resDTO.setSuccessful(false); 
				resDTO.setErrorMessage("医嘱：【"+cido.getName_or()+"】删除确认失败，请管理员查看数据，当签署标志Fg_sign为Y才能删除。");
				break;
			}
		}
		// 返回
		return resDTO;
	}
	// 获得护嘱可以停止核对的医嘱
	public CiOrderDO[] nurStopChkValidate(List<CiOrderDO> ciorders) {
		List<CiOrderDO> orders = new ArrayList<CiOrderDO>();
		for (CiOrderDO cido : ciorders) {
			if (FBoolean.TRUE.equals(cido.getFg_long())&&FBoolean.FALSE.equals(cido.getFg_canc())
					&&FBoolean.FALSE.equals(cido.getFg_chk_stop())) {
				orders.add(cido);
			}
		}
		// 返回
		return orders.toArray(new CiOrderDO[0]);
	}

	// 获得护嘱可作废确认的医嘱
	public CiOrderDO[] nurCancelChkValidate(List<CiOrderDO> ciorders) throws BizException {
		List<CiOrderDO> orders = new ArrayList<CiOrderDO>();
		for (CiOrderDO cido : ciorders) {
			//医嘱是否已记账
			if(!CiOrdUtils.ordIsHasBl(cido.getId_or())){
				orders.add(cido);
			}else if (cido.getFg_uncancelable()!=null&&!cido.getFg_uncancelable().booleanValue()
					&&FBoolean.TRUE.equals(cido.getFg_chk())&&!FBoolean.TRUE.equals(cido.getFg_chk_canc())) {
				orders.add(cido);
			}
		}
		// 返回
		return orders.toArray(new CiOrderDO[0]);
	}

}
