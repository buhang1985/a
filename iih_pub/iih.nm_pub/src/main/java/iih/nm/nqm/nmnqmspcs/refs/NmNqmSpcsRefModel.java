package iih.nm.nqm.nmnqmspcs.refs;

import iih.bd.utils.BdEnvContextUtil;
import iih.nm.nqm.nmnqmspcs.d.NmNqmSpcsDo;

import java.util.List;

import xap.sys.appfw.refinfo.RefGridModel;

public class NmNqmSpcsRefModel extends RefGridModel {

	@Override
	public String[] getShowFieldCode() {
		return new String[] { NmNqmSpcsDo.NAME, NmNqmSpcsDo.CODE, NmNqmSpcsDo.VERSION, NmNqmSpcsDo.FG_ACTIVE };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "标题", "编码", "版本", "启用状态" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { NmNqmSpcsDo.ID_NQM_SPCS };
	}

	@Override
	public String getPkFieldCode() {
		return NmNqmSpcsDo.ID_NQM_SPCS;
	}

	@Override
	public String getRefCodeField() {
		return NmNqmSpcsDo.CODE;
	}

	@Override
	public String getRefNameField() {
		return NmNqmSpcsDo.NAME;
	}

	@Override
	public String getTableName() {
		return new NmNqmSpcsDo().getTableName();
	}

	@Override
	public String[] getBlurFields() {
		return super.getBlurFields();
	}

	@Override
	public List<String> getWherePart() {
		List<String> wherePart = super.getWherePart();
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new NmNqmSpcsDo(), false);
		wherePart.add(BdModeWherePart);
		return wherePart;
	}    
}