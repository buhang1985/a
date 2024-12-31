package iih.bl.st.s.bp.op;

import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.st.blstoep.d.BlStOepDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据记账id查询结算数据
 * @author ly 2019/07/17
 *
 */
public class GetBlStByIdCgBP {

	/**
	 * 根据记账id查询结算数据
	 * @param cgId
	 * @return
	 * @throws BizException
	 */
	public BlStOepDO exec(String cgId) throws BizException{
		
		if(StringUtil.isEmpty(cgId)){
			throw new BizException("查询结算数据：入参记账id为空");
		}
		
		String stIdSql = "select distinct itmoep.id_stoep id_stoep from bl_cg_itm_oep itmoep "
				+ "inner join bl_cg_oep oep "
				+ "on itmoep.id_cgoep =  oep.id_cgoep "
				+ "where oep.id_cgoep = ? ";
		
		DAFacade daf = new DAFacade();
		SqlParam param = new SqlParam();
		param.addParam(cgId);
		BlCgItmOepDO rlt = (BlCgItmOepDO)daf.execQuery(stIdSql, param, new BeanHandler(BlCgItmOepDO.class));
		if(rlt == null || StringUtil.isEmpty(rlt.getId_stoep()))
			return null;
		
		BlStOepDO stData = (BlStOepDO)daf.findByPK(BlStOepDO.class, rlt.getId_stoep());
		return stData;
	}
}
