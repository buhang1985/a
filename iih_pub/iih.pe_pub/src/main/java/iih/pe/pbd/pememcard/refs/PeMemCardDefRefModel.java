package iih.pe.pbd.pememcard.refs;
import java.util.ArrayList;
import java.util.List;

import iih.pe.pbd.pememcard.d.PeMemCardDefDO;
import iih.pe.comm.utils.PeEnvContextUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.refinfo.RefGridModel;

public class PeMemCardDefRefModel extends RefGridModel {


	@Override
	public String[] getShowFieldCode() {
		return new String[] { PeMemCardDefDO.CODE, PeMemCardDefDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PeMemCardDefDO.ID_PEMEMCARD };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return PeMemCardDefDO.ID_PEMEMCARD;
	}

	@Override
	public String getRefCodeField() {
		return PeMemCardDefDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return PeMemCardDefDO.NAME;
	}

	@Override
	public String getTableName() {
		return new PeMemCardDefDO().getTableName();
	}


	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = new ArrayList<String>();
		listWhereParts.addAll(super.getWherePart());
		listWhereParts.add(PeEnvContextUtil.processEnvContext(new PeMemCardDefDO(), false));
		return listWhereParts;
	}
}

