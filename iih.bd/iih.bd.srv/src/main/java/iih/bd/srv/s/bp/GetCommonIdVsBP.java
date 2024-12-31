package iih.bd.srv.s.bp;

import iih.bd.srv.oth.d.CommonIDVsDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.orm.utils.ITransQry;

/**
 * 获得通用主键及值数据操作BP
 */
public class GetCommonIdVsBP {
	/**
	 * 获得通用主键及值数据操作
	 * @param qry
	 * @return
	 * @throws BizException
	 */
	public CommonIDVsDO[] exec(ITransQry qry)throws BizException {
		CommonIDVsDO[] rtn = (CommonIDVsDO[]) AppFwUtil.getDORstWithDao(qry,
				CommonIDVsDO.class);
		return rtn;
	}
}
