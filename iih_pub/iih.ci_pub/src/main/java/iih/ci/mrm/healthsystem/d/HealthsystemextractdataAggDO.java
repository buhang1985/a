package iih.ci.mrm.healthsystem.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mrm.healthsystem.d.desc.HealthsystemextractdataAggDODesc;



/**
 * 数据抽取任务
 */
public class HealthsystemextractdataAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public ExtractDataDO getParentDO() {
		return ((ExtractDataDO) super.getParentDO());
	}

	public void setParentDO(ExtractDataDO headDO) {
		setParent(headDO);
	}

	public DocContrastDO[] getDocContrastDO() {
		IBaseDO[] dos = getChildren(DocContrastDO.class);
		if(dos==null) return null;
		DocContrastDO[] result=new DocContrastDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(DocContrastDO)dos[i];
		}
		return result;
	}
	
	public void setDocContrastDO(DocContrastDO[] dos) {
		setChildren(DocContrastDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		HealthsystemextractdataAggDODesc desc = new HealthsystemextractdataAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new ExtractDataDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mrm.healthsystem.d.DocContrastDO")) {
             return new DocContrastDO();
         }
         return null;
     }
}