package iih.en.pv.s.bp;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.srvdc.d.FixedChargePkgItmDO;
import iih.bd.srv.srvdc.d.SrvdcAggDO;
import iih.bd.srv.srvdc.i.ISrvdcRService;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.enfee.d.EnFixedFeeDO;
import iih.en.pv.enfee.d.EnFixedFeeItemDO;
import iih.en.pv.enfee.d.EnfixedfeeAggDO;
import iih.en.pv.enfee.dto.d.PatiFixedFeeLeftDTO;
import iih.en.pv.enfee.i.IEnFixedFeeItemDOCudService;
import iih.en.pv.enfee.i.IEnfixedfeeCudService;
import iih.en.pv.enfee.i.IEnfixedfeeMDOCudService;
import iih.en.pv.enfee.i.IEnfixedfeeRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 患者固定费用相关函数实现
 * @author liwq
 *
 */
public class GetFixedFeeInfoBP  {
	/**
	 * 根据病区id 查询该病区内所有患者得收费模式信息
	 * 收费模式 sd_dcg_mode=0表示继承科室模式 sdsd_dcg_mode=1表示患者专有模式
	 * @param wardId 患者所在病区id
	 * @return PatiFixedFeeLeftDTO类型
	 * @throws BizException
	 * @author liwq
	 */
     public PatiFixedFeeLeftDTO[] getFixedFeeModeInfo(String id_dept,String dicKey ,String cond) throws BizException{
    	 if (EnValidator.isEmpty(id_dept)) {
 			return null;
 		}
 		List<PatiFixedFeeLeftDTO> datas = null;
 		//1、查询病区下患者就诊信息以及收费模式
 		StringBuilder sql = new StringBuilder();
 		sql.append("SELECT DISTINCT ENT.ID_ENT,DCG.SD_DCG_MODE,ENT.NAME_PAT,IP.NAME_BED BED_NAME,IP.CODE_AMR_IP ");
 		sql.append("FROM ");
 		sql.append("EN_ENT ENT INNER JOIN EN_ENT_IP IP ON ENT.ID_ENT = IP.ID_ENT ");
 		sql.append("INNER JOIN EN_ENT_DCG DCG ON ENT.ID_ENT = DCG.ID_ENT ");
 		sql.append("WHERE ENT.FG_IP = 'Y' AND ");
 		sql.append("IP.CODE_AMR_IP IS NOT NULL AND ENT.ID_DEP_NUR = '").append(id_dept).append("' ");
 		if(dicKey.equals("0"))
 		{
 			sql.append(" AND (ENT.NAME_PAT LIKE '%").append(cond).append("%' or IP.NAME_BED LIKE '%").append(cond).append("%')");
 		}
 		else if(dicKey.equals("1")) {
 			sql.append(" AND ENT.NAME_PAT LIKE '%").append(cond).append("%'");
		}else if(dicKey.equals("2")){
			sql.append(" AND IP.NAME_BED LIKE '%").append(cond).append("%'");
		} 		
 		sql.append(" ORDER BY IP.NAME_BED");
 		FArrayList flist = AppFwUtil.getMapListWithDao(sql.toString());
 		if (null == flist || flist.size() == 0) {
 			return null;
 		}
 		
 		//2、返回数据患者就诊数据
 		datas = new ArrayList<PatiFixedFeeLeftDTO>();
 		for (int i = 0; i < flist.size(); i++) {
 			Map<String, Object> map = (Map<String, Object>) flist.get(i);
 			PatiFixedFeeLeftDTO dto = new PatiFixedFeeLeftDTO();
 			String key = "id_ent";
 			dto.setId_ent(map.get(key) == null ? null : map.get(key).toString());
 			key = "sd_dcg_mode";
 			dto.setSd_dcg_mode( map.get(key).toString().equals("1") ? FBoolean.TRUE : FBoolean.FALSE);
 			
 			key = "name_pat";
 			dto.setName_pat(map.get(key) == null ? null : map.get(key).toString()); 
 			key = "bed_name";
 			dto.setBed_name(map.get(key) == null ? null : ( map.get(key).toString() + "床" ) );
 			key = "code_amr_ip";
 			dto.setCode_amr_ip(map.get(key) == null ? null :  map.get(key).toString() );
 			datas.add(dto);
 		}
 		PatiFixedFeeLeftDTO[] dtoArr = datas.toArray(new PatiFixedFeeLeftDTO[] {});
 		
 		return dtoArr;
     }
     
     /**
      * 根据患者就诊id和收费模式  获取 科室或患者专有固定费用
      * @param idEnt
      * @param isMode
      * @return
      * @author liwq
      * @throws BizException
      */
     
  	public EnFixedFeeItemDO[] getFixedFeeItmInfo(String idEnt , FBoolean isMode,String idDepNur) throws BizException{
 		if (EnValidator.isEmpty(idEnt)) {
 			return null;
 		}
 		//1、获取患者固定费用明细
 		if(isMode.booleanValue()){
 			return getPatiInfo(idEnt, isMode);
 		}
 		else{ 	//2、获取科室固定费用明细		
 			return getDepFixedInfo(idEnt, isMode,idDepNur);
 		} 		
 	}

  	/**
  	 * 根据患者id_ent 获取该患者所在科室得固定费用
  	 * @param idEnt
  	 * @param isFalse
  	 * @return
  	 * @throws BizException
  	 */
  	@SuppressWarnings("null")
	private EnFixedFeeItemDO[] getDepFixedInfo(String idEnt,FBoolean isFalse,String idDepNur) throws BizException {
  		//1、获取患者所在的病区
		String idDepNurs = "%";
		idDepNurs +=	idDepNur; 
		idDepNurs += "%";
		List<String> allTmp = new ArrayList<String>();
		//2、根据病区id 查询处科室固定费用id
		StringBuilder sqlDC = new StringBuilder();
		sqlDC.append("SELECT ID_SRVDC FROM BD_SRV_DC WHERE ");
		sqlDC.append("FG_ACTIVE = ? ");
		sqlDC.append("AND ID_DEP LIKE ? ");
		SqlParam param = new SqlParam();
		param.addParam(FBoolean.TRUE);
		param.addParam(idDepNurs);
		List<String> flistTmp = (List<String>) new DAFacade().execQuery(sqlDC.toString(), param, new ColumnListHandler());
		if(!EnValidator.isEmpty(flistTmp)){
			for(String tmp : flistTmp){
				allTmp.add(tmp);
			}
		}
		//获取全院固定费用
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("SELECT ID_SRVDC FROM BD_SRV_DC WHERE ");
		stringBuilder.append("FG_ACTIVE = ? ");
		stringBuilder.append(" AND (ID_DEP = '~' OR ID_DEP IS NULL) ");
		stringBuilder.append(" AND SD_OWTP = ? ");
		SqlParam param2 = new SqlParam();
		param2.addParam(FBoolean.TRUE);
		param2.addParam(IBdSrvDictCodeConst.SD_OWTP_HOSPIAL);
		List<String> flistTmpAll = (List<String>) new DAFacade().execQuery(stringBuilder.toString(), param2, new ColumnListHandler());
		if(!EnValidator.isEmpty(flistTmpAll)){
			for(String tmp : flistTmpAll){
				allTmp.add(tmp);
			}
		}
		
		//3、获取科室所包含得固定费用包的ID
		String id_Srvdc = "'";
		for (int j = 0; j < allTmp.size(); j++) {
			id_Srvdc += allTmp.get(j).toString();
			if(allTmp.size()-1 != j)
				id_Srvdc += "','";					
		}
		id_Srvdc += "'";	
		//4、根据固定费用包ID 查询Agg
  		List<EnFixedFeeItemDO> datas = null;
  		ISrvdcRService iSrvdcRService = ServiceFinder.find(ISrvdcRService.class);
  		SrvdcAggDO[] srvdcAggDOArr = iSrvdcRService.find("id_srvdc in ("+id_Srvdc+")", "", FBoolean.FALSE);
  		
  		if(srvdcAggDOArr==null || srvdcAggDOArr.length==0)
		{
			return null;
		}
  		//5、返回科室固定费用明细
  		datas = new ArrayList<EnFixedFeeItemDO>();
 		for ( SrvdcAggDO srvdcAggDO : srvdcAggDOArr) 
 		{
 			FixedChargePkgItmDO[] fixedChargePkgItmDO = srvdcAggDO.getFixedChargePkgItmDO();
 			if(fixedChargePkgItmDO != null && fixedChargePkgItmDO.length != 0)
 			{
				for (int i = 0; i < fixedChargePkgItmDO.length; i++) {
					EnFixedFeeItemDO dto = new EnFixedFeeItemDO();
					String Id_srvdc = fixedChargePkgItmDO[i].getId_srvdc();
					String Id_srcdcitm = fixedChargePkgItmDO[i]
							.getId_srvdcitm();
					String Id_srv = fixedChargePkgItmDO[i].getId_srv();
					String Id_srv_code = fixedChargePkgItmDO[i].getSrv_code();
					String Id_srv_name = fixedChargePkgItmDO[i].getSrv_name();
					String Id_mm = fixedChargePkgItmDO[i].getId_mm();
					String Id_mm_code = fixedChargePkgItmDO[i].getMm_code();
					String Id_mm_name = fixedChargePkgItmDO[i].getMm_name();
					FDouble Quan = fixedChargePkgItmDO[i].getQuan();					
				
					String sqlUnit = " select b.id_unit_med id_unit, a.code Unit_code, a.name unit_name from bd_measdoc a right join  bd_srv b on a.id_measdoc = b.id_unit_med where b.id_srv = ? ";
					SqlParam param1 = new SqlParam();
		            param1.addParam(Id_srv);
					List<EnFixedFeeItemDO> list = (List<EnFixedFeeItemDO>) new DAFacade().execQuery(sqlUnit,param1,new BeanListHandler(EnFixedFeeItemDO.class));
					EnFixedFeeItemDO arr = list.get(0);
					String Id_unit = arr.getId_unit();
					String Unit_code = arr.getUnit_code();
					String Unit_name = arr.getUnit_name();

					dto.setId_entdcgitm(Id_srcdcitm);
					dto.setId_entdcg(Id_srvdc);					
					dto.setId_srv(Id_srv);
					dto.setId_srv_code(Id_srv_code);
					dto.setId_srv_name(Id_srv_name);
					dto.setId_mm(Id_mm);
					dto.setId_mm_code(Id_mm_code);
					dto.setId_mm_name(Id_mm_name);
					dto.setQuan(Quan);
					dto.setId_unit(Id_unit);
					dto.setUnit_code(Unit_code);
					dto.setUnit_name(Unit_name);
					dto.setFg_mm(fixedChargePkgItmDO[i].getFg_mm());
					datas.add(dto);

				}
 			}
 		}
 		EnFixedFeeItemDO[] dtoArr = datas.toArray(new EnFixedFeeItemDO[] {});
 		
 		return dtoArr;
  	}
  	/**
  	 * 获取患者专有固定费用明细
  	 * @param idEnt
  	 * @param isTrue
  	 * @return
  	 * @throws BizException 
  	 */
  	private EnFixedFeeItemDO[] getPatiInfo(String idEnt, FBoolean isTrue ) throws BizException  {
//  	
 		//1.查 AGG
		IEnfixedfeeRService iEnfixedfeeRService = ServiceFinder
				.find(IEnfixedfeeRService.class);
		EnfixedfeeAggDO[] enfixedfeeAggDOArr = iEnfixedfeeRService.find(
				" sd_dcg_mode = '1' and id_ent='" + idEnt + "'", "", FBoolean.TRUE);
		if (enfixedfeeAggDOArr == null || enfixedfeeAggDOArr.length == 0) {
			return null;
		}
		//2、返回患者固定费用明细
		EnFixedFeeItemDO[] enFixedFeeItemDO = enfixedfeeAggDOArr[0].getEnFixedFeeItemDO();
		if (EnValidator.isEmpty(enFixedFeeItemDO)) {
			EnFixedFeeItemDO enFixedFeeItem = new EnFixedFeeItemDO();
			String id_entdcg = enfixedfeeAggDOArr[0].getParentDO().getId_entdcg();
			enFixedFeeItem.setId_entdcg(id_entdcg);
			return new EnFixedFeeItemDO[]{enFixedFeeItem};
		}		
 		
		return enFixedFeeItemDO;
		
  	}
  	
  	/**
	 * 根据患者就诊id  将科室固定费用改为患者固定费用模式
	 * @param idEnt
	 * @return FBoolean
	 * @author liwq
	 * @throws BizException
	 */
  	public String changedPati(String idEnt,String idDepNur) throws BizException {
  		String fchangedSuccess = "";
		//1.查 AGG
		IEnfixedfeeRService iEnfixedfeeRService=ServiceFinder.find(IEnfixedfeeRService.class);
		EnfixedfeeAggDO[] enfixedfeeAggDOArr=iEnfixedfeeRService.find(" id_ent='"+idEnt+"'", "", FBoolean.TRUE);
		if(EnValidator.isEmpty(enfixedfeeAggDOArr))
		{
			fchangedSuccess = "未获取到该患者此次就诊的固定费用信息！";
			return fchangedSuccess;
		}
		//2.获得子表新数据 
		EnFixedFeeDO  enFixedFeeDO=enfixedfeeAggDOArr[0].getParentDO();
		enFixedFeeDO.setSd_dcg_mode(IEnDictCodeConst.SD_DCG_MODE_PAT);
		enFixedFeeDO.setId_dcg_mode(IEnDictCodeConst.ID_DCG_MODE_PAT);
		enFixedFeeDO.setStatus(DOStatus.UPDATED);
		//获取患者科室的固定费用
		EnFixedFeeItemDO[] fixedItm = getDepFixedInfo(idEnt,FBoolean.FALSE,idDepNur);
		if(!EnValidator.isEmpty(fixedItm))
		{
			for(EnFixedFeeItemDO enFixedFeeItemDO: fixedItm)
			{
				enFixedFeeItemDO.setId_entdcgitm(null);
				enFixedFeeItemDO.setId_entdcg(enFixedFeeDO.getId_entdcg());
				enFixedFeeItemDO.setStatus(DOStatus.NEW);
			}
		}		
		enfixedfeeAggDOArr[0].setParentDO(enFixedFeeDO);
		enfixedfeeAggDOArr[0].setEnFixedFeeItemDO(fixedItm);
		//3.保存
		IEnfixedfeeCudService iEnfixedfeeCudService1=ServiceFinder.find(IEnfixedfeeCudService.class);
		EnfixedfeeAggDO[] enfixedfeeAggDOArr1=iEnfixedfeeCudService1.save(enfixedfeeAggDOArr);
		if(EnValidator.isEmpty(enfixedfeeAggDOArr1))
		{
			fchangedSuccess = "保存该患者的固定费用信息失败！";
		}
  		return fchangedSuccess;
  	}

  	/**
	 * 根据患者就诊id  将患者专有模式切换为科室继承模式
	 * @param idEnt
	 * @return FBoolean
	 * @author liwq
	 * @throws BizException
	 */
  	public String changedDep(String idEnt) throws BizException {
  		String fchangedSuccess = "";  	
  		//1.查 AGG
  		IEnfixedfeeRService iEnfixedfeeRService=ServiceFinder.find(IEnfixedfeeRService.class);
  		EnfixedfeeAggDO[] enfixedfeeAggDOArr=iEnfixedfeeRService.find(" id_ent='"+idEnt+"'", "", FBoolean.TRUE);
  		if(EnValidator.isEmpty(enfixedfeeAggDOArr))
  		{
  			fchangedSuccess = "未获取到该患者此次就诊的固定费用信息！";
  			return fchangedSuccess;
  		}
  		EnFixedFeeDO  enFixedFeeDO = enfixedfeeAggDOArr[0].getParentDO();
  		enFixedFeeDO.setSd_dcg_mode(IEnDictCodeConst.SD_DCG_MODE_DEP);
  		enFixedFeeDO.setId_dcg_mode(IEnDictCodeConst.ID_DCG_MODE_DEP);
  		enFixedFeeDO.setStatus(DOStatus.UPDATED);
  	    //保存
  		IEnfixedfeeMDOCudService iCudService=ServiceFinder.find(IEnfixedfeeMDOCudService.class);
  		EnFixedFeeDO[] enfixedfeeDO = iCudService.save(new EnFixedFeeDO[]{enFixedFeeDO});
  		if(EnValidator.isEmpty(enfixedfeeDO))
  		{
  			fchangedSuccess = "保存该患者的固定费用信息失败！";
  			return fchangedSuccess;
  		}
  		//2.获取患者专有子表数据
  		EnFixedFeeItemDO[] enFixedFeeItemDOArr = enfixedfeeAggDOArr[0].getEnFixedFeeItemDO();
  		if(!EnValidator.isEmpty(enFixedFeeItemDOArr))
		{
  		    //3.逻辑删除子表数据
  	  		IEnFixedFeeItemDOCudService iEnFixedFeeItemDOCudService=ServiceFinder.find(IEnFixedFeeItemDOCudService.class);
  	  		for( int i = 0; i < enFixedFeeItemDOArr.length; i++)
  	  		{
  	  			String id_entdcg = enFixedFeeItemDOArr[i].getId_entdcgitm();
  	  			iEnFixedFeeItemDOCudService.logicDeleteById(id_entdcg);
  	  		}
		}
  		return fchangedSuccess;
  	}

  	/**
	 * 根据服务id_srv 判断是否是物品
	 * @param id_srv
	 * @return FBoolean
	 * @author liwq
	 * @throws BizException
	 */
	public FBoolean isSrvOrMm(String id_srv) throws BizException {
		FBoolean isOr = FBoolean.FALSE;
		String[] bdsrvFields={"Id_srv","fg_mm","id_unit_med","code","name"};
		DAFacade dafacade=new DAFacade();
		List<MedSrvDO> medSrvDOLst=(List<MedSrvDO>)dafacade.findByCond(MedSrvDO.class, " id_srv='"+id_srv+"'", bdsrvFields);
		if(medSrvDOLst==null || medSrvDOLst.size()==0)
		{
			return null;							
		}
		MedSrvDO medSrvDO=medSrvDOLst.toArray(new MedSrvDO[0])[0]; //主键查询，只有一行记录
		
		String fg_mm = medSrvDO.getFg_mm().toString();
		
		if(fg_mm.equals("Y"))
			isOr = FBoolean.TRUE;
		if(fg_mm.equals("N"))
			isOr = FBoolean.FALSE;
		return isOr;
	}
	
	/**
	 *  返回服务id和单位名称
	 * @param 
	 * @return EnFixedFeeItemDO[]
	 * @author liwq
	 * @throws BizException
	 */	
	public EnFixedFeeItemDO[] returnSrvUnitMap() throws BizException {
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ID_MEASDOC,NAME FROM BD_MEASDOC  ");
		FArrayList flist = AppFwUtil.getMapListWithDao(sql.toString());
 		if (null == flist || flist.size() == 0) {
 			return null;
 		}

 		List<EnFixedFeeItemDO> datas=new ArrayList<EnFixedFeeItemDO>();
 		
 		for(int i = 0 ; i < flist.size(); i++){
			Map<String, Object> map = (Map<String, Object>) flist.get(i);
			EnFixedFeeItemDO dto = new EnFixedFeeItemDO();

			String key = "id_measdoc";
			String id_unit = map.get(key).toString();
			key = "name";
			String unit_name = map.get(key).toString();

			dto.setId_unit(id_unit);
			dto.setUnit_name(unit_name);

			datas.add(dto);
 		}
 		
 		EnFixedFeeItemDO[] dtoArr = datas.toArray(new EnFixedFeeItemDO[] {});
		return dtoArr;
	}
  	
}
