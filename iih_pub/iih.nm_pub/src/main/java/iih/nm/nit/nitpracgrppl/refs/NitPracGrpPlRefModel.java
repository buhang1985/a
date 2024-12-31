package iih.nm.nit.nitpracgrppl.refs;

import iih.nm.nit.nitpracgrppl.d.NitPracgrpPlDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class NitPracGrpPlRefModel extends RefGridModel{
	
	@Override
	public String[] getShowFieldCode() {		
		return new String[] { NitPracgrpPlDO.NAME, NitPracgrpPlDO.DT_BEGIN,NitPracgrpPlDO.DT_END,NitPracgrpPlDO.TOTAL_WEEKS};
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "计划", "开始时间","结束时间","总周数" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		
		return new String[] {NitPracgrpPlDO.ID_PRACGRP_PL};
	}

	@Override
	public String getPkFieldCode() {
		
		return NitPracgrpPlDO.ID_PRACGRP_PL;
	}

	@Override
	public String getRefNameField() {
		
		return NitPracgrpPlDO.NAME;
	}

	@Override
	public String getTableName() {
		
		return new NitPracgrpPlDO().getTableName();
	}
	
}
