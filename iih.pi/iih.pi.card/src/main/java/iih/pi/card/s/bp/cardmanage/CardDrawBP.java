package iih.pi.card.s.bp.cardmanage;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.bd.utils.BdEnvContextUtil;
import iih.pi.card.act.d.PiCardActDO;
import iih.pi.card.act.s.ActCrudServiceImpl;
import iih.pi.card.card.d.PiCardDO;
import iih.pi.card.dto.d.CardManageDTO;
import iih.pi.card.iss.d.DirectEnum;
import iih.pi.card.iss.d.PiCardIssDO;
import iih.pi.card.iss.i.IIssCudService;
import iih.pi.card.s.bp.cardmanage.sql.DrawCardSql;
import iih.pi.card.s.bp.cardmanage.sql.FindGetedCardCodesSql;
import iih.pi.card.s.bp.cardmanage.sql.FindNotEntryCardCodesSql;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class CardDrawBP {

	/**
	 * 卡领用处理
	 * 
	 * @param dto
	 * @throws BizException
	 */
	public void exec(CardManageDTO dto) throws BizException {

		if (dto == null)
			return;

		this.validate(dto);

		this.insertIss(dto);

		// 批量领用时不生成操作记录，量太大，影响性能 吴浩 2018-9-15
//		this.inserAct(dto, issDo.getId_cardiss());

		this.drawCard(dto);
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
	}

	/**
	 * 插入就诊发放记录
	 * 
	 * @param dto
	 * @throws BizException
	 */
	private PiCardIssDO insertIss(CardManageDTO dto) throws BizException {

		PiCardIssDO issDo = new PiCardIssDO();
		issDo.setEu_direct(DirectEnum.DISTRIBUTE);
		issDo.setQuan(dto.getAmount());
		issDo.setId_emp_get(dto.getId_emp_get());
		issDo.setDt_iss(new FDateTime());
		issDo.setId_emp_iss(Context.get().getStuffId());
		issDo.setStatus(DOStatus.NEW);

		IIssCudService issCudService = ServiceFinder.find(IIssCudService.class);
		PiCardIssDO[] result = issCudService.insert(new PiCardIssDO[] { issDo });
		return result[0];
	}

	/**
	 * 插入就诊卡操作记录
	 * 
	 * @param dto
	 * @param cardDos
	 * @param cardIssId
	 * @throws BizException
	 */
	@SuppressWarnings("unused")
	private void inserAct(PiCardDO[] cardDos, CardManageDTO dto, String cardIssId) throws BizException {
		ActCrudServiceImpl actService = new ActCrudServiceImpl();
		List<PiCardActDO> actList = new ArrayList<PiCardActDO>();

		FDateTime now = new FDateTime();

		for (PiCardDO card : cardDos) {
			PiCardActDO actDo = new PiCardActDO();
			actDo.setId_card(card.getId_card());
			actDo.setId_cardacttp(IPiDictCodeConst.ID_CARDACTTP_DRAW);// 领用
			actDo.setSd_cardacttp(IPiDictCodeConst.SD_CARDACTTP_DRAW);
			actDo.setId_emp_act(Context.get().getStuffId());
			actDo.setDt_act(now);
			actDo.setId_cardiss(cardIssId);
			actDo.setDes_act("领用");
			actDo.setStatus(DOStatus.NEW);

			actList.add(actDo);
		}

		actService.insert(actList.toArray(new PiCardActDO[actList.size()]));
	}

	/**
	 * 更新患者就诊卡数据
	 * 
	 * @param cardDos
	 * @throws BizException
	 */
	private void drawCard(CardManageDTO dto) throws BizException {
		
		//将校验前移，起始号和结束号之间的差值，有可能和数据库中更新的数量有可能不相等  比如卡号从1890021-1891000之间 数据库查出991条数据，还有18901等数据干扰
		throwCardNotEntryErrMsg(dto);

		throwDrawCountErrMsg2(dto);
		DrawCardSql sql = new DrawCardSql(dto.getCode_begin(), dto.getCode_end(), dto.getId_emp_get(),dto.getId_patcardtp());

		DAFacade daFacade = new DAFacade();
		int drawCount = daFacade.execUpdate(sql.getQrySQLStr(), sql.getQryParameter(null));

//		throwCardNotEntryErrMsg(dto);
//
//		throwDrawCountErrMsg(dto, drawCount);
	}

	/**
	 * 抛出卡未录入错误消息</br>
	 * 要领用的卡还未录入
	 * 
	 * @param dto
	 * @throws BizException
	 */
	private void throwCardNotEntryErrMsg(CardManageDTO dto) throws BizException {

		String sql = String.format("select count(*) from pi_card where %s and length(code)=length(?) and length(code)=length(?) and code >= ? and code <= ? and ID_PATCARDTP=? ",
				BdEnvContextUtil.processEnvContext(new PiCardDO(), false));

		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(dto.getCode_begin());
		sqlParam.addParam(dto.getCode_end());
		sqlParam.addParam(dto.getCode_begin());
		sqlParam.addParam(dto.getCode_end());
		sqlParam.addParam(dto.getId_patcardtp());

		DAFacade daFacade = new DAFacade();
		Integer cardCount = (Integer) daFacade.execQuery(sql, sqlParam, new ColumnHandler());
		if (!dto.getAmount().equals(cardCount)) {
			throw new BizException("领用范围内有卡号未录入。");
		}
//		String[] cardCodes = FindNotEntryCardCodes(dto);
//		if (ArrayUtils.isEmpty(cardCodes)) {
//			return;
//		}
//
//		String cardCodeMsg = StringUtils.join(cardCodes, ",");
//		String msg = String.format("存在%s张卡未被录入，未录入卡号列表（超过20张只显示前20张）：%s", cardCodes.length, cardCodeMsg);
//		throw new BizException(msg);
	}

	@SuppressWarnings("unchecked")
	private String[] FindNotEntryCardCodes(CardManageDTO dto) throws BizException {
		FindNotEntryCardCodesSql sql = new FindNotEntryCardCodesSql(dto.getCode_begin(), dto.getCode_end());
		DAFacade daFacade = new DAFacade();
		ArrayList<String> codes = (ArrayList<String>) daFacade.execQuery(sql.getQrySQLStr(), sql.getQryParameter(null),
				new ColumnListHandler());
		return codes.toArray(new String[0]);
	}

	/**
	 * 抛出领出数量错误消息</br>
	 * 要领用的卡已被领用
	 * 
	 * @param dto
	 * @param drawCount 实际领出数量
	 * @throws BizException
	 */
	private void throwDrawCountErrMsg(CardManageDTO dto, int drawCount) throws BizException {
		if (dto.getAmount().equals(drawCount)) {
			return;
		}

		String[] cardCodes = findGetedCardCodes(dto);
		String cardCodeMsg = StringUtils.join(cardCodes, ",");
		String msg = String.format("存在%s张卡已被领用，已领用卡列表（超过20张只显示前20张）：%s", dto.getAmount() - drawCount, cardCodeMsg);
		throw new BizException(msg);
	}

	/**
	 * 抛出领出数量错误消息</br>
	 * 要领用的卡已被领用
	 * 
	 * @param dto
	 * @param drawCount 实际领出数量
	 * @throws BizException
	 */
	private void throwDrawCountErrMsg2(CardManageDTO dto) throws BizException {
		String[] cardCodes = findGetedCardCodes(dto);
		if(ArrayUtil.isEmpty(cardCodes)){
			return ;
		}
		String cardCodeMsg = StringUtils.join(cardCodes, ",");
		String msg = String.format("存在%s张卡已被领用，已领用卡列表（超过20张只显示前20张）：%s", cardCodes.length, cardCodeMsg);
		throw new BizException(msg);
	}
	/**
	 * 获取已领取卡片编码列表
	 * 
	 * @param dto
	 * @return
	 * @throws DAException
	 */
	@SuppressWarnings("unchecked")
	private String[] findGetedCardCodes(CardManageDTO dto) throws DAException {
		FindGetedCardCodesSql sql = new FindGetedCardCodesSql(dto.getCode_begin(), dto.getCode_end());

		DAFacade daFacade = new DAFacade();
		ArrayList<String> cardCodeList = (ArrayList<String>) daFacade.execQuery(sql.getQrySQLStr(),
				sql.getQryParameter(null), new ColumnListHandler());
		return cardCodeList.toArray(new String[0]);
	}
}
