package iih.pe.report.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetDisAgeDisQry implements ITransQry {
	
	private String dt_begin;
	
	private String dt_end;
	
	private String sex;
	
	private String age_start;
	
	private String age_end;
	
	private String fg_marry;
	
	private String petype;

	private String pediag;
		
	public GetDisAgeDisQry(String dt_begin, String dt_end, String sex, String age_start, String age_end, String fg_marry, String petype, String pediag) {
		
		this.dt_begin = dt_begin;
		this.dt_end = dt_end;
		this.sex = sex;
		this.age_start = age_start;
		this.age_end = age_end;
		this.fg_marry = fg_marry;
		this.petype = petype;
		this.pediag = pediag;
		
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {

		SqlParam param = new SqlParam();
		if(!dt_begin.equals("")){
			param.addParam(dt_begin);
		}
		if(!dt_end.equals("")){
			param.addParam(dt_end);
		}
		if(!sex.equals("") && !sex.equals("0")){
			param.addParam(sex);
		}
		if(!age_start.equals("")){
			param.addParam(age_start);
		}
		if(!age_end.equals("")){
			param.addParam(age_end);
		}
		param.addParam(pediag);
		if(!dt_begin.equals("")){
			param.addParam(dt_begin);
		}
		if(!dt_end.equals("")){
			param.addParam(dt_end);
		}
		if(!sex.equals("") && !sex.equals("0")){
			param.addParam(sex);
		}
		if(!age_start.equals("")){
			param.addParam(age_start);
		}
		if(!age_end.equals("")){
			param.addParam(age_end);
		}
		return param;
		
	}

	@Override
	public String getQrySQLStr() {
		boolean flag1  = false;
		boolean flag2  = false;
		String key1 = " where ";
		String key2 = " and ";
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("select c1.age_psn, c1.num/c2.num as scale from"); 
		sqlStr.append(" (select a.age_psn, count (b.diag) num");
		sqlStr.append(" from pe_apt_pepsnappt a"); 
		sqlStr.append(" inner join pe_wf_perstdiagsugg b");
		sqlStr.append(" on a.id_pepsnappt = b.id_pepsnappt");
		if(!dt_begin.equals("")){
			sqlStr.append(" where a.dt_pe >= ?");
			flag1 = true;
		}
		if(!dt_end.equals("")){
			if(flag1){
				sqlStr.append(key2 + "a.dt_pe <= ?");
			}else{
				sqlStr.append(key1 + "a.dt_pe <= ?");
			}
			flag1 = true;
		}
		if(!sex.equals("") && !sex.equals("0")){
			if(flag1){
				sqlStr.append(key2 + "a.sd_sex_psn = ?"); 
			}else{
				sqlStr.append(key1 + "a.sd_sex_psn = ?"); 
			}
			flag1 = true;
		}
		if(!age_start.equals("")){
			if(flag1){
				sqlStr.append(key2 + "a.age_psn >= ?");
			}else{
				sqlStr.append(key1 + "a.age_psn >= ?");
			}
			flag1 = true;
		}
		if(!age_end.equals("")){
			if(flag1){
				sqlStr.append(key2 + "a.age_psn <= ?");
			}else{
				sqlStr.append(key1 + "a.age_psn <= ?");
			}
			flag1 = true;
		}
		if(!fg_marry.equals("") && !fg_marry.equals("0")){
			if(flag1){
				if(fg_marry.equals("1")){					
					sqlStr.append(key2 + "a.marriage = 'Y'");
				}else{
					sqlStr.append(key2 + "a.marriage = 'N'");					
				}
			}else{
				if(fg_marry.equals("1")){					
					sqlStr.append(key1 + "a.marriage = 'Y'");
				}else{
					sqlStr.append(key1 + "a.marriage = 'N'");					
				}
			}
		}
		if(!petype.equals("") && !petype.equals("0")){
			if(flag1){
				if(petype.equals("1")){					
					sqlStr.append(key2 + "a.id_pecorpappt = '~'");
				}else{
					sqlStr.append(key2 + "a.id_pecorpappt <> '~'");
				}
			}else{
				if(petype.equals("1")){					
					sqlStr.append(key1 + "a.id_pecorpappt = '~'");
				}else{
					sqlStr.append(key1 + "a.id_pecorpappt <> '~'");
				}
			}
		}
		sqlStr.append(" and b.diag = ?");
		sqlStr.append(" group by a.age_psn) c1"); 
		sqlStr.append(" inner join"); 
		sqlStr.append(" (select a.age_psn, count (b.diag) num");
		sqlStr.append(" from pe_apt_pepsnappt a"); 
		sqlStr.append(" inner join pe_wf_perstdiagsugg b");
		sqlStr.append(" on a.id_pepsnappt = b.id_pepsnappt");
		if(!dt_begin.equals("")){
			sqlStr.append(" where a.dt_pe >= ?");
			flag2 = true;
		}
		if(!dt_end.equals("")){
			if(flag2){
				sqlStr.append(key2 + "a.dt_pe <= ?");
			}else{
				sqlStr.append(key1 + "a.dt_pe <= ?");
			}
			flag2 = true;
		}
		if(!sex.equals("") && !sex.equals("0")){
			if(flag2){
				sqlStr.append(key2 + "a.sd_sex_psn = ?"); 
			}else{
				sqlStr.append(key1 + "a.sd_sex_psn = ?"); 
			}
			flag2 = true;
		}
		if(!age_start.equals("")){
			if(flag2){
				sqlStr.append(key2 + "a.age_psn >= ?");
			}else{
				sqlStr.append(key1 + "a.age_psn >= ?");
			}
			flag2 = true;
		}
		if(!age_end.equals("")){
			if(flag2){
				sqlStr.append(key2 + "a.age_psn <= ?");
			}else{
				sqlStr.append(key1 + "a.age_psn <= ?");
			}
			flag2 = true;
		}
		if(!fg_marry.equals("") && !fg_marry.equals("0")){
			if(flag2){
				if(fg_marry.equals("1")){					
					sqlStr.append(key2 + "a.marriage = 'Y'");
				}else{
					sqlStr.append(key2 + "a.marriage = 'N'");					
				}
			}else{
				if(fg_marry.equals("1")){					
					sqlStr.append(key1 + "a.marriage = 'Y'");
				}else{
					sqlStr.append(key1 + "a.marriage = 'N'");					
				}
			}
			flag2 = true;
		}
		if(!petype.equals("") && !petype.equals("0")){
			if(flag2){
				if(petype.equals("1")){					
					sqlStr.append(key2 + "a.id_pecorpappt = '~'");
				}else{
					sqlStr.append(key2 + "a.id_pecorpappt <> '~'");
				}
			}else{
				if(petype.equals("1")){					
					sqlStr.append(key1 + "a.id_pecorpappt = '~'");
				}else{
					sqlStr.append(key1 + "a.id_pecorpappt <> '~'");
				}
			}
		}
		sqlStr.append(" group by a.age_psn) c2");
		sqlStr.append(" on c1.age_psn = c2.age_psn");
		sqlStr.append(" order by c1.age_psn");
		System.out.println(sqlStr.toString());
		return sqlStr.toString();
	}

}
