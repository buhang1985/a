package iih.pe.pbd.qrycond.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.pbd.qrycond.d.desc.QrycondAggDODesc;



/**
 * 查询条件
 */
public class QrycondAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public QryCondDO getParentDO() {
		return ((QryCondDO) super.getParentDO());
	}

	public void setParentDO(QryCondDO headDO) {
		setParent(headDO);
	}

	public QryCondItmDO[] getQryCondItmDO() {
		IBaseDO[] dos = getChildren(QryCondItmDO.class);
		if(dos==null) return null;
		QryCondItmDO[] result=new QryCondItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(QryCondItmDO)dos[i];
		}
		return result;
	}
	
	public void setQryCondItmDO(QryCondItmDO[] dos) {
		setChildren(QryCondItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		QrycondAggDODesc desc = new QrycondAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new QryCondDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.pbd.qrycond.d.QryCondItmDO")) {
             return new QryCondItmDO();
         }
         return null;
     }
}