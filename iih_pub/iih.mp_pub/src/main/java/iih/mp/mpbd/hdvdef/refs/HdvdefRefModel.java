package iih.mp.mpbd.hdvdef.refs;

import java.util.ArrayList;
import java.util.List;

import iih.mp.mpbd.hdvdef.d.HdvDefDO;
import iih.mp.pub.MpEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class HdvdefRefModel extends RefGridModel {

	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}
	@Override
	public String[] getShowFieldCode() {
		return new String[] { HdvDefDO.CODE, HdvDefDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { HdvDefDO.ID_HDV_DEF };
	}

	@Override
	public String getPkFieldCode() {
		return HdvDefDO.ID_HDV_DEF;
	}

	@Override
	public String getRefCodeField() {
		return HdvDefDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return HdvDefDO.NAME;
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { HdvDefDO.NAME, HdvDefDO.CODE };
	}

	@Override
	public String getTableName() {
		return new HdvDefDO().getTableName();
	}

	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = new ArrayList<String>();
		listWhereParts.addAll(super.getWherePart());
		listWhereParts.add(new MpEnvContextUtil().getWherePart(new HdvDefDO(), false));
		return listWhereParts;
	}
}
