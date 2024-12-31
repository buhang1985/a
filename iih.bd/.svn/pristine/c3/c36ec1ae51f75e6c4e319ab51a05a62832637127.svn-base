package iih.bd.mm.meterial.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.mm.meterial.d.MeterialAggDO;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.d.desc.MeterialDODesc;
import iih.bd.mm.meterial.i.IMeterialCudService;
import iih.bd.mm.meterial.i.IMeterialExtCudService;
import iih.bd.mm.meterial.i.IMeterialMDORService;
import iih.bd.mm.meterial.i.IMeterialRService;
import iih.bd.mm.srvprirel.d.MmSrvPriRelDO;
import iih.bd.mm.srvprirel.i.ISrvprirelCudService;
import iih.bd.mm.srvprirel.i.ISrvprirelRService;
import iih.bd.pp.baseprisrv.d.BaseprisrvAggDO;
import iih.bd.pp.baseprisrv.d.PriSrvDO;

import iih.bd.pp.baseprisrv.d.SrvPriDO;
import iih.bd.pp.baseprisrv.i.IBaseprisrvCudService;
import iih.bd.pp.baseprisrv.i.IBaseprisrvMDORService;
import iih.bd.pp.baseprisrv.i.IBaseprisrvRService;
import iih.bd.pp.baseprisrv.i.ISrvPriDORService;
import iih.bd.pp.prisrv.i.IPrisrvRService;
import iih.bd.pp.service.i.IPriMaintainService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.srv.medsrv.i.IMedsrvCudService;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bd.srv.medsrv.i.IMedsrvRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;

/**
 * 医疗物品AggDO数据CRUD服务实现
 */
public class MeterialExtCrudServiceImpl extends BaseAggService<MeterialAggDO, MeterialDO>
implements IMeterialExtCudService, IMeterialRService {

	public MeterialExtCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(MeterialDODesc.class), IAppFwTempTbl.tmp_iaw_22.name());
	}

	@Override
	public MeterialAggDO saveMMInfoSrvPri(MeterialAggDO aggdo, MedSrvDO srvdo, PriSrvDO medPriSrvDO,
			SrvPriDO[] srvPriDOArr) throws BizException {

		//保存物品服务
		IMedsrvCudService medSrv = ServiceFinder.find(IMedsrvCudService.class);
		MedsrvAggDO srvAggdo = new MedsrvAggDO();
		srvdo.setId_grp(aggdo.getParentDO().getId_grp());
		srvdo.setId_org(aggdo.getParentDO().getId_org());
		medPriSrvDO.setId_grp(srvdo.getId_grp());
		medPriSrvDO.setId_org(srvdo.getId_org());
		for(SrvPriDO pdo :srvPriDOArr)
		{
			pdo.setId_grp(srvdo.getId_grp());
			pdo.setId_org(srvdo.getId_org());
		}
		srvdo.setPri(srvPriDOArr[0].getPrice());
		aggdo.getParentDO().setPrice(srvdo.getPri());
		srvAggdo.setParentDO(srvdo);
		MedsrvAggDO[] srvAggdoed =  medSrv.save(new MedsrvAggDO[]{srvAggdo});
		//保存物品及价表
		//IPriMaintainService priSrv = ServiceFinder.find(IPriMaintainService.class);
		//MedSrvDO medPriSrvDOed = priSrv.saveMedSrvPrice(medPriSrvDO, priSrvDOArr);

		BaseprisrvAggDO aggDO = new BaseprisrvAggDO();
		aggDO.setParentDO(medPriSrvDO);
		aggDO.setSrvPriDO(srvPriDOArr);


		IBaseprisrvCudService basePriSrv =  ServiceFinder.find(IBaseprisrvCudService.class);
		BaseprisrvAggDO[] aggs = basePriSrv.save(new BaseprisrvAggDO[]{aggDO});		
		aggdo.getParentDO().setId_srv(srvAggdoed[0].getPrimaryKey());//回写物品目录到物品基本信息表
		String Id_srvpri = aggs[0].getParentDO().getId_srv();//价格服务主键
		aggdo.getParentDO().setId_srvpri(Id_srvpri);//Id_srvpri 是计算列 不存到数据库
		//保存物品基本信息
		IMeterialCudService mmSrv = ServiceFinder.find(IMeterialCudService.class);
		int doStatus = aggdo.getParentDO().getStatus();
		MeterialAggDO[] aggdoed =  mmSrv.save(new MeterialAggDO[]{aggdo});
		
		ISrvprirelRService srvR = ServiceFinder.find(ISrvprirelRService.class);
		
		MmSrvPriRelDO[] priRelDOS = null;
		if(doStatus != DOStatus.NEW)	
		{
			priRelDOS = srvR.find(" id_mm = '"+aggdo.getPrimaryKey()+"' ", null, FBoolean.FALSE);
		}
		//新建的物品或没有维护过关系的物品		
		if(priRelDOS==null || priRelDOS.length<1)
		{//新增的直接插入关系维护
			ISrvprirelCudService srvRel = ServiceFinder.find(ISrvprirelCudService.class);
			MmSrvPriRelDO priRel = new MmSrvPriRelDO();
			priRel.setId_mm(aggdoed[0].getPrimaryKey());//基本信息主键
			priRel.setId_srvmm(srvAggdoed[0].getPrimaryKey());//物品服务主键
			priRel.setId_srvpri(Id_srvpri);//价格服务主键
			MmSrvPriRelDO[] priRels = new MmSrvPriRelDO[]{priRel};//物品价格关系
			srvRel.insert(priRels);
		}
		
		return aggdoed[0];
	}

	@Override
	public void delMMInfoSrvPri(String[] idMMs) throws BizException {

		if(idMMs==null || idMMs.length<1)
		{
			throw new BizException("传入物品ID为空。");
		}
		StringBuffer IdMMs = new StringBuffer();;
		for(String idMM:idMMs)
		{
			IdMMs.append("'"+idMM+"',");
		}
		String strIdmms = IdMMs.toString().substring(0,IdMMs.toString().length()-1);
		ISrvprirelRService relSrv = ServiceFinder.find(ISrvprirelRService.class);
		MmSrvPriRelDO[] priRels = relSrv.find(" id_mm in ("+strIdmms+") ", null, FBoolean.FALSE);
		//删除关系表
		ISrvprirelCudService relSrvCud = ServiceFinder.find(ISrvprirelCudService.class);
		relSrvCud.delete(priRels);
		/*
		if(priRels!=null && priRels.length>0)
		{
			List<MeterialAggDO> mmList= new ArrayList<MeterialAggDO>();
			List<MedsrvAggDO> srvList= new ArrayList<MedsrvAggDO>();
			for(MmSrvPriRelDO priRel:priRels)
			{
				//删除物品基本信息

				IMeterialRService mmRSrv= ServiceFinder.find(IMeterialRService.class);
				MeterialAggDO mmAggDO =  mmRSrv.findById(priRel.getId_mm());
				if(mmAggDO!=null)
				{
					mmList.add(mmAggDO);
				}				

				//删除物品服务

				IMedsrvRService medRSrv = ServiceFinder.find(IMedsrvRService.class);
				MedsrvAggDO ssAggDO = medRSrv.findById(priRel.getId_srvmm());
				if(ssAggDO!=null)
				{
					srvList.add(ssAggDO);
				}

				//删除物品及价表
				IPriMaintainService priSrv = ServiceFinder.find(IPriMaintainService.class);
				MedsrvAggDO priAggDO = medRSrv.findById(priRel.getId_srvpri());
				if(priAggDO!=null)
				{
					priSrv.deleteMedSrvAndPrice(priAggDO.getParentDO());
				}
				
			}
			IMeterialCudService mmSrv = ServiceFinder.find(IMeterialCudService.class);
			//删除物品基本信息
			mmSrv.delete(mmList.toArray(new MeterialAggDO[mmList.size()]));
			IMedsrvCudService medRSrv = ServiceFinder.find(IMedsrvCudService.class);
			//删除物品服务
			medRSrv.delete(srvList.toArray(new MedsrvAggDO[srvList.size()]));
			//删除关系表
			ISrvprirelCudService relSrvCud = ServiceFinder.find(ISrvprirelCudService.class);
			relSrvCud.delete(priRels);

		}*/
		
		List<MeterialAggDO> mmList= new ArrayList<MeterialAggDO>();
		IMeterialMDORService mmRSrv= ServiceFinder.find(IMeterialMDORService.class);
		MeterialDO[]  mmDO = mmRSrv.findByBIds(idMMs, FBoolean.FALSE);
		if(mmDO!=null && mmDO.length>0)
		{
			IMeterialCudService mmSrv = ServiceFinder.find(IMeterialCudService.class);
			//删除物品基本信息
			mmSrv.deleteByParentDO(mmDO);;
			String aa= "";
		}
		
	}

	@Override
	public FMap2 getMcAllByMmID(String id_mm) throws BizException{
		FMap2 map = new FMap2();
		ISrvprirelRService srvRel = ServiceFinder.find(ISrvprirelRService.class);
		
			MmSrvPriRelDO[] prirel = srvRel.find(" id_mm = '"+id_mm+"' ", null, FBoolean.FALSE);
			if(prirel==null || prirel.length<1)
			{
				map.put("mmsrv", null);
				map.put("prisrv", null);
				map.put("pri", null);
				map.put("msg", "尚未维护耗材月价表关系！");
				return map;
			}

			IMedsrvMDORService medSrv = ServiceFinder.find(IMedsrvMDORService.class);
			MedSrvDO  mmSrvDO  = medSrv.findById(prirel[0].getId_srvmm());
			IBaseprisrvRService priceSrv = ServiceFinder.find(IBaseprisrvRService.class);
			BaseprisrvAggDO priSrvAggDo = priceSrv.findById(prirel[0].getId_srvpri());
			map.put("mmsrv", mmSrvDO);
			map.put("prisrv", priSrvAggDo.getParentDO());
			ISrvPriDORService priSrv = ServiceFinder.find(ISrvPriDORService.class);
			SrvPriDO[]  prisDO = priSrv.find(" Id_srv ='"+prirel[0].getId_srvpri()+"' and FG_ACTIVE = 'Y' ", null, FBoolean.FALSE);
			if(prisDO!=null && prisDO.length>0)
			{
				map.put("pri", prisDO[0]);
			}else{
				map.put("pri", null);
			}
			
		
		
		return map;
	}


}
