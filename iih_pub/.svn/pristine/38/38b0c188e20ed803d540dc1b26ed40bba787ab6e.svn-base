package iih.bd.pp.bdhpspec.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.pp.bdhpspec.d.desc.BdhpspecAggDODesc;



/**
 * 医保特殊病
 */
public class BdhpspecAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public BdHpSpecDO getParentDO() {
		return ((BdHpSpecDO) super.getParentDO());
	}

	public void setParentDO(BdHpSpecDO headDO) {
		setParent(headDO);
	}

	public BdHpSpecDrugDO[] getBdHpSpecDrugDO() {
		IBaseDO[] dos = getChildren(BdHpSpecDrugDO.class);
		if(dos==null) return null;
		BdHpSpecDrugDO[] result=new BdHpSpecDrugDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(BdHpSpecDrugDO)dos[i];
		}
		return result;
	}
	
	public void setBdHpSpecDrugDO(BdHpSpecDrugDO[] dos) {
		setChildren(BdHpSpecDrugDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		BdhpspecAggDODesc desc = new BdhpspecAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new BdHpSpecDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.pp.bdhpspec.d.BdHpSpecDrugDO")) {
             return new BdHpSpecDrugDO();
         }
         return null;
     }
}