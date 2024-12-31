package iih.cssd.dpbd.pkg.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.cssd.dpbd.pkg.d.desc.PkgAggDODesc;



/**
 * 消毒包定义
 */
public class PkgAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public CssdPkgDO getParentDO() {
		return ((CssdPkgDO) super.getParentDO());
	}

	public void setParentDO(CssdPkgDO headDO) {
		setParent(headDO);
	}

	public Cssdpkgmm[] getCssdpkgmm() {
		IBaseDO[] dos = getChildren(Cssdpkgmm.class);
		if(dos==null) return null;
		Cssdpkgmm[] result=new Cssdpkgmm[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(Cssdpkgmm)dos[i];
		}
		return result;
	}
	
	public void setCssdpkgmm(Cssdpkgmm[] dos) {
		setChildren(Cssdpkgmm.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PkgAggDODesc desc = new PkgAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new CssdPkgDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.cssd.dpbd.pkg.d.Cssdpkgmm")) {
             return new Cssdpkgmm();
         }
         return null;
     }
}