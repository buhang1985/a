package iih.nm.nqm.qctplapp.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nm.nqm.qctplapp.d.desc.QctplappAggDODesc;



/**
 * 质量控制应用
 */
public class QctplappAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public QctplAppDO getParentDO() {
		return ((QctplAppDO) super.getParentDO());
	}

	public void setParentDO(QctplAppDO headDO) {
		setParent(headDO);
	}

	public QctplAppEleDO[] getQctplAppEleDO() {
		IBaseDO[] dos = getChildren(QctplAppEleDO.class);
		if(dos==null) return null;
		QctplAppEleDO[] result=new QctplAppEleDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(QctplAppEleDO)dos[i];
		}
		return result;
	}
	
	public void setQctplAppEleDO(QctplAppEleDO[] dos) {
		setChildren(QctplAppEleDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		QctplappAggDODesc desc = new QctplappAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new QctplAppDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nm.nqm.qctplapp.d.QctplAppEleDO")) {
             return new QctplAppEleDO();
         }
         return null;
     }
}