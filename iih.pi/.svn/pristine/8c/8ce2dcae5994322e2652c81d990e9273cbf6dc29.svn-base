package iih.pi.card.s.bp.cardmanage;

import iih.pi.card.card.d.CardSuEnum;
import iih.pi.card.card.d.PiCardDO;
import iih.pi.card.card.i.ICardRService;
import iih.pi.reg.pat.d.PatDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 根据卡号发放卡片
 * 
 * @author dj.zhang
 *
 */
public class DispCardByCardNoBp {

	public void exec(String cardNo, PatDO patDO) throws BizException {
		if (cardNo == null) {
			return;
		}

		dispCard(cardNo, patDO);

	}

	/**
	 * 发卡
	 * 
	 * @param cardNo
	 * @param patDO
	 * @throws BizException 
	 */
	private void dispCard(String cardNo, PatDO patDO) throws BizException {
		PiCardDO piCardDO = findPiCardDOByCardNo(cardNo);
		// 校验卡
		validCard(cardNo, piCardDO);
		// 发卡
		dispCard(new PiCardDO[] { piCardDO }, patDO);

	}

	/**
	 * 发卡
	 * 
	 * @param piCardDOs
	 * @param patDO
	 * @throws BizException 
	 */
	private void dispCard(PiCardDO[] piCardDOs, PatDO patDO) throws BizException {
		CardDistributeBp bp = new CardDistributeBp();
		bp.exec(piCardDOs, patDO);
	}

	/**
	 * 校验卡
	 * 
	 * @param cardNo
	 * @param piCardDO
	 * @throws BizException
	 */
	private void validCard(String cardNo, PiCardDO piCardDO) throws BizException {
		if (piCardDO == null) {
			throw new BizException("卡%s未录入系统，无法使用。");
		}
		if (piCardDO.getEu_cardsu() != CardSuEnum.BLANK) {
			throw new BizException("该卡非空白卡，无法使用:" + piCardDO.getCode());
		}

		if (!FBoolean.TRUE.equals(piCardDO.getFg_get())) {
			throw new BizException("该卡未领取，无法使用:" + piCardDO.getCode());
		}
	}

	/**
	 * 根据卡号查询卡
	 * 
	 * @param cardNo
	 * @return
	 * @throws BizException
	 */
	private PiCardDO findPiCardDOByCardNo(String cardNo) throws BizException {
		ICardRService cardRService = ServiceFinder.find(ICardRService.class);
		PiCardDO[] cardDOs = cardRService.findByAttrValString("Code", cardNo);
		if (cardDOs != null && cardDOs.length > 0) {
			return cardDOs[0];
		}
		return null;
	}

}
