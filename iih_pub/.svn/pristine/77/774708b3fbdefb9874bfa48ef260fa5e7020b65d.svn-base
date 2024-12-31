package iih.ci.ord.app.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.ord.app.d.desc.CiappbtsheetAggDODesc;



/**
 * 备血打印申请单
 */
public class CiappbtsheetAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public CiAppBtSheetDO getParentDO() {
		return ((CiAppBtSheetDO) super.getParentDO());
	}

	public void setParentDO(CiAppBtSheetDO headDO) {
		setParent(headDO);
	}

	public CiAppBtItemSheetDO[] getCiAppBtItemSheetDO() {
		IBaseDO[] dos = getChildren(CiAppBtItemSheetDO.class);
		if(dos==null) return null;
		CiAppBtItemSheetDO[] result=new CiAppBtItemSheetDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(CiAppBtItemSheetDO)dos[i];
		}
		return result;
	}
	
	public void setCiAppBtItemSheetDO(CiAppBtItemSheetDO[] dos) {
		setChildren(CiAppBtItemSheetDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		CiappbtsheetAggDODesc desc = new CiappbtsheetAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new CiAppBtSheetDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.ord.app.d.CiAppBtItemSheetDO")) {
             return new CiAppBtItemSheetDO();
         }
         return null;
     }
}