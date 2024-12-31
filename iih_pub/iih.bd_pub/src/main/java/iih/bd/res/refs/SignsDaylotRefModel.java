package iih.bd.res.refs;

import xap.sys.appfw.refinfo.RefGridModel;
import iih.bd.res.dayslot.d.DaysLotDO;

public class SignsDaylotRefModel extends RefGridModel {
	@Override
	public String[] getShowFieldCode() {
		return new String[]{DaysLotDO.TIME_BEGIN,DaysLotDO.CODE};
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[]{DaysLotDO.ID_DAYSLOT};
	}

	@Override
	public String[] getShowFieldName() {
		return new String[]{"测量时间","编码"};
	}

	@Override
	public String getPkFieldCode() {
		return DaysLotDO.ID_DAYSLOT;
	}

	@Override
	public String getRefCodeField() {
		return DaysLotDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return DaysLotDO.TIME_BEGIN;
	}
	
	@Override
	public String getRefSql() {

		String refSql=	"select time_begin,code,id_dayslot from bd_dayslot where id_dayslotca='0001AA1000000002NJ1R'  order by time_begin asc";
		return refSql;
	}

	@Override
	public String getTableName() {
		return new DaysLotDO().getTableName();
	}
	
}
