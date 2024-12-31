package iih.bd.srv.emrterm.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.srv.emrterm.d.desc.EmrnormwordAggDODesc;



/**
 * 病历常用词分类
 */
public class EmrnormwordAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public EmrNormWordCaDO getParentDO() {
		return ((EmrNormWordCaDO) super.getParentDO());
	}

	public void setParentDO(EmrNormWordCaDO headDO) {
		setParent(headDO);
	}

	public EmrNormWordDO[] getEmrNormWordDO() {
		IBaseDO[] dos = getChildren(EmrNormWordDO.class);
		if(dos==null) return null;
		EmrNormWordDO[] result=new EmrNormWordDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(EmrNormWordDO)dos[i];
		}
		return result;
	}
	
	public void setEmrNormWordDO(EmrNormWordDO[] dos) {
		setChildren(EmrNormWordDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		EmrnormwordAggDODesc desc = new EmrnormwordAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new EmrNormWordCaDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.srv.emrterm.d.EmrNormWordDO")) {
             return new EmrNormWordDO();
         }
         return null;
     }
}