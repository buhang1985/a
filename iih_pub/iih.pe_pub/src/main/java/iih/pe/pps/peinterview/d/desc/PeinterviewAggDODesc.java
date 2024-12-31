package iih.pe.pps.peinterview.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.pps.peinterview.d.PeInterviewDO;
import iih.pe.pps.peinterview.d.PeInterviewHistDO;
import iih.pe.pps.peinterview.d.desc.PeInterviewHistDODesc;

/**
 * 体检检后随访
 * @author
 *
 */
public class PeinterviewAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PeinterviewAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeInterviewDO.class);
        addChildren(PeInterviewHistDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeInterviewHistDODesc.class).getFKAttrDesc());        
	  }	  
}