package iih.bd.srv.medsrv.refs.sql;

import java.util.List;

import iih.bd.bc.udi.pub.IBdSrvDictCodeTypeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.utils.BdEnvContextUtil;

public class OrMedSrvOrderNameLength extends OrMedSrvOrderBase {
	protected String getQueryColumn() {
		StringBuffer sb = new StringBuffer("select");
		sb.append(
				" distinct Name_srv_desc,name_srvtp, des_pri, case when des is not null and (c1Des is not null or bdSrvDes is not null) and sup_name is not null then des ||','||sup_name else des||sup_name end as des, sd_hpsrvtp,Id_hpsrvtp , hp_des, Code_hpsrvorca,IdSrvIdMm, id_Srv, Id_mm, sd_srvtp,code,name,'' as wordfreq,wbcode,pycode");
		sb.append(" from ( ");
		;
		return sb.toString();
	}
	@Override
	public String getMySqlStr(String code_entp, String id_hp, String inputstr,
			String id_pripat,List<String> whereList) {
		StringBuilder formatsql = new StringBuilder();
		//这个参照医保的过滤条件包括
		//1、bd_hp_srvorca的id_hp,医保计划
		//2、bd_hp_srvorca的dt_b,dt_e
		//3、eu_status的等于4，4应该就是已对照的标识
		formatsql.append(super.getMySqlStr(code_entp, id_hp, inputstr, id_pripat, whereList))
				.append(" select bd_srv_comp.pycode,bd_srv_comp.wbcode, bd_srv_comp.Name || (case when bd_srv_comp.fg_mm='Y' and bd_srv_comp.fg_ctm !='Y'  then '[' || (case when bd_srv_comp.Name=A1.Name then '' else A1.Name || '，' end) || A1.Spec || ']' else '' end) as Name_srv_desc,")
				.append(" D.ctrl2 as name_srvtp,")
				.append(" (case when bd_srv_comp.Fg_Mm='Y' and bd_srv_comp.fg_ctm !='Y' then to_char(A1.Price,'fm9999999990.00') || ''  else to_char(bd_srv_comp.price_ratio,'fm9999999990.00') || ''  end) as des_pri,")
				// 拼接描述，如果是费用项目拼接医保目录类型，医保目录描述，服务描述，否则只显示服务的描述
				.append(" case when bd_srv_comp.fg_bl ='Y' then ")
				.append(" (case when c1.name is null or ( C.Dt_e is not null and sysdate>to_date(C.Dt_e,'yyyy-MM-dd hh24:mi:ss')) or ( C.Dt_b is not null and sysdate<to_date(C.Dt_b,'yyyy-MM-dd hh24:mi:ss'))  then '【丙类】' else '【'||c1.name||'】' end) ||  c1.Des || (case when c1.Des is null then bd_srv_comp.Des else '，'||bd_srv_comp.Des end) ||(case when b.name  is  null then '' else ' ('||b.name||') ' end )")
				.append(" else  bd_srv_comp.des end as des ,")
				.append(" A1.sup_name,")
				.append(" c1.Des as c1Des,bd_srv_comp.des bdSrvDes,")
				//.append(" (case when c1.name is null and bd_srv_comp.fg_bl ='Y' then '丙类' else c1.name end) || (case when (case when c1.name is null and bd_srv_comp.fg_bl ='Y' then '丙类' else c1.name end) is not null and c1.Des is not null then '，'||c1.Des when c1.Des is not null then c1.Des else '' end) || (case when bd_srv_comp.Des is not null and (c1.Des is not null or (case when c1.name is null and bd_srv_comp.fg_bl ='Y' then '丙类' else c1.name end) is not null) then '，'||bd_srv_comp.Des when bd_srv_comp.des is not null then  bd_srv_comp.des else '' end) as des, ")
				
				.append(" bd_srv_comp.name, bd_srv_comp.code,bd_srv_comp.Id_Srv ,bd_srv_comp.Sd_Srvtp , A1.id_mm,A1.name as name_mm, C.Sd_Hpsrvtp,C.Id_hpsrvtp,C.Des as hp_des,(bd_srv_comp.id_srv||'-' || A1.id_mm) as IDSRVIDMM,C.code as code_hpsrvorca,srvca.fullName as fullName  ")
				.append(" from (")
				.append(getSrvMmSql(code_entp,id_pripat,whereList))
				.append(" ) bd_srv_comp ")
				.append(" left outer join bd_mm A1 ON A1.Id_Srv=bd_srv_comp.Id_Srv  and A1.fg_active='Y' and A1.Ds=0 and A1.Fg_Out='N' ")
				.append(" left join (select id_mm, sum(quan_usable) quan_usable  from (")
				.append(" select bl.id_mm, quan_usable FROM mm_bl bl inner join (select id_wh from bd_wh where "+getIdWh()+") wh ")
				.append(" on bl.id_wh=wh.id_wh inner join BD_MM_WH mmwh ON bl.id_wh = mmwh.id_wh AND mmwh.id_mm = bl.id_mm")
				.append(" WHERE MMWH.FG_ACTIVE = 'Y' AND mmwh.fg_out  = 'N' and bl.quan_usable > 0 ) group by id_mm ) mmbl")
				.append(" on mmbl.id_mm = A1.id_mm ")
				.append(" and bd_srv_comp." + getFgUseFld(code_entp))
				.append(" left join bd_udidoc b on b.id_udidoc = A1.id_abrd  left outer join bd_hp_srvorca C ON bd_srv_comp.ID_SRV=C.Id_Srv")
				.append((id_hp != null && id_hp != "") ? " and C.Id_Hp='" + id_hp + "'" : "")
				.append(" and ((bd_srv_comp.fg_mm='Y' and A1.Id_Mm=c.id_mm) or bd_srv_comp.fg_mm='N')")
				.append(" left outer join bd_udidoc C1 ON C1.Id_Udidoc=C.Id_Hpsrvtp")
				.append(" left outer join bd_udidoc D ON D.Id_udidoclist='" + IBdSrvDictCodeTypeConst.ID_SRVTP
						+ "' and D.code = bd_srv_comp.sd_srvtp_udidoc  LEFT OUTER JOIN bd_srvca srvca  ON srvca.id_srvca     = bd_srv_comp.id_srvca"
						+ " where (A1.fg_active is null or A1.fg_active = 'Y')"
						+ " and (bd_srv_comp.fg_mm ='N' or bd_srv_comp.fg_ctm ='Y' or nvl(mmbl.quan_usable,0) >0 ) ) t");
				formatsql.append(" order by length(t.pycode) asc,t.pycode");
		return formatsql.toString();
	}

	@Override
	public String getSrvMmSql(String code_entp, String id_pripat,List<String> whereList) {
		String orgsql=BdEnvContextUtil.processEnvContext(new MedSrvDO(), "a0");
		String whereStr = "";
		for (String part : whereList) {
			whereStr += " and " + part;
		}
	
		StringBuilder formatsql = new StringBuilder("select * from (");
		formatsql.append(" select a0.*,BDSRVPRICE.price_ratio,")
		.append(" decode(substr(sd_srvtp,1,2),'01',substr(sd_srvtp,1,4),'14',substr(sd_srvtp,1,4),substr(sd_srvtp,1,2)) as sd_srvtp_udidoc, ") // 获取服务的显示名称01,14取4位，其余取两位
		.append(" bd_srv_drug.id_dosage,bd_srv_drug.id_srvdrug")
		.append(" from bd_srv a0 left join view_price_rp BDSRVPRICE on a0.id_srv=BDSRVPRICE.id_srv  and BDSRVPRICE.id_pripat= '" + id_pripat + "'")
		//.append(" from bd_srv a0 left join bd_srv_price on a0.id_srv=bd_srv_price.id_srv and bd_srv_price.id_pripat= '" + id_pripat + "'")
		.append(" left join bd_srv_drug on a0.id_srv = bd_srv_drug.id_srv ")
		.append(" left join bd_mm mm on mm.id_srv = a0.id_srv ")
		.append(" where a0.Fg_Or = 'Y' and a0.Fg_Active = 'Y' and a0.ds = 0 ")
		.append(" and a0." + getFgUseFld(code_entp)) // 获取可使用标识 
		.append(" and ").append(orgsql)
		.append( whereStr)
		.append(" order by length(a0.pycode) asc,a0.pycode")
		.append(" ) where rownum <= "+this.getRowsCount());
		return formatsql.toString();
	}
	protected String getIdWh(){
		return " fg_use_op='Y' or fg_use_er='Y' ";
	}
}
