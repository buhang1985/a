package iih.nmr.pkuf.nmrdi.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nmr.pkuf.nmrdi.d.desc.NmrdiAggDODesc;



/**
 * 护理诊断
 */
public class NmrdiAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NmrDiDO getParentDO() {
		return ((NmrDiDO) super.getParentDO());
	}

	public void setParentDO(NmrDiDO headDO) {
		setParent(headDO);
	}

	public NmrDiFacDO[] getNmrDiFacDO() {
		IBaseDO[] dos = getChildren(NmrDiFacDO.class);
		if(dos==null) return null;
		NmrDiFacDO[] result=new NmrDiFacDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NmrDiFacDO)dos[i];
		}
		return result;
	}
	
	public void setNmrDiFacDO(NmrDiFacDO[] dos) {
		setChildren(NmrDiFacDO.class, dos);
	}
	public NmrDiTrDO[] getNmrDiTrDO() {
		IBaseDO[] dos = getChildren(NmrDiTrDO.class);
		if(dos==null) return null;
		NmrDiTrDO[] result=new NmrDiTrDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NmrDiTrDO)dos[i];
		}
		return result;
	}
	
	public void setNmrDiTrDO(NmrDiTrDO[] dos) {
		setChildren(NmrDiTrDO.class, dos);
	}
	public NmrDiMeaDO[] getNmrDiMeaDO() {
		IBaseDO[] dos = getChildren(NmrDiMeaDO.class);
		if(dos==null) return null;
		NmrDiMeaDO[] result=new NmrDiMeaDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NmrDiMeaDO)dos[i];
		}
		return result;
	}
	
	public void setNmrDiMeaDO(NmrDiMeaDO[] dos) {
		setChildren(NmrDiMeaDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		NmrdiAggDODesc desc = new NmrdiAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NmrDiDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nmr.pkuf.nmrdi.d.NmrDiFacDO")) {
             return new NmrDiFacDO();
         }
	    else if (clzName.equals("iih.nmr.pkuf.nmrdi.d.NmrDiTrDO")) {
             return new NmrDiTrDO();
         }
	    else if (clzName.equals("iih.nmr.pkuf.nmrdi.d.NmrDiMeaDO")) {
             return new NmrDiMeaDO();
         }
         return null;
     }
}