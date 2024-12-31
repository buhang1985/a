package iih.bd.pp.bdhpspec.s.bp;

import java.util.ArrayList;

import iih.bd.pp.bdhpspec.d.BdHpSpecDO;
import iih.bd.pp.bdhpspec.s.bp.sql.FindBdHpSpecSql;
import iih.bd.pp.hp.d.HPDO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 使用医保计划查询医保特殊病列表业务逻辑
 * 
 * @author hao_wu
 *
 */
public class FindByHpBp {

	public BdHpSpecDO[] exec(HPDO hpdo) throws BizException {
		String wherePart = GetWherePart(hpdo);
		FindBdHpSpecSql sql = new FindBdHpSpecSql(wherePart);
		DAFacade daFacade = new DAFacade();
		@SuppressWarnings("unchecked")
		ArrayList<BdHpSpecDO> dataList = (ArrayList<BdHpSpecDO>) daFacade.execQuery(sql.getQrySQLStr(),
				sql.getQryParameter(null), new BeanListHandler(BdHpSpecDO.class));
		if (dataList != null) {
			return dataList.toArray(new BdHpSpecDO[0]);
		}
		return null;
	}

	/**
	 * 获取条件语句
	 * 
	 * @param hpdo
	 * @return
	 */
	private String GetWherePart(HPDO hpdo) {
		StringBuilder wherePartBuilder = new StringBuilder(" 1 = 1 ");
		if (hpdo != null) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(String.format(" ID_HP = '%s' ", hpdo.getId_hp()));
		}
		return wherePartBuilder.toString();
	}

}
