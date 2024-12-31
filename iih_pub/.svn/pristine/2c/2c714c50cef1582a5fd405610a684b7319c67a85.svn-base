package iih.pe.pbd.pewfroute.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.pbd.pewfroute.d.desc.PewfrouteAggDODesc;



/**
 * 体检流程路线定义
 */
public class PewfrouteAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeWfRouteDO getParentDO() {
		return ((PeWfRouteDO) super.getParentDO());
	}

	public void setParentDO(PeWfRouteDO headDO) {
		setParent(headDO);
	}

	public PeChkRouteDO[] getPeChkRouteDO() {
		IBaseDO[] dos = getChildren(PeChkRouteDO.class);
		if(dos==null) return null;
		PeChkRouteDO[] result=new PeChkRouteDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeChkRouteDO)dos[i];
		}
		return result;
	}
	
	public void setPeChkRouteDO(PeChkRouteDO[] dos) {
		setChildren(PeChkRouteDO.class, dos);
	}
	public PeChkRouteCondDO[] getPeChkRouteCondDO() {
		IBaseDO[] dos = getChildren(PeChkRouteCondDO.class);
		if(dos==null) return null;
		PeChkRouteCondDO[] result=new PeChkRouteCondDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeChkRouteCondDO)dos[i];
		}
		return result;
	}
	
	public void setPeChkRouteCondDO(PeChkRouteCondDO[] dos) {
		setChildren(PeChkRouteCondDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PewfrouteAggDODesc desc = new PewfrouteAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeWfRouteDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.pbd.pewfroute.d.PeChkRouteDO")) {
             return new PeChkRouteDO();
         }
	    else if (clzName.equals("iih.pe.pbd.pewfroute.d.PeChkRouteCondDO")) {
             return new PeChkRouteCondDO();
         }
         return null;
     }
}