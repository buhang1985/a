package iih.mp.dg.ipdgapp.refs;

import java.util.List;

import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.permfw.dataper.d.DataPerResDO;
import xap.sys.permfw.dataper.d.DataPerRuleDO;
import xap.sys.permfw.dataper.d.desc.DataPerResDODesc;
import xap.sys.permfw.dataper.d.desc.DataPerRuleDODesc;


public class MpDgDataPerRuleModel extends RefGridModel{

	private static final long serialVersionUID = 1L;

	/**
	 * 显示字段中文名
	 */
	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	/**
	 * 显示字段名
	 */
	@Override
	public String[] getShowFieldCode() {
		return new String[] { DataPerRuleDO.CODE, DataPerRuleDO.NAME };
	}

	/**
	 * 隐藏字段数组
	 */
	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { DataPerRuleDO.ID_DATAPER_RES, DataPerRuleDO.ID_DATAPER_RULE };
	}

	/**
	 * 查询字段名数组
	 */
	@Override
	public String[] getBlurFields() {
		return new String[] { DataPerRuleDO.CODE, DataPerRuleDO.NAME };
	}

	/**
	 * 参照主表名
	 */
	@Override
	public String getTableName() {
		return DataPerRuleDODesc.TABLE_NAME;
	}

	/**
	 * 主键字段
	 */
	@Override
	public String getPkFieldCode() {
		return DataPerRuleDO.ID_DATAPER_RULE;
	}

	/**
	 * 编码字段
	 */
	@Override
	public String getRefCodeField() {
		return DataPerRuleDO.CODE;
	}

	/**
	 * 显示名称字段
	 */
	@Override
	public String getRefNameField() {
		return DataPerRuleDO.NAME;
	}
	
	@Override
	public String getRefSql() {
		
		String resCode =(String)this.getExtendAttributeValue("code_res");//资源编码
		
		String t = DataPerRuleDODesc.TABLE_NAME;
		String t2 = DataPerResDODesc.TABLE_NAME;
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select ").append(String.format("%s.%s", t,DataPerRuleDO.CODE)).append(", ")
			 .append(String.format("%s.%s", t,DataPerRuleDO.NAME)).append(", ")
			 .append(String.format("%s.%s", t,DataPerRuleDO.ID_DATAPER_RES)).append(", ")
			 .append(String.format("%s.%s", t,DataPerRuleDO.ID_DATAPER_RULE))
			 .append(" from ").append(t).append(" inner join ").append(t2)
			 .append(" on ").append(String.format("%s.%s", t,DataPerRuleDO.ID_DATAPER_RES))
			 .append(" = ").append(String.format("%s.%s", t2,DataPerResDO.ID_DATAPER_RES))
			 .append(" where 1=1 ");
		
		if(!StringUtil.isEmpty(resCode)){
			sqlSb.append("and ").append(String.format("%s.%s", t2,DataPerResDO.CODE))
			     .append(" = '").append(resCode).append("' ");
		}
			
		List<String> whereList = this.getWherePart();
		if (whereList.size() > 0) {
			//sb.append(" Where 1=1 ");
			for (String where : this.getWherePart()) {
				sqlSb.append(" And (").append(where).append(") ");
			}
		}
		
		sqlSb.append(" order by ").append(String.format("%s.%s", t,DataPerRuleDO.CODE));
		
		return sqlSb.toString();
	}
}
