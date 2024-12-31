package iih.bd.srv.medsrv.s.validator.bp;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import xap.sys.appfw.bizrule.validation.ValidationFailure;

/**
 * 医疗服务校验业务逻辑
 * 
 * @author hao_wu
 *
 */
public class MedSrvValidateBp {

	public ValidationFailure exec(MedsrvAggDO object) {
		if (object == null) {
			return null;
		}

		ValidationFailure vFailure = checkSrvTpCodeLength(object);
		if (vFailure != null) {
			return vFailure;
		}

		return null;
	}

	/**
	 * 检查服务类型编码长度
	 * 
	 * @param object
	 * @return
	 */
	private ValidationFailure checkSrvTpCodeLength(MedsrvAggDO object) {
		MedSrvDO medSrvDO = object.getParentDO();
		if (medSrvDO != null) {
			if (medSrvDO.getSd_srvtp() == null || medSrvDO.getSd_srvtp().length() < 4) {
				String msg = String.format("医疗服务\"%s\"中服务类型编码长度不能小于4位。", medSrvDO.getName());
				return new ValidationFailure(msg);
			}
		}
		return null;
	}
}
