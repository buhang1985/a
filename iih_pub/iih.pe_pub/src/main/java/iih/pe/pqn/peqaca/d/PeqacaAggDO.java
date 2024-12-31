package iih.pe.pqn.peqaca.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.pqn.peqaca.d.desc.PeqacaAggDODesc;



/**
 * 体检问卷组套
 */
public class PeqacaAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeQaCaDO getParentDO() {
		return ((PeQaCaDO) super.getParentDO());
	}

	public void setParentDO(PeQaCaDO headDO) {
		setParent(headDO);
	}

	public PeQaCaItmDO[] getPeQaCaItmDO() {
		IBaseDO[] dos = getChildren(PeQaCaItmDO.class);
		if(dos==null) return null;
		PeQaCaItmDO[] result=new PeQaCaItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeQaCaItmDO)dos[i];
		}
		return result;
	}
	
	public void setPeQaCaItmDO(PeQaCaItmDO[] dos) {
		setChildren(PeQaCaItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PeqacaAggDODesc desc = new PeqacaAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeQaCaDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.pqn.peqaca.d.PeQaCaItmDO")) {
             return new PeQaCaItmDO();
         }
         return null;
     }
}