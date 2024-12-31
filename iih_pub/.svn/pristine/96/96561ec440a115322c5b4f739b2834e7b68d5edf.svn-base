package iih.mi.mc.mimcspec.refs;

import java.util.List;

import ca.krasnay.sqlbuilder.SelectBuilder;
import iih.bd.utils.BdEnvContextUtil;
import iih.mi.mc.mimcspec.d.MiMcSpecDrugDO;
import xap.sys.appfw.refinfo.RefGridModel;
/**
 * 特殊病药品对照参照
 * @author liming
 *
 */
public class MiMcSpecDrugRefModel extends RefGridModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return (new String[] {MiMcSpecDrugDO.CODE_MM,MiMcSpecDrugDO.NAME_MM,MiMcSpecDrugDO.SPEC_MM,MiMcSpecDrugDO.NAME_UNIT_PKGBASE});
		
	}

	@Override
	public String[] getHiddenFieldCode() {
		return (new String[] { "Id_mm",MiMcSpecDrugDO.ID_UNIT_PKGBASE,MiMcSpecDrugDO.QUAN_LIMIT});
	}

	@Override
	public String[] getShowFieldName() {
		return (new String[] { "HIS项目编码","HIS项目名称","HIS规格","HIS单位","医保项目编码","医保项目名称"});
	}

	@Override
	public String getPkFieldCode() {
		return "Id_mm";
	}


	@Override
	public String getRefNameField() {
		return MiMcSpecDrugDO.NAME_MM;
	}

	@Override
	public String getTableName() {
		return "drugmm";
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { MiMcSpecDrugDO.NAME_MM };
	}

	@Override
	public String getRefSql() {
		String wherePart = BuildWherePart();
		String orderPart = BuildOrderPart();
		String refSql = null;
		try {
			if (wherePart != null && !"".equals(wherePart)) {
				this.getWherePart().add(wherePart);
			}
			if (orderPart != null && !"".equals(orderPart)) {
				this.getOrderPart().add(orderPart);
			}
			//refSql = super.getRefSql();

		 refSql = "select * from ( select   mm.code code_mm,mm.name name_mm ,mm.spec,mm.name_unit_pkgbase,mm.id_mm,mm.id_unit_pkgbase,drug.quan_limit,spec.id_hp,spec.id_didef,spec.id_dsdef "+
 "from MI_MC_SPEC_DRUG  drug  inner join bd_mm mm on drug.id_mm = mm.id_mm    left join MI_MC_SPEC spec on spec.id_hpspec =drug.id_hpspec  ) drugmm  where 1=1 ";
        

		} finally {
			if (wherePart != null && !"".equals(wherePart)) {
				this.getWherePart().remove(wherePart);
			}
			if (orderPart != null && !"".equals(orderPart)) {
				this.getOrderPart().remove(orderPart);
			}
			StringBuilder sqlSb =new StringBuilder();
			List<String> whereList = this.getWherePart();
			if (whereList.size() > 0) {
				for (String where : this.getWherePart()) {
					sqlSb.append(" And (").append(where).append(") ");
				}
			}
			refSql =refSql+sqlSb.toString() ;
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
		stringBuilder.append(" and ds = '0' ");
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new MiMcSpecDrugDO(), false);
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
		stringBuilder.append(String.format("%s", MiMcSpecDrugDO.CODE_SRV));
		return stringBuilder.toString();
	}
}
