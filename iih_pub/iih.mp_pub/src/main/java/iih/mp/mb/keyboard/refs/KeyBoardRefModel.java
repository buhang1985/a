package iih.mp.mb.keyboard.refs;

import iih.mp.mb.keyboard.d.KeyBoardDO;
import iih.mp.mb.keyboard.d.desc.KeyBoardDODesc;
import xap.sys.appfw.refinfo.RefGridModel;

public class KeyBoardRefModel extends RefGridModel {
	
	
	@Override
	public String[] getShowFieldCode() {
		return new String[] { KeyBoardDO.ID_MB_KB, KeyBoardDO.KEYBOARDNAME};
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "键盘主键", "键盘名称"};
	}

	@Override
	public String getPkFieldCode() {
		return KeyBoardDO.ID_MB_KB;
	}

	@Override
	public String getRefCodeField() {
		
		return KeyBoardDO.ID_MB_KB;
	}

	@Override
	public String getRefNameField() {
		
		return KeyBoardDO.KEYBOARDNAME;
	}
	
	@Override
	public String getTableName(){
		return KeyBoardDODesc.TABLE_NAME;
	}
	
//	@Override
//	public String getRefSql() {
//		
//		String sql = "select id_mb_kb,keyboardname,pages from mp_mb_kb  mp_mb_kb where 1=1";
//		
//		StringBuilder sb = new StringBuilder(sql);
//
//		return sb.toString();		
//	}
	
}
