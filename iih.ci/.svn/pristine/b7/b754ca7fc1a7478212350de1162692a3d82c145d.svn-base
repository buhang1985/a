package iih.ci.mrfp.cimrfpdto.s;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import iih.ci.mr.cimrsource.d.CiMrSourceDO;
import iih.ci.mr.pub.MrConst.IMrPubConst;
import iih.ci.mrfp.cimrfpdto.d.CiMrFpSugDTO;
import iih.ci.mrfp.cimrfpdto.i.MrFpGetInfoMaintainService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

@Service(serviceInterfaces = { MrFpGetInfoMaintainService.class }, binding = Binding.JSONRPC)
public class MrFpGetInfoMaintainServiceImpl implements MrFpGetInfoMaintainService{
	
	/**
	 * 获取手术信息
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public CiMrFpSugDTO[] getFpSugByRefresh(String id_ent) throws BizException{
		DAFacade daf=new DAFacade();
		List<CiMrFpSugDTO> list2=new ArrayList<CiMrFpSugDTO>();
		List<CiMrSourceDO> list=new ArrayList<CiMrSourceDO>();
		StringBuilder sb = new StringBuilder();
		sb.append("select ci_mr_source.* from ci_mr_source ci_mr_source ");
		sb.append(" left join ci_mr ci_mr on ci_mr.id_mr = ci_mr_source.id_mr ");
		sb.append(" left join bd_mrtp bd_mrtp on bd_mrtp.id_mrtp = ci_mr.id_mrtp ");
		sb.append(" left join bd_set bd_set on bd_set.id_set = bd_mrtp.id_data_set ");
		sb.append(" where ci_mr.id_ent = '"+id_ent+"' and bd_set.code in ('"+IMrPubConst.DS_SSJL+"','"+IMrPubConst.DS_ZLJL+"')");
		sb.append(" order by ci_mr.createdtime ");
		list = (List<CiMrSourceDO>) daf.execQuery(sb.toString(), new BeanListHandler(CiMrSourceDO.class));		
		Set<String> set=new HashSet<String>();
		for(CiMrSourceDO sourceDO:list){
			set.add(sourceDO.getId_mr());
		}
		int temp=0;
		Boolean isAdd = false;			
		for(int i=0;i<set.size();i++){
			CiMrFpSugDTO sugDTO=new CiMrFpSugDTO();
			int n=0;
			isAdd = false;
			for(int m=temp;m<list.size();m++){
				if(m<=temp){ n=m;}
				else{ n=m-1;}
				String idMr = list.get(m).getId_mr();
				String idMr_old = list.get(n).getId_mr();
				if(idMr.equals(idMr_old)){
					 String namePro = list.get(m).getName_pro();
					String name = namePro.substring(0,1).toUpperCase()+namePro.substring(1);
					String content = list.get(m).getContent();
					if(list.get(m).getContent()!=null){
						isAdd = true;						
						sugDTO.setAttrVal(name, content);													
					}
		        }else{
		        	temp=n+1;   	
		        	break;
		        }
				n++;
			}
			if(isAdd)
			{
			list2.add(sugDTO);
			}
		}
		return (CiMrFpSugDTO[]) list2.toArray(new CiMrFpSugDTO[0]);
	}
    
	

	@SuppressWarnings("unchecked")
	@Override
	public CiMrFpSugDTO[] getFpSugByMrId(String id_mr) throws BizException {

		DAFacade daf=new DAFacade();
		List<CiMrFpSugDTO> list2=new ArrayList<CiMrFpSugDTO>();
		List<CiMrSourceDO> list=new ArrayList<CiMrSourceDO>();
		StringBuilder sb = new StringBuilder();
		sb.append("select ci_mr_source.* from ci_mr_source ci_mr_source ");
		sb.append(" where ci_mr_source.id_mr = '"+id_mr+"' ");
		list = (List<CiMrSourceDO>) daf.execQuery(sb.toString(), new BeanListHandler(CiMrSourceDO.class));
		
		Set<String> set=new HashSet<String>();
		for(CiMrSourceDO sourceDO:list){
			set.add(sourceDO.getId_mr());
		}
		int temp=0;
		Boolean isAdd = false;
		for(int i=0;i<set.size();i++){
			CiMrFpSugDTO sugDTO=new CiMrFpSugDTO();
			int n=0;
			isAdd = false;
			for(int m=temp;m<list.size();m++){
				if(m<=temp){ n=m;}
				else{ n=m-1;}
				String idMr = list.get(m).getId_mr();
				String idMr_old = list.get(n).getId_mr();
				if(idMr.equals(idMr_old)){
					String namePro = list.get(m).getName_pro();
					String name = namePro.substring(0,1).toUpperCase()+namePro.substring(1);
					String content = list.get(m).getContent();
					if(list.get(m).getContent()!=null){
						isAdd = true;
						if((list.get(m).getFg_ref()==FBoolean.TRUE)){	
							String name_id="id"+namePro.substring(namePro.indexOf("_"));
							String name_sd="sd"+namePro.substring(namePro.indexOf("_"));
							String id_name=name_id.substring(0,1).toUpperCase()+name_id.substring(1);
							String sd_name=name_sd.substring(0,1).toUpperCase()+name_sd.substring(1);
							String refcontent = list.get(m).getRefcontent();
							if(refcontent!=null&&refcontent.length()>0)
							{
							String[] contentArr=refcontent.split("\\|");					
							String value=contentArr[0].substring(contentArr[0].indexOf(":")+1);
							sugDTO.setAttrVal(id_name, value);
							String value2=contentArr[1].substring(contentArr[1].indexOf(":")+1);
							sugDTO.setAttrVal(sd_name, value2);
							}
							sugDTO.setAttrVal(name, content);
						}else{						
							if(namePro.equals("dt_start_sug") || namePro.equals("dt_end_sug")){															
							    String dateString = "";							
								if(content.contains("年"))
								{
									dateString = content.replace("年", "-").replace("月", "-").replace("日", " ").replace("  ", "");
								}else
								{
									dateString = content;
								}
								if(dateString.length()>1&&dateString.length()<=11)
								{
									if(!dateString.contains(" "))
									{
									dateString = dateString+" ";
									}
									dateString = dateString+"00:00:00";
								}														
								sugDTO.setAttrVal(name, new FDateTime(dateString)); 												
						}else{
							sugDTO.setAttrVal(name, content);
						}
					 }
				 }
	        }else{
	        	temp=n+1;   	
	        	break;
	        }
				n++;
		    }
			if(isAdd)
			{
			list2.add(sugDTO);
			}
	   }
	   return (CiMrFpSugDTO[]) list2.toArray(new CiMrFpSugDTO[0]);
	}	
}