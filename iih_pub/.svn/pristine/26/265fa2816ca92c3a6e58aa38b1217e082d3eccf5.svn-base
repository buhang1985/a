package iih.nm.nqm.nmnqmtask.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nm.nqm.nmnqmtask.d.desc.NqmtaskAggDODesc;



/**
 * 护理管理_检查任务
 */
public class NqmtaskAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NmNqmTaskDO getParentDO() {
		return ((NmNqmTaskDO) super.getParentDO());
	}

	public void setParentDO(NmNqmTaskDO headDO) {
		setParent(headDO);
	}

	public NmNqmTaskActorDO[] getNmNqmTaskActorDO() {
		IBaseDO[] dos = getChildren(NmNqmTaskActorDO.class);
		if(dos==null) return null;
		NmNqmTaskActorDO[] result=new NmNqmTaskActorDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NmNqmTaskActorDO)dos[i];
		}
		return result;
	}
	
	public void setNmNqmTaskActorDO(NmNqmTaskActorDO[] dos) {
		setChildren(NmNqmTaskActorDO.class, dos);
	}
	public NqmTaskDetDO[] getNqmTaskDetDO() {
		IBaseDO[] dos = getChildren(NqmTaskDetDO.class);
		if(dos==null) return null;
		NqmTaskDetDO[] result=new NqmTaskDetDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NqmTaskDetDO)dos[i];
		}
		return result;
	}
	
	public void setNqmTaskDetDO(NqmTaskDetDO[] dos) {
		setChildren(NqmTaskDetDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		NqmtaskAggDODesc desc = new NqmtaskAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NmNqmTaskDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nm.nqm.nmnqmtask.d.NmNqmTaskActorDO")) {
             return new NmNqmTaskActorDO();
         }
	    else if (clzName.equals("iih.nm.nqm.nmnqmtask.d.NqmTaskDetDO")) {
             return new NqmTaskDetDO();
         }
         return null;
     }
}