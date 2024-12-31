package iih.pi.dic.phyind.refs;

import iih.pi.dic.phyind.d.PiPatPhyIndDO;
import iih.pi.dic.phyind.d.PiPatPhyIndOptDO;
import iih.pi.reg.pat.d.PatDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class PhyindRefModel extends RefGridModel {
	@Override
	public String[] getShowFieldCode(){
		return new String[]{PiPatPhyIndDO.CODE,PiPatPhyIndDO.NAME};
	}
	@Override
	public String[] getHiddenFieldCode(){
		return new String[]{PiPatPhyIndDO.ID_PATPHYIND};
	}
	@Override
	public String[] getShowFieldName(){
		return new String[]{"编码","名称"};
	}
	@Override
	public String[] getBlurFields() {
		return new String[] { PiPatPhyIndDO.CODE, PiPatPhyIndDO.NAME, PiPatPhyIndDO.PYCODE, PiPatPhyIndDO.WBCODE };
	}
	@Override
	public String getPkFieldCode(){
		return PiPatPhyIndDO.ID_PATPHYIND;
	}
	@Override
	public String getTableName(){
		return new PiPatPhyIndDO().getTableName();
	}
	@Override
	public String getRefCodeField(){
		return PiPatPhyIndDO.CODE;
	}
	@Override
	public String getRefNameField(){
		return PatDO.NAME;
	}
}
