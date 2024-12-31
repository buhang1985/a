package iih.en.pv.s.bp;

import iih.en.comm.validator.EnValidator;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 是否为高端商保
 * 
 * @author yankan
 *
 */
public class CheckIsHpcgBP {
	/**
	 * 判断就诊是否为高端商保
	 * 
	 * @param entId 就诊ID
	 * @return FBoolean
	 * @throws BizException
	 */
	public FBoolean exec(String entId) throws BizException {
		EnValidator.validateParam("就诊ID", entId);

		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT HP.FG_HPCG FROM EN_ENT ENT ");
		sqlBuilder.append("LEFT JOIN BD_HP HP ON ENT.ID_HP=HP.ID_HP ");
		sqlBuilder.append("WHERE ID_ENT=? ");

		SqlParam param = new SqlParam();
		param.addParam(entId);

		String isHpcgStr = (String)new DAFacade().execQuery(sqlBuilder.toString(), param, new ColumnHandler());
		return new FBoolean(isHpcgStr);
	}

}
