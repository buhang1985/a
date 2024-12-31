package iih.bd.srv.s.bp.iemsg;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.srv.iemsg.d.IELisContpRelDict;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.srv.medsrv.i.IMedsrvCudService;
import iih.bd.srv.medsrv.i.IMedsrvRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocRService;

/**
 * 集成平台Lis项目与容器关系处理
 * @author liu_xiaoying
 *
 */
public class SetIEMsgInfo4LisContpRelBP {

	public boolean exec(IELisContpRelDict[] dtos) throws BizException{
		StringBuffer liscods=new StringBuffer();
		Map<String,String> liscontpmap=new HashMap<String,String>();
		for(IELisContpRelDict dto:dtos){
			liscods.append("'"+dto.getCode()+"',");
			liscontpmap.put(dto.getCode(), dto.getContainercode());
		}
		return setMsgInfo2Srv(liscods.toString(),liscontpmap);
	}
	
	private boolean setMsgInfo2Srv(String liscods,Map<String,String> liscontpmap) throws BizException{
		List<MedsrvAggDO> medsrvs=findMedsrvByCode(liscods,liscontpmap);
		return saveMedsrv(medsrvs.toArray(new MedsrvAggDO[medsrvs.size()]));
	}
	/**
	 * 根据Lis编码查询aggdo
	 * @param strcodes
	 * @return
	 * @throws BizException
	 */
	private List<MedsrvAggDO> findMedsrvByCode(String strcodes,Map<String,String> liscontpmap) throws BizException{
		IMedsrvRService service=ServiceFinder.find(IMedsrvRService.class);
		String wherestr=" a0.code_rel5 in ("+strcodes.substring(0, strcodes.length()-1)+")";
		MedsrvAggDO[] aggdos= service.find(wherestr, null, FBoolean.FALSE);
		
		Map<String,String> lissrvmap=new HashMap<String,String>();
		List<String> idsrvs=new ArrayList<String>();
		List<MedsrvAggDO> agglist=new ArrayList<MedsrvAggDO>();
		Map<String,String> udidocmap=findUdi();
		//找出服务套
		for(MedsrvAggDO aggdo:aggdos){
			if(aggdo.getParentDO().getFg_set()==FBoolean.TRUE){
				for(MedSrvSetItemDO itemdo:aggdo.getMedSrvSetItemDO()){
					idsrvs.add(itemdo.getId_srv_itm());
					lissrvmap.put(itemdo.getId_srv_itm(), aggdo.getParentDO().getCode_rel5());
				}
			}else{
				agglist.add(aggdo);
			}
		}
		//查询服务套内项目
		if(idsrvs.size()>0){
			MedsrvAggDO[] srvaggdos= service.findByIds(idsrvs.toArray(new String[idsrvs.size()]), FBoolean.FALSE);
			for(MedsrvAggDO agg:srvaggdos){
				agglist.add(agg);
			}
		}
		//修改容器类型
		if(agglist.size()>0){
			for(MedsrvAggDO agg:agglist){
				String liscode="";
				if(lissrvmap.containsKey(agg.getParentDO().getId_srv())){
					liscode=lissrvmap.get(agg.getParentDO().getId_srv());
				}else{
					liscode=agg.getParentDO().getCode_rel5();
				}
				if(liscode.length()>0){
					if(liscontpmap.containsKey(liscode)){
						agg.getMedSrvLisDO()[0].setSd_contp(liscontpmap.get(liscode));
						agg.getMedSrvLisDO()[0].setId_contp(udidocmap.get(liscontpmap.get(liscode)));
						agg.getMedSrvLisDO()[0].setStatus(DOStatus.UPDATED);
						agg.getParentDO().setStatus(DOStatus.UPDATED);
					}
				}
			}
		}
		return agglist;
	}
	/**
	 * 保存服务项目
	 * @param medsrvs
	 * @return
	 * @throws BizException
	 */
	private boolean saveMedsrv(MedsrvAggDO[] medsrvs) throws BizException{
		IMedsrvCudService service=ServiceFinder.find(IMedsrvCudService.class);
		MedsrvAggDO[] result= service.save(medsrvs);
		if(result.length==0)return false;
		return true;
	}
	
	private Map<String,String> findUdi() throws BizException{
		Map<String,String> udidocmap=new HashMap<String,String>();
		IUdidocRService service=ServiceFinder.find(IUdidocRService.class);
		UdidocDO[] udidoclist=service.find("bd_udidoc.id_udidoclist='0001ZZ200000000000CS'and bd_udidoc.code like 'AFD%'", null,null);
		for(UdidocDO udido:udidoclist){
			udidocmap.put(udido.getCode(), udido.getId_udidoc());
		}
		return udidocmap;
	}

}
