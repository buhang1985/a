package iih.bd.pp.i;

import xap.mw.core.data.BizException;
import iih.bd.pp.dto.priview.d.BdPriViewDTO;

/**
 * 价格计算(新服务)
 * @author ly 2018/06/27
 *
 */
public interface IBdPriCalService {

	/**
	 * 计算服务价格
	 * @param srvIds 服务id
	 * @param pripatIds 价格分类id
	 * @return 计价结果
	 * @throws BizException
	 * @author ly 2018/06/27
	 */
	public abstract BdPriViewDTO[] calSrvPrice(String[] srvIds,String[] pripatIds) throws BizException;
}
