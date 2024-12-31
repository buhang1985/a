package iih.bd.fc.que.bp;

import java.util.List;

import iih.bd.fc.que.d.QueDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 判断队列是否有相对应排班计划
 * 
 * @author liubin
 *
 */
public class HasScPlBP {
	/**
	 * 判断队列是否有相对应排班计划
	 * 
	 * @param que
	 * 		队列DO
	 * @return
	 * @throws BizException
	 * @author liubin
	 */
	public FBoolean hasScPl(QueDO que) throws BizException {
		if(que==null){
			return FBoolean.FALSE;
		}
		String sql = "SELECT PL.ID_SCPL FROM SC_PL PL WHERE PL.ID_SCRES = ? AND PL.ID_DEP = ? AND PL.DS = 0 ";
		SqlParam param = new SqlParam();
		param.addParam(que.getId_scres());
		param.addParam(que.getId_dep());
		List<String> list = (List<String>) new DAFacade().execQuery(sql, param, new ColumnListHandler());
		if(!ListUtil.isEmpty(list)){
			return FBoolean.TRUE;
		}
		return FBoolean.FALSE;
	}
}
