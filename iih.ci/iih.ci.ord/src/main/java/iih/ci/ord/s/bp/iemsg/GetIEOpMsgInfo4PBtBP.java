package iih.ci.ord.s.bp.iemsg;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import iih.bd.base.utils.StringUtils;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.iemsg.d.IEOpBtCdLisItmDTO;
import iih.ci.ord.iemsg.d.IEOpBtDemandDTO;
import iih.ci.ord.iemsg.d.IEOpBtDiagDTO;
import iih.ci.ord.iemsg.d.IEOpBtNumLisItmDTO;
import iih.ci.ord.iemsg.d.IEOpBtOrEnDTO;
import iih.ci.ord.iemsg.d.IEOpBtStrLisItmDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.iemsg.qry.CiBtOpOrQry;
import iih.ci.ord.s.bp.iemsg.qry.CiBtOpOrViewItemQry;
import iih.ci.ord.s.bp.iemsg.qry.CiLisOpOrNoAcountQry;
import iih.en.pv.out.d.EntOpVitalSignsDTO;
import iih.en.pv.out.i.IEn4CiQryService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;

/**
 * 生成集成平台备血申请服务数据信息操作BP
 * （门诊）
 */
public class GetIEOpMsgInfo4PBtBP {
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
	public IEOpBtOrEnDTO[] exec(String id_ors) throws BizException{
		//有效性校验
		if(CiOrdUtils.isEmpty(id_ors))return null;
		
		//获得备血医嘱申请数据信息集合
		IEOpBtOrEnDTO[] rtndtos=getIEOpBtOrEnDTOs(id_ors);
		//检验项目 CD类--枚举
		FArrayList2 iebtcdlisitms = new FArrayList2();
		//检验项目字符串类
		FArrayList2 iebtstrlisitms = new FArrayList2();
		//血液要求集合
		FArrayList2 iebtdemands = new FArrayList2();
		//血液诊断集合
		FArrayList2 iebtdiags = new FArrayList2();
		if (!CiOrdUtils.isEmpty(rtndtos)) {
			for (IEOpBtOrEnDTO ieOpBtOrEnDTO : rtndtos) {
				String sql = getSQlStr(ieOpBtOrEnDTO.getId_apbt());
				List<Map<String, Object>> maps=CiOrdUtils.getRsMapList(sql);
				for (Map<String, Object> map : maps) {
					String sd_restrptlabtp = CiOrdUtils.nullHandle(map.get("sd_restrptlabtp"));
					String id_unit = CiOrdUtils.nullHandle(map.get("id_unit"));
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
				if(!CiOrdUtils.isEmpty(bt_mode_id)){
					List<Map<String, Object>> bd_maps =CiOrdUtils.getRsMapList(getBdModeBtSql());
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
				//年龄
				if(!CiOrdUtils.isEmpty(ieOpBtOrEnDTO.getBirthday())){
					FDateTime fd=new FDateTime(ieOpBtOrEnDTO.getBirthday().toString());
					FDate fDate=new FDate(fd.toString());
					String ager=AgeCalcUtil.getAge(fDate);
					ieOpBtOrEnDTO.setAge(ager);    
				}
				//身高体重
				String id_en=ieOpBtOrEnDTO.getId_ent();
				IEn4CiQryService service = (IEn4CiQryService)ServiceFinder.find(IEn4CiQryService.class.getName());
				try {
					if(!CiOrdUtils.isEmpty(id_en)) {
						String[] arrStrings=id_en.split(",");
						EntOpVitalSignsDTO[] dto  = service.getEntOpVitalSigns(arrStrings);
						if(!CiOrdUtils.isEmpty(dto)) {
							//体重
							if(!CiOrdUtils.isEmpty(dto[0].getWeight())) {
								ieOpBtOrEnDTO.setWeight(dto[0].getWeight().toString());
							}
							//体重单位
							if(!CiOrdUtils.isEmpty(dto[0].getName_unit_weight())) {
								ieOpBtOrEnDTO.setWeight_unit(dto[0].getName_unit_weight());
							}
							//身高
							if(!CiOrdUtils.isEmpty(dto[0].getHeight())) {
								ieOpBtOrEnDTO.setHeight(dto[0].getHeight().toString());
							}
							//身高单位
							if(!CiOrdUtils.isEmpty(dto[0].getName_unit_height())) {
								ieOpBtOrEnDTO.setHeight_unit(dto[0].getName_unit_height());
							}
						}
					}
					
				} catch (BizException e) {
					e.printStackTrace();
				}
			}
		}
		//返回备血申请医嘱数据集合信息
		return rtndtos;
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
		CiBtOpOrViewItemQry qry = new CiBtOpOrViewItemQry(id_apbts);
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
	private void setOpBtDemandDto8Map(List<Map<String, Object>> bd_maps,IEOpBtOrEnDTO ieOpBtOrEnDTO,FArrayList2 iebtdemands,String bt_mode_id){
		for (Map<String, Object> map : bd_maps) {
			String id_udidoc = CiOrdUtils.nullHandle(map.get("id_udidoc"));
			if(bt_mode_id.equals(id_udidoc)){
				IEOpBtDemandDTO ieopbtdemanddto = new IEOpBtDemandDTO();
				ieopbtdemanddto.setId_iebtdemand(id_udidoc);
				ieopbtdemanddto.setId_iebtdemand(id_udidoc);
				ieopbtdemanddto.setId_iebtoren(ieOpBtOrEnDTO.getId_apbt());
				ieopbtdemanddto.setId_iebtoren(ieOpBtOrEnDTO.getId_apbt());
				ieopbtdemanddto.setBloodreqcode(CiOrdUtils.nullHandle(map.get("code")));
				ieopbtdemanddto.setBloodreq(CiOrdUtils.nullHandle(map.get("name")));
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
		dto.setId_iebtcdlisitm(CiOrdUtils.nullHandle(map.get("id_apbtobsindex")));
		dto.setId_iebtoren(CiOrdUtils.nullHandle(map.get("id_apbt")));
		dto.setJyresult(CiOrdUtils.nullHandle(map.get("val_restrptlab")));
		dto.setJyapplycode(CiOrdUtils.nullHandle(map.get("code_srv")));
		dto.setJyresultcode(CiOrdUtils.nullHandle(map.get("val_restrptlab")));
	}
	
	/**
	 * IE门诊输血数值检验项目信息 ST=字符串 DTO
	 * @param dto
	 * @param map
	 */
	private void setOpBtStrDto8Map(	IEOpBtStrLisItmDTO dto,Map<String, Object> map){
		dto.setId_iebtstrlisitm(CiOrdUtils.nullHandle(map.get("id_apbtobsindex")));
		dto.setId_iebtoren(CiOrdUtils.nullHandle(map.get("id_apbt")));
		dto.setJyresult(CiOrdUtils.nullHandle(map.get("val_restrptlab")));
		dto.setJyapplycode(CiOrdUtils.nullHandle(map.get("code_srv")));
	}
	
	/**
	 * 获得备血医嘱申请数据信息集合
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	private IEOpBtOrEnDTO[] getIEOpBtOrEnDTOs(String id_ors) throws BizException{		
		CiBtOpOrQry qry=new CiBtOpOrQry(id_ors);
		IEOpBtOrEnDTO[] rtn = (IEOpBtOrEnDTO[])AppFwUtil.getDORstWithDao(qry, IEOpBtOrEnDTO.class);
		 return rtn;
	}
}