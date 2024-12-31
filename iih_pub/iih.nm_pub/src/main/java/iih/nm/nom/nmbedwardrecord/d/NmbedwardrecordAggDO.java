package iih.nm.nom.nmbedwardrecord.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nm.nom.nmbedwardrecord.d.desc.NmbedwardrecordAggDODesc;



/**
 * 病房患者统计
 */
public class NmbedwardrecordAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NomBedwardRecordDO getParentDO() {
		return ((NomBedwardRecordDO) super.getParentDO());
	}

	public void setParentDO(NomBedwardRecordDO headDO) {
		setParent(headDO);
	}

	public NomBedwardItmDO[] getNomBedwardItmDO() {
		IBaseDO[] dos = getChildren(NomBedwardItmDO.class);
		if(dos==null) return null;
		NomBedwardItmDO[] result=new NomBedwardItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NomBedwardItmDO)dos[i];
		}
		return result;
	}
	
	public void setNomBedwardItmDO(NomBedwardItmDO[] dos) {
		setChildren(NomBedwardItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		NmbedwardrecordAggDODesc desc = new NmbedwardrecordAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NomBedwardRecordDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nm.nom.nmbedwardrecord.d.NomBedwardItmDO")) {
             return new NomBedwardItmDO();
         }
         return null;
     }
}