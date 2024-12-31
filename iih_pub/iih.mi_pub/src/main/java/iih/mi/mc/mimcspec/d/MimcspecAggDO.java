package iih.mi.mc.mimcspec.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.mi.mc.mimcspec.d.desc.MimcspecAggDODesc;



/**
 * 医保特殊病
 */
public class MimcspecAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public MiMcSpecDO getParentDO() {
		return ((MiMcSpecDO) super.getParentDO());
	}

	public void setParentDO(MiMcSpecDO headDO) {
		setParent(headDO);
	}

	public MiMcSpecDrugDO[] getMiMcSpecDrugDO() {
		IBaseDO[] dos = getChildren(MiMcSpecDrugDO.class);
		if(dos==null) return null;
		MiMcSpecDrugDO[] result=new MiMcSpecDrugDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(MiMcSpecDrugDO)dos[i];
		}
		return result;
	}
	
	public void setMiMcSpecDrugDO(MiMcSpecDrugDO[] dos) {
		setChildren(MiMcSpecDrugDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		MimcspecAggDODesc desc = new MimcspecAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new MiMcSpecDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.mi.mc.mimcspec.d.MiMcSpecDrugDO")) {
             return new MiMcSpecDrugDO();
         }
         return null;
     }
}