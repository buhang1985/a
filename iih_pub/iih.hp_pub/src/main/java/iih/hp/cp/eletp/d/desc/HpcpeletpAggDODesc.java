package iih.hp.cp.eletp.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.hp.cp.eletp.d.HpCpElemTypeDO;
import iih.hp.cp.eletp.d.HpCpElemTypeNestableDO;
import iih.hp.cp.eletp.d.desc.HpCpElemTypeNestableDODesc;
import iih.hp.cp.eletp.d.HpCpElemTypePropDO;
import iih.hp.cp.eletp.d.desc.HpCpElemTypePropDODesc;
import iih.hp.cp.eletp.d.HpCpElemTypePropTrgDO;
import iih.hp.cp.eletp.d.desc.HpCpElemTypePropTrgDODesc;

/**
 * 诊疗计划元素类型
 * @author
 *
 */
public class HpcpeletpAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public HpcpeletpAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(HpCpElemTypeDO.class);
        addChildren(HpCpElemTypeNestableDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(HpCpElemTypeNestableDODesc.class).getFKAttrDesc());        
        addChildren(HpCpElemTypePropDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(HpCpElemTypePropDODesc.class).getFKAttrDesc());        
        addChildren(HpCpElemTypePropTrgDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(HpCpElemTypePropTrgDODesc.class).getFKAttrDesc());        
	  }	  
}