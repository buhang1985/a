package iih.ci.mr.nu.newborn24hobsrec.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mr.nu.newborn24hobsrec.d.New24ObsPatDO;
import iih.ci.mr.nu.newborn24hobsrec.d.New24ObsDO;
import iih.ci.mr.nu.newborn24hobsrec.d.desc.New24ObsDODesc;

/**
 * 新生儿24小时观察记录单
 * @author
 *
 */
public class Newborn24hobsrecAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public Newborn24hobsrecAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(New24ObsPatDO.class);
        addChildren(New24ObsDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(New24ObsDODesc.class).getFKAttrDesc());        
	  }	  
}