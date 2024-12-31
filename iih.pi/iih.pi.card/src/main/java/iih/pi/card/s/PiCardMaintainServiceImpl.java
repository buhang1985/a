package iih.pi.card.s;

import iih.pi.card.card.d.PiCardDO;
import iih.pi.card.dto.d.CardManageDTO;
import iih.pi.card.dto.d.CardrtnrptDTO;
import iih.pi.card.i.IPiCardMaintainService;
import iih.pi.card.s.bp.cardmanage.CardCancelBP;
import iih.pi.card.s.bp.cardmanage.CardDistributeBp;
import iih.pi.card.s.bp.cardmanage.CardDrawBP;
import iih.pi.card.s.bp.cardmanage.CardEntryBP;
import iih.pi.card.s.bp.cardmanage.DispCardByCardNoBp;
import iih.pi.card.s.bp.cardmanage.DispCardByIdsBp;
import iih.pi.card.s.bp.cardmanage.ImportPiCardInfoBP;
import iih.pi.card.s.bp.cardrtnrpt.CardBaceSaveBp;
import iih.pi.card.s.bp.cardrtnrpt.CardLossBp;
import iih.pi.card.s.bp.cardrtnrpt.CardLossCancelBp;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PiPatCardDO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

/**
 * 卡管理维护服务
 * 
 * @author Administrator
 *
 */
@Service(serviceInterfaces = { IPiCardMaintainService.class }, binding = Binding.JSONRPC)
public class PiCardMaintainServiceImpl implements IPiCardMaintainService {

	/**
	 * 卡录入
	 * 
	 * @param dto
	 * @throws BizException
	 */
	@Override
	public void entryCards(CardManageDTO dto) throws BizException {
		CardEntryBP bp = new CardEntryBP();
		bp.exec(dto);
	}

	/**
	 * 卡领取
	 * 
	 * @param dto
	 * @throws BizException
	 */
	@Override
	public void drawCards(CardManageDTO dto) throws BizException {
		CardDrawBP bp = new CardDrawBP();
		bp.exec(dto);
	}

	/**
	 * 卡注销
	 * 
	 * @param card
	 * @throws BizException
	 */
	@Override
	public void cancelCard(PiCardDO card) throws BizException {
		CardCancelBP bp = new CardCancelBP();
		bp.exec(card);
	}

	/**
	 * 退卡
	 * 
	 * @param cardDto
	 * @throws BizException
	 */
	@Override
	public void cardBackSave(CardrtnrptDTO cardDto) throws BizException {
		CardBaceSaveBp bp = new CardBaceSaveBp();
		bp.exec(cardDto);
	}

	/**
	 * 卡挂失
	 * 
	 * @param cardDto
	 * @throws BizException
	 */
	@Override
	public PiPatCardDO cardLossSave(CardrtnrptDTO cardDto) throws BizException {
		CardLossBp bp = new CardLossBp();
		return bp.exec(cardDto);
	}

	/**
	 * 卡取消挂失
	 * 
	 * @param cardDto
	 * @throws BizException
	 */
	@Override
	public PiPatCardDO cardLossCancelSave(CardrtnrptDTO cardDto) throws BizException {
		CardLossCancelBp bp = new CardLossCancelBp();
		return bp.exec(cardDto);
	}

	/**
	 * 发卡
	 *
	 * @param cardDo
	 * @throws BizException
	 */
	@Override
	public void cardDistribute(PiCardDO[] cardDoS, PatDO patDO) throws BizException {

		CardDistributeBp bp = new CardDistributeBp();
		bp.exec(cardDoS, patDO);
	}

	/**
	 * 根据卡主键进行发卡
	 * 
	 * @param cardIds
	 *            卡ID集合
	 * @throws BizException
	 */
	@Override
	public void dispCardByIds(String[] cardIds, PatDO patDo) throws BizException {
		DispCardByIdsBp bp = new DispCardByIdsBp();
		bp.exec(cardIds, patDo);
	}

	/**
	 * 根据卡号进行发卡
	 * 
	 * @param cardNo
	 *            卡号
	 * @throws BizException
	 */
	@Override
	public void dispCardByNo(String cardNo, PatDO patDO) throws BizException {
		DispCardByCardNoBp bp = new DispCardByCardNoBp();
		bp.exec(cardNo, patDO);
	}

	/**
	 * 批量导入
	 * @param cardDoS
	 * @throws BizException
	 */
	@Override
	public void importPiCardInfo(PiCardDO[] cardDoS) throws BizException {
		ImportPiCardInfoBP bp=new ImportPiCardInfoBP();
		bp.exec(cardDoS);
	}
	
	
}
