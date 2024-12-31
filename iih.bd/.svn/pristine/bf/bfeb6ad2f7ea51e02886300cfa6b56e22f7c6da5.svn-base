package iih.bd.srv.srvreact.s.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeTypeConst;
import iih.bd.srv.d.BdSrvQryDTO;
import iih.bd.srv.medsrv.d.BdMmDto;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDOCudService;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bd.srv.srvreact.d.SrvReactDO;
import iih.bd.srv.srvreact.d.SrvReactItemDO;
import iih.bd.srv.srvreact.d.SrvReactSrv;
import iih.bd.srv.srvreact.d.SrvreactAggDO;
import iih.bd.srv.srvreact.i.ISrvReactItemDOCudService;
import iih.bd.srv.srvreact.i.ISrvreactCudService;
import iih.bd.srv.srvreact.i.ISrvreactRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class GetSrvReactData implements IBdSrvDictCodeTypeConst,IBdSrvDictCodeConst {

	/**
	 * 服务互斥树的构造
	 * @return
	 * @throws BizException
	 */
	public BdSrvQryDTO[] srvreactTreeData() throws BizException {
		String sql ="select name, code as id ,null as id_parent from BD_UDIDOC "
				+ "where ID_UDIDOCLIST = '"+SD_REACTCA+"' and code<>'"+SD_REACTCA_NONE+"' "
				+ "union "
				+ "select name,ID_SRVREACT as id, '"+SD_REACTCA_INGROUP+"' as id_parent from BD_SRV_REACT where ds=0 and sd_reacttp='"+SD_REACTCA_INGROUP+"'";
		//				+ "union "
		//				+ "select name,ID_srv as id, '"+SD_REACTCA_ALL+"' as id_parent from BD_SRV where fg_active='Y' and fg_or='Y' and ds=0 and SD_REACTCA='"+SD_REACTCA_ALL+"'";
		List<BdSrvQryDTO> list= (List<BdSrvQryDTO>)new DAFacade().execQuery(sql, new BeanListHandler(BdSrvQryDTO.class));
		return list.toArray(new BdSrvQryDTO[0]);

	}

	/**
	 * 诊断标准分类树
	 * @return
	 * @throws BizException
	 */
	public BdSrvQryDTO[] diagcateatTreeData() throws BizException {
		String sql ="select t.Id_cdsystp id_cdsys, udi.name name_cdsys, t.id_cdsys as id, '' as id_parent,t.name,t.id_cdsys as Id_digastd,t.name as Name_digastdI,t.id_gradetp,t.sv from BD_CDSYS t left join bd_udidoc udi on udi.id_udidoc=t.Id_cdsystp where t.activestate='2'" 
				+" union all"
				+" select sys.Id_cdsystp id_cdsys, udi.name name_cdsys, t1.id_distdca as id,t1.id_cdsys as  id_parent,t1.name,t1.id_cdsys as Id_digastd,sys.name as Name_digastd, sys.id_gradetp,t1.sv from bd_di_stdca t1 inner join BD_CDSYS sys on t1.id_cdsys = sys.id_cdsys and sys.activestate='2' left join bd_udidoc udi on udi.id_udidoc=sys.Id_cdsystp where t1.id_parent is null"
				+" union all"
				+" select sys.Id_cdsystp id_cdsys, udi.name name_cdsys, t1.id_distdca as id,t1.id_parent,t1.name,t1.id_cdsys as Id_digastd,sys.name as Name_digastd, sys.id_gradetp,t1.sv from bd_di_stdca t1 inner join BD_CDSYS sys on t1.id_cdsys = sys.id_cdsys and sys.activestate='2' left join bd_udidoc udi on udi.id_udidoc=sys.Id_cdsystp where t1.id_parent is not  null";
		List<BdSrvQryDTO> list= (List<BdSrvQryDTO>)new DAFacade().execQuery(sql, new BeanListHandler(BdSrvQryDTO.class));
		return list.toArray(new BdSrvQryDTO[0]);
	}


	/**
	 * 查询所有全排斥
	 * @return
	 * @throws BizException
	 */
	public SrvReactSrv[] findSrv() throws BizException {
		String sql="select id_srv  from bd_srv where fg_or='Y' and sd_reactca='"+SD_REACTCA_ALL+"' and fg_active='Y' and ds=0";
		List<SrvReactSrv> list= (List<SrvReactSrv>)new DAFacade().execQuery(sql, new BeanListHandler(SrvReactSrv.class));
		return list.toArray(new SrvReactSrv[0]);		
	} 
	/**
	 * 查询单个服务
	 * @param id
	 * @return
	 * @throws BizException
	 */
	public SrvReactSrv[] findById(String id) throws BizException {
		String sql="select id_srv,code,id_srvtp,name from bd_srv where id_srv='"+id+"'";
		List<SrvReactSrv> list= (List<SrvReactSrv>)new DAFacade().execQuery(sql, new BeanListHandler(SrvReactSrv.class));
		return list.toArray(new SrvReactSrv[0]);		
	} 
	/**
	 * 查询服务项目所在排斥组
	 * @param id
	 * @return
	 * @throws BizException
	 */
	public SrvReactDO[] findGroup(String id) throws BizException{

		String sql="select name from bd_srv_react a,bd_srv_react_itm b where a.id_srvreact=b.id_srvreact and b.id_srv='"+id+"' and a.ds='0'";
		List<SrvReactDO> list=(List<SrvReactDO>)new DAFacade().execQuery(sql, new BeanListHandler(SrvReactDO.class));
		return list.toArray(new SrvReactDO[0]);
	}

	private IMedsrvMDOCudService saveService = (IMedsrvMDOCudService)ServiceFinder.find(IMedsrvMDOCudService.class);

	private ISrvreactCudService reactService=(ISrvreactCudService)ServiceFinder.find(ISrvreactCudService.class);
	private ISrvreactRService findService=(ISrvreactRService)ServiceFinder.find(ISrvreactRService.class);
	private ISrvReactItemDOCudService itemService=(ISrvReactItemDOCudService)ServiceFinder.find(ISrvReactItemDOCudService.class);

	/**
	 * 组排斥的保存
	 */
	public void saveGroupReact(SrvreactAggDO aggDo)throws BizException{


		List<SrvReactItemDO> delList =new ArrayList<SrvReactItemDO>();
		SrvreactAggDO[] aggDos=this.findService.find(" a0.sd_reacttp = '"+SD_REACTCA_ALL+"'", null, FBoolean.FALSE);
		if(aggDos.length!=0){
			Map<String,SrvReactItemDO> itemMap=new HashMap<String,SrvReactItemDO>();
			SrvReactItemDO[] allitems=aggDos[0].getSrvReactItemDO();
			for(SrvReactItemDO item : allitems){
				itemMap.put(item.getId_srv(), item);
			}
			SrvReactItemDO[] items=aggDo.getSrvReactItemDO();
			if(items!=null){
				for(SrvReactItemDO item : items){
					if(itemMap.containsKey(item.getId_srv())){
						SrvReactItemDO itdo=itemMap.get(item.getId_srv());
						delList.add(itemMap.get(item.getId_srv()));
					}
				}	
			}
		}
		//		saveService.save(updatList.toArray(new MedSrvDO[updatList.size()]));
		if(aggDo.getParentDO().getStatus()==DOStatus.NEW){
			aggDo.getParentDO().setSd_reacttp(SD_REACTCA_INGROUP);
			aggDo.getParentDO().setId_reacttp(ID_REACTCA_INGROUP);
		}
		reactService.save(new SrvreactAggDO[]{aggDo});
		if(delList.size()>0){
			itemService.delete(delList.toArray(new SrvReactItemDO[0] ));
		}
	}

	/**
	 * 组排斥的删除
	 * @param aggDo
	 * @throws BizException
	 */
	public void delGroupReact(SrvreactAggDO aggDo) throws BizException{
		aggDo.getParentDO().setStatus(DOStatus.DELETED);
		//		List<MedSrvDO> updatList = this.udateList(aggDo);
		//		saveService.save(updatList.toArray(new MedSrvDO[updatList.size()]));
		reactService.delete(new SrvreactAggDO[]{aggDo});
	}
	/**
	 * 获得需要修改的医疗服务项目集合
	 * @param aggDo
	 * @return
	 * @throws BizException
	 */
	public List<MedSrvDO> udateList(SrvreactAggDO aggDo) throws BizException{

		IMedsrvMDORService srvService = (IMedsrvMDORService)ServiceFinder.find(IMedsrvMDORService.class);
		MedSrvDO srvDo[]=srvService.find(" a0.fg_or='Y' and a0.fg_active='Y'", null, FBoolean.FALSE);

		Map<String,MedSrvDO> map=new HashMap<String,MedSrvDO>();

		String sql="select id_srv from bd_srv_react_itm where ds=0";
		List<SrvReactItemDO> list=(List<SrvReactItemDO>)new DAFacade().execQuery(sql, new BeanListHandler(SrvReactItemDO.class));
		Map<String,Integer> srvidMap=new HashMap<String,Integer>();
		for(SrvReactItemDO itemDo:list){
			if(srvidMap.get(itemDo.getId_srv()) == null)
			{
				srvidMap.put(itemDo.getId_srv(),1);
			}else{
				srvidMap.put(itemDo.getId_srv(), srvidMap.get(itemDo.getId_srv()) + 1);
			}
		}


		List<MedSrvDO> updatList=new ArrayList<MedSrvDO>();
		for(MedSrvDO medsrvDO:srvDo){
			map.put(medsrvDO.getId_srv(), medsrvDO);
		}

		SrvReactItemDO[] reactItem=aggDo.getSrvReactItemDO();
		if(aggDo.getParentDO().getStatus()==DOStatus.DELETED){
			for(SrvReactItemDO item:reactItem)
			{
				if(srvidMap.get(item.getId_srv())==1){
					MedSrvDO mdesrv=map.get(item.getId_srv());
					//					mdesrv.setSd_reactca(SD_REACTCA_NONE);
					mdesrv.setStatus(DOStatus.UPDATED);
					updatList.add(mdesrv);	
				}
			}
		}else{
			for(SrvReactItemDO item:reactItem)
			{

				if(item.getStatus()==DOStatus.NEW){
					MedSrvDO mdesrv=map.get(item.getId_srv());
					//					mdesrv.setSd_reactca(SD_REACTCA_INGROUP);
					mdesrv.setStatus(DOStatus.UPDATED);
					//					aggDo.getParentDO().setStatus(DOStatus.UPDATED);
					updatList.add(mdesrv);
				}
				if(item.getStatus()==DOStatus.DELETED){
					if(srvidMap.get(item.getId_srv())==1){
						MedSrvDO mdesrv=map.get(item.getId_srv());
						//						mdesrv.setSd_reactca(SD_REACTCA_NONE);
						mdesrv.setStatus(DOStatus.UPDATED);
						updatList.add(mdesrv);					
					}
				}
			}
		}
		return updatList;
	}


	/*
	 * 服务关联物品查询
	 */
	public BdMmDto[] getBdMmData(String id) throws BizException {
		String sql =
				"select t1.name mm_name, t3.name dep_name,t1.spec,t4.name as sup_name\n" +
						"  from bd_mm t1\n" + 
						"  left join BD_MM_CTR t2\n" + 
						"    on t1.id_mm = t2.id_mm\n" + 
						"  left join bd_dep t3\n" + 
						"    on t2.id_dep = t3.id_dep\n" + 
						"left join BD_SUP t4\n" +
						"   on t1.id_sup = t4.id_sup"+
						" where t1.id_srv = '"+id+"' and t1.fg_active='Y'";

		List<BdMmDto> list= (List<BdMmDto>)new DAFacade().execQuery(sql, new BeanListHandler(BdMmDto.class));
		return list.toArray(new BdMmDto[0]);

	}
}
