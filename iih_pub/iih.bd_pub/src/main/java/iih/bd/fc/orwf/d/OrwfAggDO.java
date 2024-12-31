package iih.bd.fc.orwf.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.fc.orwf.d.desc.OrwfAggDODesc;



/**
 * 医嘱流向
 */
public class OrwfAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public OrWfCfgDO getParentDO() {
		return ((OrWfCfgDO) super.getParentDO());
	}

	public void setParentDO(OrWfCfgDO headDO) {
		setParent(headDO);
	}

	public WfCfgAttrDO[] getWfCfgAttrDO() {
		IBaseDO[] dos = getChildren(WfCfgAttrDO.class);
		if(dos==null) return null;
		WfCfgAttrDO[] result=new WfCfgAttrDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(WfCfgAttrDO)dos[i];
		}
		return result;
	}
	
	public void setWfCfgAttrDO(WfCfgAttrDO[] dos) {
		setChildren(WfCfgAttrDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		OrwfAggDODesc desc = new OrwfAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new OrWfCfgDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.fc.orwf.d.WfCfgAttrDO")) {
             return new WfCfgAttrDO();
         }
         return null;
     }
}