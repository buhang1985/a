package iih.bd.pp.anhuiinsur.i.refs;

import iih.bd.mhi.baserefs.MhiBaseRefGridModel;
import iih.bd.pp.anhuiinsur.d.BdHpZlOrginalDO;
import xap.mw.coreitf.i.IBaseDO;

/**
 * 安徽医保诊疗目录参照模型
 * 
 * @author hao_wu
 *
 */
public class TreatOrginalRefModel extends MhiBaseRefGridModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5974205490982171276L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { BdHpZlOrginalDO.CODE, BdHpZlOrginalDO.NAME, BdHpZlOrginalDO.PRI_MAX };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { BdHpZlOrginalDO.ID_HPZLORGINAL, "Pk" };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称", "单价上限价" };
	}

	@Override
	public String getPkFieldCode() {
		return "Pk";
	}

	@Override
	public String getRefCodeField() {
		return BdHpZlOrginalDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return BdHpZlOrginalDO.NAME;
	}

	@Override
	public String getTableName() {
		return new BdHpZlOrginalDO().getTableName();
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { BdHpZlOrginalDO.NAME, BdHpZlOrginalDO.CODE, BdHpZlOrginalDO.PY_CODE,
				BdHpZlOrginalDO.WB_CODE, BdHpZlOrginalDO.ZDY_CODE };
	}

	@Override
	protected String getBaseRefSql() {
		StringBuilder sqlBuilder = new StringBuilder();

		sqlBuilder.append(" SELECT A0.CODE, ");
		sqlBuilder.append(" A0.NAME, ");
		sqlBuilder.append(" A0.PRI_MAX, ");
		sqlBuilder.append(" A0.ID_HPZLORGINAL, ");
		sqlBuilder.append(" A0.ID_HP ");
		sqlBuilder.append(" ||'_' ");
		sqlBuilder.append(" ||A0.CODE AS PK ");
		sqlBuilder.append(" FROM BD_HP_ZL_ORGINAL A0");

		return sqlBuilder.toString();
	}

	/**
	 * 构建排序语句
	 * 
	 * @return
	 */
	@Override
	protected String buildOrderPart() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(String.format("%s", BdHpZlOrginalDO.CODE));
		return stringBuilder.toString();
	}

	@Override
	protected IBaseDO getDo() {
		return new BdHpZlOrginalDO();
	}
}
