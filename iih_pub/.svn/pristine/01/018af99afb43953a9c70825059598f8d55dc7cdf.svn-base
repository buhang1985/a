package iih.nm.nhr.nmnurpatent.refs;

import xap.sys.appfw.refinfo.RefGridModel;
import iih.nm.nhr.institutabatch.d.NmBatchDO;


import iih.nm.nhr.nmnurpatent.d.NmNurPatentDO;

/**
 * 专利参照
 * 
 * @author lijm
 *
 */
public class NmNurPatentModel extends RefGridModel {

	@Override
	public String[] getShowFieldCode() {

		return new String[] {  NmNurPatentDO.NAME_PATENT};
	}

	@Override
	public String[] getShowFieldName() {

		return new String[] { "专利名称" };
	}

	@Override
	public String[] getHiddenFieldCode() {

		return new String[] { NmNurPatentDO.ID_NUR_PATENT};
	}

	@Override
	public String getPkFieldCode() {

		return NmNurPatentDO.ID_NUR_PATENT;
	}

	@Override
	public String getRefCodeField() {

		return NmNurPatentDO.ID_NUR_PATENT;
	}

	@Override
	public String getRefNameField() {

		return NmNurPatentDO.NAME_PATENT;
	}

	@Override
	public String getTableName() {

		return new NmNurPatentDO().getTableName();
	}

	@Override
	public String[] getBlurFields() {

		return super.getBlurFields();
	}
}
