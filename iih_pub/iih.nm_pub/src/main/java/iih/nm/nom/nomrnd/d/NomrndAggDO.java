package iih.nm.nom.nomrnd.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nm.nom.nomrnd.d.desc.NomrndAggDODesc;



/**
 * 护理查房记录
 */
public class NomrndAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NomRndDO getParentDO() {
		return ((NomRndDO) super.getParentDO());
	}

	public void setParentDO(NomRndDO headDO) {
		setParent(headDO);
	}

	public NomRndPsnDO[] getNomRndPsnDO() {
		IBaseDO[] dos = getChildren(NomRndPsnDO.class);
		if(dos==null) return null;
		NomRndPsnDO[] result=new NomRndPsnDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NomRndPsnDO)dos[i];
		}
		return result;
	}
	
	public void setNomRndPsnDO(NomRndPsnDO[] dos) {
		setChildren(NomRndPsnDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		NomrndAggDODesc desc = new NomrndAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NomRndDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nm.nom.nomrnd.d.NomRndPsnDO")) {
             return new NomRndPsnDO();
         }
         return null;
     }
}