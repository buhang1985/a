package iih.pi.reg.pat.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pi.reg.pat.d.desc.PatiAggDODesc;



/**
 * 患者基本信息
 */
public class PatiAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PatDO getParentDO() {
		return ((PatDO) super.getParentDO());
	}

	public void setParentDO(PatDO headDO) {
		setParent(headDO);
	}

	public PatiAddrDO[] getPatiAddrDO() {
		IBaseDO[] dos = getChildren(PatiAddrDO.class);
		if(dos==null) return null;
		PatiAddrDO[] result=new PatiAddrDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PatiAddrDO)dos[i];
		}
		return result;
	}
	
	public void setPatiAddrDO(PatiAddrDO[] dos) {
		setChildren(PatiAddrDO.class, dos);
	}
	public PiPatContDO[] getPiPatContDO() {
		IBaseDO[] dos = getChildren(PiPatContDO.class);
		if(dos==null) return null;
		PiPatContDO[] result=new PiPatContDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PiPatContDO)dos[i];
		}
		return result;
	}
	
	public void setPiPatContDO(PiPatContDO[] dos) {
		setChildren(PiPatContDO.class, dos);
	}
	public PiPatCardDO[] getPiPatCardDO() {
		IBaseDO[] dos = getChildren(PiPatCardDO.class);
		if(dos==null) return null;
		PiPatCardDO[] result=new PiPatCardDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PiPatCardDO)dos[i];
		}
		return result;
	}
	
	public void setPiPatCardDO(PiPatCardDO[] dos) {
		setChildren(PiPatCardDO.class, dos);
	}
	public PiPatHpDO[] getPiPatHpDO() {
		IBaseDO[] dos = getChildren(PiPatHpDO.class);
		if(dos==null) return null;
		PiPatHpDO[] result=new PiPatHpDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PiPatHpDO)dos[i];
		}
		return result;
	}
	
	public void setPiPatHpDO(PiPatHpDO[] dos) {
		setChildren(PiPatHpDO.class, dos);
	}
	public PiPatBiolDO[] getPiPatBiolDO() {
		IBaseDO[] dos = getChildren(PiPatBiolDO.class);
		if(dos==null) return null;
		PiPatBiolDO[] result=new PiPatBiolDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PiPatBiolDO)dos[i];
		}
		return result;
	}
	
	public void setPiPatBiolDO(PiPatBiolDO[] dos) {
		setChildren(PiPatBiolDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PatiAggDODesc desc = new PatiAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PatDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pi.reg.pat.d.PatiAddrDO")) {
             return new PatiAddrDO();
         }
	    else if (clzName.equals("iih.pi.reg.pat.d.PiPatContDO")) {
             return new PiPatContDO();
         }
	    else if (clzName.equals("iih.pi.reg.pat.d.PiPatCardDO")) {
             return new PiPatCardDO();
         }
	    else if (clzName.equals("iih.pi.reg.pat.d.PiPatHpDO")) {
             return new PiPatHpDO();
         }
	    else if (clzName.equals("iih.pi.reg.pat.d.PiPatBiolDO")) {
             return new PiPatBiolDO();
         }
         return null;
     }
}