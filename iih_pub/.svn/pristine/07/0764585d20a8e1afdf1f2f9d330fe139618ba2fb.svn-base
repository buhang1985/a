package iih.pi.patsrvpkg.pipatsrvpkgitem.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pi.patsrvpkg.pipatsrvpkgitem.d.desc.PipatsrvpkgitemAggDODesc;



/**
 * 患者服务包服务项目对照
 */
public class PipatsrvpkgitemAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PiPatSrvPkgItmDO getParentDO() {
		return ((PiPatSrvPkgItmDO) super.getParentDO());
	}

	public void setParentDO(PiPatSrvPkgItmDO headDO) {
		setParent(headDO);
	}

	public PiPatSrvPkgItemCompDO[] getPiPatSrvPkgItemCompDO() {
		IBaseDO[] dos = getChildren(PiPatSrvPkgItemCompDO.class);
		if(dos==null) return null;
		PiPatSrvPkgItemCompDO[] result=new PiPatSrvPkgItemCompDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PiPatSrvPkgItemCompDO)dos[i];
		}
		return result;
	}
	
	public void setPiPatSrvPkgItemCompDO(PiPatSrvPkgItemCompDO[] dos) {
		setChildren(PiPatSrvPkgItemCompDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PipatsrvpkgitemAggDODesc desc = new PipatsrvpkgitemAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PiPatSrvPkgItmDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pi.patsrvpkg.pipatsrvpkgitem.d.PiPatSrvPkgItemCompDO")) {
             return new PiPatSrvPkgItemCompDO();
         }
         return null;
     }
}