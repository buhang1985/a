package iih.nm.nbd.nbddepca.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nm.nbd.nbddepca.d.desc.NbddepcaAggDODesc;



/**
 * 护理单元
 */
public class NbddepcaAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NbdDepCaDO getParentDO() {
		return ((NbdDepCaDO) super.getParentDO());
	}

	public void setParentDO(NbdDepCaDO headDO) {
		setParent(headDO);
	}

	public NbdDepDO[] getNbdDepDO() {
		IBaseDO[] dos = getChildren(NbdDepDO.class);
		if(dos==null) return null;
		NbdDepDO[] result=new NbdDepDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NbdDepDO)dos[i];
		}
		return result;
	}
	
	public void setNbdDepDO(NbdDepDO[] dos) {
		setChildren(NbdDepDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		NbddepcaAggDODesc desc = new NbddepcaAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NbdDepCaDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nm.nbd.nbddepca.d.NbdDepDO")) {
             return new NbdDepDO();
         }
         return null;
     }
}