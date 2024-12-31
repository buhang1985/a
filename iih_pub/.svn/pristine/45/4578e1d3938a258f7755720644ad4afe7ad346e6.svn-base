package iih.nm.nom.nmbedwardrecord.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nm.nom.nmbedwardrecord.d.NomBedwardRecordDO;
import iih.nm.nom.nmbedwardrecord.d.NomBedwardItmDO;
import iih.nm.nom.nmbedwardrecord.d.desc.NomBedwardItmDODesc;

/**
 * 病房患者统计
 * @author
 *
 */
public class NmbedwardrecordAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public NmbedwardrecordAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NomBedwardRecordDO.class);
        addChildren(NomBedwardItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NomBedwardItmDODesc.class).getFKAttrDesc());        
	  }	  
}