package iih.nm.nqm.nmnqmqcmt.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nm.nqm.nmnqmqcmt.d.NmNqmQcmtDO;
import iih.nm.nqm.nmnqmqcmt.d.NmNqmQcmtIsuDO;
import iih.nm.nqm.nmnqmqcmt.d.desc.NmNqmQcmtIsuDODesc;
import iih.nm.nqm.nmnqmqcmt.d.NmNqmqcmtPsnDO;
import iih.nm.nqm.nmnqmqcmt.d.desc.NmNqmqcmtPsnDODesc;

/**
 * 护理管理_质控会议议题
 * @author
 *
 */
public class NmnqmqcmtAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public NmnqmqcmtAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NmNqmQcmtDO.class);
        addChildren(NmNqmQcmtIsuDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NmNqmQcmtIsuDODesc.class).getFKAttrDesc());        
        addChildren(NmNqmqcmtPsnDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NmNqmqcmtPsnDODesc.class).getFKAttrDesc());        
	  }	  
}