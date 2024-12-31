package iih.pi.card.s.bp.cardrtnrpt;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.pi.card.act.d.PiCardActDO;
import iih.pi.card.act.i.IActCudService;
import iih.pi.card.card.d.CardSuEnum;
import iih.pi.card.card.d.PiCardDO;
import iih.pi.card.card.i.ICardCudService;
import iih.pi.card.card.i.ICardRService;
import iih.pi.card.dto.d.CardrtnrptDTO;
import iih.pi.params.PiParams;
import iih.pi.reg.pat.d.PiPatCardDO;
import iih.pi.reg.pat.i.IPiPatCardDOCudService;
import iih.pi.reg.pat.i.IPiPatCardDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 卡取消挂失处理
 * 
 * @author 未知
 * @version ly 2019/03/27 重构
 *
 */
public class CardLossCancelBp {

	/**
	 * 卡取消挂失
	 * 
	 * @param dto
	 * @throws BizException
	 */
	public PiPatCardDO exec(CardrtnrptDTO dto) throws BizException {

		this.validate(dto);

		// 更新卡库卡状态
		this.updateCard(dto);

		// 插入卡操作记录
		this.saveCardActData(dto);

		// 更新就诊卡状态
		PiPatCardDO patCardDO = this.updatePiPatCard(dto);

		return patCardDO;
	}

	/**
	 * 校验
	 * 
	 * @param dto
	 * @throws BizException
	 */
	private void validate(CardrtnrptDTO dto) throws BizException {

		if (dto == null) {
			throw new BizException("卡取消挂失:入参数据为空");
		}

		if (StringUtil.isEmpty(dto.getId_patcard())) {
			throw new BizException("卡取消挂失:入参患者卡id为空");
		}
		PiParams pi = new PiParams();
		if (FBoolean.FALSE.equals(pi.PIPAT0020())) {
			IPiPatCardDORService piCardRService = ServiceFinder.find(IPiPatCardDORService.class);
			PiPatCardDO[] piCardDOs = piCardRService.findByAttrValString(PiPatCardDO.ID_PAT, dto.getId_pat());
			for (PiPatCardDO piCardDO : piCardDOs) {
				if (FBoolean.TRUE.equals(piCardDO.getFg_act())) {
					throw new BizException("取消挂失时 存在多张启用的相同类型卡 请先保存数据再继续");
				}
			}
		}

	}

	/**
	 * 保存卡操作记录
	 * 
	 * @param dto
	 * @throws BizException
	 */
	private void saveCardActData(CardrtnrptDTO dto) throws BizException {

		PiCardActDO actDo = new PiCardActDO();
		actDo.setStatus(DOStatus.NEW);
		actDo.setId_cardacttp(IPiDictCodeConst.ID_CARDACTTP_CANCELLOSE);
		actDo.setSd_cardacttp(IPiDictCodeConst.SD_CARDACTTP_CANCELLOSE);
		actDo.setId_emp_act(Context.get().getStuffId());
		actDo.setDt_act(new FDateTime());
		actDo.setId_cardiss(null);
		actDo.setId_patcard(dto.getId_patcard());
		actDo.setId_pat(dto.getId_pat());
		actDo.setId_card(dto.getId_card());
		actDo.setDes_act("取消挂失");
		IActCudService actservice = ServiceFinder.find(IActCudService.class);
		actservice.insert(new PiCardActDO[] { actDo });
	}

	/**
	 * 更新卡库卡状态
	 * 
	 * @param dto
	 * @throws BizException
	 */
	private void updateCard(CardrtnrptDTO dto) throws BizException {

		ICardRService cardFservice = ServiceFinder.find(ICardRService.class);
		ICardCudService cardservice = ServiceFinder.find(ICardCudService.class);

		if (StringUtil.isEmpty(dto.getId_card()))
			return;

		PiCardDO cardDo = cardFservice.findById(dto.getId_card());
		if (cardDo == null)
			return;

		cardDo.setStatus(DOStatus.UPDATED);
		cardDo.setEu_cardsu(CardSuEnum.USING);
		cardDo.setFg_canc(FBoolean.FALSE);
		cardDo.setId_emp_canc(null);
		cardDo.setDt_canc(null);
		cardDo.setDes_canc("取消挂失");

		cardservice.save(new PiCardDO[] { cardDo });
	}

	/**
	 * 更新患者就诊卡状态
	 * 
	 * @param dto
	 * @throws BizException
	 */
	private PiPatCardDO updatePiPatCard(CardrtnrptDTO dto) throws BizException {

		IPiPatCardDORService piCardRService = ServiceFinder.find(IPiPatCardDORService.class);
		IPiPatCardDOCudService piCardCudService = ServiceFinder.find(IPiPatCardDOCudService.class);

		PiPatCardDO piCardDo = piCardRService.findById(dto.getId_patcard());
		piCardDo.setFg_act(FBoolean.TRUE);
		piCardDo.setFg_picardloss(FBoolean.FALSE);
		if (!hasFgDef(dto)) {
			piCardDo.setFg_def(FBoolean.TRUE);
		} else {
			piCardDo.setFg_def(FBoolean.FALSE);
		}
		piCardDo.setStatus(DOStatus.UPDATED);

		return piCardCudService.update(new PiPatCardDO[] { piCardDo })[0];
	}
	
	/**
	 * 是否默认
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	private boolean hasFgDef(CardrtnrptDTO dto) throws BizException {
		boolean hasFgDef = false;

		IPiPatCardDORService piCardRService = ServiceFinder.find(IPiPatCardDORService.class);

		PiPatCardDO[] piCardDos = piCardRService.findByAttrValString(PiPatCardDO.ID_PAT, dto.getId_pat());
		for (PiPatCardDO piCardDo : piCardDos) {
			if (piCardDo.getId_patcard().equals(dto.getId_patcard()))
				continue;
			if (!FBoolean.TRUE.equals(piCardDo.getFg_act()))
				continue;
			if (FBoolean.TRUE.equals(piCardDo.getFg_def()))
				return true;
		}
		return hasFgDef;
	}
}
