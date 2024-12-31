package iih.pi.card.s.bp.cardmanage;

import java.util.HashMap;

import iih.pi.card.card.d.CardSuEnum;
import iih.pi.card.card.d.PiCardDO;
import iih.pi.card.card.i.ICardRService;
import iih.pi.reg.pat.d.PatDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 根据卡主键发放卡片
 * 
 * @author hao_wu 2018-6-7
 *
 */
public class DispCardByIdsBp {

	public void exec(String[] cardIds, PatDO patDo) throws BizException {
		if (cardIds == null || cardIds.length <= 0) {
			return;
		}

		dispCard(cardIds, patDo);
	}

	/**
	 * 发卡
	 * 
	 * @param cardCodes
	 * @throws BizException
	 */
	private void dispCard(String[] cardIds, PatDO patDO) throws BizException {
		HashMap<String, PiCardDO> cardMap = findCardMapByIds(cardIds);
		// 校验卡
		validCards(cardIds, cardMap);
		// 发卡
		dispCard(cardMap.values().toArray(new PiCardDO[0]), patDO);
	}

	/**
	 * 根据卡号查询卡字典
	 * 
	 * @param cardCodes
	 *            卡号集合
	 * @return
	 * @throws BizException
	 */
	private HashMap<String, PiCardDO> findCardMapByIds(String[] cardIds) throws BizException {
		HashMap<String, PiCardDO> piCardMap = new HashMap<String, PiCardDO>();

		ICardRService cardRService = ServiceFinder.find(ICardRService.class);
		PiCardDO[] result = cardRService.findByIds(cardIds, FBoolean.FALSE);
		if (result != null && result.length > 0) {
			for (PiCardDO piCardDO : result) {
				piCardMap.put(piCardDO.getId_card(), piCardDO);
			}
		}
		return piCardMap;
	}

	/**
	 * 发卡
	 * 
	 * @param piCards
	 * @throws BizException
	 */
	private void dispCard(PiCardDO[] piCards, PatDO patDo) throws BizException {
		CardDistributeBp bp = new CardDistributeBp();
		bp.exec(piCards, patDo);
	}

	/**
	 * 校验卡
	 * 
	 * @param cardCodes
	 * @param cardMap
	 * @throws BizException
	 */
	private void validCards(String[] cardIds, HashMap<String, PiCardDO> cardMap) throws BizException {
		for (String cardId : cardIds) {
			if (!cardMap.containsKey(cardId)) {
				throw new BizException("卡%s未录入系统，无法使用。");
			}
			PiCardDO cardDo = cardMap.get(cardId);

			if (cardDo.getEu_cardsu() != CardSuEnum.BLANK) {
				throw new BizException("该卡非空白卡，无法使用:" + cardDo.getCode());
			}

			if (!FBoolean.TRUE.equals(cardDo.getFg_get())) {
				throw new BizException("该卡未领取，无法使用:" + cardDo.getCode());
			}
		}
	}
}
