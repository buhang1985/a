package iih.pe.pqn.pestrokemodel.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.pqn.pestrokemodel.d.PeStrokeModelDO;
import iih.pe.pqn.pestrokemodel.d.PeStrokeModelAgeDO;
import iih.pe.pqn.pestrokemodel.d.desc.PeStrokeModelAgeDODesc;
import iih.pe.pqn.pestrokemodel.d.PeStrokeModelSbpDO;
import iih.pe.pqn.pestrokemodel.d.desc.PeStrokeModelSbpDODesc;
import iih.pe.pqn.pestrokemodel.d.PeStrokeModelTotalDO;
import iih.pe.pqn.pestrokemodel.d.desc.PeStrokeModelTotalDODesc;
import iih.pe.pqn.pestrokemodel.d.PeStrokeModelOthRiksDO;
import iih.pe.pqn.pestrokemodel.d.desc.PeStrokeModelOthRiksDODesc;
import iih.pe.pqn.pestrokemodel.d.PeStrokeModelFieldDO;
import iih.pe.pqn.pestrokemodel.d.desc.PeStrokeModelFieldDODesc;

/**
 * 健康评估模型_脑卒中
 * @author
 *
 */
public class PestrokemodelAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PestrokemodelAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeStrokeModelDO.class);
        addChildren(PeStrokeModelAgeDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeStrokeModelAgeDODesc.class).getFKAttrDesc());        
        addChildren(PeStrokeModelSbpDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeStrokeModelSbpDODesc.class).getFKAttrDesc());        
        addChildren(PeStrokeModelTotalDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeStrokeModelTotalDODesc.class).getFKAttrDesc());        
        addChildren(PeStrokeModelOthRiksDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeStrokeModelOthRiksDODesc.class).getFKAttrDesc());        
        addChildren(PeStrokeModelFieldDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeStrokeModelFieldDODesc.class).getFKAttrDesc());        
	  }	  
}