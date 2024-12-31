package iih.mi.bd.s.bp;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import iih.bd.mhi.hpfeeca.d.HpFeecaDO;
import iih.mi.bd.s.bp.sql.FindHpFeecaByCodesSql;
import iih.bd.base.utils.SqlUtils;
import iih.mi.mibd.d.FeecaInfoDTO;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * @author dj.zhang
 *
 */
public class FindHpFeecaByCodesBp {

	/**
	 * @param hpId
	 * @param feecaCodes
	 * @return
	 * @throws DAException
	 */
	public FeecaInfoDTO[] exec(String hpId, String[] feecaCodes) throws DAException {
		String wherePart;
		if (feecaCodes != null && feecaCodes.length > 0) {
			wherePart = getWherePart(feecaCodes);
		} else {
			wherePart = " 1=1 ";
		}
		FindHpFeecaByCodesSql sql = new FindHpFeecaByCodesSql(hpId, wherePart);
		DAFacade daFacade = new DAFacade();
		@SuppressWarnings("unchecked")
		ArrayList<FeecaInfoDTO> result = (ArrayList<FeecaInfoDTO>) daFacade.execQuery(sql.getQrySQLStr(),
				sql.getQryParameter(null), new BeanListHandler(FeecaInfoDTO.class));
		return result.toArray(new FeecaInfoDTO[0]);
	}

	/**
	 * @param feecaCodes
	 * @return
	 */
	private String getWherePart(String[] feecaCodes) throws DAException {
		StringBuilder wherepartBuilder = new StringBuilder("1=1");
		String wherePart = SqlUtils.getInSqlByIds(HpFeecaDO.CODE, feecaCodes);
		if (StringUtils.isNotEmpty(wherePart)) {
			wherepartBuilder.append(" AND ");
			wherepartBuilder.append(wherePart);
		}
		return wherepartBuilder.toString();
	}

}
