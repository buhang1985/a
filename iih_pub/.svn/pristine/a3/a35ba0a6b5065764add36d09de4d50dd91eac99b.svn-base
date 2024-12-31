package iih.pi.reg.pat.refs;

import java.util.List;

import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hp.d.desc.HPDODesc;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.permfw.pub.EnvContextUtil;
/**
 * 患者医保计划参照模型
 * @author Administrator
 *
 */
public class PatHpRefModel extends RefGridModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { HPDO.CODE, HPDO.NAME, "no_hp"};
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] {HPDO.ID_HP, HPDO.FG_CARDST };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称", "医保卡号"};
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { HPDO.CODE, HPDO.NAME };
	}

	@Override
	public String getRefTitle() {
		return super.getRefTitle();
	}

	@Override
	public String getPkFieldCode() {
		return HPDO.ID_HP;
	}

	@Override
	public String getRefCodeField() {
		return HPDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return HPDO.NAME;
	}
	

	@Override
	public String getTableName() {		
		//return new PiPatHpDO().getTableName();后续处理
		return HPDODesc.TABLE_NAME;
	}
	
	@Override
	public String getRefSql() {
		String patidStr = (String) this.getExtendAttributeValue("patid");
		String fgactStr = (String) this.getExtendAttributeValue("fgact");
		String notHPStr = (String) this.getExtendAttributeValue("notHP");
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("select BD_HP.code, ");
		sqlBuilder.append("BD_HP.name, ");
		if(StringUtil.isEmpty(patidStr) ){
			sqlBuilder.append("null as no_hp, ");
		}else{
			sqlBuilder.append("PATHP.no_hp as no_hp, ");
		}
		sqlBuilder.append("BD_HP.id_hp, ");
		sqlBuilder.append("BD_HP.fg_cardst ");
		sqlBuilder.append("from BD_HP BD_HP ");
		
		if(!StringUtil.isEmpty(patidStr) ){
			sqlBuilder.append(" left join PI_PAT_HP PATHP on BD_HP.id_hp=PATHP.id_hp ");
			sqlBuilder.append(" and PATHP.id_pat = '" + patidStr + "'");
			if(!StringUtil.isEmpty(fgactStr)){
				sqlBuilder.append(" and PATHP.fg_act = '"+ fgactStr + "'");
			}
		}
		//where
		StringBuilder whereBuilder = new StringBuilder(" WHERE 1=1 AND BD_HP.FG_ACTIVE='Y' ");	
		if (!StringUtil.isEmpty(notHPStr)){
			whereBuilder.append(" And BD_HP.id_hp <> '" + notHPStr + "' ");
		}
		
		List<String> whereList = this.getWherePart();
		if (whereList.size() > 0) {
			for (String where : this.getWherePart()) {
				whereBuilder.append(" And (").append(where).append(") ");
			}
		}
		String orgStr = EnvContextUtil.processEnvContext("", new HPDO(), "BD_HP");
		if(!StringUtil.isEmpty(orgStr)){
			whereBuilder.append(String.format(" and %s ", orgStr));
		}
		sqlBuilder.append(whereBuilder);//where条件
		//增加排序功能
		if(!StringUtil.isEmpty(patidStr) || 
				!StringUtil.isEmpty(fgactStr) || 
				!StringUtil.isEmpty(notHPStr)){
			sqlBuilder.append(" order by no_hp,code");//按患者卡号排序，如果有卡号自动在前面，然后按医保编码排序
		}else{
			sqlBuilder.append(" order by code");
		}
		
		return sqlBuilder.toString();
	}
}
