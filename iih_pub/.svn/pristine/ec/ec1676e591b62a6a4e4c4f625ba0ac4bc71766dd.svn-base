package iih.nm.nqm.qctplelemaintenance.refs;

import iih.nm.nqm.qctplelemaintenance.d.NmQctplEleDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class NmQctplEleModel extends RefGridModel {

	@Override
	public String[] getShowFieldCode() {
		
		return new String[] { NmQctplEleDO.NAME, NmQctplEleDO.CODE,NmQctplEleDO.ID_QCTPL_ELE };
	}

	@Override
	public String[] getShowFieldName() {
	
		return new String[] { "元素名称", "元素编码","元素id" };
	}

//	@Override
//	public String[] getHiddenFieldCode() {
//
//		return new String[] { NmQctplCaDO.CODE };
//	}

	@Override
	public String getPkFieldCode() {

		return NmQctplEleDO.ID_QCTPL_ELE;
	}

	@Override
	public String getRefCodeField() {

		return NmQctplEleDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return NmQctplEleDO.NAME;
	}

	@Override
	public String getTableName() {
		return new NmQctplEleDO().getTableName();
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { NmQctplEleDO.ID_QCTPL_ELE, NmQctplEleDO.NAME,NmQctplEleDO.CODE };
	}


}
