package iih.bd.srv.ems.s.validator;

import org.apache.commons.lang.StringUtils;

import iih.bd.srv.ems.d.EmsPrnTmplDO;
import iih.bd.srv.ems.d.EmsPrnTmplRelPresDO;
import iih.bd.srv.ems.d.EmsprntmplAggDO;
import iih.bd.srv.ems.d.PresPrnRelFactorEnum;
import xap.mw.core.data.DOStatus;
import xap.sys.appfw.bizrule.validation.ValidationFailure;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 医疗单打印模板关联处方数据校验
 * 
 * @author hao_wu
 *
 */
public class EmsPrnTmplRelPresDODataValidate implements Validator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6223676528324414478L;

	@Override
	public ValidationFailure validate(Object... aobj) {
		if (aobj == null || aobj.length <= 0) {
			return null;
		}
		for (Object object : aobj) {
			if (object instanceof EmsprntmplAggDO) {
				ValidationFailure vFailure = srvValidate((EmsprntmplAggDO) object);
				if (vFailure != null) {
					return vFailure;
				}
				vFailure = srvTpValidate((EmsprntmplAggDO) object);
				if (vFailure != null) {
					return vFailure;
				}
			}

		}
		return null;
	}

	/**
	 * 服务校验
	 * 
	 * @return
	 */
	private ValidationFailure srvValidate(EmsprntmplAggDO emsprntmplAggDO) {
		if (emsprntmplAggDO == null) {
			return null;
		}
		EmsPrnTmplDO emsPrnTmplDO = emsprntmplAggDO.getParentDO();

		EmsPrnTmplRelPresDO[] relSrvArray = emsprntmplAggDO.getEmsPrnTmplRelPresDO();
		if (relSrvArray == null || relSrvArray.length <= 0) {
			return null;
		}

		for (EmsPrnTmplRelPresDO emsPrnTmplRelPresDO : relSrvArray) {
			String eu_presprnrelfactortp = emsPrnTmplRelPresDO.getEu_presprnrelfactortp();
			String idPresTp = emsPrnTmplRelPresDO.getId_prestp();
			if (eu_presprnrelfactortp != null && DOStatus.DELETED != emsPrnTmplRelPresDO.getStatus()
					&& eu_presprnrelfactortp.equals(PresPrnRelFactorEnum.PRESTYPE)
					&& (idPresTp == null || StringUtils.isBlank(idPresTp.trim()))) {
				String msg = String.format("医疗单打印模板\"%s\"关联处方类型列表中处方类型为空。", emsPrnTmplDO.getName());
				return new ValidationFailure(msg);
			}
		}
		return null;
	}

	/**
	 * 服务类型校验
	 * 
	 * @return
	 */
	private ValidationFailure srvTpValidate(EmsprntmplAggDO emsprntmplAggDO) {
		if (emsprntmplAggDO == null) {
			return null;
		}
		EmsPrnTmplDO emsPrnTmplDO = emsprntmplAggDO.getParentDO();

		EmsPrnTmplRelPresDO[] relSrvArray = emsprntmplAggDO.getEmsPrnTmplRelPresDO();
		if (relSrvArray == null || relSrvArray.length <= 0) {
			return null;
		}

		for (EmsPrnTmplRelPresDO emsPrnTmplRelPresDO : relSrvArray) {
			String eu_presprnrelfactortp = emsPrnTmplRelPresDO.getEu_presprnrelfactortp();
			String idPrestpword = emsPrnTmplRelPresDO.getId_prestpword();
			if (eu_presprnrelfactortp != null && DOStatus.DELETED != emsPrnTmplRelPresDO.getStatus()
					&& eu_presprnrelfactortp.equals(PresPrnRelFactorEnum.PRESFLAGTYPE)
					&& (idPrestpword == null || StringUtils.isBlank(idPrestpword.trim()))) {
				String msg = String.format("医疗单打印模板\"%s\"关联处方类型列表中处方标识类型为空。", emsPrnTmplDO.getName());
				return new ValidationFailure(msg);
			}
		}
		return null;
	}

}
