package iih.nmr.pkuf.nmrcoll.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nmr.pkuf.nmrcoll.d.desc.NmrcollAggDODesc;



/**
 * 文书采集记录
 */
public class NmrcollAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NmrCollDO getParentDO() {
		return ((NmrCollDO) super.getParentDO());
	}

	public void setParentDO(NmrCollDO headDO) {
		setParent(headDO);
	}

	public NmrCollItmDO[] getNmrCollItmDO() {
		IBaseDO[] dos = getChildren(NmrCollItmDO.class);
		if(dos==null) return null;
		NmrCollItmDO[] result=new NmrCollItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NmrCollItmDO)dos[i];
		}
		return result;
	}
	
	public void setNmrCollItmDO(NmrCollItmDO[] dos) {
		setChildren(NmrCollItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		NmrcollAggDODesc desc = new NmrcollAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NmrCollDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nmr.pkuf.nmrcoll.d.NmrCollItmDO")) {
             return new NmrCollItmDO();
         }
         return null;
     }
}