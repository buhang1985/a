package iih.mi.bd.s.bp;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import iih.mi.bd.d.MisBaseInfoDTO;
import iih.mi.bd.s.bp.sql.FindMissByIdsSql;
import iih.bd.base.utils.SqlUtils;
import iih.mi.mibd.mis.d.MisDO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * @author dj.zhang
 *
 */
public class FindMissByIdsBp {

	/**
	 * 执行查询逻辑
	 * @param midIds
	 * @return MisBaseInfoDTO[]
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public MisBaseInfoDTO[] exec(String[] midIds) throws BizException {
		String wherePart = getWherePart(midIds);
		FindMissByIdsSql sql = new FindMissByIdsSql(wherePart);
		DAFacade daFacade = new DAFacade();
		ArrayList<MisBaseInfoDTO> result = (ArrayList<MisBaseInfoDTO>) daFacade.execQuery(sql.getQrySQLStr(),
				sql.getQryParameter(null), new BeanListHandler(MisBaseInfoDTO.class));
		return result.toArray(new MisBaseInfoDTO[0]);
	}

	/**
	 * 生成wherePart条件
	 * @param midIds
	 * @return String
	 * @throws BizException
	 */
	private String getWherePart(String[] midIds) throws BizException {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");
		String wherePart = SqlUtils.getInSqlByIds(MisDO.ID_MIS, midIds);
		if (StringUtils.isNotEmpty(wherePart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(wherePart);
		}
		return wherePartBuilder.toString();
	}

}
