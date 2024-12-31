package iih.ci.mr.nu.pipeslip.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mr.nu.pipeslip.d.desc.PipeslipAggDODesc;



/**
 * 管道滑脱危险因素评估
 */
public class PipeslipAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PipeSlipDO getParentDO() {
		return ((PipeSlipDO) super.getParentDO());
	}

	public void setParentDO(PipeSlipDO headDO) {
		setParent(headDO);
	}

	public PipeSlipCritDO[] getPipeSlipCritDO() {
		IBaseDO[] dos = getChildren(PipeSlipCritDO.class);
		if(dos==null) return null;
		PipeSlipCritDO[] result=new PipeSlipCritDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PipeSlipCritDO)dos[i];
		}
		return result;
	}
	
	public void setPipeSlipCritDO(PipeSlipCritDO[] dos) {
		setChildren(PipeSlipCritDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PipeslipAggDODesc desc = new PipeslipAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PipeSlipDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mr.nu.pipeslip.d.PipeSlipCritDO")) {
             return new PipeSlipCritDO();
         }
         return null;
     }
}