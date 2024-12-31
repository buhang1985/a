package iih.pe.pqn.peevalkinematics.refs;

import iih.pe.pqn.peevalkinematics.d.PeEvalKineDurDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class PeEvalKineDurRefModel extends RefGridModel {
	
	@Override
	public String[] getShowFieldCode() {
		return new String[] { PeEvalKineDurDO.CODE, PeEvalKineDurDO.NAME, PeEvalKineDurDO.SCORE };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PeEvalKineDurDO.ID_PEEVALKINEDUR };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称", "分值" };
	}

	@Override
	public String getPkFieldCode() {
		return PeEvalKineDurDO.ID_PEEVALKINEDUR;
	}

	@Override
	public String getRefCodeField() {
		return PeEvalKineDurDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return PeEvalKineDurDO.NAME;
	}

	@Override
	public String getTableName() {
		return new PeEvalKineDurDO().getTableName();
	}

}
