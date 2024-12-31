package iih.bd.srv.medsrvpkg.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.srv.medsrvpkg.d.desc.MedsrvpkgAggDODesc;



/**
 * 医疗服务包
 */
public class MedsrvpkgAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public MedSrvPkgDO getParentDO() {
		return ((MedSrvPkgDO) super.getParentDO());
	}

	public void setParentDO(MedSrvPkgDO headDO) {
		setParent(headDO);
	}

	public MedSrvPkgItemDO[] getMedSrvPkgItemDO() {
		IBaseDO[] dos = getChildren(MedSrvPkgItemDO.class);
		if(dos==null) return null;
		MedSrvPkgItemDO[] result=new MedSrvPkgItemDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(MedSrvPkgItemDO)dos[i];
		}
		return result;
	}
	
	public void setMedSrvPkgItemDO(MedSrvPkgItemDO[] dos) {
		setChildren(MedSrvPkgItemDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		MedsrvpkgAggDODesc desc = new MedsrvpkgAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new MedSrvPkgDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.srv.medsrvpkg.d.MedSrvPkgItemDO")) {
             return new MedSrvPkgItemDO();
         }
         return null;
     }
}