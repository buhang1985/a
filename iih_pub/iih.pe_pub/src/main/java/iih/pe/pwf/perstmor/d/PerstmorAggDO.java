package iih.pe.pwf.perstmor.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.pwf.perstmor.d.desc.PerstmorAggDODesc;



/**
 * 体检形态学报告
 */
public class PerstmorAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeRstMorDO getParentDO() {
		return ((PeRstMorDO) super.getParentDO());
	}

	public void setParentDO(PeRstMorDO headDO) {
		setParent(headDO);
	}

	public PeRstMorItmDO[] getPeRstMorItmDO() {
		IBaseDO[] dos = getChildren(PeRstMorItmDO.class);
		if(dos==null) return null;
		PeRstMorItmDO[] result=new PeRstMorItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeRstMorItmDO)dos[i];
		}
		return result;
	}
	
	public void setPeRstMorItmDO(PeRstMorItmDO[] dos) {
		setChildren(PeRstMorItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PerstmorAggDODesc desc = new PerstmorAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeRstMorDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.pwf.perstmor.d.PeRstMorItmDO")) {
             return new PeRstMorItmDO();
         }
         return null;
     }
}