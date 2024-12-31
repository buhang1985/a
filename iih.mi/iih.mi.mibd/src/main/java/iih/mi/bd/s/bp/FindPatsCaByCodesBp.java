package iih.mi.bd.s.bp;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import iih.mi.bd.d.PatCaBaseInfoDTO;
import iih.mi.bd.s.bp.sql.FindPatsCaByCodesSql;
import iih.bd.base.utils.SqlUtils;
import iih.mi.mibd.patca.d.PatcaDo;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * @author dj.zhang
 *
 */
public class FindPatsCaByCodesBp {

	/**
	 * 执行查询逻辑
	 * @param misId
	 * @param patCaCodes
	 * @return PatCaBaseInfoDTO[]
	 * @throws BizException
	 */
	public PatCaBaseInfoDTO[] exec(String misId, String[] patCaCodes) throws BizException {
		String wherePart = getWherePart(patCaCodes);
		FindPatsCaByCodesSql sql = new FindPatsCaByCodesSql(misId, wherePart);
		DAFacade daFacade = new DAFacade();
		@SuppressWarnings("unchecked")
		ArrayList<PatCaBaseInfoDTO> result = (ArrayList<PatCaBaseInfoDTO>) daFacade.execQuery(sql.getQrySQLStr(),
				sql.getQryParameter(null), new BeanListHandler(PatCaBaseInfoDTO.class));
		return result.toArray(new PatCaBaseInfoDTO[0]);
	}

	/**
	 * 生成wherePart条件
	 * @param patCaCodes
	 * @return String
	 * @throws BizException
	 */
	private String getWherePart(String[] patCaCodes) throws BizException {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");
		String wherePart = SqlUtils.getInSqlByBigIds(PatcaDo.CODE, patCaCodes);
		if (StringUtils.isNotEmpty(wherePart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(wherePart);
		}
		return wherePartBuilder.toString();
	}

}
