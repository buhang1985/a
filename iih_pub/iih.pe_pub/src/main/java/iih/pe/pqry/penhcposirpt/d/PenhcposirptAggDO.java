package iih.pe.pqry.penhcposirpt.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.pqry.penhcposirpt.d.desc.PenhcposirptAggDODesc;



/**
 * 体检上报报表_卫生局阳性统计
 */
public class PenhcposirptAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeNhcPosiRptDO getParentDO() {
		return ((PeNhcPosiRptDO) super.getParentDO());
	}

	public void setParentDO(PeNhcPosiRptDO headDO) {
		setParent(headDO);
	}

	public PeNhcPosiListDO[] getPeNhcPosiListDO() {
		IBaseDO[] dos = getChildren(PeNhcPosiListDO.class);
		if(dos==null) return null;
		PeNhcPosiListDO[] result=new PeNhcPosiListDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeNhcPosiListDO)dos[i];
		}
		return result;
	}
	
	public void setPeNhcPosiListDO(PeNhcPosiListDO[] dos) {
		setChildren(PeNhcPosiListDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PenhcposirptAggDODesc desc = new PenhcposirptAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeNhcPosiRptDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.pqry.penhcposirpt.d.PeNhcPosiListDO")) {
             return new PeNhcPosiListDO();
         }
         return null;
     }
}