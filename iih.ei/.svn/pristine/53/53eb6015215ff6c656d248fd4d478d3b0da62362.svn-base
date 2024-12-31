package iih.ei.std.bd.v1.s.bp;

import java.util.List;
import java.util.Map;

import iih.ei.std.bd.v1.model.BDQryParam;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;

/**
 * 查询XML视图数据业务逻辑
 * 
 * @author hao_wu 2019-2-27
 *
 */
public class FindXmlViewDataBp {

	public String exec(String paramXml) {
		try {
			BDQryParam qryParam = BDQryParam.deSerializeByXml(paramXml);
			String viewName = findViewNameByCode(qryParam.getItfCode());

			PaginationInfo pgInfo = qryParam.getPgInfo();
			if (pgInfo != null) {
				FindXmlPagingViewDataByViewNameBp bp = new FindXmlPagingViewDataByViewNameBp();
				String resultXml = bp.exec(qryParam, viewName);
				return resultXml;
			} else {
				FindViewDataByViewNameBp bp = new FindViewDataByViewNameBp();
				List<Map<String, Object>> dataList = bp.exec(viewName);

				String resultXml = convertToXml(dataList);
				return resultXml;
			}

		} catch (Exception e) {
			CreateErrXmlByExBp bp = new CreateErrXmlByExBp();
			String resultXml = bp.exec(e);
			return resultXml;
		}
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
