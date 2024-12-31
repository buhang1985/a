package iih.bd.srv.ortpl.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.srv.ortpl.d.desc.SrvortplitemAggDODesc;



/**
 * 医嘱模板项目
 */
public class SrvortplitemAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public OrTplItmDO getParentDO() {
		return ((OrTplItmDO) super.getParentDO());
	}

	public void setParentDO(OrTplItmDO headDO) {
		setParent(headDO);
	}

	public OrTplItmDtDO[] getOrTplItmDtDO() {
		IBaseDO[] dos = getChildren(OrTplItmDtDO.class);
		if(dos==null) return null;
		OrTplItmDtDO[] result=new OrTplItmDtDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(OrTplItmDtDO)dos[i];
		}
		return result;
	}
	
	public void setOrTplItmDtDO(OrTplItmDtDO[] dos) {
		setChildren(OrTplItmDtDO.class, dos);
	}
	public OrTplItmSetDO[] getOrTplItmSetDO() {
		IBaseDO[] dos = getChildren(OrTplItmSetDO.class);
		if(dos==null) return null;
		OrTplItmSetDO[] result=new OrTplItmSetDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(OrTplItmSetDO)dos[i];
		}
		return result;
	}
	
	public void setOrTplItmSetDO(OrTplItmSetDO[] dos) {
		setChildren(OrTplItmSetDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		SrvortplitemAggDODesc desc = new SrvortplitemAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new OrTplItmDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.srv.ortpl.d.OrTplItmDtDO")) {
             return new OrTplItmDtDO();
         }
	    else if (clzName.equals("iih.bd.srv.ortpl.d.OrTplItmSetDO")) {
             return new OrTplItmSetDO();
         }
         return null;
     }
}