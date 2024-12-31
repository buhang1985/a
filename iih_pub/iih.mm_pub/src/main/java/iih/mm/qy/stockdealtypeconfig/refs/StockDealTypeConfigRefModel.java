package iih.mm.qy.stockdealtypeconfig.refs;

import iih.bd.mm.mmcategory.d.MMCategoryDO;
import iih.mm.qy.stockdealtypeconfig.d.StockDealTypeConfigDO;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import xap.sys.appfw.refinfo.RefGridModel;

public class StockDealTypeConfigRefModel extends RefGridModel {
	@Override
	public String[] getShowFieldCode(){
		return new String[]{StockDealTypeConfigDO.NAME};
	}
	@Override
	public String[] getHiddenFieldCode(){
		return new String[]{StockDealTypeConfigDO.ID_SDT};
	}
	@Override
	public String[] getShowFieldName(){
		return new String[]{"名称"};
	}
	@Override
	public String getPkFieldCode(){
		return StockDealTypeConfigDO.ID_SDT;
	}
	@Override
	public String getTableName(){
		return new StockDealTypeConfigDO().getTableName();
	}
	@Override
	public String getRefCodeField(){
		return StockDealTypeConfigDO.ID_SDT;
		
	}
	@Override
	public String getRefNameField(){
		return MMCategoryDO.NAME;
		
	}
	@Override
	public List<String> getOrderPart() {
		List<String> orderPart = new ArrayList<String>();
		orderPart.add(StockDealTypeConfigDO.NAME);
		return orderPart;
	}
	@Override
	public String[] getBlurFields() {
		return new String[] { StockDealTypeConfigDO.NAME,
				StockDealTypeConfigDO.PYCODE, StockDealTypeConfigDO.WBCODE};
	}
	
	@Override
	public String getRefSql() {	
		String direction = (String) this.getExtendAttributeValue("direction");
		
		StringBuffer wherePartBuffer = new StringBuffer();
		wherePartBuffer.append("ds=0");
		
		if (!StringUtils.isBlank(direction)) {
			wherePartBuffer.append(" and direction = '" + direction + "' ");
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
