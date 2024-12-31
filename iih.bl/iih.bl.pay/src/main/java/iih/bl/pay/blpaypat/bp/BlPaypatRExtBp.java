package iih.bl.pay.blpaypat.bp;

import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.blpaypat.qry.BlPaypatRExtQry;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.utils.AppFwUtil;

public class BlPaypatRExtBp {

	/**
	 * 查询门诊预交金收退记录
	 * @param whereStr
	 * @param orderStr
	 * @param isLazy
	 * @return
	 * @throws BizException
	 * @author liwenqiang
	 */
	public BlPrePayPatDO[] exec(String whereStr, String orderStr, FBoolean isLazy) throws BizException{
		BlPrePayPatDO[] blPrePayPatDOs = (BlPrePayPatDO[]) AppFwUtil
				.getDORstWithDao(new BlPaypatRExtQry(whereStr,orderStr,isLazy),
						BlPrePayPatDO.class);
		
		return blPrePayPatDOs;
	}
}
