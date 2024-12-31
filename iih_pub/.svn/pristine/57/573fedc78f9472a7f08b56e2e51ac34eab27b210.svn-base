package iih.bd.res.warehouse.refs;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.IBdResDictCodeConst;
import iih.bd.res.warehouse.d.WarehouseDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.mw.core.data.Context;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.refinfo.RefTreeModel;
import xap.sys.dataper.i.IDataperExtQry;
import xap.sys.permfw.dataper.d.DataPerRuleDO;

@SuppressWarnings("serial")
public class EmsWareHouseRefModel extends RefTreeModel {
	@Override
	public String[] getShowFieldCode() {
		return new String[] { WarehouseDO.CODE, WarehouseDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { WarehouseDO.ID_WH, WarehouseDO.ID_CYCLEU, WarehouseDO.SD_CYCLEU, WarehouseDO.FG_LOC,
				WarehouseDO.ID_PARENT, WarehouseDO.INNERCODE,WarehouseDO.ID_DEP_BELONG };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return WarehouseDO.ID_WH;
	}

	@Override
	public String getRefCodeField() {
		return WarehouseDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return WarehouseDO.NAME;
	}

	@Override
	public String getTableName() {
		return new WarehouseDO().getTableName();
	}

	@Override
	public String getFatherField() {
		return WarehouseDO.ID_PARENT;
	}

	@Override
	public String getChildField() {
		return WarehouseDO.ID_WH;
	}

	@Override
	public String getRefSql() {
		String wherePart = BuildWherePart();
		String orderPart = BuildOrderPart();
		String refSql;
		try {
			if(wherePart != null && !"".equals(wherePart))  {this.getWherePart().add(wherePart);}
			if(orderPart != null && !"".equals(orderPart))  {this.getOrderPart().add(orderPart);}
			refSql = super.getRefSql();

		} finally {
			if(wherePart != null && !"".equals(wherePart))  {this.getWherePart().remove(wherePart);}
			if(orderPart != null && !"".equals(orderPart))  {this.getOrderPart().remove(orderPart);}
		}

		return refSql;
	}

	/**
	 * 构建条件语句
	 * 
	 * @return
	 */
	private String BuildWherePart() {

		StringBuilder stringBuilder = new StringBuilder("1 = 1");
		stringBuilder.append(" and fg_active = 'Y' and fg_last = 'Y'  and sd_whtp = '13' ");
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new WarehouseDO(), false);
		stringBuilder.append(String.format(" and %s ", BdModeWherePart));

		String id_wh_list = (String) this.getExtendAttributeValue("id_wh_list");
		if (!StringUtils.isBlank(id_wh_list)) {
			stringBuilder.append(" and id_wh in " + id_wh_list);
		}

		// TODO
		// 所有仓库列表单独走数据权限， 不与部门挂钩
		String id_dep_belong = (String) this.getExtendAttributeValue("id_dep_belong");
		if (!StringUtils.isBlank(id_dep_belong)) {
			stringBuilder.append(" and id_dep_belong = '" + id_dep_belong + "'");
		}
		

		this.setDataper(stringBuilder);

		return stringBuilder.toString();
	}

	/**
	 * 构建排序语句
	 * 
	 * @return
	 */
	private String BuildOrderPart() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(String.format("%s", WarehouseDO.CODE));
		return stringBuilder.toString();
	}

	private void setDataper(StringBuilder wherePartBuffer) {
		String funcode = (String) this.getExtendAttributeValue("funcode");

		if (StringUtils.isBlank(funcode)) {
			return;
		}

		IDataperExtQry ideq = ServiceFinder.find(IDataperExtQry.class);
		String whereSql = "";

		try {
			List<DataPerRuleDO> listruledo = ideq.getSysDataperRuleByUserRole(Context.get().getUserId(), funcode);
			if (listruledo != null && listruledo.size() > 0) {
				DataPerRuleDO ruleDo = listruledo.get(0);
				whereSql = ideq.getwhere(ruleDo);
			}

		} catch (Throwable e) {
			e.printStackTrace();
		}

		if (!StringUtils.isBlank(whereSql)) {
			wherePartBuffer.append(" and " + whereSql + " ");
		}
	}

	@Override
	public String afterBuilderSql(String sql) {
		return super.afterBuilderSql(sql);
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { WarehouseDO.NAME, WarehouseDO.CODE, WarehouseDO.PYCODE, WarehouseDO.WBCODE,
				WarehouseDO.MNECODE };
	}

}
