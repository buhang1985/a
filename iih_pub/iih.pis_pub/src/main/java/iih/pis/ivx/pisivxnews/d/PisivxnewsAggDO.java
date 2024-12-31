package iih.pis.ivx.pisivxnews.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pis.ivx.pisivxnews.d.desc.PisivxnewsAggDODesc;



/**
 * 微信服务-新闻服务
 */
public class PisivxnewsAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PisivxNewsDO getParentDO() {
		return ((PisivxNewsDO) super.getParentDO());
	}

	public void setParentDO(PisivxNewsDO headDO) {
		setParent(headDO);
	}

	public PisivxArticleDO[] getPisivxArticleDO() {
		IBaseDO[] dos = getChildren(PisivxArticleDO.class);
		if(dos==null) return null;
		PisivxArticleDO[] result=new PisivxArticleDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PisivxArticleDO)dos[i];
		}
		return result;
	}
	
	public void setPisivxArticleDO(PisivxArticleDO[] dos) {
		setChildren(PisivxArticleDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PisivxnewsAggDODesc desc = new PisivxnewsAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PisivxNewsDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pis.ivx.pisivxnews.d.PisivxArticleDO")) {
             return new PisivxArticleDO();
         }
         return null;
     }
}