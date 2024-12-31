package iih.pe.pps.pepositrack.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.pps.pepositrack.d.desc.PepositrackAggDODesc;



/**
 * 体检阳性结果追踪
 */
public class PepositrackAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PePosiTrackDO getParentDO() {
		return ((PePosiTrackDO) super.getParentDO());
	}

	public void setParentDO(PePosiTrackDO headDO) {
		setParent(headDO);
	}

	public PePostTrackHistDO[] getPePostTrackHistDO() {
		IBaseDO[] dos = getChildren(PePostTrackHistDO.class);
		if(dos==null) return null;
		PePostTrackHistDO[] result=new PePostTrackHistDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PePostTrackHistDO)dos[i];
		}
		return result;
	}
	
	public void setPePostTrackHistDO(PePostTrackHistDO[] dos) {
		setChildren(PePostTrackHistDO.class, dos);
	}
	public PePosiTrackDtlDO[] getPePosiTrackDtlDO() {
		IBaseDO[] dos = getChildren(PePosiTrackDtlDO.class);
		if(dos==null) return null;
		PePosiTrackDtlDO[] result=new PePosiTrackDtlDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PePosiTrackDtlDO)dos[i];
		}
		return result;
	}
	
	public void setPePosiTrackDtlDO(PePosiTrackDtlDO[] dos) {
		setChildren(PePosiTrackDtlDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PepositrackAggDODesc desc = new PepositrackAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PePosiTrackDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.pps.pepositrack.d.PePostTrackHistDO")) {
             return new PePostTrackHistDO();
         }
	    else if (clzName.equals("iih.pe.pps.pepositrack.d.PePosiTrackDtlDO")) {
             return new PePosiTrackDtlDO();
         }
         return null;
     }
}