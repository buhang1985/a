package iih.sc.scbd.scdeptparam.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.sc.scbd.scdeptparam.d.desc.ScdeptparamAggDODesc;



/**
 * 排班科室参数
 */
public class ScdeptparamAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public ScDeptParamDO getParentDO() {
		return ((ScDeptParamDO) super.getParentDO());
	}

	public void setParentDO(ScDeptParamDO headDO) {
		setParent(headDO);
	}

	public ScDeptParamDsDO[] getScDeptParamDsDO() {
		IBaseDO[] dos = getChildren(ScDeptParamDsDO.class);
		if(dos==null) return null;
		ScDeptParamDsDO[] result=new ScDeptParamDsDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(ScDeptParamDsDO)dos[i];
		}
		return result;
	}
	
	public void setScDeptParamDsDO(ScDeptParamDsDO[] dos) {
		setChildren(ScDeptParamDsDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		ScdeptparamAggDODesc desc = new ScdeptparamAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new ScDeptParamDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.sc.scbd.scdeptparam.d.ScDeptParamDsDO")) {
             return new ScDeptParamDsDO();
         }
         return null;
     }
}