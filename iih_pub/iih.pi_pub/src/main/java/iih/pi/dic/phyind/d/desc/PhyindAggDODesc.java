package iih.pi.dic.phyind.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pi.dic.phyind.d.PiPatPhyIndDO;
import iih.pi.dic.phyind.d.PiPatPhyIndOptDO;
import iih.pi.dic.phyind.d.desc.PiPatPhyIndOptDODesc;

/**
 * 患者生理指标
 * @author
 *
 */
public class PhyindAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PhyindAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PiPatPhyIndDO.class);
        addChildren(PiPatPhyIndOptDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PiPatPhyIndOptDODesc.class).getFKAttrDesc());        
	  }	  
}