package iih.pi.card.s.bp.cardmanage;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.pi.card.act.d.PiCardActDO;
import iih.pi.card.act.s.ActCrudServiceImpl;
import iih.pi.card.card.d.CardSuEnum;
import iih.pi.card.card.d.PiCardDO;
import iih.pi.card.card.s.CardCrudServiceImpl;
import iih.pi.card.iss.d.PiCardIssDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.permfw.user.d.UserDO;
import xap.sys.permfw.user.i.IUserRService;

public class CardCancelBP {

	/**
	 * 卡注销处理
	 * @param card
	 * @throws BizException
	 */
	public void exec(PiCardDO card) throws BizException{
		
		if(card == null)
			return;
		
		this.validate(card);
		
		this.insertIss(card);
		
		this.updateCard(card);
	}
	
	/**
	 * 逻辑校验
	 * @param card
	 * @throws BizException
	 */
	private void validate(PiCardDO card) throws BizException{
		if(StringUtil.isEmpty(card.getDes_canc()))
			throw new BizException("销卡原因不能为空");
		
		if(!CardSuEnum.BLANK.equals(card.getEu_cardsu()))
			throw new BizException("卡不是空白卡，无法注销");
	}
	
	/**
	 * 登录就诊卡操作记录
	 * @param card
	 * @throws BizException
	 */
	private void insertIss(PiCardDO card) throws BizException{
		ActCrudServiceImpl actService = new ActCrudServiceImpl();
		
		PiCardActDO actDo = new PiCardActDO();
		actDo.setId_card(card.getId_card());
		actDo.setId_cardacttp(IPiDictCodeConst.ID_CARDACTTP_CANCEL);//注销
		actDo.setSd_cardacttp(IPiDictCodeConst.SD_CARDACTTP_CANCEL);
		actDo.setId_emp_act(Context.get().getStuffId());
		actDo.setDt_act(new FDateTime());
		actDo.setDes_act("注销：" + card.getDes_canc());
		actDo.setStatus(DOStatus.NEW);
		
		actService.insert(actDo);
	}
	
	/**
	 *  更新患者就诊卡数据
	 * @param card
	 * @throws BizException
	 */
	private void updateCard(PiCardDO card) throws BizException{
		CardCrudServiceImpl cardService = new CardCrudServiceImpl();
		
		card.setEu_cardsu(CardSuEnum.CANCEL);
		card.setFg_canc(FBoolean.TRUE);
		card.setId_emp_canc(Context.get().getStuffId());
		card.setDt_canc(new FDateTime());
		card.setStatus(DOStatus.UPDATED);
		
		cardService.update(card);
	}
}
