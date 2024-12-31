package iih.bd.mm.materialnames.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.mm.materialnames.d.desc.MaterialnamesAggDODesc;



/**
 * 药品通用名目录
 */
public class MaterialnamesAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public MaterialNamesDO getParentDO() {
		return ((MaterialNamesDO) super.getParentDO());
	}

	public void setParentDO(MaterialNamesDO headDO) {
		setParent(headDO);
	}

	public MnAliasSetDO[] getMnAliasSetDO() {
		IBaseDO[] dos = getChildren(MnAliasSetDO.class);
		if(dos==null) return null;
		MnAliasSetDO[] result=new MnAliasSetDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(MnAliasSetDO)dos[i];
		}
		return result;
	}
	
	public void setMnAliasSetDO(MnAliasSetDO[] dos) {
		setChildren(MnAliasSetDO.class, dos);
	}
	public MnCodeSetDO[] getMnCodeSetDO() {
		IBaseDO[] dos = getChildren(MnCodeSetDO.class);
		if(dos==null) return null;
		MnCodeSetDO[] result=new MnCodeSetDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(MnCodeSetDO)dos[i];
		}
		return result;
	}
	
	public void setMnCodeSetDO(MnCodeSetDO[] dos) {
		setChildren(MnCodeSetDO.class, dos);
	}
	public MaterialsDO[] getMaterialsDO() {
		IBaseDO[] dos = getChildren(MaterialsDO.class);
		if(dos==null) return null;
		MaterialsDO[] result=new MaterialsDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(MaterialsDO)dos[i];
		}
		return result;
	}
	
	public void setMaterialsDO(MaterialsDO[] dos) {
		setChildren(MaterialsDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		MaterialnamesAggDODesc desc = new MaterialnamesAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new MaterialNamesDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.mm.materialnames.d.MnAliasSetDO")) {
             return new MnAliasSetDO();
         }
	    else if (clzName.equals("iih.bd.mm.materialnames.d.MnCodeSetDO")) {
             return new MnCodeSetDO();
         }
	    else if (clzName.equals("iih.bd.mm.materialnames.d.MaterialsDO")) {
             return new MaterialsDO();
         }
         return null;
     }
}