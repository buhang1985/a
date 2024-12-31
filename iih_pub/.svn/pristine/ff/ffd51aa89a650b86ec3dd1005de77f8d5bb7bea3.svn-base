package iih.cssd.dpbd.pkgca.refs;

import java.util.ArrayList;
import java.util.List;

import iih.bd.utils.BdEnvContextUtil;
import iih.cssd.dpbd.instr.d.CssdiNSTRDO;
import iih.cssd.dpbd.pkgca.d.CssdPkgCaDO;
import xap.sys.appfw.refinfo.RefTreeModel;

public class PkgcaRefsModel extends RefTreeModel {

	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { CssdPkgCaDO.CODE, CssdPkgCaDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { CssdPkgCaDO.ID_PKG_CA, CssdPkgCaDO.ID_PARENT };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return CssdPkgCaDO.ID_PKG_CA;
	}

	@Override
	public String getChildField() {
		return CssdPkgCaDO.ID_PKG_CA;
	}

	@Override
	public String getFatherField() {
		return CssdPkgCaDO.ID_PARENT;
	}

	@Override
	public String getRefCodeField() {
		return CssdPkgCaDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return CssdPkgCaDO.NAME;
	}

	@Override
	public List<String> getWherePart() {
		List<String> wherePart = super.getWherePart();
		if (wherePart == null) {
			wherePart = new ArrayList<String>();
		}
		// 增加集团管控
		wherePart.add(BdEnvContextUtil.processEnvContext(new CssdPkgCaDO(), false));
		return wherePart;
	}

	@Override
	public String getTableName() {
		return new CssdPkgCaDO().getTableName();
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { CssdPkgCaDO.NAME, CssdPkgCaDO.CODE };
	};
}
