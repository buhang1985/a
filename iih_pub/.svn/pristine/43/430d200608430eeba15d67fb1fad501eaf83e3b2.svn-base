package iih.bd.mm.meterial.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.mm.meterial.d.desc.MeterialAggDODesc;



/**
 * 医疗物品
 */
public class MeterialAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public MeterialDO getParentDO() {
		return ((MeterialDO) super.getParentDO());
	}

	public void setParentDO(MeterialDO headDO) {
		setParent(headDO);
	}

	public MMPackageUnitDO[] getMMPackageUnitDO() {
		IBaseDO[] dos = getChildren(MMPackageUnitDO.class);
		if(dos==null) return null;
		MMPackageUnitDO[] result=new MMPackageUnitDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(MMPackageUnitDO)dos[i];
		}
		return result;
	}
	
	public void setMMPackageUnitDO(MMPackageUnitDO[] dos) {
		setChildren(MMPackageUnitDO.class, dos);
	}
	public MMAliasDO[] getMMAliasDO() {
		IBaseDO[] dos = getChildren(MMAliasDO.class);
		if(dos==null) return null;
		MMAliasDO[] result=new MMAliasDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(MMAliasDO)dos[i];
		}
		return result;
	}
	
	public void setMMAliasDO(MMAliasDO[] dos) {
		setChildren(MMAliasDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		MeterialAggDODesc desc = new MeterialAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new MeterialDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.mm.meterial.d.MMPackageUnitDO")) {
             return new MMPackageUnitDO();
         }
	    else if (clzName.equals("iih.bd.mm.meterial.d.MMAliasDO")) {
             return new MMAliasDO();
         }
         return null;
     }
}