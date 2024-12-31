package iih.bd.srv.mrwp.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.srv.mrwp.d.desc.MrwpAggDODesc;



/**
 * mrwp
 */
public class MrwpAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public MrWritePowerDO getParentDO() {
		return ((MrWritePowerDO) super.getParentDO());
	}

	public void setParentDO(MrWritePowerDO headDO) {
		setParent(headDO);
	}

	public MrWritePowerEmpDO[] getMrWritePowerEmpDO() {
		IBaseDO[] dos = getChildren(MrWritePowerEmpDO.class);
		if(dos==null) return null;
		MrWritePowerEmpDO[] result=new MrWritePowerEmpDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(MrWritePowerEmpDO)dos[i];
		}
		return result;
	}
	
	public void setMrWritePowerEmpDO(MrWritePowerEmpDO[] dos) {
		setChildren(MrWritePowerEmpDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		MrwpAggDODesc desc = new MrwpAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new MrWritePowerDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.srv.mrwp.d.MrWritePowerEmpDO")) {
             return new MrWritePowerEmpDO();
         }
         return null;
     }
}