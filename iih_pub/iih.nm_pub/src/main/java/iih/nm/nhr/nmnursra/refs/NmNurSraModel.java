package iih.nm.nhr.nmnursra.refs;

import iih.nm.nhr.nmnursra.d.NmNurSraDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class NmNurSraModel extends RefGridModel  {
	@Override
	public String[] getShowFieldCode() {

		return new String[] { NmNurSraDO.NAME_SUB, NmNurSraDO.NO_SUB };
	}

	@Override
	public String[] getShowFieldName() {

		return new String[] { "课题名称", "课题编码" };
	}

	@Override
	public String[] getHiddenFieldCode() {

		return new String[] { NmNurSraDO.ID_NUR_SRA };
	}

	@Override
	public String getPkFieldCode() {

		return NmNurSraDO.ID_NUR_SRA;
	}

	@Override
	public String getRefCodeField() {

		return NmNurSraDO.NO_SUB;
	}

	@Override
	public String getRefNameField() {

		return NmNurSraDO.NAME_SUB;
	}

	@Override
	public String getTableName() {

		return new NmNurSraDO().getTableName();
	}

	@Override
	public String[] getBlurFields() {

		return super.getBlurFields();
	}
}
