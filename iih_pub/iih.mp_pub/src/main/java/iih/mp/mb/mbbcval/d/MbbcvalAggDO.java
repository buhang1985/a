package iih.mp.mb.mbbcval.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.mp.mb.mbbcval.d.desc.MbbcvalAggDODesc;



/**
 * 条码对照查询
 */
public class MbbcvalAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public MbBcValDO getParentDO() {
		return ((MbBcValDO) super.getParentDO());
	}

	public void setParentDO(MbBcValDO headDO) {
		setParent(headDO);
	}

	public MbBcValParamDO[] getMbBcValParamDO() {
		IBaseDO[] dos = getChildren(MbBcValParamDO.class);
		if(dos==null) return null;
		MbBcValParamDO[] result=new MbBcValParamDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(MbBcValParamDO)dos[i];
		}
		return result;
	}
	
	public void setMbBcValParamDO(MbBcValParamDO[] dos) {
		setChildren(MbBcValParamDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		MbbcvalAggDODesc desc = new MbbcvalAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new MbBcValDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.mp.mb.mbbcval.d.MbBcValParamDO")) {
             return new MbBcValParamDO();
         }
         return null;
     }
}