package iih.nm.nhr.nmnurac.refs;

import xap.sys.appfw.refinfo.RefGridModel;
import iih.nm.nhr.institutabatch.d.NmBatchDO;
import iih.nm.nhr.nmnurac.d.NmNurAcDO;


/**
 * 学术会议参照
 * 
 * @author lijm
 *
 */
public class NmNurAcModel extends RefGridModel {

	@Override
	public String[] getShowFieldCode() {

		return new String[] {  NmNurAcDO.NAME_CONFREC };
	}

	@Override
	public String[] getShowFieldName() {

		return new String[] { "学术会议名称" };
	}

	@Override
	public String[] getHiddenFieldCode() {

		return new String[] { NmNurAcDO.ID_NUR_AC};
	}

	@Override
	public String getPkFieldCode() {

		return NmNurAcDO.ID_NUR_AC;
	}

	@Override
	public String getRefCodeField() {

		return NmNurAcDO.ID_NUR_AC;
	}

	@Override
	public String getRefNameField() {

		return NmNurAcDO.NAME_CONFREC;
	}

	@Override
	public String getTableName() {

		return new NmNurAcDO().getTableName();
	}

	@Override
	public String[] getBlurFields() {

		return super.getBlurFields();
	}
}
