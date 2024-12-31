package iih.pe.pwf.perstlis.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.pwf.perstlis.d.desc.PerstlisAggDODesc;



/**
 * 体检检验报告
 */
public class PerstlisAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeRstLisDO getParentDO() {
		return ((PeRstLisDO) super.getParentDO());
	}

	public void setParentDO(PeRstLisDO headDO) {
		setParent(headDO);
	}

	public PeRstLisItmDO[] getPeRstLisItmDO() {
		IBaseDO[] dos = getChildren(PeRstLisItmDO.class);
		if(dos==null) return null;
		PeRstLisItmDO[] result=new PeRstLisItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeRstLisItmDO)dos[i];
		}
		return result;
	}
	
	public void setPeRstLisItmDO(PeRstLisItmDO[] dos) {
		setChildren(PeRstLisItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PerstlisAggDODesc desc = new PerstlisAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeRstLisDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.pwf.perstlis.d.PeRstLisItmDO")) {
             return new PeRstLisItmDO();
         }
         return null;
     }
}