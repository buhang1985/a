package iih.en.pv.s.bp;

import iih.en.comm.validator.EnValidator;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 判断是否是高端商保
 * 
 * @author liubin
 *
 */
public class CheckIsHpCmClBP {
	/**
	 * 判断医保是否为高端商保
	 * @param hpId 医保计划ID
	 * @return FBoolean
	 * @throws BizException
	 * @author yankan
	 */
	public FBoolean exec(String hpId) throws BizException {
		if(EnValidator.isEmpty(hpId))
			return FBoolean.FALSE;
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT HP.ID_HP FROM BD_HP HP ");
		sb.append("WHERE HP.ID_HP = ? ");
		sb.append("AND HP.FG_HPCG = ? ");
		sb.append("AND HP.SD_HPTP LIKE ? ");
		SqlParam param = new SqlParam();
		param.addParam(hpId);
		param.addParam(FBoolean.TRUE);
		param.addParam("2%");
		String hp = (String)new DAFacade().execQuery(sb.toString(), param, new ColumnHandler());
		return new FBoolean(!EnValidator.isEmpty(hp));
	}
}
