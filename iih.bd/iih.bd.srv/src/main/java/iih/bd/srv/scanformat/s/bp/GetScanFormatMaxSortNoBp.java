package iih.bd.srv.scanformat.s.bp;

import java.util.List;

import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;

/**
 * 获取扫描格式最大排序号bp
 * @author guoyang
 *
 */
public class GetScanFormatMaxSortNoBp {

	public int exec() {
		return getMaxNo() + 1;
	}

	private int getMaxNo() {
		String sql = " SELECT NVL(MAX(SORTNO),0) FROM BD_MRM_DF ";
		
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