package iih.ci.ord.s.external.thirdws.bp;

import java.util.HashMap;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import iih.ci.ord.ciorder.d.desc.CiOrderDODesc;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.external.blood.ruimei.s.bp.ApiUtils;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.custcfg.billcode.i.IBillcodeManage;

public class ThirdwsAppUtils {
	
	public String getOrdCode() throws BizException {
		IBillcodeManage codeManage = ServiceFinder.find(IBillcodeManage.class);
//		String code_or = codeManage.getPreBillCode_RequiresNew(CiOrderDODesc.CLASS_FULLNAME);
		String code_or = CiOrdAppUtils.getCiOrdQryService().getCodeOr();
		return code_or;
	}
	
	/**
	 * 返回值
	 * 
	 * @param code
	 * @param msg
	 * @return
	 */
	public  String getRstMsgCodeMsg(String code) {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		sqlStr.append("<results>                                   \n");
		sqlStr.append(" 	<code_or>" + code + "</code_or>   \n");
		sqlStr.append(" 	<msg></msg>        \n");
		sqlStr.append("</results>                                  \n");
		return sqlStr.toString();
	}

}
