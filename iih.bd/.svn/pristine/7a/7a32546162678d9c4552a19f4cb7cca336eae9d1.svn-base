package iih.bd.mm.materialnames.s.bp.queryer;

import iih.bd.mm.materialnames.d.MnCodeSetDO;
import iih.bd.mm.materialnames.s.bp.creater.MnCodeSetDOCreater;
import iih.bd.srv.medsrv.d.MedSrvCodeSetDO;
import xap.mw.core.data.BizException;

/**
 * 药品通用名编码集查询器
 * 
 * @author hao_wu
 *
 */
public class MnCodeSetQueryer {
	/**
	 * 通过通用名id查询药品通用名编码集
	 * 
	 * @param id
	 * @return
	 * @throws BizException
	 */
	public static MnCodeSetDO[] findMnCodeSetBySrvId(String id) throws BizException {
		MedSrvCodeSetDO[] medSrvCodeSetDOs = MedSrvQueryer.findMedSrvCodeSetBySrvId(id);
		MnCodeSetDO[] mnCodeSetDOs = MnCodeSetDOCreater.createMnCodeSetDOs(medSrvCodeSetDOs);
		return mnCodeSetDOs;
	}
}
