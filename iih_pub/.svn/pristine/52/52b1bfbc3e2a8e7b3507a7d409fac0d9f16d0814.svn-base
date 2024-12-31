package iih.nm.nit.nitpracgrppl.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nm.nit.nitpracgrppl.d.desc.NitpracgrpplAggDODesc;



/**
 * 小组计划
 */
public class NitpracgrpplAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NitPracgrpPlDO getParentDO() {
		return ((NitPracgrpPlDO) super.getParentDO());
	}

	public void setParentDO(NitPracgrpPlDO headDO) {
		setParent(headDO);
	}

	public NitPracgrpPlDepDO[] getNitPracgrpPlDepDO() {
		IBaseDO[] dos = getChildren(NitPracgrpPlDepDO.class);
		if(dos==null) return null;
		NitPracgrpPlDepDO[] result=new NitPracgrpPlDepDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NitPracgrpPlDepDO)dos[i];
		}
		return result;
	}
	
	public void setNitPracgrpPlDepDO(NitPracgrpPlDepDO[] dos) {
		setChildren(NitPracgrpPlDepDO.class, dos);
	}
	public NitPracGrpPlPsnDO[] getNitPracGrpPlPsnDO() {
		IBaseDO[] dos = getChildren(NitPracGrpPlPsnDO.class);
		if(dos==null) return null;
		NitPracGrpPlPsnDO[] result=new NitPracGrpPlPsnDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NitPracGrpPlPsnDO)dos[i];
		}
		return result;
	}
	
	public void setNitPracGrpPlPsnDO(NitPracGrpPlPsnDO[] dos) {
		setChildren(NitPracGrpPlPsnDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		NitpracgrpplAggDODesc desc = new NitpracgrpplAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NitPracgrpPlDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nm.nit.nitpracgrppl.d.NitPracgrpPlDepDO")) {
             return new NitPracgrpPlDepDO();
         }
	    else if (clzName.equals("iih.nm.nit.nitpracgrppl.d.NitPracGrpPlPsnDO")) {
             return new NitPracGrpPlPsnDO();
         }
         return null;
     }
}