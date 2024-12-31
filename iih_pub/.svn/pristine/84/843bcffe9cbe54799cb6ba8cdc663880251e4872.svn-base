package iih.ci.ord.app.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.ord.app.d.desc.CiapprissheetAggDODesc;



/**
 * 检查打印申请单
 */
public class CiapprissheetAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public CiAppRisSheetDO getParentDO() {
		return ((CiAppRisSheetDO) super.getParentDO());
	}

	public void setParentDO(CiAppRisSheetDO headDO) {
		setParent(headDO);
	}

	public CiAppRisSheetOrDO[] getCiAppRisSheetOrDO() {
		IBaseDO[] dos = getChildren(CiAppRisSheetOrDO.class);
		if(dos==null) return null;
		CiAppRisSheetOrDO[] result=new CiAppRisSheetOrDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(CiAppRisSheetOrDO)dos[i];
		}
		return result;
	}
	
	public void setCiAppRisSheetOrDO(CiAppRisSheetOrDO[] dos) {
		setChildren(CiAppRisSheetOrDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		CiapprissheetAggDODesc desc = new CiapprissheetAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new CiAppRisSheetDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.ord.app.d.CiAppRisSheetOrDO")) {
             return new CiAppRisSheetOrDO();
         }
         return null;
     }
}