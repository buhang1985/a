package iih.bd.srv.cherbboilmd.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.srv.cherbboilmd.d.desc.CherbboilmdAggDODesc;



/**
 * 医疗服务中药煎法
 */
public class CherbboilmdAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public CHerbBoilMdDO getParentDO() {
		return ((CHerbBoilMdDO) super.getParentDO());
	}

	public void setParentDO(CHerbBoilMdDO headDO) {
		setParent(headDO);
	}

	public CHerbBoilDesDO[] getCHerbBoilDesDO() {
		IBaseDO[] dos = getChildren(CHerbBoilDesDO.class);
		if(dos==null) return null;
		CHerbBoilDesDO[] result=new CHerbBoilDesDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(CHerbBoilDesDO)dos[i];
		}
		return result;
	}
	
	public void setCHerbBoilDesDO(CHerbBoilDesDO[] dos) {
		setChildren(CHerbBoilDesDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		CherbboilmdAggDODesc desc = new CherbboilmdAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new CHerbBoilMdDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.srv.cherbboilmd.d.CHerbBoilDesDO")) {
             return new CHerbBoilDesDO();
         }
         return null;
     }
}