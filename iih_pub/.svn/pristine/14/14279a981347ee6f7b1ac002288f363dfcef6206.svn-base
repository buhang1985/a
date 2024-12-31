package iih.pe.pqn.peevalchrodef.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.pqn.peevalchrodef.d.PeEvalChroDefDO;
import iih.pe.pqn.peevalchrodef.d.PeChroRiskDefDO;
import iih.pe.pqn.peevalchrodef.d.desc.PeChroRiskDefDODesc;
import iih.pe.pqn.peevalchrodef.d.PeChroGradeDO;
import iih.pe.pqn.peevalchrodef.d.desc.PeChroGradeDODesc;
import iih.pe.pqn.peevalchrodef.d.PeChroDietDefDO;
import iih.pe.pqn.peevalchrodef.d.desc.PeChroDietDefDODesc;
import iih.pe.pqn.peevalchrodef.d.PeChroExerciseDefDO;
import iih.pe.pqn.peevalchrodef.d.desc.PeChroExerciseDefDODesc;

/**
 * 体检慢性病评估定义
 * @author
 *
 */
public class PeevalchrodefAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PeevalchrodefAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeEvalChroDefDO.class);
        addChildren(PeChroRiskDefDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeChroRiskDefDODesc.class).getFKAttrDesc());        
        addChildren(PeChroGradeDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeChroGradeDODesc.class).getFKAttrDesc());        
        addChildren(PeChroDietDefDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeChroDietDefDODesc.class).getFKAttrDesc());        
        addChildren(PeChroExerciseDefDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeChroExerciseDefDODesc.class).getFKAttrDesc());        
	  }	  
}