package iih.hp.cp.app.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.hp.cp.app.d.desc.HpcpappAggDODesc;



/**
 * 诊疗计划应用
 */
public class HpcpappAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public HpCpAppDO getParentDO() {
		return ((HpCpAppDO) super.getParentDO());
	}

	public void setParentDO(HpCpAppDO headDO) {
		setParent(headDO);
	}

	public HpCpAppLogDO[] getHpCpAppLogDO() {
		IBaseDO[] dos = getChildren(HpCpAppLogDO.class);
		if(dos==null) return null;
		HpCpAppLogDO[] result=new HpCpAppLogDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(HpCpAppLogDO)dos[i];
		}
		return result;
	}
	
	public void setHpCpAppLogDO(HpCpAppLogDO[] dos) {
		setChildren(HpCpAppLogDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		HpcpappAggDODesc desc = new HpcpappAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new HpCpAppDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.hp.cp.app.d.HpCpAppLogDO")) {
             return new HpCpAppLogDO();
         }
         return null;
     }
}