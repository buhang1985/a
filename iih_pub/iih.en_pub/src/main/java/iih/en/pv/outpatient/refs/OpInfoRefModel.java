package iih.en.pv.outpatient.refs;

import java.util.ArrayList;
import java.util.List;

import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.sc.pub.ScGroupControlUtils;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 门诊参照模型
 * 
 * @author yank
 *
 */
public class OpInfoRefModel extends RefGridModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1709837864968328910L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { "CODE_ENT", "NAME_PAT", "NAME_DEP", "DT_ENTRY" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { "DT_ACPT", "SD_STATUS", "ID_ENT", "ID_PAT", "ID_DEP", "CODE_DEP" };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "就诊编码", "患者姓名", "就诊科室", "就诊日期" };
	}

	@Override
	public String getPkFieldCode() {
		return "ID_ENT";
	}

	@Override
	public String getRefCodeField() {
		return "CODE_ENT";
	}

	@Override
	public String getRefNameField() {
		return "NAME_PAT";
	}

	@Override
	public String getTableName() {
		return "ENT_OP";
	}
	/**
	 * 重写条件
	 */
	@Override
	public List<String> getWherePart() {
		List<String> whereParts = new ArrayList<String>();
		whereParts.addAll(super.getWherePart());
		//增加集团管控
		whereParts.add(ScGroupControlUtils.getGroupControlFitler(new PatiVisitDO(), "ENT_OP"));
		return whereParts;
	}
	@Override
	public String getRefSql() {
		String depId = (String) this.getExtendAttributeValue("depId");// 就诊科室
		String sd_status = (String) this.getExtendAttributeValue("sd_status");// 就诊状态

		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT * FROM (");
		sqlBuilder.append("SELECT ENT.CODE CODE_ENT,ENT.NAME_PAT,DEP.NAME AS NAME_DEP,");
		sqlBuilder.append("SUBSTR(ENT.DT_ENTRY,0,10) AS DT_ENTRY,ENT.DT_ACPT,");
		sqlBuilder.append("CASE OP.SD_STATUS WHEN '01' THEN '预约' WHEN '02' THEN '挂号' ");
		sqlBuilder.append("WHEN '05' THEN '就诊' WHEN '08' THEN '诊毕' ELSE '未知' END AS SD_STATUS,");
		sqlBuilder.append("ENT.ID_GRP,ENT.ID_ORG,");//增加集团组织条件
		sqlBuilder.append("ENT.ID_ENT,ENT.ID_PAT,ID_DEP_PHY AS ID_DEP,DEP.CODE AS CODE_DEP ");
		sqlBuilder.append("FROM EN_ENT ENT ");
		sqlBuilder.append("INNER JOIN EN_ENT_OP OP ON ENT.ID_ENT=OP.ID_ENT ");
		sqlBuilder.append("LEFT JOIN BD_DEP DEP ON DEP.ID_DEP=ENT.ID_DEP_PHY ");
		sqlBuilder.append(") ENT_OP ");
		sqlBuilder.append("WHERE 1=1 ");

		if (!StringUtil.isEmpty(depId)) {
			sqlBuilder.append(" AND ID_DEP='" + depId + "'");// 就诊科室
		}
		if (!StringUtil.isEmpty(sd_status)) {
			sqlBuilder.append(" AND SD_STATUS='" + sd_status + "'");// 就诊状态
		}

		List<String> whereList = this.getWherePart();
		if (whereList.size() > 0) {
			for (String where : this.getWherePart()) {
				sqlBuilder.append(" And (").append(where).append(") ");
			}
		}

		return sqlBuilder.toString();
	}

	/**
	 * 模糊检索 支持就诊编码、患者姓名、科室名称
	 * 
	 * @return
	 */
	@Override
	public String[] getBlurFields() {
		return new String[] { "CODE_ENT", "NAME_PAT", "NAME_DEP" };
	}
}
