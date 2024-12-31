package iih.bd.res.dayslot.refs;

import java.util.ArrayList;
import java.util.List;

import iih.bd.res.dayslot.d.DaysLotDO;
import iih.bd.res.dayslot.d.desc.DaysLotDODesc;
import iih.bd.res.dayslotca.d.DaysLotcaDO;
import iih.bd.res.dayslotca.d.desc.DaysLotcaDODesc;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class DaySlotShowDaylotCaRefModel extends RefGridModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { DaysLotDO.CODE, DaysLotDO.NAME ,DaysLotDO.NAME_DAYSLOTCA};
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { DaysLotDO.ID_DAYSLOT, DaysLotDO.TIME_BEGIN };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" ,"日期分组类型"};
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
		return DaysLotDO.NAME;
	}
	
	public String getRefTimeEndField() {
		return DaysLotcaDO.NAME;
	}
	public String getRefDaySlotTpNAMEEndField() {
		return DaysLotDO.NAME_DAYSLOTCA;
	}
	@Override
	public String getTableName() {
		return DaysLotDODesc.TABLE_NAME;
	}
	
	@Override
	public String[] getBlurFields() {
		return new String[] { DaysLotDO.CODE, DaysLotDO.NAME,DaysLotDO.NAME_DAYSLOTCA, DaysLotDO.PYCODE, DaysLotDO.WBCODE, DaysLotDO.MNECODE };
	}

	@Override
	public String getRefSql() {
		StringBuilder refSql = new StringBuilder();
			refSql.append(" select bd_dayslot.Code,    bd_dayslot.Name,  bd_dayslotca.name as Name_dayslotca,    bd_dayslot.Id_dayslot,   bd_dayslot.Time_begin  ");
			refSql.append(" from bd_dayslot bd_dayslot inner join bd_dayslotca bd_dayslotca on bd_dayslot.id_dayslotca = bd_dayslotca.id_dayslotca ");
			refSql.append(" where 1 = 1   and  ");
			refSql.append(" bd_dayslot.fg_active = 'Y'  and bd_dayslot.id_dayslotca in   (select id_dayslotca     from bd_dayslotca  where sd_dayslotcatp in ('1', '2'))");
			refSql.append(" and " + BuildWherePart());
		    refSql.append( " order by bd_dayslotca.code,bd_dayslot.Sortno ");

		return refSql.toString();
	}

	/**
	 * 构建条件语句
	 * 
	 * @return
	 */
	private String BuildWherePart() {
		StringBuilder stringBuilder = new StringBuilder("1 = 1");
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new DaysLotDO(), false);
		stringBuilder.append(String.format(" and %s ", BdModeWherePart));
		return stringBuilder.toString();
	}

}
