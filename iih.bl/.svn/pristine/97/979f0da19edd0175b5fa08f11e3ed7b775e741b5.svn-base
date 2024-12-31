package iih.bl.cg.s.ep;

import java.util.List;

import iih.bd.base.utils.SqlUtils;
import iih.bl.cg.blcgoeptf.d.BlCgItmOepTfRcdDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 门诊费用转移记录EP
 * @author ly 2019/03/13
 *
 */
public class BlCgItmOepTfRcdEP {

	/**
	 * 根据记账id检索有效的转移记录
	 * @param cgItmIds
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public BlCgItmOepTfRcdDO[] getOepTfRcdByCgItmIds(String[] cgItmIds) throws BizException{
	
		if(ArrayUtil.isEmpty(cgItmIds))
			return null;
		
		String sql = "select * from bl_cg_itm_oep_tfrcd where fg_active = 'Y' and ";
		sql += SqlUtils.getInSqlByParamValues("id_cgitmoep", cgItmIds);
		
		SqlParam sqlParam = new SqlParam();
		for (String cgId : cgItmIds) {
			sqlParam.addParam(cgId);
		}
		
		DAFacade daf = new DAFacade();
		List<BlCgItmOepTfRcdDO> rlt = (List<BlCgItmOepTfRcdDO>) daf.execQuery(
				sql, sqlParam, new BeanListHandler(BlCgItmOepTfRcdDO.class));		
		
		if(ListUtil.isEmpty(rlt))
			return null;
		
		return rlt.toArray(new BlCgItmOepTfRcdDO[0]);
			
	}
}
