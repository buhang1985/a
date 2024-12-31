package iih.nm.nqm.nmnqmcstmpl.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nm.nqm.nmnqmcstmpl.d.desc.NmnqmcstmplAggDODesc;



/**
 * 护理管理_检查标准模板
 */
public class NmnqmcstmplAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NmnqmcstmplDO getParentDO() {
		return ((NmnqmcstmplDO) super.getParentDO());
	}

	public void setParentDO(NmnqmcstmplDO headDO) {
		setParent(headDO);
	}

	public NmnqmtmplitmDO[] getNmnqmtmplitmDO() {
		IBaseDO[] dos = getChildren(NmnqmtmplitmDO.class);
		if(dos==null) return null;
		NmnqmtmplitmDO[] result=new NmnqmtmplitmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NmnqmtmplitmDO)dos[i];
		}
		return result;
	}
	
	public void setNmnqmtmplitmDO(NmnqmtmplitmDO[] dos) {
		setChildren(NmnqmtmplitmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		NmnqmcstmplAggDODesc desc = new NmnqmcstmplAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NmnqmcstmplDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nm.nqm.nmnqmcstmpl.d.NmnqmtmplitmDO")) {
             return new NmnqmtmplitmDO();
         }
         return null;
     }
}