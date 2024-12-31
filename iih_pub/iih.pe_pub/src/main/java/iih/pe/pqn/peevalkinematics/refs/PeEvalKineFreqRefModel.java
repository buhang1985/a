package iih.pe.pqn.peevalkinematics.refs;

import iih.pe.pqn.peevalkinematics.d.PeEvalKineFreqDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class PeEvalKineFreqRefModel extends RefGridModel {
	
	@Override
	public String[] getShowFieldCode() {
		return new String[] { PeEvalKineFreqDO.CODE, PeEvalKineFreqDO.NAME, PeEvalKineFreqDO.SCORE };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PeEvalKineFreqDO.ID_PEEVALKINEFREQ };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称", "分值" };
	}

	@Override
	public String getPkFieldCode() {
		return PeEvalKineFreqDO.ID_PEEVALKINEFREQ;
	}

	@Override
	public String getRefCodeField() {
		return PeEvalKineFreqDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return PeEvalKineFreqDO.NAME;
	}

	@Override
	public String getTableName() {
		return new PeEvalKineFreqDO().getTableName();
	}

}
