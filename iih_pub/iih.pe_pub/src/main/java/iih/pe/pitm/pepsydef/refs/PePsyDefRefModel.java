package iih.pe.pitm.pepsydef.refs;

import java.util.ArrayList;
import java.util.List;

import iih.pe.comm.utils.PeEnvContextUtil;
import iih.pe.pitm.pepsydef.d.PePsyDefDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class PePsyDefRefModel extends RefGridModel {

	private static final long serialVersionUID = 1L;
	
	@Override
	public String[] getShowFieldCode() {
		return new String[] { PePsyDefDO.CODE, PePsyDefDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PePsyDefDO.ID_PEPSYDEF };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "处方内容" };
	}

	@Override
	public String getPkFieldCode() {
		return PePsyDefDO.ID_PEPSYDEF;
	}

	@Override
	public String getRefCodeField() {
		return PePsyDefDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return PePsyDefDO.CODE;
	}

	@Override
	public String getTableName() {
		return new PePsyDefDO().getTableName();
	}
	
	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = new ArrayList<String>();
		listWhereParts.addAll(super.getWherePart());
//		listWhereParts.add(PeEnvContextUtil.processEnvContext(new PePsyDefDO(), false));
		return listWhereParts;
	}

}
