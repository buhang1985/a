package iih.bd.fc.wf.s.bp;

import java.util.List;

import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;

/**
 * 获取当前bd_wf下的执行科室最大序号
 * @author guoyang
 *
 */
public class GetMaxSortNOBp {
	
	public int exec(String idwf) {
		return getMaxNo(idwf) + 1;
	}
	
	private int getMaxNo(String idwf) {
		String sql = " SELECT NVL(MAX(SORTNO),0) FROM BD_WF_DEP WHERE ID_WF = '"+ idwf +"' ";
		int maxSrotno;
		try {
			@SuppressWarnings("unchecked")
			List<Integer> list = (List<Integer>) new DAFacade().execQuery(sql, new ColumnListHandler());
			maxSrotno = list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return maxSrotno;
	}

}
