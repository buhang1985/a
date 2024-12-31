package iih.bd.srv.qcmraddrule.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.srv.qcmraddrule.d.desc.QcmraddruleAggDODesc;



/**
 * 组件
 */
public class QcmraddruleAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public QcmraddruleDO getParentDO() {
		return ((QcmraddruleDO) super.getParentDO());
	}

	public void setParentDO(QcmraddruleDO headDO) {
		setParent(headDO);
	}

	public QcmraddpreruleDO[] getQcmraddpreruleDO() {
		IBaseDO[] dos = getChildren(QcmraddpreruleDO.class);
		if(dos==null) return null;
		QcmraddpreruleDO[] result=new QcmraddpreruleDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(QcmraddpreruleDO)dos[i];
		}
		return result;
	}
	
	public void setQcmraddpreruleDO(QcmraddpreruleDO[] dos) {
		setChildren(QcmraddpreruleDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		QcmraddruleAggDODesc desc = new QcmraddruleAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new QcmraddruleDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.srv.qcmraddrule.d.QcmraddpreruleDO")) {
             return new QcmraddpreruleDO();
         }
         return null;
     }
}