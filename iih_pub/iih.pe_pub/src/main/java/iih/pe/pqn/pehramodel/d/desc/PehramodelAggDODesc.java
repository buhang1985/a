package iih.pe.pqn.pehramodel.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.pqn.pehramodel.d.PeHraModelDO;
import iih.pe.pqn.pehramodel.d.PeHraModelRiskDO;
import iih.pe.pqn.pehramodel.d.desc.PeHraModelRiskDODesc;
import iih.pe.pqn.pehramodel.d.PeHraModelIRDO;
import iih.pe.pqn.pehramodel.d.desc.PeHraModelIRDODesc;

/**
 * 体检疾病风险评估模型
 * @author
 *
 */
public class PehramodelAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PehramodelAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeHraModelDO.class);
        addChildren(PeHraModelRiskDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeHraModelRiskDODesc.class).getFKAttrDesc());        
        addChildren(PeHraModelIRDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeHraModelIRDODesc.class).getFKAttrDesc());        
	  }	  
}