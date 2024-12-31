package iih.bl.cg.s.bp.op;

import java.util.List;

import iih.bd.base.utils.SqlUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;

/**
 *  通过医嘱服务id查询门诊记账明细id
 * @author ly 2018/07/28
 *
 */
public class GetCgOepItmIdsByOrsrvBP {

	/**
	 * 通过医嘱服务id查询门诊记账明细id
	 * @param orsrvIds 医嘱服务ids
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public String[] exec(String[] orsrvIds) throws BizException{
		
		if(ArrayUtil.isEmpty(orsrvIds))
			return null;
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select itmoep.id_cgitmoep  ");
		sqlSb.append("from bl_cg_itm_oep itmoep ");
		sqlSb.append("inner join bl_cg_oep oep ");
		sqlSb.append("on itmoep.id_cgoep = oep.id_cgoep ");
		sqlSb.append("and oep.eu_direct = 1 ");
		sqlSb.append("where " + SqlUtils.getInSqlByIds("itmoep.id_orsrv", orsrvIds));
		
		DAFacade daf = new DAFacade();
		List<Object> rlt = (List<Object>)daf.execQuery(sqlSb.toString(), new ColumnListHandler());
		if(ListUtil.isEmpty(rlt))
			return null;
		
		return rlt.toArray(new String[0]);
	}
}
