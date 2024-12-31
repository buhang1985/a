package iih.en.pv.enfee.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.en.pv.enfee.d.desc.EnfixedfeeAggDODesc;



/**
 * 患者就诊_固定费用
 */
public class EnfixedfeeAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public EnFixedFeeDO getParentDO() {
		return ((EnFixedFeeDO) super.getParentDO());
	}

	public void setParentDO(EnFixedFeeDO headDO) {
		setParent(headDO);
	}

	public EnFixedFeeItemDO[] getEnFixedFeeItemDO() {
		IBaseDO[] dos = getChildren(EnFixedFeeItemDO.class);
		if(dos==null) return null;
		EnFixedFeeItemDO[] result=new EnFixedFeeItemDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(EnFixedFeeItemDO)dos[i];
		}
		return result;
	}
	
	public void setEnFixedFeeItemDO(EnFixedFeeItemDO[] dos) {
		setChildren(EnFixedFeeItemDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		EnfixedfeeAggDODesc desc = new EnfixedfeeAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new EnFixedFeeDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.en.pv.enfee.d.EnFixedFeeItemDO")) {
             return new EnFixedFeeItemDO();
         }
         return null;
     }
}