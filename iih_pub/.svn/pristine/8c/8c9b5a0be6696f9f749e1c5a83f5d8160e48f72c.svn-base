package iih.pe.papt.pehmappt.refs;

import iih.pe.papt.pehmappt.d.PeHmApptDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class PeHmApptRefModel extends RefGridModel {
	
	@Override
	public String[] getShowFieldCode() {
		return new String[] { PeHmApptDO.NO_APPT, PeHmApptDO.DT_APPT };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PeHmApptDO.ID_PEHMAPPT };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "预约号", "预约日期" };
	}

	@Override
	public String getPkFieldCode() {
		return PeHmApptDO.ID_PEHMAPPT;
	}

	@Override
	public String getRefCodeField() {
		return PeHmApptDO.NO_APPT;
	}

	@Override
	public String getRefNameField() {
		return PeHmApptDO.NO_APPT;
	}

	@Override
	public String getTableName() {
		return new PeHmApptDO().getTableName();
	}

}
