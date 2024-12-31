package iih.pe.pqn.peevallifestyle.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.pqn.peevallifestyle.d.desc.PeevallifestyleAggDODesc;



/**
 * 健康生活方式评估定义
 */
public class PeevallifestyleAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeEvalLifestyleDO getParentDO() {
		return ((PeEvalLifestyleDO) super.getParentDO());
	}

	public void setParentDO(PeEvalLifestyleDO headDO) {
		setParent(headDO);
	}

	public PeEvalLifestyleItmDO[] getPeEvalLifestyleItmDO() {
		IBaseDO[] dos = getChildren(PeEvalLifestyleItmDO.class);
		if(dos==null) return null;
		PeEvalLifestyleItmDO[] result=new PeEvalLifestyleItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeEvalLifestyleItmDO)dos[i];
		}
		return result;
	}
	
	public void setPeEvalLifestyleItmDO(PeEvalLifestyleItmDO[] dos) {
		setChildren(PeEvalLifestyleItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PeevallifestyleAggDODesc desc = new PeevallifestyleAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeEvalLifestyleDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.pqn.peevallifestyle.d.PeEvalLifestyleItmDO")) {
             return new PeEvalLifestyleItmDO();
         }
         return null;
     }
}