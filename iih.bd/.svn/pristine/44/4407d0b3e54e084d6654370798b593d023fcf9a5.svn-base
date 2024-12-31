package iih.bd.srv.ems.s.validator;

import org.apache.commons.lang.StringUtils;

import iih.bd.srv.ems.d.EmsPrnTmplDO;
import iih.bd.srv.ems.d.EmsPrnTmplRelSrvDO;
import iih.bd.srv.ems.d.EmsprntmplAggDO;
import iih.bd.srv.ems.d.eu_srvcatpenum;
import xap.mw.core.data.DOStatus;
import xap.sys.appfw.bizrule.validation.ValidationFailure;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 医疗单打印模板关联服务数据校验
 * 
 * @author hao_wu
 *
 */
public class EmsPrnTmplRelSrvDODataValidate implements Validator {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7211607681607900495L;

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

		EmsPrnTmplRelSrvDO[] relSrvArray = emsprntmplAggDO.getEmsPrnTmplRelSrvDO();
		if (relSrvArray == null || relSrvArray.length <= 0) {
			return null;
		}

		for (EmsPrnTmplRelSrvDO emsPrnTmplRelSrvDO : relSrvArray) {
			String eu_ofreftp = emsPrnTmplRelSrvDO.getEu_ofreftp();
			String idSrv = emsPrnTmplRelSrvDO.getId_srv();
			if (eu_ofreftp != null && DOStatus.DELETED != emsPrnTmplRelSrvDO.getStatus()
					&& eu_ofreftp.equals(eu_srvcatpenum.SRV) && (idSrv == null || StringUtils.isBlank(idSrv.trim()))) {
				String msg = String.format("医疗单打印模板\"%s\"关联服务列表中服务为空。", emsPrnTmplDO.getName());
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

		EmsPrnTmplRelSrvDO[] relSrvArray = emsprntmplAggDO.getEmsPrnTmplRelSrvDO();
		if (relSrvArray == null || relSrvArray.length <= 0) {
			return null;
		}

		for (EmsPrnTmplRelSrvDO emsPrnTmplRelSrvDO : relSrvArray) {
			String eu_ofreftp = emsPrnTmplRelSrvDO.getEu_ofreftp();
			String idSrvTp = emsPrnTmplRelSrvDO.getId_srvtp();
			if (eu_ofreftp != null && DOStatus.DELETED != emsPrnTmplRelSrvDO.getStatus()
					&& eu_ofreftp.equals(eu_srvcatpenum.CA) && (idSrvTp == null || idSrvTp.trim() == "")) {
				String msg = String.format("医疗单打印模板\"%s\"关联服务列表中服务类型为空。", emsPrnTmplDO.getName());
				return new ValidationFailure(msg);
			}
		}
		return null;
	}

}
