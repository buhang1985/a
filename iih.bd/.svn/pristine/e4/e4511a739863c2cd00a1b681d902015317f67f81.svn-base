package iih.bd.webservice.test.s;

import iih.bd.utils.WsXmlUtils;
import iih.bd.webservice.test.bean.OnLineTestResultBean;
import iih.bd.webservice.test.i.IOnLineTestWebService;

/**
 * 在线测试WebService
 * 
 * @author hao_wu 2018-7-16
 *
 */
public class OnLineTestWebServiceImpl implements IOnLineTestWebService {

	@Override
	public String test() {
		OnLineTestResultBean resultBean = new OnLineTestResultBean();
		String resultXml = WsXmlUtils.serialize(resultBean);
		return resultXml;
	}

}
