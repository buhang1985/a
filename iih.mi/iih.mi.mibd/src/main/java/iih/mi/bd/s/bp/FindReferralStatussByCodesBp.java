package iih.mi.bd.s.bp;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import iih.mi.bd.d.ReferralStatusBaseInfoDTO;
import iih.mi.bd.s.bp.sql.FindReferralStatussByCodesSql;
import iih.bd.base.utils.SqlUtils;
import iih.mi.mibd.referralstatus.d.ReferralStatusDO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * @author hexx
 *
 */
public class FindReferralStatussByCodesBp {

	
	/**
	 * 根据转诊状态编码集合查询转诊状态基础信息集合业务逻辑
	 * 
	 * @param misId
	 * @param referralStatusCodes
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public ReferralStatusBaseInfoDTO[] exec(String misId, String[] referralStatusCodes) throws BizException{
		String wherePart = getWherePart(referralStatusCodes);
		FindReferralStatussByCodesSql sql = new FindReferralStatussByCodesSql(misId,wherePart);
		DAFacade dafacade = new DAFacade();
		ArrayList<ReferralStatusBaseInfoDTO> result = (ArrayList<ReferralStatusBaseInfoDTO>) dafacade.execQuery(sql.getQrySQLStr(), 
				sql.getQryParameter(null), new BeanListHandler(ReferralStatusBaseInfoDTO.class));
		return result.toArray(new ReferralStatusBaseInfoDTO[0]);
	}

	private String getWherePart(String[] referralStatusCodes) {
		StringBuilder builder = new StringBuilder("1=1");
		String wherePart = SqlUtils.getInSqlByIds(ReferralStatusDO.CODE, referralStatusCodes);
		if (StringUtils.isNotEmpty(wherePart)) {
			builder.append("and");
			builder.append(wherePart);
		}
		return builder.toString();
	}
}
