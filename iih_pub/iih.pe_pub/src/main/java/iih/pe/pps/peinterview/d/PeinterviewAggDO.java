package iih.pe.pps.peinterview.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.pps.peinterview.d.desc.PeinterviewAggDODesc;



/**
 * 体检检后随访
 */
public class PeinterviewAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeInterviewDO getParentDO() {
		return ((PeInterviewDO) super.getParentDO());
	}

	public void setParentDO(PeInterviewDO headDO) {
		setParent(headDO);
	}

	public PeInterviewHistDO[] getPeInterviewHistDO() {
		IBaseDO[] dos = getChildren(PeInterviewHistDO.class);
		if(dos==null) return null;
		PeInterviewHistDO[] result=new PeInterviewHistDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeInterviewHistDO)dos[i];
		}
		return result;
	}
	
	public void setPeInterviewHistDO(PeInterviewHistDO[] dos) {
		setChildren(PeInterviewHistDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PeinterviewAggDODesc desc = new PeinterviewAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeInterviewDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.pps.peinterview.d.PeInterviewHistDO")) {
             return new PeInterviewHistDO();
         }
         return null;
     }
}