package iih.mp.mb.mbbc.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.mp.mb.mbbc.d.desc.MbbcAggDODesc;



/**
 * 条码对照
 */
public class MbbcAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public MbBcDO getParentDO() {
		return ((MbBcDO) super.getParentDO());
	}

	public void setParentDO(MbBcDO headDO) {
		setParent(headDO);
	}

	public MbBcRuleDO[] getMbBcRuleDO() {
		IBaseDO[] dos = getChildren(MbBcRuleDO.class);
		if(dos==null) return null;
		MbBcRuleDO[] result=new MbBcRuleDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(MbBcRuleDO)dos[i];
		}
		return result;
	}
	
	public void setMbBcRuleDO(MbBcRuleDO[] dos) {
		setChildren(MbBcRuleDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		MbbcAggDODesc desc = new MbbcAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new MbBcDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.mp.mb.mbbc.d.MbBcRuleDO")) {
             return new MbBcRuleDO();
         }
         return null;
     }
}