package iih.pe.pqn.peevalkinematics.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.pqn.peevalkinematics.d.PeEvalKinematicsDO;
import iih.pe.pqn.peevalkinematics.d.PeEvalKineIntDO;
import iih.pe.pqn.peevalkinematics.d.desc.PeEvalKineIntDODesc;
import iih.pe.pqn.peevalkinematics.d.PeEvalKineDurDO;
import iih.pe.pqn.peevalkinematics.d.desc.PeEvalKineDurDODesc;
import iih.pe.pqn.peevalkinematics.d.PeEvalKineFreqDO;
import iih.pe.pqn.peevalkinematics.d.desc.PeEvalKineFreqDODesc;
import iih.pe.pqn.peevalkinematics.d.PeEvalKineLevelDO;
import iih.pe.pqn.peevalkinematics.d.desc.PeEvalKineLevelDODesc;

/**
 * 健康评估-运动评估定义
 * @author
 *
 */
public class PeevalkinematicsAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PeevalkinematicsAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeEvalKinematicsDO.class);
        addChildren(PeEvalKineIntDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeEvalKineIntDODesc.class).getFKAttrDesc());        
        addChildren(PeEvalKineDurDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeEvalKineDurDODesc.class).getFKAttrDesc());        
        addChildren(PeEvalKineFreqDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeEvalKineFreqDODesc.class).getFKAttrDesc());        
        addChildren(PeEvalKineLevelDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeEvalKineLevelDODesc.class).getFKAttrDesc());        
	  }	  
}