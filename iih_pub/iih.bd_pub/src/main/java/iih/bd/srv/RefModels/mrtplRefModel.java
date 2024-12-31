package iih.bd.srv.RefModels;

import java.util.List;

import iih.bd.srv.emrtpl.d.EmrTplDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class mrtplRefModel extends RefGridModel {
	@Override
	public String[] getShowFieldCode() {
		// TODO Auto-generated method stub
		return new String[] { EmrTplDO.NAME, EmrTplDO.CODE };
	}

	@Override
	public String[] getHiddenFieldCode() {
		// TODO Auto-generated method stub
		return new String[] { EmrTplDO.ID_MRTPL };
	}

	@Override
	public String[] getShowFieldName() {
		// TODO Auto-generated method stub
		return new String[] { "模板名称", "编码" };
	}

	@Override
	public String getPkFieldCode() {
		// TODO Auto-generated method stub
		return EmrTplDO.ID_MRTPL;
	}

	@Override
	public String getRefCodeField() {
		// TODO Auto-generated method stub
		return EmrTplDO.CODE;
	}

	@Override
	public String getRefNameField() {
		// TODO Auto-generated method stub
		return EmrTplDO.NAME;
	}

	@Override
	public String getTableName() {
		return new EmrTplDO().getTableName();
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { EmrTplDO.CODE, EmrTplDO.NAME, EmrTplDO.WBCODE, EmrTplDO.PYCODE, EmrTplDO.MNECODE };
	}
	
	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = super.getWherePart();
		listWhereParts.add(BdEnvContextUtil.processEnvContext(new EmrTplDO(), false));
		return listWhereParts;
	}
}