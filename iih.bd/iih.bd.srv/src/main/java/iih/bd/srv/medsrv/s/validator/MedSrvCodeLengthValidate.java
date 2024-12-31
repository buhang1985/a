package iih.bd.srv.medsrv.s.validator;

import org.apache.commons.lang.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.utils.BdSrvParamUtils;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.bizrule.validation.ValidationFailure;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 医疗服务编码长度检验
 * 
 * @author hao_wu
 *
 */
public class MedSrvCodeLengthValidate implements Validator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public ValidationFailure validate(Object... objs) {
		if (objs == null || objs.length <= 0) {
			return null;
		}

		try {
			FBoolean needCheckSrvCodeLength = BdSrvParamUtils.getFgCheckSrvCodeLength();
			if (FBoolean.FALSE.equals(needCheckSrvCodeLength)) {
				return null;
			}
		} catch (Exception e) {
			return new ValidationFailure(e.getMessage());
		}

		ValidationFailure vFailure = null;
		for (Object object : objs) {
			if (object instanceof MedsrvAggDO) {
				vFailure = CheckMedSrvAggCodeLegth((MedsrvAggDO) object);
			} else if (object instanceof MedSrvDO) {
				vFailure = CheckMedSrvCodeLegth((MedSrvDO) object);
			}
			if (vFailure != null) {
				return vFailure;
			}
		}
		return null;
	}

	/**
	 * 检查医疗服务Agg编码长度
	 * 
	 * @param object
	 * @return
	 */
	private ValidationFailure CheckMedSrvAggCodeLegth(MedsrvAggDO medsrvAggDO) {
		MedSrvDO medSrvDO = medsrvAggDO.getParentDO();
		ValidationFailure vFailure = CheckMedSrvCodeLegth(medSrvDO);
		return vFailure;
	}

	/**
	 * 检查医疗服务编码长度
	 * 
	 * @param object
	 * @return
	 */
	private ValidationFailure CheckMedSrvCodeLegth(MedSrvDO medSrvDO) {
		if (medSrvDO != null && StringUtils.isNotEmpty(medSrvDO.getSd_srvtp())
				&& medSrvDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS)
				&& FBoolean.TRUE.equals(medSrvDO.getFg_or())
				&& (StringUtils.isEmpty(medSrvDO.getCode()) || medSrvDO.getCode().length() != 8)) {
			String msg = String.format("检查类临床医疗服务项目\"%s\"的编码\"%s\"长度不是8位，请修正。", medSrvDO.getName(), medSrvDO.getCode());
			return new ValidationFailure(msg);
		}
		return null;
	}

}
