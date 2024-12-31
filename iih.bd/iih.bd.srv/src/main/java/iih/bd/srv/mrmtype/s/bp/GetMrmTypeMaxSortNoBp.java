package iih.bd.srv.mrmtype.s.bp;

import java.util.List;

import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;

/**
 * 获取病案分类最大排序号bp
 * @author guoyang
 *
 */
public class GetMrmTypeMaxSortNoBp {

	public int exec(String idStr, Boolean isentp) {
		return getMaxNo(idStr, isentp) + 1;
	}

	private int getMaxNo(String idStr, Boolean isentp) {
		String sql = " SELECT NVL(MAX(SORTNO),0) FROM BD_MRM_TP ";
		
		if(isentp){
			sql += " WHERE id_entp = '"+idStr+"' ";
		}else{
			sql += " WHERE id_dep = '"+idStr+"' ";
		}
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
