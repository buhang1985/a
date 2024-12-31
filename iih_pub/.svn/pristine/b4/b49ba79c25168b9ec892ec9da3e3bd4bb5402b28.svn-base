package iih.bd.srv.srvpkggrpitm.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.srv.srvpkggrpitm.d.desc.SrvpkggrpitmAggDODesc;



/**
 * 医疗服务包分组项目
 */
public class SrvpkggrpitmAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public SrvPkgItmDO getParentDO() {
		return ((SrvPkgItmDO) super.getParentDO());
	}

	public void setParentDO(SrvPkgItmDO headDO) {
		setParent(headDO);
	}

	public SrvPkgItmSrvContrastDO[] getSrvPkgItmSrvContrastDO() {
		IBaseDO[] dos = getChildren(SrvPkgItmSrvContrastDO.class);
		if(dos==null) return null;
		SrvPkgItmSrvContrastDO[] result=new SrvPkgItmSrvContrastDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(SrvPkgItmSrvContrastDO)dos[i];
		}
		return result;
	}
	
	public void setSrvPkgItmSrvContrastDO(SrvPkgItmSrvContrastDO[] dos) {
		setChildren(SrvPkgItmSrvContrastDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		SrvpkggrpitmAggDODesc desc = new SrvpkggrpitmAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new SrvPkgItmDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.srv.srvpkggrpitm.d.SrvPkgItmSrvContrastDO")) {
             return new SrvPkgItmSrvContrastDO();
         }
         return null;
     }
}