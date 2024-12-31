package iih.pe.pbd.peinstrument.refs;
import java.util.ArrayList;
import java.util.List;


import iih.pe.pbd.peinstrument.d.PeInstrumentDO;
import iih.pe.comm.utils.PeEnvContextUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.refinfo.RefGridModel;

public class PeInstrumentRefModel extends RefGridModel {


	@Override
	public String[] getShowFieldCode() {
		return new String[] { PeInstrumentDO.CODE, PeInstrumentDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PeInstrumentDO.ID_PEINSTRUMENT };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "设备编码", "设备名称" };
	}

	@Override
	public String getPkFieldCode() {
		return PeInstrumentDO.ID_PEINSTRUMENT;
	}

	@Override
	public String getRefCodeField() {
		return PeInstrumentDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return PeInstrumentDO.NAME;
	}

	@Override
	public String getTableName() {
		return new PeInstrumentDO().getTableName();
	}

	@Override
	public List<String> getOrderPart(){
		List<String> listOrderParts = new ArrayList<String>();
		listOrderParts.addAll(super.getOrderPart());
		return listOrderParts;
	}
	

	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = new ArrayList<String>();
		listWhereParts.addAll(super.getWherePart());
		listWhereParts.add(PeEnvContextUtil.processEnvContext(new PeInstrumentDO(), false));
		return listWhereParts;
	}
}

