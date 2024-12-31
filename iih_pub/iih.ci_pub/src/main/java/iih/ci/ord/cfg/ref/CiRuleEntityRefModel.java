package iih.ci.ord.cfg.ref;

import java.util.List;

import iih.ci.ord.cfg.cirulecfg.d.CiRuleEntity;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.appfw.refinfo.RefResultSet;

public class CiRuleEntityRefModel extends RefGridModel{

	private static final long serialVersionUID = 1L;
	private String queryParam;
	
	@Override
	public String[] getShowFieldCode() {
		return new String[] {CiRuleEntity.ID_RULE, CiRuleEntity.NAME_RULE_TYPE, CiRuleEntity.CLASS_PATH, CiRuleEntity.CLASS_NAME};
	}
	
	@Override
	public String[] getShowFieldName() {
		return new String[] {"规则定义ID", "规则类型", "规则类路径", "规则类名称"};
	}
	
	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { CiRuleEntity.PROPS_DEF, CiRuleEntity.RULE_TYPE };
	}
	
	@Override
	public String getPkFieldCode() {
		return CiRuleEntity.ID_RULE;
	}
	
	@Override
	public String getRefNameField() {
		return CiRuleEntity.CLASS_NAME;
	}
	
	@Override
	public String getTableName() {
		return "entity";
	}
	
	@Override
	public void addWherePart(String wherePart) {
		this.getWherePart().add(wherePart);
	}
	
	@Override
	public String[] getBlurFields() {
		return new String[] {CiRuleEntity.CLASS_NAME};
	}
	
	@Override
	public RefResultSet filterRefBlurValue(String blurValue, PaginationInfo pg) {
		this.queryParam = blurValue.toLowerCase();
		
		StringBuilder sb = new StringBuilder();
		sb.append(" (entity.class_name like '%" + this.queryParam + "%' ");
		sb.append(" or entity.class_path like '%" + this.queryParam + "%' )");
		this.addWherePart(sb.toString());
		
		try {
			if (pg == null) {
				return this.getRefData();
			}
			else {
				return this.getRefData(pg);
			}
		} finally {
			this.removeWherePart(sb.toString());
		}
	}
	
	@Override
	public String getRefSql() {
		StringBuilder sql = new StringBuilder();
		sql.append(" select entity.id_rule, entity.name_rule_type, entity.class_path, entity.class_name, entity.props_def, entity.rule_type ")
		   .append(" from ci_rule_entity entity ")
		   .append(" where ")
		   .append(" entity.ds = '0' ");
		
		String whereStr = "";
		List<String> whereList = this.getWherePart();
		for (String part : whereList) {
			whereStr += (" and " + part);
		}
		if (whereStr.length() > 0) {
			sql.append(" and (" + whereStr.substring(5) + ") ");			
		}
		
		return sql.toString();
	}
}
