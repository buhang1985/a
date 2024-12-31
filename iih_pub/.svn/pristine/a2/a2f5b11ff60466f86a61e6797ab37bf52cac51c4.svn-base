package iih.nm.nhr.institutabatch.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nm.nhr.institutabatch.d.desc.InstitutabatchAggDODesc;



/**
 * 院校批次管理
 */
public class InstitutabatchAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NmStuOrgDO getParentDO() {
		return ((NmStuOrgDO) super.getParentDO());
	}

	public void setParentDO(NmStuOrgDO headDO) {
		setParent(headDO);
	}

	public NmBatchDO[] getNmBatchDO() {
		IBaseDO[] dos = getChildren(NmBatchDO.class);
		if(dos==null) return null;
		NmBatchDO[] result=new NmBatchDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NmBatchDO)dos[i];
		}
		return result;
	}
	
	public void setNmBatchDO(NmBatchDO[] dos) {
		setChildren(NmBatchDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		InstitutabatchAggDODesc desc = new InstitutabatchAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NmStuOrgDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nm.nhr.institutabatch.d.NmBatchDO")) {
             return new NmBatchDO();
         }
         return null;
     }
}