package iih.bd.fc.wf.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.fc.wf.d.desc.WfAggDODesc;



/**
 * 流程配置_医嘱流向
 */
public class WfAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public WfDO getParentDO() {
		return ((WfDO) super.getParentDO());
	}

	public void setParentDO(WfDO headDO) {
		setParent(headDO);
	}

	public WfSrvtpDO[] getWfSrvtpDO() {
		IBaseDO[] dos = getChildren(WfSrvtpDO.class);
		if(dos==null) return null;
		WfSrvtpDO[] result=new WfSrvtpDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(WfSrvtpDO)dos[i];
		}
		return result;
	}
	
	public void setWfSrvtpDO(WfSrvtpDO[] dos) {
		setChildren(WfSrvtpDO.class, dos);
	}
	public WfDepDO[] getWfDepDO() {
		IBaseDO[] dos = getChildren(WfDepDO.class);
		if(dos==null) return null;
		WfDepDO[] result=new WfDepDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(WfDepDO)dos[i];
		}
		return result;
	}
	
	public void setWfDepDO(WfDepDO[] dos) {
		setChildren(WfDepDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		WfAggDODesc desc = new WfAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new WfDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.fc.wf.d.WfSrvtpDO")) {
             return new WfSrvtpDO();
         }
	    else if (clzName.equals("iih.bd.fc.wf.d.WfDepDO")) {
             return new WfDepDO();
         }
         return null;
     }
}