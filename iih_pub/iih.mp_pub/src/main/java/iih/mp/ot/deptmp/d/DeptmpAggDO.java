package iih.mp.ot.deptmp.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.mp.ot.deptmp.d.desc.DeptmpAggDODesc;



/**
 * 通用医技科室模板
 */
public class DeptmpAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public MpOrPrTmpDO getParentDO() {
		return ((MpOrPrTmpDO) super.getParentDO());
	}

	public void setParentDO(MpOrPrTmpDO headDO) {
		setParent(headDO);
	}

	public MpOrPrTmpDtDO[] getMpOrPrTmpDtDO() {
		IBaseDO[] dos = getChildren(MpOrPrTmpDtDO.class);
		if(dos==null) return null;
		MpOrPrTmpDtDO[] result=new MpOrPrTmpDtDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(MpOrPrTmpDtDO)dos[i];
		}
		return result;
	}
	
	public void setMpOrPrTmpDtDO(MpOrPrTmpDtDO[] dos) {
		setChildren(MpOrPrTmpDtDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		DeptmpAggDODesc desc = new DeptmpAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new MpOrPrTmpDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.mp.ot.deptmp.d.MpOrPrTmpDtDO")) {
             return new MpOrPrTmpDtDO();
         }
         return null;
     }
}