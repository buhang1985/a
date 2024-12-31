package iih.bd.pp.hp.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hp.d.HpDiDO;
import iih.bd.pp.hp.d.desc.HpDiDODesc;
import iih.bd.pp.hp.d.HPPropDO;
import iih.bd.pp.hp.d.desc.HPPropDODesc;
import iih.bd.pp.hp.d.HPSegDO;
import iih.bd.pp.hp.d.desc.HPSegDODesc;
import iih.bd.pp.hp.d.HpDepDO;
import iih.bd.pp.hp.d.desc.HpDepDODesc;
import iih.bd.pp.hp.d.HpDosageDO;
import iih.bd.pp.hp.d.desc.HpDosageDODesc;
import iih.bd.pp.hp.d.HpFreqDO;
import iih.bd.pp.hp.d.desc.HpFreqDODesc;
import iih.bd.pp.hp.d.BdHpLimitPsdDO;
import iih.bd.pp.hp.d.desc.BdHpLimitPsdDODesc;
import iih.bd.pp.hp.d.BdHpPrestpDO;
import iih.bd.pp.hp.d.desc.BdHpPrestpDODesc;
import iih.bd.pp.hp.d.BdHpUnlimitDrugDO;
import iih.bd.pp.hp.d.desc.BdHpUnlimitDrugDODesc;
import iih.bd.pp.hp.d.BdHpKindDO;
import iih.bd.pp.hp.d.desc.BdHpKindDODesc;
import iih.bd.pp.hp.d.BdHpPatcaDO;
import iih.bd.pp.hp.d.desc.BdHpPatcaDODesc;
import iih.bd.pp.hp.d.BdHpOrgDO;
import iih.bd.pp.hp.d.desc.BdHpOrgDODesc;
import iih.bd.pp.hp.d.BdHpCtrDO;
import iih.bd.pp.hp.d.desc.BdHpCtrDODesc;

/**
 * 医保计划
 * @author
 *
 */
public class HpAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public HpAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(HPDO.class);
        addChildren(HpDiDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(HpDiDODesc.class).getFKAttrDesc());        
        addChildren(HPPropDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(HPPropDODesc.class).getFKAttrDesc());        
        addChildren(HPSegDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(HPSegDODesc.class).getFKAttrDesc());        
        addChildren(HpDepDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(HpDepDODesc.class).getFKAttrDesc());        
        addChildren(HpDosageDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(HpDosageDODesc.class).getFKAttrDesc());        
        addChildren(HpFreqDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(HpFreqDODesc.class).getFKAttrDesc());        
        addChildren(BdHpLimitPsdDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(BdHpLimitPsdDODesc.class).getFKAttrDesc());        
        addChildren(BdHpPrestpDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(BdHpPrestpDODesc.class).getFKAttrDesc());        
        addChildren(BdHpUnlimitDrugDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(BdHpUnlimitDrugDODesc.class).getFKAttrDesc());        
        addChildren(BdHpKindDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(BdHpKindDODesc.class).getFKAttrDesc());        
        addChildren(BdHpPatcaDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(BdHpPatcaDODesc.class).getFKAttrDesc());        
        addChildren(BdHpOrgDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(BdHpOrgDODesc.class).getFKAttrDesc());        
        addChildren(BdHpCtrDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(BdHpCtrDODesc.class).getFKAttrDesc());        
	  }	  
}