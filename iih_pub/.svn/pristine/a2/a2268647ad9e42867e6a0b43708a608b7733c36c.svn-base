package iih.hp.cp.sdele.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.hp.cp.sdele.d.desc.HpcpsdeleAggDODesc;



/**
 * 诊疗计划标准元素
 */
public class HpcpsdeleAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public HpCpSdElemDO getParentDO() {
		return ((HpCpSdElemDO) super.getParentDO());
	}

	public void setParentDO(HpCpSdElemDO headDO) {
		setParent(headDO);
	}

	public HpCpSdElemRulePkgDO[] getHpCpSdElemRulePkgDO() {
		IBaseDO[] dos = getChildren(HpCpSdElemRulePkgDO.class);
		if(dos==null) return null;
		HpCpSdElemRulePkgDO[] result=new HpCpSdElemRulePkgDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(HpCpSdElemRulePkgDO)dos[i];
		}
		return result;
	}
	
	public void setHpCpSdElemRulePkgDO(HpCpSdElemRulePkgDO[] dos) {
		setChildren(HpCpSdElemRulePkgDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		HpcpsdeleAggDODesc desc = new HpcpsdeleAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new HpCpSdElemDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.hp.cp.sdele.d.HpCpSdElemRulePkgDO")) {
             return new HpCpSdElemRulePkgDO();
         }
         return null;
     }
}