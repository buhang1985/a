package iih.bd.mm.materialnames.s.bp.creater;

import iih.bd.mm.materialnames.d.MnCodeSetDO;
import iih.bd.mm.materialnames.d.adapter.MnCodeSetDOAdapter;
import iih.bd.srv.medsrv.d.MedSrvCodeSetDO;

/**
 * 药品通用名编码集创建器
 * 
 * @author hao_wu
 *
 */
public class MnCodeSetDOCreater {
	/**
	 * 创建药品通用名编码集
	 * 
	 * @param medSrvCodeSetDOs
	 * @return
	 */
	public static MnCodeSetDO[] createMnCodeSetDOs(MedSrvCodeSetDO[] medSrvCodeSetDOs) {
		MnCodeSetDOAdapter adapter = new MnCodeSetDOAdapter();
		MnCodeSetDO[] codeSets = adapter.getMnCodeSetDOs(medSrvCodeSetDOs);
		return codeSets;
	}
}
