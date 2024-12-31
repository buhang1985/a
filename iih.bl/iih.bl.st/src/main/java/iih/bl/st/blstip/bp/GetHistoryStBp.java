package iih.bl.st.blstip.bp;

import iih.bl.st.blcgipdto.d.BlStBaseInfo;
import iih.bl.st.blstip.bp.Qry.GetHistoryStQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 查询历史结算信息
 * @author liwenqiang
 *
 */
public class GetHistoryStBp {
	/**
	 * 查询历史结算信息
	 * @param stInfo
	 * @return
	 * @author liwenqiang
	 * @throws BizException 
	 */
	public BlStBaseInfo[] exec(String entId) throws BizException{
		BlStBaseInfo[] stInfo = (BlStBaseInfo[]) AppFwUtil
				.getDORstWithDao(new GetHistoryStQry(entId),
						BlStBaseInfo.class);
		return stInfo;
	}
}
