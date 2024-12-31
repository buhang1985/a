package iih.nm.nit.nmnitgrppl.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nm.nit.nmnitgrppl.d.desc.NmnitgrpplAggDODesc;



/**
 * 护理管理_实习小组_计划
 */
public class NmnitgrpplAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NmNitGrpPlDO getParentDO() {
		return ((NmNitGrpPlDO) super.getParentDO());
	}

	public void setParentDO(NmNitGrpPlDO headDO) {
		setParent(headDO);
	}

	public NmNitGrpPlDepDO[] getNmNitGrpPlDepDO() {
		IBaseDO[] dos = getChildren(NmNitGrpPlDepDO.class);
		if(dos==null) return null;
		NmNitGrpPlDepDO[] result=new NmNitGrpPlDepDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NmNitGrpPlDepDO)dos[i];
		}
		return result;
	}
	
	public void setNmNitGrpPlDepDO(NmNitGrpPlDepDO[] dos) {
		setChildren(NmNitGrpPlDepDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		NmnitgrpplAggDODesc desc = new NmnitgrpplAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NmNitGrpPlDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nm.nit.nmnitgrppl.d.NmNitGrpPlDepDO")) {
             return new NmNitGrpPlDepDO();
         }
         return null;
     }
}