package iih.pi.card.s.bp.cardmanage;

import java.util.ArrayList;
import java.util.List;

import iih.pi.card.card.d.CardSuEnum;
import iih.pi.card.card.d.PiCardDO;
import iih.pi.card.card.s.CardCrudServiceImpl;
import iih.pi.card.dto.d.CardManageDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

public class CardEntryBP {

	/**
	 * 卡录入处理
	 * 
	 * @param dto
	 * @throws BizException
	 */
	public void exec(CardManageDTO dto) throws BizException {

		if (dto == null)
			return;

		// 校验
		this.validate(dto);
		// 插入
		this.insert(dto);
	}

	/**
	 * 逻辑校验
	 * 
	 * @param dto
	 * @throws BizException
	 */
	private void validate(CardManageDTO dto) throws BizException {

		CardCodeCheckBP checkBP = new CardCodeCheckBP();
		checkBP.exec(dto);

		// 存在性校验
		CardCrudServiceImpl cardRService = new CardCrudServiceImpl();

		//String wherePart = String.format("code >= '%s' and code <= '%s'",dto.getCode_begin(), dto.getCode_end());
		String wherePart = String.format("length(code)=length('%s') and length(code)=length('%s') and code >= '%s' and code <= '%s'",dto.getCode_begin(), dto.getCode_end(), dto.getCode_begin(), dto.getCode_end());
		PiCardDO[] dos = cardRService.find(wherePart, "", FBoolean.FALSE);
		if (!ArrayUtil.isEmpty(dos))
			throw new BizException("录入范围内卡号已登录");
	}

	/**
	 * 插入数据
	 * 
	 * @param dto
	 * @throws BizException
	 */
	private void insert(CardManageDTO dto) throws BizException {

		String[] beginA = CardCodeUtil.subString(dto.getCode_begin());
		String[] endA = CardCodeUtil.subString(dto.getCode_end());

		int codelen = beginA[1].length();

		int begin = Integer.parseInt(beginA[1]);
		int end = Integer.parseInt(endA[1]);

		CardCrudServiceImpl cardRService = new CardCrudServiceImpl();

		List<PiCardDO> cardList = new ArrayList<PiCardDO>();
		for (int i = begin; i <= end; i++) {

			String code = beginA[0] + this.getCode(i, codelen);
			cardList.add(this.createCardDO(code, dto));
		}

		cardRService.insert(cardList.toArray(new PiCardDO[cardList.size()]));
	}

	/**
	 * 将数字转为字符串，如果长度小于len则在前补充0
	 * 
	 * @param code
	 * @param len
	 * @return
	 */
	private String getCode(int code, int len) {

		String result = Integer.toString(code);
		int dif = len - result.length();
		if (dif > 0) {
			String head = "";
			for (int i = 0; i < dif; i++) {
				head += "0";
			}
			result = head + result;
		}

		return result;
	}

	/**
	 * 创建就诊卡DO
	 * 
	 * @param code
	 * @param dto
	 * @return
	 */
	private PiCardDO createCardDO(String code, CardManageDTO dto) {
		PiCardDO card = new PiCardDO();
		card.setCode(code);
		card.setId_patcardtp(dto.getId_patcardtp());
		card.setEu_cardsu(CardSuEnum.BLANK);
		card.setId_emp_entry(Context.get().getStuffId());
		card.setFg_password(dto.getFg_password());
		card.setDt_entry(new FDateTime());
		card.setFg_get(FBoolean.FALSE);
		card.setFg_canc(FBoolean.FALSE);
		card.setStatus(DOStatus.NEW);
		card.setId_org(Context.get().getOrgId());
		card.setId_grp(Context.get().getGroupId());
		return card;
	}
}
