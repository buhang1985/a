package iih.bl.cg.api.s.bp.qry;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetNotChargeInfosQry implements ITransQry {

	String pat_code;
	String repdate;
	String enddate;

	public GetNotChargeInfosQry(String pat_code, String rep_date, String end_date) {
		this.pat_code = pat_code;
		this.repdate = rep_date;
		this.enddate = end_date;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		List<Object> listpara=new ArrayList<Object>();
		if (this.pat_code != null && this.pat_code != "") {
			listpara.add(this.pat_code);
		}
		if (this.repdate != null && this.repdate != "") {
			listpara.add(this.repdate + " 00:00:00");
		}
		if (this.enddate != null && this.enddate != "") {
			listpara.add(this.enddate + " 23:59:59");
		}
		for (int i = 0; i < 4; i++) {
			for (Object object : listpara) {
				param.addParam(object);
			}
		}
		
		return param;
	}

	
	@Override
	public String getQrySQLStr() {
		StringBuffer sb = new StringBuffer();
		//处方
		sb.append(
				"select b.code as ticket_id,\n" +
						"'处方'|| b.code as ticket_type,\n" + 
						"c.name as ticket_content,\n" + 
						"e.spec as specification,\n" + 
						"(select sum(nvl(mm.price_pgku_cur * mm.quan_cur,0.0)) as price from ci_or_srv_mm mm where mm.id_orsrvmm=d.id_orsrvmm )as charge_price,\n" + 
						"d.quan_cur as charge_amount,\n" + 
						"a.orders as caoyao_fu,\n" + 
						"f.name as ybtype,\n" + 
						"'' as drug_status,\n" + 
						"g.barcode_chis as p_bar_code,\n" + 
						"h.times_op as times,\n" + 
						"i.code as apply_unit,\n" + 
						"i.name as dept_name\n" + 
						"from ci_order a\n" + 
						"left join ci_pres b on b.id_pati=a.id_pat\n" + 
						"left join ci_or_srv c on c.id_pres=b.id_pres\n" + 
						"left join ci_or_srv_mm d on d.id_orsrv=c.id_orsrv\n" + 
						"left join bd_mm e on e.id_mm=d.id_mm\n" + 
						"left join bd_udidoc f on f.id_udidoc=c.id_hpsrvtp\n" + 
						"left join pi_pat g on g.id_pat=b.id_pati\n" + 
						"left join en_ent_op h on h.id_ent=a.id_en\n" + 
						"left join bd_dep i on i.id_dep=a.id_dep_sign\n" + 
				"where a.sd_srvtp like '01%' and a.sd_su_bl=0");

		if (this.pat_code != null && this.pat_code != "") {
			sb.append(" AND g.pat_code=?");
		}
		if (this.repdate != null && this.repdate != "") {
			sb.append(" AND a.dt_sign>?");
		}
		if (this.enddate != null && this.enddate != "") {
			sb.append(" AND a.dt_sign<?");
		}
		//检查
		sb.append(" union ");
		sb.append(

				"select s1.no_applyform as ticket_id,\n" +
						"'检查'|| s1.no_applyform as ticket_type,\n" + 
						"c1.name as ticket_content,\n" + 
						"'' as specification,\n" + 
						"(select sum((case when A1.fg_bl = 'Y' and A1.Fg_Mm = 'N' then nvl(A1.Pri * A1.Quan_Medu, 0.0)\n" + 
						"when A1.Fg_Mm = 'Y' then nvl(B1.Price_Pgku_Cur * B1.Quan_Cur, 0.0) else 0.0 end))\n" + 
						"as amt from ci_or_srv A1 left outer join ci_or_srv_mm B1 ON A1.Id_Orsrv = B1.Id_Orsrv where A1.Id_Or = x1.Id_Or)as charge_price,\n" + 
						"x1.times_cur as charge_amount,\n" + 
						"0 as caoyao_fu,\n" + 
						"'' as ybtype,\n" + 
						"x1.dt_sign as happen_date,\n" + 
						"'' as drug_status,\n" + 
						"d1.barcode_chis as p_bar_code,\n" + 
						"e1.times_op as times,\n" + 
						"f1.code as apply_unit,\n" + 
						"f1.name as dept_name\n" + 
						"from ci_ap_obs s1\n" + 
						"left join ci_order x1 on x1.id_or=s1.id_or\n" + 
						"left join bd_srv c1 on c1.id_srv=x1.id_srv\n" + 
						"left join pi_pat d1 on d1.id_pat=x1.id_pat\n" + 
						"left join en_ent_op e1 on e1.id_ent=x1.id_en\n" + 
						"left join bd_dep f1 on f1.id_dep=x1.id_dep_sign"+ 
				"where a.sd_srvtp like '02%' and  a.sd_su_bl=0");

		if (this.pat_code != null && this.pat_code != "") {
			sb.append(" AND x1.pat_code=?");
		}
		if (this.repdate != null && this.repdate != "") {
			sb.append(" AND x1.dt_sign>?");
		}
		if (this.enddate != null && this.enddate != "") {
			sb.append(" AND x1.dt_sign<?");
		}
		//治疗
		sb.append(" union ");
		sb.append(
				"select b3.code_prn as ticket_id,\n" +
						"'诊疗'|| b3.code_prn as ticket_type,\n" + 
						"c3.name as ticket_content,\n" + 
						"c3.id_medu as specification,\n" + 
						"(select sum(nvl(item.amt_biz,0.0)) as price from ci_prn_item item where item.id_ciprn=b3.id_ciprn )as charge_price,\n" + 
						"c3.quan_medu as charge_amount,\n" + 
						"0 as caoyao_fu,\n" + 
						"f3.name as ybtype,\n" + 
						"a3.dt_sign as happen_date,\n" + 
						"'' as drug_status,\n" + 
						"g3.barcode_chis as p_bar_code,\n" + 
						"h3.times_op as times,\n" + 
						"i3.code as apply_unit,\n" + 
						"i3.name as dept_name\n" + 
						"from ci_prn b3\n" + 
						"left join ci_prn_item d3 on d3.id_ciprn=b3.id_ciprn\n" + 
						"left join ci_or_srv c3 on c3.id_orsrv=a3.id_biz\n" + 
						"left join ci_order a3 on a3.id_or=c3.id_or\n" + 
						"left join bd_udidoc f3 on f3.id_udidoc=c3.id_hpsrvtp\n" + 
						"left join pi_pat g3 on g3.id_pat=a3.id_pat\n" + 
						"left join en_ent_op h3 on h3.id_ent=a3.id_en\n" + 
						"left join bd_dep i3 on i3.id_dep=a3.id_dep_sign"+
				"where a.sd_su_bl=0");

		if (this.pat_code != null && this.pat_code != "") {
			sb.append(" AND a3.pat_code=?");
		}
		if (this.repdate != null && this.repdate != "") {
			sb.append(" AND a3.dt_sign>?");
		}
		if (this.enddate != null && this.enddate != "") {
			sb.append(" AND a3.dt_sign<?");
		}
		//检验
		sb.append(" union ");
		sb.append(
				"select s2.code_app as ticket_id,\n" +
						"'检验'|| s2.code_app as ticket_type,\n" + 
						"c2.name as ticket_content,\n" + 
						"'' as specification,\n" + 
						"(select sum((case when A2.fg_bl = 'Y' and A2.Fg_Mm = 'N' then nvl(A2.Pri * A2.Quan_Medu, 0.0)\n" + 
						"when A2.Fg_Mm = 'Y' then nvl(B2.Price_Pgku_Cur * B2.Quan_Cur, 0.0) else 0.0 end))\n" + 
						"as amt from ci_or_srv A2 left outer join ci_or_srv_mm B2 ON A2.Id_Orsrv = B2.Id_Orsrv where A2.Id_Or = x2.Id_Or)as charge_price,\n" + 
						"x2.times_cur as charge_amount,\n" + 
						"0 as caoyao_fu,\n" + 
						"'' as ybtype,\n" + 
						"x2.dt_sign as happen_date,\n" + 
						"'' as drug_status,\n" + 
						"d2.barcode_chis as p_bar_code,\n" + 
						"e2.times_op as times,\n" + 
						"f2.code as apply_unit,\n" + 
						"f2.name as dept_name\n" + 
						"from ci_app_lis s2\n" + 
						"left join ci_app_lis_or y2 on y2.id_ciapplissheet=s2.id_ciapplissheet\n" + 
						"left join ci_order x2 on x2.id_or=y2.id_or\n" + 
						"left join bd_srv c2 on c2.id_srv=x2.id_srv\n" + 
						"left join pi_pat d2 on d2.id_pat=x2.id_pat\n" + 
						"left join en_ent_op e2 on e2.id_ent=x2.id_en\n" + 
						"left join bd_dep f2 on f2.id_dep=x2.id_dep_sign"+
				"where a.sd_srvtp like '03%' and  a.sd_su_bl=0");

		if (this.pat_code != null && this.pat_code != "") {
			sb.append(" AND x2.pat_code=?");
		}
		if (this.repdate != null && this.repdate != "") {
			sb.append(" AND x2.dt_sign>?");
		}
		if (this.enddate != null && this.enddate != "") {
			sb.append(" AND x2.dt_sign<?");
		}
		return sb.toString();
	}

	String getDateToString(Date date) {
		if (date != null) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			return formatter.format(date);
		}
		return null;
	}
}
