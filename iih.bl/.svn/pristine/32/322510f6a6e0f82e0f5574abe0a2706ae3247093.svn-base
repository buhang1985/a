package iih.bl.cg.bp.ip;

import java.util.List;

import iih.bl.cg.dto.d.BlIpPatDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取出院患者列表(用于护士站床旁结算节点)
 * @author shaokx 2020.05.11
 *
 */
public class GetIpPatListOutHosBP {

	/**
	 * 获取出院患者列表
	 * @param depId
	 * @param fuzzyCond
	 * @return
	 * @throws BizException
	 */
	public BlIpPatDTO[] exec(String depId,String fuzzyCond,String dt_b,String dt_e) throws BizException{
		StringBuilder sql = new StringBuilder();
		sql.append(" select nvl(st.status,'未结算') fg_pay,");
		sql.append(" ent.id_ent, ");
		sql.append(" ent.code code_ent, ");
		sql.append(" entip.name_bed, ");
		sql.append(" pat.id_pat, ");
		sql.append(" pat.name name_pat, ");
		sql.append(" pat.code code_pat, ");
		sql.append(" entip.code_amr_ip, ");
		sql.append(" entip.dt_disc dt_end, ");
		sql.append(" outnur.id_dep id_dep_nurout, ");
		sql.append(" outnur.name name_dep_nurout, ");
		sql.append(" outphy.id_dep id_dep_phyout, ");
		sql.append(" outphy.name name_dep_phyout ");
		sql.append(" from en_ent ent ");
		sql.append(" inner join en_ent_ip entip on ent.id_ent = entip.id_ent ");
		sql.append(" inner join pi_pat pat on ent.id_pat = pat.id_pat ");
		sql.append(" left join bd_dep outnur on entip.id_dep_nurdisc = outnur.id_dep ");
		sql.append(" left join bd_dep outphy on entip.id_dep_phydisc = outphy.id_dep ");
		sql.append(" left join ( ");
		sql.append(" select distinct cgip.id_ent,'未结算' status from bl_cg_ip cgip where cgip.fg_st = 'N' and cgip.eu_direct = 1 ");
		sql.append(" union all ");
		sql.append(" select stip.id_ent,'已结算未付款' status from bl_st_ip stip where stip.fg_pay = 'N' ");
		sql.append(" union all ");
		sql.append(" select distinct stip2.id_ent,'已付款' status from bl_st_ip stip2 where stip2.fg_pay = 'Y' and stip2.eu_direct = 1 and stip2.fg_canc = 'N' ");
		sql.append("  )st on st.id_ent = ent.id_ent ");
		sql.append(" where ent.code_entp in ('10', '11') ");
		sql.append(" and entip.sd_status = '28' ");//表示患者出院
		sql.append(" and entip.id_dep_nurdisc = ? ");
		
		if(!StringUtil.isEmpty(fuzzyCond)){
			sql.append(" and (lower(entip.name_bed) like ? or lower(pat.name) like ? or lower(pat.pycode) like ?) ");
		}
		
		if(!StringUtil.isEmpty(dt_b)){
			sql.append(" and entip.dt_disc >= ?");
		}
		
		if(!StringUtil.isEmpty(dt_e)){
			sql.append(" and entip.dt_disc <= ?");
		}
		
		sql.append(" order by entip.name_bed ");

		SqlParam param = new SqlParam();
		param.addParam(depId);
		
		if(!StringUtil.isEmpty(fuzzyCond)){
			param.addParam(fuzzyCond);
			param.addParam(fuzzyCond);
			param.addParam(fuzzyCond);
		}
		
		if(!StringUtil.isEmpty(dt_b)){
			param.addParam(dt_b);
		}
		
		if(!StringUtil.isEmpty(dt_e)){
			param.addParam(dt_e);
		}
		
		List<BlIpPatDTO> outPatList = (List<BlIpPatDTO>)new DAFacade().execQuery(sql.toString(), param, new BeanListHandler(BlIpPatDTO.class));
		
		return outPatList.toArray(new BlIpPatDTO[]{});
	}
	
}
