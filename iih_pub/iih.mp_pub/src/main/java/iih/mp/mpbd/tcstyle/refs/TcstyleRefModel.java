package iih.mp.mpbd.tcstyle.refs;

import iih.mp.mpbd.tcstyle.d.TcstyleDO;
import iih.mp.pub.MpEnvContextUtil;

import java.util.ArrayList;
import java.util.List;

import xap.sys.appfw.refinfo.RefGridModel;

public class TcstyleRefModel extends RefGridModel {

	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldName() {
		return new String[] { "样式名称", "样式编码" };
	}

	@Override
	public String[] getShowFieldCode() {
		return new String[] { TcstyleDO.CODE, TcstyleDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { TcstyleDO.ID_TC_STY };
	}

	@Override
	public String getPkFieldCode() {
		return TcstyleDO.ID_TC_STY;
	}

	@Override
	public String getRefCodeField() {
		return TcstyleDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return TcstyleDO.NAME;
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { TcstyleDO.NAME, TcstyleDO.WBCODE, TcstyleDO.PYCODE, TcstyleDO.MNECODE };
	}

	@Override
	public String getTableName() {
		return new TcstyleDO().getTableName();
	}

	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = new ArrayList<String>();
		listWhereParts.addAll(super.getWherePart());
		listWhereParts.add(new MpEnvContextUtil().getWherePart(new TcstyleDO(), false));
		return listWhereParts;
	}
}
