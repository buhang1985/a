package iih.mi.mibd.srvfacdircomp.i;

import iih.mi.mibd.srvfacdircomp.d.SrvfacDirCompDTO;
import xap.mw.core.data.BizException;

/**
 * 服务设施拓展服务接口
 *
 *@author hexx
 */
public interface ISrvfacdircompExtCudService {
	
	/**保存服务设施对照接口
	 * @param misId
	 * @param srvfacDirCompDTOs
	 * @return
	 * @throws BizException
	 */
	public abstract SrvfacDirCompDTO[] saveSrvfacComp(String misId,SrvfacDirCompDTO[] srvfacDirCompDTOs) throws BizException;
	
	/**服务设施自动对照接口
	 * @param misId
	 * @throws BizException
	 */
	public void autoComp(String misId) throws BizException;
	
	
	/**服务设施删除服务
	 * @param misId
	 * @param srvfacDirCompDTOs
	 * @return
	 * @throws BizException
	 */
	SrvfacDirCompDTO[]  deleteSrvfacComp (String misId,SrvfacDirCompDTO[] srvfacDirCompDTOs)throws BizException; 
	
}