package iih.pe.phm.peevalriskreldef.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.phm.peevalriskreldef.d.PeEvalRiskRelDefDO;
import iih.pe.phm.peevalriskreldef.d.PeEvalRiskRelDefItmDO;
import iih.pe.phm.peevalriskreldef.d.desc.PeEvalRiskRelDefItmDODesc;

/**
 * 健康评估-危险因素关系定义
 * @author
 *
 */
public class PeevalriskreldefAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PeevalriskreldefAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeEvalRiskRelDefDO.class);
        addChildren(PeEvalRiskRelDefItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeEvalRiskRelDefItmDODesc.class).getFKAttrDesc());        
	  }	  
}