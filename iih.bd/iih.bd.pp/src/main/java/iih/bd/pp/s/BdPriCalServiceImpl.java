package iih.bd.pp.s;

import iih.bd.pp.dto.priview.d.BdPriViewDTO;
import iih.bd.pp.i.IBdPriCalService;
import iih.bd.pp.s.bp.prinew.BdPpCalSrvPriceBP;
import xap.mw.core.data.BizException;

/**
 * 价格计算(新服务)
 * @author ly 2018/06/27
 *
 */
public class BdPriCalServiceImpl implements IBdPriCalService{

	/**
	 * 计算服务价格
	 * @param srvIds 服务id
	 * @param pripatIds 价格分类id
	 * @return 计价结果
	 * @throws BizException
	 * @author ly 2018/06/27
	 */
	@Override
	public BdPriViewDTO[] calSrvPrice(String[] srvIds, String[] pripatIds) throws BizException {
		BdPpCalSrvPriceBP bp = new BdPpCalSrvPriceBP();
		return bp.exec(srvIds, pripatIds);
	}

}
