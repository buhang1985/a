package iih.bl.st.blstproxyhp.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bl.st.blstproxyhp.d.desc.BlstproxyhpAggDODesc;



/**
 * 代报结算_门急诊转住院
 */
public class BlstproxyhpAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public BlStProxyhpDO getParentDO() {
		return ((BlStProxyhpDO) super.getParentDO());
	}

	public void setParentDO(BlStProxyhpDO headDO) {
		setParent(headDO);
	}

	public BlStProxyhpItmDO[] getBlStProxyhpItmDO() {
		IBaseDO[] dos = getChildren(BlStProxyhpItmDO.class);
		if(dos==null) return null;
		BlStProxyhpItmDO[] result=new BlStProxyhpItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(BlStProxyhpItmDO)dos[i];
		}
		return result;
	}
	
	public void setBlStProxyhpItmDO(BlStProxyhpItmDO[] dos) {
		setChildren(BlStProxyhpItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		BlstproxyhpAggDODesc desc = new BlstproxyhpAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new BlStProxyhpDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bl.st.blstproxyhp.d.BlStProxyhpItmDO")) {
             return new BlStProxyhpItmDO();
         }
         return null;
     }
}