package iih.bd.pp.hp.s.bp;

import java.util.List;

import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;

/**
 * 医保计划总额分摊策略获取最大序号
 * @author guoyang
 *
 */
public class PropMaxSortnoBp {

	public int exec(String id_hp){
		return getMaxSortno(id_hp)+1;
	}
	
	/**
	 * 获取医保计划总额分摊策略最大序号
	 * @param id_hp
	 * @return
	 */
	private int getMaxSortno(String id_hp){
		String sql = " select nvl(max(sortno),0) from bd_hp_prop ";
		if(id_hp != null){
			sql +=" WHERE ID_HP = '" + id_hp + "' ";
		}
		try {
			@SuppressWarnings("unchecked")
			List<Integer> list = (List<Integer>) new DAFacade().execQuery(sql, new ColumnListHandler());
			return list.get(0);
		} catch (DAException e) {
			e.printStackTrace();
			return 0;
		}
	}
}
