package iih.ci.mr.nu.ipobstetricnur.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mr.nu.ipobstetricnur.d.IpobstetricnurinfoDO;
import iih.ci.mr.nu.ipobstetricnur.d.IpobstetricnurDO;
import iih.ci.mr.nu.ipobstetricnur.d.desc.IpobstetricnurDODesc;

/**
 * 产科住院患者护理记录单
 * @author
 *
 */
public class IpobstetricnurAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public IpobstetricnurAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(IpobstetricnurinfoDO.class);
        addChildren(IpobstetricnurDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(IpobstetricnurDODesc.class).getFKAttrDesc());        
	  }	  
}