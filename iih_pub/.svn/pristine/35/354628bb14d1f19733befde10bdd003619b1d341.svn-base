package iih.pe.pqn.peqacatlog.refs;

import java.util.ArrayList;
import java.util.List;

import iih.pe.pqn.peqacatlog.d.PeQaCatDO;
import iih.pe.comm.utils.PeEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class PeQaCatRefModel extends RefGridModel {

	public PeQaCatRefModel() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String[] getShowFieldCode() {
		return new String[] { PeQaCatDO.CODE, PeQaCatDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PeQaCatDO.ID_PEQACATLOG };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return PeQaCatDO.ID_PEQACATLOG;
	}

	@Override
	public String getRefCodeField() {
		return PeQaCatDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return PeQaCatDO.NAME;
	}

	@Override
	public String getTableName() {
		return new PeQaCatDO  ().getTableName();
	}


	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = new ArrayList<String>();
		listWhereParts.addAll(super.getWherePart());
		listWhereParts.add(PeEnvContextUtil.processEnvContext(new PeQaCatDO(), false) + " order by code");
		return listWhereParts;
	}
}
