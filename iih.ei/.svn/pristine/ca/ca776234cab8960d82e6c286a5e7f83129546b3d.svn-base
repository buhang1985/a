package iih.ei.std.bd.v1.s.bp;

import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;

/**
 * 根据接口编码查询视图数据业务逻辑
 * 
 * @author hao_wu 2019-2-27
 *
 */
public class FindViewDataByItfCodeBp {

	public List<Map<String, Object>> exec(String itfCode) throws BizException {
		String viewName = findViewNameByCode(itfCode);
		FindViewDataByViewNameBp bp = new FindViewDataByViewNameBp();
		List<Map<String, Object>> dataList = bp.exec(viewName);
		return dataList;
	}

	/**
	 * 根据接口编码获取视图名称
	 * 
	 * @param itfCode 接口编码
	 * @return
	 * @throws BizException
	 */
	private String findViewNameByCode(String itfCode) throws BizException {
		FindViewNameByItfCodeBp bp = new FindViewNameByItfCodeBp();
		String viewName = bp.exec(itfCode);
		return viewName;
	}

}
