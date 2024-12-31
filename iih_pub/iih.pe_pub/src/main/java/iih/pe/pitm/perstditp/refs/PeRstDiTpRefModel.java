package iih.pe.pitm.perstditp.refs;

import java.util.ArrayList;
import java.util.List;

import iih.pe.pitm.perstditp.d.PeRstDiTpDO;
import iih.pe.comm.utils.PeEnvContextUtil;
import xap.sys.appfw.refinfo.RefTreeModel;

public class PeRstDiTpRefModel extends RefTreeModel {


	@Override
	public String[] getShowFieldCode() {
		return new String[] { PeRstDiTpDO.CODE, PeRstDiTpDO.NAME};
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PeRstDiTpDO.ID_PERSTDITP, PeRstDiTpDO.ID_PERSTDITP_PAR };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "诊断目录编码", "诊断目录名称"};
	}

	@Override
	public String getPkFieldCode() {
		return PeRstDiTpDO.ID_PERSTDITP;
	}

	@Override
	public String getRefCodeField() {
		return PeRstDiTpDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return PeRstDiTpDO.NAME;
	}

	@Override
	public String getChildField() {
		return PeRstDiTpDO.ID_PERSTDITP;
	}

	@Override
	public String getFatherField() {
		return PeRstDiTpDO.ID_PERSTDITP_PAR;
	}

	@Override
	public String getTableName() {
		return new PeRstDiTpDO().getTableName();
	}

	@Override
	public List<String> getOrderPart(){
		List<String> listOrderParts = new ArrayList<String>();
		listOrderParts.add(PeRstDiTpDO.SORTNO);
		return listOrderParts;
	}

	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = new ArrayList<String>();
		listWhereParts.addAll(super.getWherePart());
		listWhereParts.add(PeEnvContextUtil.processEnvContext(new PeRstDiTpDO(), false));
		return listWhereParts;
	}
	@Override
	public String afterBuilderSql(String sql) {

		return super.afterBuilderSql(sql);
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { PeRstDiTpDO.NAME, PeRstDiTpDO.CODE };
	}
}
