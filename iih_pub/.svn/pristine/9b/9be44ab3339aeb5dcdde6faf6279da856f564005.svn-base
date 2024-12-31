package iih.sc.scbd.scdeptparam.refs;

import java.util.List;

import iih.sc.pub.ScGroupControlUtils;
import iih.sc.scbd.scapptrule.d.ScapptruleDO;
import iih.sc.scbd.scdeptparam.d.ScDeptParamDO;
import xap.mw.core.data.Context;
import xap.sys.appfw.refinfo.RefGridModel;

public class ScDepParamRefModel extends RefGridModel {

	@Override
	public String[] getShowFieldCode() {
		return new String[] { "name_ver" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { ScDeptParamDO.ID_DEPTPARAM,ScDeptParamDO.VER,ScDeptParamDO.D_BEGIN,ScDeptParamDO.D_END };
	}

	@Override
	public String getRefSql() {
		String sql = "select * from (select 'V'||sc_dep_param.ver||'('||sc_dep_param.d_begin||'~'||sc_dep_param.d_end||')' as name_ver,sc_dep_param.*  from sc_dep_param  order by sc_dep_param.ver desc )sc_dep_param";
		StringBuilder sb = new StringBuilder(sql);
		sb.append(" where 1=1 ");
		List whereList = getWherePart();
		if (whereList.size() > 0) {
			for (String where : getWherePart()) {
				sb.append(" And (").append(where).append(") ");
			}
		}
		return sb.toString();
//		return	super.getRefSql();
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "版本" };
	}

	@Override
	public String getPkFieldCode() {
		return ScDeptParamDO.ID_DEPTPARAM;
	}

	@Override
	public String getRefNameField() {
		return "name_ver";
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return new ScDeptParamDO().getTableName();
	}

	@Override
	public List<String> getWherePart() {
		List<String> where = super.getWherePart();
		//增加集团管控
		where.add(ScGroupControlUtils.getGroupControlFitler(new ScapptruleDO(), "sc_dep_param"));
		where.add("Id_dep='" + Context.get().getDeptId() + "'");
		where.add(ScDeptParamDO.EU_STATUS + "='1'");
		return where;
	}
}
