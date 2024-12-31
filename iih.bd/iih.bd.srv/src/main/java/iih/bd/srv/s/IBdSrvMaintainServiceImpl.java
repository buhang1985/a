package iih.bd.srv.s;

import java.util.ArrayList;

import iih.bd.srv.dto.d.MedSrvPriDTO;
import iih.bd.srv.i.IBdSrvMaintainService;
import iih.bd.srv.medsrv.bf.SaveSrv;
import iih.bd.srv.medsrv.bf.UpdateSrvPriMdInfoBP;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.srv.medsrv.i.IMedsrvMDOCudService;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bd.srv.oth.d.BizCntDTO;
import iih.bd.srv.oth.d.MedSrvWordFreqDO;
import iih.bd.srv.s.bp.WordFreqStatisticInfoUpdateBP;
import iih.bd.srv.srvreact.d.SrvreactAggDO;
import iih.bd.srv.srvreact.s.bp.GetSrvReactData;
import iih.bd.srv.srvrtctl.d.SrvRtItmDO;
import iih.bd.srv.srvrtctl.d.SrvrtctlAggDO;
import iih.bd.srv.srvrtctl.i.ISrvrtctlCudService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

@Service(serviceInterfaces={IBdSrvMaintainService.class}, binding=Binding.JSONRPC)
public class IBdSrvMaintainServiceImpl implements  IBdSrvMaintainService{

	@Override
	public int  updateFgActive(String fg_active,String Id) throws BizException {
		// TODO Auto-generated method stub
		
		 String sql = "  update  bd_mrtpl set FG_ACTIVE ='"+fg_active+"' where   ID_MRTPL ='"+Id+"' ";
		 DAFacade cade = new DAFacade();
		 int i =  cade.execUpdate(sql);
		
		return i;
	}

	

	@Override
	public boolean updateSrvPriMdInfo(MedSrvPriDTO[] srvprimddto)
			throws BizException {
		UpdateSrvPriMdInfoBP bp=new UpdateSrvPriMdInfoBP();
		return bp.exec(srvprimddto);
	}



	@Override
	public void saveGroupReact(SrvreactAggDO aggDo) throws BizException {
		GetSrvReactData react=new GetSrvReactData();
		react.saveGroupReact(aggDo);		
	}
	@Override
	public void delGroupReact(SrvreactAggDO aggDo) throws BizException {
		GetSrvReactData react=new GetSrvReactData();
		react.delGroupReact(aggDo);		
	}



	@Override
	public SrvrtctlAggDO[] UpdateSrvFgrt(SrvrtctlAggDO srvrtctlAggDO) throws BizException {
		ArrayList<String> addList=new ArrayList<String>();
		ArrayList<String> delList=new ArrayList<String>();
	    SrvRtItmDO[] srvRtArr = srvrtctlAggDO.getSrvRtItmDO();
	    
	    if(srvRtArr!=null){
	    	for(SrvRtItmDO item:srvRtArr){
		    	if(item.getStatus() == DOStatus.NEW){
		    		System.out.println(item.getId_srv());
		    		addList.add(item.getId_srv());
		    	}else if(item.getStatus() == DOStatus.DELETED){
		    		System.out.println(item.getId_srv());
		    		delList.add(item.getId_srv());
		    	}
		    }
	    }
        
		//保存Agg
		Object obj = ServiceFinder.find(ISrvrtctlCudService.class);		
		SrvrtctlAggDO[] srvrtctlaggdos=null;
		if(srvrtctlAggDO.getParent().getStatus()==DOStatus.DELETED )
		{
			((ISrvrtctlCudService)obj).delete(new SrvrtctlAggDO[]{srvrtctlAggDO});	
		}
		else
		{
			srvrtctlaggdos=((ISrvrtctlCudService)obj).save(new SrvrtctlAggDO[]{srvrtctlAggDO});
		}
		
	    if(addList.size()==0 && delList.size()==0)
	    {
	    	return srvrtctlaggdos;
	    }
	    ArrayList<MedSrvDO> medSrvDOList=new ArrayList<MedSrvDO>();
	    
	    //查询服务的DO
	    Object obj1 = ServiceFinder.find(IMedsrvMDORService.class);
	    MedSrvDO[] medSrvDo=((IMedsrvMDORService)obj1).find(" 1=1 ", "", FBoolean.FALSE);

	    if(medSrvDo==null || medSrvDo.length==0)
	    {
	    	return srvrtctlaggdos;
	    }
	    
		String sql = " select id_srvrtitm from bd_srv_rt_itm ";
		ArrayList<SrvRtItmDO> allSrvRtItmDO = (ArrayList<SrvRtItmDO>)new DAFacade().execQuery(sql, new BeanListHandler(SrvRtItmDO.class));

	    //新增的服务开立权限
	    for(String additem:addList){
	    	for(MedSrvDO item:medSrvDo){
	    		if(additem.equals(item.getId_srv())){
//	    			item.setFg_rt(FBoolean.TRUE);
	    			item.setStatus(DOStatus.UPDATED);
	    			medSrvDOList.add(item);
	    			break;
	    		}
	    	}
	    }
	    
	    boolean delFlag=false;
	    boolean InDelFlag=true;
	    //删除了服务开立权限
	    for(String delitem:delList)
	    {
	    	delFlag=false;
	    	InDelFlag=true;
	    	//查看服务是否在其他受控组中,如果在其他受控组，则标志为FALSE
	    	for(SrvRtItmDO itemSrvRtItemDo:allSrvRtItmDO){
	    		if(delitem.equals(itemSrvRtItemDo.getId_srv())){	    			
	    			InDelFlag=false;
	    			break;
	    		}
	    	}
	    	
	    	//不在其他受控服务组,修改服务权限标志
	    	if(InDelFlag)
	    	{
	    		for(MedSrvDO item:medSrvDo){
	    			if(delitem.equals(item.getId_srv()))
	    			{
//	    				item.setFg_rt(FBoolean.FALSE);
	    				item.setStatus(DOStatus.UPDATED);
	    				
		    			medSrvDOList.add(item);
		    			delFlag=true;
		    			break;
	    			}
	    		}
	    		if(delFlag)
	    		{
	    			break;
	    		}
	    	}
	    }	    

	    //保存更新后的服务


		Object obj3 = ServiceFinder.find(IMedsrvMDOCudService.class);	
		MedSrvDO[] xx=((IMedsrvMDOCudService)obj3).save(medSrvDOList.toArray(new MedSrvDO[medSrvDOList.size()]));
		//saveService.save(updatList.toArray(new MedSrvDO[updatList.size()]));
		return srvrtctlaggdos;
	}



	@Override
	public boolean SaveMedSrv(MedsrvAggDO srvAggDO) throws BizException {
		SaveSrv save=new SaveSrv();
		return save.Save(srvAggDO);
	}



	@Override
	public void wordFreqStatisticInfoUpdate(MedSrvWordFreqDO wfpkdata,
			BizCntDTO[] bizcnts) throws BizException {
		WordFreqStatisticInfoUpdateBP bp=new WordFreqStatisticInfoUpdateBP();
		bp.exec(wfpkdata, bizcnts);
		
	}



	@Override
	public int updateFreqFgActive(String fg_active, String Id)
			throws BizException {
		// TODO Auto-generated method stub
		 String sql = "  update  bd_freq set FG_ACTIVE ='"+fg_active+"' where   id_freq ='"+Id+"' ";
		 DAFacade cade = new DAFacade();
		 int i =  cade.execUpdate(sql);
		
		return i;
	}

}
