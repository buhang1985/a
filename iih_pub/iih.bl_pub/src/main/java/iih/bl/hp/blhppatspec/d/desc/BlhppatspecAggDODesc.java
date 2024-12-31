package iih.bl.hp.blhppatspec.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bl.hp.blhppatspec.d.BlHpPatSpecDO;
import iih.bl.hp.blhppatspec.d.BlHpPatSpecDiDO;
import iih.bl.hp.blhppatspec.d.desc.BlHpPatSpecDiDODesc;

/**
 * 医保特殊病患者
 * @author
 *
 */
public class BlhppatspecAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public BlhppatspecAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(BlHpPatSpecDO.class);
        addChildren(BlHpPatSpecDiDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(BlHpPatSpecDiDODesc.class).getFKAttrDesc());        
	  }	  
}