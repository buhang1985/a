package iih.bl.hp.s.bp;

import java.util.List;

import iih.bd.base.utils.SqlUtils;
import iih.bl.hp.dto.chronic.d.BlHpChronicCheckDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 
 * 慢性病处方校验
 * @author ly 2018/10/25
 *
 */
public class BlHpCheckChronicPresBP {
	
	/**
	 * 校验慢性病处方
	 * @param presIds
	 * @return 校验结果
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public BlHpChronicCheckDTO[] exec(String[] presIds) throws BizException{
		
		if(ArrayUtil.isEmpty(presIds))
			return null;
		
		String sql = this.getSql(presIds);
		DAFacade daf = new DAFacade();
		List<BlHpChronicCheckDTO> rlt = (List<BlHpChronicCheckDTO>) daf
				.execQuery(sql, new BeanListHandler(BlHpChronicCheckDTO.class));		
		
		if(ListUtil.isEmpty(rlt))
			return null;
		
		return rlt.toArray(new BlHpChronicCheckDTO[0]);
	}
	
	/**
	 * 检索sql
	 * @return
	 */
	private String getSql(String[] presIds){
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select pres.id_pres, ");
		sqlSb.append("case when (select count(1) ");
		sqlSb.append("from ci_or_srv orsrv ");
		sqlSb.append("inner join ci_order ord ");
		sqlSb.append("on orsrv.id_or = ord.id_or ");
		sqlSb.append("where ord.sd_excessive_reason = '2' ");
		sqlSb.append("and orsrv.id_pres = pres.id_pres) > 0 then 'Y' else 'N' end fg_chronic, ");
		sqlSb.append("case when (select count(1) ");
		sqlSb.append("from bl_cg_itm_oep cgitm ");
		sqlSb.append("inner join bl_st_oep stoep ");
		sqlSb.append("on stoep.id_stoep = cgitm.id_stoep ");
		sqlSb.append("where nvl(stoep.id_paypatoep, '~') <> '~' ");
		sqlSb.append("and cgitm.id_pres = pres.id_pres) > 0 then 'Y' else 'N' end fg_pay ");
		sqlSb.append("from ci_pres pres ");
		sqlSb.append("where ");
		sqlSb.append(SqlUtils.getInSqlByBigIds("pres.id_pres", presIds));
		
		return sqlSb.toString();
	}
}
