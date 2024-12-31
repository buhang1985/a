package iih.mp.nr.crisisval.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.mp.nr.crisisval.d.desc.CrisisvalAggDODesc;



/**
 * 危急值
 */
public class CrisisvalAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public CrisisValDO getParentDO() {
		return ((CrisisValDO) super.getParentDO());
	}

	public void setParentDO(CrisisValDO headDO) {
		setParent(headDO);
	}

	public CrisisValLisDO[] getCrisisValLisDO() {
		IBaseDO[] dos = getChildren(CrisisValLisDO.class);
		if(dos==null) return null;
		CrisisValLisDO[] result=new CrisisValLisDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(CrisisValLisDO)dos[i];
		}
		return result;
	}
	
	public void setCrisisValLisDO(CrisisValLisDO[] dos) {
		setChildren(CrisisValLisDO.class, dos);
	}
	public CrisisValObsDO[] getCrisisValObsDO() {
		IBaseDO[] dos = getChildren(CrisisValObsDO.class);
		if(dos==null) return null;
		CrisisValObsDO[] result=new CrisisValObsDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(CrisisValObsDO)dos[i];
		}
		return result;
	}
	
	public void setCrisisValObsDO(CrisisValObsDO[] dos) {
		setChildren(CrisisValObsDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		CrisisvalAggDODesc desc = new CrisisvalAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new CrisisValDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.mp.nr.crisisval.d.CrisisValLisDO")) {
             return new CrisisValLisDO();
         }
	    else if (clzName.equals("iih.mp.nr.crisisval.d.CrisisValObsDO")) {
             return new CrisisValObsDO();
         }
         return null;
     }
}