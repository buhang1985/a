package iih.bd.pp.anhuisrvorca.s.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.anhuisrvorca.d.DrugCompDTO;
import iih.bd.pp.hpsrvorca.d.HpStatusEnum;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 设置自费
 * 
 * @author dj.zhang
 *
 */
public class SetOwnExpenseBp {

	public String[] exec(DrugCompDTO[] drugCompDTOs) throws BizException {
		if (drugCompDTOs == null || drugCompDTOs.length <= 0) {
			throw new BizException("没有设为自费的数据");
		}
		String[] ids = getNeedSetData(drugCompDTOs);
		String[] result = setOwnExpense(ids,drugCompDTOs[0].getId_hp());
		return result;
	}

	/**
	 * 获取数据
	 * 
	 * @param drugCompDTOs
	 * @return
	 */
	private String[] getNeedSetData(DrugCompDTO[] drugCompDTOs) {
		List<String> ids = new ArrayList<String>();
		for (DrugCompDTO drugComp : drugCompDTOs) {
			ids.add(drugComp.getId_mm());
		}
		return ids.toArray(new String[0]);
	}

	/**
	 * @param drugCompDTOs
	 * @return
	 * @throws DAException
	 */
	private String[] setOwnExpense(String[] ids,String id_hp) throws BizException {
		String needSetCodes = SqlUtils.getInSqlByBigIds("Id_mm", ids);
		String sql = "update bd_hp_srvorca set eu_status = " + HpStatusEnum.OWNEXPENS + " where " + needSetCodes+" and id_hp='"+id_hp+"'";
		DAFacade df = new DAFacade();
		df.execUpdate(sql);
		return ids;
	}

}
