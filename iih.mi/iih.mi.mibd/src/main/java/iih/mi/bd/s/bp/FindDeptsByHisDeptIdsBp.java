package iih.mi.bd.s.bp;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import iih.mi.bd.d.DeptBaseInfoDTO;
import iih.mi.bd.s.bp.sql.FindDeptsByHisDeptIdsSql;
import iih.bd.base.utils.SqlUtils;
import iih.mi.mibd.dep.d.DepDo;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * @author dj.zhang
 *
 */
public class FindDeptsByHisDeptIdsBp {

	/**
	 * 执行查询逻辑
	 * @param misId
	 * @param hisDeptIds
	 * @return DeptBaseInfoDTO[]
	 * @throws DAException
	 */
	public DeptBaseInfoDTO[] exec(String misId, String[] hisDeptIds) throws DAException {
		String wherePart = getWherePart(hisDeptIds);
		FindDeptsByHisDeptIdsSql sql = new FindDeptsByHisDeptIdsSql(misId, wherePart);
		DAFacade daFacade = new DAFacade();
		@SuppressWarnings("unchecked")
		ArrayList<DeptBaseInfoDTO> result = (ArrayList<DeptBaseInfoDTO>) daFacade.execQuery(sql.getQrySQLStr(),
				sql.getQryParameter(null), new BeanListHandler(DeptBaseInfoDTO.class));
		return result.toArray(new DeptBaseInfoDTO[0]);
	}

	/**
	 * 生成wherePart条件
	 * @param hisDeptIds
	 * @return String
	 * @throws DAException
	 */
	private String getWherePart(String[] hisDeptIds) throws DAException {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");
		String wherePart = SqlUtils.getInSqlByIds(DepDo.ID_DEP, hisDeptIds);
		if (StringUtils.isNotEmpty(wherePart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(wherePart);
		}
		return wherePartBuilder.toString();
	}

}
