package iih.nmr.common.medicrecord.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nmr.common.medicrecord.d.MedicalRecordSetDO;
import iih.nmr.common.medicrecord.d.MedicalRecordSetCollDO;
import iih.nmr.common.medicrecord.d.desc.MedicalRecordSetCollDODesc;

/**
 * 医疗记录数据集
 * @author
 *
 */
public class MedicrecordAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public MedicrecordAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(MedicalRecordSetDO.class);
        addChildren(MedicalRecordSetCollDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MedicalRecordSetCollDODesc.class).getFKAttrDesc());        
	  }	  
}