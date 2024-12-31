package iih.pe.phm.pechrodise.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.phm.pechrodise.d.desc.PechrodiseAggDODesc;



/**
 * 体检慢性病风险评估
 */
public class PechrodiseAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeChroDiseDO getParentDO() {
		return ((PeChroDiseDO) super.getParentDO());
	}

	public void setParentDO(PeChroDiseDO headDO) {
		setParent(headDO);
	}

	public PeChroDiseRiskListDO[] getPeChroDiseRiskListDO() {
		IBaseDO[] dos = getChildren(PeChroDiseRiskListDO.class);
		if(dos==null) return null;
		PeChroDiseRiskListDO[] result=new PeChroDiseRiskListDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeChroDiseRiskListDO)dos[i];
		}
		return result;
	}
	
	public void setPeChroDiseRiskListDO(PeChroDiseRiskListDO[] dos) {
		setChildren(PeChroDiseRiskListDO.class, dos);
	}
	public PeChroDiseScDO[] getPeChroDiseScDO() {
		IBaseDO[] dos = getChildren(PeChroDiseScDO.class);
		if(dos==null) return null;
		PeChroDiseScDO[] result=new PeChroDiseScDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeChroDiseScDO)dos[i];
		}
		return result;
	}
	
	public void setPeChroDiseScDO(PeChroDiseScDO[] dos) {
		setChildren(PeChroDiseScDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PechrodiseAggDODesc desc = new PechrodiseAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeChroDiseDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.phm.pechrodise.d.PeChroDiseRiskListDO")) {
             return new PeChroDiseRiskListDO();
         }
	    else if (clzName.equals("iih.pe.phm.pechrodise.d.PeChroDiseScDO")) {
             return new PeChroDiseScDO();
         }
         return null;
     }
}