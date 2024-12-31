package iih.bd.srv.medusage.validator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.bizrule.validation.ValidationFailure;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.sys.bdfw.refcheck.i.IReferenceCheck;
import xap.sys.bdfw.validator.IAttributeNameGetter;

public class AggSrvReferenceValidator implements Validator{
	
	private List<String> notNullFields = new ArrayList<String>();
	
	private IAttributeNameGetter attributeNameGetter;
	

	
	private ValidationFailure batchValidate(Object[] objs) throws BizException {

		ValidationFailure failure = null;
		for(int i=0;i<objs.length;i++)
		{
			if(objs[i] instanceof BaseAggDO)
			{
				BaseAggDO do1 = (BaseAggDO) objs[i];
				
				if( doValidate(do1)){
					
					if(failure==null)
					{
						failure = new ValidationFailure(do1.getParentDO().getAttrVal("Name")+"   已被引用不能修改");
					}
					
					
				}
			}
		}
		return failure;
	}
	
	private Boolean doValidate(BaseAggDO vo) throws BizException
	{
		
		Boolean b=ServiceFinder.find(IReferenceCheck.class).isReferenced(vo.getParentDO().getTableName(), vo.getParentDO().getPkVal(),new String[]{"bd_freq_time"}, new StringBuffer());
       if(!b){
    	   for (BaseDO basedo : vo.getAllChildrenDO()) {
    		   b=ServiceFinder.find(IReferenceCheck.class).isReferenced2(basedo.getTableName(), basedo.getPkVal(), new StringBuffer());
    		   if(b)
    			   break;
		}    	  
       }
	
			return b;
	}

	@Override
	public ValidationFailure validate(Object... arg0) {
		// TODO Auto-generated method stub
		
		if (ArrayUtils.isEmpty(arg0)){
			return null;
		}
		Object[] objs = (Object[]) arg0;
		ValidationFailure vl=null;
		try {
			vl= batchValidate(objs);
		} catch (BizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return vl;
		}
	}

}
