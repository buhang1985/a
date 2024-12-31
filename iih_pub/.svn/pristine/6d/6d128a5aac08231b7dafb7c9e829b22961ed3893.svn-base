package iih.pe.phm.pehmer.refs;

import java.util.ArrayList;
import java.util.List;

import iih.pe.comm.utils.PeEnvContextUtil;
import iih.pe.phm.pehmer.d.PeHmerDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class PeHmerRefModel extends RefGridModel {
	
	@Override
	public String[] getShowFieldCode() {
		return new String[] { PeHmerDO.CODE, PeHmerDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		//return new String[] { PeHmerDO.ID_PEHMER };
		return new String[] { PeHmerDO.ID_USER };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "姓名" };
	}

	@Override
	public String getPkFieldCode() {
		//return PeHmerDO.ID_PEHMER;
		return PeHmerDO.ID_USER;
	}

	@Override
	public String getRefCodeField() {
		return PeHmerDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return PeHmerDO.NAME;
	}

	@Override
	public String getTableName() {
		return new PeHmerDO().getTableName();
	}
	
	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = new ArrayList<String>();
		listWhereParts.addAll(super.getWherePart());
		
		StringBuilder sb = new StringBuilder(" 1=1 ");
		sb.append(" and fg_active='Y' ");
		String str = PeEnvContextUtil.processEnvContext(new PeHmerDO(), false);
		sb.append(String.format(" and %s ", str));
		
		listWhereParts.add(sb.toString());
		
		return listWhereParts;
	}

}
