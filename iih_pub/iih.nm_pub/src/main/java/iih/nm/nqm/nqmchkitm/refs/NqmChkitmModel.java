package iih.nm.nqm.nqmchkitm.refs;

import iih.nm.nqm.nqmchkitm.d.NmNqmChkitmcaDo;
import xap.sys.appfw.refinfo.RefGridModel;

public class NqmChkitmModel extends RefGridModel {

	@Override
	public String[] getShowFieldCode() {

		return new String[] { NmNqmChkitmcaDo.CODE, NmNqmChkitmcaDo.NAME };
	}

	@Override
	public String[] getShowFieldName() {

		return new String[] { "评分分类编号", "评分分类名称" };
	}

	@Override
	public String[] getHiddenFieldCode() {
	
		return new String[] { NmNqmChkitmcaDo.ID_NQM_CHKITMCA};
	}

	@Override
	public String getPkFieldCode() {
		
		return NmNqmChkitmcaDo.ID_NQM_CHKITMCA;
	}

	@Override
	public String getRefCodeField() {
		
		return NmNqmChkitmcaDo.CODE;
	}

	@Override
	public String getRefNameField() {
		
		return NmNqmChkitmcaDo.NAME;
	}

	@Override
	public String getTableName() {
		
		return new NmNqmChkitmcaDo().getTableName();
	}

	@Override
	public String[] getBlurFields() {
		
		return super.getBlurFields();
	}

}
