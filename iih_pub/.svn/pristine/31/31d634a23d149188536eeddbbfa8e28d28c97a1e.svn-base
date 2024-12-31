package iih.nmr.pkuf.nmrdi.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nmr.pkuf.nmrdi.d.NmrDiDO;
import iih.nmr.pkuf.nmrdi.d.NmrDiFacDO;
import iih.nmr.pkuf.nmrdi.d.desc.NmrDiFacDODesc;
import iih.nmr.pkuf.nmrdi.d.NmrDiTrDO;
import iih.nmr.pkuf.nmrdi.d.desc.NmrDiTrDODesc;
import iih.nmr.pkuf.nmrdi.d.NmrDiMeaDO;
import iih.nmr.pkuf.nmrdi.d.desc.NmrDiMeaDODesc;

/**
 * 护理诊断
 * @author
 *
 */
public class NmrdiAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public NmrdiAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NmrDiDO.class);
        addChildren(NmrDiFacDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NmrDiFacDODesc.class).getFKAttrDesc());        
        addChildren(NmrDiTrDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NmrDiTrDODesc.class).getFKAttrDesc());        
        addChildren(NmrDiMeaDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NmrDiMeaDODesc.class).getFKAttrDesc());        
	  }	  
}