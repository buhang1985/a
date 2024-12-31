package iih.cssd.dpus.dfpuse.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.cssd.dpus.dfpuse.d.desc.DfpuseAggDODesc;



/**
 * 消毒包使用
 */
public class DfpuseAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public DfpUseDo getParentDO() {
		return ((DfpUseDo) super.getParentDO());
	}

	public void setParentDO(DfpUseDo headDO) {
		setParent(headDO);
	}

	public DfpUseItmDo[] getDfpUseItmDo() {
		IBaseDO[] dos = getChildren(DfpUseItmDo.class);
		if(dos==null) return null;
		DfpUseItmDo[] result=new DfpUseItmDo[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(DfpUseItmDo)dos[i];
		}
		return result;
	}
	
	public void setDfpUseItmDo(DfpUseItmDo[] dos) {
		setChildren(DfpUseItmDo.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		DfpuseAggDODesc desc = new DfpuseAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new DfpUseDo();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.cssd.dpus.dfpuse.d.DfpUseItmDo")) {
             return new DfpUseItmDo();
         }
         return null;
     }
}