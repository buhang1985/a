package iih.bd.res.place.validate;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.ArrayUtils;

import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IDODesc;
import xap.sys.appfw.bizrule.validation.ValidationFailure;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.bdfw.validator.IAttributeNameGetter;
import xap.sys.bdfw.validator.MDAttributeNameGetter;
import xap.sys.bdfw.validator.NullValueValidationFailure;
import xap.sys.bdfw.validator.NullValueValidator;

public class AggNullValueValidator implements Validator{
	
	private List<String> notNullFields = new ArrayList<String>();
	
	private IAttributeNameGetter attributeNameGetter;
	
	public static NullValueValidator createMDNullValueValidator(IDODesc doDesc, List<String> notNullFields)
	{
		return new NullValueValidator(new MDAttributeNameGetter(doDesc),notNullFields);
		
	}
	
	public AggNullValueValidator(IAttributeNameGetter attributeNameGetter, List<String> notNullFields) {
		super();
		this.attributeNameGetter = attributeNameGetter;
		if(notNullFields!=null)
		{
			this.notNullFields = notNullFields;
		}
	}
	
	private ValidationFailure batchValidate(Object[] objs) {

		NullValueValidationFailure failure = null;
		for(int i=0;i<objs.length;i++)
		{
			if(objs[i] instanceof BaseDO)
			{
				BaseDO do1 = (BaseDO) objs[i];
				
				List<String> shouldNotBeNullFields = doValidate(do1);
				if(shouldNotBeNullFields!=null)
				{
					if(failure==null)
					{
						failure = new NullValueValidationFailure(attributeNameGetter);
					}
					failure.add(do1, shouldNotBeNullFields);
				}
					
					
			}
			else
			{
			BaseDO do1 = (BaseDO) objs[i];
				
				List<String> shouldNotBeNullFields = doValidate(do1);
				if(shouldNotBeNullFields!=null)
				{
					if(failure==null)
					{
						failure = new NullValueValidationFailure(attributeNameGetter);
					}
					failure.add(do1, shouldNotBeNullFields);
				}
			}
		}
		if(failure!=null)
			failure.generateMessage();
		return failure;
	}
	
	private List<String> doValidate(BaseDO vo)
	{
		List<String> shouldNotBeNullFields = new ArrayList<String>();
		for(int i=0;i<notNullFields.size();i++)
		{
			Object value = vo.getAttrVal(notNullFields.get(i));
			
			if(value==null||
					(value instanceof String && StringUtils.isBlank((String)value)))
			{
				shouldNotBeNullFields.add(notNullFields.get(i));
			}
				
		}
		if(shouldNotBeNullFields.size()>0)
			return shouldNotBeNullFields;
		else 
			return null;
	}

	@Override
	public ValidationFailure validate(Object... dos) {
		// TODO Auto-generated method stub
		if (ArrayUtils.isEmpty(dos)){
			return null;
		}
		Object[] objs = (Object[]) dos;
		return batchValidate(objs);
	}

}
