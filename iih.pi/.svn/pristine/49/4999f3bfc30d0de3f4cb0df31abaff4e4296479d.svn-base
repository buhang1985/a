package iih.pi.banner.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetPatientBannerDTOSSql implements ITransQry {

	private String Keys;
	
	public GetPatientBannerDTOSSql(String keys)
	{
		Keys = keys;
	}
	
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		
		return null;
	}

	@Override
	public String getQrySQLStr() {
		return GetSqlStr();
	}
	
	public String GetSqlStr()
	{
		String SqlStr=" select * from ( "
				+"  select "
				+"    /* enent.id_ent,诊断记录ID*/ "
				+"     patient.code,/*患者编码Code*/ "
				+"     patient.id_pat,/*患者id*/ "
				+"     /*---------患者信息开始---------*/ "
				+"     patient.name,/*1姓名*/ "
				+"     udisex.name as sex,/*2性别*/ "
				+"     patient.dt_birth,/*3出生日期*/ "
				+"     nation.name as nation,/*4民族*/ "
				+"     Occupation.name as Occupation, /*5职业*/  "
				+"   ( "
				+"    select "
				+"     concat(province.name,address.street) "
				+"     from PI_PAT_ADDR address "
				+"    left join bd_udidoc adduid on address.sd_addrtp=adduid.id_udidoc and address.sd_addrtp='9' "
				+"    left join bd_udidoc province on address.sd_admdiv=province.id_udidoc "
				+"   where address.id_pat=patient.id_pat and rownum=1 "
				+"   ) as address/*现住址*/,   "
				+"   nvl(patient.mob,patient.tel) as phonenum,/*8电话 先 移动电话 固定电话*/ "
				+"   marry.name as  marryhis,/*9婚史*/      "
				+"   (select count(*) from pi_pat_cbh where id_pat=patient.id_pat ) as birthhis,/*育史*/     " 
				+"   (select count(*) from pi_pat_DI where id_pat=patient.id_pat ) as sicknesshis,/*疾病史*/ "
				+"   (select count(*) from pi_pat_al where id_pat=patient.id_pat ) as allergyhis,/*过敏史*/ "
				+"   /*  (select name from BD_HP where BD_HP.id_hp in(select id_hp from PI_PAT_HP where PI_PAT_HP.id_pat=enent.id_pat and fg_deft='Y') and rownum=1) as pipathpname,医保 保险计划*/  "
				+"     idtp.name as id_idtp,/*证件类型*/ "
				+"  patient.id_code /*证件号码*/ "
				+"    from pi_pat patient   "
				+"    left join pi_pat_acc patacc on patient.id_pat=patacc.id_pat and  patient.fg_invd='N' "
				+"    left join bd_udidoc marry on patient.id_marry=marry.id_udidoc/*患者婚姻状况*/ "
				+"    left join bd_udidoc idtp on patient.id_idtp=idtp.id_udidoc/*]证件类型*/ "
				+"    left join bd_udidoc nation on patient.id_nation=nation.id_udidoc/*民族*/ "
				+"    left join bd_udidoc Occupation on patient.id_occu=Occupation.id_udidoc/*民族*/ "
				+"    left join bd_udidoc udisex on udisex.id_udidoc=patient.id_sex "            
				+"   )  "+ Keys;
		return SqlStr;
		
	}

}
