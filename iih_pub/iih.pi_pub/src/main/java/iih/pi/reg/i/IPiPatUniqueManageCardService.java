package iih.pi.reg.i;

import iih.pi.reg.dto.uniquemanage.d.PiPatDealRltDTO;
import iih.pi.reg.pat.d.PiPatCardDO;
import xap.mw.core.data.BizException;

/**
 * 患者唯一性管理服务(客开服务)
 * (用于第三方平台患者唯一性管理卡管理)
 * @author ly 2019/06/04
 *
 */
public interface IPiPatUniqueManageCardService {

	/**
	 * 退卡
	 * @param cardDO 卡信息
	 * @return 处理结果
	 * @throws BizException
	 * @author ly 2019/06/04
	 */
	public abstract PiPatDealRltDTO withdrawCard(PiPatCardDO cardDO) throws BizException;
	
	/**
	 * 挂失
	 * @param cardDO 卡信息
	 * @return 处理结果
	 * @throws BizException
	 * @author ly 2019/06/04
	 */
	public abstract PiPatDealRltDTO lossCard(PiPatCardDO cardDO) throws BizException;
	
	/**
	 * 补卡
	 * @param cardDO 卡信息
	 * @return 处理结果
	 * @throws BizException
	 * @author ly 2019/06/04
	 */
	public abstract PiPatDealRltDTO patchCard(PiPatCardDO[] cardDO) throws BizException;
}
