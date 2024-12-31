package iih.bd.srv.medsrv.refs.sql;

import java.util.List;

import iih.bd.bc.udi.pub.IBdSrvDictCodeTypeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.mw.core.data.Context;

public class OrMedSrvOrderWordFreq extends OrMedSrvOrderBase {

	@Override
	public String getMySqlStr(String code_entp, String id_hp, String inputstr,
			String id_pripat,List<String> whereList) {
		StringBuilder formatsql = new StringBuilder();
		formatsql.append(super.getMySqlStr(code_entp, id_hp, inputstr, id_pripat, whereList));
		formatsql
				.append(" select bd_srv_comp.pycode,bd_srv_comp.wbcode,bd_srv_comp.wordfreq, bd_srv_comp.Name || (case when bd_srv_comp.fg_mm='Y' and bd_srv_comp.fg_ctm !='Y'  then '[' || (case when bd_srv_comp.Name=A1.Name then '' else A1.Name || '，' end) || A1.Spec || ']' else '' end) as Name_srv_desc,")
				.append(" D.ctrl2 as name_srvtp,")
				.append(" (case when bd_srv_comp.Fg_Mm='Y' and bd_srv_comp.fg_ctm !='Y' then to_char(A1.Price,'fm9999999990.00') || ''  else to_char(bd_srv_comp.price_ratio,'fm9999999990.00') || ''  end) as des_pri,")
				// 拼接描述，如果是费用项目拼接医保目录类型，医保目录描述，服务描述，否则只显示服务的描述
				.append(" case when bd_srv_comp.fg_bl ='Y' then ")
				.append(" (case when c1.name is null or eu_status != 4 or ( C.Dt_e is not null and sysdate>to_date(C.Dt_e,'yyyy-MM-dd hh24:mi:ss')) or ( C.Dt_b is not null and sysdate<to_date(C.Dt_b,'yyyy-MM-dd hh24:mi:ss'))  then '丙类' else c1.name end) || (case when  c1.Des is null then '' else '，' ||  c1.Des end ) || (case when bd_srv_comp.Des is null then '' else '，'||bd_srv_comp.Des end)")
				.append(" else  bd_srv_comp.des end as des ,")
				.append(" bd_srv_comp.name, bd_srv_comp.code,bd_srv_comp.Id_Srv ,bd_srv_comp.Sd_Srvtp , A1.id_mm,A1.name as name_mm, C.Sd_Hpsrvtp,C.Id_hpsrvtp,C.Des as hp_des,(bd_srv_comp.id_srv||'-' || A1.id_mm) as IDSRVIDMM,C.code as code_hpsrvorca ")
				.append(" from (")
				.append(getSrvMmSql(code_entp,id_pripat,whereList))
				.append(" ) bd_srv_comp ")
				.append(" left outer join bd_mm A1 ON A1.Id_Srv=bd_srv_comp.Id_Srv ")
				.append(" and " + getFgUseFld(code_entp))
				.append(" left outer join bd_hp_srvorca C ON bd_srv_comp.ID_SRV=C.Id_Srv")
				.append((id_hp != null && id_hp != "") ? " and C.Id_Hp='" + id_hp + "'" : "")
				.append(" and ((bd_srv_comp.fg_mm='Y' and A1.Id_Mm=c.id_mm) or bd_srv_comp.fg_mm='N')")
				.append(" left outer join bd_udidoc C1 ON C1.Id_Udidoc=C.Id_Hpsrvtp")
				.append(" left outer join bd_udidoc D ON D.Id_udidoclist='" + IBdSrvDictCodeTypeConst.ID_SRVTP
					+ "' and D.code = bd_srv_comp.sd_srvtp_udidoc "
						+ " where A1.fg_active is null or A1.fg_active = 'Y'");
				if(inputstr!=null&&inputstr!=""){
					formatsql.append(" ) t order by t.wordfreq desc,case when lower(t.wbcode)='"+inputstr+".' or lower(t.pycode)='"+inputstr+".' or lower(t.name) ='"+inputstr+"' then 0 else 1 end asc,t.pycode");
				}else{
					formatsql.append(" ) t order by t.wordfreq desc,t.pycode");
				}
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
		formatsql.append(" select a0.*,view_price_rp.price_ratio,")
		.append(" (case when bsw.cnt is null then 0  else bsw.cnt end) as wordfreq,")
		.append(" decode(substr(sd_srvtp,1,2),'01',substr(sd_srvtp,1,4),'14',substr(sd_srvtp,1,4),substr(sd_srvtp,1,2)) as sd_srvtp_udidoc, ") // 获取服务的显示名称01,14取4位，其余取两位
		.append(" bd_srv_drug.id_dosage,bd_srv_drug.id_srvdrug")
		.append(" from bd_srv a0 left join view_price_rp on a0.id_srv=view_price_rp.id_srv and view_price_rp.id_pripat= '" + id_pripat + "'")
		.append(" left join bd_srv_drug on a0.id_srv = bd_srv_drug.id_srv ")
		.append(" left join bd_srvoth_wordfreq bsw  on a0.id_srv = bsw.id_biz and biz_classtype = 'medsrv'").append(" and id_dept ='").append(Context.get().getDeptId()).append("' ")
		.append(" where a0.Fg_Or = 'Y' and a0.Fg_Active = 'Y' and a0.ds = 0 ")
		.append(" and " + getFgUseFld(code_entp)) // 获取可使用标识 
		.append(" and ").append(orgsql)
		.append( whereStr)
		.append(" order by wordfreq desc,a0.pycode")
		.append(" ) where rownum <= "+this.getRowsCount());
		return formatsql.toString();
	}

}
