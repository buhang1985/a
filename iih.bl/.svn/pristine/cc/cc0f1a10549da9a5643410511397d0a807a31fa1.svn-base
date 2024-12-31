package iih.bl.cg.s.bp.validate;

import iih.bd.base.exception.ArgumentNullException;
import iih.bd.base.utils.SqlUtils;
import iih.bl.cg.dto.d.BlStStateEnum;
import iih.bl.cg.s.bp.op.BlOpClearAccSuspDataBP;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.handler.ColumnListHandler;

/**
 * 门诊医嘱服务是否已经结算
 * @author ly 2018/08/23
 *
 */
public class OpOrsrvHasSettledBP {

	/**
	 * 门诊医嘱服务是否已经结算
	 * @param orsrvIds 医嘱服务数组
	 * @return 全部结算:true 否则false
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public Integer exec(String[] orsrvIds) throws BizException{

		if (ArrayUtil.isEmpty(orsrvIds)) {
			throw new ArgumentNullException("门诊医嘱服务是否已经结算", "医嘱服务数组");
		}
		
		//删除挂起数据
		BlOpClearAccSuspDataBP bp = new BlOpClearAccSuspDataBP();
		bp.exec(orsrvIds);
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select distinct stoep.id_stoep ");
		sqlSb.append("from bl_cg_itm_oep cgitm ");
		sqlSb.append("inner join bl_cg_oep cgoep ");
		sqlSb.append("on cgitm.id_cgoep = cgoep.id_cgoep ");
		sqlSb.append("and cgoep.eu_direct = 1 ");
		sqlSb.append("inner join bl_st_oep stoep ");
		sqlSb.append("on cgitm.id_stoep = stoep.id_stoep ");
		sqlSb.append("and length(stoep.id_paypatoep) > 2 ");
		sqlSb.append("where " + SqlUtils.getInSqlByIds("cgitm.id_orsrv", orsrvIds));
		
		DAFacade daf = new DAFacade();
		List<Object> result = (List<Object>)daf.execQuery(sqlSb.toString(), new ColumnListHandler());
		if(ListUtil.isEmpty(result))
			return BlStStateEnum.ST_NOT;
		
		// 不考虑查询到多次结算的情况
		String stId = (String)result.get(0);
		
		sqlSb = new StringBuilder();
		sqlSb.append("select count(1) from bl_st_oep ");
		sqlSb.append("inner join bl_prop_oep ");
		sqlSb.append("on bl_st_oep.id_stoep = bl_prop_oep.id_stoep ");
		sqlSb.append("where bl_st_oep.id_stoep = '" + stId + "'");
		
		Integer count = (Integer)daf.execQuery(sqlSb.toString(), new ColumnHandler());
		
		if(count == 0){
			return BlStStateEnum.ST_COMMON;
		}
		
		return BlStStateEnum.ST_HP;
	}
}
