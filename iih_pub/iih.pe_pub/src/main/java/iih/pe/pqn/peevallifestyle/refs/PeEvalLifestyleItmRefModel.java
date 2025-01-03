package iih.pe.pqn.peevallifestyle.refs;

import iih.pe.pqn.peevallifestyle.d.PeEvalLifestyleItmDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class PeEvalLifestyleItmRefModel extends RefGridModel {
	
	@Override
	public String[] getShowFieldCode() {
		return new String[] { PeEvalLifestyleItmDO.CODE, PeEvalLifestyleItmDO.NAME, PeEvalLifestyleItmDO.VALUE_REF };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PeEvalLifestyleItmDO.ID_PEEVALLIFESTYLEITM };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "项目编码", "项目姓名","参考值" };
	}

	@Override
	public String getPkFieldCode() {
		return PeEvalLifestyleItmDO.ID_PEEVALLIFESTYLEITM;
	}

	@Override
	public String getRefCodeField() {
		return PeEvalLifestyleItmDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return PeEvalLifestyleItmDO.NAME;
	}

	@Override
	public String getTableName() {
		return new PeEvalLifestyleItmDO().getTableName();
	}

}
