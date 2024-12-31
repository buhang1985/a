package iih.bl.cg.s.bp.newrfd;

import java.util.List;

import iih.bl.cg.dto.d.BlIpPatDTO;
import iih.bl.comm.IBlCustomFileConst;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询待退费审核患者信息
 * 
 * @author zhangxin
 * @date 2019年6月26日
 */
public class GetIpFefundAppPatListBP {
	public BlIpPatDTO[] exec(String fuzzyCond) throws DAException {
		StringBuffer sql = new StringBuffer();
		sql.append(
				"  select distinct ent.Id_Ent, b.id_bed, b.name_bed,  p.id_pat,  p.name        as name_pat,  b.code_amr_ip,   ent.dt_acpt, "
						+ "  dep1.name     name_dep_nur, dep1.id_dep   id_dep_nur,  dep2.id_dep   id_dep_phy, dep2.name     name_dep_phy ")
				.append("  from bl_rfd_itm rfd ").append(" inner join en_ent ent on ent.id_ent = rfd.id_ent ")
				.append(" inner join en_ent_ip b   on b.id_ent = ent.id_ent  ")
				.append(" inner join pi_pat p   on p.id_pat = rfd.id_pat  ")
				.append("  inner join bd_dep dep1  on ent.id_dep_nur = dep1.id_dep ")
				.append("  inner join bd_dep dep2  on ent.id_dep_phy = dep2.id_dep ")
				.append(" where  rfd.fg_active ='Y' and ent.fg_ip = 'Y' and rfd.sd_su_rdfitm='1' ").append("and ent.fg_st='N' ")
		 		.append(" and rfd.sd_rfdaptp='").append(IBlCustomFileConst.SD_NURSE_APPLY).append("' ");
		SqlParam sqlParam = new SqlParam();
		if(!fuzzyCond.equals("%%")){
			fuzzyCond = "%" + fuzzyCond.toLowerCase() + "%";
			sql.append("and (lower(b.name_bed) like ? ").append("or lower(p.name) like ? ")
					.append("or lower(p.pycode) like ?) ");
			sqlParam.addParam(fuzzyCond);
			sqlParam.addParam(fuzzyCond);
			sqlParam.addParam(fuzzyCond);
		}
		
		sql.append("order by b.name_bed");
		@SuppressWarnings("unchecked")
		List<BlIpPatDTO> entList = (List<BlIpPatDTO>) new DAFacade().execQuery(sql.toString(), sqlParam,
				new BeanListHandler(BlIpPatDTO.class));
		return entList.toArray(new BlIpPatDTO[] {});
	}
}
