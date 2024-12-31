package iih.hp.cp.ele.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.hp.cp.ele.d.HpCpElemDO;
import iih.hp.cp.ele.d.HpCpElemMatchDO;
import iih.hp.cp.ele.d.desc.HpCpElemMatchDODesc;
import iih.hp.cp.ele.d.HpCpElemRulePkgDO;
import iih.hp.cp.ele.d.desc.HpCpElemRulePkgDODesc;
import iih.hp.cp.ele.d.HpCpElemDiagRuleDO;
import iih.hp.cp.ele.d.desc.HpCpElemDiagRuleDODesc;
import iih.hp.cp.ele.d.HpCpElemIndexDO;
import iih.hp.cp.ele.d.desc.HpCpElemIndexDODesc;
import iih.hp.cp.ele.d.HpCpElemSugRuleDO;
import iih.hp.cp.ele.d.desc.HpCpElemSugRuleDODesc;
import iih.hp.cp.ele.d.HpCpElemBoundaryDO;
import iih.hp.cp.ele.d.desc.HpCpElemBoundaryDODesc;
import iih.hp.cp.ele.d.HpCpElemStageDO;
import iih.hp.cp.ele.d.desc.HpCpElemStageDODesc;
import iih.hp.cp.ele.d.HpCpElemTextDO;
import iih.hp.cp.ele.d.desc.HpCpElemTextDODesc;
import iih.hp.cp.ele.d.HpCpElemOrderPkgDO;
import iih.hp.cp.ele.d.desc.HpCpElemOrderPkgDODesc;
import iih.hp.cp.ele.d.HpCpElemOrderDO;
import iih.hp.cp.ele.d.desc.HpCpElemOrderDODesc;
import iih.hp.cp.ele.d.HpCpElemMedRecordDO;
import iih.hp.cp.ele.d.desc.HpCpElemMedRecordDODesc;
import iih.hp.cp.ele.d.HpCpElemBioDO;
import iih.hp.cp.ele.d.desc.HpCpElemBioDODesc;
import iih.hp.cp.ele.d.HpCpElemVitalDO;
import iih.hp.cp.ele.d.desc.HpCpElemVitalDODesc;

/**
 * 诊疗计划元素
 * @author
 *
 */
public class HpcpeleAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public HpcpeleAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(HpCpElemDO.class);
        addChildren(HpCpElemMatchDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(HpCpElemMatchDODesc.class).getFKAttrDesc());        
        addChildren(HpCpElemRulePkgDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(HpCpElemRulePkgDODesc.class).getFKAttrDesc());        
        addChildren(HpCpElemDiagRuleDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(HpCpElemDiagRuleDODesc.class).getFKAttrDesc());        
        addChildren(HpCpElemIndexDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(HpCpElemIndexDODesc.class).getFKAttrDesc());        
        addChildren(HpCpElemSugRuleDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(HpCpElemSugRuleDODesc.class).getFKAttrDesc());        
        addChildren(HpCpElemBoundaryDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(HpCpElemBoundaryDODesc.class).getFKAttrDesc());        
        addChildren(HpCpElemStageDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(HpCpElemStageDODesc.class).getFKAttrDesc());        
        addChildren(HpCpElemTextDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(HpCpElemTextDODesc.class).getFKAttrDesc());        
        addChildren(HpCpElemOrderPkgDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(HpCpElemOrderPkgDODesc.class).getFKAttrDesc());        
        addChildren(HpCpElemOrderDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(HpCpElemOrderDODesc.class).getFKAttrDesc());        
        addChildren(HpCpElemMedRecordDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(HpCpElemMedRecordDODesc.class).getFKAttrDesc());        
        addChildren(HpCpElemBioDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(HpCpElemBioDODesc.class).getFKAttrDesc());        
        addChildren(HpCpElemVitalDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(HpCpElemVitalDODesc.class).getFKAttrDesc());        
	  }	  
}