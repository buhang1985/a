package iih.mi.bd.s.bp;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import iih.bd.mhi.admstatus.d.AdmStatusDO;
import iih.bd.mhi.hpadmstatusdircomp.d.HpAdmstatusDirCompDO;
import iih.bd.mhi.hpadmstatusdircomp.d.desc.HpAdmstatusDirCompDODesc;
import iih.mi.bd.s.bp.sql.FindAdmStatussByCodesSql;
import iih.bd.base.utils.SqlUtils;
import iih.mi.mibd.d.AdmStatusBaseInfoDTO;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * @author dj.zhang
 *
 */
public class FindAdmStatussByCodesBp {

	/**
	 * 执行查询逻辑
	 * 
	 * @param hpId
	 * @param admStatusCodes
	 * @return AdmStatusBaseInfoDTO[]
	 * @throws DAException
	 */
	public AdmStatusBaseInfoDTO[] exec(String hpId, String[] admStatusCodes) throws DAException {
		String wherePart;
		if (admStatusCodes != null && admStatusCodes.length > 0) {
			wherePart = getWherePart(admStatusCodes);
		} else {
			wherePart = " 1=1 ";
		}
		FindAdmStatussByCodesSql sql = new FindAdmStatussByCodesSql(hpId, wherePart);
		DAFacade daFacade = new DAFacade();
		@SuppressWarnings("unchecked")
		ArrayList<AdmStatusBaseInfoDTO> result = (ArrayList<AdmStatusBaseInfoDTO>) daFacade.execQuery(
				sql.getQrySQLStr(), sql.getQryParameter(null), new BeanListHandler(AdmStatusBaseInfoDTO.class));
		return result.toArray(new AdmStatusBaseInfoDTO[0]);
	}

	/**
	 * 生成wherePart条件
	 * 
	 * @param admStatusCodes
	 * @return String
	 * @throws DAException
	 */
	private String getWherePart(String[] admStatusCodes) throws DAException {
		StringBuilder wherepartBuilder = new StringBuilder("1=1");
		String wherePart = SqlUtils.getInSqlByIds(HpAdmstatusDirCompDO.CODE_LEVELDISE, admStatusCodes);
		if (StringUtils.isNotEmpty(wherePart)) {
			wherepartBuilder.append(" AND ");
			wherepartBuilder.append(wherePart);
		}
		return wherepartBuilder.toString();
	}

}
