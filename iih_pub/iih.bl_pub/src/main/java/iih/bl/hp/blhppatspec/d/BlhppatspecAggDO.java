package iih.bl.hp.blhppatspec.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bl.hp.blhppatspec.d.desc.BlhppatspecAggDODesc;



/**
 * 医保特殊病患者
 */
public class BlhppatspecAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public BlHpPatSpecDO getParentDO() {
		return ((BlHpPatSpecDO) super.getParentDO());
	}

	public void setParentDO(BlHpPatSpecDO headDO) {
		setParent(headDO);
	}

	public BlHpPatSpecDiDO[] getBlHpPatSpecDiDO() {
		IBaseDO[] dos = getChildren(BlHpPatSpecDiDO.class);
		if(dos==null) return null;
		BlHpPatSpecDiDO[] result=new BlHpPatSpecDiDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(BlHpPatSpecDiDO)dos[i];
		}
		return result;
	}
	
	public void setBlHpPatSpecDiDO(BlHpPatSpecDiDO[] dos) {
		setChildren(BlHpPatSpecDiDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		BlhppatspecAggDODesc desc = new BlhppatspecAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new BlHpPatSpecDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bl.hp.blhppatspec.d.BlHpPatSpecDiDO")) {
             return new BlHpPatSpecDiDO();
         }
         return null;
     }
}