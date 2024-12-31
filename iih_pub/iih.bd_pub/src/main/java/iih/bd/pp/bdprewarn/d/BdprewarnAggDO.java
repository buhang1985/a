package iih.bd.pp.bdprewarn.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.pp.bdprewarn.d.desc.BdprewarnAggDODesc;



/**
 * 预交金警告策略
 */
public class BdprewarnAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public BdPreWarnDO getParentDO() {
		return ((BdPreWarnDO) super.getParentDO());
	}

	public void setParentDO(BdPreWarnDO headDO) {
		setParent(headDO);
	}

	public BdPreWarnItmDO[] getBdPreWarnItmDO() {
		IBaseDO[] dos = getChildren(BdPreWarnItmDO.class);
		if(dos==null) return null;
		BdPreWarnItmDO[] result=new BdPreWarnItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(BdPreWarnItmDO)dos[i];
		}
		return result;
	}
	
	public void setBdPreWarnItmDO(BdPreWarnItmDO[] dos) {
		setChildren(BdPreWarnItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		BdprewarnAggDODesc desc = new BdprewarnAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new BdPreWarnDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.pp.bdprewarn.d.BdPreWarnItmDO")) {
             return new BdPreWarnItmDO();
         }
         return null;
     }
}