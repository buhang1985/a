package iih.mm.pl.poplanstrategy.refs;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import iih.mm.pl.poplanstrategy.d.PoPlanStrategyDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class PoPlanStrategyRefModel extends RefGridModel{
	@Override
	public String[] getShowFieldCode() {
		return new String[]{PoPlanStrategyDO.NAME,PoPlanStrategyDO.WH_NAME};
	}
	@Override
	public String[] getHiddenFieldCode() {
		return new String[]{PoPlanStrategyDO.ID_STRATEGY,PoPlanStrategyDO.ID_GRP,PoPlanStrategyDO.ID_ORG,PoPlanStrategyDO.ID_WH};
	}
	@Override
	public String[] getShowFieldName() {
		return new String[]{"策略名称", "仓库"};
	}
	@Override
	public String getPkFieldCode() {
		return PoPlanStrategyDO.ID_STRATEGY;
	}
	/*@Override
	public String getRefCodeField() {
		return StockPlanDO.CODE;
	}*/
	
	@Override
	public String[] getBlurFields() {
		return new String[]{PoPlanStrategyDO.NAME};
	}
	
	@Override
	public String getRefNameField() {
		return PoPlanStrategyDO.NAME;
	}

	@Override
	public String getTableName() {
		return "pl";
	}
	
	@Override
	public String getRefSql() {
		String id_wh = (String) this.getExtendAttributeValue("id_wh");
		
		StringBuffer wherePartBuffer = new StringBuffer("1 = 1");
		if (!StringUtils.isBlank(id_wh)) {
			wherePartBuffer.append(" and wh.id_wh like '" + id_wh + "%' ");
		}
		String wherePart = wherePartBuffer.toString();
		this.addWherePart(wherePart);
		
		StringBuffer sql = new StringBuffer();
		sql.append("select pl.name,            ");
		sql.append("       wh.name as wh_name, ");
		sql.append("       pl.id_strategy,     ");
		sql.append("       pl.id_grp,          ");
		sql.append("       pl.id_org,          ");
		sql.append("       pl.id_wh            ");
		sql.append("  from mm_pl_strategy pl   ");
		sql.append("  left join bd_wh wh       ");
		sql.append("    on pl.id_wh = wh.id_wh ");
		List<String> whereList = this.getWherePart();
		if (whereList.size() > 0) {
			sql.append(" where 1 = 1 ");
			for (String where : this.getWherePart()) {
				sql.append(" and (").append(where).append(") ");
			}
		}
		return sql.toString();
	}
}
