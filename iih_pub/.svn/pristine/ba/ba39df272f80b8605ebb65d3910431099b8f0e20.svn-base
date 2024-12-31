package iih.pe.phm.peexerciseplan.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.phm.peexerciseplan.d.PeExercisePlanDO;
import iih.pe.phm.peexerciseplan.d.PeExercisePlanDtlDO;
import iih.pe.phm.peexerciseplan.d.desc.PeExercisePlanDtlDODesc;
import iih.pe.phm.peexerciseplan.d.PeExerciseListDO;
import iih.pe.phm.peexerciseplan.d.desc.PeExerciseListDODesc;

/**
 * 体检运动计划
 * @author
 *
 */
public class PeexerciseplanAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PeexerciseplanAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeExercisePlanDO.class);
        addChildren(PeExercisePlanDtlDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeExercisePlanDtlDODesc.class).getFKAttrDesc());        
        addChildren(PeExerciseListDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeExerciseListDODesc.class).getFKAttrDesc());        
	  }	  
}