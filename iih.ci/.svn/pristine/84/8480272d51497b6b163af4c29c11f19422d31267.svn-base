package iih.ci.ord.s.ems.ip.assi.base;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.ems.d.SrvMatchEmsParamDTO;
import iih.bd.srv.ems.d.SrvMatchEmsRstDTO;
import iih.bd.srv.ems.i.IEmsManagementService;
import iih.bd.srv.emsqry.d.EmsFunclassKVDTO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.common.EmsDriverInfo;
import iih.ci.ord.i.ems.ip.assi.cp.ICiCpMainService;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.i.meta.EmsSaveDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.cache.BDSrvInfoCache;
import iih.ci.ord.s.ems.ip.assi.cp.drugs.CpDrugsDriver;
import iih.ci.ord.s.ems.ip.assi.cp.herbs.CpHerbsDriver;
import iih.ci.ord.s.ems.ip.assi.cp.lis.CpLisDriver;
import iih.ci.ord.s.ems.ip.assi.cp.opr.CpOprDriver;
import iih.ci.ord.s.ems.ip.assi.cp.pathgy.CpPathgyDriver;
import iih.ci.ord.s.ems.ip.assi.cp.ris.CpRisDriver;
import iih.ci.ord.s.ems.ip.assi.cp.treat.CpTreatDriver;
import iih.ci.ord.s.ems.utils.ReflClassUtils;
import iih.hp.cp.docinfodto.d.DocSrvinfoDTO;
import iih.hp.cp.docinfodto.d.DocinfoDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.sf.core.util.ServiceFinder;

public class CiCpMainServiceImpl implements ICiCpMainService{
	
	private IEmsManagementService iemsmanagementservice ;

	@Override
	public EmsRstDTO[] save(CiEnContextDTO ctx, EmsSaveDTO[] szEms) throws BizException {
		// TODO Auto-generated method stub
		iemsmanagementservice = ServiceFinder.find(IEmsManagementService.class);
		EmsSaveDTO tpl = szEms[0];
		FArrayList drugList = tpl.getDocument();
		if (CiOrdUtils.isEmpty(drugList))
			return null;
		DocinfoDTO docinfo = (DocinfoDTO) drugList.get(0);
		FArrayList srvinfoList = docinfo.getRefeleitems();
		DocSrvinfoDTO srvinfo=(DocSrvinfoDTO)srvinfoList.get(0);
		FArrayList fa=new FArrayList();
		fa.add(srvinfo.getId_srv());
		MedSrvDO medSrvInfo = BDSrvInfoCache.GetBdSrvInfo(ctx, srvinfo.getId_srv());
		FMap medSrvMatchEmsMap=medSrvMatchEms(ctx, fa, medSrvInfo.getSd_srvtp());
		SrvMatchEmsRstDTO srvmatchemsrstdto = (SrvMatchEmsRstDTO) medSrvMatchEmsMap.get(medSrvInfo.getId_srv());
		EmsFunclassKVDTO driverInfo = iemsmanagementservice.getEmsFunclassKVDTO(srvmatchemsrstdto.getFuncclassstr());
		// 设置后台驱动描述
		EmsDriverInfo driver = new EmsDriverInfo();
		driver.setJsonDriver(srvmatchemsrstdto.getFuncclassstr());
		driver.setId_ems(srvmatchemsrstdto.getId_ems());
		tpl.setDriverInfo(driver);
		if (null != driverInfo ) {
			
			driver.setDll(driverInfo.getDll());
			driver.setEmsBackendDriver(driverInfo.getClasspath_jar());
 			driver.setEmsFrontDriver(driverInfo.getClasspath_dll());
			driver.setTmpl_Classpath_jar(driverInfo.getTmpl_Classpath_jar());			
			// 反射调用医疗单加载方法
		}
		if (medSrvInfo.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG)) {
		    return new CpDrugsDriver().save(ctx, szEms);
		}else if (medSrvInfo.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_LIS)) {
			return new CpLisDriver().save(ctx, szEms);
		}else if (medSrvInfo.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS)) {
			if(medSrvInfo.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS_BINGLI)) {
				//病理
				return new CpPathgyDriver().save(ctx, szEms);
			}else {
			   return new CpRisDriver().save(ctx, szEms);
			}
		}else  if (medSrvInfo.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)) {
			return new CpHerbsDriver().save(ctx, szEms);
		}else if(medSrvInfo.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_TREAT)) {
			return new CpTreatDriver().save(ctx, szEms);			
		}else if(medSrvInfo.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_OP)) {
			return new CpOprDriver().save(ctx, szEms);
		}
		//没有匹配到医疗单则返回空数组
		return new EmsRstDTO[] {};
	}
	
	/**
	 * 医疗单匹配
	 * @param ctx
	 * @param tpllist
	 * @return
	 * @throws BizException
	 */
	private FMap medSrvMatchEms(CiEnContextDTO ctx, FArrayList idSrvList, String sd_srvtp)
			throws BizException {
		List<SrvMatchEmsParamDTO> emslist = new ArrayList<SrvMatchEmsParamDTO>();
		if (!CiOrdUtils.isEmpty(idSrvList)) {
			for (Object object : idSrvList) {
				String id_srv = (String) object;
				SrvMatchEmsParamDTO srvmatchemsparamdto = assemblyEmsMatchInfo(ctx, id_srv, sd_srvtp);
				emslist.add(srvmatchemsparamdto);
			}
		}

		return iemsmanagementservice.medSrvMatchEms(emslist.toArray(new SrvMatchEmsParamDTO[] {}));
	}
	
	/**
	 * 拼装查询医疗单驱动的入参对象
	 * @param ctx
	 * @param tplItem
	 * @param isSet
	 * @return
	 */
	private SrvMatchEmsParamDTO assemblyEmsMatchInfo(CiEnContextDTO ctx, String id_srv, String sd_srvtp) {
		SrvMatchEmsParamDTO srvmatchemsparamdto = new SrvMatchEmsParamDTO();
		srvmatchemsparamdto.setCode_entp(ctx.getCode_entp());
		srvmatchemsparamdto.setDt_or(CiOrdAppUtils.getServerDateTime());
		srvmatchemsparamdto.setId_dept(ctx.getId_dep_or());
		srvmatchemsparamdto.setId_emp(ctx.getId_emp_or());
		srvmatchemsparamdto.setId_grp(ctx.getId_grp());
		srvmatchemsparamdto.setId_org(ctx.getId_org());
		srvmatchemsparamdto.setId_srv(id_srv);
		srvmatchemsparamdto.setSd_srvtp(sd_srvtp);
		srvmatchemsparamdto.setEmsappmode(0);
		return srvmatchemsparamdto;
	}


}
