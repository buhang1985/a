package iih.pe.pqn.peevalsubhealth.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.pqn.peevalsubhealth.d.desc.PeevalsubhealthAggDODesc;



/**
 * 体检亚健康评估定义
 */
public class PeevalsubhealthAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeEvalSubhealthDO getParentDO() {
		return ((PeEvalSubhealthDO) super.getParentDO());
	}

	public void setParentDO(PeEvalSubhealthDO headDO) {
		setParent(headDO);
	}

	public PeEvalSHQaDO[] getPeEvalSHQaDO() {
		IBaseDO[] dos = getChildren(PeEvalSHQaDO.class);
		if(dos==null) return null;
		PeEvalSHQaDO[] result=new PeEvalSHQaDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeEvalSHQaDO)dos[i];
		}
		return result;
	}
	
	public void setPeEvalSHQaDO(PeEvalSHQaDO[] dos) {
		setChildren(PeEvalSHQaDO.class, dos);
	}
	public PeEvalSHRstDO[] getPeEvalSHRstDO() {
		IBaseDO[] dos = getChildren(PeEvalSHRstDO.class);
		if(dos==null) return null;
		PeEvalSHRstDO[] result=new PeEvalSHRstDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeEvalSHRstDO)dos[i];
		}
		return result;
	}
	
	public void setPeEvalSHRstDO(PeEvalSHRstDO[] dos) {
		setChildren(PeEvalSHRstDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PeevalsubhealthAggDODesc desc = new PeevalsubhealthAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeEvalSubhealthDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.pqn.peevalsubhealth.d.PeEvalSHQaDO")) {
             return new PeEvalSHQaDO();
         }
	    else if (clzName.equals("iih.pe.pqn.peevalsubhealth.d.PeEvalSHRstDO")) {
             return new PeEvalSHRstDO();
         }
         return null;
     }
}