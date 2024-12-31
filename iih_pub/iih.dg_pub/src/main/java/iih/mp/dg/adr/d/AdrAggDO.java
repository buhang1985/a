package iih.mp.dg.adr.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.mp.dg.adr.d.desc.AdrAggDODesc;



/**
 * 药品不良反应
 */
public class AdrAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public MpDgAdrDO getParentDO() {
		return ((MpDgAdrDO) super.getParentDO());
	}

	public void setParentDO(MpDgAdrDO headDO) {
		setParent(headDO);
	}

	public MpDgAdrItmDO[] getMpDgAdrItmDO() {
		IBaseDO[] dos = getChildren(MpDgAdrItmDO.class);
		if(dos==null) return null;
		MpDgAdrItmDO[] result=new MpDgAdrItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(MpDgAdrItmDO)dos[i];
		}
		return result;
	}
	
	public void setMpDgAdrItmDO(MpDgAdrItmDO[] dos) {
		setChildren(MpDgAdrItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		AdrAggDODesc desc = new AdrAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new MpDgAdrDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.mp.dg.adr.d.MpDgAdrItmDO")) {
             return new MpDgAdrItmDO();
         }
         return null;
     }
}