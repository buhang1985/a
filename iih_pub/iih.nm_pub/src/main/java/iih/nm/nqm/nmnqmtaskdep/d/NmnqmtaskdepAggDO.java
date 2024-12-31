package iih.nm.nqm.nmnqmtaskdep.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nm.nqm.nmnqmtaskdep.d.desc.NmnqmtaskdepAggDODesc;



/**
 * 护理管理_检查任务明细
 */
public class NmnqmtaskdepAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NmNqmTaskDepDO getParentDO() {
		return ((NmNqmTaskDepDO) super.getParentDO());
	}

	public void setParentDO(NmNqmTaskDepDO headDO) {
		setParent(headDO);
	}

	public NmNqmTaskDepmtplDO[] getNmNqmTaskDepmtplDO() {
		IBaseDO[] dos = getChildren(NmNqmTaskDepmtplDO.class);
		if(dos==null) return null;
		NmNqmTaskDepmtplDO[] result=new NmNqmTaskDepmtplDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NmNqmTaskDepmtplDO)dos[i];
		}
		return result;
	}
	
	public void setNmNqmTaskDepmtplDO(NmNqmTaskDepmtplDO[] dos) {
		setChildren(NmNqmTaskDepmtplDO.class, dos);
	}
	public NmNqmTaskPsnDO[] getNmNqmTaskPsnDO() {
		IBaseDO[] dos = getChildren(NmNqmTaskPsnDO.class);
		if(dos==null) return null;
		NmNqmTaskPsnDO[] result=new NmNqmTaskPsnDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NmNqmTaskPsnDO)dos[i];
		}
		return result;
	}
	
	public void setNmNqmTaskPsnDO(NmNqmTaskPsnDO[] dos) {
		setChildren(NmNqmTaskPsnDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		NmnqmtaskdepAggDODesc desc = new NmnqmtaskdepAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NmNqmTaskDepDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nm.nqm.nmnqmtaskdep.d.NmNqmTaskDepmtplDO")) {
             return new NmNqmTaskDepmtplDO();
         }
	    else if (clzName.equals("iih.nm.nqm.nmnqmtaskdep.d.NmNqmTaskPsnDO")) {
             return new NmNqmTaskPsnDO();
         }
         return null;
     }
}