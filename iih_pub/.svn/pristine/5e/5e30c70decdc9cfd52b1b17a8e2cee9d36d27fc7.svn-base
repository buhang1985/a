package iih.en.pv.entdi.ref;


import iih.en.pv.entdi.d.EntDiDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class RefEntDIDO  extends RefGridModel{

	
	@Override
	public String[] getShowFieldCode() {
		return new String[]{EntDiDO.NAME_DIDEF_DIS,EntDiDO.CODE_DIDEF_DIS,EntDiDO.ID_DI,EntDiDO.ID_DIDEF_DIS,EntDiDO.ID_ENTDI};
	}
	
	@Override
	public String[] getHiddenFieldCode() {
		return new String[]{EntDiDO.ID_ENT};
	}
	@Override
	public String[] getShowFieldName() {
		return new String[]{"诊断名称","诊断编码","临床诊断编码","基础诊断编码","就诊诊断编码"};
	}
	
	@Override
	public String getPkFieldCode() {
		return EntDiDO.ID_ENTDI;
	}
	@Override
	public String getRefCodeField() {
		return EntDiDO.ID_DI;
	}
	@Override
	public String getRefNameField() {
		return EntDiDO.NAME_DIDEF_DIS;
	}

	@Override
	public void addWherePart(String wherePart) {
		
		getWherePart().add(wherePart);
	}
	
	@Override
	public String getRefSql() {
		String wherePart = "";
		boolean isFalse = false;
		String id_ent = (String) this.getExtendAttributeValue("id_ent");
		if(id_ent != null && !id_ent.equals("")){
			if(isFalse){
				wherePart += "and id_ent = '"+id_ent+"'  ";
			}else{
				wherePart += " id_ent = '"+id_ent+"'  ";
				isFalse = true;
			}
			
		}
		
		if(wherePart!=null && !wherePart.equals("")){
			this.addWherePart(wherePart);
		}
		String sql = null;
		try {
			sql = super.getRefSql();
		} finally {
			this.removeWherePart(wherePart);
		}
		
		return sql;
	}
	@Override
	public String getTableName() {
		return new EntDiDO().getTableName();
	}
}
