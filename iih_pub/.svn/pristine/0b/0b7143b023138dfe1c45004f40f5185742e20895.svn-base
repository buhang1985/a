package iih.mp.dg.opinfu.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.mp.dg.opinfu.d.desc.OpinfuAggDODesc;



/**
 * 门诊输液
 */
public class OpinfuAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public OpInfuseDO getParentDO() {
		return ((OpInfuseDO) super.getParentDO());
	}

	public void setParentDO(OpInfuseDO headDO) {
		setParent(headDO);
	}

	public OpInfuseDtDO[] getOpInfuseDtDO() {
		IBaseDO[] dos = getChildren(OpInfuseDtDO.class);
		if(dos==null) return null;
		OpInfuseDtDO[] result=new OpInfuseDtDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(OpInfuseDtDO)dos[i];
		}
		return result;
	}
	
	public void setOpInfuseDtDO(OpInfuseDtDO[] dos) {
		setChildren(OpInfuseDtDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		OpinfuAggDODesc desc = new OpinfuAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new OpInfuseDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.mp.dg.opinfu.d.OpInfuseDtDO")) {
             return new OpInfuseDtDO();
         }
         return null;
     }
}