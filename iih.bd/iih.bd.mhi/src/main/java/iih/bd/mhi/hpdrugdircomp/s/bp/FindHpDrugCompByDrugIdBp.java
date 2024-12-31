package iih.bd.mhi.hpdrugdircomp.s.bp;

import java.util.ArrayList;

import iih.bd.base.utils.SqlUtils;
import iih.bd.mhi.hpdrugdircomp.d.HpDrugDirCompDTO;
import iih.bd.mhi.hpdrugdircomp.s.bp.sql.FindHpDrugDirCompSql;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 通过药品ID查询药品对照
 * 
 * @author hexx
 */
public class FindHpDrugCompByDrugIdBp {

	/**
	 * @Title: exec
	 * @Description: 执行
	 * @param hpId
	 * @param hpdrugIds
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public HpDrugDirCompDTO[] exec(String hpId, String[] hpdrugIds) throws BizException {
		String wherePart = SqlUtils.getInSqlByIds("BD_MM.ID_MM", hpdrugIds);
		FindHpDrugDirCompSql sql = new FindHpDrugDirCompSql(hpId, wherePart);
		DAFacade daFacade = new DAFacade();
		ArrayList<HpDrugDirCompDTO> result = (ArrayList<HpDrugDirCompDTO>) daFacade.execQuery(sql.getQrySQLStr(),
				sql.getQryParameter(null), new BeanListHandler(HpDrugDirCompDTO.class));
		return result.toArray(new HpDrugDirCompDTO[0]);
	}
}
