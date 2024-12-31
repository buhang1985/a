package iih.bl.hp.s.miparampack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bl.hp.dto.d.IpBillItmUploadHpDTO;
import iih.bl.hp.dto.miipcharge.d.DetailUpLoadSearchDTO;
import iih.bl.hp.i.IBlHpQryService;
import iih.bl.hp.rural.dto.d.RuralPersonInfoDTO;
import iih.bl.hp.s.miparampack.qry.GetIpBillItmUploadHpQry;
import iih.ci.ord.i.external.provide.ICiOrdBlService;
import iih.ci.ord.i.external.provide.meta.bl.OrdDrugInfo4BlDTO;
import iih.mi.biz.dto.d.InpDetailUpLoadParamDTO;
import iih.mi.biz.dto.d.InpDetailsParamDTO;
import iih.mi.biz.dto.d.MiSrvTp;
import iih.mi.biz.dto.d.ParamAttributeDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;

/**
 * 构建明细费用上传参数值
 * @author 
 *
 */
public class GetUploadInpDetailsParamBP {

	/**
	 * 构建明细费用上传参数值
	 * @param searchDto 查询条件
	 * @param attrDto 需要设置的参数
	 * @return
	 * @throws BizException
	 */

	public InpDetailUpLoadParamDTO exec(DetailUpLoadSearchDTO searchDto,
			ParamAttributeDTO attrDto) throws BizException {
		 //获得明细上传医保处方明细详细信息
		IpBillItmUploadHpDTO[] idulDtos=(	IpBillItmUploadHpDTO[]) AppFwUtil.getDORstWithDao(new GetIpBillItmUploadHpQry(searchDto.getId_ent(),searchDto.getId_stip()),IpBillItmUploadHpDTO.class);
		IpBillItmUploadHpDTO[] billItmUploadHpDTOs = getBillItmUploadHpDTOs(idulDtos,searchDto);
		InpDetailUpLoadParamDTO dto = geDetailUpLoadParamDTO(searchDto,billItmUploadHpDTOs);
		return dto;
	}
	
	/**
	 * 获得农合就诊信息
	 * @param id_ent
	 * @throws BizException
	 */
	private RuralPersonInfoDTO getRuralPersonInfoDTO(String id_ent) throws BizException{
		IBlHpQryService ieService=ServiceFinder.find(IBlHpQryService.class);
		RuralPersonInfoDTO rDto=ieService.getRuralPersonInfo(id_ent);
		return rDto;
	}
	
	/** 
	 * 获取医嘱服务药品信息和对应的服务项目主键的映射Map
	 * @param strIdEnt
	 * @return
	 * @throws BizException
	 */
	private Map<String,OrdDrugInfo4BlDTO> getIdOrSrvVsMMInfoMap(String strIdEnt) throws BizException
	{
		//获取本次就诊下所有药品信息
		ICiOrdBlService ciOrdBlService=ServiceFinder.find(ICiOrdBlService.class);
		List<OrdDrugInfo4BlDTO> lst=java.util.Arrays.asList(ciOrdBlService.getOrdDrugInfo4BlDTOs(strIdEnt,null,null,new FBoolean(false)));
		Map<String,OrdDrugInfo4BlDTO> map=new HashMap<String, OrdDrugInfo4BlDTO>();
		for(OrdDrugInfo4BlDTO item:lst){
			if(!map.containsKey(item.getId_orsrv()))
			{
				map.put(item.getId_orsrv(), item);
			}
		}
		return map;
	}
	/**
	 * 补全字段
	 * @param idulDtos
	 * @param searchDto
	 * @return
	 * @throws BizException
	 */
	private IpBillItmUploadHpDTO [] getBillItmUploadHpDTOs(IpBillItmUploadHpDTO[] idulDtos,DetailUpLoadSearchDTO searchDto) throws BizException{
		//查询草药单复方规则，且修改单复方标志 BdHpLimitPsdDO
		String[] fields = {"Id_srv"};
		String sql = " select id_srv from bd_hp_limit_psd ";
		List<String> limitPsdDoList = (List<String>)new DAFacade().execQuery(sql, new ColumnListHandler());
		//获取对照信息
		Map<String,OrdDrugInfo4BlDTO> map=this.getIdOrSrvVsMMInfoMap(searchDto.getId_ent());
		
		for(IpBillItmUploadHpDTO billHpDto : idulDtos) {

			if(IBdSrvDictCodeConst.SD_SRVTP_DRUG.equals(billHpDto.getSd_srvtp().substring(0,2))){
				//如果是药品信息补全剂型、规格等属性
				//拿到对应的开药信息
				OrdDrugInfo4BlDTO ordDrugInfo=map.get(billHpDto.getId_orsrv());
				if(ordDrugInfo!=null)
				{
					//剂型
					billHpDto.setId_dosage(ordDrugInfo.getId_dosage());
					//剂型名称
					billHpDto.setName_dosage(ordDrugInfo.getName_dosage());
					//医疗用量
					billHpDto.setQuan_medu(ordDrugInfo.getQuan_medu());
					//用量单位
					billHpDto.setMeduunit_name(ordDrugInfo.getName_medu());
					//频次主键
					billHpDto.setId_freq(ordDrugInfo.getId_freq());
					//频次名称
					billHpDto.setName_freq(ordDrugInfo.getName_freq());
					//用药天数
					billHpDto.setDays(ordDrugInfo.getDays_or());
					//用法
					billHpDto.setId_route(ordDrugInfo.getId_route());
					billHpDto.setName_route(ordDrugInfo.getName_route());
				}
				if(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG.equals(billHpDto.getSd_srvtp().substring(0, 4))) {
					if(limitPsdDoList.contains(billHpDto.getId_srv()))
						billHpDto.setFg_single(FBoolean.TRUE);	
					else
						billHpDto.setFg_single(FBoolean.FALSE);
				}
			}
		}
		return idulDtos;
	}
	/**
	 * 获取医保入参
	 * @param searchDto
	 * @param billDTOs
	 * @return
	 * @throws BizException
	 */
	private InpDetailUpLoadParamDTO geDetailUpLoadParamDTO(DetailUpLoadSearchDTO searchDto,IpBillItmUploadHpDTO[] billDTOs) throws BizException{
		InpDetailsParamDTO[] inpDetailsParamDTOs=new InpDetailsParamDTO[billDTOs.length];
		RuralPersonInfoDTO rDto = getRuralPersonInfoDTO(searchDto.getId_ent());//就诊信息
		for (int i = 0; i < billDTOs.length; i++) {
			InpDetailsParamDTO iDto=new InpDetailsParamDTO();
			iDto.setBillitemno(billDTOs[i].getId_cgip());//项目序号
			iDto.setFeetp_code(billDTOs[i].getCode_inccaitm());
			iDto.setFeetp_name(billDTOs[i].getName_inccaitm());
			iDto.setHis_sdsrvtp(billDTOs[i].getSd_srvtp());
			iDto.setUnit(billDTOs[i].getName_srvu());//单位
			iDto.setPrice(billDTOs[i].getPrice());
			iDto.setAmt(billDTOs[i].getAmt_ratio());
			iDto.setDoctorname(billDTOs[i].getName_emp_or());
			iDto.setDoctorcode(billDTOs[i].getId_emp_or());
			if(billDTOs[i].getEu_direct()==1)
			{
				iDto.setPresno(billDTOs[i].getId_cgip());//处方号正记录传记账id
			}
			else{
				iDto.setPresno(billDTOs[i].getId_cgpar());//处方号负记录传冲红行号
				iDto.setBillitemno_old(billDTOs[i].getId_cgpar());//负记录上传冲红记录对应原行号
			}
            iDto.setPresdate(billDTOs[i].getDt_srv());
            iDto.setQuan(billDTOs[i].getQuan());
            iDto.setOrders(billDTOs[i].getQuan());
            iDto.setDepname(billDTOs[i].getName_dep_or());
            iDto.setDepcode(billDTOs[i].getCode_dep_or());
            iDto.setInpno(rDto.getHp_serialno());//流水号
            iDto.setCreatedate(new FDateTime());
            iDto.setUpdatedate(new FDateTime());
            iDto.setOperatorname(Context.get().getStuffId());//经办人
            iDto.setDt_cg(billDTOs[i].getDt_cg());
            if(IBdSrvDictCodeConst.SD_SRVTP_DRUG.equals(billDTOs[i].getSd_srvtp().substring(0,2))){
            	iDto.setHis_fg_drug(FBoolean.TRUE);//药品标识
    			iDto.setSrvtp(MiSrvTp.DRUG);//药品
            	iDto.setSpec(billDTOs[i].getSpec());//规格
            	iDto.setDose(billDTOs[i].getId_dosage());
            	iDto.setDoseage(billDTOs[i].getQuan_medu());
            	iDto.setDosage_unit(billDTOs[i].getMeduunit_name());
            	iDto.setFreq(billDTOs[i].getId_freq());
            	iDto.setDays(billDTOs[i].getDays());
            	iDto.setUsage(billDTOs[i].getId_route());
            	iDto.setHisitemcode(billDTOs[i].getCode_mm());
            	iDto.setHisitemname(billDTOs[i].getName_mm());
            }
            else
            {
	        	iDto.setHis_fg_drug(FBoolean.FALSE);//药品标识
				iDto.setHisitemcode(billDTOs[i].getCode_srv());
	        	iDto.setHisitemname(billDTOs[i].getName_srv());
	        	iDto.setSrvtp(MiSrvTp.TREAT);//诊疗
            }
			inpDetailsParamDTOs[i]=iDto;
		}
		List<InpDetailsParamDTO> asList = Arrays.asList(inpDetailsParamDTOs);
		FArrayList fList=new FArrayList();
		fList.addAll(asList);
		InpDetailUpLoadParamDTO idulpDto=new InpDetailUpLoadParamDTO();
		idulpDto.setDetails(fList);
		idulpDto.setAreacode(rDto.getCh_areacode());//参合地编码
		return idulpDto;
	}
}
