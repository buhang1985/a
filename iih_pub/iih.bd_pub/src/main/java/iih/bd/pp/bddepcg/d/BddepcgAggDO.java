package iih.bd.pp.bddepcg.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.pp.bddepcg.d.desc.BddepcgAggDODesc;



/**
 * 科室补费策略
 */
public class BddepcgAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public BdDepCgDO getParentDO() {
		return ((BdDepCgDO) super.getParentDO());
	}

	public void setParentDO(BdDepCgDO headDO) {
		setParent(headDO);
	}

	public BdDepCgItmDO[] getBdDepCgItmDO() {
		IBaseDO[] dos = getChildren(BdDepCgItmDO.class);
		if(dos==null) return null;
		BdDepCgItmDO[] result=new BdDepCgItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(BdDepCgItmDO)dos[i];
		}
		return result;
	}
	
	public void setBdDepCgItmDO(BdDepCgItmDO[] dos) {
		setChildren(BdDepCgItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		BddepcgAggDODesc desc = new BddepcgAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new BdDepCgDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.pp.bddepcg.d.BdDepCgItmDO")) {
             return new BdDepCgItmDO();
         }
         return null;
     }
}