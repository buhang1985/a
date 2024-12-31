package iih.bl.cg.s.bp.ip;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.ISysDictCodeConst;
import iih.bd.pp.i.IBdPpQryService;
import iih.bd.pp.srvspecround.d.SrvSpecRoundDO;
import iih.bd.pp.srvspecround.i.ISrvspecroundRService;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.dto.alwaysor.d.BlCgAlwaysOrCgInfoDTO;
import iih.bl.cg.dto.alwaysor.d.BlCgAlwaysOrCondDTO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.measdoc.d.MeasDocDO;

/**
 * 获取持续医嘱可退费记账信息
 * @author ly 2020/03/12
 *
 */
public class GetAlwaysOrCgInfoBP {
	
	/**
	 * 获取持续医嘱可退费记账信息
	 * @param condDtos
	 * @return
	 * @throws BizException
	 */
	public BlCgAlwaysOrCgInfoDTO[] exec(BlCgAlwaysOrCondDTO[] condDtos) throws BizException{
	
		if(ArrayUtil.isEmpty(condDtos))
			return null;
		
		List<String> orIdList = new ArrayList<String>();
		for (BlCgAlwaysOrCondDTO condDto : condDtos) {
			orIdList.add(condDto.getId_or());
		}
		
		//查询医嘱记账数据
		BlCgIpDO[] cgDos = this.getCgData(orIdList.toArray(new String[0]));
		Map<String, List<BlCgIpDO>> cgMap = new HashMap<String, List<BlCgIpDO>>();
		if(!ArrayUtil.isEmpty(cgDos)){
			for (BlCgIpDO blCgIpDO : cgDos) {
				
				List<BlCgIpDO> cgList = null;
				if(cgMap.containsKey(blCgIpDO.getId_orsrv())){
					cgList = cgMap.get(blCgIpDO.getId_orsrv());
				}else{
					cgList = new ArrayList<BlCgIpDO>();
					cgMap.put(blCgIpDO.getId_orsrv(), cgList);
				}
				cgList.add(blCgIpDO);
			}		
		}
		
		//查询服务及单位数据
		Map<String, MeasDocDO> measMap = this.getTimeUnitMap();
		Map<String, SrvSpecRoundDO> medSrvSpecRoundMap = this.getAllPrnSrvSpecRoundList();
		Map<String, List<OrdSrvDO>> orsrvMap = new HashMap<String, List<OrdSrvDO>>();
		OrdSrvDO[] orsrvDos = this.getCiData(orIdList.toArray(new String[0]));
		if(!ArrayUtil.isEmpty(orsrvDos)){
			for (OrdSrvDO ordSrvDO : orsrvDos) {
				
				List<OrdSrvDO> orsrvList = null;
				if(orsrvMap.containsKey(ordSrvDO.getId_or())){
					orsrvList = orsrvMap.get(ordSrvDO.getId_or());
				}else{
					orsrvList = new ArrayList<OrdSrvDO>();
					orsrvMap.put(ordSrvDO.getId_or(), orsrvList);
				}
				orsrvList.add(ordSrvDO);
			}
		}
		
		//计算需退数量
		List<BlCgAlwaysOrCgInfoDTO> orcgList = new ArrayList<BlCgAlwaysOrCgInfoDTO>();
		for (BlCgAlwaysOrCondDTO condDto : condDtos) {
			
			List<OrdSrvDO> orsrvList = orsrvMap.get(condDto.getId_or());
			if(ListUtil.isEmpty(orsrvList))
				continue;
			
			int secs = FDateTime.getSecondsBetween(condDto.getDt_sign(), condDto.getDt_end());
			if(secs <= 0)
				continue;
				
			// 毫秒数
			FDouble msec = new FDouble(secs).multiply(1000);
			
			for (OrdSrvDO ordSrvDO : orsrvList) {
				
				MeasDocDO timeUnitDO = measMap.get(ordSrvDO.getId_medu());
				FDouble quan = this.convertByUnit(timeUnitDO, msec);
				
				SrvSpecRoundDO srvSpecRoundDO = medSrvSpecRoundMap.get(ordSrvDO.getId_srv());
				if(srvSpecRoundDO != null){
					quan = this.calcSpecRoundQuan(quan, srvSpecRoundDO);
				}

				List<BlCgIpDO> blCgList = cgMap.get(ordSrvDO.getId_orsrv());
				
				BlCgAlwaysOrCgInfoDTO orCgDTO = new BlCgAlwaysOrCgInfoDTO();
				orCgDTO.setId_or(ordSrvDO.getId_or());
				orCgDTO.setId_ent(condDto.getId_ent());
				orCgDTO.setId_orsrv(ordSrvDO.getId_orsrv());
				
				if(ListUtil.isEmpty(blCgList)){
					orCgDTO.setRet_quan(FDouble.ZERO_DBL);
					orCgDTO.setId_cgips(null);
				}else{
					
					FDouble quanRet = quan;
					String cgIps = "";
					
					for (BlCgIpDO blCgIpDO : blCgList) {
						FDouble quanCg = blCgIpDO.getQuan().sub(blCgIpDO.getQuan_ret());
						if(quanRet.compareTo(quanCg) <0 ){
							cgIps += blCgIpDO.getId_cgip() + ",";
						}
						quanRet = quanRet.sub(quanCg);
					}
					
					if(StringUtil.isEmpty(cgIps)){
						orCgDTO.setRet_quan(FDouble.ZERO_DBL);
						orCgDTO.setId_cgips(null);
					}else{
						orCgDTO.setRet_quan(quanRet.abs());
						orCgDTO.setId_cgips(cgIps.substring(0, cgIps.length() - 1));
					}
				}
			}
		}
		return orcgList.toArray(new BlCgAlwaysOrCgInfoDTO[0]);
	}
	
	/**
	 * 查询记账数据
	 * @param orIds
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private BlCgIpDO[] getCgData(String[] orIds) throws BizException{
		
		DAFacade daf = new DAFacade();
		String sql = "select id_cgip,id_orsrv,quan,quan_ret from bl_cg_ip where  ";
		sql += "eu_direct = 1 and fg_refund = 'N' and ";
		sql += SqlUtils.getInSqlByIds("id_or", orIds);
		sql += " order by dt_cg desc ";
		
		List<BlCgIpDO> cgDOList = (List<BlCgIpDO>)daf.execQuery(sql, new BeanListHandler(BlCgIpDO.class));
		if(ListUtil.isEmpty(cgDOList))
			return null;
		
		return cgDOList.toArray(new BlCgIpDO[0]);
	}
	
	/**
	 * 获取时间相关单位
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private Map<String, MeasDocDO> getTimeUnitMap() throws BizException {
		Map<String, MeasDocDO> measDocDOMap = new HashMap<String, MeasDocDO>();
		String whereStr = "sd_oppdimen=?";
		SqlParam param = new SqlParam();
		param.addParam(ISysDictCodeConst.SD_OPPDIMEN_T);// 时间类型
		List<MeasDocDO> measDocDOLst = (List<MeasDocDO>) new DAFacade().findByCond(MeasDocDO.class, whereStr, param);
		if (!ListUtil.isEmpty(measDocDOLst)) {
			for (MeasDocDO measDocDO : measDocDOLst) {
				measDocDOMap.put(measDocDO.getId_measdoc(), measDocDO);
			}
		}
		return measDocDOMap;
	}
	
	/**
	 * 获取特殊取整方式
	 * @return
	 * @throws BizException
	 */
	private Map<String, SrvSpecRoundDO> getAllPrnSrvSpecRoundList() throws BizException {
		ISrvspecroundRService iSrvspecroundRService = ServiceFinder.find(ISrvspecroundRService.class);
		SrvSpecRoundDO[] srvSpecRoundDO_arr = iSrvspecroundRService.find("1=1", "", FBoolean.FALSE);
		Map<String, SrvSpecRoundDO> srvSpecRoundMap = new HashMap<String, SrvSpecRoundDO>();
		if (!ArrayUtil.isEmpty(srvSpecRoundDO_arr)) {
			for (SrvSpecRoundDO srvSpecRoundDO : srvSpecRoundDO_arr) {
				srvSpecRoundMap.put(srvSpecRoundDO.getId_srv(), srvSpecRoundDO);
			}
		}
		return srvSpecRoundMap;
	}

	/**
	 * 查询医嘱数据信息
	 * @param orIds
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private OrdSrvDO[] getCiData(String[] orIds) throws BizException{
		
		DAFacade daf = new DAFacade();
		String sql = "select id_or,id_orsrv,id_srv,id_medu from ci_or_srv ";
		sql += " where fg_bl = 'Y' and ";
		sql += SqlUtils.getInSqlByIds("id_or", orIds);
		
		List<OrdSrvDO> cisrvList = (List<OrdSrvDO>)daf.execQuery(sql, new BeanListHandler(BlCgIpDO.class));
		if(ListUtil.isEmpty(cisrvList))
			return null;
		
		return cisrvList.toArray(new OrdSrvDO[0]);
	}
	
	/**
	 * 计算数量
	 * @param srvUnitDO
	 * @param minSecs
	 * @return
	 */
	private FDouble convertByUnit(MeasDocDO srvUnitDO, FDouble minSecs) {
		if(minSecs==null || minSecs.doubleValue()<=0){
			return FDouble.ZERO_DBL;
		}
		FDouble factor = srvUnitDO.getScalefactor();// 单位换算系数
		FDouble quan = minSecs.div(factor);
		return quan;// 计算数量过程中不能舍弃小数
	}
	
	/**
	 * 计算特殊取整
	 * @param quan
	 * @param specRoundDO
	 * @return
	 * @throws BizException
	 */
	private FDouble calcSpecRoundQuan(FDouble quan,SrvSpecRoundDO specRoundDO) throws BizException{
		IBdPpQryService ppQryService = ServiceFinder.find(IBdPpQryService.class);
		return ppQryService.specRound(quan, specRoundDO);
	}
}
