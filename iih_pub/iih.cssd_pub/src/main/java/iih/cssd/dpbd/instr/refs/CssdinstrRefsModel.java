package iih.cssd.dpbd.instr.refs;

import java.util.ArrayList;
import java.util.List;

import iih.bd.fc.que.d.QueDO;
import iih.bd.utils.BdEnvContextUtil;
import iih.cssd.dpbd.instr.d.CssdiNSTRDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class CssdinstrRefsModel extends RefGridModel {

	@Override
	public String[] getShowFieldCode() {
		// TODO Auto-generated method stub
		return new String[] { CssdiNSTRDO.CODE, CssdiNSTRDO.NAME };
	}

	@Override
	public String[] getShowFieldName() {
		// TODO Auto-generated method stub
		return new String[] { "编码", "名称" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		// TODO Auto-generated method stub
		return new String[] { CssdiNSTRDO.ID_INSTR };
	}

	@Override
	public String getPkFieldCode() {
		// TODO Auto-generated method stub
		return CssdiNSTRDO.ID_INSTR;
	}

	@Override
	public String getRefCodeField() {
		// TODO Auto-generated method stub
		return CssdiNSTRDO.CODE;
	}

	@Override
	public String getRefNameField() {
		// TODO Auto-generated method stub
		return CssdiNSTRDO.NAME;
	}

	@Override
	public List<String> getWherePart() {
		List<String> wherePart = super.getWherePart();
		if (wherePart == null) {
			wherePart = new ArrayList<String>();
		}
		// 增加集团管控
		wherePart.add(BdEnvContextUtil.processEnvContext(new CssdiNSTRDO(), false));
		return wherePart;
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return new CssdiNSTRDO().getTableName();
	}

	@Override
	public String[] getBlurFields() {
		// TODO Auto-generated method stub
		return super.getBlurFields();
	}

}
