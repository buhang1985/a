package iih.ci.mr.nu.baby24care.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mr.nu.baby24care.d.desc.Baby24careAggDODesc;



/**
 * 新生儿24小时护理记录单
 */
public class Baby24careAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public Baby24InfoDO getParentDO() {
		return ((Baby24InfoDO) super.getParentDO());
	}

	public void setParentDO(Baby24InfoDO headDO) {
		setParent(headDO);
	}

	public NurRecDO[] getNurRecDO() {
		IBaseDO[] dos = getChildren(NurRecDO.class);
		if(dos==null) return null;
		NurRecDO[] result=new NurRecDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NurRecDO)dos[i];
		}
		return result;
	}
	
	public void setNurRecDO(NurRecDO[] dos) {
		setChildren(NurRecDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		Baby24careAggDODesc desc = new Baby24careAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new Baby24InfoDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mr.nu.baby24care.d.NurRecDO")) {
             return new NurRecDO();
         }
         return null;
     }
}