package iih.ci.ord.cirptlabhis.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.ord.cirptlabhis.d.desc.CirptlabhisAggDODesc;



/**
 * 检验报告单历史
 */
public class CirptlabhisAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public CiRptLabHISDO getParentDO() {
		return ((CiRptLabHISDO) super.getParentDO());
	}

	public void setParentDO(CiRptLabHISDO headDO) {
		setParent(headDO);
	}

	public CiRptLabItmHISDO[] getCiRptLabItmHISDO() {
		IBaseDO[] dos = getChildren(CiRptLabItmHISDO.class);
		if(dos==null) return null;
		CiRptLabItmHISDO[] result=new CiRptLabItmHISDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(CiRptLabItmHISDO)dos[i];
		}
		return result;
	}
	
	public void setCiRptLabItmHISDO(CiRptLabItmHISDO[] dos) {
		setChildren(CiRptLabItmHISDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		CirptlabhisAggDODesc desc = new CirptlabhisAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new CiRptLabHISDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.ord.cirptlabhis.d.CiRptLabItmHISDO")) {
             return new CiRptLabItmHISDO();
         }
         return null;
     }
}