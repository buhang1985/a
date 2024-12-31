package iih.ci.mr.nu.prescforoper.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mr.nu.prescforoper.d.desc.PrescforoperAggDODesc;



/**
 * 手术室患者压疮危险因素评分
 */
public class PrescforoperAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PrescforDO getParentDO() {
		return ((PrescforDO) super.getParentDO());
	}

	public void setParentDO(PrescforDO headDO) {
		setParent(headDO);
	}

	public PrescforoperDO[] getPrescforoperDO() {
		IBaseDO[] dos = getChildren(PrescforoperDO.class);
		if(dos==null) return null;
		PrescforoperDO[] result=new PrescforoperDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PrescforoperDO)dos[i];
		}
		return result;
	}
	
	public void setPrescforoperDO(PrescforoperDO[] dos) {
		setChildren(PrescforoperDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PrescforoperAggDODesc desc = new PrescforoperAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PrescforDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mr.nu.prescforoper.d.PrescforoperDO")) {
             return new PrescforoperDO();
         }
         return null;
     }
}