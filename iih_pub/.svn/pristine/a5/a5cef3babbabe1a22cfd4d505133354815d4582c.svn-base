package iih.nm.nqm.qctplmaintenance.refs;

import iih.nm.nqm.qctplmaintenance.d.NmQctplDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class NmQctplModel extends RefGridModel {

	@Override
	public String[] getShowFieldCode() {
		
		return new String[] { NmQctplDO.NAME, NmQctplDO.CODE,NmQctplDO.ID_QCTPL };
	}

	@Override
	public String[] getShowFieldName() {
	
		return new String[] { "模板名称", "模板编码","模板id" };
	}

	@Override
	public String[] getHiddenFieldCode() {

		return new String[] { NmQctplDO.ID_QCTPL_CA,NmQctplDO.VERSION,NmQctplDO.SD_STATUS };
	}

	@Override
	public String getPkFieldCode() {

		return NmQctplDO.ID_QCTPL;
	}

	@Override
	public String getRefCodeField() {

		return NmQctplDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return NmQctplDO.NAME;
	}

	@Override
	public String getTableName() {
		return new NmQctplDO().getTableName();
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { NmQctplDO.ID_QCTPL, NmQctplDO.NAME,NmQctplDO.CODE, NmQctplDO.PYCODE, NmQctplDO.WBCODE, NmQctplDO.MNECODE };
	}

}
