package iih.pe.pitm.perstsuggdef.refs;

import java.util.ArrayList;
import java.util.List;

import iih.pe.pitm.perstsuggdef.d.PeRstSuggDefDO;
import iih.pe.comm.utils.PeEnvContextUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.refinfo.RefGridModel;
//诊断建议定义参照
public class PeRstSuggDefRefModel extends RefGridModel {

	@Override
	public String[] getShowFieldCode() {
		return new String[] { PeRstSuggDefDO.CODE, PeRstSuggDefDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PeRstSuggDefDO.ID_PERSTSUGGDEF };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return PeRstSuggDefDO.ID_PERSTSUGGDEF;
	}

	@Override
	public String getRefCodeField() {
		return PeRstSuggDefDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return PeRstSuggDefDO.NAME;
	}

	@Override
	public String getTableName() {
		return new PeRstSuggDefDO().getTableName();
	}

	@Override
	public List<String> getOrderPart(){
		List<String> listOrderParts = new ArrayList<String>();
		listOrderParts.addAll(super.getOrderPart());
		listOrderParts.add(PeRstSuggDefDO.SORTNO);
		return listOrderParts;
	}
	

	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = new ArrayList<String>();
		listWhereParts.addAll(super.getWherePart());
		listWhereParts.add(PeEnvContextUtil.processEnvContext(new PeRstSuggDefDO(), false));
		return listWhereParts;
	}
}
