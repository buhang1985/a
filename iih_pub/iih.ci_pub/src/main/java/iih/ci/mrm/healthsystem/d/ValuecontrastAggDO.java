package iih.ci.mrm.healthsystem.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mrm.healthsystem.d.desc.ValuecontrastAggDODesc;



/**
 * 对照
 */
public class ValuecontrastAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public ValueContrastDO getParentDO() {
		return ((ValueContrastDO) super.getParentDO());
	}

	public void setParentDO(ValueContrastDO headDO) {
		setParent(headDO);
	}

	public ValueContrastDetailDO[] getValueContrastDetailDO() {
		IBaseDO[] dos = getChildren(ValueContrastDetailDO.class);
		if(dos==null) return null;
		ValueContrastDetailDO[] result=new ValueContrastDetailDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(ValueContrastDetailDO)dos[i];
		}
		return result;
	}
	
	public void setValueContrastDetailDO(ValueContrastDetailDO[] dos) {
		setChildren(ValueContrastDetailDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		ValuecontrastAggDODesc desc = new ValuecontrastAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new ValueContrastDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mrm.healthsystem.d.ValueContrastDetailDO")) {
             return new ValueContrastDetailDO();
         }
         return null;
     }
}