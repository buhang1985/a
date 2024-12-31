package iih.pe.pitm.perstsuggtp.refs;

import java.util.ArrayList;
import java.util.List;

import iih.pe.pitm.perstsuggtp.d.PeRstSuggTpDO;
import iih.pe.comm.utils.PeEnvContextUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.refinfo.RefGridModel;
//诊断建议定义参照
public class PeRstSuggTpRefModel extends RefGridModel {

	@Override
	public String[] getShowFieldCode() {
		return new String[] { PeRstSuggTpDO.CODE, PeRstSuggTpDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PeRstSuggTpDO.ID_PERSTSUGGTP };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return PeRstSuggTpDO.ID_PERSTSUGGTP;
	}

	@Override
	public String getRefCodeField() {
		return PeRstSuggTpDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return PeRstSuggTpDO.NAME;
	}

	@Override
	public String getTableName() {
		return new PeRstSuggTpDO().getTableName();
	}

	@Override
	public List<String> getOrderPart(){
		List<String> listOrderParts = new ArrayList<String>();
		listOrderParts.addAll(super.getOrderPart());
		listOrderParts.add(PeRstSuggTpDO.SORTNO);
		return listOrderParts;
	}
	

	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = new ArrayList<String>();
		listWhereParts.addAll(super.getWherePart());
		listWhereParts.add(PeEnvContextUtil.processEnvContext(new PeRstSuggTpDO(), false));
		return listWhereParts;
	}
}