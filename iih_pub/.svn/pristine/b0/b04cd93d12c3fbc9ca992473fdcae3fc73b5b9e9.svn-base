package iih.pe.por.pecorpbinfo.refs;

import java.util.ArrayList;
import java.util.List;

import iih.pe.comm.utils.PeEnvContextUtil;
import iih.pe.pitm.perstditp.d.PeRstDiTpDO;
import iih.pe.por.pecorpbinfo.d.PeCorpbInfoDO;
import xap.sys.appfw.refinfo.RefTreeModel;

public class PeCorpbInfoRefModel extends RefTreeModel {


	@Override
	public String[] getShowFieldCode() {
		return new String[] { PeCorpbInfoDO.CODE, PeCorpbInfoDO.NAME, PeCorpbInfoDO.PYCODE};
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PeCorpbInfoDO.ID_PECORPBINFO, PeCorpbInfoDO.ID_PECORPBINFO_PAR };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称", "检索码"};
	}

	@Override
	public String getPkFieldCode() {
		return PeCorpbInfoDO.ID_PECORPBINFO;
	}

	@Override
	public String getRefCodeField() {
		return PeCorpbInfoDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return PeCorpbInfoDO.NAME;
	}

	@Override
	public String getChildField() {
		return PeCorpbInfoDO.ID_PECORPBINFO;
	}

	@Override
	public String getFatherField() {
		return PeCorpbInfoDO.ID_PECORPBINFO_PAR;
	}

	@Override
	public String getTableName() {
		return new PeCorpbInfoDO().getTableName();
	}

	@Override
	public List<String> getOrderPart(){
		List<String> listOrderParts = new ArrayList<String>();
		listOrderParts.add(PeCorpbInfoDO.CODE + " desc");
		return listOrderParts;
	}

	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = new ArrayList<String>();
		listWhereParts.addAll(super.getWherePart());
		listWhereParts.add(PeEnvContextUtil.processEnvContext(new PeCorpbInfoDO(), false));
		return listWhereParts;
	}
	
	@Override
	public String afterBuilderSql(String sql) {

		return super.afterBuilderSql(sql);
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { PeCorpbInfoDO.NAME, PeCorpbInfoDO.CODE, PeCorpbInfoDO.PYCODE };
	}
}
