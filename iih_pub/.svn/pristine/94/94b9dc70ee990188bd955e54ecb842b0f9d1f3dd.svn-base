package iih.bd.srv.ems.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.srv.ems.d.desc.EmsprntmplAggDODesc;



/**
 * 医疗单打印模板管理
 */
public class EmsprntmplAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public EmsPrnTmplDO getParentDO() {
		return ((EmsPrnTmplDO) super.getParentDO());
	}

	public void setParentDO(EmsPrnTmplDO headDO) {
		setParent(headDO);
	}

	public EmsPrnTmplRelSrvDO[] getEmsPrnTmplRelSrvDO() {
		IBaseDO[] dos = getChildren(EmsPrnTmplRelSrvDO.class);
		if(dos==null) return null;
		EmsPrnTmplRelSrvDO[] result=new EmsPrnTmplRelSrvDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(EmsPrnTmplRelSrvDO)dos[i];
		}
		return result;
	}
	
	public void setEmsPrnTmplRelSrvDO(EmsPrnTmplRelSrvDO[] dos) {
		setChildren(EmsPrnTmplRelSrvDO.class, dos);
	}
	public EmsPrnTmplRelPresDO[] getEmsPrnTmplRelPresDO() {
		IBaseDO[] dos = getChildren(EmsPrnTmplRelPresDO.class);
		if(dos==null) return null;
		EmsPrnTmplRelPresDO[] result=new EmsPrnTmplRelPresDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(EmsPrnTmplRelPresDO)dos[i];
		}
		return result;
	}
	
	public void setEmsPrnTmplRelPresDO(EmsPrnTmplRelPresDO[] dos) {
		setChildren(EmsPrnTmplRelPresDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		EmsprntmplAggDODesc desc = new EmsprntmplAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new EmsPrnTmplDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.srv.ems.d.EmsPrnTmplRelSrvDO")) {
             return new EmsPrnTmplRelSrvDO();
         }
	    else if (clzName.equals("iih.bd.srv.ems.d.EmsPrnTmplRelPresDO")) {
             return new EmsPrnTmplRelPresDO();
         }
         return null;
     }
}