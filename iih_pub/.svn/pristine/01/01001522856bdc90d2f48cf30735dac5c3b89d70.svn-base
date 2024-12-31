package iih.nm.nom.nommeet.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nm.nom.nommeet.d.NomMeetDO;
import iih.nm.nom.nommeet.d.NomMeetPsnDO;
import iih.nm.nom.nommeet.d.desc.NomMeetPsnDODesc;

/**
 * 会议记录
 * @author
 *
 */
public class NommeetAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public NommeetAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NomMeetDO.class);
        addChildren(NomMeetPsnDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NomMeetPsnDODesc.class).getFKAttrDesc());        
	  }	  
}