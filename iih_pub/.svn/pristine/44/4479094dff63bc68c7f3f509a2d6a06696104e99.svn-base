package iih.pe.por.pepsnpot.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.por.pepsnpot.d.desc.PepsnpotAggDODesc;



/**
 * 体检潜在客户
 */
public class PepsnpotAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PePsnPotDO getParentDO() {
		return ((PePsnPotDO) super.getParentDO());
	}

	public void setParentDO(PePsnPotDO headDO) {
		setParent(headDO);
	}

	public PePsnPotFollowDO[] getPePsnPotFollowDO() {
		IBaseDO[] dos = getChildren(PePsnPotFollowDO.class);
		if(dos==null) return null;
		PePsnPotFollowDO[] result=new PePsnPotFollowDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PePsnPotFollowDO)dos[i];
		}
		return result;
	}
	
	public void setPePsnPotFollowDO(PePsnPotFollowDO[] dos) {
		setChildren(PePsnPotFollowDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PepsnpotAggDODesc desc = new PepsnpotAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PePsnPotDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.por.pepsnpot.d.PePsnPotFollowDO")) {
             return new PePsnPotFollowDO();
         }
         return null;
     }
}