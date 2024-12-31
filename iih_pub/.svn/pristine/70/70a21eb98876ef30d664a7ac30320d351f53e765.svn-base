package iih.ci.mrqc.mrconnotationqc.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mrqc.mrconnotationqc.d.desc.MrconnotationqcAggDODesc;



/**
 * mrconnotationqcdo
 */
public class MrconnotationqcAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public MrConnotationQcDO getParentDO() {
		return ((MrConnotationQcDO) super.getParentDO());
	}

	public void setParentDO(MrConnotationQcDO headDO) {
		setParent(headDO);
	}

	public MrConnotationQcItmDO[] getMrConnotationQcItmDO() {
		IBaseDO[] dos = getChildren(MrConnotationQcItmDO.class);
		if(dos==null) return null;
		MrConnotationQcItmDO[] result=new MrConnotationQcItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(MrConnotationQcItmDO)dos[i];
		}
		return result;
	}
	
	public void setMrConnotationQcItmDO(MrConnotationQcItmDO[] dos) {
		setChildren(MrConnotationQcItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		MrconnotationqcAggDODesc desc = new MrconnotationqcAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new MrConnotationQcDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mrqc.mrconnotationqc.d.MrConnotationQcItmDO")) {
             return new MrConnotationQcItmDO();
         }
         return null;
     }
}