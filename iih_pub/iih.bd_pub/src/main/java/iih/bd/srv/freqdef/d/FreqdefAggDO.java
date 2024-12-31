package iih.bd.srv.freqdef.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.srv.freqdef.d.desc.FreqdefAggDODesc;



/**
 * 医嘱频次定义
 */
public class FreqdefAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public FreqDefDO getParentDO() {
		return ((FreqDefDO) super.getParentDO());
	}

	public void setParentDO(FreqDefDO headDO) {
		setParent(headDO);
	}

	public FreqTimeDO[] getFreqTimeDO() {
		IBaseDO[] dos = getChildren(FreqTimeDO.class);
		if(dos==null) return null;
		FreqTimeDO[] result=new FreqTimeDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(FreqTimeDO)dos[i];
		}
		return result;
	}
	
	public void setFreqTimeDO(FreqTimeDO[] dos) {
		setChildren(FreqTimeDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		FreqdefAggDODesc desc = new FreqdefAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new FreqDefDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.srv.freqdef.d.FreqTimeDO")) {
             return new FreqTimeDO();
         }
         return null;
     }
}