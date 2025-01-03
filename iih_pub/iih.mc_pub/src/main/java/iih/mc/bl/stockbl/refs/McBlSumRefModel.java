package iih.mc.bl.stockbl.refs;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import iih.bd.res.warehouse.d.WarehouseDO;
import iih.bd.res.warehouse.i.IWarehouseService;
import iih.mc.common.params.McParams;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 耗材结存参照模型(按耗材名称汇总，不分批次)
 * 
 * @author chma 2019-03-11
 *
 */
public class McBlSumRefModel extends RefGridModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { "name_mm", "name_fac", "spec", "name_pkgu", "quan_usable", "code_mm" };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "耗材名称", "生产厂商", "规格","单位","可用数量", "耗材编码" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { "id_mm" };
	}

	@Override
	public String getPkFieldCode() {
		return "id_mm";
	}

	@Override
	public String getRefCodeField() {
		return "name_wh";
	}

	@Override
	public String getRefNameField() {
		return "name_mm";
	}

	@Override
	public String getTableName() {
		return "storebl";
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { "code_mm", "name_mm", "pycode_mm", "wbcode_mm", "mnecode_mm" };
	}

	@Override
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

			
			//参照物品是否按结存查询，结存中有则显示没有不显示 ，可以通过组织参数 变为 只要耗材库与物品关系中维护了就显示
			try {
				int mcBlRef = McParams.MCBLREF1();
				if(mcBlRef == 1)
				{
					String whId = (String) this.getExtendAttributeValue("id_wh");
					sqlBuilder = getAllMM(whId,sqlBuilder);
				}else{
					List<String> wherePartList = this.getWherePart();
					if (wherePartList != null && wherePartList.size() > 0) {
						wherePart = StringUtils.join(wherePartList, " and ");
						sqlBuilder.append(" where ");
						sqlBuilder.append(wherePart);
					}
				}
			} catch (BizException e) {
				
				e.printStackTrace();
			}
			

			List<String> orderPartList = this.getOrderPart();
			if (orderPartList != null && orderPartList.size() > 0) {
				orderPart = StringUtils.join(orderPartList, " and ");
				sqlBuilder.append(" order by ");
				sqlBuilder.append(orderPart);
			}

		} finally {
			if (wherePart != null && !"".equals(wherePart)) {
			//	this.getWherePart().remove(wherePart);
			}
			if (orderPart != null && !"".equals(orderPart)) {
			//	this.getOrderPart().remove(orderPart);
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
		sqlBuilder.append("SELECT ");
		sqlBuilder.append("name_mm,");
		sqlBuilder.append("name_fac,");
		sqlBuilder.append("spec,");
		
		sqlBuilder.append("name_pkgu,");
	
		sqlBuilder.append("quan_usable,");
		sqlBuilder.append("code_mm,id_mm, ");
		sqlBuilder.append("pycode_mm,");
		sqlBuilder.append("wbcode_mm,");
		sqlBuilder.append("mnecode_mm ");
		sqlBuilder.append(",id_wh ");
		sqlBuilder.append("FROM (");
		sqlBuilder.append("SELECT mm.id_mm,");
		sqlBuilder.append("wh.name AS name_wh, ");
		sqlBuilder.append("mm.name AS name_mm, ");
		sqlBuilder.append("fac.name AS name_fac, ");
		sqlBuilder.append("mm.spec AS spec,");
		sqlBuilder.append("pkgu.name AS name_pkgu, ");
		sqlBuilder.append("sum(ROUND(MMBL.QUAN_USABLEACT,2)) AS quan_usable, ");
		sqlBuilder.append("mm.code AS code_mm, ");
		sqlBuilder.append("MM.PYCODE AS pycode_mm, ");
		sqlBuilder.append("MM.WBCODE AS wbcode_mm, ");
		sqlBuilder.append("MM.MNECODE AS mnecode_mm, ");
		sqlBuilder.append("WH.ID_WH AS ID_WH ");
		sqlBuilder.append("FROM V_MC_BL_QUERY mmbl ");
		sqlBuilder.append("INNER JOIN bd_wh wh ");
		sqlBuilder.append("ON wh.id_wh = mmbl.id_wh ");
		sqlBuilder.append("INNER JOIN bd_mm mm ");
		sqlBuilder.append("ON mm.id_mm = mmbl.id_mm ");
		sqlBuilder.append("LEFT JOIN bd_sup fac ");
		sqlBuilder.append("ON fac.id_sup = mmbl.id_sup ");
		sqlBuilder.append("INNER JOIN BD_MM_PKGU mmpkgu ");
		sqlBuilder.append("ON MMPKGU.ID_MMPKGU = MMBL.ID_UNIT_PKGACT ");
		sqlBuilder.append("INNER JOIN bd_measdoc pkgu ");
		sqlBuilder.append("ON pkgu.id_measdoc = MMPKGU.ID_UNIT_PKG ");
		sqlBuilder.append("WHERE ROUND(MMBL.QUAN_USABLEACT,2) > 0 ");
		sqlBuilder.append("group by mm.id_mm,");
		sqlBuilder.append("wh.name , ");
		sqlBuilder.append("mm.name , ");
		sqlBuilder.append("fac.name ,");
		sqlBuilder.append("mm.spec,");
		sqlBuilder.append("pkgu.name,");
		sqlBuilder.append("mm.code,");
		sqlBuilder.append("MM.PYCODE,");
		sqlBuilder.append("MM.WBCODE,");
		sqlBuilder.append("MM.MNECODE, ");
		sqlBuilder.append("WH.ID_WH");
		sqlBuilder.append(") storebl ");
		return sqlBuilder.toString();
	}

	/**
	 * 构建条件语句
	 * 
	 * @return
	 */
	private String BuildWherePart() {
		StringBuilder stringBuilder = new StringBuilder("1 = 1");

		String whId = (String) this.getExtendAttributeValue("id_wh");
		String wherePartStr = (String) this.getExtendAttributeValue("WherePart");

		if (StringUtils.isEmpty(whId)) {
			// 仓库为空时，尝试根据当前科室获取仓库
			whId = findWhIdByContextDep();
		}

		if (StringUtils.isNotEmpty(whId)) {
			// 过滤为指定仓库
			String wherePart = String.format(" and id_wh = '%s'", whId);
			stringBuilder.append(wherePart);
		} 
		else {
			stringBuilder.append(" and 1 = 2");
		}

		if (StringUtils.isNotEmpty(wherePartStr)) {
			stringBuilder.append(" and ");
			stringBuilder.append(wherePartStr);
		}

		return stringBuilder.toString();
	}

	/**
	 * 根据当前科室获取仓库主键
	 * 
	 * @return
	 */
	private String findWhIdByContextDep() {
		try {
			String depId = Context.get().getDeptId();
			IWarehouseService warehouseService = ServiceFinder.find(IWarehouseService.class);
			WarehouseDO warehouseDO = warehouseService.findOwerWhByDepId(depId, FBoolean.FALSE);
			return warehouseDO.getId_wh();
		} catch (Exception e) {
		}
		return null;
	}

	/**
	 * 构建排序语句
	 * 
	 * @return
	 */
	private String BuildOrderPart() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("pycode_mm");
		return stringBuilder.toString();
	}
	
	private StringBuilder getAllMM(String id_wh ,StringBuilder sqlBuilder)
	{
		StringBuilder newBuilder = new StringBuilder();
		newBuilder.append(" select name_mm,name_fac,spec,name_pkgu,sum(quan_usable),code_mm,id_mm,pycode_mm,wbcode_mm,mnecode_mm from (");

		
		
		
		sqlBuilder.append(" union ");
		sqlBuilder.append(" select distinct BD_MM.Name name_mm, ");
		sqlBuilder.append(" BD_MM.Sup_name name_fac, ");
		sqlBuilder.append(" BD_MM.Spec spec, ");
		sqlBuilder.append(" BD_MM.Name_unit_pkgbase name_pkgu, ");
		sqlBuilder.append(" 0 quan_usable, ");
		sqlBuilder.append(" BD_MM.Code code_mm, ");
		sqlBuilder.append(" BD_MM.Id_mm id_mm, ");
		sqlBuilder.append(" BD_MM.Pycode pycode_mm, ");
		sqlBuilder.append(" BD_MM.Wbcode wbcode_mm, ");
		sqlBuilder.append(" BD_MM.Mnecode mnecode_mm, ");
		sqlBuilder.append(" MMWH.Id_wh ");
		sqlBuilder.append(" from BD_MM BD_MM,BD_MM_WH MMWH ");
		sqlBuilder.append(" where  ");
		sqlBuilder.append(" BD_MM.fg_active = 'Y'  ");
		sqlBuilder.append(" and BD_MM.ds = 0 and  ");
		sqlBuilder.append(" BD_MM.sd_mmtp like '3%' and ");
		sqlBuilder.append(" BD_MM.id_mm = MMWH.id_mm  and ");
		sqlBuilder.append(" MMWH.id_wh = '"+id_wh+"' AND　MMWH.fg_active = 'Y' ");
		sqlBuilder.append(" AND MMWH.ds = 0) storebl ");
		List<String> wherePartList = this.getWherePart();
		if (wherePartList != null && wherePartList.size() > 0) {
			String wherePart = StringUtils.join(wherePartList, " and ");
			sqlBuilder.append(" where ");
			sqlBuilder.append(wherePart);
		}
		newBuilder.append(sqlBuilder);
		newBuilder.append("  group by name_mm,name_fac,spec,name_pkgu,code_mm,id_mm,pycode_mm,wbcode_mm,mnecode_mm");
		return newBuilder;
	}
	
}
