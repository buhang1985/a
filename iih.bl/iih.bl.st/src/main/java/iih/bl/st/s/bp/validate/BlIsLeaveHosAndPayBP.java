package iih.bl.st.s.bp.validate;

import iih.bl.st.blstoep.d.StTypeEnum;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 判断是否已经做了出院收付款业务
 * @author ly 2019/03/26
 *
 */
public class BlIsLeaveHosAndPayBP {

	/**
	 *  判断是否已经做了出院收付款业务
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public FBoolean exec(String entId) throws BizException{
		
		if(StringUtil.isEmpty(entId)){
			throw new BizException("判断出院收付款:入参就诊id为空");
		}
		
		String sql = "select count(1) from bl_st_ip "
				+ "where id_ent = ? "
				+ "and fg_canc = 'N' "
				+ "and fg_pay = 'Y' "
				+ "and eu_direct = 1 "
				+ "and eu_sttp  = ?";
		SqlParam param = new SqlParam();
		param.addParam(entId);
		param.addParam(StTypeEnum.ST_INP);
		
		DAFacade daf = new DAFacade();
		Integer count = (Integer)daf.execQuery(sql, param, new ColumnHandler());
		
		return count == 0 ? FBoolean.FALSE : FBoolean.TRUE;
	}
}
