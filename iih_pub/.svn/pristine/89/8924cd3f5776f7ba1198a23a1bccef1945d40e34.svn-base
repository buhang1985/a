package iih.mp.dg.transreg.i;

import iih.mp.dg.transreg.dto.d.TransRegPrePaySrvDTO;
import xap.mw.core.data.BizException;

/**
 * 输液登记扩展查询服务接口
 * 
 * @author hao_wu 2018-5-24
 *
 */
public interface ITransRegExtRService {

	/**
	 * 查询患者在当前科室未记账服务列表
	 * 
	 * @param patId
	 *            患者主键
	 * @return
	 * @throws BizException
	 */
	public abstract TransRegPrePaySrvDTO[] findPendingAccontCiSrvs(String patId) throws BizException;
}
