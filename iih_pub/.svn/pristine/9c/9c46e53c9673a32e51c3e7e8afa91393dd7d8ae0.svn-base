package iih.pi.card.i;

import iih.pi.card.card.d.PiCardDO;
import iih.pi.card.dto.d.CardManageDTO;
import iih.pi.card.dto.d.CardrtnrptDTO;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PiPatCardDO;
import xap.mw.core.data.BizException;

/**
 * 卡管理维护服务
 * 
 * @author Administrator
 *
 */
public interface IPiCardMaintainService {

	/**
	 * 卡录入
	 * 
	 * @param dto
	 * @throws BizException
	 */
	public abstract void entryCards(CardManageDTO dto) throws BizException;

	/**
	 * 卡领取
	 * 
	 * @param dto
	 * @throws BizException
	 */
	public abstract void drawCards(CardManageDTO dto) throws BizException;

	/**
	 * 卡注销
	 * 
	 * @param card
	 * @throws BizException
	 */
	public abstract void cancelCard(PiCardDO card) throws BizException;

	/**
	 * 退卡
	 * 
	 * @param cardDto
	 * @throws BizException
	 */
	public void cardBackSave(CardrtnrptDTO cardDto) throws BizException;

	/**
	 * 卡挂失
	 * 
	 * @param cardDto
	 * @throws BizException
	 */
	public PiPatCardDO cardLossSave(CardrtnrptDTO cardDto) throws BizException;

	/**
	 * 卡取消挂失
	 * 
	 * @param cardDto
	 * @throws BizException
	 */
	public PiPatCardDO cardLossCancelSave(CardrtnrptDTO cardDto) throws BizException;

	/**
	 * 发卡
	 * 
	 * @param cardDo
	 * @param caDo
	 * @throws BizException
	 */
	public void cardDistribute(PiCardDO[] cardDoS, PatDO patDO) throws BizException;

	/**
	 * 根据卡主键进行发卡
	 * 
	 * @param cardIds
	 *            卡ID集合
	 * @throws BizException
	 */
	public void dispCardByIds(String[] cardIds, PatDO patDO) throws BizException;
	
	/**
	 * 根据卡号进行发卡
	 * 
	 * @param cardNo
	 *            卡号
	 * @throws BizException
	 */
	public void dispCardByNo(String cardNo, PatDO patDO) throws BizException;
	/**
	 * 批量导入
	 * @param cardDoS
	 * @throws BizException
	 */
	public void importPiCardInfo(PiCardDO[] cardDoS) throws BizException;
}
