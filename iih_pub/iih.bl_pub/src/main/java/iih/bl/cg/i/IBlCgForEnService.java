package iih.bl.cg.i;

import iih.bl.cg.dto.en.opaccount.d.BlCgOpAccount4EnDTO;
import iih.bl.cg.dto.en.opaccount.d.BlCgOpAccountRlt4EnDTO;
import iih.bl.cg.dto.en.opaccount.d.BlCgOpRefund4EnDTO;
import iih.bl.cg.dto.en.opaccount.d.BlCgReplaceEntDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 费用记帐域对就诊提供服务
 * @author ly 2019/10/31
 *
 */
public interface IBlCgForEnService {

	/**
	 * 挂号记账
	 * @param accDto
	 * @return
	 * @throws BizException
	 * @author ly 2019/10/31
	 */
	public abstract BlCgOpAccountRlt4EnDTO opKeepAccount(BlCgOpAccount4EnDTO accDto) throws BizException;
	
	/**
	 * 挂号取消记账
	 * @param rfdDto
	 * @throws BizException
	 * @author ly 2019/10/31
	 */
	public abstract void opRefundAccount(BlCgOpRefund4EnDTO rfdDto) throws BizException;
	
	/**
	 * 替诊时更新费用
	 * @param dto
	 * @throws BizException
	 * @author ly 2019/11/18
	 */
	public abstract void updateCgWhenReplaceEnt(BlCgReplaceEntDTO dto) throws BizException;
	
	/**
	 * 预住院患者是否有费用转入门诊/住院
	 * @param idEnt : 预住院就诊主键
	 * @param isOep : Y:门诊，否则是住院
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean isPreipTransf(String idEnt,FBoolean isOep) throws BizException;
}
