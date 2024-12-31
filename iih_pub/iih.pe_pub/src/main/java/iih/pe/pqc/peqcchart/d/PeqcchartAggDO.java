package iih.pe.pqc.peqcchart.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.pqc.peqcchart.d.desc.PeqcchartAggDODesc;



/**
 * 体检质控图
 */
public class PeqcchartAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeQcChartDO getParentDO() {
		return ((PeQcChartDO) super.getParentDO());
	}

	public void setParentDO(PeQcChartDO headDO) {
		setParent(headDO);
	}

	public PeQcChartItemDO[] getPeQcChartItemDO() {
		IBaseDO[] dos = getChildren(PeQcChartItemDO.class);
		if(dos==null) return null;
		PeQcChartItemDO[] result=new PeQcChartItemDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeQcChartItemDO)dos[i];
		}
		return result;
	}
	
	public void setPeQcChartItemDO(PeQcChartItemDO[] dos) {
		setChildren(PeQcChartItemDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PeqcchartAggDODesc desc = new PeqcchartAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeQcChartDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.pqc.peqcchart.d.PeQcChartItemDO")) {
             return new PeQcChartItemDO();
         }
         return null;
     }
}