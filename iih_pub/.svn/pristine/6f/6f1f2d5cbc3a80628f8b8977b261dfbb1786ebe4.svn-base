package iih.mp.mpbd.mpskd.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.mp.mpbd.mpskd.d.desc.MpskdAggDODesc;



/**
 * 护理任务定义
 */
public class MpskdAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public MpSkdDO getParentDO() {
		return ((MpSkdDO) super.getParentDO());
	}

	public void setParentDO(MpSkdDO headDO) {
		setParent(headDO);
	}

	public MpSkdOrDO[] getMpSkdOrDO() {
		IBaseDO[] dos = getChildren(MpSkdOrDO.class);
		if(dos==null) return null;
		MpSkdOrDO[] result=new MpSkdOrDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(MpSkdOrDO)dos[i];
		}
		return result;
	}
	
	public void setMpSkdOrDO(MpSkdOrDO[] dos) {
		setChildren(MpSkdOrDO.class, dos);
	}
	public MpSkdEntstaDO[] getMpSkdEntstaDO() {
		IBaseDO[] dos = getChildren(MpSkdEntstaDO.class);
		if(dos==null) return null;
		MpSkdEntstaDO[] result=new MpSkdEntstaDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(MpSkdEntstaDO)dos[i];
		}
		return result;
	}
	
	public void setMpSkdEntstaDO(MpSkdEntstaDO[] dos) {
		setChildren(MpSkdEntstaDO.class, dos);
	}
	public MpSkdNmrDO[] getMpSkdNmrDO() {
		IBaseDO[] dos = getChildren(MpSkdNmrDO.class);
		if(dos==null) return null;
		MpSkdNmrDO[] result=new MpSkdNmrDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(MpSkdNmrDO)dos[i];
		}
		return result;
	}
	
	public void setMpSkdNmrDO(MpSkdNmrDO[] dos) {
		setChildren(MpSkdNmrDO.class, dos);
	}
	public MpSkdVsDO[] getMpSkdVsDO() {
		IBaseDO[] dos = getChildren(MpSkdVsDO.class);
		if(dos==null) return null;
		MpSkdVsDO[] result=new MpSkdVsDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(MpSkdVsDO)dos[i];
		}
		return result;
	}
	
	public void setMpSkdVsDO(MpSkdVsDO[] dos) {
		setChildren(MpSkdVsDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		MpskdAggDODesc desc = new MpskdAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new MpSkdDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.mp.mpbd.mpskd.d.MpSkdOrDO")) {
             return new MpSkdOrDO();
         }
	    else if (clzName.equals("iih.mp.mpbd.mpskd.d.MpSkdEntstaDO")) {
             return new MpSkdEntstaDO();
         }
	    else if (clzName.equals("iih.mp.mpbd.mpskd.d.MpSkdNmrDO")) {
             return new MpSkdNmrDO();
         }
	    else if (clzName.equals("iih.mp.mpbd.mpskd.d.MpSkdVsDO")) {
             return new MpSkdVsDO();
         }
         return null;
     }
}