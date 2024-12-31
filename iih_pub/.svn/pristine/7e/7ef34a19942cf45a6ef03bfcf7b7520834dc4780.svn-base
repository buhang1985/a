package iih.bd.srv.emrimg.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.srv.emrimg.d.desc.EmrimgAggDODesc;



/**
 * 医疗记录图片库管理
 */
public class EmrimgAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public EmrImageDO getParentDO() {
		return ((EmrImageDO) super.getParentDO());
	}

	public void setParentDO(EmrImageDO headDO) {
		setParent(headDO);
	}

	public EmrImgAliasDO[] getEmrImgAliasDO() {
		IBaseDO[] dos = getChildren(EmrImgAliasDO.class);
		if(dos==null) return null;
		EmrImgAliasDO[] result=new EmrImgAliasDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(EmrImgAliasDO)dos[i];
		}
		return result;
	}
	
	public void setEmrImgAliasDO(EmrImgAliasDO[] dos) {
		setChildren(EmrImgAliasDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		EmrimgAggDODesc desc = new EmrimgAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new EmrImageDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.srv.emrimg.d.EmrImgAliasDO")) {
             return new EmrImgAliasDO();
         }
         return null;
     }
}