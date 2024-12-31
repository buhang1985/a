package iih.syn.common.userinit.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.syn.common.userinit.d.desc.UserinitAggDODesc;



/**
 * 用户同步初始化
 */
public class UserinitAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public SynUserInitDO getParentDO() {
		return ((SynUserInitDO) super.getParentDO());
	}

	public void setParentDO(SynUserInitDO headDO) {
		setParent(headDO);
	}

	public SYnUserInitRespDO[] getSYnUserInitRespDO() {
		IBaseDO[] dos = getChildren(SYnUserInitRespDO.class);
		if(dos==null) return null;
		SYnUserInitRespDO[] result=new SYnUserInitRespDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(SYnUserInitRespDO)dos[i];
		}
		return result;
	}
	
	public void setSYnUserInitRespDO(SYnUserInitRespDO[] dos) {
		setChildren(SYnUserInitRespDO.class, dos);
	}
	public SynUserInitOrgDO[] getSynUserInitOrgDO() {
		IBaseDO[] dos = getChildren(SynUserInitOrgDO.class);
		if(dos==null) return null;
		SynUserInitOrgDO[] result=new SynUserInitOrgDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(SynUserInitOrgDO)dos[i];
		}
		return result;
	}
	
	public void setSynUserInitOrgDO(SynUserInitOrgDO[] dos) {
		setChildren(SynUserInitOrgDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		UserinitAggDODesc desc = new UserinitAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new SynUserInitDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.syn.common.userinit.d.SYnUserInitRespDO")) {
             return new SYnUserInitRespDO();
         }
	    else if (clzName.equals("iih.syn.common.userinit.d.SynUserInitOrgDO")) {
             return new SynUserInitOrgDO();
         }
         return null;
     }
}