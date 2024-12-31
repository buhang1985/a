package iih.ci.mrm.cimrfpdicatado.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mrm.cimrfpdicatado.d.CiMrFpDiCataDO;
import iih.ci.mrm.cimrfpdicatado.d.CiMrFpZYDiCataDO;
import iih.ci.mrm.cimrfpdicatado.d.desc.CiMrFpZYDiCataDODesc;
import iih.ci.mrm.cimrfpdicatado.d.CiMrFpXYDiCataDO;
import iih.ci.mrm.cimrfpdicatado.d.desc.CiMrFpXYDiCataDODesc;

/**
 * 病案编目诊断
 * @author
 *
 */
public class CimrfpdicatadoAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public CimrfpdicatadoAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(CiMrFpDiCataDO.class);
        addChildren(CiMrFpZYDiCataDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(CiMrFpZYDiCataDODesc.class).getFKAttrDesc());        
        addChildren(CiMrFpXYDiCataDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(CiMrFpXYDiCataDODesc.class).getFKAttrDesc());        
	  }	  
}