package iih.syn.common.unittrg.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.syn.common.unittrg.d.desc.UnittrgAggDODesc;



/**
 * 数据同步目标
 */
public class UnittrgAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public SynUnitTrgDO getParentDO() {
		return ((SynUnitTrgDO) super.getParentDO());
	}

	public void setParentDO(SynUnitTrgDO headDO) {
		setParent(headDO);
	}

	public SynUnitTrgMapDO[] getSynUnitTrgMapDO() {
		IBaseDO[] dos = getChildren(SynUnitTrgMapDO.class);
		if(dos==null) return null;
		SynUnitTrgMapDO[] result=new SynUnitTrgMapDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(SynUnitTrgMapDO)dos[i];
		}
		return result;
	}
	
	public void setSynUnitTrgMapDO(SynUnitTrgMapDO[] dos) {
		setChildren(SynUnitTrgMapDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		UnittrgAggDODesc desc = new UnittrgAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new SynUnitTrgDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.syn.common.unittrg.d.SynUnitTrgMapDO")) {
             return new SynUnitTrgMapDO();
         }
         return null;
     }
}