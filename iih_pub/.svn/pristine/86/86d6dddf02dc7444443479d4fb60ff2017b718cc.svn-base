package iih.bd.pp.bdbltpl.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.pp.bdbltpl.d.desc.BdbltplAggDODesc;



/**
 * 自定义费用模板
 */
public class BdbltplAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public BdBlTplDO getParentDO() {
		return ((BdBlTplDO) super.getParentDO());
	}

	public void setParentDO(BdBlTplDO headDO) {
		setParent(headDO);
	}

	public BdBltplItmDO[] getBdBltplItmDO() {
		IBaseDO[] dos = getChildren(BdBltplItmDO.class);
		if(dos==null) return null;
		BdBltplItmDO[] result=new BdBltplItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(BdBltplItmDO)dos[i];
		}
		return result;
	}
	
	public void setBdBltplItmDO(BdBltplItmDO[] dos) {
		setChildren(BdBltplItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		BdbltplAggDODesc desc = new BdbltplAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new BdBlTplDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.pp.bdbltpl.d.BdBltplItmDO")) {
             return new BdBltplItmDO();
         }
         return null;
     }
}