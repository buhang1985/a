package iih.bd.srv.preformat.s.bp;

import java.util.List;

import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;

/**
 * 获取新序号业务逻辑
 * 
 * @author hao_wu
 *
 */
public class GetNewSerialNumberBp {

	public int exec(String str, Boolean b) {
		int maxSerialNumber = getMaxSerialNumber(str, b);
		return maxSerialNumber + 1;
	}

	/**
	 * 获取最大序号
	 * 
	 * @return
	 */
	private int getMaxSerialNumber(String str, boolean b) {
		String sql = "SELECT NVL(MAX(nu_sort),0) FROM bd_mr_pre_format";
		if(b){
			sql += " WHERE id_dept = '"+str+"' ";
		}else{
			sql += " WHERE id_entp = '"+str+"' ";
		}
		int maxSerialNumber;
		try {
			@SuppressWarnings("unchecked")
			List<Integer> list = (List<Integer>) new DAFacade().execQuery(sql, new ColumnListHandler());
			maxSerialNumber = list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return maxSerialNumber;
	}
}