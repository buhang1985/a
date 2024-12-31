package iih.pi.reg.s.bp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.pi.dic.cardtype.d.PiPatCardTpDO;
import iih.pi.dic.cardtype.i.ICardtypeRService;
import iih.pi.reg.pat.d.PiPatCardDO;
import iih.pi.reg.pat.i.IPiPatCardDORService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 判断是否为最后一张就诊卡
 * 
 * @author dj.zhang
 *
 */
public class FindPatValidCardCountByPatIdBp {

	public FBoolean exec(String patId) throws BizException {
		if (StringUtils.isNotEmpty(patId)) {
			throw new BizException("患者不可为空");
		}
		FBoolean fBoolean = new FBoolean(false);
		PiPatCardDO[] piPatCards = getPiPatCards(patId);
		if (piPatCards != null && piPatCards.length > 0) {
			fBoolean = new FBoolean(true);
		}
		return fBoolean;
	}

	/**
	 * 获取患者卡
	 * 
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	private PiPatCardDO[] getPiPatCards(String patId) throws BizException {
		PiPatCardTpDO[] cardTps = getCardTps();
		IPiPatCardDORService IPiPatCardDORService = ServiceFinder.find(IPiPatCardDORService.class);
		String whereStr = getWhereStr(cardTps, patId);
		PiPatCardDO[] piPatCardDOs = IPiPatCardDORService.find(whereStr, "CODE", new FBoolean(false));
		return piPatCardDOs;
	}

	/**
	 * 获取就诊卡类型
	 * 
	 * @return
	 * @throws BizException
	 */
	private PiPatCardTpDO[] getCardTps() throws BizException {
		ICardtypeRService cardtypeRService = ServiceFinder.find(ICardtypeRService.class);
		PiPatCardTpDO[] cardTps = cardtypeRService.find(IPiDictCodeConst.SD_CARD_TYPE_TREATMENT, "CODE",
				new FBoolean(false));
		return cardTps;
	}

	/**
	 * 查询条件
	 * 
	 * @param cardTps
	 * @param patId
	 * @return
	 */
	private String getWhereStr(PiPatCardTpDO[] cardTps, String patId) {
		StringBuilder wherePart = new StringBuilder("1 = 1");
		List<String> patCardTps = new ArrayList<String>();
		if (cardTps != null) {
			for (PiPatCardTpDO cardTp : cardTps) {
				patCardTps.add(cardTp.getSd_patcardtp());
			}
		}
		String sqlByBigIds = SqlUtils.getInSqlByBigIds("SD_PATCARDTP", patCardTps.toArray(new String[0]));
		if (StringUtils.isNotEmpty(sqlByBigIds)) {
			wherePart.append(" AND ");
			wherePart.append(sqlByBigIds);
		}
		if (StringUtils.isNotEmpty(patId)) {
			wherePart.append(" AND ");
			wherePart.append(patId);
		}
		return wherePart.toString();
	}

}
