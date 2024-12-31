package iih.mm.pl.stockplan.refs;

import iih.mm.pl.stockplan.d.StockPlanDO;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.Context;
import xap.sys.appfw.refinfo.RefGridModel;

public class StockplanRefModel extends RefGridModel {
	@Override
	public String[] getShowFieldCode() {
		return new String[]{StockPlanDO.CODE,StockPlanDO.NAME,StockPlanDO.CREATEDTIME};
	}
	@Override
	public String[] getHiddenFieldCode() {
		return new String[]{StockPlanDO.ID_PL,StockPlanDO.ID_GRP,StockPlanDO.ID_ORG,StockPlanDO.ID_WH};
	}
	@Override
	public String[] getShowFieldName() {
		return new String[]{"计划单号", "计划名称", "申请日期"};
	}
	@Override
	public String getPkFieldCode() {
		return StockPlanDO.ID_PL;
	}
	@Override
	public String getRefCodeField() {
		return StockPlanDO.CODE;
	}
	@Override
	public String getRefNameField() {
		return StockPlanDO.NAME;
	}

	@Override
	public String getTableName() {
		return new StockPlanDO().getTableName();
	}
	@Override
	public List<String> getOrderPart() {
		List<String> orderPart = new ArrayList<String>();
		orderPart.add(StockPlanDO.CODE);
		return orderPart;
	}
	
	@Override
	public String getRefSql() {
		String id_org = Context.get().getOrgId();
		
		StringBuffer wherePartBuffer = new StringBuffer();
		wherePartBuffer.append("ds=0");
		
		if(!StringUtils.isBlank(id_org)){
			wherePartBuffer.append(" and id_org = '" + id_org +"' ");
		}

		String wherePart = wherePartBuffer.toString();
		this.addWherePart(wherePart);
		String sql = null;
		try {
			sql = super.getRefSql();
		} finally {
			this.removeWherePart(wherePart);
		}

		return sql;
	}
}
