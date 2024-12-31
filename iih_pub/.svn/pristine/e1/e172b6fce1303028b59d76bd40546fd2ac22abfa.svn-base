package iih.bd.res.warehouse.refs;

import java.util.List;

import iih.bd.bc.udi.pub.IBdResDictCodeConst;
import iih.bd.utils.BdEnvContextUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.d.desc.DeptDODesc;

/**
 * 基数药科室参照模型
 * @author ly 2017/06/30
 *
 */
public class DeptBaseRefModel extends RefGridModel {

	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { DeptDO.CODE, DeptDO.NAME };
	}
	
	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { DeptDO.ID_DEP, DeptDO.ID_PARENT,DeptDO.INNERCODE };
	}
	
	@Override
	public String[] getShowFieldName() {
		return new String[] { "部门编码", "部门名称" };
	}
	
	@Override
	public String getPkFieldCode() {
		return DeptDO.ID_DEP;
	}
	
	@Override
	public String getRefCodeField() {
		return DeptDO.CODE;
	}
	
	@Override
	public String getRefNameField() {
		return DeptDO.NAME;
	}
	
	@Override
	public String getTableName() {
		return DeptDODesc.TABLE_NAME;
	}
	
	@Override
	public String[] getBlurFields() {
		return new String[]{DeptDO.CODE, DeptDO.NAME, DeptDO.PYCODE, DeptDO.WBCODE, DeptDO.INNERCODE};
	}
	
	@Override
	public String getRefSql() {
		
		String sql = "select code,name,id_dep,id_parent,innercode from bd_dep "
				+ " where id_dep in (" + getBaseWarehourseSql() + ") ";
		
		String orgSql = BdEnvContextUtil.processEnvContext(new DeptDO(), false);
		if(!StringUtil.isEmpty(orgSql)){
			sql += " and " + orgSql + " ";
		}
		
		StringBuilder sb = new StringBuilder(sql);
		List<String> whereList = this.getWherePart();
		if (whereList.size() > 0) {
			for (String where : this.getWherePart()) {
				sb.append(" And (").append(where).append(") ");
			}
		}
		
		sb.append(" order by code ");
		
		return sb.toString();
	}
	
	/**
	 * 基数药仓库子查询
	 * @return
	 */
	private String getBaseWarehourseSql(){
		return "select distinct id_dep_belong from bd_wh where sd_whtp = '"
				+ IBdResDictCodeConst.SD_WHTP_JISHU + "' ";
	}
}
