package iih.pe.pqn.peevalkinematics.refs;

import iih.pe.pqn.peevalkinematics.d.PeEvalKineLevelDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class PeEvalKineLevelRefModel extends RefGridModel{
	@Override
	public String[] getShowFieldCode() {
		return new String[] { PeEvalKineLevelDO.CODE, PeEvalKineLevelDO.NAME, PeEvalKineLevelDO.SCORE_LOW, PeEvalKineLevelDO.SCORE_HIGH, PeEvalKineLevelDO.ACTIVITYINDEX };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PeEvalKineLevelDO.ID_PEEVALKINELEVEL };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称", "低值", "高值", "指数" };
	}

	@Override
	public String getPkFieldCode() {
		return PeEvalKineLevelDO.ID_PEEVALKINELEVEL;
	}

	@Override
	public String getRefCodeField() {
		return PeEvalKineLevelDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return PeEvalKineLevelDO.NAME;
	}

	@Override
	public String getTableName() {
		return new PeEvalKineLevelDO().getTableName();
	}
}
