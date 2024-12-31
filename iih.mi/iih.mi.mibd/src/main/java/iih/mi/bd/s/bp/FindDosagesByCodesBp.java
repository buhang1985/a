package iih.mi.bd.s.bp;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import iih.mi.bd.d.DosageBaseInfoDTO;
import iih.mi.bd.s.bp.sql.FindDosagesByCodesSql;
import iih.bd.base.utils.SqlUtils;
import iih.mi.mibd.dosage.d.DosageDO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class FindDosagesByCodesBp {

	/**
	 * 根据剂型编码集合查询剂型基础信息集合业务逻辑
	 * 
	 * @param misId
	 * @param dosageCodes
	 * @return
	 * @throws BizException
	 * @author hexx
	 */
	@SuppressWarnings("unchecked")
	public DosageBaseInfoDTO[] exec(String misId, String[] dosageCodes) throws BizException {
		String wherePart = getWherePart(dosageCodes);
		FindDosagesByCodesSql sql = new FindDosagesByCodesSql(misId, wherePart);
		DAFacade daFacade = new DAFacade();
		ArrayList<DosageBaseInfoDTO> result = (ArrayList<DosageBaseInfoDTO>) daFacade.execQuery(sql.getQrySQLStr(),
				sql.getQryParameter(null), new BeanListHandler(DosageBaseInfoDTO.class));
		return result.toArray(new DosageBaseInfoDTO[0]);
	}

	private String getWherePart(String[] dosageCodes) {
		StringBuilder builder = new StringBuilder("1=1");
		String wherePart = SqlUtils.getInSqlByIds(DosageDO.CODE, dosageCodes);
		if (StringUtils.isNotEmpty(wherePart)) {
			builder.append("and");
			builder.append(wherePart);
		}
		return builder.toString();
	}
}
