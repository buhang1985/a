package iih.ei.std.bd.v1.s.bp;

import iih.ei.std.bd.v1.model.BDQryParam;
import iih.ei.std.bd.v1.model.BdQryRtnData;
import xap.mw.core.data.BizException;

/**
 * 查询分页视图数据业务逻辑
 * 
 * @author hao_wu 2019-2-26
 *
 */
public class FindXmlPagingViewDataByViewNameBp {

	public String exec(BDQryParam qryParam, String viewName) {

		try {
			FindPagingViewDataByViewNameBp bp = new FindPagingViewDataByViewNameBp();
			BdQryRtnData pagRtnData = bp.exec(qryParam.getPgInfo(), viewName);

			String resultXml = convertToXml(pagRtnData);
			return resultXml;
		} catch (Exception e) {
			CreateErrXmlByExBp bp = new CreateErrXmlByExBp();
			String resultXml = bp.exec(e);
			return resultXml;
		}
	}

	/**
	 * 将分页数据信息序列化为Xml
	 * 
	 * @param pagRtnData
	 * @return
	 * @throws BizException
	 */
	private String convertToXml(BdQryRtnData pagRtnData) throws BizException {
		PagingDataSerializeBp bp = new PagingDataSerializeBp();
		String resultXml = bp.exec(pagRtnData);
		return resultXml;
	}
}
