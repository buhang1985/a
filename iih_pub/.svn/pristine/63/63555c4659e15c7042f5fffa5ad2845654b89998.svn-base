package iih.ci.tsip.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.tsip.d.desc.CitsorderAggDODesc;



/**
 * 治疗方案医嘱
 */
public class CitsorderAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public CiTsOrDO getParentDO() {
		return ((CiTsOrDO) super.getParentDO());
	}

	public void setParentDO(CiTsOrDO headDO) {
		setParent(headDO);
	}

	public CiTsOrSrvDO[] getCiTsOrSrvDO() {
		IBaseDO[] dos = getChildren(CiTsOrSrvDO.class);
		if(dos==null) return null;
		CiTsOrSrvDO[] result=new CiTsOrSrvDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(CiTsOrSrvDO)dos[i];
		}
		return result;
	}
	
	public void setCiTsOrSrvDO(CiTsOrSrvDO[] dos) {
		setChildren(CiTsOrSrvDO.class, dos);
	}
	public CiTsOrSrvSetDO[] getCiTsOrSrvSetDO() {
		IBaseDO[] dos = getChildren(CiTsOrSrvSetDO.class);
		if(dos==null) return null;
		CiTsOrSrvSetDO[] result=new CiTsOrSrvSetDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(CiTsOrSrvSetDO)dos[i];
		}
		return result;
	}
	
	public void setCiTsOrSrvSetDO(CiTsOrSrvSetDO[] dos) {
		setChildren(CiTsOrSrvSetDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		CitsorderAggDODesc desc = new CitsorderAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new CiTsOrDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.tsip.d.CiTsOrSrvDO")) {
             return new CiTsOrSrvDO();
         }
	    else if (clzName.equals("iih.ci.tsip.d.CiTsOrSrvSetDO")) {
             return new CiTsOrSrvSetDO();
         }
         return null;
     }
}