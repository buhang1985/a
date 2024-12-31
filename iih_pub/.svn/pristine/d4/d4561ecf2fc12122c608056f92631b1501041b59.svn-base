package iih.nm.nom.nmnomwbk.refs;

import iih.nm.com.ref.ComRefGridModel;
import iih.nm.nom.nmnomwbk.d.NmNomWbkDO;
import xap.mw.coreitf.i.IBaseDO;

public class NomWbkModel extends ComRefGridModel {

	@Override
	public String[] getShowFieldCode() {

		return new String[] { NmNomWbkDO.NAME };
	}

	@Override
	public String[] getShowFieldName() {

		return new String[] { "护士长手册名称" };
	}

	@Override
	public String getPkFieldCode() {

		return NmNomWbkDO.ID_NOM_WBK;
	}

	@Override
	public String getRefCodeField() {

		return NmNomWbkDO.ID_NOM_WBK;
	}

	@Override
	public String getRefNameField() {

		return NmNomWbkDO.NAME;
	}
	
	public IBaseDO getBaseDO(){
		
		return new NmNomWbkDO();
	}	
}
