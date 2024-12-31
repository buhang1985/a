package iih.bd.srv.udidoc.refs;

import iih.bd.bc.udi.pub.IBdMmDictCodeTypeConst;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefTreeModel;
import xap.sys.bdfw.cenum.d.ActiveStateEnum;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 药品剂型参照模型</br>
 * 因涉及多表关联查询，标准模型涉及缓存，所以另写一个
 * 
 * @author hao_wu
 *
 */
public class DosageTypeRefModel extends RefTreeModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7427104980889337712L;

	public String getChildField() {
		return UdidocDO.ID_UDIDOC;
	}

	public String getFatherField() {
		return UdidocDO.ID_PARENT;
	}

	public boolean isNotLeafNodeSelected() {
		return false;
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "名称", "编码" };
	}

	@Override
	public String[] getShowFieldCode() {
		return new String[] { UdidocDO.NAME, UdidocDO.CODE };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { UdidocDO.ID_UDIDOC, UdidocDO.ID_UDIDOCLIST, UdidocDO.CODE_STD, UdidocDO.ID_PARENT,
				UdidocDO.INNERCODE, UdidocDO.PYCODE, UdidocDO.WBCODE, UdidocDO.MNECODE, UdidocDO.CTRL1, UdidocDO.CTRL2,
				UdidocDO.CTRL3, UdidocDO.CTRL4, UdidocDO.CTRL5 };
	}

	@Override
	public String getRefNameField() {
		return UdidocDO.NAME;
	}

	@Override
	public String getPkFieldCode() {
		return UdidocDO.ID_UDIDOC;
	}

	@Override
	public String getRefCodeField() {
		return UdidocDO.CODE;
	}

	@Override
	public String getTableName() {
		return new UdidocDO().getTableName();
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { UdidocDO.CODE, UdidocDO.NAME, UdidocDO.PYCODE, UdidocDO.WBCODE, UdidocDO.MNECODE };
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
		stringBuilder.append(" and ds = 0");
		stringBuilder.append(String.format(" and activestate = %s", ActiveStateEnum.ACTIVE));
		stringBuilder.append(
				String.format(" and (id_udidoclist in (select id_udidoclist from bd_udidoclist where code = '%s'))",
						IBdMmDictCodeTypeConst.SD_DOSAGETYPE));

		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new UdidocDO(), false);
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
		stringBuilder.append(UdidocDO.CODE);
		return stringBuilder.toString();
	}
}
