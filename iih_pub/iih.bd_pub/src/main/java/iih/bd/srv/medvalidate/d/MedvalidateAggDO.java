package iih.bd.srv.medvalidate.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.srv.medvalidate.d.desc.MedvalidateAggDODesc;



/**
 * 基础数据服务校验
 */
public class MedvalidateAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public BDErrorInfoDO getParentDO() {
		return ((BDErrorInfoDO) super.getParentDO());
	}

	public void setParentDO(BDErrorInfoDO headDO) {
		setParent(headDO);
	}

	public BDErrorInfoItemDO[] getBDErrorInfoItemDO() {
		IBaseDO[] dos = getChildren(BDErrorInfoItemDO.class);
		if(dos==null) return null;
		BDErrorInfoItemDO[] result=new BDErrorInfoItemDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(BDErrorInfoItemDO)dos[i];
		}
		return result;
	}
	
	public void setBDErrorInfoItemDO(BDErrorInfoItemDO[] dos) {
		setChildren(BDErrorInfoItemDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		MedvalidateAggDODesc desc = new MedvalidateAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new BDErrorInfoDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.srv.medvalidate.d.BDErrorInfoItemDO")) {
             return new BDErrorInfoItemDO();
         }
         return null;
     }
}