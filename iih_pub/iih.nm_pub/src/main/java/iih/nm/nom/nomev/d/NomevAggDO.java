package iih.nm.nom.nomev.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nm.nom.nomev.d.desc.NomevAggDODesc;



/**
 * 护理部大事记
 */
public class NomevAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NomEvDO getParentDO() {
		return ((NomEvDO) super.getParentDO());
	}

	public void setParentDO(NomEvDO headDO) {
		setParent(headDO);
	}

	public NomEvFileDO[] getNomEvFileDO() {
		IBaseDO[] dos = getChildren(NomEvFileDO.class);
		if(dos==null) return null;
		NomEvFileDO[] result=new NomEvFileDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NomEvFileDO)dos[i];
		}
		return result;
	}
	
	public void setNomEvFileDO(NomEvFileDO[] dos) {
		setChildren(NomEvFileDO.class, dos);
	}
	public NomEvPsnDO[] getNomEvPsnDO() {
		IBaseDO[] dos = getChildren(NomEvPsnDO.class);
		if(dos==null) return null;
		NomEvPsnDO[] result=new NomEvPsnDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NomEvPsnDO)dos[i];
		}
		return result;
	}
	
	public void setNomEvPsnDO(NomEvPsnDO[] dos) {
		setChildren(NomEvPsnDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		NomevAggDODesc desc = new NomevAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NomEvDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nm.nom.nomev.d.NomEvFileDO")) {
             return new NomEvFileDO();
         }
	    else if (clzName.equals("iih.nm.nom.nomev.d.NomEvPsnDO")) {
             return new NomEvPsnDO();
         }
         return null;
     }
}