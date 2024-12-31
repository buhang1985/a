package iih.ci.event.ord.bps.revert.op.logicbp;

import java.util.List;
import java.util.Map;

import iih.ci.event.ord.bps.revert.op.query.OpBtRevertCheckInfoQuery;
import iih.ci.event.ord.bps.revert.op.query.OpBtRevertEntInfoQuery;
import iih.ci.event.ord.bps.zcommon.parambp.CommonParamBP;
import iih.ci.event.ord.utils.OrdEventFireDTO;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.iemsg.d.IEOpBtCdLisItmDTO;
import iih.ci.ord.iemsg.d.IEOpBtDemandDTO;
import iih.ci.ord.iemsg.d.IEOpBtDiagDTO;
import iih.ci.ord.iemsg.d.IEOpBtOrEnDTO;
import iih.ci.ord.iemsg.d.IEOpBtStrLisItmDTO;
import iih.en.pv.out.d.EntOpVitalSignsDTO;
import iih.en.pv.out.i.IEn4CiQryService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
/**
 * 门诊撤回 备血逻辑处理BS008
 * @author F
 *
 * @date 2019年10月10日上午11:17:20
 *
 * @classpath iih.ci.event.ord.bps.revert.op.logicbp.OpBtRevertLogicDealWithBP
 */
public class OpBtRevertLogicDealWithBP extends CommonParamBP{

	private static String CD = "2";//枚举
	private static String ST = "1";//字符串
	
	private static String mode_bt ="@@@@ZZ2000000000007X";//预定输血方式 字典
	/**
	 * 生成集成平台备血申请服务数据信息
	 * （门诊）
	 * @param id_ors  医嘱id串
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public IEOpBtOrEnDTO[] exec(OrdEventFireDTO firedto) throws BizException{
		//有效性校验
		if(OrdEventUtil.isEmpty(firedto.getIdors()))return null;
		
		//获得备血就诊申请数据信息集合
		IEOpBtOrEnDTO[] rtndtos=getIEOpBtOrEnDTOs(firedto.getIdors());
		//检验项目 CD类--枚举
		FArrayList2 iebtcdlisitms = new FArrayList2();
		//检验项目字符串类
		FArrayList2 iebtstrlisitms = new FArrayList2();
		//血液要求集合
		FArrayList2 iebtdemands = new FArrayList2();
		//血液诊断集合
		FArrayList2 iebtdiags = new FArrayList2();
		if (!OrdEventUtil.isEmpty(rtndtos)) {
			for (IEOpBtOrEnDTO ieOpBtOrEnDTO : rtndtos) {
				String sql = getSQlStr(ieOpBtOrEnDTO.getId_apbt());
				List<Map<String, Object>> maps=OrdEventUtil.getRsMapList(sql);
				for (Map<String, Object> map : maps) {
					String sd_restrptlabtp = OrdEventUtil.nullHandle(map.get("sd_restrptlabtp"));
					//0 数值 1字符 2枚举
					if(CD.equals(sd_restrptlabtp)){
						//枚举值
						IEOpBtCdLisItmDTO ieopbtcdlisitmdto = new IEOpBtCdLisItmDTO();
						setOpBtCDDto8Map(ieopbtcdlisitmdto, map);
						iebtcdlisitms.add(ieopbtcdlisitmdto);
					}else if(ST.equals(sd_restrptlabtp)){
						//字符串
						IEOpBtStrLisItmDTO ieopbtstrlisitmdto = new IEOpBtStrLisItmDTO();
						setOpBtStrDto8Map(ieopbtstrlisitmdto, map);
						iebtstrlisitms.add(ieopbtstrlisitmdto);
					}
				}
				ieOpBtOrEnDTO.setIebtcdlisitms(iebtcdlisitms);
				ieOpBtOrEnDTO.setIebtstrlisitms(iebtstrlisitms);
				//血液要求
				String bt_mode_id = ieOpBtOrEnDTO.getId_mode_bt();
				if(!OrdEventUtil.isEmpty(bt_mode_id)){
					List<Map<String, Object>> bd_maps =OrdEventUtil.getRsMapList(getBdModeBtSql());
					int count = bt_mode_id.indexOf(",");
					if(count > 0){
						String[] bt_mode_ids = bt_mode_id.split(",");
						for (String id : bt_mode_ids) {
							setOpBtDemandDto8Map(bd_maps, ieOpBtOrEnDTO, iebtdemands, id);
						}
					}else{
						setOpBtDemandDto8Map(bd_maps, ieOpBtOrEnDTO, iebtdemands, bt_mode_id);
					}
				}
				ieOpBtOrEnDTO.setIebtdemands(iebtdemands);
				
				//输血诊断集合
				IEOpBtDiagDTO ieopbtdiagdto = new IEOpBtDiagDTO();
				setOpBtDiDto8Map(ieopbtdiagdto, ieOpBtOrEnDTO);
				iebtdiags.add(ieopbtdiagdto);
				ieOpBtOrEnDTO.setIebtdiags(iebtdiags);
				//设置值
				setValue(ieOpBtOrEnDTO);
			}
		}
		//返回备血申请医嘱数据集合信息
		return rtndtos;
	}
	/**
	 * 设置值
	 * @param ieOpBtOrEnDTO
	 */
	private void setValue(IEOpBtOrEnDTO ieOpBtOrEnDTO) {
		//年龄
		if(!OrdEventUtil.isEmpty(ieOpBtOrEnDTO.getBirthday())){
			ieOpBtOrEnDTO.setAge(AgeCalcUtil.getAge(new FDate(new FDateTime(ieOpBtOrEnDTO.getBirthday().toString()).toString())));    
		}
		//就诊类别
		ieOpBtOrEnDTO.setJztype(getParamCodeEntp(ieOpBtOrEnDTO.getJztype()));
		//就诊次数
		if(OrdEventUtil.isEmpty(ieOpBtOrEnDTO.getTimes())) {
			ieOpBtOrEnDTO.setTimes("0");
		}
		//身高体重
		String id_en=ieOpBtOrEnDTO.getId_ent();
		IEn4CiQryService service = (IEn4CiQryService)ServiceFinder.find(IEn4CiQryService.class.getName());
		try {
			if(!OrdEventUtil.isEmpty(id_en)) {
				String[] arrStrings=id_en.split(",");
				EntOpVitalSignsDTO[] dto  = service.getEntOpVitalSigns(arrStrings);
				if(!OrdEventUtil.isEmpty(dto)) {
					//体重
					if(!OrdEventUtil.isEmpty(dto[0].getWeight())) {
						ieOpBtOrEnDTO.setWeight(dto[0].getWeight().toString());
					}
					//体重单位
					if(!OrdEventUtil.isEmpty(dto[0].getName_unit_weight())) {
						ieOpBtOrEnDTO.setWeight_unit(dto[0].getName_unit_weight());
					}
					//身高
					if(!OrdEventUtil.isEmpty(dto[0].getHeight())) {
						ieOpBtOrEnDTO.setHeight(dto[0].getHeight().toString());
					}
					//身高单位
					if(!OrdEventUtil.isEmpty(dto[0].getName_unit_height())) {
						ieOpBtOrEnDTO.setHeight_unit(dto[0].getName_unit_height());
					}
				}
			}
		} catch (BizException e) {
			ieOpBtOrEnDTO.setWeight("");
			ieOpBtOrEnDTO.setWeight_unit("");
			ieOpBtOrEnDTO.setHeight("");
			ieOpBtOrEnDTO.setHeight_unit("");
		}
	}
	/**
	 * 获取输血方式字典值
	 * @return
	 */
	private String getBdModeBtSql(){
		return " select id_udidoc,code,name from bd_udidoc where id_udidoclist = '"+mode_bt+"'";
	}
	/**
	 * 获得 SQL串 
	 * @param id_ors
	 * @return
	 */
	private String getSQlStr(String id_apbts){
		OpBtRevertCheckInfoQuery qry = new OpBtRevertCheckInfoQuery(id_apbts);
		return qry.getQrySQLStr();
	}
	
	/**
	 * IE门诊输血诊断
	 * @param dto
	 * @param map
	 */
	private void setOpBtDiDto8Map(IEOpBtDiagDTO dto,IEOpBtOrEnDTO ieOpBtOrEnDTO){
		dto.setId_iebtdiag(ieOpBtOrEnDTO.getDidef_id());
		dto.setId_iebtoren(ieOpBtOrEnDTO.getId_apbt());
		dto.setDiagnosecode("");
		dto.setDiagnosename("临床诊断");
		dto.setDiseasecode(ieOpBtOrEnDTO.getDidef_code());
		dto.setDiagnosename(ieOpBtOrEnDTO.getDidef_name());
	}
	/**
	 * IE门诊输血特殊要求
	 * @param dto
	 * @param map
	 */
	@SuppressWarnings("unchecked")
	private void setOpBtDemandDto8Map(List<Map<String, Object>> bd_maps,IEOpBtOrEnDTO ieOpBtOrEnDTO,FArrayList2 iebtdemands,String bt_mode_id){
		for (Map<String, Object> map : bd_maps) {
			String id_udidoc = OrdEventUtil.nullHandle(map.get("id_udidoc"));
			if(bt_mode_id.equals(id_udidoc)){
				IEOpBtDemandDTO ieopbtdemanddto = new IEOpBtDemandDTO();
				ieopbtdemanddto.setId_iebtdemand(id_udidoc);
				ieopbtdemanddto.setId_iebtdemand(id_udidoc);
				ieopbtdemanddto.setId_iebtoren(ieOpBtOrEnDTO.getId_apbt());
				ieopbtdemanddto.setId_iebtoren(ieOpBtOrEnDTO.getId_apbt());
				ieopbtdemanddto.setBloodreqcode(OrdEventUtil.nullHandle(map.get("code")));
				ieopbtdemanddto.setBloodreq(OrdEventUtil.nullHandle(map.get("name")));
				iebtdemands.add(ieopbtdemanddto);
			}
		}
	}
	/**
	 * IE门诊输血数值检验项目信息 CD=枚举 DTO
	 * @param dto
	 * @param map
	 */
	private void setOpBtCDDto8Map(	IEOpBtCdLisItmDTO dto,Map<String, Object> map){
		dto.setId_iebtcdlisitm(OrdEventUtil.nullHandle(map.get("id_apbtobsindex")));
		dto.setId_iebtoren(OrdEventUtil.nullHandle(map.get("id_apbt")));
		dto.setJyresult(OrdEventUtil.nullHandle(map.get("val_restrptlab")));
		dto.setJyapplycode(OrdEventUtil.nullHandle(map.get("code_srv")));
		dto.setJyresultcode(OrdEventUtil.nullHandle(map.get("val_restrptlab")));
	}
	
	/**
	 * IE门诊输血数值检验项目信息 ST=字符串 DTO
	 * @param dto
	 * @param map
	 */
	private void setOpBtStrDto8Map(	IEOpBtStrLisItmDTO dto,Map<String, Object> map){
		dto.setId_iebtstrlisitm(iih.ci.event.ord.utils.OrdEventUtil.nullHandle(map.get("id_apbtobsindex")));
		dto.setId_iebtoren(OrdEventUtil.nullHandle(map.get("id_apbt")));
		dto.setJyresult(OrdEventUtil.nullHandle(map.get("val_restrptlab")));
		dto.setJyapplycode(OrdEventUtil.nullHandle(map.get("code_srv")));
	}
	
	/**
	 * 获得备血就诊申请数据信息集合
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	private IEOpBtOrEnDTO[] getIEOpBtOrEnDTOs(String id_ors) throws BizException{		
		OpBtRevertEntInfoQuery qry=new OpBtRevertEntInfoQuery(id_ors);
		IEOpBtOrEnDTO[] rtn = (IEOpBtOrEnDTO[])AppFwUtil.getDORstWithDao(qry, IEOpBtOrEnDTO.class);
		 return rtn;
	}
}
