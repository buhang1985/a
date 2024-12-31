package iih.nm.nqm.qctplelemaintenance.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nm.nqm.qctplelemaintenance.d.desc.QctplelemaintenanceAggDODesc;



/**
 * 质量模板元素
 */
public class QctplelemaintenanceAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NmQctplEleDO getParentDO() {
		return ((NmQctplEleDO) super.getParentDO());
	}

	public void setParentDO(NmQctplEleDO headDO) {
		setParent(headDO);
	}

	public NmQctplEleItmDO[] getNmQctplEleItmDO() {
		IBaseDO[] dos = getChildren(NmQctplEleItmDO.class);
		if(dos==null) return null;
		NmQctplEleItmDO[] result=new NmQctplEleItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NmQctplEleItmDO)dos[i];
		}
		return result;
	}
	
	public void setNmQctplEleItmDO(NmQctplEleItmDO[] dos) {
		setChildren(NmQctplEleItmDO.class, dos);
	}
	public NmQctplEleGrpDO[] getNmQctplEleGrpDO() {
		IBaseDO[] dos = getChildren(NmQctplEleGrpDO.class);
		if(dos==null) return null;
		NmQctplEleGrpDO[] result=new NmQctplEleGrpDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NmQctplEleGrpDO)dos[i];
		}
		return result;
	}
	
	public void setNmQctplEleGrpDO(NmQctplEleGrpDO[] dos) {
		setChildren(NmQctplEleGrpDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		QctplelemaintenanceAggDODesc desc = new QctplelemaintenanceAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NmQctplEleDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nm.nqm.qctplelemaintenance.d.NmQctplEleItmDO")) {
             return new NmQctplEleItmDO();
         }
	    else if (clzName.equals("iih.nm.nqm.qctplelemaintenance.d.NmQctplEleGrpDO")) {
             return new NmQctplEleGrpDO();
         }
         return null;
     }
}