package iih.nm.nom.nmnomwbkconfig.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nm.nom.nmnomwbkconfig.d.desc.NmnomwbkconfigAggDODesc;



/**
 * 护士长手册配置
 */
public class NmnomwbkconfigAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NmNomWbkConfigDO getParentDO() {
		return ((NmNomWbkConfigDO) super.getParentDO());
	}

	public void setParentDO(NmNomWbkConfigDO headDO) {
		setParent(headDO);
	}

	public NmNomWbkDepDO[] getNmNomWbkDepDO() {
		IBaseDO[] dos = getChildren(NmNomWbkDepDO.class);
		if(dos==null) return null;
		NmNomWbkDepDO[] result=new NmNomWbkDepDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NmNomWbkDepDO)dos[i];
		}
		return result;
	}
	
	public void setNmNomWbkDepDO(NmNomWbkDepDO[] dos) {
		setChildren(NmNomWbkDepDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		NmnomwbkconfigAggDODesc desc = new NmnomwbkconfigAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NmNomWbkConfigDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nm.nom.nmnomwbkconfig.d.NmNomWbkDepDO")) {
             return new NmNomWbkDepDO();
         }
         return null;
     }
}