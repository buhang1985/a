package iih.bd.srv.srvrtctl.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.srv.srvrtctl.d.desc.SrvrtctlAggDODesc;



/**
 * 服务开立权限
 */
public class SrvrtctlAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public SrvRtCtlDO getParentDO() {
		return ((SrvRtCtlDO) super.getParentDO());
	}

	public void setParentDO(SrvRtCtlDO headDO) {
		setParent(headDO);
	}

	public SrvRtItmDO[] getSrvRtItmDO() {
		IBaseDO[] dos = getChildren(SrvRtItmDO.class);
		if(dos==null) return null;
		SrvRtItmDO[] result=new SrvRtItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(SrvRtItmDO)dos[i];
		}
		return result;
	}
	
	public void setSrvRtItmDO(SrvRtItmDO[] dos) {
		setChildren(SrvRtItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		SrvrtctlAggDODesc desc = new SrvrtctlAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new SrvRtCtlDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.srv.srvrtctl.d.SrvRtItmDO")) {
             return new SrvRtItmDO();
         }
         return null;
     }
}