package iih.ci.mrqc.randomcheck.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mrqc.randomcheck.d.desc.MrqcrandomcheckAggDODesc;



/**
 * 门诊病历抽查
 */
public class MrqcrandomcheckAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public CiMrQcRandomRecordDO getParentDO() {
		return ((CiMrQcRandomRecordDO) super.getParentDO());
	}

	public void setParentDO(CiMrQcRandomRecordDO headDO) {
		setParent(headDO);
	}

	public CiMrQcRandomRecordItmDO[] getCiMrQcRandomRecordItmDO() {
		IBaseDO[] dos = getChildren(CiMrQcRandomRecordItmDO.class);
		if(dos==null) return null;
		CiMrQcRandomRecordItmDO[] result=new CiMrQcRandomRecordItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(CiMrQcRandomRecordItmDO)dos[i];
		}
		return result;
	}
	
	public void setCiMrQcRandomRecordItmDO(CiMrQcRandomRecordItmDO[] dos) {
		setChildren(CiMrQcRandomRecordItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		MrqcrandomcheckAggDODesc desc = new MrqcrandomcheckAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new CiMrQcRandomRecordDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mrqc.randomcheck.d.CiMrQcRandomRecordItmDO")) {
             return new CiMrQcRandomRecordItmDO();
         }
         return null;
     }
}