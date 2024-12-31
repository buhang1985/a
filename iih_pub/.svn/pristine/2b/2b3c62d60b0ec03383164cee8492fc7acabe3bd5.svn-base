package iih.en.out.refs;

import iih.bd.base.utils.SqlUtils;
import iih.sc.scbd.scdeptparam.d.desc.ScDeptParamDODesc;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.refinfo.RefTreeModel;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.d.desc.DeptDODesc;
import xap.sys.permfw.pub.EnvContextUtil;

/**
 * 部门排班参数参照
 * 
 * @author liubin
 *
 */
public class DeptScParamRefModel extends RefTreeModel {

	private static final long serialVersionUID = 1L;
	
	@Override
	public String[] getShowFieldCode() {
		return new String[] {DeptDO.CODE, DeptDO.NAME};
	}
	
	@Override
	public String[] getHiddenFieldCode() {
		return new String[]{DeptDO.ID_DEP, DeptDO.ID_PARENT, DeptDO.INNERCODE};
	}
	
	@Override
	public String[] getShowFieldName() {
		return new String[] {"部门编码", "部门名称"};
	}
	
	@Override
	public String getPkFieldCode() {
		return DeptDO.ID_DEP;
	}
	
	@Override
	public String getChildField() {
		return DeptDO.ID_DEP;
	}
	
	@Override
	public String getFatherField() {
		return DeptDO.ID_PARENT;
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
	public String[] getBlurFields() {
		return new String[] {DeptDO.CODE, DeptDO.NAME, DeptDO.PYCODE, DeptDO.WBCODE, DeptDO.MNECODE};
	}
	
	@Override
	public String getTableName() {
		return DeptDODesc.TABLE_NAME;
	}
	
	@Override
	public List<String> getOrderPart() {
		List<String> list = new ArrayList<String>();
		list.add(DeptDO.CODE);
		return list;
	}
	
	@Override
	public String getRefSql() {
		//科室类型
		FArrayList sddepttp = (FArrayList) getExtendAttributeValue("sddepttp");
		//科室集合
		FArrayList depIds = (FArrayList) getExtendAttributeValue("depIds");
		//排班类型
		FArrayList sctps = (FArrayList) getExtendAttributeValue("sctps");
		
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" SELECT BD_DEP.CODE, ");
		sqlBuilder.append(" BD_DEP.NAME, ");
		sqlBuilder.append(" BD_DEP.ID_DEP, ");
		sqlBuilder.append(" BD_DEP.ID_PARENT, ");
		sqlBuilder.append(" BD_DEP.INNERCODE ");
		sqlBuilder.append(" FROM BD_DEP ");
		sqlBuilder.append(" WHERE BD_DEP.ACTIVESTATE = '2' ");
		String orgSql = EnvContextUtil.processEnvContext(null, new DeptDODesc(), "BD_DEP");
		if(!StringUtil.isEmptyWithTrim(orgSql)){
			sqlBuilder.append(" AND ").append(orgSql);
		}
		if(!ListUtil.isEmpty(sddepttp)){
			sqlBuilder.append(SqlUtils.getInSqlByIds(" AND BD_DEP.SD_DEPTTP ", sddepttp));
		}
		if(!ListUtil.isEmpty(depIds)){
			sqlBuilder.append(SqlUtils.getInSqlByIds(" AND BD_DEP.ID_DEP ", depIds));
		}
		sqlBuilder.append(" AND EXISTS ( SELECT * FROM SC_DEP_PARAM SCPARAM WHERE SCPARAM.EU_STATUS = '1' AND BD_DEP.ID_DEP = SCPARAM.ID_DEP ");
		orgSql = EnvContextUtil.processEnvContext(null, new ScDeptParamDODesc(), "SCPARAM");
		if(!StringUtil.isEmptyWithTrim(orgSql)){
			sqlBuilder.append(" AND ").append(orgSql);
		}
		if(!ListUtil.isEmpty(sctps)){
			sqlBuilder.append(SqlUtils.getInSqlByIds(" AND SCPARAM.SD_SCTP ", sctps));
		}
		sqlBuilder.append(" )");
		
		List<String> whereList = getWherePart();
		if (!ListUtil.isEmpty(whereList)) {
			for (String where : whereList) {
				sqlBuilder.append(" AND (").append(where).append(") ");
			}
		}
		List<String> orderList = getOrderPart();
		if (!ListUtil.isEmpty(orderList)) {
			sqlBuilder.append(" ORDER BY ");
			boolean isFirst = true;
			for (String order : orderList) {
				if(isFirst){
					isFirst = false;
				}else{
					sqlBuilder.append(", ");
				}
				sqlBuilder.append(order);
			}
		}
		return sqlBuilder.toString();
	}
}
