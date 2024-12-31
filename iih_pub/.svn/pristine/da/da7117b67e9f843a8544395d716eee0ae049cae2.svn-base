package iih.ci.ord.ciordems.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;

/**
 * 医嘱医疗单
 */
public class CiordemsAggDTO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public EmsHeadDO getParentDO() {
		return ((EmsHeadDO) super.getParentDO());
	}

	public void setParentDO(EmsHeadDO headDO) {
		setParent(headDO);
	}

	public EmsDrugItemDO[] getEmsDrugItemDO() {
		return ((EmsDrugItemDO[]) getChildren(EmsDrugItemDO.class));
	}
	
	public void setEmsDrugItemDO(EmsDrugItemDO[] dos) {
		setChildren(EmsDrugItemDO.class, dos);
	}
	public EmsObsItemDO[] getEmsObsItemDO() {
		return ((EmsObsItemDO[]) getChildren(EmsObsItemDO.class));
	}
	
	public void setEmsObsItemDO(EmsObsItemDO[] dos) {
		setChildren(EmsObsItemDO.class, dos);
	}
	public EmsBtItemDO[] getEmsBtItemDO() {
		return ((EmsBtItemDO[]) getChildren(EmsBtItemDO.class));
	}
	
	public void setEmsBtItemDO(EmsBtItemDO[] dos) {
		setChildren(EmsBtItemDO.class, dos);
	}
	public EmsOpitemDO[] getEmsOpitemDO() {
		return ((EmsOpitemDO[]) getChildren(EmsOpitemDO.class));
	}
	
	public void setEmsOpitemDO(EmsOpitemDO[] dos) {
		setChildren(EmsOpitemDO.class, dos);
	}
	public EmsPathgyItemDO[] getEmsPathgyItemDO() {
		return ((EmsPathgyItemDO[]) getChildren(EmsPathgyItemDO.class));
	}
	
	public void setEmsPathgyItemDO(EmsPathgyItemDO[] dos) {
		setChildren(EmsPathgyItemDO.class, dos);
	}
	public EmsConsItemDO[] getEmsConsItemDO() {
		return ((EmsConsItemDO[]) getChildren(EmsConsItemDO.class));
	}
	
	public void setEmsConsItemDO(EmsConsItemDO[] dos) {
		setChildren(EmsConsItemDO.class, dos);
	}
	public EmsTransItemDO[] getEmsTransItemDO() {
		return ((EmsTransItemDO[]) getChildren(EmsTransItemDO.class));
	}
	
	public void setEmsTransItemDO(EmsTransItemDO[] dos) {
		setChildren(EmsTransItemDO.class, dos);
	}
	public EmsOutItemDO[] getEmsOutItemDO() {
		return ((EmsOutItemDO[]) getChildren(EmsOutItemDO.class));
	}
	
	public void setEmsOutItemDO(EmsOutItemDO[] dos) {
		setChildren(EmsOutItemDO.class, dos);
	}
	public EmsBuItemDO[] getEmsBuItemDO() {
		return ((EmsBuItemDO[]) getChildren(EmsBuItemDO.class));
	}
	
	public void setEmsBuItemDO(EmsBuItemDO[] dos) {
		setChildren(EmsBuItemDO.class, dos);
	}

	 public  BaseDO createParentDO() {
         return new EmsHeadDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.ord.ciordems.d.EmsDrugItemDO")) {
             return new EmsDrugItemDO();
         }
	    else if (clzName.equals("iih.ci.ord.ciordems.d.EmsObsItemDO")) {
             return new EmsObsItemDO();
         }
	    else if (clzName.equals("iih.ci.ord.ciordems.d.EmsBtItemDO")) {
             return new EmsBtItemDO();
         }
	    else if (clzName.equals("iih.ci.ord.ciordems.d.EmsOpitemDO")) {
             return new EmsOpitemDO();
         }
	    else if (clzName.equals("iih.ci.ord.ciordems.d.EmsPathgyItemDO")) {
             return new EmsPathgyItemDO();
         }
	    else if (clzName.equals("iih.ci.ord.ciordems.d.EmsConsItemDO")) {
             return new EmsConsItemDO();
         }
	    else if (clzName.equals("iih.ci.ord.ciordems.d.EmsTransItemDO")) {
             return new EmsTransItemDO();
         }
	    else if (clzName.equals("iih.ci.ord.ciordems.d.EmsOutItemDO")) {
             return new EmsOutItemDO();
         }
	    else if (clzName.equals("iih.ci.ord.ciordems.d.EmsBuItemDO")) {
             return new EmsBuItemDO();
         }
         return null;
     }
    
    /**
     * AggDTO 中元数据描述不存在，此方法不应使用 
     */ 
    @Override
	public IAggDesc getAggDesc() {
		return null;
	}

}