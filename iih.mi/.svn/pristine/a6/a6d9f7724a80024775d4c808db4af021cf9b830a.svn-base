package iih.mi.bd.s.bp;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import iih.mi.bd.d.PresTpBaseInfoDTO;
import iih.mi.bd.s.bp.sql.FindPresTpsByCodesSql;
import iih.bd.base.utils.SqlUtils;
import iih.mi.mibd.prestp.d.PrestpDO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class FindPresTpsByCodesBp {

	/**
	 * 根据处方类型编码集合查询处方类型基础信息集合业务逻辑
	 * 
	 * @param misId
	 * @param presTpCodes
	 * @return
	 * @throws BizException
	 * @author hexx
	 */
	@SuppressWarnings("unchecked")
	public PresTpBaseInfoDTO[] exec(String misId, String[] presTpCodes) throws BizException {
		String wherePart = getWherePart(presTpCodes);
		FindPresTpsByCodesSql sql = new FindPresTpsByCodesSql(misId, wherePart);
		DAFacade daFacade = new DAFacade();
		ArrayList<PresTpBaseInfoDTO> result = (ArrayList<PresTpBaseInfoDTO>) daFacade.execQuery(sql.getQrySQLStr(),
				sql.getQryParameter(null), new BeanListHandler(PresTpBaseInfoDTO.class));
		return result.toArray(new PresTpBaseInfoDTO[0]);
	}

	private String getWherePart(String[] presTpCodes) {
		StringBuilder builder = new StringBuilder("1=1");
		String wherePart = SqlUtils.getInSqlByIds(PrestpDO.CODE, presTpCodes);
		if (StringUtils.isNotEmpty(wherePart)) {
			builder.append("and");
			builder.append(wherePart);
		}
		return builder.toString();
	}
}
