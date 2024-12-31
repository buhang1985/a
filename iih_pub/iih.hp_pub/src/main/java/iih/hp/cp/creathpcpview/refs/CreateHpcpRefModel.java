package iih.hp.cp.creathpcpview.refs;

import iih.hp.cp.creathpcpview.d.CreatHpcpView;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.Context;
import xap.sys.appfw.refinfo.RefGridModel;

public class CreateHpcpRefModel extends RefGridModel {
	
	@Override
	public String[] getShowFieldCode() {
		return new String[] { CreatHpcpView.CP_CODE, CreatHpcpView.CP_NAME, CreatHpcpView.CP_NUM };
	}
	
	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { CreatHpcpView.ID_CP, CreatHpcpView.ID_GRP,
				CreatHpcpView.ID_ORG, CreatHpcpView.PYCODE, CreatHpcpView.WBCODE, CreatHpcpView.MNECODE };
	}
	
	@Override
	public String[] getBlurFields() {
		return new String[] { CreatHpcpView.CP_CODE, CreatHpcpView.CP_NAME,
				CreatHpcpView.PYCODE, CreatHpcpView.WBCODE, CreatHpcpView.MNECODE };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称", "患者数" };
	}

	@Override
	public String getPkFieldCode() {
		return CreatHpcpView.ID_CP;
	}

	@Override
	public String getRefCodeField() {
		return CreatHpcpView.CP_CODE;
	}

	@Override
	public String getRefNameField() {
		return CreatHpcpView.CP_NAME;
	}

	@Override
	public String getTableName() {
		return new CreatHpcpView().getTableName();
	}
	
	@Override
	public List<String> getOrderPart() {
		List<String> orderPart = new ArrayList<String>();
		orderPart.add(CreatHpcpView.CP_CODE);
		return orderPart;
	}
	
	@Override
	public String getRefSql() {
		StringBuffer wherePartBuffer = new StringBuffer();
		wherePartBuffer.append(" id_grp = '" + Context.get().getGroupId() + "' ");
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
