package iih.pe.report.bp.qry;

import iih.pe.report.constant.PeConstant;
/**
 * 报表查询sql
 * @author 32797
 *
 */
public class SqlQryBp {
	/**
	 * 获取本次体检结果信息
	 * @return
	 */
	public String getQrySQLStrOfHisDto(String id_pepsnappt) {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" select a.ID_PEPSNAPPT as id_pepsnappt,a.DT_PE as dt_pe_0,");
		sqlStr.append("        r.ID_PESRVBCATLOG  as id_pesrvbcatlog,");
		sqlStr.append("        r.ID_PESRVITEM     as id_pesrvitem,");
		sqlStr.append("        r.ID_PERST         as id_perst,");
		sqlStr.append("        r.ID_PEDEPTSET     as id_pedeptset,");
		sqlStr.append("        d.ID_PEDEPTSET_PAR as id_pedeptset_par,");
		sqlStr.append("        d.NAME             as name_dep,");
		sqlStr.append("        c.NAME             as name_catlog,");
		sqlStr.append("        i.NAME             as name_item,");
		sqlStr.append("        a.pestatus         as peitemstatus,");
		sqlStr.append("        r.RST              as rst_0,");
		sqlStr.append("        r.des              as des,");
		sqlStr.append("        r.REF              as ref,");
		sqlStr.append("        r.UNIT             as unit,");
		sqlStr.append("        r.MARK             as mark,");
		sqlStr.append("        r.FG_ABN           as fg_abn,");
		sqlStr.append("        r.FG_POSI          as fg_posi,");
		sqlStr.append("        r.ID_DEP_NUR       as emp_nur,");
		sqlStr.append("        r.DT_NUR           as dt_nur,");
		sqlStr.append("        dep.id_pedeptset   as dep_nur,");
		sqlStr.append("        dep.id_pedeptset   as dep_doc,");
		sqlStr.append("        r.ID_EMP_DOC       as emp_doc,");
		sqlStr.append("        r.DT_DOC           as dt_doc,");
		sqlStr.append("		   rpt.name 		  as name_rptpart");
		sqlStr.append("   from PE_APT_PEPSNAPPT a");
		sqlStr.append("  inner join PE_WF_PERST r");
		sqlStr.append("     on a.ID_PEPSNAPPT = r.ID_PEPSNAPPT");
		sqlStr.append("  inner join PE_ITM_PESRVITEM i");
		sqlStr.append("     on r.ID_PESRVITEM = i.ID_PESRVITEM");
		sqlStr.append("  inner join PE_ITM_PESRVBCATLOG c");
		sqlStr.append("     on r.ID_PESRVBCATLOG = c.ID_PESRVBCATLOG");
		sqlStr.append("  inner join PE_BD_DEPTSET d");
		sqlStr.append("     on r.ID_PEDEPTSET = d.ID_PEDEPTSET");
		sqlStr.append("  inner join pe_wf_pewfdep dep");
		sqlStr.append("     on dep.id_pepsnappt = a.id_pepsnappt");
		sqlStr.append(" and c.id_pedeptset = dep.id_pedeptset");
		sqlStr.append("   inner join (select name, id_udidoc");
		sqlStr.append("                 from bd_udidoc");
		sqlStr.append("                where id_udidoclist = '@@@@BZ400000000001G2') rpt");
		sqlStr.append("      on i.id_rptpart = rpt.id_udidoc");
		if(!id_pepsnappt.equals("")){
			sqlStr.append(" where a.pestatus > " + PeConstant.PEAPPTED);
			sqlStr.append("   and a.id_pepsnappt = '" +id_pepsnappt + "'");
		}
		sqlStr.append(" order by d.SORTNO, c.SORTNO, i.SORTNO");
		return sqlStr.toString();
	}
	
	//获取前一次体检结果
	public String getQrySQLStrOfRstDtos(String id_pepsnappt) {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" select a.ID_PEPSNAPPT,a.DT_PE,");
		sqlStr.append("   r.ID_PESRVBCATLOG, r.ID_PESRVITEM, r.ID_PERST, r.ID_PEDEPTSET, ");
		sqlStr.append("   case when dep.depst = 0 then d.name || '[未做]' else d.name end name_dep, dep.depst, c.NAME as name_catlog, i.NAME as name_item, ");
		sqlStr.append("   c.NAME, c.ENAME, c.NAME_SHORT, c.catlog,");
		sqlStr.append("   case when peitemstatus = 1 then r.RST else '-' end as rst, ");
		sqlStr.append("   r.UNIT, r.REF, r.MARK, r.FG_ABN, r.FG_POSI, r.DES, ");
		sqlStr.append("   r.ID_DEP_NUR as emp_nur, r.DT_NUR, ");
		sqlStr.append("   r.ID_EMP_DOC as emp_doc, r.DT_DOC, ");
		sqlStr.append("   i.id_ruleref, i.id_rulelegal ");
		sqlStr.append(" from PE_APT_PEPSNAPPT a inner join PE_WF_PERST r on a.ID_PEPSNAPPT = r.ID_PEPSNAPPT");
		sqlStr.append("   inner join PE_ITM_PESRVITEM i on r.ID_PESRVITEM = i.ID_PESRVITEM");
		sqlStr.append("   inner join PE_ITM_PESRVBCATLOG c on r.ID_PESRVBCATLOG = c.ID_PESRVBCATLOG");
		sqlStr.append("   inner join PE_BD_DEPTSET d on r.ID_PEDEPTSET = d.ID_PEDEPTSET");
		sqlStr.append("   inner join PE_WF_PEWFDEP dep on r.ID_PEPSNAPPT = dep.ID_PEPSNAPPT and r.ID_PEDEPTSET = dep.ID_PEDEPTSET");
				
		if(!id_pepsnappt.equals("")){
			sqlStr.append(" where a.pestatus > " + PeConstant.PEAPPT);
			sqlStr.append("   and a.id_pepsnappt = '" + id_pepsnappt + "'");
		}else{
			sqlStr.append(" where 0 = 1 ");
		}
		sqlStr.append(" order by d.SORTNO, c.SORTNO, i.SORTNO");
		return sqlStr.toString();
	}

	public String getQrySQLStrOfPsnAppt(String id_pepsnappt) {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("select apt.id_pepsnbinfo, apt.id_en, apt.id_registrar, apt.pe_times,");
		sqlStr.append("apt.fg_petp, apt.apttp, apt.card_pe, apt.dt_pe");
		sqlStr.append("  from pe_apt_pepsnappt apt");
		sqlStr.append(" where apt.id_pepsnappt = '" + id_pepsnappt + "'");
		return sqlStr.toString();
	}

	public String getQrySQLStrOfPsnAppt(String id_pepsnbinfo, String id_pepsnappt, String dt_pe) {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("select * from");
		sqlStr.append(" (select apt.id_pepsnbinfo");
		sqlStr.append(" from pe_apt_pepsnappt apt");
		sqlStr.append(" where apt.id_pepsnbinfo = '" + id_pepsnbinfo + "'");
		sqlStr.append(" and apt.id_pepsnappt <> '" + id_pepsnappt + "'");
		sqlStr.append(" and apt.dt_pe <= '" + dt_pe + "'");
		sqlStr.append(" order by dt_pe desc) a");
		sqlStr.append(" where rownum <= 2");
		return sqlStr.toString();
	}

	//获取前两次体检结果信息
	

}
