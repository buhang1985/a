package iih.pi.reg.pat.s.rule;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.pi.card.card.d.CardSuEnum;
import iih.pi.card.card.d.PiCardDO;
import iih.pi.card.card.i.ICardCudService;
import iih.pi.card.card.i.ICardRService;
import iih.pi.card.i.IPiCardMaintainService;
import iih.pi.params.PiParams;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.d.PiPatCardDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.bizrule.IRule;
import xap.sys.appfw.orm.dataaccess.DBUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 患者新注册就诊卡前发卡规则
 * 
 * @author hao_wu 2018-6-6
 *
 */
public class DispCardWhenInsertPatCardRule implements IRule<PatiAggDO> {

	@Override
	public void process(PatiAggDO... patAggs) throws BizException {
		if (patAggs == null || patAggs.length <= 0) {
			return;
		}

		FBoolean fgCardMgr = new PiParams().PIPAT0027();// 是否开启卡库管理
		if (FBoolean.FALSE.equals(fgCardMgr)) {
			this.insertPiCardDo(patAggs);
		} else {
			for (PatiAggDO patAggDo : patAggs) {
				dispCard(patAggDo);
			}
		}
	}

	/**
	 * 发卡
	 * 
	 * @param patAggDo
	 * @throws BizException
	 */
	private void dispCard(PatiAggDO patAggDo) throws BizException {
		PatDO patDo = patAggDo.getParentDO();
		PiPatCardDO[] patCards = patAggDo.getPiPatCardDO();
		if (!ArrayUtil.isEmpty(patCards)){
			//校验就诊卡
			checkPiPatCardDOs(patCards);
		}
		PiPatCardDO[] patEntCards = this.getPatEntCard(patCards);

		if (ArrayUtil.isEmpty(patEntCards))
			return;

		String[] cardIds = getCardIds(patEntCards);

		dispCard(cardIds, patDo);
	}
	
	/**
	 * 校验卡片是否被他人使用，无论该卡是否已禁用
	 * @author : hanjq 2019年10月30日 上午11:34:01
	 * @param patEntCards
	 * @throws BizException 
	 */
	private void checkPiPatCardDOs(PiPatCardDO[] patEntCards) throws BizException{
		DAFacade daf = new DAFacade();
		StringBuilder bd = new StringBuilder();
		bd.append("select patcard.code, cardtp.name Patcardtp_name	")
		.append(" from pi_pat_card patcard	")
		.append(" join pi_pat_cardtp cardtp	on cardtp.id_cardtp = patcard.id_patcardtp	")
		.append(" where patcard.code = ? and patcard.id_patcardtp = ?  and patcard.id_pat != ?");
		for(PiPatCardDO card:patEntCards){
			if(card.getStatus() == DOStatus.UNCHANGED){
				continue;
			}
			SqlParam param = new SqlParam();
			param.addParam(card.getCode());
			param.addParam(card.getId_patcardtp());
			param.addParam(card.getId_pat());
			
			List<PiPatCardDO> list = (List<PiPatCardDO>) daf.execQuery(bd.toString(), param, new BeanListHandler(PiPatCardDO.class));
			if(list != null && list.size()> 0){
				throw new BizException("卡号为"+list.get(0).getCode() + "的" + list.get(0).getPatcardtp_name()+"已被使用");
			}
		}
		
	}

	/**
	 * 获取患者就诊卡集合
	 * 
	 * @param patCards
	 * @return
	 */
	private PiPatCardDO[] getPatEntCard(PiPatCardDO[] patCards) {

		if (ArrayUtil.isEmpty(patCards))
			return null;

		ArrayList<PiPatCardDO> patEntCardList = new ArrayList<PiPatCardDO>();
		for (PiPatCardDO piPatCardDO : patCards) {
			if (IPiDictCodeConst.SD_CARD_TYPE_TREATMENT.equals(piPatCardDO.getSd_patcardtp_udi())
					&& DOStatus.NEW == piPatCardDO.getStatus()) {
				patEntCardList.add(piPatCardDO);
			}
		}
		return patEntCardList.toArray(new PiPatCardDO[0]);
	}

	/**
	 * 获取就诊卡主键集合
	 * 
	 * @param patCards
	 * @return
	 * @throws BizException
	 */
	private String[] getCardIds(PiPatCardDO[] patEntCards) throws BizException {

		ArrayList<String> cardIdList = new ArrayList<String>();
		for (PiPatCardDO piPatCardDO : patEntCards) {
			if (StringUtils.isEmpty(piPatCardDO.getId_card())) {
				setCardId(piPatCardDO);
			}
			cardIdList.add(piPatCardDO.getId_card());
		}
		return cardIdList.toArray(new String[0]);
	}

	/**
	 * 设置卡主键
	 * 
	 * @param piPatCardDO
	 * @throws BizException
	 */
	private void setCardId(PiPatCardDO piPatCardDO) throws BizException {
		ICardRService cardRService = ServiceFinder.find(ICardRService.class);

		String wherePart = String.format("id_patcardtp = '%s' and code = '%s'", piPatCardDO.getId_patcardtp(),
				piPatCardDO.getCode());
		PiCardDO[] cardDos = cardRService.find(wherePart, "", FBoolean.FALSE);
		if (cardDos == null || cardDos.length <= 0) {
			String msg = String.format("%s\"%s\"未入库，请先入库。", piPatCardDO.getPatcardtp_name(), piPatCardDO.getCode());
			throw new BizException(msg);
		}

		piPatCardDO.setId_card(cardDos[0].getId_card());
	}

	/**
	 * 发卡
	 * 
	 * @param cardCodes
	 * @throws BizException
	 */
	private void dispCard(String[] cardCodes, PatDO patDo) throws BizException {
		IPiCardMaintainService piCardMaintainService = ServiceFinder.find(IPiCardMaintainService.class);
		piCardMaintainService.dispCardByIds(cardCodes, patDo);
	}

	/**
	 * PIPAT0027为false时，pi_card插入数据
	 * 
	 * @param patAggs
	 * @throws BizException
	 */
	private void insertPiCardDo(PatiAggDO[] patAggs) throws BizException {
		for (PatiAggDO patiAggDO : patAggs) {
			PiPatCardDO[] PiPatCardDo = patiAggDO.getPiPatCardDO();
			PiPatCardDO[] patEntCards = this.getPatEntCard(PiPatCardDo);

			if (ArrayUtil.isEmpty(patEntCards))
				return;
			checkPiPatCardDOs(patEntCards);
			
			//不走卡库管理的情况下，卡号不能与卡库管理里的已有卡号一致
			for (PiPatCardDO card : patEntCards) {
				
				if(card.getStatus() == DOStatus.UNCHANGED){
					continue;
				}
				
				ICardRService cardservice = ServiceFinder.find(ICardRService.class);
				PiCardDO[] piCardDos = cardservice.findByAttrValString(PiCardDO.CODE, card.getCode());
				
				if(!ArrayUtil.isEmpty(piCardDos)){
					throw new BizException(""+piCardDos[0].getCode() + "，该卡号与卡库管理里的卡号重复");
				}
			}
			
			String[] oiDs = new DBUtil().getOIDs(patEntCards.length);
			List<PiCardDO> list = new ArrayList<PiCardDO>();

			for (int i = 0; i < patEntCards.length; i++) {
				PiCardDO cardDos = new PiCardDO();
				if (StringUtils.isEmpty(cardDos.getId_card())) {
					cardDos.setId_org(Context.get().getOrgId());
					cardDos.setId_grp(Context.get().getGroupId());
					// 生成主键 并赋值
					cardDos.setId_card(oiDs[i]);
					cardDos.setCode(patEntCards[i].getCode());// 卡编号
					cardDos.setId_emp_canc(Context.get().getStuffId());
					cardDos.setDt_canc(new FDateTime());
					cardDos.setEu_cardsu(CardSuEnum.USING);
					cardDos.setStatus(DOStatus.NEW);
					list.add(cardDos);
					patEntCards[i].setId_card(cardDos.getId_card());
				}
			}
			// 新增患者就诊卡
			ICardCudService cardservice = ServiceFinder.find(ICardCudService.class);
			cardservice.insert(list.toArray(new PiCardDO[] {}));
		}
	}
}
