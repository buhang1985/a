package iih.nm.nca.satsrvyrecord.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nm.nca.satsrvyrecord.d.desc.SatsrvyAggDODesc;



/**
 * 满意度调查记录
 */
public class SatsrvyAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NmNcaSrvyRecordDO getParentDO() {
		return ((NmNcaSrvyRecordDO) super.getParentDO());
	}

	public void setParentDO(NmNcaSrvyRecordDO headDO) {
		setParent(headDO);
	}

	public NmNcaSrvyItemDO[] getNmNcaSrvyItemDO() {
		IBaseDO[] dos = getChildren(NmNcaSrvyItemDO.class);
		if(dos==null) return null;
		NmNcaSrvyItemDO[] result=new NmNcaSrvyItemDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NmNcaSrvyItemDO)dos[i];
		}
		return result;
	}
	
	public void setNmNcaSrvyItemDO(NmNcaSrvyItemDO[] dos) {
		setChildren(NmNcaSrvyItemDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		SatsrvyAggDODesc desc = new SatsrvyAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NmNcaSrvyRecordDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nm.nca.satsrvyrecord.d.NmNcaSrvyItemDO")) {
             return new NmNcaSrvyItemDO();
         }
         return null;
     }
}