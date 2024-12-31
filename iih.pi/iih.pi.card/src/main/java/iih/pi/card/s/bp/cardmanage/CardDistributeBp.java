package iih.pi.card.s.bp.cardmanage;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.pi.card.act.d.PiCardActDO;
import iih.pi.card.act.i.IActCudService;
import iih.pi.card.card.d.CardSuEnum;
import iih.pi.card.card.d.PiCardDO;
import iih.pi.card.card.i.ICardCudService;
import iih.pi.reg.pat.d.PatDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 发卡业务逻辑
 * 
 * @author hao_wu
 *
 */
public class CardDistributeBp {
	/**
	 * 发卡
	 * 
	 * @param cardDo
	 * @throws BizException
	 */
	public void exec(PiCardDO[] cardDOS, PatDO patDo) throws BizException {
		if (cardDOS == null || cardDOS.length <= 0) {
			throw new BizException("卡信息不允许为空。");
		}

		PiCardDO[] result = dispCards(cardDOS);
		saveCardChangeRec(result, patDo);
	}

	/**
	 * 发卡
	 * 
	 * @param piCards
	 * @return
	 * @throws BizException
	 */
	private PiCardDO[] dispCards(PiCardDO[] piCards) throws BizException {
		for (PiCardDO piCardDO : piCards) {
			piCardDO.setEu_cardsu(CardSuEnum.USING);
			piCardDO.setStatus(DOStatus.UPDATED);
		}

		ICardCudService cardCudService = ServiceFinder.find(ICardCudService.class);
		PiCardDO[] result = cardCudService.update(piCards);
		return result;
	}

	/**
	 * 保存卡变更记录
	 * 
	 * @param piCards
	 * @param patDo
	 * @throws BizException
	 */
	private void saveCardChangeRec(PiCardDO[] piCards, PatDO patDo) throws BizException {
		if (piCards == null || piCards.length <= 0) {
			return;
		}

		// 将要进行状态变更的卡信息
		List<PiCardActDO> ListCardActDOS = new ArrayList<PiCardActDO>();
		for (PiCardDO cardDo : piCards) {

			PiCardActDO cardRecDo = getCardChangeRec(cardDo, patDo);
			if (cardRecDo != null) {
				ListCardActDOS.add(cardRecDo);
			}
		}

		IActCudService actservice = ServiceFinder.find(IActCudService.class);
		actservice.insert(ListCardActDOS.toArray(new PiCardActDO[0]));
	}

	/**
	 * 获取发卡变更记录
	 * 
	 * @param cardDo
	 * @param patDo
	 * @return
	 */
	private PiCardActDO getCardChangeRec(PiCardDO cardDo, PatDO patDo) {
		PiCardActDO actDo = new PiCardActDO();
		actDo.setStatus(DOStatus.NEW);
		actDo.setId_emp_act(Context.get().getStuffId());
		actDo.setDt_act(new FDateTime());
		actDo.setId_cardiss(null);
		actDo.setId_card(cardDo.getId_card());
		actDo.setId_cardacttp(IPiDictCodeConst.ID_CARDACTTP_SEND);// 领用
		actDo.setSd_cardacttp(IPiDictCodeConst.SD_CARDACTTP_SEND);
		actDo.setDes_act("领用");
		actDo.setId_pat(patDo.getId_pat());
		return actDo;
	}
}
