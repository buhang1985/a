package iih.ei.std.bd.v1.s;

import iih.ei.std.bd.v1.i.IBdQryWebService;
import iih.ei.std.bd.v1.s.bp.FindXmlViewDataBp;

/**
 * 基础数据查询Web服务
 * 
 * @author hao_wu 2019-2-26
 *
 */
public class BdQryWebServiceImpl implements IBdQryWebService {

	@Override
	public String findData(String paramXml) {
		FindXmlViewDataBp bp = new FindXmlViewDataBp();
		String xmlStr = bp.exec(paramXml);
		return xmlStr;
	}
}
