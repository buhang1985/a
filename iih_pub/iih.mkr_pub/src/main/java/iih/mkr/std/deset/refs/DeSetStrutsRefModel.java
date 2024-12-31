package iih.mkr.std.deset.refs;

import java.util.List;

import ca.krasnay.sqlbuilder.SelectBuilder;
import iih.mkr.std.deset.d.DeDataSetDO;
import iih.mkr.utils.MkrEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 数据集参照模型
 * 
 * @author yy.zhao_2017年11月24日14:00:33
 *
 */
public class DeSetStrutsRefModel extends RefGridModel {

	@Override
	public String[] getShowFieldCode() {
		return new String[] { DeDataSetDO.CODE, DeDataSetDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { DeDataSetDO.ID_SET, DeDataSetDO.WBCODE,
				DeDataSetDO.PYCODE };
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { DeDataSetDO.CODE, DeDataSetDO.WBCODE,
				DeDataSetDO.PYCODE, DeDataSetDO.NAME, DeDataSetDO.MNECODE };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return DeDataSetDO.ID_SET;
	}

	@Override
	public String getTableName() {
		return new DeDataSetDO().getTableName();
	}

	@Override
	public String getRefCodeField() {
		return DeDataSetDO.CODE;

	}

	@Override
	public String getRefNameField() {
		return DeDataSetDO.NAME;
	}

	@Override
	public String getRefSql() {

		StringBuffer sqlStr = new StringBuffer();

		String IdPsndocs = (String) this.getExtendAttributeValue("Id_psndocs");

		if (IdPsndocs == null || IdPsndocs.length() < 1) {
			sqlStr.append(" select               													 ");
			sqlStr.append(" bd_set.code,bd_set.name,bd_set.id_set,bd_set.id_grp,bd_set.id_org,bd_set.des,bd_set.wbcode,bd_set.pycode,bd_set.mnecode,bd_set.id_setca,bd_set.innercode,bd_set.def1,bd_set.def2,bd_set.def3,bd_set.def4,bd_set.def5,bd_set.def6,bd_set.def7,bd_set.def8,bd_set.def9,bd_set.def10,bd_set.createdby,bd_set.createdtime,bd_set.modifiedby,bd_set.modifiedtime,bd_set.ds,bd_set.sv                                                                             ");
			sqlStr.append(" from bd_set bd_set   where 1=1          													 ");
		} else {
			sqlStr.append(" select   * from (                                                                    ");
			sqlStr.append(" select                                                                               ");
			sqlStr.append(" bdset.code,bdset.name,bdset.id_set,bdset.id_grp,bdset.id_org,bdset.des,bdset.wbcode,bdset.pycode,bdset.mnecode,bdset.id_setca,bdset.innercode,bdset.def1,bdset.def2,bdset.def3,bdset.def4,bdset.def5,bdset.def6,bdset.def7,bdset.def8,bdset.def9,bdset.def10,bdset.createdby,bdset.createdtime,bdset.modifiedby,bdset.modifiedtime,bdset.ds,bdset.sv                                                                             ");
			sqlStr.append(" from sys_paramreg paramreg                                                           ");
			sqlStr.append(" inner join sys_funcreg func on func.id_fun=paramreg.id_parent                        ");
			sqlStr.append(" inner join sys_resp_func resp on resp.biz_id=func.code                               ");
			sqlStr.append(" inner join bd_set bdset on bdset.id_set=paramreg.paramvalue                          ");
			sqlStr.append(" where resp.id_resp in                                                                ");
			sqlStr.append(" (                                                                                    ");
			sqlStr.append("   select orgresp.id_resp                                                             ");
			sqlStr.append("   from sys_org_resp orgresp                                                          ");
			sqlStr.append("   inner join sys_subject_org suborg on suborg.id_subjectorg = orgresp.id_subjectorg  ");
			sqlStr.append("   inner join sys_user sysuser on sysuser.id_user = suborg.subjectid                  ");
			sqlStr.append("   where sysuser.id_psn in(" + IdPsndocs
					+ ")                                             ");
			sqlStr.append("   UNION                                                                              ");
			sqlStr.append("   select id_resp                                                                     ");
			sqlStr.append("   from sys_func_permcfg funcper                                                      ");
			sqlStr.append("   inner join sys_user sysuser on sysuser.id_user = funcper.subjectid                 ");
			sqlStr.append("   where sysuser.id_psn in(" + IdPsndocs
					+ ")                                             ");
			sqlStr.append("   UNION                                                                              ");
			sqlStr.append("   select orgresp.id_resp                                                             ");
			sqlStr.append("   from sys_org_resp orgresp                                                          ");
			sqlStr.append("   inner join sys_subject_org suborg on suborg.id_subjectorg = orgresp.id_subjectorg  ");
			sqlStr.append("   inner join sys_user_role userrole on userrole.id_role = suborg.subjectid           ");
			sqlStr.append("   inner join sys_user sysuser on sysuser.id_user = userrole.id_user                  ");
			sqlStr.append("   where sysuser.id_psn in(" + IdPsndocs
					+ ")                                             ");
			sqlStr.append("   UNION                                                                              ");
			sqlStr.append("   select id_resp                                                                     ");
			sqlStr.append("   from sys_func_permcfg funcper                                                      ");
			sqlStr.append("   inner join sys_user_role userrole on userrole.id_role = funcper.subjectid          ");
			sqlStr.append("   inner join sys_user sysuser on sysuser.id_user = userrole.id_user                  ");
			sqlStr.append("   where sysuser.id_psn in(" + IdPsndocs
					+ ")                                             ");
			sqlStr.append(" )                                                                                    ");
			sqlStr.append(" ) bd_set   where 1=1                                                                                ");
		}

		List<String> whereList = this.getWherePart();
		if (whereList.size() > 0) {
			for (String where : whereList) {
				sqlStr.append(" and (").append(where).append(") ");
			}
		}

		List<String> orderList = this.getOrderPart();
		if (orderList.size() > 0) {
			sqlStr.append(" order by ");
			for (int i = 0; i < orderList.size(); i++) {
				String order = orderList.get(i);
				sqlStr.append((i == 0 ? "" : ",") + order);
			}
		}
		return sqlStr.toString();
	}

	/**
	 * 构建条件语句
	 * 
	 * @return
	 */
	private String BuildWherePart() {
		StringBuilder stringBuilder = new StringBuilder("1 = 1");
		String BdModeWherePart = MkrEnvContextUtil.processEnvContext(
				new DeDataSetDO(), false);
		stringBuilder.append(String.format(" and %s ", BdModeWherePart));
		return stringBuilder.toString();
	}

	/**
	 * 构建排序语句
	 * 
	 * @return
	 */
	private String BuildOrderPart() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(String.format("%s", DeDataSetDO.CODE));
		return stringBuilder.toString();
	}
}
