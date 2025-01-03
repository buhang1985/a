package iih.pe.por.pepsnbinfo.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.por.pepsnbinfo.d.desc.PepsnbinfoAggDODesc;



/**
 * 体检客户基本资料
 */
public class PepsnbinfoAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PePsnBInfoDO getParentDO() {
		return ((PePsnBInfoDO) super.getParentDO());
	}

	public void setParentDO(PePsnBInfoDO headDO) {
		setParent(headDO);
	}

	public PePsnBInfoPriDO[] getPePsnBInfoPriDO() {
		IBaseDO[] dos = getChildren(PePsnBInfoPriDO.class);
		if(dos==null) return null;
		PePsnBInfoPriDO[] result=new PePsnBInfoPriDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PePsnBInfoPriDO)dos[i];
		}
		return result;
	}
	
	public void setPePsnBInfoPriDO(PePsnBInfoPriDO[] dos) {
		setChildren(PePsnBInfoPriDO.class, dos);
	}
	public PePsnPhyDO[] getPePsnPhyDO() {
		IBaseDO[] dos = getChildren(PePsnPhyDO.class);
		if(dos==null) return null;
		PePsnPhyDO[] result=new PePsnPhyDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PePsnPhyDO)dos[i];
		}
		return result;
	}
	
	public void setPePsnPhyDO(PePsnPhyDO[] dos) {
		setChildren(PePsnPhyDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PepsnbinfoAggDODesc desc = new PepsnbinfoAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PePsnBInfoDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.por.pepsnbinfo.d.PePsnBInfoPriDO")) {
             return new PePsnBInfoPriDO();
         }
	    else if (clzName.equals("iih.pe.por.pepsnbinfo.d.PePsnPhyDO")) {
             return new PePsnPhyDO();
         }
         return null;
     }
}