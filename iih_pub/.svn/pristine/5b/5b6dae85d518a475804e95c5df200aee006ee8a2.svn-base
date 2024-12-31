package iih.ci.mr.nu.laborprorecord.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mr.nu.laborprorecord.d.desc.LaborprorecordAggDODesc;



/**
 * 产程观察护理记录单
 */
public class LaborprorecordAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PuerperainfoDO getParentDO() {
		return ((PuerperainfoDO) super.getParentDO());
	}

	public void setParentDO(PuerperainfoDO headDO) {
		setParent(headDO);
	}

	public LaborprorecorditmDO[] getLaborprorecorditmDO() {
		IBaseDO[] dos = getChildren(LaborprorecorditmDO.class);
		if(dos==null) return null;
		LaborprorecorditmDO[] result=new LaborprorecorditmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(LaborprorecorditmDO)dos[i];
		}
		return result;
	}
	
	public void setLaborprorecorditmDO(LaborprorecorditmDO[] dos) {
		setChildren(LaborprorecorditmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		LaborprorecordAggDODesc desc = new LaborprorecordAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PuerperainfoDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mr.nu.laborprorecord.d.LaborprorecorditmDO")) {
             return new LaborprorecorditmDO();
         }
         return null;
     }
}