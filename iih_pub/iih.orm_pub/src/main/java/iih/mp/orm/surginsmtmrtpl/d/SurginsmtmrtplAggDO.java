package iih.mp.orm.surginsmtmrtpl.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.mp.orm.surginsmtmrtpl.d.desc.SurginsmtmrtplAggDODesc;



/**
 * 手术器械模板
 */
public class SurginsmtmrtplAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public SurgInsmtMrtplDO getParentDO() {
		return ((SurgInsmtMrtplDO) super.getParentDO());
	}

	public void setParentDO(SurgInsmtMrtplDO headDO) {
		setParent(headDO);
	}

	public SurgInsmtMrtplItemDO[] getSurgInsmtMrtplItemDO() {
		IBaseDO[] dos = getChildren(SurgInsmtMrtplItemDO.class);
		if(dos==null) return null;
		SurgInsmtMrtplItemDO[] result=new SurgInsmtMrtplItemDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(SurgInsmtMrtplItemDO)dos[i];
		}
		return result;
	}
	
	public void setSurgInsmtMrtplItemDO(SurgInsmtMrtplItemDO[] dos) {
		setChildren(SurgInsmtMrtplItemDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		SurginsmtmrtplAggDODesc desc = new SurginsmtmrtplAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new SurgInsmtMrtplDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.mp.orm.surginsmtmrtpl.d.SurgInsmtMrtplItemDO")) {
             return new SurgInsmtMrtplItemDO();
         }
         return null;
     }
}