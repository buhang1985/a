package iih.bd.srv.srvselfcaitm.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.srv.srvselfcaitm.d.desc.SrvselfcaitmAggDODesc;



/**
 * 服务自定义分类项目
 */
public class SrvselfcaitmAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public SrvSelfCaItemDO getParentDO() {
		return ((SrvSelfCaItemDO) super.getParentDO());
	}

	public void setParentDO(SrvSelfCaItemDO headDO) {
		setParent(headDO);
	}

	public SrvSelfCaItmRelDO[] getSrvSelfCaItmRelDO() {
		IBaseDO[] dos = getChildren(SrvSelfCaItmRelDO.class);
		if(dos==null) return null;
		SrvSelfCaItmRelDO[] result=new SrvSelfCaItmRelDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(SrvSelfCaItmRelDO)dos[i];
		}
		return result;
	}
	
	public void setSrvSelfCaItmRelDO(SrvSelfCaItmRelDO[] dos) {
		setChildren(SrvSelfCaItmRelDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		SrvselfcaitmAggDODesc desc = new SrvselfcaitmAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new SrvSelfCaItemDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.srv.srvselfcaitm.d.SrvSelfCaItmRelDO")) {
             return new SrvSelfCaItmRelDO();
         }
         return null;
     }
}