package iih.nm.nhr.nmnuratc.refs;

import xap.sys.appfw.refinfo.RefGridModel;
import iih.nm.nhr.institutabatch.d.NmBatchDO;
import iih.nm.nhr.nmnuratc.d.NmNurAtcDO;


/**
 * 专著参照
 * 
 * @author lijm
 *
 */
public class NmNurAtcModel extends RefGridModel {

	@Override
	public String[] getShowFieldCode() {

		return new String[] {  NmNurAtcDO.NAME_ATC};
	}

	@Override
	public String[] getShowFieldName() {

		return new String[] { "专著论文名称" };
	}

	@Override
	public String[] getHiddenFieldCode() {

		return new String[] { NmNurAtcDO.ID_NUR_ATC};
	}

	@Override
	public String getPkFieldCode() {

		return NmNurAtcDO.ID_NUR_ATC;
	}

	@Override
	public String getRefCodeField() {

		return NmNurAtcDO.ID_NUR_ATC;
	}

	@Override
	public String getRefNameField() {

		return NmNurAtcDO.NAME_ATC;
	}

	@Override
	public String getTableName() {

		return new NmNurAtcDO().getTableName();
	}

	@Override
	public String[] getBlurFields() {

		return super.getBlurFields();
	}
}
