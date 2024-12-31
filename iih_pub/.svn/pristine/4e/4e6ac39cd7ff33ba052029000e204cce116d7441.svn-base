package iih.pi.reg.pat.refs;

import java.util.ArrayList;
import java.util.List;

import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.permfw.pub.EnvContextUtil;
import iih.pi.reg.pat.d.PatDO;


public class PatiRefModel extends RefGridModel {
	@Override
	public String[] getShowFieldCode(){
		return new String[]{PatDO.CODE,PatDO.NAME};
	}
	@Override
	public String[] getHiddenFieldCode(){
		return new String[]{PatDO.ID_PAT};
	}
	@Override
	public String[] getShowFieldName(){
		return new String[]{"编码","名称"};
	}
	@Override
	public String getPkFieldCode(){
		return PatDO.ID_PAT;
	}
	@Override
	public String getTableName(){
		return new PatDO().getTableName();
	}
	@Override
	public String getRefCodeField(){
		return PatDO.CODE;
	}
	@Override
	public String getRefNameField(){
		return PatDO.NAME;
	}
	
	@Override
	public List<String> getOrderPart() {
		List<String> orderList =  super.getOrderPart();
		if(orderList.contains(PatDO.CODE))
			return orderList;
		
		orderList.add(PatDO.CODE);
		return orderList;
	}
	
	@Override
	public String[] getBlurFields() {
		return new String[]{PatDO.CODE,PatDO.NAME,PatDO.PYCODE,PatDO.WBCODE};
	}
	
  	@Override
	public List<String> getWherePart() {
		List<String> wheres = super.getWherePart();
		if (wheres == null) {
			wheres = new ArrayList<String>();
		}
		String orgSql = EnvContextUtil.processEnvContext("",new PatDO(),false);
		wheres.add(orgSql);
		return wheres;		
	}
}
