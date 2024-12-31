package iih.bd.srv.ortpl.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.srv.ortpl.d.desc.OrtmplAggDODesc;



/**
 * 医嘱模板
 */
public class OrtmplAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public OrTmplDO getParentDO() {
		return ((OrTmplDO) super.getParentDO());
	}

	public void setParentDO(OrTmplDO headDO) {
		setParent(headDO);
	}

	public OrTplNItmDO[] getOrTplNItmDO() {
		IBaseDO[] dos = getChildren(OrTplNItmDO.class);
		if(dos==null) return null;
		OrTplNItmDO[] result=new OrTplNItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(OrTplNItmDO)dos[i];
		}
		return result;
	}
	
	public void setOrTplNItmDO(OrTplNItmDO[] dos) {
		setChildren(OrTplNItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		OrtmplAggDODesc desc = new OrtmplAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new OrTmplDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.srv.ortpl.d.OrTplNItmDO")) {
             return new OrTplNItmDO();
         }
         return null;
     }
}