package iih.bd.srv.medsrv.s.bp;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import xap.mw.core.data.BizException;

/**
 * 护理类型医疗服务启用检查业务逻辑
 * 
 * @author hao_wu
 *
 */
public class NurseSrvEnableCheckBp {

	public void exec(MedSrvDO medSrvDO) throws BizException {
		if (medSrvDO == null) {
			return;
		}

		String sdSrvTp = medSrvDO.getSd_srvtp();
		if (sdSrvTp != null && sdSrvTp.length() >= 4
				&& sdSrvTp.substring(0, 4).equals(IBdSrvDictCodeConst.SD_SRVTP_NURSE_VS)) {
			// 生命体征需单独校验
			VitalSignsSrvEnableCheckBp bp = new VitalSignsSrvEnableCheckBp();
			bp.exec(medSrvDO);
			return;
		}
	}
}
