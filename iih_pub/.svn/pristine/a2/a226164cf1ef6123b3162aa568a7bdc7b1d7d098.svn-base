package iih.pe.pqn.peevalsubhealth.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.pqn.peevalsubhealth.d.PeEvalSubhealthDO;
import iih.pe.pqn.peevalsubhealth.d.PeEvalSHQaDO;
import iih.pe.pqn.peevalsubhealth.d.desc.PeEvalSHQaDODesc;
import iih.pe.pqn.peevalsubhealth.d.PeEvalSHRstDO;
import iih.pe.pqn.peevalsubhealth.d.desc.PeEvalSHRstDODesc;

/**
 * 体检亚健康评估定义
 * @author
 *
 */
public class PeevalsubhealthAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PeevalsubhealthAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeEvalSubhealthDO.class);
        addChildren(PeEvalSHQaDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeEvalSHQaDODesc.class).getFKAttrDesc());        
        addChildren(PeEvalSHRstDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeEvalSHRstDODesc.class).getFKAttrDesc());        
	  }	  
}