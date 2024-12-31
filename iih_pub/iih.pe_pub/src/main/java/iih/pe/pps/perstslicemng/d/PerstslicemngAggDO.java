package iih.pe.pps.perstslicemng.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.pps.perstslicemng.d.desc.PerstslicemngAggDODesc;



/**
 * 体检重要结果分层管理
 */
public class PerstslicemngAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeRstSliceMngDO getParentDO() {
		return ((PeRstSliceMngDO) super.getParentDO());
	}

	public void setParentDO(PeRstSliceMngDO headDO) {
		setParent(headDO);
	}

	public PeRstSliceMngPsnDO[] getPeRstSliceMngPsnDO() {
		IBaseDO[] dos = getChildren(PeRstSliceMngPsnDO.class);
		if(dos==null) return null;
		PeRstSliceMngPsnDO[] result=new PeRstSliceMngPsnDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeRstSliceMngPsnDO)dos[i];
		}
		return result;
	}
	
	public void setPeRstSliceMngPsnDO(PeRstSliceMngPsnDO[] dos) {
		setChildren(PeRstSliceMngPsnDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PerstslicemngAggDODesc desc = new PerstslicemngAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeRstSliceMngDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.pps.perstslicemng.d.PeRstSliceMngPsnDO")) {
             return new PeRstSliceMngPsnDO();
         }
         return null;
     }
}