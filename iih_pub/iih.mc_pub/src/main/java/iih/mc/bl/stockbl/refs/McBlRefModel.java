package iih.mc.bl.stockbl.refs;

import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.res.warehouse.d.WarehouseDO;
import iih.bd.res.warehouse.i.IWarehouseService;
import iih.mc.common.params.McParams;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 耗材结存参照模型
 * 
 * @author chma 2019-03-11
 *
 */
public class McBlRefModel extends RefGridModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { "name_wh","mmca_name", "name_mm", "name_fac", "spec", "batch", "date_expi", "name_pkgu", "pri_sa",
				"pri_act", "quan_usable", "code_mm"};
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "仓库名称","耗材分类", "耗材名称", "生产厂商", "规格", "批次", "有效期", "单位", "售价", "进价", "可用数量", "耗材编码"};
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { "id_bl","id_mm" };
	}

	@Override
	public String getPkFieldCode() {
		return "id_bl";
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

			List<String> wherePartList = this.getWherePart();
			if (wherePartList != null && wherePartList.size() > 0) {
				wherePart = StringUtils.join(wherePartList, " and ");
				sqlBuilder.append(" where ");
				sqlBuilder.append(wherePart);
			}
			
			//参照物品是否按结存查询，结存中有则显示没有不显示 ，可以通过组织参数 变为 只要耗材库与物品关系中维护了就显示
			//目前领用申请必须从结存中获取 因为要预留申请数量
			/*try {
				int mcBlRef = McParams.MCBLREF1();
				if(mcBlRef == 1)
				{
					String whId = (String) this.getExtendAttributeValue("id_wh");
					sqlBuilder = getAllMM(whId,sqlBuilder);
				}
			} catch (BizException e) {
				
				e.printStackTrace();
			}*/

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
		sqlBuilder.append("SELECT name_wh,");
		sqlBuilder.append("mmca_name,");		
		sqlBuilder.append("name_mm,");
		sqlBuilder.append("name_fac,");
		sqlBuilder.append("spec,");
		sqlBuilder.append("batch,");
		sqlBuilder.append("date_expi,");
		sqlBuilder.append("name_pkgu,");
		sqlBuilder.append("pri_sa,");
		sqlBuilder.append("pri_act,");
		sqlBuilder.append("quan_usable,");
		sqlBuilder.append("code_mm,");
		sqlBuilder.append("id_bl,");
		sqlBuilder.append("id_mm, ");
		sqlBuilder.append("pycode_mm,");
		sqlBuilder.append("wbcode_mm,");
		sqlBuilder.append("mnecode_mm,");
		sqlBuilder.append("id_wh ");
		sqlBuilder.append("FROM ");
		sqlBuilder.append("(SELECT mmbl.id_bl,");
		sqlBuilder.append("(select ca.name from bd_mmca ca where ca.id_mmca in (select m2.id_mmca from bd_mm m2 where m2.id_mm = mm.id_mm)) AS mmca_name,");		
		sqlBuilder.append("wh.name AS name_wh,");
		sqlBuilder.append("mm.name AS name_mm,");
		sqlBuilder.append("fac.name AS name_fac,");
		sqlBuilder.append("mm.spec AS spec,");
		sqlBuilder.append("MMBL.BATCH AS BATCH,");
		sqlBuilder.append("MMBL.DATE_EXPI AS date_expi,");
		sqlBuilder.append("pkgu.name AS name_pkgu,");
		sqlBuilder.append(" to_char(ROUND(MMBL.PRI_SA, 4), 'fm9999999990.0000') AS pri_sa,");
		sqlBuilder.append("to_char(ROUND(MMBL.PRI_ACT, 4), 'fm9999999990.0000') AS pri_act,");
		sqlBuilder.append("to_char(ROUND(MMBL.QUAN_USABLEACT, 2), 'fm9999999990.00') AS quan_usable,");
		sqlBuilder.append("mm.code AS code_mm,");
		sqlBuilder.append("MM.PYCODE AS pycode_mm,");
		sqlBuilder.append("MM.WBCODE AS wbcode_mm,");
		sqlBuilder.append("MM.MNECODE AS mnecode_mm, ");
		sqlBuilder.append("WH.ID_WH AS ID_WH, ");
		sqlBuilder.append("mmbl.id_mm ");
		sqlBuilder.append("FROM V_MC_BL_QUERY mmbl ");
		sqlBuilder.append("INNER JOIN bd_wh wh ");
		sqlBuilder.append("ON wh.id_wh = mmbl.id_wh ");
		sqlBuilder.append("INNER JOIN bd_mm mm ");
		sqlBuilder.append("ON mm.id_mm = mmbl.id_mm ");
		sqlBuilder.append("INNER JOIN bd_sup fac ");
		sqlBuilder.append("ON fac.id_sup = mmbl.id_sup ");
		sqlBuilder.append("INNER JOIN BD_MM_PKGU mmpkgu ");
		sqlBuilder.append("ON MMPKGU.ID_MMPKGU = MMBL.ID_UNIT_PKGACT ");
		sqlBuilder.append("INNER JOIN bd_measdoc pkgu ");
		sqlBuilder.append("ON pkgu.id_measdoc = MMPKGU.ID_UNIT_PKG ");
		//sqlBuilder.append("WHERE ROUND(MMBL.QUAN_USABLEACT,2) > 0");
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
		Boolean redblue = (Boolean) this.getExtendAttributeValue("redblue");
		String wherePartStr = (String) this.getExtendAttributeValue("WherePart");
		String whapId = (String) this.getExtendAttributeValue("id_wh_ap");
		/*if (StringUtils.isEmpty(whId)) {
			// 仓库为空时，尝试根据当前科室获取仓库
			whId = findWhIdByContextDep();
		}*/

		if (StringUtils.isNotEmpty(whId)) {
			// 过滤为指定仓库
			String wherePart = String.format(" and id_wh = '%s'", whId);
			stringBuilder.append(wherePart);
		} 
		//else {
		//	stringBuilder.append(" and 1 = 2");
		//}
		if(redblue == null || !redblue) {
			stringBuilder.append(" and quan_usable > 0 ");
		}
		if (StringUtils.isNotEmpty(wherePartStr)) {
			stringBuilder.append(" and ");
			stringBuilder.append(wherePartStr);
		}
		if (StringUtils.isNotEmpty(whapId)) {
			// 过滤为指定仓库
			String wherePart = String.format(" and id_mm in (select id_mm from bd_mm_wh where id_wh = '%s' )",whapId);
			stringBuilder.append(wherePart);
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
		sqlBuilder.append("  ");
		sqlBuilder.append(" union ");                 
		sqlBuilder.append(" select '' name_wh, ");
		sqlBuilder.append(" mmca.name mmca_name, ");
		sqlBuilder.append(" mm.name name_mm, ");
		sqlBuilder.append(" fac.name name_fac, ");
		sqlBuilder.append(" spec, ");
		sqlBuilder.append(" '' batch, ");
		sqlBuilder.append(" null date_expi, ");
		sqlBuilder.append(" mm.name_unit_pkgbase name_pkgu, ");
		sqlBuilder.append(" '0' pri_sa, ");
		sqlBuilder.append(" '0' pri_act, ");
		sqlBuilder.append(" '0' quan_usable, ");
		sqlBuilder.append(" mm.code code_mm, ");
		sqlBuilder.append(" 'MCMM_'||mm.id_mm id_bl, ");//把物品id拼接成结存是为了 参照主键是id_bl 不能为空所以给值 后续会做相应处理
		sqlBuilder.append(" mm.id_mm, ");
		sqlBuilder.append(" mm.pycode pycode_mm, ");
		sqlBuilder.append(" mm.wbcode wbcode_mm, ");
		sqlBuilder.append(" mm.mnecode mnecode_mm, ");
		sqlBuilder.append(" id_wh ");
		sqlBuilder.append(" from bd_mm mm inner join bd_mm_wh whmm on whmm.id_mm = mm.id_mm ");
		sqlBuilder.append(" LEFT JOIN bd_sup fac ");
		sqlBuilder.append(" ON fac.id_sup = mm.id_sup ");
		sqlBuilder.append(" LEFT JOIN Bd_Mmca mmca ");
		sqlBuilder.append(" ON mmca.id_mmca = mm.id_mmca ");
		sqlBuilder.append(" where whmm.id_wh = '"+id_wh+"' ");
		sqlBuilder.append(" and  mm.id_mm not in ( ");                 
		sqlBuilder.append(" select q.ID_MM from  V_MC_BL_QUERY q where q.ID_WH = '"+id_wh+"'  and quan_usable > 0 ");
		sqlBuilder.append(" ) ");
		return sqlBuilder;
	}
}
