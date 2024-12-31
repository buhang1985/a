package iih.bd.srv.dataspecilchar.s.bp;

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

	public int exec() {
		int maxSerialNumber = getMaxSerialNumber();
		return maxSerialNumber + 1;
	}

	/**
	 * 获取最大序号
	 * 
	 * @return
	 */
	private int getMaxSerialNumber() {
		String sql = "SELECT NVL(MAX(ID_IN),0) FROM BD_SC";
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
