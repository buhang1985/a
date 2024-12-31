package iih.pe.pitm.pechrodisedef.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.pitm.pechrodisedef.d.desc.PechrodisedefAggDODesc;



/**
 * 体检慢性病定义
 */
public class PechrodisedefAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeChroDiseDefDO getParentDO() {
		return ((PeChroDiseDefDO) super.getParentDO());
	}

	public void setParentDO(PeChroDiseDefDO headDO) {
		setParent(headDO);
	}

	public PeChroDiseDiDefDO[] getPeChroDiseDiDefDO() {
		IBaseDO[] dos = getChildren(PeChroDiseDiDefDO.class);
		if(dos==null) return null;
		PeChroDiseDiDefDO[] result=new PeChroDiseDiDefDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeChroDiseDiDefDO)dos[i];
		}
		return result;
	}
	
	public void setPeChroDiseDiDefDO(PeChroDiseDiDefDO[] dos) {
		setChildren(PeChroDiseDiDefDO.class, dos);
	}
	public PeChroDiseRuleDefDO[] getPeChroDiseRuleDefDO() {
		IBaseDO[] dos = getChildren(PeChroDiseRuleDefDO.class);
		if(dos==null) return null;
		PeChroDiseRuleDefDO[] result=new PeChroDiseRuleDefDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeChroDiseRuleDefDO)dos[i];
		}
		return result;
	}
	
	public void setPeChroDiseRuleDefDO(PeChroDiseRuleDefDO[] dos) {
		setChildren(PeChroDiseRuleDefDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PechrodisedefAggDODesc desc = new PechrodisedefAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeChroDiseDefDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.pitm.pechrodisedef.d.PeChroDiseDiDefDO")) {
             return new PeChroDiseDiDefDO();
         }
	    else if (clzName.equals("iih.pe.pitm.pechrodisedef.d.PeChroDiseRuleDefDO")) {
             return new PeChroDiseRuleDefDO();
         }
         return null;
     }
}