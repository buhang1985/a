package iih.sc.scbd.refs;

import java.util.List;

import iih.bd.utils.BdEnvContextUtil;
import iih.sc.scbd.scheduleca.d.ScheduleCADO;
import iih.sc.scbd.scprttmpl.d.ScPrtTmplDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class ScPrtTmplRefModel extends RefGridModel {

	@Override
	public String[] getShowFieldCode(){
		return new String[]{ScPrtTmplDO.CODE,ScPrtTmplDO.NAME};
	}
	@Override
	public String[] getHiddenFieldCode(){
		return new String[]{ScPrtTmplDO.ID_PRTTMPL};
	}
	@Override
	public String[] getShowFieldName(){
		return new String[]{"编码","名称"};
	}
	@Override
	public String getPkFieldCode(){
		return ScPrtTmplDO.ID_PRTTMPL;
	}
	@Override
	public String getTableName(){
		return new ScPrtTmplDO().getTableName();
	}
	@Override
	public String getRefCodeField(){
		return ScPrtTmplDO.CODE;
	}
	@Override
	public String getRefNameField(){
		return ScPrtTmplDO.NAME;
	}
}
