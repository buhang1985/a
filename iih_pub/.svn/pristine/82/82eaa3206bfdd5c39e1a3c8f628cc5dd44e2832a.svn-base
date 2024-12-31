package iih.bd.res.mtassist.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.res.mtassist.d.desc.MtassistAggDODesc;



/**
 * 医技辅
 */
public class MtassistAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public MtAssistDO getParentDO() {
		return ((MtAssistDO) super.getParentDO());
	}

	public void setParentDO(MtAssistDO headDO) {
		setParent(headDO);
	}

	public MtassistFundDO[] getMtassistFundDO() {
		IBaseDO[] dos = getChildren(MtassistFundDO.class);
		if(dos==null) return null;
		MtassistFundDO[] result=new MtassistFundDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(MtassistFundDO)dos[i];
		}
		return result;
	}
	
	public void setMtassistFundDO(MtassistFundDO[] dos) {
		setChildren(MtassistFundDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		MtassistAggDODesc desc = new MtassistAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new MtAssistDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.res.mtassist.d.MtassistFundDO")) {
             return new MtassistFundDO();
         }
         return null;
     }
}