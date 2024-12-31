package iih.pe.phm.perstsurvery.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.phm.perstsurvery.d.desc.PerstsurveryAggDODesc;



/**
 * 体检问卷结果
 */
public class PerstsurveryAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeRstSurveryDO getParentDO() {
		return ((PeRstSurveryDO) super.getParentDO());
	}

	public void setParentDO(PeRstSurveryDO headDO) {
		setParent(headDO);
	}

	public PeRstSurveryKeyDO[] getPeRstSurveryKeyDO() {
		IBaseDO[] dos = getChildren(PeRstSurveryKeyDO.class);
		if(dos==null) return null;
		PeRstSurveryKeyDO[] result=new PeRstSurveryKeyDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeRstSurveryKeyDO)dos[i];
		}
		return result;
	}
	
	public void setPeRstSurveryKeyDO(PeRstSurveryKeyDO[] dos) {
		setChildren(PeRstSurveryKeyDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PerstsurveryAggDODesc desc = new PerstsurveryAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeRstSurveryDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.phm.perstsurvery.d.PeRstSurveryKeyDO")) {
             return new PeRstSurveryKeyDO();
         }
         return null;
     }
}