package iih.pe.pwf.perstdiagsugg.refs;

import java.util.ArrayList;
import java.util.List;

import iih.pe.pwf.perstdiagsugg.d.PeRstDiagSuggDO;
import iih.pe.comm.utils.PeEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class PeRstDiagSuggRefModel extends RefGridModel {

	public PeRstDiagSuggRefModel() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String[] getShowFieldCode() {
		return new String[] { PeRstDiagSuggDO.SORTNO, PeRstDiagSuggDO.DIAG };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PeRstDiagSuggDO.ID_PERSTDIAGSUGG };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "序号", "诊断" };
	}

	@Override
	public String getPkFieldCode() {
		return PeRstDiagSuggDO.ID_PERSTDIAGSUGG;
	}

	@Override
	public String getRefCodeField() {
		return PeRstDiagSuggDO.SORTNO;
	}

	@Override
	public String getRefNameField() {
		return PeRstDiagSuggDO.DIAG;
	}

	@Override
	public String getTableName() {
		return new PeRstDiagSuggDO().getTableName();
	}


	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = new ArrayList<String>();
		listWhereParts.addAll(super.getWherePart());
		listWhereParts.add(PeEnvContextUtil.processEnvContext(new PeRstDiagSuggDO(), false));
		return listWhereParts;
	}
}
