package iih.hp.cp.appele.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.hp.cp.appele.d.HpCpAppElemDO;
import iih.hp.cp.appele.d.HpCpAppElemStageDO;
import iih.hp.cp.appele.d.desc.HpCpAppElemStageDODesc;
import iih.hp.cp.appele.d.HpCpAppDiagRuleDO;
import iih.hp.cp.appele.d.desc.HpCpAppDiagRuleDODesc;
import iih.hp.cp.appele.d.HpCpAppElemOrderPkgDO;
import iih.hp.cp.appele.d.desc.HpCpAppElemOrderPkgDODesc;
import iih.hp.cp.appele.d.HpCpAppElemOrderDO;
import iih.hp.cp.appele.d.desc.HpCpAppElemOrderDODesc;
import iih.hp.cp.appele.d.HpCpAppElemMrDO;
import iih.hp.cp.appele.d.desc.HpCpAppElemMrDODesc;

/**
 * 诊疗计划应用_元素
 * @author
 *
 */
public class HpcpappeleAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public HpcpappeleAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(HpCpAppElemDO.class);
        addChildren(HpCpAppElemStageDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(HpCpAppElemStageDODesc.class).getFKAttrDesc());        
        addChildren(HpCpAppDiagRuleDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(HpCpAppDiagRuleDODesc.class).getFKAttrDesc());        
        addChildren(HpCpAppElemOrderPkgDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(HpCpAppElemOrderPkgDODesc.class).getFKAttrDesc());        
        addChildren(HpCpAppElemOrderDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(HpCpAppElemOrderDODesc.class).getFKAttrDesc());        
        addChildren(HpCpAppElemMrDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(HpCpAppElemMrDODesc.class).getFKAttrDesc());        
	  }	  
}