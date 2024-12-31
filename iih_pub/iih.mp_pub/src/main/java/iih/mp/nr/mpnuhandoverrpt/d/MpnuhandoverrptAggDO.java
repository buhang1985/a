package iih.mp.nr.mpnuhandoverrpt.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.mp.nr.mpnuhandoverrpt.d.desc.MpnuhandoverrptAggDODesc;



/**
 * 护理交接班
 */
public class MpnuhandoverrptAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public MpNuHsDO getParentDO() {
		return ((MpNuHsDO) super.getParentDO());
	}

	public void setParentDO(MpNuHsDO headDO) {
		setParent(headDO);
	}

	public MpNuHsWardDO[] getMpNuHsWardDO() {
		IBaseDO[] dos = getChildren(MpNuHsWardDO.class);
		if(dos==null) return null;
		MpNuHsWardDO[] result=new MpNuHsWardDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(MpNuHsWardDO)dos[i];
		}
		return result;
	}
	
	public void setMpNuHsWardDO(MpNuHsWardDO[] dos) {
		setChildren(MpNuHsWardDO.class, dos);
	}
	public MpNuHsPatDO[] getMpNuHsPatDO() {
		IBaseDO[] dos = getChildren(MpNuHsPatDO.class);
		if(dos==null) return null;
		MpNuHsPatDO[] result=new MpNuHsPatDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(MpNuHsPatDO)dos[i];
		}
		return result;
	}
	
	public void setMpNuHsPatDO(MpNuHsPatDO[] dos) {
		setChildren(MpNuHsPatDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		MpnuhandoverrptAggDODesc desc = new MpnuhandoverrptAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new MpNuHsDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.mp.nr.mpnuhandoverrpt.d.MpNuHsWardDO")) {
             return new MpNuHsWardDO();
         }
	    else if (clzName.equals("iih.mp.nr.mpnuhandoverrpt.d.MpNuHsPatDO")) {
             return new MpNuHsPatDO();
         }
         return null;
     }
}