package iih.bd.srv.emreditor.refs;

import iih.bd.srv.emreditor.d.EmrEditorDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.bdfw.cenum.d.ActiveStateEnum;

@SuppressWarnings("serial")
public class EmreditorRefModel extends RefGridModel {

	@Override
	public String[] getShowFieldCode() {
		return new String[] { EmrEditorDO.CODE, EmrEditorDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { EmrEditorDO.ID_MRED, EmrEditorDO.DLL_PATH, EmrEditorDO.NAME_CLASS,
				EmrEditorDO.FUNC_EDITOR };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "医疗记录编辑器名称" };
	}

	@Override
	public String getPkFieldCode() {
		return EmrEditorDO.ID_MRED;
	}

	@Override
	public String getRefCodeField() {
		return EmrEditorDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return EmrEditorDO.NAME;
	}

	@Override
	public String getTableName() {
		return new EmrEditorDO().getTableName();
	}

	public String getDll_pathField() {
		return EmrEditorDO.DLL_PATH;
	}

	public String getName_classField() {
		return EmrEditorDO.NAME_CLASS;
	}

	public String getFunc_editor() {
		return EmrEditorDO.FUNC_EDITOR;
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { EmrEditorDO.NAME, EmrEditorDO.CODE, EmrEditorDO.MNECODE, EmrEditorDO.PYCODE,
				EmrEditorDO.WBCODE };
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
		stringBuilder.append(String.format(" and Activestate = '%s'", ActiveStateEnum.ACTIVE));
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new EmrEditorDO(), false);
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
		return stringBuilder.toString();
	}
}