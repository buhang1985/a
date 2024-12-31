package iih.mi.bd.s.bp;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import iih.mi.bd.d.FreqBaseInfoDTO;
import iih.mi.bd.s.bp.sql.FindFreqsByCodesSql;
import iih.bd.base.utils.SqlUtils;
import iih.mi.mibd.freq.d.FreqDO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class FindFreqsByCodesBp {

	/**
	 * 根据频次编码集合查询频次基础信息集合业务逻辑
	 * 
	 * @param misId
	 * @param freqCodes
	 * @return
	 * @throws BizException
	 * @author hexx
	 */
	@SuppressWarnings("unchecked")
	public FreqBaseInfoDTO[] exec(String misId, String[] freqCodes) throws BizException {
		String wherePart = getWherePart(freqCodes);
		FindFreqsByCodesSql sql = new FindFreqsByCodesSql(misId, wherePart);
		DAFacade daFacade = new DAFacade();
		ArrayList<FreqBaseInfoDTO> result = (ArrayList<FreqBaseInfoDTO>) daFacade.execQuery(sql.getQrySQLStr(),
				sql.getQryParameter(null), new BeanListHandler(FreqBaseInfoDTO.class));
		return result.toArray(new FreqBaseInfoDTO[0]);

	}

	private String getWherePart(String[] freqCodes) {
		StringBuilder builder = new StringBuilder("1=1");
		String wherePart = SqlUtils.getInSqlByIds(FreqDO.CODE, freqCodes);
		if (StringUtils.isNotEmpty(wherePart)) {
			builder.append("and");
			builder.append(wherePart);
		}
		return builder.toString();
	}

}
