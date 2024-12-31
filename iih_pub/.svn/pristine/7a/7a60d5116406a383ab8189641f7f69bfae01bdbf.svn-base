package iih.bd.srv.qcconreject.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.srv.qcconreject.d.desc.QcconrejectAggDODesc;



/**
 * 组件
 */
public class QcconrejectAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public QcconrejectDO getParentDO() {
		return ((QcconrejectDO) super.getParentDO());
	}

	public void setParentDO(QcconrejectDO headDO) {
		setParent(headDO);
	}

	public QcconrejectconDO[] getQcconrejectconDO() {
		IBaseDO[] dos = getChildren(QcconrejectconDO.class);
		if(dos==null) return null;
		QcconrejectconDO[] result=new QcconrejectconDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(QcconrejectconDO)dos[i];
		}
		return result;
	}
	
	public void setQcconrejectconDO(QcconrejectconDO[] dos) {
		setChildren(QcconrejectconDO.class, dos);
	}
	public QcconrejectitemDO[] getQcconrejectitemDO() {
		IBaseDO[] dos = getChildren(QcconrejectitemDO.class);
		if(dos==null) return null;
		QcconrejectitemDO[] result=new QcconrejectitemDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(QcconrejectitemDO)dos[i];
		}
		return result;
	}
	
	public void setQcconrejectitemDO(QcconrejectitemDO[] dos) {
		setChildren(QcconrejectitemDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		QcconrejectAggDODesc desc = new QcconrejectAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new QcconrejectDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.srv.qcconreject.d.QcconrejectconDO")) {
             return new QcconrejectconDO();
         }
	    else if (clzName.equals("iih.bd.srv.qcconreject.d.QcconrejectitemDO")) {
             return new QcconrejectitemDO();
         }
         return null;
     }
}