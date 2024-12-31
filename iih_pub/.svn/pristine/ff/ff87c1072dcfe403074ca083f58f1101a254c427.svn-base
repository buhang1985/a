package iih.sc.scbd.schedulesrv.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.sc.scbd.schedulesrv.d.desc.ScsrvkinddoAggDODesc;



/**
 * 排班服务类别
 */
public class ScsrvkinddoAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public ScSrvKindDO getParentDO() {
		return ((ScSrvKindDO) super.getParentDO());
	}

	public void setParentDO(ScSrvKindDO headDO) {
		setParent(headDO);
	}

	public ScSrvKindItm[] getScSrvKindItm() {
		IBaseDO[] dos = getChildren(ScSrvKindItm.class);
		if(dos==null) return null;
		ScSrvKindItm[] result=new ScSrvKindItm[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(ScSrvKindItm)dos[i];
		}
		return result;
	}
	
	public void setScSrvKindItm(ScSrvKindItm[] dos) {
		setChildren(ScSrvKindItm.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		ScsrvkinddoAggDODesc desc = new ScsrvkinddoAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new ScSrvKindDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.sc.scbd.schedulesrv.d.ScSrvKindItm")) {
             return new ScSrvKindItm();
         }
         return null;
     }
}