package iih.pi.reg.s.bp.qry;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.desc.PatDODesc;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.permfw.pub.EnvContextUtil;

/**
 * 患者banner检索sql
 * @author ly
 *
 */
public class PiBannerQry implements ITransQry{

	private String condWhere;
	private String sqlStr;
	
	public PiBannerQry(String sqlStr,String condWhere){
		this.condWhere = condWhere;
		this.sqlStr = sqlStr;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer sqlSb) {
		
		sqlSb.append(condWhere);
		
		//添加组织条件
		String orgSql = EnvContextUtil.processEnvContext("", new PatDO(), false);
		if(!StringUtil.isEmpty(orgSql)){
			orgSql = orgSql.replace(PatDODesc.TABLE_NAME + ".", "");
			sqlSb.append("and " + orgSql);
		}
		
		return new SqlParam();
	}

	@Override
	public String getQrySQLStr() {
		
		StringBuilder sqlSb = new StringBuilder();
		//传入的sql为空时
		if(StringUtil.isEmptyWithTrim(this.sqlStr)){
			sqlSb.append("select * from ");
			sqlSb.append("  (  ");
			sqlSb.append(this.getDefaultSql());
			sqlSb.append("   )  ");
			//if(!StringUtil.isEmptyWithTrim(condWhere)){
				sqlSb.append("where 1=1 ");
			//}
		}else{
			sqlSb.append(this.sqlStr);
		}

		return sqlSb.toString();
	}
	
	private String getDefaultSql(){
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("   select ");
		sqlSb.append("       patient.id_grp, /*集团id*/ ");
		sqlSb.append("       patient.id_org, /*组织id*/ ");
		sqlSb.append("       patient.id_pat, /*患者id*/ ");
		sqlSb.append("       patient.code, /*患者编码*/ "); 
		sqlSb.append("       patient.code as code_pat, /*患者编码*/ ");
		sqlSb.append("       patient.name, /*1姓名*/ ");
		sqlSb.append("       udisex.name as sex, /*2性别*/ ");
		sqlSb.append("       patient.dt_birth, /*3出生日期*/ ");
		sqlSb.append("       nation.name as nation, /*4民族*/ ");
		sqlSb.append("       Occupation.name as Occupation, /*5职业*/ ");
		sqlSb.append("       (select id_pataddr ");
		sqlSb.append("          from PI_PAT_ADDR address ");
		sqlSb.append("         where address.id_pat = patient.id_pat ");
		sqlSb.append("           and address.sd_addrtp = '" + IPiDictCodeConst.SD_ADDR_TYPE_NOW + "' ");
		sqlSb.append("           and rownum = 1) as id_pataddr, /*现住址id 取现住址在外部处理*/ ");
		sqlSb.append("       nvl(patient.mob, patient.tel) as phonenum, /*8电话 先 移动电话 固定电话*/ ");
		sqlSb.append("       (select name from BD_HP where BD_HP.id_hp in(select id_hp from PI_PAT_HP where ");
		sqlSb.append("        PI_PAT_HP.id_pat=patient.id_pat and fg_deft='Y') and rownum=1) as pipathpname,/*医保  保险计划*/ ");
		sqlSb.append("       marry.name as marryhis, /*9婚史*/ ");
		sqlSb.append("       (select count(*) from pi_pat_cbh where id_pat = patient.id_pat) as birthhis, /*育史*/ ");
		sqlSb.append("       (select count(*) from pi_pat_DI where id_pat = patient.id_pat) as sicknesshis, /*疾病史*/ ");
		//*过敏史在外部处理*/sqlSb.append("       (select count(*) from pi_pat_al where id_pat = patient.id_pat) as allergyhis, /*过敏史*/ ");
		sqlSb.append("       idtp.name as id_idtp, /*证件类型*/  ");
		sqlSb.append("       patient.id_code, /*证件号码*/  ");
		sqlSb.append("		 patph.id_hp,/*医保计划*/");
		sqlSb.append("		 patph.no_hp,/*医保号*/");
		sqlSb.append("		 bdph.name as name_hp,/*医保计划名称*/");
		sqlSb.append("		 patcert.name as name_patcret,/*信用分类*/");
		sqlSb.append("		 pripat.name as name_pripat,/*价格分类*/");
		sqlSb.append("		 patca.name as patcaname, /*患者分类*/");
		sqlSb.append("		 patca.id_patca as patcaid, /*患者分类id*/");
		sqlSb.append("		 patca.code as patcacode, /*患者分类编码*/");
		sqlSb.append("		 patient.fg_realname, /*实名认证*/");
		sqlSb.append("		 patient.code_amr_ip, /*住院病案编号*/");
		sqlSb.append("		 patient.photo as photo_pat, /*照片*/");
		sqlSb.append("		 patient.barcode_chis, /*CHIS条码号*/");
		sqlSb.append("			patcard.code as patcode, /*就诊卡号*/");
		sqlSb.append("       (select pi_pat_acc.prepay prepay_balance from pi_pat_acc where id_pat = patient.id_pat) as prepay_balance /*预交金余额*/");
		sqlSb.append("   from pi_pat patient ");
		sqlSb.append("   left join pi_pat_hp patph ");
		sqlSb.append("     on patient.id_pat=patph.id_pat");
		sqlSb.append("     and fg_deft='Y'");
		sqlSb.append("     and fg_act='Y'");
		sqlSb.append("   left join bd_hp bdph");
		sqlSb.append("     on patph.id_hp=bdph.id_hp/*患者医保计划*/");
		sqlSb.append("   left join pi_pat_acc patacc ");
		sqlSb.append("     on patient.id_pat = patacc.id_pat ");
		sqlSb.append("     and patient.fg_invd = 'N' ");
		sqlSb.append("   left join PI_PAT_CA patca");
		sqlSb.append("     on patient.id_paticate=patca.id_patca/*患者分类*/");
		sqlSb.append("   left join bd_udidoc marry ");
		sqlSb.append("     on patient.id_marry = marry.id_udidoc /*患者婚姻状况*/ ");
		sqlSb.append("   left join bd_udidoc idtp ");
		sqlSb.append("     on patient.id_idtp = idtp.id_udidoc /*证件类型*/ ");
		sqlSb.append("   left join bd_udidoc nation ");
		sqlSb.append("     on patient.id_nation = nation.id_udidoc /*民族*/ ");
		sqlSb.append("   left join pi_pat_cret patcert");
		sqlSb.append("     on patient.id_patcrettp=patcert.id_patcret/*信用分类*/");
		sqlSb.append("   left join bd_pri_pat pripat");
		sqlSb.append("     on patient.id_patpritp=pripat.id_pripat/*价格分类*/");
		sqlSb.append("   left join bd_udidoc Occupation ");
		sqlSb.append("     on patient.id_occu = Occupation.id_udidoc /*民族*/ ");
		sqlSb.append("   left join bd_udidoc udisex ");
		sqlSb.append("     on udisex.id_udidoc = patient.id_sex ");
		sqlSb.append("    left join PI_PAT_CARD patcard ");
		sqlSb.append("     on patient.id_pat=patcard.id_pat and patcard.fg_act='Y' ");
		sqlSb.append("   where patient.ds = 0 ");
		sqlSb.append("   and patient.fg_invd = 'N' ");
		return sqlSb.toString();
	}
}
