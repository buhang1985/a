package iih.pe.phm.pehmgroup.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.phm.pehmgroup.d.PeHmGroupDO;
import iih.pe.phm.pehmgroup.d.PeHmGroupPsnDO;
import iih.pe.phm.pehmgroup.d.desc.PeHmGroupPsnDODesc;
import iih.pe.phm.pehmgroup.d.PeHmGroupRisksDO;
import iih.pe.phm.pehmgroup.d.desc.PeHmGroupRisksDODesc;

/**
 * 体检健康群体管理
 * @author
 *
 */
public class PehmgroupAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PehmgroupAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeHmGroupDO.class);
        addChildren(PeHmGroupPsnDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeHmGroupPsnDODesc.class).getFKAttrDesc());        
        addChildren(PeHmGroupRisksDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeHmGroupRisksDODesc.class).getFKAttrDesc());        
	  }	  
}