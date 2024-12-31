package iih.pe.pqn.peqacatlog.refs;

import java.util.ArrayList;
import java.util.List;

import iih.pe.comm.utils.PeEnvContextUtil;
import iih.pe.pqn.peqacatlog.d.PeQaCatGrdDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class PeQaCatGrdRefModel extends RefGridModel {

	public PeQaCatGrdRefModel() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String[] getShowFieldCode() {
		return new String[] { PeQaCatGrdDO.CODE, PeQaCatGrdDO.NAME,PeQaCatGrdDO.CLASSLABEL,PeQaCatGrdDO.SCORE_BEGIN,PeQaCatGrdDO.SCORE_END };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PeQaCatGrdDO.ID_PEQACATGRD };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称","类别标签","起始分值","结束分值" };
	}

	@Override
	public String getPkFieldCode() {
		return PeQaCatGrdDO.ID_PEQACATGRD;
	}

	@Override
	public String getRefCodeField() {
		return PeQaCatGrdDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return PeQaCatGrdDO.NAME;
	}

	@Override
	public String getTableName() {
		return new PeQaCatGrdDO  ().getTableName();
	}


	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = new ArrayList<String>();
		listWhereParts.addAll(super.getWherePart());
		listWhereParts.add(PeEnvContextUtil.processEnvContext(new PeQaCatGrdDO(), false));
		return listWhereParts;
	}

}
