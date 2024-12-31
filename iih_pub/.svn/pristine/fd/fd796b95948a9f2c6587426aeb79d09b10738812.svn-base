package iih.pe.pitm.perstdisuppdef.refs;

import java.util.ArrayList;
import java.util.List;
import iih.pe.pitm.perstdisuppdef.d.PeRstDiSuppDefDO;
import iih.pe.comm.utils.PeEnvContextUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.refinfo.RefGridModel;
//诊断补充说明参照
public class PeRstDiSuppDefRefModel extends RefGridModel {

	@Override
	public String[] getShowFieldCode() {
		return new String[] { PeRstDiSuppDefDO.CODE, PeRstDiSuppDefDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PeRstDiSuppDefDO.ID_PERSTDISUPPDEF };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return PeRstDiSuppDefDO.ID_PERSTDISUPPDEF;
	}

	@Override
	public String getRefCodeField() {
		return PeRstDiSuppDefDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return PeRstDiSuppDefDO.NAME;
	}

	@Override
	public String getTableName() {
		return new PeRstDiSuppDefDO().getTableName();
	}

	@Override
	public List<String> getOrderPart(){
		List<String> listOrderParts = new ArrayList<String>();
		listOrderParts.addAll(super.getOrderPart());
		listOrderParts.add(PeRstDiSuppDefDO.CODE);
		return listOrderParts;
	}
	

	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = new ArrayList<String>();
		listWhereParts.addAll(super.getWherePart());
		listWhereParts.add(PeEnvContextUtil.processEnvContext(new PeRstDiSuppDefDO(), false));
		return listWhereParts;
	}
}
