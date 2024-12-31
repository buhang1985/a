package iih.bd.srv.mrmtype.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.srv.mrmtype.d.desc.MrmtypeAggDODesc;



/**
 * 病案分类
 */
public class MrmtypeAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public MrmTypeDO getParentDO() {
		return ((MrmTypeDO) super.getParentDO());
	}

	public void setParentDO(MrmTypeDO headDO) {
		setParent(headDO);
	}

	public MrmTypeMrtpDO[] getMrmTypeMrtpDO() {
		IBaseDO[] dos = getChildren(MrmTypeMrtpDO.class);
		if(dos==null) return null;
		MrmTypeMrtpDO[] result=new MrmTypeMrtpDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(MrmTypeMrtpDO)dos[i];
		}
		return result;
	}
	
	public void setMrmTypeMrtpDO(MrmTypeMrtpDO[] dos) {
		setChildren(MrmTypeMrtpDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		MrmtypeAggDODesc desc = new MrmtypeAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new MrmTypeDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.srv.mrmtype.d.MrmTypeMrtpDO")) {
             return new MrmTypeMrtpDO();
         }
         return null;
     }
}