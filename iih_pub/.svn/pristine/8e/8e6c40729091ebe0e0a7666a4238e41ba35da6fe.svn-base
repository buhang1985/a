package iih.nm.nqm.nqmchkitm.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nm.nqm.nqmchkitm.d.desc.NqmchkitmAggDODesc;



/**
 * 护理管理_评分项目
 */
public class NqmchkitmAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NmNqmChkitmcaDo getParentDO() {
		return ((NmNqmChkitmcaDo) super.getParentDO());
	}

	public void setParentDO(NmNqmChkitmcaDo headDO) {
		setParent(headDO);
	}

	public NmNqmChkitmDo[] getNmNqmChkitmDo() {
		IBaseDO[] dos = getChildren(NmNqmChkitmDo.class);
		if(dos==null) return null;
		NmNqmChkitmDo[] result=new NmNqmChkitmDo[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NmNqmChkitmDo)dos[i];
		}
		return result;
	}
	
	public void setNmNqmChkitmDo(NmNqmChkitmDo[] dos) {
		setChildren(NmNqmChkitmDo.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		NqmchkitmAggDODesc desc = new NqmchkitmAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NmNqmChkitmcaDo();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nm.nqm.nqmchkitm.d.NmNqmChkitmDo")) {
             return new NmNqmChkitmDo();
         }
         return null;
     }
}