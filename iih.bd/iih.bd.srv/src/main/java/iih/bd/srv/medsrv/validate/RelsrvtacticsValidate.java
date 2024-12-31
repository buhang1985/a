package iih.bd.srv.medsrv.validate;

import org.apache.commons.lang.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.medsrv.d.RelSrvTacticDO;
import xap.sys.appfw.bizrule.validation.ValidationFailure;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 关联服务策略校验
 * 
 * @author guoyang
 *
 */
public class RelsrvtacticsValidate implements Validator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public ValidationFailure validate(Object... aobj) {
		if (aobj == null || aobj.length <= 0) {
			return null;
		}

		return Validate(aobj);
	}

	/**
	 * 校验
	 * 
	 * @param aobj
	 * @return
	 */
	private ValidationFailure Validate(Object[] aobj) {
		for (Object object : aobj) {
			if (object instanceof RelSrvTacticDO) {
				ValidationFailure vFailure = Validate((RelSrvTacticDO) object);
				if (vFailure != null) {
					return vFailure;
				}
			}
		}
		return null;
	}

	/**
	 * 校验
	 * 
	 * @param relSrvTacticDO
	 * @return
	 */
	private ValidationFailure Validate(RelSrvTacticDO relSrvTacticDO) {
		ValidationFailure vFailure = CheckSdRelfactortp(relSrvTacticDO);
		if (vFailure != null) {
			return vFailure;
		}
		vFailure = CheckBizitm(relSrvTacticDO);
		if (vFailure != null) {
			return vFailure;
		}
		vFailure = CheckRoundMd(relSrvTacticDO);
		if (vFailure != null) {
			return vFailure;
		}
		return null;
	}

	/**
	 * 校验舍入规则
	 * 
	 * @param relSrvTacticDO
	 * @return
	 */
	private ValidationFailure CheckRoundMd(RelSrvTacticDO relSrvTacticDO) {
		if (IBdSrvDictCodeConst.SD_QUANCALMD_RATIO.equals(relSrvTacticDO.getSd_quancalmd())
				&& StringUtils.isEmpty(relSrvTacticDO.getId_roundmd())) {
			// 用量计算为比例法时，舍入规则不允许为空
			String msg = String.format("当\"%s+%s\"策略用量计算为比例法时，舍入规则不允许为空。", relSrvTacticDO.getSrvname(),
					relSrvTacticDO.getRelsrvname());
			return new ValidationFailure(msg);
		}
		return null;
	}

	/**
	 * 校验套内项目
	 * 
	 * @param relSrvTacticDO
	 * @return
	 */
	private ValidationFailure CheckBizitm(RelSrvTacticDO relSrvTacticDO) {
		if ((relSrvTacticDO.getSd_relfactortp().equals(IBdSrvDictCodeConst.SD_RELFACTORTP_SETSETITM))
				&& (relSrvTacticDO.getId_bizitm() == null)) {
			String msg = String.format("当\"%s+%s\"策略关联因素类型为：\"套+套内项目\"时,\"套内项目\"不允许为空。", relSrvTacticDO.getSrvname(),
					relSrvTacticDO.getRelsrvname());
			return new ValidationFailure(msg);
		}
		return null;
	}

	/**
	 * 校验服务关联策略类型编码
	 * 
	 * @param relSrvTacticDO
	 * @return
	 */
	private ValidationFailure CheckSdRelfactortp(RelSrvTacticDO relSrvTacticDO) {
		if (relSrvTacticDO.getSd_relfactortp() == null) {
			String msg = String.format("\"%s+%s\"策略关联因素类型编码不允许为空。", relSrvTacticDO.getSrvname(),
					relSrvTacticDO.getRelsrvname());
			return new ValidationFailure(msg);
		}
		return null;
	}

}
