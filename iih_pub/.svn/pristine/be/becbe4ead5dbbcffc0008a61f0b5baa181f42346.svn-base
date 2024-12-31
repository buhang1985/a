package iih.pe.pitm.pesrvsetdef.refs;
import java.util.ArrayList;
import java.util.List;

import iih.pe.pitm.pesrvbcatlog.d.PeSrvbCatlogDO;
import iih.pe.pitm.pesrvsetdef.d.PeSrvSetDefDO;
import iih.pe.comm.utils.PeEnvContextUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.refinfo.RefGridModel;

//体检套餐定义参照
public class PeSrvSetDefRefModel extends RefGridModel {

	@Override
	public String[] getShowFieldCode() {
		return new String[] { PeSrvSetDefDO.CODE, PeSrvSetDefDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PeSrvSetDefDO.ID_PESRVSETDEF };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return PeSrvSetDefDO.ID_PESRVSETDEF;
	}

	@Override
	public String getRefCodeField() {
		return PeSrvSetDefDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return PeSrvSetDefDO.NAME;
	}

	@Override
	public String getTableName() {
		return new PeSrvSetDefDO().getTableName();
	}

	@Override
	public List<String> getOrderPart(){
		List<String> listOrderParts = new ArrayList<String>();
		listOrderParts.addAll(super.getOrderPart());
		listOrderParts.add(PeSrvSetDefDO.ID_PESRVSETDEF);
		listOrderParts.add(PeSrvSetDefDO.SORTNO);
		return listOrderParts;
	}
	

	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = new ArrayList<String>();
		listWhereParts.addAll(super.getWherePart());
		listWhereParts.add(PeEnvContextUtil.processEnvContext(new PeSrvSetDefDO(), false));
		return listWhereParts;
	}
}
