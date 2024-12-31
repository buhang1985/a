package iih.nm.nom.nmnomwbkitm.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nm.nom.nmnomwbkitm.d.desc.NmnomwbkitmAggDODesc;



/**
 * 护士长手册模板
 */
public class NmnomwbkitmAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NmNomWbkCaDO getParentDO() {
		return ((NmNomWbkCaDO) super.getParentDO());
	}

	public void setParentDO(NmNomWbkCaDO headDO) {
		setParent(headDO);
	}

	public NmNomWbkItmDO[] getNmNomWbkItmDO() {
		IBaseDO[] dos = getChildren(NmNomWbkItmDO.class);
		if(dos==null) return null;
		NmNomWbkItmDO[] result=new NmNomWbkItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NmNomWbkItmDO)dos[i];
		}
		return result;
	}
	
	public void setNmNomWbkItmDO(NmNomWbkItmDO[] dos) {
		setChildren(NmNomWbkItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		NmnomwbkitmAggDODesc desc = new NmnomwbkitmAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NmNomWbkCaDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nm.nom.nmnomwbkitm.d.NmNomWbkItmDO")) {
             return new NmNomWbkItmDO();
         }
         return null;
     }
}