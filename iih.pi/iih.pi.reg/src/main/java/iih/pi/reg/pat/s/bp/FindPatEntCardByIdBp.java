package iih.pi.reg.pat.s.bp;

import java.util.ArrayList;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据患者主键查询患者就诊卡卡号集合
 * 
 * @author hao_wu 2018-9-12
 *
 */
public class FindPatEntCardByIdBp {

	@SuppressWarnings("unchecked")
	public String[] exec(String patId) throws BizException {
		String sql = getSql(patId);
		SqlParam sqlParam = getSqlParam(patId);

		DAFacade daFacade = new DAFacade();
		ArrayList<String> entCardCodeList = (ArrayList<String>) daFacade.execQuery(sql, sqlParam,
				new ColumnListHandler());
		String[] entCardCodes = entCardCodeList.toArray(new String[0]);
		return entCardCodes;
	}

	/**
	 * 获取SQL
	 * 
	 * @param patId
	 * @return
	 */
	private String getSql(String patId) {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT CARD.CODE ");
		sqlBuilder.append("FROM PI_CARD CARD ");
		sqlBuilder.append("INNER JOIN PI_PAT_CARD PATCARD ");
		sqlBuilder.append("ON CARD.ID_CARD = PATCARD.ID_CARD ");
		sqlBuilder.append("INNER JOIN PI_PAT_CARDTP PATCARDTP ");
		sqlBuilder.append("ON PATCARDTP.ID_CARDTP = CARD.ID_PATCARDTP ");
		sqlBuilder.append("WHERE PATCARDTP.SD_PATCARDTP = ? ");
		sqlBuilder.append("AND PATCARD.ID_PAT = ? ");
		sqlBuilder.append("ORDER BY PATCARD.ID_PATCARD DESC ");

		return sqlBuilder.toString();
	}

	/**
	 * 获取SQL参数
	 * 
	 * @param patId
	 * @return
	 */
	private SqlParam getSqlParam(String patId) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(IPiDictCodeConst.SD_CARD_TYPE_TREATMENT);
		sqlParam.addParam(patId);
		return sqlParam;
	}

}
