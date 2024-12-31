package iih.bd.srv.srvpkg.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.srv.srvpkg.d.desc.SrvpkgAggDODesc;



/**
 * 医疗服务包
 */
public class SrvpkgAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public SrvPkgDO getParentDO() {
		return ((SrvPkgDO) super.getParentDO());
	}

	public void setParentDO(SrvPkgDO headDO) {
		setParent(headDO);
	}

	public SrvPkgCondDO[] getSrvPkgCondDO() {
		IBaseDO[] dos = getChildren(SrvPkgCondDO.class);
		if(dos==null) return null;
		SrvPkgCondDO[] result=new SrvPkgCondDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(SrvPkgCondDO)dos[i];
		}
		return result;
	}
	
	public void setSrvPkgCondDO(SrvPkgCondDO[] dos) {
		setChildren(SrvPkgCondDO.class, dos);
	}
	public SrvPkgDepDO[] getSrvPkgDepDO() {
		IBaseDO[] dos = getChildren(SrvPkgDepDO.class);
		if(dos==null) return null;
		SrvPkgDepDO[] result=new SrvPkgDepDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(SrvPkgDepDO)dos[i];
		}
		return result;
	}
	
	public void setSrvPkgDepDO(SrvPkgDepDO[] dos) {
		setChildren(SrvPkgDepDO.class, dos);
	}
	public SrvPkgContrDO[] getSrvPkgContrDO() {
		IBaseDO[] dos = getChildren(SrvPkgContrDO.class);
		if(dos==null) return null;
		SrvPkgContrDO[] result=new SrvPkgContrDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(SrvPkgContrDO)dos[i];
		}
		return result;
	}
	
	public void setSrvPkgContrDO(SrvPkgContrDO[] dos) {
		setChildren(SrvPkgContrDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		SrvpkgAggDODesc desc = new SrvpkgAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new SrvPkgDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.srv.srvpkg.d.SrvPkgCondDO")) {
             return new SrvPkgCondDO();
         }
	    else if (clzName.equals("iih.bd.srv.srvpkg.d.SrvPkgDepDO")) {
             return new SrvPkgDepDO();
         }
	    else if (clzName.equals("iih.bd.srv.srvpkg.d.SrvPkgContrDO")) {
             return new SrvPkgContrDO();
         }
         return null;
     }
}