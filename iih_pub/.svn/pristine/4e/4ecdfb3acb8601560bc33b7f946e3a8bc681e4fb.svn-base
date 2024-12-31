package iih.pe.pbd.pemembercardca.refs;
import java.util.ArrayList;
import java.util.List;

import iih.pe.pbd.pemembercardca.d.PeMemCardCaDO;
import iih.pe.comm.utils.PeEnvContextUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.refinfo.RefGridModel;

public class PeMemCardCaRefModel extends RefGridModel {


	@Override
	public String[] getShowFieldCode() {
		return new String[] { PeMemCardCaDO.CODE, PeMemCardCaDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PeMemCardCaDO.ID_PEMEMCARDCA };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "类别编码", "类别名称" };
	}

	@Override
	public String getPkFieldCode() {
		return PeMemCardCaDO.ID_PEMEMCARDCA;
	}

	@Override
	public String getRefCodeField() {
		return PeMemCardCaDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return PeMemCardCaDO.NAME;
	}

	@Override
	public String getTableName() {
		return new PeMemCardCaDO().getTableName();
	}


	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = new ArrayList<String>();
		listWhereParts.addAll(super.getWherePart());
		listWhereParts.add(PeEnvContextUtil.processEnvContext(new PeMemCardCaDO(), false));
		return listWhereParts;
	}
}

