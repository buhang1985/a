package iih.sc.scbd.schedulesrv.refs;

import java.util.ArrayList;
import java.util.List;

import iih.sc.pub.ScGroupControlUtils;
import iih.sc.scbd.schedulesrv.d.ScheduleSrvDO;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 口腔预约号别参照模型
 * 
 * @author zhengcm
 * @date 2017-01-09 19:47:40
 *
 */
public class OralScSrvRefModel extends RefGridModel {

	@Override
	public String[] getShowFieldCode() {
		return new String[] { ScheduleSrvDO.CODE, ScheduleSrvDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { ScheduleSrvDO.ID_SCSRV, ScheduleSrvDO.NOTE };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return ScheduleSrvDO.ID_SCSRV;
	}

	@Override
	public String getRefCodeField() {
		return ScheduleSrvDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return ScheduleSrvDO.NAME;
	}

	@Override
	public String getTableName() {
		return new ScheduleSrvDO().getTableName();
	}

	/*
	 * 拼音、五笔、助记码 过滤
	 */
	@Override
	public String[] getBlurFields() {
		return new String[] { "pycode", "wbcode", "mnecode", "code", "name" };
	}
	/**
	 * 重写条件
	 */
	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = new ArrayList<String>();
		listWhereParts.addAll(super.getWherePart());
		//增加集团管控
		listWhereParts.add(ScGroupControlUtils.getGroupControlFitler(new ScheduleSrvDO(), false));
		return listWhereParts;
	}
	@Override
	public String getRefSql() {
		// 获取过滤参数
		String id_scpl = (String) getExtendAttributeValue("id_scpl");
		if (!StringUtil.isEmptyWithTrim(id_scpl)) {
			StringBuilder sb = new StringBuilder();
			sb.append("select code,name,id_scsrv ");
			sb.append("from " + new ScheduleSrvDO().getTableName() + " ");
			sb.append("where 1 = 1 and id_scsrv in ");
			sb.append("(select id_scsrv from sc_pl where id_scpl = '" + id_scpl + "' ");
			sb.append("union ");
			sb.append("select id_scsrv from sc_pl_optsrv where id_scpl = '" + id_scpl + "')");
			List<String> whereList = this.getWherePart();
			if (!ListUtil.isEmpty(whereList)) {
				for (String where : this.getWherePart()) {
					sb.append(" and (").append(where).append(") ");
				}
			}
			// 排序
			sb.append("order by code ");
			return sb.toString();
		} else {
			return super.getRefSql() + " order by sc_srv.code ";
		}

	}

}
