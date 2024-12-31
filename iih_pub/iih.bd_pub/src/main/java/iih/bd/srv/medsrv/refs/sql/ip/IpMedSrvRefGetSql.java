package iih.bd.srv.medsrv.refs.sql.ip;

import java.util.List;

import com.mysql.jdbc.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeTypeConst;
import iih.bd.srv.medsrv.refs.sql.OrMedSrvOrderNameLength;

public class IpMedSrvRefGetSql extends OrMedSrvOrderNameLength{
	private String sd_herbpreparationtp;
	public void setSd_herbpreparationtp(String sd_herbpreparationtp) {
		this.sd_herbpreparationtp = sd_herbpreparationtp;
	}
	protected String getQueryColumn() {
		StringBuffer sb = new StringBuffer("select");
		sb.append(
				" distinct Name_srv_desc, Name_unit_sale,des_pri, des || case when drugrange is not null then ' ('||drugrange||') ' else '' end || case when abrd_name is not null then ' ('||abrd_name||') ' else '' end ||sup_name as des,id_Srv, Id_mm, sd_srvtp,id_srvtp,fg_ctm,id_unit_med,quan_med,pycode,IdSrvIdMm,name,id_unit_sale");
		sb.append(" from ( ");
		;
		return sb.toString();
	}
	@Override
	public String getMySqlStr(String code_entp, String id_hp, String inputstr,
			String id_pripat,List<String> whereList) {
		String MMGroupCodeParam = DrugCheckDisplayMd4IP.getInstance().getDrugGroupParam();
		if("11".equals(DrugCheckDisplayMd4IP.getInstance().getDrugCheckDisplayMd4IP())){
			return getPkgModel(code_entp, id_hp, inputstr,id_pripat, whereList, MMGroupCodeParam);
		}else{
			return getDrugModel(code_entp, id_hp, inputstr,id_pripat, whereList, MMGroupCodeParam);
		}
	} 
	/**
	 * 商品模式
	 * @param code_entp
	 * @param id_hp
	 * @param inputstr
	 * @param id_pripat
	 * @param whereList
	 * @return
	 */
	public String getDrugModel(String code_entp, String id_hp, String inputstr,
			String id_pripat,List<String> whereList,String mmGroupCodeString){
		StringBuilder formatsql = new StringBuilder();
		formatsql.append(getQueryColumn())
				.append(" select bd_srv_comp.pycode,")
				.append(" bd_srv_comp.Name || (case when bd_srv_comp.fg_mm='Y' and bd_srv_comp.fg_ctm !='Y'  then '[' || (case when bd_srv_comp.Name=A1.Name then '' else A1.Name || '，' end) || A1.Spec || ']' || '   ('||b.name||')' else '' end) as Name_srv_desc,")
				.append(" (case when bd_srv_comp.Fg_Mm='Y' and bd_srv_comp.fg_ctm !='Y' then to_char(A1.Price,'fm9999999990.00') || ''  else to_char(bd_srv_comp.price_ratio,'fm9999999990.00') || ''  end) as des_pri,")
				// 拼接描述，如果是费用项目拼接医保目录类型，医保目录描述，服务描述，否则只显示服务的描述
				.append(" case when bd_srv_comp.fg_bl ='Y' then ")
				.append(" (case when c1.name is null or ( C.Dt_e is not null and sysdate>to_date(C.Dt_e,'yyyy-MM-dd hh24:mi:ss')) or ( C.Dt_b is not null and sysdate<to_date(C.Dt_b,'yyyy-MM-dd hh24:mi:ss'))  then '丙类' else c1.name end) || (case when  c1.Des is null then '' else '，' ||  c1.Des end ) || (case when bd_srv_comp.Des is null then '' else '，'||bd_srv_comp.Des end)")
				.append(" else  bd_srv_comp.des end as des ,")
				.append(" bd_srv_comp.name,")
				.append(" bd_srv_comp.Id_Srv,")
				.append(" bd_srv_comp.Sd_Srvtp,")
				.append(" D.name as name_srvtp,")
				.append(" srvca.name as fullName,")
				.append(" b.name as abrd_name, basedrugrange.name  as drugrange, ")
				.append(" A1.id_mm,")
				.append(" A1.SUP_NAME,")
				.append(" A1.name as name_mm,")
			    .append(" bd_srv_comp.id_unit_med,")
			    .append(" bd_srv_comp.quan_med,")
			    .append(" bd_srv_comp.id_srvtp,")
			    .append(" bd_srv_comp.fg_ctm,")
			    .append(" C.Des as hp_des,(bd_srv_comp.id_srv||'-' || A1.id_mm) as IDSRVIDMM,")
			    .append(" '' as id_unit_sale,'' as name_unit_sale")
				.append(" from (")
				.append(getSrvMmSql(code_entp,id_pripat,whereList))
				.append(" ) bd_srv_comp ")
				.append(" left outer join bd_mm A1 ON A1.Id_Srv=bd_srv_comp.Id_Srv and A1.fg_active='Y' and A1.fg_out='N' and A1.ds=0")
				.append(" and bd_srv_comp." + getFgUseFld(code_entp))
				.append(" left join (select id_mm, sum(quan_usable) quan_usable  from (")
				.append(" select bl.id_mm, quan_usable FROM mm_bl bl inner join (select id_wh from bd_wh where fg_use_ip='Y') wh ")
				.append(" on bl.id_wh=wh.id_wh inner join BD_MM_WH mmwh ON bl.id_wh = mmwh.id_wh AND mmwh.id_mm = bl.id_mm")
				.append(" WHERE MMWH.FG_ACTIVE = 'Y' AND mmwh.fg_out  = 'N' and bl.quan_usable > 0 ) group by id_mm ) mmbl")
				.append(" on mmbl.id_mm = A1.id_mm  left join bd_udidoc basedrugrange on basedrugrange.id_udidoc = A1.id_basedrugrange  left join bd_udidoc b on b.id_udidoc = A1.id_abrd ")
				.append(" left outer join bd_hp_srvorca C ON bd_srv_comp.ID_SRV=C.Id_Srv")
				.append((id_hp != null && id_hp != "") ? " and C.Id_Hp='" + id_hp + "'" : "")
				.append(" and ((bd_srv_comp.fg_mm='Y' and A1.Id_Mm=c.id_mm) or bd_srv_comp.fg_mm='N')")
				.append(" left outer join bd_udidoc C1 ON C1.Id_Udidoc=C.Id_Hpsrvtp")
				.append(" left outer join bd_udidoc D ON D.Id_udidoclist='" + IBdSrvDictCodeTypeConst.ID_SRVTP+"' and D.code = bd_srv_comp.sd_srvtp_udidoc ")
				.append(" left join bd_srvca srvca on srvca.id_srvca = bd_srv_comp.id_srvca")
				.append(" where (A1.fg_active is null or A1.fg_active = 'Y')");
				if(!StringUtils.isNullOrEmpty(sd_herbpreparationtp)){
					formatsql.append(String.format(" and (nvl(A1.sd_herbpreparationtp,'~')='~' or A1.sd_herbpreparationtp = '%s')",this.sd_herbpreparationtp));
				}
				formatsql.append(" and (bd_srv_comp.fg_mm ='N' or bd_srv_comp.fg_ctm ='Y' or nvl(mmbl.quan_usable,0) >0 ) ) t");
				formatsql.append(" order by length(t.pycode) asc,t.pycode");
		return formatsql.toString();
	}
	/**
	 * 大小包装模式
	 * @param code_entp
	 * @param id_hp
	 * @param inputstr
	 * @param id_pripat
	 * @param whereList
	 * @return
	 */
	private String getPkgModel(String code_entp, String id_hp, String inputstr,
			String id_pripat,List<String> whereList,String mmGroupCodeString){
		StringBuilder formatsql = new StringBuilder();
		formatsql.append(getQueryColumn())
				.append(" select bd_srv_comp.pycode,")
				.append(" bd_srv_comp.Name || (case when bd_srv_comp.fg_mm='Y' and bd_srv_comp.fg_ctm !='Y'  then '[' || (case when bd_srv_comp.Name=A1.Name then '' else A1.Name || '，' end) || A1.Spec || ']' || '   ('||b.name||')' else '' end) as Name_srv_desc,")
				.append(" (case when bd_srv_comp.Fg_Mm='Y' and bd_srv_comp.fg_ctm !='Y' then to_char(vbmip.price_pkg,'fm9999999990.00') || ''  else to_char(bd_srv_comp.price_ratio,'fm9999999990.00') || ''  end) as des_pri,")
				// 拼接描述，如果是费用项目拼接医保目录类型，医保目录描述，服务描述，否则只显示服务的描述
				.append(" case when bd_srv_comp.fg_bl ='Y' then ")
				.append(" (case when c1.name is null or ( C.Dt_e is not null and sysdate>to_date(C.Dt_e,'yyyy-MM-dd hh24:mi:ss')) or ( C.Dt_b is not null and sysdate<to_date(C.Dt_b,'yyyy-MM-dd hh24:mi:ss'))  then '丙类' else c1.name end) || (case when  c1.Des is null then '' else '，' ||  c1.Des end ) || (case when bd_srv_comp.Des is null then '' else '，'||bd_srv_comp.Des end)")
				.append(" else  bd_srv_comp.des end as des ,")
				.append(" bd_srv_comp.name,")
				.append(" bd_srv_comp.Id_Srv,")
				.append(" bd_srv_comp.Sd_Srvtp,")
				.append(" D.name as name_srvtp,")
				.append(" srvca.name as fullName,")
				.append(" b.name as abrd_name, basedrugrange.name AS drugrange,")
				.append(" A1.id_mm,")
				.append(" A1.SUP_NAME,")
				.append(" A1.name as name_mm,")
			    .append(" bd_srv_comp.id_unit_med,")
			    .append(" bd_srv_comp.quan_med,")
			    .append(" bd_srv_comp.id_srvtp,")
			    .append(" bd_srv_comp.fg_ctm,")
			    .append(" C.Des as hp_des,(bd_srv_comp.id_srv||'-' || A1.id_mm) as IDSRVIDMM,")
			    .append(" vbmip.id_ap_unit as id_unit_sale,vbmip.appkgname as name_unit_sale")
				.append(" from (")
				.append(getSrvMmSql(code_entp,id_pripat,whereList))
				.append(" ) bd_srv_comp ")
				.append(" left outer join bd_mm A1 ON A1.Id_Srv=bd_srv_comp.Id_Srv and A1.fg_active='Y' and A1.fg_out='N' and A1.ds=0")
				.append(" and bd_srv_comp." + getFgUseFld(code_entp))
				.append(" left join (select id_mm, sum(quan_usable) quan_usable  from (")
				.append(" select bl.id_mm, quan_usable FROM mm_bl bl inner join (select id_wh from bd_wh where fg_use_ip='Y') wh ")
				.append(" on bl.id_wh=wh.id_wh inner join BD_MM_WH mmwh ON bl.id_wh = mmwh.id_wh AND mmwh.id_mm = bl.id_mm")
				.append(" WHERE MMWH.FG_ACTIVE = 'Y' AND mmwh.fg_out  = 'N' and bl.quan_usable > 0 ) group by id_mm ) mmbl")
				.append(" on mmbl.id_mm = A1.id_mm left join bd_udidoc basedrugrange on basedrugrange.id_udidoc = A1.id_basedrugrange   left join bd_udidoc b on b.id_udidoc = A1.id_abrd ")
				.append(" left outer join bd_hp_srvorca C ON bd_srv_comp.ID_SRV=C.Id_Srv")
				.append((id_hp != null && id_hp != "") ? " and C.Id_Hp='" + id_hp + "'" : "")
				.append(" and ((bd_srv_comp.fg_mm='Y' and A1.Id_Mm=c.id_mm) or bd_srv_comp.fg_mm='N')")
				.append(" left outer join bd_udidoc C1 ON C1.Id_Udidoc=C.Id_Hpsrvtp")
				.append(" left outer join bd_udidoc D ON D.Id_udidoclist='" + IBdSrvDictCodeTypeConst.ID_SRVTP+"' and D.code = bd_srv_comp.sd_srvtp_udidoc ")
				.append(" left join bd_udidoc basedrugrange on basedrugrange.id_udidoc = A1.id_basedrugrange left join bd_udidoc b on b.id_udidoc = A1.id_abrd")
				.append(" left join V_BD_MM_IP_PKG vbmip on vbmip.id_mm = A1.id_mm")
				.append(" left join bd_srvca srvca on srvca.id_srvca = bd_srv_comp.id_srvca")
				.append(" where (A1.fg_active is null or A1.fg_active = 'Y')");
				if(!StringUtils.isNullOrEmpty(sd_herbpreparationtp)){
					formatsql.append(String.format(" and (nvl(A1.sd_herbpreparationtp,'~')='~' or A1.sd_herbpreparationtp = '%s')",this.sd_herbpreparationtp));
				}
				formatsql.append(" and (bd_srv_comp.fg_mm ='N' or bd_srv_comp.fg_ctm ='Y' or nvl(mmbl.quan_usable,0) >0 ) ) t");
				formatsql.append(" order by length(t.pycode) asc,t.pycode");
		return formatsql.toString();
		
		  
	}
}
