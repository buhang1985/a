package iih.bd.pp.anhuisrvorca.s.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.anhuisrvorca.d.DrugCompDTO;
import iih.bd.pp.hpsrvorca.d.HpStatusEnum;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 取消自费
 * 
 * @author dj.zhang
 *
 */
public class CanCleOwnExpenseBp {

	public String[] exec(DrugCompDTO[] drugCompDTOs) throws BizException {
		if (drugCompDTOs == null || drugCompDTOs.length <= 0) {
			throw new BizException("没有需要取消自费的数据");
		}
		String[] ids = getNeedSetData(drugCompDTOs);
		String[] result = setOwnExpense(ids);
		return result;
	}

	private String[] setOwnExpense(String[] ids) throws BizException {
		String needSetCodes = SqlUtils.getInSqlByBigIds("Id_mm", ids);
		String sql = "update bd_hp_srvorca set eu_status = " + HpStatusEnum.NOT_MATCHED + " where " + needSetCodes;
		DAFacade df = new DAFacade();
		df.execUpdate(sql);
		return ids;
	}

	private String[] getNeedSetData(DrugCompDTO[] drugCompDTOs) {
		List<String> codes = new ArrayList<String>();
		for (DrugCompDTO drugComp : drugCompDTOs) {
			codes.add(drugComp.getId_mm());
		}
		return codes.toArray(new String[0]);
	}

}
