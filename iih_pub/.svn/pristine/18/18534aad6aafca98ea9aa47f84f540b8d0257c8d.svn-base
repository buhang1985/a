package iih.pe.pitm.perstdocdidef.refs;

import java.util.ArrayList;
import java.util.List;

import iih.pe.comm.utils.PeEnvContextUtil;
import iih.pe.pitm.perstdocdidef.d.PeDocTmplDO;
import xap.sys.appfw.refinfo.RefTreeModel;

public class PeDocTmplRefModel extends RefTreeModel {


	@Override
	public String[] getShowFieldCode() {
		return new String[] { PeDocTmplDO.CODE, PeDocTmplDO.NAME};
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PeDocTmplDO.ID_PEDOCTMPL, PeDocTmplDO.ID_PEDOCTMPL_PAR };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称"};
	}

	@Override
	public String getPkFieldCode() {
		return PeDocTmplDO.ID_PEDOCTMPL;
	}

	@Override
	public String getRefCodeField() {
		return PeDocTmplDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return PeDocTmplDO.NAME;
	}

	@Override
	public String getChildField() {
		return PeDocTmplDO.ID_PEDOCTMPL;
	}

	@Override
	public String getFatherField() {
		return PeDocTmplDO.ID_PEDOCTMPL_PAR;
	}

	@Override
	public String getTableName() {
		return new PeDocTmplDO().getTableName();
	}

	@Override
	public List<String> getOrderPart(){
		List<String> listOrderParts = new ArrayList<String>();
		listOrderParts.add(PeDocTmplDO.SORTNO);
		return listOrderParts;
	}

	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = new ArrayList<String>();
		listWhereParts.addAll(super.getWherePart());
		listWhereParts.add(PeEnvContextUtil.processEnvContext(new PeDocTmplDO(), false));
		return listWhereParts;
	}
	@Override
	public String afterBuilderSql(String sql) {

		return super.afterBuilderSql(sql);
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { PeDocTmplDO.NAME, PeDocTmplDO.CODE };
	}
}
