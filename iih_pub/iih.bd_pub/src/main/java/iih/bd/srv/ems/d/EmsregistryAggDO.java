package iih.bd.srv.ems.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.srv.ems.d.desc.EmsregistryAggDODesc;



/**
 * 医疗单注册
 */
public class EmsregistryAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public EmsDO getParentDO() {
		return ((EmsDO) super.getParentDO());
	}

	public void setParentDO(EmsDO headDO) {
		setParent(headDO);
	}

	public EmsRelSrvDO[] getEmsRelSrvDO() {
		IBaseDO[] dos = getChildren(EmsRelSrvDO.class);
		if(dos==null) return null;
		EmsRelSrvDO[] result=new EmsRelSrvDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(EmsRelSrvDO)dos[i];
		}
		return result;
	}
	
	public void setEmsRelSrvDO(EmsRelSrvDO[] dos) {
		setChildren(EmsRelSrvDO.class, dos);
	}
	public EmsIndexDO[] getEmsIndexDO() {
		IBaseDO[] dos = getChildren(EmsIndexDO.class);
		if(dos==null) return null;
		EmsIndexDO[] result=new EmsIndexDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(EmsIndexDO)dos[i];
		}
		return result;
	}
	
	public void setEmsIndexDO(EmsIndexDO[] dos) {
		setChildren(EmsIndexDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		EmsregistryAggDODesc desc = new EmsregistryAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new EmsDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.srv.ems.d.EmsRelSrvDO")) {
             return new EmsRelSrvDO();
         }
	    else if (clzName.equals("iih.bd.srv.ems.d.EmsIndexDO")) {
             return new EmsIndexDO();
         }
         return null;
     }
}