package iih.bd.fc.orpltp.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.fc.orpltp.d.desc.OrpltpAggDODesc;



/**
 * 医嘱执行计划状态
 */
public class OrpltpAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public OrpltpDO getParentDO() {
		return ((OrpltpDO) super.getParentDO());
	}

	public void setParentDO(OrpltpDO headDO) {
		setParent(headDO);
	}

	public OrpltpStaDO[] getOrpltpStaDO() {
		IBaseDO[] dos = getChildren(OrpltpStaDO.class);
		if(dos==null) return null;
		OrpltpStaDO[] result=new OrpltpStaDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(OrpltpStaDO)dos[i];
		}
		return result;
	}
	
	public void setOrpltpStaDO(OrpltpStaDO[] dos) {
		setChildren(OrpltpStaDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		OrpltpAggDODesc desc = new OrpltpAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new OrpltpDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.fc.orpltp.d.OrpltpStaDO")) {
             return new OrpltpStaDO();
         }
         return null;
     }
}