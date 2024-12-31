package iih.pe.pitm.pesrvitemrange.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.pitm.pesrvitemrange.d.desc.PesrvitemrangeAggDODesc;



/**
 * 体检结果范围定义
 */
public class PesrvitemrangeAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeSrvItemRangeDO getParentDO() {
		return ((PeSrvItemRangeDO) super.getParentDO());
	}

	public void setParentDO(PeSrvItemRangeDO headDO) {
		setParent(headDO);
	}

	public PeSrvItemRangeRuleDO[] getPeSrvItemRangeRuleDO() {
		IBaseDO[] dos = getChildren(PeSrvItemRangeRuleDO.class);
		if(dos==null) return null;
		PeSrvItemRangeRuleDO[] result=new PeSrvItemRangeRuleDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeSrvItemRangeRuleDO)dos[i];
		}
		return result;
	}
	
	public void setPeSrvItemRangeRuleDO(PeSrvItemRangeRuleDO[] dos) {
		setChildren(PeSrvItemRangeRuleDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PesrvitemrangeAggDODesc desc = new PesrvitemrangeAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeSrvItemRangeDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.pitm.pesrvitemrange.d.PeSrvItemRangeRuleDO")) {
             return new PeSrvItemRangeRuleDO();
         }
         return null;
     }
}