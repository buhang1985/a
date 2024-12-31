package iih.bd.fc.orpltpmatch.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.fc.orpltpmatch.d.desc.OrpltpmatchAggDODesc;



/**
 * 医嘱闭环匹配
 */
public class OrpltpmatchAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public OrpltpMatchDO getParentDO() {
		return ((OrpltpMatchDO) super.getParentDO());
	}

	public void setParentDO(OrpltpMatchDO headDO) {
		setParent(headDO);
	}

	public OrpltpMatchAttrDO[] getOrpltpMatchAttrDO() {
		IBaseDO[] dos = getChildren(OrpltpMatchAttrDO.class);
		if(dos==null) return null;
		OrpltpMatchAttrDO[] result=new OrpltpMatchAttrDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(OrpltpMatchAttrDO)dos[i];
		}
		return result;
	}
	
	public void setOrpltpMatchAttrDO(OrpltpMatchAttrDO[] dos) {
		setChildren(OrpltpMatchAttrDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		OrpltpmatchAggDODesc desc = new OrpltpmatchAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new OrpltpMatchDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.fc.orpltpmatch.d.OrpltpMatchAttrDO")) {
             return new OrpltpMatchAttrDO();
         }
         return null;
     }
}