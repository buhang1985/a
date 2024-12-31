package iih.pe.pbd.qry.refs;

import iih.pe.pbd.qry.d.QryDO;
import iih.pe.comm.utils.PeEnvContextUtil;

import java.util.ArrayList;
import java.util.List;

import xap.sys.appfw.refinfo.RefGridModel;

public class QryProjectRefsModel extends RefGridModel {

	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { QryDO.CODE, QryDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { QryDO.ID_QRY};
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "方案编码", "方案名称" };
	}

	@Override
	public String getPkFieldCode() {
		return QryDO.ID_QRY;
	}

	@Override
	public String getRefCodeField() {
		return QryDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return QryDO.NAME;
	}

	@Override
	public String getTableName() {
		return new QryDO().getTableName();
	}
	@Override
	public String[] getBlurFields() {
		return new String[] { QryDO.NAME, QryDO.CODE, QryDO.PYCODE, QryDO.WBCODE, QryDO.MNECODE };
	}

	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = new ArrayList<String>();
		listWhereParts.addAll(super.getWherePart());
		listWhereParts.add(PeEnvContextUtil.processEnvContext(new QryDO(), false));
		return listWhereParts;
	}
}