package iih.sc.apt.scapt.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.apt.scapt.d.ScAptMtDO;
import iih.sc.apt.scapt.d.desc.ScAptMtDODesc;
import iih.sc.apt.scapt.d.ScAptOpDO;
import iih.sc.apt.scapt.d.desc.ScAptOpDODesc;
import iih.sc.apt.scapt.d.ScAptOptDO;
import iih.sc.apt.scapt.d.desc.ScAptOptDODesc;

/**
 * 计划排班_预约
 * @author
 *
 */
public class ScaptAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public ScaptAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(ScAptDO.class);
        addChildren(ScAptMtDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(ScAptMtDODesc.class).getFKAttrDesc());        
        addChildren(ScAptOpDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(ScAptOpDODesc.class).getFKAttrDesc());        
        addChildren(ScAptOptDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(ScAptOptDODesc.class).getFKAttrDesc());        
	  }	  
}