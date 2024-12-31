package iih.pis.ivx.pisivxorder.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pis.ivx.pisivxorder.d.desc.PisivxorderAggDODesc;



/**
 * 微信处方订单
 */
public class PisivxorderAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PisIvxOrderDO getParentDO() {
		return ((PisIvxOrderDO) super.getParentDO());
	}

	public void setParentDO(PisIvxOrderDO headDO) {
		setParent(headDO);
	}

	public PisIvxOrderDtlDO[] getPisIvxOrderDtlDO() {
		IBaseDO[] dos = getChildren(PisIvxOrderDtlDO.class);
		if(dos==null) return null;
		PisIvxOrderDtlDO[] result=new PisIvxOrderDtlDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PisIvxOrderDtlDO)dos[i];
		}
		return result;
	}
	
	public void setPisIvxOrderDtlDO(PisIvxOrderDtlDO[] dos) {
		setChildren(PisIvxOrderDtlDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PisivxorderAggDODesc desc = new PisivxorderAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PisIvxOrderDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pis.ivx.pisivxorder.d.PisIvxOrderDtlDO")) {
             return new PisIvxOrderDtlDO();
         }
         return null;
     }
}