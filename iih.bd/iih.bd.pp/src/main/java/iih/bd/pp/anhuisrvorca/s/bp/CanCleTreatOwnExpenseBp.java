package iih.bd.pp.anhuisrvorca.s.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.anhuisrvorca.d.TreatCompDTO;
import iih.bd.pp.hpsrvorca.d.HpStatusEnum;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;

public class CanCleTreatOwnExpenseBp {

	public String[] exec(TreatCompDTO[] treatCompDTOs) throws BizException {
		if (treatCompDTOs == null || treatCompDTOs.length <= 0) {
			throw new BizException("没有需要取消自费的数据");
		}
		String[] ids = getNeedSetData(treatCompDTOs);
		String[] result = canCleTreatOwnExpense(ids);
		return result;
	}

	private String[] canCleTreatOwnExpense(String[] ids) throws BizException {
		String needSetCodes = SqlUtils.getInSqlByBigIds("Id_srv", ids);
		String sql = "update bd_hp_srvorca set eu_status = " + HpStatusEnum.NOT_MATCHED + " where " + needSetCodes;
		DAFacade df = new DAFacade();
		df.execUpdate(sql);
		return ids;
	}

	private String[] getNeedSetData(TreatCompDTO[] treatCompDTOs) {
		List<String> ids = new ArrayList<String>();
		for (TreatCompDTO treatComp : treatCompDTOs) {
			ids.add(treatComp.getId_srv());
		}
		return ids.toArray(new String[0]);
	}

}
