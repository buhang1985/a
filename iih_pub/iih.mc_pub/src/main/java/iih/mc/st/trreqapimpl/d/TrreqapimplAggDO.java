package iih.mc.st.trreqapimpl.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.mc.st.trreqapimpl.d.desc.TrreqapimplAggDODesc;



/**
 * 调拨单
 */
public class TrreqapimplAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public McTrReqApImplDO getParentDO() {
		return ((McTrReqApImplDO) super.getParentDO());
	}

	public void setParentDO(McTrReqApImplDO headDO) {
		setParent(headDO);
	}

	public McTrReqApImplSumItemDO[] getMcTrReqApImplSumItemDO() {
		IBaseDO[] dos = getChildren(McTrReqApImplSumItemDO.class);
		if(dos==null) return null;
		McTrReqApImplSumItemDO[] result=new McTrReqApImplSumItemDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(McTrReqApImplSumItemDO)dos[i];
		}
		return result;
	}
	
	public void setMcTrReqApImplSumItemDO(McTrReqApImplSumItemDO[] dos) {
		setChildren(McTrReqApImplSumItemDO.class, dos);
	}
	public McTrReqApImplItemDO[] getMcTrReqApImplItemDO() {
		IBaseDO[] dos = getChildren(McTrReqApImplItemDO.class);
		if(dos==null) return null;
		McTrReqApImplItemDO[] result=new McTrReqApImplItemDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(McTrReqApImplItemDO)dos[i];
		}
		return result;
	}
	
	public void setMcTrReqApImplItemDO(McTrReqApImplItemDO[] dos) {
		setChildren(McTrReqApImplItemDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		TrreqapimplAggDODesc desc = new TrreqapimplAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new McTrReqApImplDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.mc.st.trreqapimpl.d.McTrReqApImplSumItemDO")) {
             return new McTrReqApImplSumItemDO();
         }
	    else if (clzName.equals("iih.mc.st.trreqapimpl.d.McTrReqApImplItemDO")) {
             return new McTrReqApImplItemDO();
         }
         return null;
     }
}