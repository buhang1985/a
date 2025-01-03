package iih.bd.pp.anhuisrvorca.s.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.anhuisrvorca.d.TreatCompDTO;
import iih.bd.pp.hpsrvorca.d.HpStatusEnum;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;

/**
 * @author dj.zhang
 *
 */
public class SetTreatOwnExpenseBp {

	public String[] exec(TreatCompDTO[] treatCompDTOs) throws BizException {
		if (treatCompDTOs == null || treatCompDTOs.length <= 0) {
			throw new BizException("没有设为自费的数据");
		}
		String[] ids = getNeedSetData(treatCompDTOs);
		String[] result = setTreatOwnExpense(ids,treatCompDTOs[0].getId_hp());
		return result;
	}

	private String[] setTreatOwnExpense(String[] ids,String id_hp) throws BizException {
		String needSetCodes = SqlUtils.getInSqlByBigIds("Id_srv", ids);
		String sql = "update bd_hp_srvorca set eu_status = " + HpStatusEnum.OWNEXPENS + " where " + needSetCodes+" and id_hp='"+id_hp+"'";
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
