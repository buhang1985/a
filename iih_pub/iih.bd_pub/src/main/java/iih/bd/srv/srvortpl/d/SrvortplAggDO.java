package iih.bd.srv.srvortpl.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.srv.srvortpl.d.desc.SrvortplAggDODesc;



/**
 * 医疗服务医嘱模板
 */
public class SrvortplAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public SrvOrdTplDO getParentDO() {
		return ((SrvOrdTplDO) super.getParentDO());
	}

	public void setParentDO(SrvOrdTplDO headDO) {
		setParent(headDO);
	}

	public SrvOrTplDiDO[] getSrvOrTplDiDO() {
		IBaseDO[] dos = getChildren(SrvOrTplDiDO.class);
		if(dos==null) return null;
		SrvOrTplDiDO[] result=new SrvOrTplDiDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(SrvOrTplDiDO)dos[i];
		}
		return result;
	}
	
	public void setSrvOrTplDiDO(SrvOrTplDiDO[] dos) {
		setChildren(SrvOrTplDiDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		SrvortplAggDODesc desc = new SrvortplAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new SrvOrdTplDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.srv.srvortpl.d.SrvOrTplDiDO")) {
             return new SrvOrTplDiDO();
         }
         return null;
     }
}