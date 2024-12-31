package iih.bd.srv.nurcustomca.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.srv.nurcustomca.d.desc.NurcustomcaAggDODesc;



/**
 * 医疗记录_护理文书分类
 */
public class NurcustomcaAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NurCustomcaDO getParentDO() {
		return ((NurCustomcaDO) super.getParentDO());
	}

	public void setParentDO(NurCustomcaDO headDO) {
		setParent(headDO);
	}

	public NurCustomcaItmDO[] getNurCustomcaItmDO() {
		IBaseDO[] dos = getChildren(NurCustomcaItmDO.class);
		if(dos==null) return null;
		NurCustomcaItmDO[] result=new NurCustomcaItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NurCustomcaItmDO)dos[i];
		}
		return result;
	}
	
	public void setNurCustomcaItmDO(NurCustomcaItmDO[] dos) {
		setChildren(NurCustomcaItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		NurcustomcaAggDODesc desc = new NurcustomcaAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NurCustomcaDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.srv.nurcustomca.d.NurCustomcaItmDO")) {
             return new NurCustomcaItmDO();
         }
         return null;
     }
}