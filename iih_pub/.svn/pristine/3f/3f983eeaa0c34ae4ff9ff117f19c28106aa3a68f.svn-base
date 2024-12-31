package iih.ci.rcm.infectionoutbreakreport.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.rcm.infectionoutbreakreport.d.desc.InfectionoutbreakreportAggDODesc;



/**
 * 医院感染暴发报告登记表
 */
public class InfectionoutbreakreportAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public InfectionOutbreakReportDO getParentDO() {
		return ((InfectionOutbreakReportDO) super.getParentDO());
	}

	public void setParentDO(InfectionOutbreakReportDO headDO) {
		setParent(headDO);
	}

	public InfecOutbreakDetailReportDO[] getInfecOutbreakDetailReportDO() {
		IBaseDO[] dos = getChildren(InfecOutbreakDetailReportDO.class);
		if(dos==null) return null;
		InfecOutbreakDetailReportDO[] result=new InfecOutbreakDetailReportDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(InfecOutbreakDetailReportDO)dos[i];
		}
		return result;
	}
	
	public void setInfecOutbreakDetailReportDO(InfecOutbreakDetailReportDO[] dos) {
		setChildren(InfecOutbreakDetailReportDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		InfectionoutbreakreportAggDODesc desc = new InfectionoutbreakreportAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new InfectionOutbreakReportDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.rcm.infectionoutbreakreport.d.InfecOutbreakDetailReportDO")) {
             return new InfecOutbreakDetailReportDO();
         }
         return null;
     }
}