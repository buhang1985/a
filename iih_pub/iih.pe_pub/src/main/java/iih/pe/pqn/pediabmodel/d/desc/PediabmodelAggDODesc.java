package iih.pe.pqn.pediabmodel.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.pqn.pediabmodel.d.PeDiabModelDO;
import iih.pe.pqn.pediabmodel.d.PeDiabModelAgeDO;
import iih.pe.pqn.pediabmodel.d.desc.PeDiabModelAgeDODesc;
import iih.pe.pqn.pediabmodel.d.PeDiabModelSbpDO;
import iih.pe.pqn.pediabmodel.d.desc.PeDiabModelSbpDODesc;
import iih.pe.pqn.pediabmodel.d.PeDiabModelSexDO;
import iih.pe.pqn.pediabmodel.d.desc.PeDiabModelSexDODesc;
import iih.pe.pqn.pediabmodel.d.PeDiabModelBmiDO;
import iih.pe.pqn.pediabmodel.d.desc.PeDiabModelBmiDODesc;
import iih.pe.pqn.pediabmodel.d.PeDiabModelWaistDO;
import iih.pe.pqn.pediabmodel.d.desc.PeDiabModelWaistDODesc;
import iih.pe.pqn.pediabmodel.d.PeDiabModelFamHisDO;
import iih.pe.pqn.pediabmodel.d.desc.PeDiabModelFamHisDODesc;

/**
 * 健康评估模型_糖尿病
 * @author
 *
 */
public class PediabmodelAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PediabmodelAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeDiabModelDO.class);
        addChildren(PeDiabModelAgeDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeDiabModelAgeDODesc.class).getFKAttrDesc());        
        addChildren(PeDiabModelSbpDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeDiabModelSbpDODesc.class).getFKAttrDesc());        
        addChildren(PeDiabModelSexDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeDiabModelSexDODesc.class).getFKAttrDesc());        
        addChildren(PeDiabModelBmiDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeDiabModelBmiDODesc.class).getFKAttrDesc());        
        addChildren(PeDiabModelWaistDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeDiabModelWaistDODesc.class).getFKAttrDesc());        
        addChildren(PeDiabModelFamHisDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeDiabModelFamHisDODesc.class).getFKAttrDesc());        
	  }	  
}