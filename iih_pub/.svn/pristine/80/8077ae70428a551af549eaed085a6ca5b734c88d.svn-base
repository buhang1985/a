package iih.ci.mr.nu.ipevalsigle.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mr.nu.ipevalsigle.d.desc.IpevalsigleAggDODesc;



/**
 * 住院患者评价单
 */
public class IpevalsigleAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public EvaluateDO getParentDO() {
		return ((EvaluateDO) super.getParentDO());
	}

	public void setParentDO(EvaluateDO headDO) {
		setParent(headDO);
	}

	public EvaluateItmDO[] getEvaluateItmDO() {
		IBaseDO[] dos = getChildren(EvaluateItmDO.class);
		if(dos==null) return null;
		EvaluateItmDO[] result=new EvaluateItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(EvaluateItmDO)dos[i];
		}
		return result;
	}
	
	public void setEvaluateItmDO(EvaluateItmDO[] dos) {
		setChildren(EvaluateItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		IpevalsigleAggDODesc desc = new IpevalsigleAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new EvaluateDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mr.nu.ipevalsigle.d.EvaluateItmDO")) {
             return new EvaluateItmDO();
         }
         return null;
     }
}