package iih.bd.srv.medsrv.s.rule.bp;

import iih.bd.srv.medsrv.d.MedSrvAliasDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import xap.mw.core.data.DOStatus;

/**
 * 医疗服务设置别名集助记码业务逻辑
 * 
 * @author hao_wu
 *
 */
public class MedsrvAggSetAliasMnecodeBp {

	public void exec(MedsrvAggDO medsrvAggDO) {
		if (medsrvAggDO == null) {
			return;
		}
		setAliasMnecode(medsrvAggDO);
	}

	/**
	 * 设置别名集助记码
	 * 
	 * @param medsrvAggDO
	 */
	private void setAliasMnecode(MedsrvAggDO medsrvAggDO) {
		MedSrvDO mData = medsrvAggDO.getParentDO();
		MedSrvAliasDO[] medSrvAliasDOArr = medsrvAggDO.getMedSrvAliasDO();
		if (mData == null || medSrvAliasDOArr == null || medSrvAliasDOArr.length <= 0) {
			return;
		}
		for (MedSrvAliasDO medSrvAliasDO : medSrvAliasDOArr) {
			if (medSrvAliasDO.getStatus() == DOStatus.DELETED) {
				continue;
			}
			medSrvAliasDO.setMnecode(mData.getMnecode());
			if (medSrvAliasDO.getStatus() == DOStatus.UNCHANGED) {
				medSrvAliasDO.setStatus(DOStatus.UPDATED);
			}
		}
	}

}
