package iih.bd.srv.medsrv.s.bp;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import xap.mw.core.data.BizException;

/**
 * 诊疗类型医疗服务启用检查业务逻辑
 * 
 * @author hao_wu
 *
 */
public class DiagTreatSrvEnableCheckBp {

	public void exec(MedSrvDO medSrvDO) throws BizException {
		if (medSrvDO == null) {
			return;
		}

		String sdSrvTp = medSrvDO.getSd_srvtp();
		if (sdSrvTp != null && sdSrvTp.length() >= 4
				&& sdSrvTp.substring(0, 4).equals(IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_CONCROSS)) {
			// 会诊
			ConsSrvEnableCheckBp bp = new ConsSrvEnableCheckBp();
			bp.exec(medSrvDO);
		}
	}

}
