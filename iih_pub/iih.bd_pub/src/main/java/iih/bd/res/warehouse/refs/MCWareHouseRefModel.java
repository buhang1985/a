package iih.bd.res.warehouse.refs;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import iih.bd.res.warehouse.d.WarehouseDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.mw.core.data.Context;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.refinfo.RefTreeModel;
import xap.sys.dataper.i.IDataperExtQry;
import xap.sys.permfw.dataper.d.DataPerRuleDO;

@SuppressWarnings("serial")
public class MCWareHouseRefModel extends RefTreeModel {
	@Override
	public String[] getShowFieldCode() {
		return new String[] { WarehouseDO.CODE, WarehouseDO.NAME, WarehouseDO.WHTP_NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { WarehouseDO.ID_WH, WarehouseDO.ID_CYCLEU, WarehouseDO.SD_CYCLEU, WarehouseDO.FG_LOC,
				WarehouseDO.ID_PARENT, WarehouseDO.INNERCODE,WarehouseDO.ID_DEP_BELONG,"Eu_mmca" };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称", "库分类" };
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

	/*@Override
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
	}*/
	public String getRefSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		String wherePart = BuildWherePart();
		String orderPart = BuildOrderPart();

		try {
			if (StringUtils.isNotEmpty(wherePart)) {
				this.getWherePart().add(wherePart);
			}
			if (StringUtils.isNotEmpty(orderPart)) {
				this.getOrderPart().add(orderPart);
			}

			String baseSql = getBaseSql();
			sqlBuilder.append(baseSql);

			List<String> wherePartList = this.getWherePart();
			if (wherePartList != null && wherePartList.size() > 0) {
				wherePart = StringUtils.join(wherePartList, " and ");
				sqlBuilder.append(" where ");
				sqlBuilder.append(wherePart);
			}

			List<String> orderPartList = this.getOrderPart();
			if (orderPartList != null && orderPartList.size() > 0) {
				orderPart = StringUtils.join(orderPartList, " and ");
				sqlBuilder.append(" order by ");
				sqlBuilder.append(orderPart);
			}

		} finally {
			if (wherePart != null && !"".equals(wherePart)) {
				this.getWherePart().remove(wherePart);
			}
			if (orderPart != null && !"".equals(orderPart)) {
				this.getOrderPart().remove(orderPart);
			}
		}

		return sqlBuilder.toString();
	}
	
	/**
	 * 获取基础SQL
	 * 
	 * @return
	 */
	private String getBaseSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("select bd_wh.Code,");
		sqlBuilder.append("bd_wh.Name,");	
		sqlBuilder.append("(case bd_wh.sd_whtp when '11' then '低值库' when '12' then '高值库'  end) as Whtp_name,");
		sqlBuilder.append("bd_wh.Id_wh,");
		sqlBuilder.append("bd_wh.Id_cycleu,");
		sqlBuilder.append("bd_wh.Sd_cycleu,");
		sqlBuilder.append("bd_wh.Fg_loc,");
		sqlBuilder.append("bd_wh.Id_parent,");
		sqlBuilder.append("bd_wh.Innercode,");
		sqlBuilder.append("bd_wh.Id_dep_belong,");
		sqlBuilder.append("(case bd_wh.sd_whtp when '11' then 1 when '12' then 2  end) as Eu_mmca");
		sqlBuilder.append(" from bd_wh bd_wh ");
		return sqlBuilder.toString();
	}

	/**
	 * 构建条件语句
	 * 
	 * @return
	 */
	private String BuildWherePart() {

		StringBuilder stringBuilder = new StringBuilder("1 = 1");
		stringBuilder.append(" and sd_whtp in ('11','12') and fg_active = 'Y' and fg_last = 'Y' ");
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new WarehouseDO(), false);
		stringBuilder.append(String.format(" and %s ", BdModeWherePart));

		String id_wh_list = (String) this.getExtendAttributeValue("id_wh_list");
		if (!StringUtils.isBlank(id_wh_list)) {
			stringBuilder.append(" and id_wh in " + id_wh_list);
		}

		String sd_whtp = (String) this.getExtendAttributeValue("sd_whtp");
		if (!StringUtils.isBlank(sd_whtp)) {
			stringBuilder.append(" and sd_whtp = '" + sd_whtp + "' ");
		}

		String sd_whtp_list = (String) this.getExtendAttributeValue("sd_whtp_list");
		if (!StringUtils.isBlank(sd_whtp_list)) {
			stringBuilder.append(" and sd_whtp in " + sd_whtp_list + " ");
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
