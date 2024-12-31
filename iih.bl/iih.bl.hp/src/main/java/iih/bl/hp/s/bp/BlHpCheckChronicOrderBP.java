package iih.bl.hp.s.bp;

import java.util.List;

import iih.bd.base.utils.SqlUtils;
import iih.bl.hp.dto.chronic.d.BlHpChronicCheck2DTO;
import iih.bl.hp.dto.chronic.d.BlHpChronicCheckDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 
 * 校验慢性病医嘱
 * @author ly 2019/10/21
 *
 */
public class BlHpCheckChronicOrderBP {

	/**
	 * 校验慢性病医嘱
	 * @param orIds
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public BlHpChronicCheck2DTO[] exec(String[] orIds) throws BizException{
		
		if(ArrayUtil.isEmpty(orIds))
			return null;
		
		String sql = this.getSql(orIds);
		DAFacade daf = new DAFacade();
		List<BlHpChronicCheck2DTO> rlt = (List<BlHpChronicCheck2DTO>) daf
				.execQuery(sql, new BeanListHandler(BlHpChronicCheck2DTO.class));		
		
		if(ListUtil.isEmpty(rlt))
			return null;
		
		return rlt.toArray(new BlHpChronicCheck2DTO[0]);
		
	}
	
	/**
	 * 检索sql
	 * @return
	 */
	private String getSql(String[] orIds){
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select ord.id_or, ");
		sqlSb.append("case when ord.sd_excessive_reason = '2' then 'Y' else 'N' end fg_chronic, ");
		sqlSb.append("case when (select count(1) ");
		sqlSb.append("from bl_cg_itm_oep cgitm ");
		sqlSb.append("inner join bl_st_oep stoep ");
		sqlSb.append("on stoep.id_stoep = cgitm.id_stoep ");
		sqlSb.append("where nvl(stoep.id_paypatoep, '~') <> '~' ");
		sqlSb.append("and cgitm.id_or = ord.id_or) > 0 then 'Y' else 'N' end fg_pay ");
		sqlSb.append("from ci_order ord ");
		sqlSb.append("where ");
		sqlSb.append(SqlUtils.getInSqlByBigIds("ord.id_or", orIds));
		
		return sqlSb.toString();
	}
}
