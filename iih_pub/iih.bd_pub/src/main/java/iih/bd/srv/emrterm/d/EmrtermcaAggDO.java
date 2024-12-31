package iih.bd.srv.emrterm.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.srv.emrterm.d.desc.EmrtermcaAggDODesc;



/**
 * 病历术语分类
 */
public class EmrtermcaAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public EmrTermCaDO getParentDO() {
		return ((EmrTermCaDO) super.getParentDO());
	}

	public void setParentDO(EmrTermCaDO headDO) {
		setParent(headDO);
	}

	public EmrTermGrpDO[] getEmrTermGrpDO() {
		IBaseDO[] dos = getChildren(EmrTermGrpDO.class);
		if(dos==null) return null;
		EmrTermGrpDO[] result=new EmrTermGrpDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(EmrTermGrpDO)dos[i];
		}
		return result;
	}
	
	public void setEmrTermGrpDO(EmrTermGrpDO[] dos) {
		setChildren(EmrTermGrpDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		EmrtermcaAggDODesc desc = new EmrtermcaAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new EmrTermCaDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.srv.emrterm.d.EmrTermGrpDO")) {
             return new EmrTermGrpDO();
         }
         return null;
     }
}