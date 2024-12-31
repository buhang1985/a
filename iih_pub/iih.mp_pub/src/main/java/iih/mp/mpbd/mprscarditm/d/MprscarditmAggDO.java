package iih.mp.mpbd.mprscarditm.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.mp.mpbd.mprscarditm.d.desc.MprscarditmAggDODesc;



/**
 * 护士站滚屏卡信息明细
 */
public class MprscarditmAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public MpRsCardItmDO getParentDO() {
		return ((MpRsCardItmDO) super.getParentDO());
	}

	public void setParentDO(MpRsCardItmDO headDO) {
		setParent(headDO);
	}

	public MpRsCardItmPsnDO[] getMpRsCardItmPsnDO() {
		IBaseDO[] dos = getChildren(MpRsCardItmPsnDO.class);
		if(dos==null) return null;
		MpRsCardItmPsnDO[] result=new MpRsCardItmPsnDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(MpRsCardItmPsnDO)dos[i];
		}
		return result;
	}
	
	public void setMpRsCardItmPsnDO(MpRsCardItmPsnDO[] dos) {
		setChildren(MpRsCardItmPsnDO.class, dos);
	}
	public MpRsCardItmSrvDO[] getMpRsCardItmSrvDO() {
		IBaseDO[] dos = getChildren(MpRsCardItmSrvDO.class);
		if(dos==null) return null;
		MpRsCardItmSrvDO[] result=new MpRsCardItmSrvDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(MpRsCardItmSrvDO)dos[i];
		}
		return result;
	}
	
	public void setMpRsCardItmSrvDO(MpRsCardItmSrvDO[] dos) {
		setChildren(MpRsCardItmSrvDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		MprscarditmAggDODesc desc = new MprscarditmAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new MpRsCardItmDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.mp.mpbd.mprscarditm.d.MpRsCardItmPsnDO")) {
             return new MpRsCardItmPsnDO();
         }
	    else if (clzName.equals("iih.mp.mpbd.mprscarditm.d.MpRsCardItmSrvDO")) {
             return new MpRsCardItmSrvDO();
         }
         return null;
     }
}