package iih.pe.pqn.peevalkinematics.refs;

import iih.pe.pqn.peevalkinematics.d.PeEvalKineIntDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class PeEvalKineIntRefModel extends RefGridModel {
	
	@Override
	public String[] getShowFieldCode() {
		return new String[] { PeEvalKineIntDO.CODE, PeEvalKineIntDO.NAME, PeEvalKineIntDO.SCORE };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PeEvalKineIntDO.ID_PEEVALKINEINT };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称", "分值" };
	}

	@Override
	public String getPkFieldCode() {
		return PeEvalKineIntDO.ID_PEEVALKINEINT;
	}

	@Override
	public String getRefCodeField() {
		return PeEvalKineIntDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return PeEvalKineIntDO.NAME;
	}

	@Override
	public String getTableName() {
		return new PeEvalKineIntDO().getTableName();
	}

}
