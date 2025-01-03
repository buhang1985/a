package iih.pe.pitm.perstdidef.refs;

import java.util.ArrayList;
import java.util.List;
import iih.pe.pitm.perstdidef.d.PeRstDiDefDO;
import iih.pe.comm.utils.PeEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class PeRstDiDefRefModel extends RefGridModel {


	@Override
	public String[] getShowFieldCode() {
		return new String[] { PeRstDiDefDO.CODE, PeRstDiDefDO.NAME, PeRstDiDefDO.PYCODE  };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PeRstDiDefDO.ID_PERSTDIDEF, PeRstDiDefDO.ADVICE, PeRstDiDefDO.ADVICE_DOC };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "诊断编码", "诊断名称", "检索码"};
	}

	@Override
	public String getPkFieldCode() {
		return PeRstDiDefDO.ID_PERSTDIDEF;
	}

	@Override
	public String getRefCodeField() {
		return PeRstDiDefDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return PeRstDiDefDO.NAME;
	}

	@Override
	public String getTableName() {
		return new PeRstDiDefDO().getTableName();
	}


	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = new ArrayList<String>();
		listWhereParts.addAll(super.getWherePart());
		listWhereParts.add(PeEnvContextUtil.processEnvContext(new PeRstDiDefDO(), false));
		return listWhereParts;
	}
}
