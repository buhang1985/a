package iih.nmr.pkuf.carecord.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nmr.pkuf.carecord.d.desc.Carecord1AggDODesc;



/**
 * 护理记录单
 */
public class Carecord1AggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public CarecorDO getParentDO() {
		return ((CarecorDO) super.getParentDO());
	}

	public void setParentDO(CarecorDO headDO) {
		setParent(headDO);
	}

	public OutputDO[] getOutputDO() {
		IBaseDO[] dos = getChildren(OutputDO.class);
		if(dos==null) return null;
		OutputDO[] result=new OutputDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(OutputDO)dos[i];
		}
		return result;
	}
	
	public void setOutputDO(OutputDO[] dos) {
		setChildren(OutputDO.class, dos);
	}
	public InputDO[] getInputDO() {
		IBaseDO[] dos = getChildren(InputDO.class);
		if(dos==null) return null;
		InputDO[] result=new InputDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(InputDO)dos[i];
		}
		return result;
	}
	
	public void setInputDO(InputDO[] dos) {
		setChildren(InputDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		Carecord1AggDODesc desc = new Carecord1AggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new CarecorDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nmr.pkuf.carecord.d.OutputDO")) {
             return new OutputDO();
         }
	    else if (clzName.equals("iih.nmr.pkuf.carecord.d.InputDO")) {
             return new InputDO();
         }
         return null;
     }
}