package iih.mm.po.purchase.refs;

import iih.mm.po.purchase.d.PurchaseOrderDO;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.Context;
import xap.sys.appfw.refinfo.RefGridModel;

public class PurchaseOrderRefModel extends RefGridModel {
	@Override
	public String[] getShowFieldCode() {
		return new String[]{PurchaseOrderDO.CODE,PurchaseOrderDO.NAME};
	}
	@Override
	public String[] getHiddenFieldCode() {
		return new String[]{PurchaseOrderDO.ID_PO, PurchaseOrderDO.ID_GRP, PurchaseOrderDO.ID_ORG};
	}
	@Override
	public String[] getShowFieldName() {
		return new String[]{"采购单号", "采购名称"};
	}
	@Override
	public String getPkFieldCode() {
		return PurchaseOrderDO.ID_PO;
	}
	@Override
	public String getRefCodeField() {
		return PurchaseOrderDO.CODE;
	}
	@Override
	public String getRefNameField() {
		return PurchaseOrderDO.NAME;
	}

	@Override
	public String getTableName() {
		return new PurchaseOrderDO().getTableName();
	}
	@Override
	public List<String> getOrderPart() {
		List<String> orderPart = new ArrayList<String>();
		orderPart.add(PurchaseOrderDO.CODE);
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
