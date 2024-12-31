package iih.mc.commom.qry.util;

import iih.bd.mm.common.MmSQLHelper;
import iih.bd.res.warehouse.util.WhDataperUtil;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ArrayUtil;

public class McWhDataperWhrUtil {
	
	public static String getWhDataperWhrStr(String whereStr, String columnName) throws BizException {
		
		StringBuffer wherePartBuffer = new StringBuffer();
		String[] whids = WhDataperUtil.getDataperWhIds(Context.get().getUserId());
		if(ArrayUtil.isEmpty(whids)){
			
			wherePartBuffer.append("1<>1");
		} else {
			
			wherePartBuffer.append(whereStr);
			wherePartBuffer.append(" and ");
			wherePartBuffer.append(MmSQLHelper.initInCondition(columnName, whids));
		}
		
		return wherePartBuffer.toString();
	}
}
