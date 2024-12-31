package iih.bd.pp.anhuisrvorca.s.bp;

import iih.bd.pp.hpsrvorca.d.HpStatusEnum;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 删除未对照数据业务逻辑
 * 
 * @author hao_wu
 *
 */
public class DeleteNoMatchedDataBp {

	public void exec(String hpId, Integer euHpSrvTp) throws BizException {
		DAFacade daFacade = new DAFacade();
		String sqlStr = "DELETE FROM BD_HP_SRVORCA WHERE EU_STATUS = ? AND ID_GRP = ? AND ID_ORG = ? AND EU_HPSRVTP = ? AND ID_HP = ?";
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(HpStatusEnum.NOT_MATCHED);
		sqlParam.addParam(Context.get().getGroupId());
		sqlParam.addParam(Context.get().getOrgId());
		sqlParam.addParam(euHpSrvTp);
		sqlParam.addParam(hpId);
		daFacade.execUpdate(sqlStr, sqlParam);
	}
}
