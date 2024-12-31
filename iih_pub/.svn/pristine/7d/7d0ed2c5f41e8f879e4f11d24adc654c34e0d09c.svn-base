package iih.nmr.ha.tcho.tchoillpatientcare.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nmr.ha.tcho.tchoillpatientcare.d.desc.TchoillpatientcareAggDODesc;



/**
 * 病危(病重)患者护理记录单
 */
public class TchoillpatientcareAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public TchoIllPatientDO getParentDO() {
		return ((TchoIllPatientDO) super.getParentDO());
	}

	public void setParentDO(TchoIllPatientDO headDO) {
		setParent(headDO);
	}

	public TchoIllPatientCareDO[] getTchoIllPatientCareDO() {
		IBaseDO[] dos = getChildren(TchoIllPatientCareDO.class);
		if(dos==null) return null;
		TchoIllPatientCareDO[] result=new TchoIllPatientCareDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(TchoIllPatientCareDO)dos[i];
		}
		return result;
	}
	
	public void setTchoIllPatientCareDO(TchoIllPatientCareDO[] dos) {
		setChildren(TchoIllPatientCareDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		TchoillpatientcareAggDODesc desc = new TchoillpatientcareAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new TchoIllPatientDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nmr.ha.tcho.tchoillpatientcare.d.TchoIllPatientCareDO")) {
             return new TchoIllPatientCareDO();
         }
         return null;
     }
}