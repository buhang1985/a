package iih.ei.std.bd.v1.s.bp;

import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;

/**
 * 查询XML视图数据业务逻辑
 * 
 * @author hao_wu 2019-2-27
 *
 */
public class FindXmlViewDataByViewNameBp {

	public String exec(String viewName) {
		try {
			FindViewDataByViewNameBp bp = new FindViewDataByViewNameBp();
			List<Map<String, Object>> dataList = bp.exec(viewName);

			String resultXml = convertToXml(dataList);
			return resultXml;
		} catch (Exception e) {
			CreateErrXmlByExBp bp = new CreateErrXmlByExBp();
			String resultXml = bp.exec(e);
			return resultXml;
		}
	}

	/**
	 * 序列化数据
	 * 
	 * @param dataList
	 * @return
	 * @throws BizException
	 */
	private String convertToXml(List<Map<String, Object>> dataList) throws BizException {
		DataListSerializeBp bp = new DataListSerializeBp();
		String xmlStr = bp.exec(dataList);
		return xmlStr;
	}
}
