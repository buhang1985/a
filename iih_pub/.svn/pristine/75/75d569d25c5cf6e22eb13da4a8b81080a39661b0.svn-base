package iih.pe.pqn.peevalnutrition.refs;

import iih.pe.pqn.peevalnutrition.d.PeEvalNutritionClsDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class PeEvalNutritionClsRefModel extends RefGridModel {
	
	@Override
	public String[] getShowFieldCode() {
		return new String[] { PeEvalNutritionClsDO.CODE, PeEvalNutritionClsDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PeEvalNutritionClsDO.ID_PEEVALNUTRITIONCLS };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return PeEvalNutritionClsDO.ID_PEEVALNUTRITIONCLS;
	}

	@Override
	public String getRefCodeField() {
		return PeEvalNutritionClsDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return PeEvalNutritionClsDO.NAME;
	}

	@Override
	public String getTableName() {
		return new PeEvalNutritionClsDO().getTableName();
	}

}
