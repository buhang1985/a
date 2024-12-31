package iih.hp.cp.hpcp.refs;

import iih.bd.bc.udi.pub.IHPDictCodeConst;
import iih.hp.cp.hpcp.d.HpCpDO;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.Context;
import xap.sys.appfw.refinfo.RefGridModel;

public class HpcpRefModel extends RefGridModel {
	@Override
	public String[] getShowFieldCode() {
		return new String[] { HpCpDO.CODE, HpCpDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { HpCpDO.ID_CP, HpCpDO.ID_GRP,
				HpCpDO.ID_ORG, HpCpDO.PYCODE, HpCpDO.WBCODE, HpCpDO.MNECODE };
	}
	
	@Override
	public String[] getBlurFields() {
		return new String[] { HpCpDO.CODE, HpCpDO.NAME,
				HpCpDO.PYCODE, HpCpDO.WBCODE, HpCpDO.MNECODE };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return HpCpDO.ID_CP;
	}

	@Override
	public String getRefCodeField() {
		return HpCpDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return HpCpDO.NAME;
	}

	@Override
	public String getTableName() {
		return new HpCpDO().getTableName();
	}
	
	@Override
	public List<String> getOrderPart() {
		List<String> orderPart = new ArrayList<String>();
		orderPart.add(HpCpDO.CODE);
		return orderPart;
	}
	
	@Override
	public String getRefSql() {
		StringBuffer wherePartBuffer = new StringBuffer();
		wherePartBuffer.append(" sd_status = '" + IHPDictCodeConst.SD_HPCP_STATUS_ENABLE + "' ");
		wherePartBuffer.append(" and id_grp = '" + Context.get().getGroupId() + "' ");
		wherePartBuffer.append(" and id_org = '" + Context.get().getOrgId() + "' ");
		wherePartBuffer.append(" and ds = 0 ");
		
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
