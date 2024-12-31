package iih.pe.pqn.peicdvmodel.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.pqn.peicdvmodel.d.PeIcdvModelDO;
import iih.pe.pqn.peicdvmodel.d.PeIcdvModelAgeDO;
import iih.pe.pqn.peicdvmodel.d.desc.PeIcdvModelAgeDODesc;
import iih.pe.pqn.peicdvmodel.d.PeIcdvModelSbpDO;
import iih.pe.pqn.peicdvmodel.d.desc.PeIcdvModelSbpDODesc;
import iih.pe.pqn.peicdvmodel.d.PeIcdvModelBmiDO;
import iih.pe.pqn.peicdvmodel.d.desc.PeIcdvModelBmiDODesc;
import iih.pe.pqn.peicdvmodel.d.PeIcdvModelTcDO;
import iih.pe.pqn.peicdvmodel.d.desc.PeIcdvModelTcDODesc;
import iih.pe.pqn.peicdvmodel.d.PeIcdvModelSmokeDO;
import iih.pe.pqn.peicdvmodel.d.desc.PeIcdvModelSmokeDODesc;
import iih.pe.pqn.peicdvmodel.d.PeIcdvModelDiabetesDO;
import iih.pe.pqn.peicdvmodel.d.desc.PeIcdvModelDiabetesDODesc;
import iih.pe.pqn.peicdvmodel.d.PeIcdvModelAvgDO;
import iih.pe.pqn.peicdvmodel.d.desc.PeIcdvModelAvgDODesc;
import iih.pe.pqn.peicdvmodel.d.PeIcdvModelTotalDO;
import iih.pe.pqn.peicdvmodel.d.desc.PeIcdvModelTotalDODesc;
import iih.pe.pqn.peicdvmodel.d.PeIcdvModelFieldDO;
import iih.pe.pqn.peicdvmodel.d.desc.PeIcdvModelFieldDODesc;

/**
 * 健康评估模型_缺血性冠心病
 * @author
 *
 */
public class PeicdvmodelAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PeicdvmodelAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeIcdvModelDO.class);
        addChildren(PeIcdvModelAgeDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeIcdvModelAgeDODesc.class).getFKAttrDesc());        
        addChildren(PeIcdvModelSbpDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeIcdvModelSbpDODesc.class).getFKAttrDesc());        
        addChildren(PeIcdvModelBmiDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeIcdvModelBmiDODesc.class).getFKAttrDesc());        
        addChildren(PeIcdvModelTcDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeIcdvModelTcDODesc.class).getFKAttrDesc());        
        addChildren(PeIcdvModelSmokeDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeIcdvModelSmokeDODesc.class).getFKAttrDesc());        
        addChildren(PeIcdvModelDiabetesDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeIcdvModelDiabetesDODesc.class).getFKAttrDesc());        
        addChildren(PeIcdvModelAvgDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeIcdvModelAvgDODesc.class).getFKAttrDesc());        
        addChildren(PeIcdvModelTotalDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeIcdvModelTotalDODesc.class).getFKAttrDesc());        
        addChildren(PeIcdvModelFieldDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeIcdvModelFieldDODesc.class).getFKAttrDesc());        
	  }	  
}