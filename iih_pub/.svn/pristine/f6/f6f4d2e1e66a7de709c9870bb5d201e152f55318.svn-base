package iih.pi.reg.i;

import xap.mw.core.data.BizException;
import iih.pi.reg.dto.pipeqry.d.PiPeQryCondDTO;
import iih.pi.reg.dto.pipeqry.d.PiPeQryRltDTO;

/**
 * 患者域客开服务
 * @author hao_wu 2018-9-2
 *
 */
public interface IPiCustomService {

	/**
	 * 第三方体检患者检索
	 * @param cond 检索条件
	 * @return 检索结果(存在多条未结算体检流水号时，优先返回登记日期最大的数据)
	 * @throws BizException
	 * @author ly 2018/09/02
	 */
	public abstract PiPeQryRltDTO findPatFromPeSystem(PiPeQryCondDTO cond) throws BizException;
	
}
