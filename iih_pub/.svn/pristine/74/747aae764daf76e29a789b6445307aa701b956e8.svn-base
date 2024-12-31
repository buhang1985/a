package iih.pi.dic.cardtype.refs;


import java.util.ArrayList;
import java.util.List;

import iih.pi.dic.cardtype.d.PiPatCardTpDO;
import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.permfw.pub.EnvContextUtil;

public class CardtypeRefModel extends RefGridModel{

	private static final long serialVersionUID = 1L;
	
	@Override
	public String[] getShowFieldCode(){
		return new String[]{PiPatCardTpDO.CODE,PiPatCardTpDO.NAME};
	}
	@Override
	public String[] getHiddenFieldCode(){
		return new String[]{PiPatCardTpDO.ID_CARDTP,PiPatCardTpDO.SD_PATCARDTP,PiPatCardTpDO.FG_PASSWORD};
	}
	@Override
	public String[] getBlurFields() {
		return new String[] { PiPatCardTpDO.CODE, PiPatCardTpDO.NAME,PiPatCardTpDO.PYCODE,PiPatCardTpDO.WBCODE,PiPatCardTpDO.MNECODE };
	}
	@Override
	public String[] getShowFieldName(){
		return new String[]{"编码","名称"};
	}
	@Override
	public String getPkFieldCode(){
		return PiPatCardTpDO.ID_CARDTP;
	}
	@Override
	public String getTableName(){
		return new PiPatCardTpDO().getTableName();
	}
	@Override
	public String getRefCodeField(){
		return PiPatCardTpDO.CODE;
	}
	@Override
	public String getRefNameField(){
		return PiPatCardTpDO.NAME;
	}
	
	@Override
	public List<String> getWherePart() {
		List<String> wheres = super.getWherePart();
		if (wheres == null) {
			wheres = new ArrayList<String>();
		}
		String orgSql = EnvContextUtil.processEnvContext("",new PiPatCardTpDO(),false);
		wheres.add(orgSql);
		return wheres;		
	}

}
