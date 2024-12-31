package iih.ci.mrm.bp;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import iih.ci.mrm.CiMrmPerformanceDTO;

public class getmzlistbp {

	public List<CiMrmPerformanceDTO> getmzlist(String id_pat,String name_pat,String id_emp_phy,String id_dep_phy, String dt_acpt,String dt_end,String performance)throws Exception{
		
		getpatlistbp lsitbp = new getpatlistbp();
		StringBuilder sb = new StringBuilder();
		sb.append(" where cm.code_entp = '00' ");
		if(StringUtils.isNotBlank(name_pat)){
			sb.append(" and ee.name_pat like '%");
			sb.append(name_pat);
			sb.append("%' ");
		}
		if(StringUtils.isNotBlank(id_emp_phy)){
			sb.append(" and ee.id_emp_phy = '"+id_emp_phy+"' ");
		}
		if(StringUtils.isNotBlank(id_dep_phy)){
			sb.append(" and ee.id_dep_phy = '"+id_dep_phy+"' ");
		}
		if(StringUtils.isNotBlank(dt_acpt)){
			sb.append(" and ee.dt_acpt >= '"+dt_acpt+"' ");
		}
		if(StringUtils.isNotBlank(dt_end)){
			sb.append(" and ee.dt_acpt <= '"+dt_end+"' ");
		}
		if(StringUtils.isNotBlank(id_pat)){
			sb.append(" and ee.id_pat = '"+id_pat+"' ");
		}
		StringBuilder sql = new StringBuilder();
		sql.append(" select JS.name_dep_phy as name_dep_phy,  ");
		sql.append(" JS.dt_acpt as dt_acpt, ");
		sql.append(" JS.id_pat as id_pat, ");
		sql.append(" JS.name_pat as name_pat, ");
		sql.append(" JS.id_emp_phy as id_emp_phy, ");
		sql.append(" JS.id_mr as id_mr, ");
		sql.append(" JS.age as age, ");
		sql.append(" JS.sd_sex_pat  as sd_sex_pat, ");
		sql.append(" KS.主诉 as Main_suit, ");
		sql.append(" KS.体格检查 as Health_checkup, ");
		sql.append(" KS.现病史 as Present_illness, ");
		sql.append(" KS.既往史 as Previous, ");
		sql.append("  KS.完成情况  as Performance");
		sql.append(" from (select cm.name, ");
		sql.append(" bdd.name    as name_dep_phy, ");
		sql.append(" ee.id_ent, ");
		sql.append(" ee.dt_acpt  as dt_acpt, ");
		sql.append(" ee.id_pat, ");
		sql.append(" ee.name_pat, ");
		sql.append(" bdp.name    as id_emp_phy, ");
		sql.append(" cm.id_mr    as id_mr, ");
		sql.append(" ca.pat_age  as age, ");
		sql.append(" bdu.name    as sd_sex_pat ");
		sql.append(" from ci_mr cm ");
		sql.append(" left join en_ent ee ");
		sql.append(" on cm.id_ent = ee.id_ent ");
		sql.append(" left join bd_dep bdd ");
		sql.append(" on ee.id_dep_phy = bdd.id_dep ");
		sql.append(" left join bd_psndoc bdp ");
		sql.append(" on ee.id_emp_phy = bdp.id_psndoc ");
		sql.append(" left join bd_udidoc bdu ");
		sql.append(" on ee.id_sex_pat = bdu.id_udidoc ");
		sql.append(" left join ci_amr ca ");
		sql.append(" on cm.id_ent = ca.id_ent ");
		sql.append(sb);
		sql.append(") JS,");
		sql.append(" (select id_mr, ");
		sql.append(" id_Ent, ");
		sql.append(" (case ");
		sql.append(" when s is null then ");
		sql.append(" '无' ");
		sql.append(" else ");
		sql.append(" '有' ");
		sql.append(" end) 主诉, ");
		sql.append(" (case ");
		sql.append(" when s1 is null then ");
		sql.append(" '无' ");
		sql.append(" else ");
		sql.append(" '有' ");
		sql.append(" end) 体格检查, ");
		sql.append(" (case ");
		sql.append(" when s3 is null then ");
		sql.append(" '无' ");
		sql.append(" else ");
		sql.append(" '有' ");
		sql.append(" end) 现病史, ");
		sql.append(" (case ");
		sql.append(" when s4 is null then ");
		sql.append(" '无' ");
		sql.append(" else ");
		sql.append(" '有' ");
		sql.append(" end) 既往史, ");
		sql.append(" (case ");
		sql.append(" when (s is null and s1 is null and s3 is null and s4 is null) then ");
		sql.append(" '未完成' ");
		sql.append(" when (s <> null and s1 <> null and s3 <> null and s4 <> null) then ");
		sql.append(" '完成' ");
		sql.append(" else ");
		sql.append(" '不完善' ");
		sql.append(" end) 完成情况 ");
		sql.append(" from (select mr.name, ");
		sql.append(" mr.id_mr, ");
		sql.append(" mr.id_ent, ");
		sql.append(" (select refs.code_element ");
		sql.append(" from ci_mr_doc_reference_value refs ");
		sql.append(" where refs.id_mr = mr.id_mr ");
		sql.append(" and refs.code_element = 'S.01') s, ");
		sql.append(" (select refs.code_element ");
		sql.append(" from ci_mr_doc_reference_value refs ");
		sql.append(" where refs.id_mr = mr.id_mr ");
		sql.append(" and refs.code_element = 'S.02') s1, ");
		sql.append(" (select refs.code_element ");
		sql.append(" from ci_mr_doc_reference_value refs ");
		sql.append(" where refs.id_mr = mr.id_mr ");
		sql.append(" and refs.code_element = 'S.03') s3, ");
		sql.append(" (select refs.code_element ");
		sql.append(" from ci_mr_doc_reference_value refs ");
		sql.append(" where refs.id_mr = mr.id_mr ");
		sql.append(" and refs.code_element = 'S.04') s4 ");
		sql.append(" from ci_mr mr)) KS ");
		sql.append(" where JS.id_mr = KS.id_mr; ");
		
		//sql.append(" order by bdd.name asc , ee.dt_acpt desc ");
		return lsitbp.getpatlist(sql.toString(),performance);
	}
}
