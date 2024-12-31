package iih.ci.mr.nu.antencare.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mr.nu.antencare.d.desc.AntencareAggDODesc;



/**
 * 产前检查记录单
 */
public class AntencareAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public AntenCareDO getParentDO() {
		return ((AntenCareDO) super.getParentDO());
	}

	public void setParentDO(AntenCareDO headDO) {
		setParent(headDO);
	}

	public InspRecDO[] getInspRecDO() {
		IBaseDO[] dos = getChildren(InspRecDO.class);
		if(dos==null) return null;
		InspRecDO[] result=new InspRecDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(InspRecDO)dos[i];
		}
		return result;
	}
	
	public void setInspRecDO(InspRecDO[] dos) {
		setChildren(InspRecDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		AntencareAggDODesc desc = new AntencareAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new AntenCareDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mr.nu.antencare.d.InspRecDO")) {
             return new InspRecDO();
         }
         return null;
     }
}