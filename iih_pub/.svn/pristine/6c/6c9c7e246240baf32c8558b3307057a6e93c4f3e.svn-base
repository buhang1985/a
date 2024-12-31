package iih.cssd.dpbd.pkg.refs;

import java.util.ArrayList;
import java.util.List;

import iih.bd.utils.BdEnvContextUtil;
import iih.cssd.dpbd.instr.d.CssdiNSTRDO;
import iih.cssd.dpbd.pkg.d.CssdPkgDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class CssdpkgRefsModel extends RefGridModel {
	@Override
	public String[] getShowFieldCode() {
		// TODO Auto-generated method stub
		return new String[] { CssdPkgDO.CODE, CssdPkgDO.NAME };
	}

	@Override
	public String[] getShowFieldName() {
		// TODO Auto-generated method stub
		return new String[] { "编码", "名称" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		// TODO Auto-generated method stub
		return new String[] { CssdPkgDO.ID_PKG };
	}

	@Override
	public String getPkFieldCode() {
		// TODO Auto-generated method stub
		return CssdPkgDO.ID_PKG;
	}

	@Override
	public String getRefCodeField() {
		// TODO Auto-generated method stub
		return CssdPkgDO.CODE;
	}

	@Override
	public String getRefNameField() {
		// TODO Auto-generated method stub
		return CssdPkgDO.NAME;
	}

	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = new ArrayList<String>();
		listWhereParts.addAll(super.getWherePart());
		listWhereParts.add(this.getTableName() + ".fg_active = 'Y' ");
		// 增加集团管控
		listWhereParts.add(BdEnvContextUtil.processEnvContext(new CssdPkgDO(), false));
		return listWhereParts;
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return new CssdPkgDO().getTableName();
	}

	@Override
	public String[] getBlurFields() {
		// TODO Auto-generated method stub
		return new String[] { CssdPkgDO.CODE, CssdPkgDO.NAME, CssdPkgDO.WBCODE, CssdPkgDO.PYCODE, CssdPkgDO.MNECODE };
	}

}
