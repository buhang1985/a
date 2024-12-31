package iih.nm.nhr.nmnureduexp.refs;

import xap.sys.appfw.refinfo.RefGridModel;
import iih.nm.nhr.institutabatch.d.NmBatchDO;

import iih.nm.nhr.nmnureduexp.d.NmNurEduExpDO;

/**
 * 教育经历参照
 * 
 * @author lijm
 *
 */
public class NmNurEduExpModel extends RefGridModel {

	@Override
	public String[] getShowFieldCode() {

		return new String[] {  NmNurEduExpDO.NAME_SCH};
	}

	@Override
	public String[] getShowFieldName() {

		return new String[] { "教育经历学校名称" };
	}

	@Override
	public String[] getHiddenFieldCode() {

		return new String[] { NmNurEduExpDO.ID_NUE_EDUEXP};
	}

	@Override
	public String getPkFieldCode() {

		return NmNurEduExpDO.ID_NUE_EDUEXP;
	}

	@Override
	public String getRefCodeField() {

		return NmNurEduExpDO.ID_NUE_EDUEXP;
	}

	@Override
	public String getRefNameField() {

		return NmNurEduExpDO.NAME_SCH;
	}

	@Override
	public String getTableName() {

		return new NmNurEduExpDO().getTableName();
	}

	@Override
	public String[] getBlurFields() {

		return super.getBlurFields();
	}
}
