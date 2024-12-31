package iih.ci.ord.s.bp.ciprn;

import iih.ci.ord.app.d.CiappbtsheetAggDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 备血申请单打印数据删除
 * @author Young
 *
 */
public class CiprnDeleteAppBtDataBP {

	public FBoolean exec(String[] idors) throws BizException {
		if (idors == null || idors.length <= 0)
			return FBoolean.TRUE;
		CiappbtsheetAggDO[] btsheets = CiprnUtils.GetCiappbtsheetAggDOsByIdor(idors);
		if (btsheets == null || btsheets.length <= 0)
			return FBoolean.TRUE;
		CiprnUtils.DeleteCiappbtsheetAggDOs(btsheets);
		return FBoolean.TRUE;
	}
}
