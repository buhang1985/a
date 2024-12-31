package iih.nm.nom.nomwkitmapp.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nm.nom.nomwkitmapp.d.desc.NomwkitmappAggDODesc;



/**
 * 护理工作项目数据录入
 */
public class NomwkitmappAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NomWkitmAppDO getParentDO() {
		return ((NomWkitmAppDO) super.getParentDO());
	}

	public void setParentDO(NomWkitmAppDO headDO) {
		setParent(headDO);
	}

	public NomWkitmAppItmDO[] getNomWkitmAppItmDO() {
		IBaseDO[] dos = getChildren(NomWkitmAppItmDO.class);
		if(dos==null) return null;
		NomWkitmAppItmDO[] result=new NomWkitmAppItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NomWkitmAppItmDO)dos[i];
		}
		return result;
	}
	
	public void setNomWkitmAppItmDO(NomWkitmAppItmDO[] dos) {
		setChildren(NomWkitmAppItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		NomwkitmappAggDODesc desc = new NomwkitmappAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NomWkitmAppDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nm.nom.nomwkitmapp.d.NomWkitmAppItmDO")) {
             return new NomWkitmAppItmDO();
         }
         return null;
     }
}