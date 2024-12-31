package iih.pi.dic.creditcategory.refs;

import iih.pi.dic.creditcategory.d.PiPatCretDO;

import java.util.List;

import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.permfw.pub.EnvContextUtil;


public class CreditRefModel extends RefGridModel{

	private static final long serialVersionUID = 1L;
	
	@Override
	public String[] getShowFieldCode(){
		return new String[]{PiPatCretDO.CODE,PiPatCretDO.NAME};
	}
	
	@Override
	public String[] getHiddenFieldCode(){
		return new String[]{PiPatCretDO.ID_PATCRET};
	}
	
	@Override
	public String[] getShowFieldName(){
		return new String[]{"编码","名称"};
	}
	
	@Override
	public String[] getBlurFields() {
		return new String[] { PiPatCretDO.CODE, PiPatCretDO.NAME,PiPatCretDO.PYCODE,PiPatCretDO.WBCODE,PiPatCretDO.MNECODE };
	}
	
	@Override
	public String getPkFieldCode(){
		return PiPatCretDO.ID_PATCRET;
	}
	
	@Override
	public String getRefCodeField(){
		return PiPatCretDO.CODE;
	}
	
	@Override
	public String getRefNameField(){
		return PiPatCretDO.NAME;
	}
	
	@Override
	public String getTableName(){
		return new PiPatCretDO().getTableName();
	}
	 
	@Override
	public List<String> getWherePart() {
		List<String> ret = super.getWherePart();
		ret.add(" ds= 0 ");
		String orgSql = EnvContextUtil.processEnvContext("", new PiPatCretDO(),false);
		ret.add(orgSql);
		return ret;
	}
	
	@Override
	public List<String> getOrderPart() {
		List<String> ret = super.getOrderPart();
		ret.add(PiPatCretDO.CODE);
		return ret;
	}
}
