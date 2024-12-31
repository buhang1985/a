package iih.bd.srv.ems.s.validator;

import iih.bd.srv.ems.d.EmsDO;
import iih.bd.srv.ems.d.EmsIndexDO;
import iih.bd.srv.ems.d.EmsregistryAggDO;
import xap.mw.core.data.DOStatus;
import xap.sys.appfw.bizrule.validation.ValidationFailure;
import xap.sys.appfw.bizrule.validation.Validator;

public class EmsIndexDODataValidate implements Validator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7772289061807948388L;

	@Override
	public ValidationFailure validate(Object... aobj) {
		if (aobj == null || aobj.length <= 0) {
			return null;
		}
		for (Object object : aobj) {
			if (object instanceof EmsregistryAggDO) {
				ValidationFailure vFailure = repeatValidate((EmsregistryAggDO) object);
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

		if (emsDO.getFg_ofdyncitm() != null && emsDO.getFg_ofdyncitm().booleanValue() == true) {
			EmsIndexDO[] emdIndexArray = emsregistryAggDO.getEmsIndexDO();
			ValidationFailure vFailure = emsIndexRepeatValidate(emdIndexArray, emsDO);
			if (vFailure != null) {
				return vFailure;
			}
		}

		return null;
	}

	/**
	 * 关联指标重复性校验
	 * 
	 * @param emdIndexArray
	 * @param emsDO
	 * @return
	 */
	private ValidationFailure emsIndexRepeatValidate(EmsIndexDO[] emdIndexArray, EmsDO emsDO) {
		if (emdIndexArray == null || emdIndexArray.length <= 0) {
			return null;
		}

		for (int i = 0; i < emdIndexArray.length; i++) {
			EmsIndexDO emsIndex1 = emdIndexArray[i];
			if (emsIndex1 != null && emsIndex1.getStatus() == DOStatus.DELETED) {
				continue;
			}
			for (int j = i + 1; j < emdIndexArray.length; j++) {

				EmsIndexDO emsIndex2 = emdIndexArray[j];
				if (emsIndex2 != null && emsIndex2.getStatus() == DOStatus.DELETED) {
					continue;
				}
				if (emsIndex1 != null && emsIndex2 != null && emsIndex1.getId_srv() != null
						&& emsIndex2.getId_srv() != null && emsIndex1.getId_srv().equals(emsIndex2.getId_srv())) {
					String msg = String.format("医疗单\"%s\"动态指标项目列表中动态指标项目重复，重复动态指标项目：\"%s\"。", emsDO.getName(),
							emsIndex1.getSrvname());
					return new ValidationFailure(msg);
				}
			}
		}

		return null;
	}

}
