package iih.pe.papt.pecorpappt.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.papt.pecorpappt.d.desc.PecorpapptAggDODesc;



/**
 * 体检团体预约单
 */
public class PecorpapptAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeCorpApptDO getParentDO() {
		return ((PeCorpApptDO) super.getParentDO());
	}

	public void setParentDO(PeCorpApptDO headDO) {
		setParent(headDO);
	}

	public PeCorpApptGrpDO[] getPeCorpApptGrpDO() {
		IBaseDO[] dos = getChildren(PeCorpApptGrpDO.class);
		if(dos==null) return null;
		PeCorpApptGrpDO[] result=new PeCorpApptGrpDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeCorpApptGrpDO)dos[i];
		}
		return result;
	}
	
	public void setPeCorpApptGrpDO(PeCorpApptGrpDO[] dos) {
		setChildren(PeCorpApptGrpDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PecorpapptAggDODesc desc = new PecorpapptAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeCorpApptDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.papt.pecorpappt.d.PeCorpApptGrpDO")) {
             return new PeCorpApptGrpDO();
         }
         return null;
     }
}