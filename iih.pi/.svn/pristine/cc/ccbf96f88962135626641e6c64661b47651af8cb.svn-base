package iih.pi.reg.s.bp.listener;


import iih.pi.dic.pipatbbrms055dto.d.Pipatbbrms055dto;
import iih.pi.reg.patbbr.d.PiPatBbrDO;
import iih.pi.reg.patbbr.i.IPatbbrCudService;

import java.util.List;
import java.util.Map;

import xap.ip.event.DataOperationEvent;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.MapListHandler;
/**
 *  不良患者ms055
 * 
 * @author lm
 * @date 2017-05-12
 */
public class PiPatBbrEventListener implements IBusinessListener {

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
/*		Pipatbbrms055dto pi=new Pipatbbrms055dto();
		FArrayList2 list=new FArrayList2(); 
		BDCommonEvent dodo=new BDCommonEvent("insert","insert",list);
		 pi.setAction("insert");
		 pi.setName_pat("李");
		 pi.setIdcard("62282219850112004X");
		 pi.setSexcode("男");
		 pi.setCode_hp("112234503003");
		 list.append(pi);
		 pi=new Pipatbbrms055dto();
		 pi.setAction("insert");
		 pi.setName_pat("张");
		 pi.setIdcard("110101194112142528");
		 pi.setSexcode("女");
		 pi.setCode_hp("102037563008");
		 list.append(pi);
		 dodo.setNewObjs(new Object[]{list});
		validation(dodo);*/
		validation(event);
		
	}
	/**
	 * 验证
	 * 
	 * @param event
	 * @return
	 */
	private void validation(IBusinessEvent event)throws BizException  {
		//WsExcecuteResultEvent wsEvent = (WsExcecuteResultEvent)event;
		//BDCommonEvent wsEvent=(BDCommonEvent)event;
		DataOperationEvent wsEvent=(DataOperationEvent)event;
		//FArrayList2 resultList = (FArrayList2)wsEvent.getNewObjs()[0];
		FArrayList2 resultList = (FArrayList2) wsEvent.getUserObject();
		if(resultList == null || resultList.size() == 0)
			throw new BizException();
		//TODO
		//Pipatbbrms055dto[] list = (Pipatbbrms055dto[]) resultList.toArray(new Pipatbbrms055dto[resultList.size()]);
		
		StringBuffer sbInWhere = new StringBuffer();
		StringBuffer sbDelWhere = new StringBuffer();

		int i=0;
		int j=0;
		for(Object obj:resultList){
			if (obj == null || !(obj instanceof Pipatbbrms055dto)) continue;
			Pipatbbrms055dto result = (Pipatbbrms055dto)obj;
			//if (event.getEventType().equals("insert")) {
			  if (result.getAction().equals("insert")) {
				//新增
				if(i>0){
					sbInWhere.append(" or ");
				}
				sbInWhere.append("(b.no_hp='"+ result.getCode_hp() +"' and (a.id_code='"+ result.getIdcard()+"' or a.sd_idtp<>'01'))");
				i++;
			}else{
				//删除
				if(j>0){
					sbDelWhere.append(" or ");
				}				
				sbDelWhere.append("(b.no_hp='"+ result.getCode_hp() +"' and (a.id_code='"+ result.getIdcard()+"' or a.sd_idtp<>'01'))");
				j++;
			}
		}
		String  sql="";
		//新增
		if(sbInWhere.length()>0)
		{
		    sql=String.format("select a.id_pat,a.id_org,a.id_grp from pi_pat a inner join pi_pat_hp b on a.id_pat=b.id_pat where (%s) and a.id_pat not in(select id_pat from PI_PAT_BBR where fg_active='Y') ", sbInWhere.toString());
			@SuppressWarnings("unchecked")
			List<Map<String, Object>> reList = (List<Map<String, Object>>)new DAFacade()
			.execQuery(sql,new MapListHandler());
			 
			if (reList != null && reList.size() > 0) {
				 for(Map<String, Object> priObjMap : reList){
					 String id_pat = (String) priObjMap.get("id_pat");
					 String id_org = (String) priObjMap.get("id_org");
					 String id_grp = (String) priObjMap.get("id_grp");
					 PiPatBbrDO bbr = new PiPatBbrDO();
					 bbr.setId_pat(id_pat);
					 bbr.setId_org(id_org);
					 bbr.setId_grp(id_grp);
					 bbr.setId_bbrtp("1001Z7100000000FF1EJ");
					 bbr.setSd_bbrtp("00");
					 bbr.setDes_reason("爽约");
					 bbr.setFg_active(FBoolean.TRUE);
					 bbr.setDs(0);
					 //bbr.setCreatedby(id_pat);
					 IPatbbrCudService conditionRService = ServiceFinder
							.find(IPatbbrCudService.class);
					 conditionRService.insert(new PiPatBbrDO[]{bbr});
				  }  
			}
		}
		//删除 更新有效标志
		//id_bbrtp 取医保类型 缺个条件
		if(sbDelWhere.length()>0)
		{
			 sql=String.format("   select c.* from pi_pat a inner join pi_pat_hp b on a.id_pat=b.id_pat inner join PI_PAT_BBR c on a.id_pat=c.id_pat where (%s) and   c.fg_active='Y' ", sbDelWhere.toString());
			 @SuppressWarnings("unchecked")	
			 List<PiPatBbrDO> reListDel = (List<PiPatBbrDO>)new DAFacade().execQuery(sql,new BeanListHandler(PiPatBbrDO.class));
				if (!ListUtil.isEmpty(reListDel)) {
					for (PiPatBbrDO que : reListDel) {					
						que.setFg_active(FBoolean.FALSE);
						que.setStatus(DOStatus.UPDATED);
						IPatbbrCudService conditionRService = ServiceFinder
								.find(IPatbbrCudService.class);		
						conditionRService.update(new PiPatBbrDO[]{que});	
					}
				}	
		}
	}
	
}
