package iih.bl.cg.s.bp.validate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.base.exception.ArgumentNullException;
import iih.bd.base.utils.SqlUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;

/**
 * 门诊医嘱是否已经结算
 * @author ly 2019/06/17
 */
public class OpOrdHasSettledBP {

	/**
	 * 门诊医嘱是否已经结算
	 * 医嘱下有服务结算即结算
	 * @param orIds 医嘱数据
	 * @return key:医嘱id value: 是否结算
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public Map<String, FBoolean> exec(String[] orIds) throws BizException{
		
		if (ArrayUtil.isEmpty(orIds)) {
			throw new ArgumentNullException("门诊医嘱是否已经结算", "医嘱数组");
		}

		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select distinct cgitm.id_or ");
		sqlSb.append("from bl_cg_itm_oep cgitm ");
		sqlSb.append("inner join bl_cg_oep cgoep ");
		sqlSb.append("on cgitm.id_cgoep = cgoep.id_cgoep ");
		sqlSb.append("and cgoep.eu_direct = 1 ");
		sqlSb.append("inner join bl_st_oep stoep ");
		sqlSb.append("on cgitm.id_stoep = stoep.id_stoep ");
		sqlSb.append("and length(stoep.id_paypatoep) > 2 ");
		sqlSb.append("where " + SqlUtils.getInSqlByIds("cgitm.id_or", orIds));

		DAFacade daf = new DAFacade();
		List<Object> rlt = (List<Object>) daf.execQuery(sqlSb.toString(), new ColumnListHandler());

		if (rlt == null) {
			rlt = new ArrayList<Object>();
		}

		Map<String, FBoolean> rltMap = new HashMap<String, FBoolean>();
		for (String orId : orIds) {

			boolean has = false;
			for (Object obj : rlt) {
				if(orId.equals((String)obj)){
					has = true;
					break;
				}
			}
			rltMap.put(orId, has ? FBoolean.TRUE : FBoolean.FALSE);
		}

		return rltMap;
	}
}
