package iih.en.pv.s.bp.ip;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.en.comm.ep.EnAccEP;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.enfee.d.EnAccountDO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 通过科室id或病区id获取就诊账户
 * 
 * @author liubin
 *
 */
public class GetEnIpAccsByDepBP {
	/**
	 * 通过科室id或病区id获取就诊账户
	 * 
	 * @param depId 科室id或病区id
	 * @return
	 * @throws BizException
	 */
	public EnAccountDO[] exec(String depId) throws BizException {
		if(EnValidator.isEmpty(depId))
			return null;
		String sql = "SELECT EN.ID_ENT FROM EN_ENT EN "
				+ "WHERE EN.CODE_ENTP=? "
				+ "AND EN.FG_CANC = ? "
				+ "AND EN.FG_IP = ? "
				+ "AND (EN.ID_DEP_PHY = ? OR EN.ID_DEP_NUR = ?)";
		SqlParam param = new SqlParam();
		param.addParam(IBdFcDictCodeConst.SD_CODE_ENTP_IP);
		param.addParam(FBoolean.FALSE);
		param.addParam(FBoolean.TRUE);
		param.addParam(depId);
		param.addParam(depId);
		List<String> list = (List<String>) new DAFacade().execQuery(sql, param, new ColumnHandler());
		if(!EnValidator.isEmpty(list))
			return new EnAccEP().getEnAccList(list.toArray(new String[0]));
		return null;
	}
}
 