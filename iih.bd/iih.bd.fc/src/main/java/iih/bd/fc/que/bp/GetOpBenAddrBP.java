package iih.bd.fc.que.bp;

import java.util.List;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class GetOpBenAddrBP {
	/**
	 * 获取门诊分诊台地址
	 * 
	 * @param depId
	 * @param scresId
	 * @return
	 * @throws BizException
	 */
	public String exec(String depId, String scresId, String benId)
			throws BizException {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT DISTINCT BD_QUE_BEN.DES ");
		sb.append("FROM BD_QUE_BEN BD_QUE_BEN INNER JOIN BD_QUE BD_QUE ON BD_QUE_BEN.ID_QUEBEN = BD_QUE.ID_QUEBEN ");
		sb.append("WHERE BD_QUE.FG_ACTIVE = ? ");
		sb.append("AND BD_QUE.SD_QUETP = ? ");
		sb.append("AND BD_QUE.ID_DEP = ? ");
		sb.append("AND BD_QUE.ID_SCRES = ? ");
		SqlParam param = new SqlParam();
		param.addParam(FBoolean.TRUE);
		param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		param.addParam(depId);
		param.addParam(scresId);
		if(!StringUtil.isEmptyWithTrim(benId)){
			sb.append("AND BD_QUE.ID_QUEBEN = ? ");
			param.addParam(benId);
		}
		List<String> list = (List<String>) new DAFacade().execQuery(sb.toString(), param, new ColumnListHandler());
		if(!ListUtil.isEmpty(list))
			return list.get(0);
		return null;
	}
}
