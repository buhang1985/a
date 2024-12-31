package iih.mi.bd.s.bp;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import iih.mi.bd.d.PresTpBaseInfoDTO;
import iih.mi.bd.s.bp.sql.FindPresTpsByHisPresTpIdsSql;
import iih.bd.base.utils.SqlUtils;
import iih.mi.mibd.prestp.d.PrestpDO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class FindPresTpsByHisPresTpIdsBp {

	/**
	 * 根据HIS处方类型主键集合查询处方类型基础信息集合业务逻辑
	 * 
	 * @param midId
	 * @param hisPresTpIds
	 * @return
	 * @throws BizException
	 * @author hexx
	 */
	@SuppressWarnings("unchecked")
	public PresTpBaseInfoDTO[] exec(String midId, String[] hisPresTpIds) throws BizException {
		String wherePart = getWherePart(hisPresTpIds);
		FindPresTpsByHisPresTpIdsSql sql = new FindPresTpsByHisPresTpIdsSql(midId, wherePart);
		DAFacade daFacade = new DAFacade();
		ArrayList<PresTpBaseInfoDTO> result = (ArrayList<PresTpBaseInfoDTO>) daFacade.execQuery(sql.getQrySQLStr(),
				sql.getQryParameter(null), new BeanListHandler(PresTpBaseInfoDTO.class));
		return result.toArray(new PresTpBaseInfoDTO[0]);

	}

	private String getWherePart(String[] hisPresTpIds) {
		StringBuilder builder = new StringBuilder("1=1");
		String wherePart = SqlUtils.getInSqlByIds(PrestpDO.CODE, hisPresTpIds);
		if (StringUtils.isNotEmpty(wherePart)) {
			builder.append("and");
			builder.append(wherePart);
		}
		return builder.toString();
	}

}
