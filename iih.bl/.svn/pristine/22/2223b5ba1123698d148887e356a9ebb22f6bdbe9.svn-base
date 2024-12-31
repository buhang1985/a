package iih.bl.cg.api.s.bp.qry;



import java.util.ArrayList;
import java.util.List;

import xap.mw.core.utils.ArrayUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetRisLisInfosQry implements ITransQry {

	private String[] ap_nos;
	private String pat_code;
	private Integer time_op;
	private String applyNo;

	public GetRisLisInfosQry(String pat_code,Integer time_op,String[] ap_nos) {
		this.ap_nos = ap_nos;
		this.pat_code = pat_code;
		this.time_op = time_op;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		List<Object> listpara=new ArrayList<Object>();
		if (ArrayUtil.isEmpty(this.ap_nos)) {
			// 拼写为多个单号			
			this.applyNo = "'";
			for (int j = 0; j < ap_nos.length; j++) {
				this.applyNo += ap_nos[j].toString();
				if(ap_nos.length-1 != j)
					this.applyNo += "','";					
			}
			this.applyNo += "'";
			listpara.add(this.applyNo);
		}
		if (this.pat_code != null && this.pat_code != "") {
			listpara.add(this.pat_code);
		}
		if (this.time_op != null) {
			listpara.add(this.time_op);
		}

		for (int i = 0; i < 2; i++) {
			for (Object object : listpara) {
				param.addParam(object);
			}
		}
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sb = new StringBuffer();
		sb.append(" select DISTINCT ");
		sb.append(" cg.id_cgitmoep as cgItmId, ");
		sb.append(" a.code as patCode, ");
		sb.append(" a.barcode_chis as barCodeChis, ");
		sb.append(" a.name patName, ");
		sb.append(" decode(instr(a.sd_sex,'1'),'1','2','2','9') as sex,  ");
		sb.append(" a.dt_birth as birthday， ");
		sb.append(" '' as age , ");
		sb.append(" '112628' as orgCode, ");
		sb.append(" '北京大学国际医院' as orgName, ");
		sb.append(" a.id_code as idCode, ");
		sb.append(" a.tel as tel, ");
		sb.append(" d.name || b.addr_pat as address, ");
		sb.append(" f.no_applyform as applyLongCode, ");
		sb.append(" h.code as srvCode, ");
		sb.append(" h.name as srvName, ");
		sb.append(" '02' as applyTpCode, ");
		sb.append(" '检查类' as applyTpName, ");
		sb.append(" f.code_app as applyCode, ");
				
		sb.append(" (select sum((case when A1.fg_bl = 'Y' and A1.Fg_Mm = 'N' then nvl(A1.Pri * A1.Quan_Medu, 0.0) ");
		sb.append(" when A1.Fg_Mm = 'Y' then nvl(B1.Price_Pgku_Cur * B1.Quan_Cur, 0.0) else 0.0 end)) ");
		sb.append(" as amt from ci_or_srv A1 left outer join ci_or_srv_mm B1 ON A1.Id_Orsrv = B1.Id_Orsrv where A1.Id_Or = g.Id_Or) as price, ");
		
		sb.append(" g.dt_effe as createDateTime, ");
		sb.append(" '' as validDateTime, ");
		sb.append(" i.code as empCode, ");
		sb.append(" i.name as empName, ");
		sb.append(" (case when g.fg_set='N' then j.sd_body ");
		sb.append("   when g.fg_set='Y' then (select dbms_lob.substr(wm_concat(a1.sd_body),4000) ");
		sb.append("    from ci_or_srv_set a1 where a1.id_or=g.id_or) else '' end) as sampleCode, ");
		sb.append(" (case when g.fg_set='N' then (select u1.name from bd_udidoc u1 where u1.id_udidoc=j.id_body) ");
		sb.append("   when g.fg_set='Y' then (select dbms_lob.substr(wm_concat(c1.sd_body),4000) ");
		sb.append("    from ci_or_srv_set c1 where c1.id_or=g.id_or) else '' end) as sampleName, ");
		sb.append(" k.code as mpDepCode, ");
		sb.append(" k.name as mpDepName, ");
		sb.append(" e.times_op as opTimes, ");
		sb.append(" '01' as enTpCode, ");
		sb.append(" '门诊' as enTpName, ");
		sb.append(" l.code as orDepCode, ");
		sb.append(" l.name as orDepName, ");
		sb.append(" (select ss.dt_last_cg from (select * from ci_or_srv srv) ss where ss.id_or=g.id_or and rownum=1) as cgDateTime, ");
		sb.append(" f.str_code_di as diagCode, ");
		sb.append(" f.str_name_di as diagName, ");
		sb.append(" p.code as orderSubCode, ");
		sb.append(" f.clinicalzztz as examAddInfo, ");
		sb.append(" m.dt_sign as diSignDateTime, ");
		sb.append(" n.code as freqCode, ");
		sb.append(" n.name as freqName, ");
		sb.append(" o.name as patCaName ");

		
		sb.append(" from ci_app_ris f ");
		sb.append(" left join ci_order g on g.id_or=f.id_or ");
		sb.append(" left join bd_srv h on h.id_srv=g.id_srv ");
		sb.append(" left join bd_psndoc i on i.id_psndoc=g.id_emp_sign ");
		sb.append(" left join bd_srv_obs j on j.id_srv=h.id_srv ");
		sb.append(" left join bd_dep k on k.id_dep=g.id_dep_mp ");
		sb.append(" left join bd_dep l on l.id_dep=g.id_dep_sign ");
		sb.append(" left join ci_di m on m.id_di=f.id_di ");
		sb.append(" left join bd_freq n on n.id_freq=g.id_freq ");
		sb.append(" left join bd_udidoc p on p.id_udidoc=h.id_iemsgca ");
		sb.append(" left join pi_pat a on a.id_pat=g.id_pat ");
		sb.append(" left join en_ent b on b.id_pat=a.id_pat ");
		sb.append(" left join bd_udidoc c on c.id_udidoc=a.id_sex ");
		sb.append(" left join bd_adminarea d on d.id_adminarea=b.id_admdiv_addr ");
		sb.append(" left join en_ent_op e on e.id_ent=b.id_ent ");
		sb.append(" left join pi_pat_ca o on o.id_patca=b.id_patca");
		sb.append(" left join bl_cg_itm_oep cg on cg.id_or = g.id_or ");
		sb.append("where f.ds='0'");

		if (ArrayUtil.isEmpty(this.ap_nos)) {
			sb.append(" and f.code_app in (?)");
		}
		if (this.pat_code != null && this.pat_code != "") {
			sb.append(" and a.code=?");
		}
		if (this.time_op != null && this.time_op >0) {
			sb.append(" and e.times_op=?");
		}
		sb.append(" union ");
		
		sb.append("select DISTINCT ");
		sb.append(" cg.id_cgitmoep as cgItmId, ");
		sb.append(" a.code as patCode, ");
		sb.append(" a.barcode_chis as barCodeChis, ");
		sb.append(" a.name patName, ");
		sb.append(" decode(instr(a.sd_sex,'1'),'1','2','2','9') as sex, ");
		sb.append(" a.dt_birth as birthday， ");
		sb.append(" '' as age , "); 
		sb.append(" '112628' as orgCode, "); 
		sb.append(" '北京大学国际医院' as orgName, "); 
		sb.append(" a.id_code as idCode, "); 
		sb.append(" a.tel as tel, "); 
		sb.append(" d.name || b.addr_pat as address, "); 		
		sb.append(" q.no_applyform as applyLongCode, "); 
//		sb.append(" h.code as srvCode, "); 
//		sb.append(" h.name as srvName, ");
		sb.append(" cg.code_srv as srvCode, ");
		sb.append(" cg.name_srv as srvName, ");
		sb.append(" '03' as applyTpCode, "); 
		sb.append(" '检验类' as applyTpName, "); 
		sb.append(" x.code_app as applyCode, "); 
//		sb.append(" (select sum((case when A1.fg_bl = 'Y' and A1.Fg_Mm = 'N' then nvl(A1.Pri * A1.Quan_Medu, 0.0) "); 
//		sb.append(" when A1.Fg_Mm = 'Y' then nvl(B1.Price_Pgku_Cur * B1.Quan_Cur, 0.0) else 0.0 end)) "); 
//		sb.append(" as amt from ci_or_srv A1 left outer join ci_or_srv_mm B1 ON A1.Id_Orsrv = B1.Id_Orsrv where A1.Id_Or = g.Id_Or) as price, "); 
		sb.append(" cg.price as price, ");
		sb.append(" g.dt_effe as createDateTime, "); 
		sb.append(" '' as validDateTime, "); 
		sb.append(" i.code as empCode, "); 
		sb.append(" i.name as empName, "); 
		sb.append(" x.sd_samptp as sampleCode, "); 
		sb.append(" r.name as sampleName, "); 
		sb.append(" k.code as mpDepCode, "); 
		sb.append(" k.name as mpDepName, "); 
		sb.append(" e.times_op as opTimes,"); 
		sb.append(" '01' as enTpCode, "); 
		sb.append(" '门诊' as enTpName, "); 
		sb.append(" l.code as orDepCode, "); 
		sb.append(" l.name as orDepName, "); 
		sb.append(" (select ss.dt_last_cg from (select * from ci_or_srv srv ) ss  where ss.id_or=g.id_or and rownum=1) as cgDateTime, "); 
		sb.append(" x.str_code_di as diagCode, "); 
		sb.append(" x.str_name_di as diagName, "); 
		sb.append(" p.code as orderSubCode, "); 
		sb.append(" '' as examAddInfo, "); 
		sb.append(" m.dt_sign as diSignDateTime, "); 
		sb.append(" n.code as freqCode, "); 
		sb.append(" n.name as freqName, "); 			
		sb.append(" o.name as patCaName "); 
		
		sb.append(" from ci_app_lis x "); 
		sb.append(" left join ci_app_lis_or s on s.id_ciapplissheet=x.id_ciapplissheet "); 
		sb.append(" left join ci_order g on g.id_or=s.id_or "); 
		sb.append(" left join ci_ap_lab q on q.id_or=g.id_or "); 
		sb.append(" left join bd_srv h on h.id_srv=g.id_srv "); 
		sb.append(" left join bd_psndoc i on i.id_psndoc=g.id_emp_sign "); 
		sb.append(" left join bd_srv_obs j on j.id_srv=h.id_srv "); 
		sb.append(" left join bd_dep k on k.id_dep=g.id_dep_mp "); 
		sb.append(" left join bd_dep l on l.id_dep=g.id_dep_sign "); 
		sb.append(" left join ci_di m on m.id_di=x.id_di "); 
		sb.append(" left join bd_freq n on n.id_freq=g.id_freq "); 
		sb.append(" left join bd_udidoc p on p.id_udidoc=h.id_iemsgca "); 
		sb.append(" left join bd_udidoc r on r.id_udidoc=x.id_samptp "); 
		sb.append(" left join pi_pat a on a.id_pat=g.id_pat "); 
		sb.append(" left join  en_ent b on b.id_pat=a.id_pat "); 
		sb.append(" left join bd_udidoc c on c.id_udidoc=a.id_sex "); 
		sb.append(" left join bd_adminarea d on d.id_adminarea=b.id_admdiv_addr "); 
		sb.append(" left join en_ent_op e on e.id_ent=b.id_ent "); 
		sb.append(" left join pi_pat_ca o on o.id_patca=b.id_patca " );
		sb.append(" left join bl_cg_itm_oep cg on cg.id_or = g.id_or ");
		sb.append("where x.ds='0'");

		if (ArrayUtil.isEmpty(this.ap_nos)) {
			sb.append(" and x.code_app in (?)");
		}
		if (this.pat_code != null && this.pat_code != "") {
			sb.append(" and a.code=?");
		}
		if (this.time_op != null && this.time_op>0) {
			sb.append(" and e.times_op=?");
		}
		return sb.toString();
	}
}
