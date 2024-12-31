package iih.bd.srv.emrtype.refs;

import org.apache.commons.lang.StringUtils;

import iih.bd.srv.emrtype.d.MrTpDO;
import iih.bd.srv.mrbasetpl.d.EmrBaseTplDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefTreeModel;

public class MrtpRefModel extends RefTreeModel {
	@Override
	public String[] getShowFieldCode() {
		return new String[] { MrTpDO.CODE, MrTpDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { MrTpDO.ID_MRTP, MrTpDO.ID_PARENT, MrTpDO.WBCODE, MrTpDO.PYCODE, MrTpDO.CD_STD };
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { EmrBaseTplDO.CODE, MrTpDO.WBCODE, MrTpDO.PYCODE, MrTpDO.NAME, MrTpDO.CODE,
				MrTpDO.MNECODE };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return MrTpDO.ID_MRTP;
	}

	@Override
	public String getTableName() {
		return new MrTpDO().getTableName();
	}

	@Override
	public String getRefCodeField() {
		return MrTpDO.CODE;

	}

	@Override
	public String getRefNameField() {
		return MrTpDO.NAME;

	}

	@Override
	public String getFatherField() {
		return MrTpDO.ID_PARENT;
	}

	@Override
	public String getChildField() {
		return MrTpDO.ID_MRTP;
	}

	@Override
	public String getRefSql() {
		String wherePart = BuildWherePart();
		String orderPart = BuildOrderPart();
		String refSql;
		try {
			if (wherePart != null && !"".equals(wherePart)) {
				this.getWherePart().add(wherePart);
			}
			if (orderPart != null && !"".equals(orderPart)) {
				this.getOrderPart().add(orderPart);
			}
			refSql = super.getRefSql();

		} finally {
			if (wherePart != null && !"".equals(wherePart)) {
				this.getWherePart().remove(wherePart);
			}
			if (orderPart != null && !"".equals(orderPart)) {
				this.getOrderPart().remove(orderPart);
			}
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
		stringBuilder.append(" and ds = 0 ");
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new MrTpDO(), false);
		stringBuilder.append(String.format(" and %s ", BdModeWherePart));

		String mrcactmId = (String) this.getExtendAttributeValue("mrcactmId");
		if (!StringUtils.isBlank(mrcactmId)) {
			String wherePart = String.format(
					" and id_mrtp in (select t.id_mrtp from bd_mrca_ctm_itm t where t.id_mrcactm='%s')", mrcactmId);
			stringBuilder.append(wherePart);
		}

		String id_setca = (String) this.getExtendAttributeValue("id_setca");
		if (!StringUtils.isEmpty(id_setca)) {
			String wherePart = String.format(" AND Id_data_set in (select id_set from bd_set where ID_SETCA = '%s')",
					id_setca);
			stringBuilder.append(wherePart);
		}

		return stringBuilder.toString();
	}

	/**
	 * 构建排序语句
	 * 
	 * @return
	 */
	private String BuildOrderPart() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(String.format("%s", MrTpDO.CODE));
		return stringBuilder.toString();
	}
}
