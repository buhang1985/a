package iih.bd.srv.srvrtctl.validate;
import iih.bd.srv.srvrtctl.d.SrvrtctlAggDO;
import iih.bd.srv.srvrtctl.i.ISrvrtctlRService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;

import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.bizrule.validation.ValidationFailure;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.sys.bdfw.refcheck.i.IReferenceCheck;
import xap.sys.bdfw.validator.IAttributeNameGetter;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;
import xap.sys.xbd.udi.d.UdidocDO;

public class AggSrvRtCtlValidator implements Validator{
	
	private List<String> notNullFields = new ArrayList<String>();
	
	private IAttributeNameGetter attributeNameGetter;
	

	
	private ValidationFailure batchValidate(Object[] objs) throws BizException {

		ValidationFailure failure = null;
		Map<String,List<SrvrtctlAggDO>> map1=this.validateInput(objs);
		Map<String,List<SrvrtctlAggDO>> map=new HashMap<String,List<SrvrtctlAggDO>>();
		ISrvrtctlRService ctlservice=ServiceFinder.find(ISrvrtctlRService.class);
		SrvrtctlAggDO[] srvaggs=ctlservice.find("1=1", null, FBoolean.FALSE);
		for (SrvrtctlAggDO do1 : srvaggs) {
			
			
				String key=do1.getParentDO().getId_srvrtca();
			if(!map.containsKey(key)){
				List<SrvrtctlAggDO> list=new ArrayList<SrvrtctlAggDO>();
				list.add(do1);
				map.put(key, list);
			}else{
				List<SrvrtctlAggDO> list=map.get(key);
				list.add(do1);
			}
			
		}
		
		for (String key1 : map1.keySet()) {
			List<SrvrtctlAggDO> list1=map1.get(key1);
			
			
			 String sql="select u.* from bd_udidoc u left join bd_srv_rtca ca on ca.id_srvrttp=u.id_udidoc where ca.id_srvrtca='"+list1.get(0).getParentDO().getId_srvrtca()+"'  ";
			   DAFacade da=new DAFacade();
			   UdidocDO udi=(UdidocDO) da.execQuery(sql, new BeanHandler(UdidocDO.class));
               if(udi.getCtrl5().equals("Y")){	
            	   
            	   for (SrvrtctlAggDO srvrtctlAgg : list1) {
            		   if(srvrtctlAgg.getParentDO().getCode()==null)
            		   {
            			   if(failure==null)
           					{
            				   failure = new ValidationFailure(srvrtctlAgg.getParentDO().getName()+"   权限级别为空");
           					}
            			   return failure;
            		   }
            		  
            		   for (SrvrtctlAggDO aggDO : list1) {
            			   if(aggDO.getParentDO().getCode()==null)
            			   {
                			   if(failure==null)
               					{
               						failure = new ValidationFailure(aggDO.getParentDO().getName()+"   权限级别为空");
               					}
                			   return failure;
                		   }
						if(aggDO.getParentDO().getId_srvrtca().equals(srvrtctlAgg.getParentDO().getId_srvrtca())&&aggDO.getParentDO().getCode().equals(srvrtctlAgg.getParentDO().getCode())){
							  {
								  if(aggDO.getParentDO().getId_srvrt()!=srvrtctlAgg.getParentDO().getId_srvrt()){
		            			   if(failure==null)
		           					{
		            				   failure = new ValidationFailure(srvrtctlAgg.getParentDO().getName()+"   权限级别重复");
		           					}
		            			   return failure;
								  }
		            		   }
						}
					}
				}
            	   SrvrtctlAggDO ctlagg=list1.get(0);
            	 
					List<SrvrtctlAggDO> list=map.get(key1);
					for (SrvrtctlAggDO srvrtctlAggDO : list) {
						if(ctlagg.getParentDO().getCode().equals(srvrtctlAggDO.getParentDO().getCode()))
						  {
							if(ctlagg.getParentDO().getId_srvrt()!=null&&!ctlagg.getParentDO().getId_srvrt().equals(srvrtctlAggDO.getParentDO().getId_srvrt()))
							{ if(failure==null)
	           					{
	            				   failure = new ValidationFailure(ctlagg.getParentDO().getName()+"   权限级别重复");
	           					}
	            			   return failure;
	            		   }else if(ctlagg.getParentDO().getId_srvrt()==null){
	            			   if(failure==null)
	           					{
	            				   failure = new ValidationFailure(ctlagg.getParentDO().getName()+"   权限级别重复");
	           					}
	            			   return failure;
	            		   }
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
	
	private Map<String,List<SrvrtctlAggDO>> validateInput(Object[] objs) throws BizException{
		

		ValidationFailure failure = null;
		Map<String,List<SrvrtctlAggDO>> map=new HashMap<String,List<SrvrtctlAggDO>>();
		for(int i=0;i<objs.length;i++)
		{
			if(objs[i] instanceof BaseAggDO)
			{
				SrvrtctlAggDO do1 = (SrvrtctlAggDO) objs[i];
				if(do1.getParentDO().getStatus()!=DOStatus.DELETED)
				{
					String key=do1.getParentDO().getId_srvrtca();
				if(!map.containsKey(key)){
					List<SrvrtctlAggDO> list=new ArrayList<SrvrtctlAggDO>();
					list.add(do1);
					map.put(key, list);
				}else{
					List<SrvrtctlAggDO> list=map.get(key);
					list.add(do1);
				}
				}
			}
		}
		
		
		return map;
		
		
	}

}
