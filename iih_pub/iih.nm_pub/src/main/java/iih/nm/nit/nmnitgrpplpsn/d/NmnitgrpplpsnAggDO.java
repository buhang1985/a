package iih.nm.nit.nmnitgrpplpsn.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nm.nit.nmnitgrpplpsn.d.desc.NmnitgrpplpsnAggDODesc;



/**
 * 护理管理_实习小组计划_人员
 */
public class NmnitgrpplpsnAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NmNitGrpPlPsnDO getParentDO() {
		return ((NmNitGrpPlPsnDO) super.getParentDO());
	}

	public void setParentDO(NmNitGrpPlPsnDO headDO) {
		setParent(headDO);
	}

	public NmNitPsnCycRecDO[] getNmNitPsnCycRecDO() {
		IBaseDO[] dos = getChildren(NmNitPsnCycRecDO.class);
		if(dos==null) return null;
		NmNitPsnCycRecDO[] result=new NmNitPsnCycRecDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NmNitPsnCycRecDO)dos[i];
		}
		return result;
	}
	
	public void setNmNitPsnCycRecDO(NmNitPsnCycRecDO[] dos) {
		setChildren(NmNitPsnCycRecDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		NmnitgrpplpsnAggDODesc desc = new NmnitgrpplpsnAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NmNitGrpPlPsnDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nm.nit.nmnitgrpplpsn.d.NmNitPsnCycRecDO")) {
             return new NmNitPsnCycRecDO();
         }
         return null;
     }
}