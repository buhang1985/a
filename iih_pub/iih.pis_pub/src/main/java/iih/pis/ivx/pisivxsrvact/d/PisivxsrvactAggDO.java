package iih.pis.ivx.pisivxsrvact.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pis.ivx.pisivxsrvact.d.desc.PisivxsrvactAggDODesc;



/**
 * 微信服务号
 */
public class PisivxsrvactAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PisIvxSrvactDO getParentDO() {
		return ((PisIvxSrvactDO) super.getParentDO());
	}

	public void setParentDO(PisIvxSrvactDO headDO) {
		setParent(headDO);
	}

	public PisivxTposappDO[] getPisivxTposappDO() {
		IBaseDO[] dos = getChildren(PisivxTposappDO.class);
		if(dos==null) return null;
		PisivxTposappDO[] result=new PisivxTposappDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PisivxTposappDO)dos[i];
		}
		return result;
	}
	
	public void setPisivxTposappDO(PisivxTposappDO[] dos) {
		setChildren(PisivxTposappDO.class, dos);
	}
	public PisIvxSrvactTagDO[] getPisIvxSrvactTagDO() {
		IBaseDO[] dos = getChildren(PisIvxSrvactTagDO.class);
		if(dos==null) return null;
		PisIvxSrvactTagDO[] result=new PisIvxSrvactTagDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PisIvxSrvactTagDO)dos[i];
		}
		return result;
	}
	
	public void setPisIvxSrvactTagDO(PisIvxSrvactTagDO[] dos) {
		setChildren(PisIvxSrvactTagDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PisivxsrvactAggDODesc desc = new PisivxsrvactAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PisIvxSrvactDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pis.ivx.pisivxsrvact.d.PisivxTposappDO")) {
             return new PisivxTposappDO();
         }
	    else if (clzName.equals("iih.pis.ivx.pisivxsrvact.d.PisIvxSrvactTagDO")) {
             return new PisIvxSrvactTagDO();
         }
         return null;
     }
}