package iih.ci.ord.s.external.thirdws.operation;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 第三方收费状态判断
 * @author zhangwq
 *
 */
public class ThirdGetBlStatusBP {
	
	public static String Code_or = "Code_or";

	public String getBlStatus(String pareXml) throws BizException {
		CiOrderDO[] ciOrderDOs=getCiorder(pareXml);
		if (ciOrderDOs!=null) {
			return outputexe(ciOrderDOs);
		}else{
			return getoutformMsg("1","不存在该医嘱编码对应的医嘱信息");
		}
			
	}
	
	public  String getoutformMsg(String code, String msg) {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n");
		sqlStr.append("<root>                                   \n");
		sqlStr.append(" 		<resultcode>" + code + "</resultcode>          \n");
		sqlStr.append(" 		<resultmsg>" + msg + "</resultmsg>     \n");
		sqlStr.append("</root>                                  \n");
		return sqlStr.toString();
	}
	
	private String outputexe(CiOrderDO[] ciOrderDOs) {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n");
		sqlStr.append("<root>                                   \n");
		for (CiOrderDO ciOrderDO : ciOrderDOs) {
			sqlStr.append(" 	<orderitem>  \n");
			sqlStr.append(" 		<code_or>" +ciOrderDO.getCode_or()  + "</code_or>          \n");
			sqlStr.append(" 		<sd_su_bl>" + ciOrderDO.getSd_su_bl() + "</sd_su_bl>     \n");
			sqlStr.append(" 	</orderitem>  \n");
		}
		
		sqlStr.append("</root>                                  \n");
		return sqlStr.toString();
		
	}

	private CiOrderDO[] getCiorder(String pareXml) throws BizException {
		if (pareXml!=null && pareXml.length()>0) {
			pareXml=pareXml.substring(0,pareXml.length()-1);
			if (pareXml.contains(",")) {
				String[] code_ors = pareXml.split(",");
				ICiorderMDORService iCiorderMDORService=ServiceFinder.find(ICiorderMDORService.class);
				CiOrderDO[] ciOrderDOs = iCiorderMDORService.findByAttrValStrings(Code_or, code_ors) ;
				return ciOrderDOs;
			}else{
				String[] code_ors =new String[1];
				code_ors[0]=pareXml;
				ICiorderMDORService iCiorderMDORService=ServiceFinder.find(ICiorderMDORService.class);
				CiOrderDO[] ciOrderDOs = iCiorderMDORService.findByAttrValStrings(Code_or, code_ors) ;
				return ciOrderDOs;
			}
		}
		return null;

	}

	
	

}
