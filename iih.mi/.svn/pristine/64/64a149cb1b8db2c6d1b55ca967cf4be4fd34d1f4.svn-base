package iih.mi.bd.s.bp;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import iih.mi.bd.d.InsurKindBaseInfoDTO;
import iih.mi.bd.s.bp.sql.FindInsurKindsByCodesSql;
import iih.bd.base.utils.SqlUtils;
import iih.mi.mibd.insurkind.d.InsurkindDO;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * @author dj.zhang
 *
 */
public class FindInsurKindsByCodesBp {

	/**
	 * 执行查询逻辑
	 * @param midId
	 * @param insurKindCodes
	 * @return InsurKindBaseInfoDTO[]
	 * @throws DAException
	 */
	@SuppressWarnings("unchecked")
	public InsurKindBaseInfoDTO[] exec(String midId, String[] insurKindCodes) throws DAException {
		String wherePart = getWherePart(insurKindCodes);
		FindInsurKindsByCodesSql sql = new FindInsurKindsByCodesSql(midId, wherePart);
		DAFacade daFacade = new DAFacade();
		ArrayList<InsurKindBaseInfoDTO> result = (ArrayList<InsurKindBaseInfoDTO>) daFacade.execQuery(
				sql.getQrySQLStr(), sql.getQryParameter(null), new BeanListHandler(InsurKindBaseInfoDTO.class));
		return result.toArray(new InsurKindBaseInfoDTO[0]);
	}

	/**
	 * 生成wherePart条件
	 * @param insurKindCodes
	 * @return String
	 * @throws DAException
	 */
	private String getWherePart(String[] insurKindCodes) throws DAException {
		StringBuilder wherepartBuilder = new StringBuilder("1=1");
		String wherePart = SqlUtils.getInSqlByIds(InsurkindDO.CODE, insurKindCodes);
		if(StringUtils.isNotEmpty(wherePart)){
			wherepartBuilder.append(" AND ");
			wherepartBuilder.append(wherePart);
		}
		return wherepartBuilder.toString();
	}

}
