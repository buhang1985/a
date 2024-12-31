package iih.bd.srv.ems.s.validator;

import org.apache.commons.lang.StringUtils;

import iih.bd.srv.ems.d.EmsDO;
import iih.bd.srv.ems.d.EmsRelSrvDO;
import iih.bd.srv.ems.d.EmsregistryAggDO;
import iih.bd.srv.ems.d.eu_srvcatpenum;
import xap.mw.core.data.DOStatus;
import xap.sys.appfw.bizrule.validation.ValidationFailure;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 医疗单关联服务数据校验
 * 
 * @author hao_wu
 *
 */
public class EmsRelSrvDODataValidate implements Validator {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6137555905121412601L;

	@Override
	public ValidationFailure validate(Object... aobj) {
		if (aobj == null || aobj.length <= 0) {
			return null;
		}
		for (Object object : aobj) {
			if (object instanceof EmsregistryAggDO) {
				ValidationFailure vFailure = srvValidate((EmsregistryAggDO) object);
				if (vFailure != null) {
					return vFailure;
				}
				vFailure = srvTpValidate((EmsregistryAggDO) object);
				if (vFailure != null) {
					return vFailure;
				}
				vFailure = repeatValidate((EmsregistryAggDO) object);
				if (vFailure != null) {
					return vFailure;
				}
			}

		}
		return null;
	}

	/**
	 * 重复校验
	 * 
	 * @param emsregistryAggDO
	 * @return
	 */
	private ValidationFailure repeatValidate(EmsregistryAggDO emsregistryAggDO) {
		if (emsregistryAggDO == null) {
			return null;
		}

		EmsDO emsDO = emsregistryAggDO.getParentDO();
		if (emsDO == null) {
			return null;
		}

		EmsRelSrvDO[] relSrvArray = emsregistryAggDO.getEmsRelSrvDO();
		ValidationFailure vFailure = relSrvRepeatValidate(relSrvArray, emsDO);
		if (vFailure != null) {
			return vFailure;
		}

		return null;
	}

	/**
	 * 关联服务重复检查
	 * 
	 * @param relSrvArray
	 * @return
	 */
	private ValidationFailure relSrvRepeatValidate(EmsRelSrvDO[] relSrvArray, EmsDO emsDO) {
		if (relSrvArray == null || relSrvArray.length <= 0) {
			return null;
		}
		for (int i = 0; i < relSrvArray.length; i++) {
			EmsRelSrvDO relSrv1 = relSrvArray[i];
			if (relSrv1 != null && relSrv1.getStatus() == DOStatus.DELETED) {
				continue;
			}
			for (int j = i + 1; j < relSrvArray.length; j++) {
				EmsRelSrvDO relSrv2 = relSrvArray[j];
				if (relSrv2 != null && relSrv2.getStatus() == DOStatus.DELETED) {
					continue;
				}
				if (relSrv1.getEu_ofreftp() != null && relSrv2.getEu_ofreftp() != null
						&& relSrv1.getEu_ofreftp().equals(relSrv2.getEu_ofreftp())
						&& relSrv1.getEu_ofreftp().equals(eu_srvcatpenum.SRV) && relSrv1.getId_srv() != null
						&& relSrv2.getId_srv() != null && relSrv1.getId_srv().equals(relSrv2.getId_srv())) {
					String msg = String.format("医疗单\"%s\"关联服务列表中服务重复，重复服务：\"%s\"。", emsDO.getName(),
							relSrv2.getSrvname());
					return new ValidationFailure(msg);
				}
				if (relSrv1.getEu_ofreftp() != null && relSrv2.getEu_ofreftp() != null
						&& relSrv1.getEu_ofreftp().equals(relSrv2.getEu_ofreftp())
						&& relSrv1.getEu_ofreftp().equals(eu_srvcatpenum.CA) && relSrv1.getId_srvtp() != null
						&& relSrv2.getId_srvtp() != null && relSrv1.getId_srvtp().equals(relSrv2.getId_srvtp())) {
					String msg = String.format("医疗单\"%s\"关联服务列表中服务类型重复，重复服务类型：\"%s\"。", emsDO.getName(),
							relSrv1.getSrvtpname());
					return new ValidationFailure(msg);
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
	private ValidationFailure srvValidate(EmsregistryAggDO emsregistryAggDO) {
		if (emsregistryAggDO == null) {
			return null;
		}
		EmsDO emsDo = emsregistryAggDO.getParentDO();

		EmsRelSrvDO[] relSrvArray = emsregistryAggDO.getEmsRelSrvDO();
		if (relSrvArray == null || relSrvArray.length <= 0) {
			return null;
		}

		for (EmsRelSrvDO emsRelSrvDO : relSrvArray) {
			String eu_ofreftp = emsRelSrvDO.getEu_ofreftp();
			String idSrv = emsRelSrvDO.getId_srv();
			if (eu_ofreftp != null && DOStatus.DELETED != emsRelSrvDO.getStatus()
					&& eu_ofreftp.equals(eu_srvcatpenum.SRV) && (idSrv == null || StringUtils.isBlank(idSrv.trim()))) {
				String msg = String.format("医疗单\"%s\"关联服务列表中服务为空。", emsDo.getName());
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
	private ValidationFailure srvTpValidate(EmsregistryAggDO emsregistryAggDO) {
		if (emsregistryAggDO == null) {
			return null;
		}
		EmsDO emsDo = emsregistryAggDO.getParentDO();

		EmsRelSrvDO[] relSrvArray = emsregistryAggDO.getEmsRelSrvDO();
		if (relSrvArray == null || relSrvArray.length <= 0) {
			return null;
		}

		for (EmsRelSrvDO emsRelSrvDO : relSrvArray) {
			String eu_ofreftp = emsRelSrvDO.getEu_ofreftp();
			String idSrvTp = emsRelSrvDO.getId_srvtp();
			if (eu_ofreftp != null && DOStatus.DELETED != emsRelSrvDO.getStatus()
					&& eu_ofreftp.equals(eu_srvcatpenum.CA)
					&& (idSrvTp == null || StringUtils.isBlank(idSrvTp.trim()))) {
				String msg = String.format("医疗单\"%s\"关联服务列表中类型为空。", emsDo.getName());
				return new ValidationFailure(msg);
			}
		}
		return null;
	}

}
