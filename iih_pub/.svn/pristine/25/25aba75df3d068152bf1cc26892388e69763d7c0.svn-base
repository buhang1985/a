package iih.pe.phm.pehmedurecipe.refs;

import java.util.ArrayList;
import java.util.List;

import iih.pe.comm.utils.PeEnvContextUtil;
import iih.pe.phm.pehmedurecipe.d.PeHmEduRecipeDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class PeHmEduRecipeRefModel extends RefGridModel {
	
	@Override
	public String[] getShowFieldCode() {
		return new String[] { PeHmEduRecipeDO.CODE, PeHmEduRecipeDO.NAME,PeHmEduRecipeDO.EXPLAIN,PeHmEduRecipeDO.SYMPTOM,PeHmEduRecipeDO.MAINRISKS,PeHmEduRecipeDO.KEYPOINT,PeHmEduRecipeDO.NOTE };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PeHmEduRecipeDO.ID_EDURECIPE };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "姓名","解释","症状","主要危险因素","保健要点","特别说明" };
	}

	@Override
	public String getPkFieldCode() {
		return PeHmEduRecipeDO.ID_EDURECIPE;
	}

	@Override
	public String getRefCodeField() {
		return PeHmEduRecipeDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return PeHmEduRecipeDO.NAME;
	}

	@Override
	public String getTableName() {
		return new PeHmEduRecipeDO().getTableName();
	}
	
	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = new ArrayList<String>();
		listWhereParts.addAll(super.getWherePart());
		
		StringBuilder sb = new StringBuilder(" 1=1 ");
		sb.append(" and fg_active='Y' ");
		String str = PeEnvContextUtil.processEnvContext(new PeHmEduRecipeDO(), false);
		sb.append(String.format(" and %s ", str));
		
		listWhereParts.add(sb.toString());
		
		return listWhereParts;
	}

}
