package iih.bd.pp.bdpripkg.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.pp.bdpripkg.d.desc.BdpripkgAggDODesc;



/**
 * 组件
 */
public class BdpripkgAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public BdPriPkgDO getParentDO() {
		return ((BdPriPkgDO) super.getParentDO());
	}

	public void setParentDO(BdPriPkgDO headDO) {
		setParent(headDO);
	}

	public BdPriPkgItmDO[] getBdPriPkgItmDO() {
		IBaseDO[] dos = getChildren(BdPriPkgItmDO.class);
		if(dos==null) return null;
		BdPriPkgItmDO[] result=new BdPriPkgItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(BdPriPkgItmDO)dos[i];
		}
		return result;
	}
	
	public void setBdPriPkgItmDO(BdPriPkgItmDO[] dos) {
		setChildren(BdPriPkgItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		BdpripkgAggDODesc desc = new BdpripkgAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new BdPriPkgDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.pp.bdpripkg.d.BdPriPkgItmDO")) {
             return new BdPriPkgItmDO();
         }
         return null;
     }
}