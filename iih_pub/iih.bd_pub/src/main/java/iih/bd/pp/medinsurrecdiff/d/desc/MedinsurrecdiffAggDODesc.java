package iih.bd.pp.medinsurrecdiff.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.pp.medinsurrecdiff.d.MedInsurRecDiffDO;
import iih.bd.pp.medinsurrecdiff.d.MedInsurDrugRecDiffDO;
import iih.bd.pp.medinsurrecdiff.d.desc.MedInsurDrugRecDiffDODesc;
import iih.bd.pp.medinsurrecdiff.d.MedInsurTreatRecDiffDO;
import iih.bd.pp.medinsurrecdiff.d.desc.MedInsurTreatRecDiffDODesc;
import iih.bd.pp.medinsurrecdiff.d.MedInsurSrvFacRecDiffDO;
import iih.bd.pp.medinsurrecdiff.d.desc.MedInsurSrvFacRecDiffDODesc;

/**
 * 医保记录差异
 * @author
 *
 */
public class MedinsurrecdiffAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public MedinsurrecdiffAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(MedInsurRecDiffDO.class);
        addChildren(MedInsurDrugRecDiffDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MedInsurDrugRecDiffDODesc.class).getFKAttrDesc());        
        addChildren(MedInsurTreatRecDiffDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MedInsurTreatRecDiffDODesc.class).getFKAttrDesc());        
        addChildren(MedInsurSrvFacRecDiffDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MedInsurSrvFacRecDiffDODesc.class).getFKAttrDesc());        
	  }	  
}