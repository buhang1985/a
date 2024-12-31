package iih.bd.srv.mrfpbltype.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.srv.mrfpbltype.d.desc.MrfpbltypeAggDODesc;



/**
 * 病案首页费用分类
 */
public class MrfpbltypeAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public MrFpBlTypeDO getParentDO() {
		return ((MrFpBlTypeDO) super.getParentDO());
	}

	public void setParentDO(MrFpBlTypeDO headDO) {
		setParent(headDO);
	}

	public MrFpBlTypeProDO[] getMrFpBlTypeProDO() {
		IBaseDO[] dos = getChildren(MrFpBlTypeProDO.class);
		if(dos==null) return null;
		MrFpBlTypeProDO[] result=new MrFpBlTypeProDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(MrFpBlTypeProDO)dos[i];
		}
		return result;
	}
	
	public void setMrFpBlTypeProDO(MrFpBlTypeProDO[] dos) {
		setChildren(MrFpBlTypeProDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		MrfpbltypeAggDODesc desc = new MrfpbltypeAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new MrFpBlTypeDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.srv.mrfpbltype.d.MrFpBlTypeProDO")) {
             return new MrFpBlTypeProDO();
         }
         return null;
     }
}