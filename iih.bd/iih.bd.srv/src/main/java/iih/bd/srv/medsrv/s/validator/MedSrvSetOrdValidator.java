package iih.bd.srv.medsrv.s.validator;

import java.util.ArrayList;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.bizrule.validation.ValidationFailure;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 医疗服务服务套开立方式校验</br>
 * 当服务套标识为true时，服务套开立方式不允许为空
 * 
 * @author hao_wu
 *
 */
public class MedSrvSetOrdValidator implements Validator {

	@Override
	public ValidationFailure validate(Object... arg0) {
		MedSrvDO[] medSrvArr = ConvertToMedsrvArray(arg0);
		ValidationFailure vFailure = CheckSetOrd(medSrvArr);
		return vFailure;
	}

	/**
	 * 检查服务套开立方式
	 * 
	 * @param medSrvArr
	 * @return
	 */
	private ValidationFailure CheckSetOrd(MedSrvDO[] medSrvArr) {
		for (MedSrvDO medSrvDO : medSrvArr) {
			ValidationFailure vFailure = CheckSetOrd(medSrvDO);
			if (vFailure != null) {
				return vFailure;
			}
		}
		return null;
	}

	/**
	 * 检查服务套开立方式
	 * 
	 * @param medSrvDO
	 * @return
	 */
	private ValidationFailure CheckSetOrd(MedSrvDO medSrvDO) {
		if (medSrvDO != null && medSrvDO.getFg_set() != null && medSrvDO.getFg_set().equals(FBoolean.TRUE)
				&& medSrvDO.getId_setord() == null) {
			String msg = String.format("医疗服务\"%s\"是服务套，服务套开立方式不允许为空。", medSrvDO.getName());
			return new ValidationFailure(msg);
		}
		return null;
	}

	/**
	 * 转换为医疗服务数组
	 * 
	 * @param arg0
	 * @return
	 */
	private MedSrvDO[] ConvertToMedsrvArray(Object[] arg0) {
		ArrayList<MedSrvDO> medSrvArr = new ArrayList<MedSrvDO>();
		for (Object object : arg0) {
			if (object instanceof MedSrvDO) {
				medSrvArr.add((MedSrvDO) object);
			} else if (object instanceof MedsrvAggDO) {
				MedsrvAggDO aggDo = (MedsrvAggDO) object;
				medSrvArr.add(aggDo.getParentDO());
			}
		}

		return medSrvArr.toArray(new MedSrvDO[0]);
	}

}
