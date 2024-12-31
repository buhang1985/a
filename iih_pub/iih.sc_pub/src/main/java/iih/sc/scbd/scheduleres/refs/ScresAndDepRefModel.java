package iih.sc.scbd.scheduleres.refs;

import java.util.ArrayList;
import java.util.List;

import iih.sc.pub.ScGroupControlUtils;
import iih.sc.scbd.scheduleres.d.ScheduleResDO;
import xap.sys.appfw.refinfo.RefGridModel;

/**周立明专用排班资源参照模型
 * @author zlm
 *
 */
public class ScresAndDepRefModel extends RefGridModel {
	@Override
	public String[] getShowFieldCode() {
		return new String[] { ScheduleResDO.CODE, ScheduleResDO.NAME, ScheduleResDO.NAME_DEPT };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { ScheduleResDO.ID_SCRES, ScheduleResDO.SD_SCRESTP, ScheduleResDO.SD_SCTP,ScheduleResDO.ID_DEP,ScheduleResDO.FG_ACTIVE,ScheduleResDO.DS,ScheduleResDO.ID_SCCA };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称", "科室" };
	}

	@Override
	public String getPkFieldCode() {
		return ScheduleResDO.ID_SCRES;
	}

	@Override
	public String getRefCodeField() {
		return "Code";
	}

	@Override
	public String getRefNameField() {
		return "Name";
	}
	
	/* 
	 *  拼音、五笔、助记码 过滤
	 */
	@Override
	public String[] getBlurFields() {
		return new String[]{ScheduleResDO.PYCODE,ScheduleResDO.WBCODE,ScheduleResDO.MNECODE,ScheduleResDO.CODE, ScheduleResDO.NAME, ScheduleResDO.NAME_DEPT};
	}

	/**
	 * 重写条件
	 */
	@Override
	public List<String> getWherePart() {
		List<String> whereParts = new ArrayList<String>();
		whereParts.addAll(super.getWherePart());
		//增加集团管控
		whereParts.add(ScGroupControlUtils.getGroupControlFitler(new ScheduleResDO(), "sc_res"));
		return whereParts;
	}
	
	@Override
	public String getRefSql() {

		StringBuffer sql = new StringBuffer();
		sql.append("select * from(");
		sql.append("select res.code,res.name,dep.name as name_dept,res.Id_scres,res.sd_screstp,res.sd_sctp,res.id_dep,res.fg_active,res.ds,res.id_scca,res.mnecode,res.pycode,res.wbcode,res.id_grp,res.id_org,res.id_emp ");
		sql.append("from sc_res res ");
		sql.append("left join bd_dep dep on res.id_dep = dep.id_dep )sc_res ");
		sql.append("where 1=1 ");

		List<String> whereList = this.getWherePart();

		if (whereList!=null && whereList.size() > 0) {

			for (String where : whereList) {

				sql.append(" And (").append(where).append(") ");
			}
		}
		sql.append(" order by Code");
		return sql.toString();
	}
	
	@Override
	public String getTableName() {
		return new ScheduleResDO().getTableName();
	}
}
