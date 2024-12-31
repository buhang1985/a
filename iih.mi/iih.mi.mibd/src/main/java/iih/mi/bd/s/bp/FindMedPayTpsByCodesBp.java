package iih.mi.bd.s.bp;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import iih.mi.bd.d.MedPayTpBaseInfoDTO;
import iih.mi.bd.s.bp.sql.FindMedPayTpsByCodesSql;
import iih.bd.base.utils.SqlUtils;
import iih.mi.mibd.medpaytp.d.MedPayTpDO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * @author hexx
 *
 */
public class FindMedPayTpsByCodesBp {
	
	/**
	 * 根据医疗付款方式编码集合查询医疗付款方式基础信息集合业务逻辑
	 * 
	 * @param misId
	 * @param medPayTpCodes
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public MedPayTpBaseInfoDTO[] exec(String misId, String[] medPayTpCodes) throws BizException {
		String wherePart = getWherePart(medPayTpCodes);
		FindMedPayTpsByCodesSql sql = new FindMedPayTpsByCodesSql(misId,wherePart);
		DAFacade daFacade = new DAFacade();
		ArrayList<MedPayTpBaseInfoDTO> result = (ArrayList<MedPayTpBaseInfoDTO>) daFacade.execQuery(sql.getQrySQLStr(),
				sql.getQryParameter(null), new BeanListHandler(MedPayTpBaseInfoDTO.class));
		return result.toArray(new MedPayTpBaseInfoDTO[0]);
	}

	private String getWherePart(String[] medPayTpCodes) {
		StringBuilder builder = new StringBuilder("1=1");
		String wherePart = SqlUtils.getInSqlByIds(MedPayTpDO.CODE, medPayTpCodes);
		if (StringUtils.isNotEmpty(wherePart)) {
			builder.append("and");
			builder.append(wherePart);
		}
		return builder.toString();
	}
}
