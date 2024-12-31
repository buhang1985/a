package iih.ci.ord.s.bp.ciprn;

import iih.ci.ord.app.d.CiAppBuSheetDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 用血申请单打印数据删除
 * @author Young
 *
 */
public class CiprnDeleteAppBuDataBP {

	public FBoolean exec(String[] idors) throws BizException {
		if (idors == null || idors.length <= 0)
			return FBoolean.TRUE;
		CiAppBuSheetDO[] busheets = CiprnUtils.GetCiAppBuSheetDOsByIdor(idors);
		if (busheets == null || busheets.length <= 0)
			return FBoolean.TRUE;
		CiprnUtils.DeleteCiAppBuSheetDOs(busheets);
		return FBoolean.TRUE;
	}
}
