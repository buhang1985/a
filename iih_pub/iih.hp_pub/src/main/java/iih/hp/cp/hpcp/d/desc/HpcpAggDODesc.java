package iih.hp.cp.hpcp.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.hp.cp.hpcp.d.HpCpDO;
import iih.hp.cp.hpcp.d.HpCpEnblOrgDO;
import iih.hp.cp.hpcp.d.desc.HpCpEnblOrgDODesc;
import iih.hp.cp.hpcp.d.HpCpFileDO;
import iih.hp.cp.hpcp.d.desc.HpCpFileDODesc;

/**
 * 诊疗计划
 * @author
 *
 */
public class HpcpAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public HpcpAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(HpCpDO.class);
        addChildren(HpCpEnblOrgDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(HpCpEnblOrgDODesc.class).getFKAttrDesc());        
        addChildren(HpCpFileDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(HpCpFileDODesc.class).getFKAttrDesc());        
	  }	  
}