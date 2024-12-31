package iih.sc.scp.aidset.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.sc.scp.aidset.d.desc.ScplanaidsetAggDODesc;



/**
 * 辅助样本设置
 */
public class ScplanaidsetAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public ScPlanAidSetDO getParentDO() {
		return ((ScPlanAidSetDO) super.getParentDO());
	}

	public void setParentDO(ScPlanAidSetDO headDO) {
		setParent(headDO);
	}

	public ScPlanAidSetDtlDO[] getScPlanAidSetDtlDO() {
		IBaseDO[] dos = getChildren(ScPlanAidSetDtlDO.class);
		if(dos==null) return null;
		ScPlanAidSetDtlDO[] result=new ScPlanAidSetDtlDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(ScPlanAidSetDtlDO)dos[i];
		}
		return result;
	}
	
	public void setScPlanAidSetDtlDO(ScPlanAidSetDtlDO[] dos) {
		setChildren(ScPlanAidSetDtlDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		ScplanaidsetAggDODesc desc = new ScplanaidsetAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new ScPlanAidSetDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.sc.scp.aidset.d.ScPlanAidSetDtlDO")) {
             return new ScPlanAidSetDtlDO();
         }
         return null;
     }
}