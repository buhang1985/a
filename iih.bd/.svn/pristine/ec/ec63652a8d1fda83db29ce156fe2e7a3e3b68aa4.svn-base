package iih.bd.srv.medsrv.bf;

import java.util.ArrayList;
import java.util.List;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.srv.medsrv.i.IMedsrvCudService;
import iih.bd.srv.srvreact.d.SrvReactItemDO;
import iih.bd.srv.srvreact.d.SrvreactAggDO;
import iih.bd.srv.srvreact.i.ISrvreactCudService;
import iih.bd.srv.srvreact.i.ISrvreactRService;
import iih.bd.srv.srvrtctl.d.SrvRtItmDO;
import iih.bd.srv.srvrtctl.i.ISrvrtctlCudService;
import iih.bd.srv.srvrtctl.i.ISrvrtctlRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class SaveSrv {
	/**
	 * 医疗服务保存
	 * @param srvAggDO
	 * @return
	 * @throws BizException
	 */
	public boolean Save(MedsrvAggDO srvAggDO) throws BizException{
		if(srvAggDO==null){
			return false;
		}
		
		IMedsrvCudService srvCudService=(IMedsrvCudService)ServiceFinder.find(IMedsrvCudService.class.getName());
		if(this.clearData(srvAggDO)!=null)
			srvAggDO=this.clearData(srvAggDO);
		srvCudService.save(new MedsrvAggDO[]{srvAggDO});
					
//		String react=srvAggDO.getParentDO().getSd_reactca();
		FBoolean fg_or=srvAggDO.getParentDO().getFg_or();		
		//互斥组
//		if(react!=null){
//			if(react.equals(IBdSrvDictCodeConst.SD_REACTCA_INGROUP)){
//				this.SaveReact(srvAggDO.getParentDO().getId_srv(),srvAggDO.getParentDO().getId_srvreact(),srvAggDO.getParentDO().getId_srvtp());
//			}
//		}
		//开立权限
		if(fg_or==FBoolean.TRUE){
			this.saveRtctl(srvAggDO.getParentDO());
		}
		return true;
	}

	/**
	 * 若服务项目选择了排斥组，将其存入组排斥表中
	 * @param id_srv
	 * @param id_group
	 * @throws BizException
	 */
	public void SaveReact(String id_srv,String Id_srvreact,String id_srvtp)throws BizException{
		ISrvreactCudService reactCudService=(ISrvreactCudService)ServiceFinder.find(ISrvreactCudService.class.getName());
		ISrvreactRService reactRService=(ISrvreactRService)ServiceFinder.find(ISrvreactRService.class.getName());
		SrvreactAggDO srvreact=reactRService.findById(Id_srvreact);
		if(srvreact == null){
			return;
		}
		SrvReactItemDO item=new SrvReactItemDO();
		item.setId_srv(id_srv);
		item.setId_srvreact(Id_srvreact);
		item.setId_srvtp(id_srvtp);
		item.setStatus(DOStatus.NEW);

		List<SrvReactItemDO> itemlist=new ArrayList<SrvReactItemDO>();
		for(SrvReactItemDO itemDO: srvreact.getSrvReactItemDO()){
			itemlist.add(itemDO);
		}
		itemlist.add(item);		
		srvreact.setSrvReactItemDO(itemlist.toArray(new SrvReactItemDO[]{}));
		srvreact.getParentDO().setStatus(DOStatus.UPDATED);
		reactCudService.save(new SrvreactAggDO[]{srvreact});
	}

	/**
	 * 开立权限保存
	 * @param srvDO
	 * @throws BizException
	 */
	public void saveRtctl(MedSrvDO srvDO) throws BizException{
		ISrvrtctlCudService reactCudService=(ISrvrtctlCudService)ServiceFinder.find(ISrvrtctlCudService.class.getName());
		ISrvrtctlRService reactRService=(ISrvrtctlRService)ServiceFinder.find(ISrvrtctlRService.class.getName());

//		SrvrtctlAggDO srvrtcl=reactRService.findById(srvDO.getId_srvrt());
//		if(srvrtcl == null){
//			return;
//		}
		SrvRtItmDO item=new SrvRtItmDO();
		item.setId_srv(srvDO.getId_srv());
//		item.setId_srvrt(srvDO.getId_srvrt());
//		item.setFg_ructr(srvDO.getFg_ructr());
//		item.setRules(srvDO.getRules());
		item.setStatus(DOStatus.NEW);

//		List<SrvRtItmDO> itemlist=new ArrayList<SrvRtItmDO>();
//		for(SrvRtItmDO itemDO: srvrtcl.getSrvRtItmDO()){
//			itemlist.add(itemDO);
//		}
//		itemlist.add(item);	
//		srvrtcl.setSrvRtItmDO(itemlist.toArray(new SrvRtItmDO[]{}));
//		srvrtcl.getParentDO().setStatus(DOStatus.UPDATED);
//		reactCudService.save(new SrvrtctlAggDO[]{srvrtcl});
	}

	/**
	 * 清除关掉Tab页的数据
	 * @param srvAggDO
	 * @return
	 */
	public MedsrvAggDO clearData(MedsrvAggDO srvAggDO ){
		if(srvAggDO==null)
			return null;
		MedSrvDO medsrvDO=srvAggDO.getParentDO();
		if(medsrvDO==null)
			return null;
		//服务套标识
		if(medsrvDO.getFg_set()==FBoolean.FALSE){
			srvAggDO.setMedSrvSetItemDO(null);
		}
		//物品标识
//		if(medsrvDO.getFg_mm()==FBoolean.FALSE){
//			srvAggDO.setMedSrvRelMmDO(null);
//		}
		//医疗单
//		if(medsrvDO.getFg_srvof()==FBoolean.FALSE){
//			srvAggDO.setMedSrvRelOfDO(null);
//		}
//		//评估单
//		if(medsrvDO.getFg_srvoe()==FBoolean.FALSE){
//			srvAggDO.setMedSrvRelOeDO(null);
//		}
//		//医疗记录
//		if(medsrvDO.getFg_mr_rel()==FBoolean.FALSE){
//			srvAggDO.setMedSrvRelMrDO(null);
//		}
//		//业务功能
//		if(medsrvDO.getFg_func_rel()==FBoolean.FALSE){
//			srvAggDO.setMedSrvrelFuncDO(null);
//		}
		return srvAggDO;
	}
}
