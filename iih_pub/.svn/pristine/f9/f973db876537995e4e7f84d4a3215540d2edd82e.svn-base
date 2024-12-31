package iih.mc.pl.deprequestap.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.mc.pl.deprequestap.d.desc.DeprequestapAggDODesc;



/**
 * 部门领用申请单
 */
public class DeprequestapAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public McDepReqApOrderDO getParentDO() {
		return ((McDepReqApOrderDO) super.getParentDO());
	}

	public void setParentDO(McDepReqApOrderDO headDO) {
		setParent(headDO);
	}

	public McDepReqApItemDO[] getMcDepReqApItemDO() {
		IBaseDO[] dos = getChildren(McDepReqApItemDO.class);
		if(dos==null) return null;
		McDepReqApItemDO[] result=new McDepReqApItemDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(McDepReqApItemDO)dos[i];
		}
		return result;
	}
	
	public void setMcDepReqApItemDO(McDepReqApItemDO[] dos) {
		setChildren(McDepReqApItemDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		DeprequestapAggDODesc desc = new DeprequestapAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new McDepReqApOrderDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.mc.pl.deprequestap.d.McDepReqApItemDO")) {
             return new McDepReqApItemDO();
         }
         return null;
     }
}