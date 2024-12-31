package iih.ci.mr.nu.babybirrecord.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mr.nu.babybirrecord.d.desc.BabybirrecordAggDODesc;



/**
 * 婴儿产时记录
 */
public class BabybirrecordAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public BabyBirInfoDO getParentDO() {
		return ((BabyBirInfoDO) super.getParentDO());
	}

	public void setParentDO(BabyBirInfoDO headDO) {
		setParent(headDO);
	}

	public BabyBirRecordDO[] getBabyBirRecordDO() {
		IBaseDO[] dos = getChildren(BabyBirRecordDO.class);
		if(dos==null) return null;
		BabyBirRecordDO[] result=new BabyBirRecordDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(BabyBirRecordDO)dos[i];
		}
		return result;
	}
	
	public void setBabyBirRecordDO(BabyBirRecordDO[] dos) {
		setChildren(BabyBirRecordDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		BabybirrecordAggDODesc desc = new BabybirrecordAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new BabyBirInfoDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mr.nu.babybirrecord.d.BabyBirRecordDO")) {
             return new BabyBirRecordDO();
         }
         return null;
     }
}