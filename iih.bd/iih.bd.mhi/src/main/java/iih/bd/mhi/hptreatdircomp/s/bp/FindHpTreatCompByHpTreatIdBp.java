package iih.bd.mhi.hptreatdircomp.s.bp;

import java.util.ArrayList;

import iih.bd.base.utils.SqlUtils;
import iih.bd.mhi.hptreatdircomp.d.HpTreatDirCompDTO;
import iih.bd.mhi.hptreatdircomp.s.bp.sql.FindHpTreatCompSql;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * @author dj.zhang
 *
 */
public class FindHpTreatCompByHpTreatIdBp {

	public HpTreatDirCompDTO[] exec(String hpId, String[] hpTreatIds) throws BizException {
		String wherePart = SqlUtils.getInSqlByIds("BD_SRV.ID_SRV", hpTreatIds);
		FindHpTreatCompSql sql = new FindHpTreatCompSql(hpId, wherePart);

		DAFacade daFacade = new DAFacade();
		@SuppressWarnings("unchecked")
		ArrayList<HpTreatDirCompDTO> result = (ArrayList<HpTreatDirCompDTO>) daFacade.execQuery(sql.getQrySQLStr(),
				sql.getQryParameter(null), new BeanListHandler(HpTreatDirCompDTO.class));
		if(result == null){
			return null;
		}
		return result.toArray(new HpTreatDirCompDTO[0]);
	}

}
