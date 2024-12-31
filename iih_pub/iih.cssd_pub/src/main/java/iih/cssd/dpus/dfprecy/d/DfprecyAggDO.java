package iih.cssd.dpus.dfprecy.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.cssd.dpus.dfprecy.d.desc.DfprecyAggDODesc;



/**
 * 消毒包回收
 */
public class DfprecyAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public DfpRecyDo getParentDO() {
		return ((DfpRecyDo) super.getParentDO());
	}

	public void setParentDO(DfpRecyDo headDO) {
		setParent(headDO);
	}

	public DfpRecyItmDo[] getDfpRecyItmDo() {
		IBaseDO[] dos = getChildren(DfpRecyItmDo.class);
		if(dos==null) return null;
		DfpRecyItmDo[] result=new DfpRecyItmDo[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(DfpRecyItmDo)dos[i];
		}
		return result;
	}
	
	public void setDfpRecyItmDo(DfpRecyItmDo[] dos) {
		setChildren(DfpRecyItmDo.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		DfprecyAggDODesc desc = new DfprecyAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new DfpRecyDo();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.cssd.dpus.dfprecy.d.DfpRecyItmDo")) {
             return new DfpRecyItmDo();
         }
         return null;
     }
}