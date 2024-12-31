package iih.bl.comm;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import xap.lui.core.xml.StringUtils;
import xap.mw.core.data.BizException;


/**
 * 业务工具类，处理一些业务方面的操作
 * @author yangyang
 *
 */
public class BlBizUtil {

	public static String getPrntTpName(String strPrntTpCode)
	{
		String strPrntTpName="";
		if(StringUtils.isEmptyWithTrim(strPrntTpCode))
			return null;
		switch(strPrntTpCode)
		{
			case IBdSrvDictCodeConst.DRUG_TYPE:
				strPrntTpName="药品";
				break;
			case IBdSrvDictCodeConst.RIS_TYPE:
				strPrntTpName="检查";
				break;
			case IBdSrvDictCodeConst.LIS_TYPE:
				strPrntTpName="检验";
				break;
			case IBdSrvDictCodeConst.TREATMENT_TYPE:
				strPrntTpName="诊疗";
			default:
				break;
		}
		return strPrntTpName;
	}
}
