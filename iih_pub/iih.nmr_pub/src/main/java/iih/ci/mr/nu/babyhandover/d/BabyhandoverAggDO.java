package iih.ci.mr.nu.babyhandover.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mr.nu.babyhandover.d.desc.BabyhandoverAggDODesc;



/**
 * 新生儿交接与记录单
 */
public class BabyhandoverAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public BabyhandoverinfoDO getParentDO() {
		return ((BabyhandoverinfoDO) super.getParentDO());
	}

	public void setParentDO(BabyhandoverinfoDO headDO) {
		setParent(headDO);
	}

	public BabyhandoverrecordDO[] getBabyhandoverrecordDO() {
		IBaseDO[] dos = getChildren(BabyhandoverrecordDO.class);
		if(dos==null) return null;
		BabyhandoverrecordDO[] result=new BabyhandoverrecordDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(BabyhandoverrecordDO)dos[i];
		}
		return result;
	}
	
	public void setBabyhandoverrecordDO(BabyhandoverrecordDO[] dos) {
		setChildren(BabyhandoverrecordDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		BabyhandoverAggDODesc desc = new BabyhandoverAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new BabyhandoverinfoDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mr.nu.babyhandover.d.BabyhandoverrecordDO")) {
             return new BabyhandoverrecordDO();
         }
         return null;
     }
}