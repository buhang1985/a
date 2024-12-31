package iih.mp.mpbd.mpmbhfunca.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.mp.mpbd.mpmbhfunca.d.desc.MpmbhfuncaAggDODesc;



/**
 * 移动医疗功能分类
 */
public class MpmbhfuncaAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public MpMbhAppCaDO getParentDO() {
		return ((MpMbhAppCaDO) super.getParentDO());
	}

	public void setParentDO(MpMbhAppCaDO headDO) {
		setParent(headDO);
	}

	public MpMbhAppFunDO[] getMpMbhAppFunDO() {
		IBaseDO[] dos = getChildren(MpMbhAppFunDO.class);
		if(dos==null) return null;
		MpMbhAppFunDO[] result=new MpMbhAppFunDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(MpMbhAppFunDO)dos[i];
		}
		return result;
	}
	
	public void setMpMbhAppFunDO(MpMbhAppFunDO[] dos) {
		setChildren(MpMbhAppFunDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		MpmbhfuncaAggDODesc desc = new MpmbhfuncaAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new MpMbhAppCaDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.mp.mpbd.mpmbhfunca.d.MpMbhAppFunDO")) {
             return new MpMbhAppFunDO();
         }
         return null;
     }
}