package iih.pe.pitm.peexercise.d.refs;

import java.util.ArrayList;
import java.util.List;

import iih.pe.comm.utils.PeEnvContextUtil;
import iih.pe.pitm.peexercise.d.PeExerciseDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class PeExerciseRefModel extends RefGridModel {
	
	@Override
	public String[] getShowFieldCode() {
		return new String[] { PeExerciseDO.CODE, PeExerciseDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PeExerciseDO.ID_PEEXERCISE };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return PeExerciseDO.ID_PEEXERCISE;
	}

	@Override
	public String getRefCodeField() {
		return PeExerciseDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return PeExerciseDO.NAME;
	}

	@Override
	public String getTableName() {
		return new PeExerciseDO().getTableName();
	}
	
	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = new ArrayList<String>();
		listWhereParts.addAll(super.getWherePart());
		listWhereParts.add(PeEnvContextUtil.processEnvContext(new PeExerciseDO(), false));
		return listWhereParts;
	}

}
