package iih.bl.pay.s.bp.ip;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bl.params.BlParams;
import iih.bl.pay.dto.d.BlLowerlimitOfArrearsDTO;
import iih.bl.pay.dto.d.ETPatInfoDTO;
import iih.bl.pay.dto.d.PrePaidAccAmtDTO;
import iih.bl.pay.i.IBlPayOutQryService;
import iih.en.pv.dto.d.IpBasicDTO;
import iih.en.pv.out.i.IEn4BlQryService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.SqlBuildHelper;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**\
 * 欠费下限
 * @author xy.zhou
 * @date 2018年6月26日
 */
public class GetBlLowerlimitOfArrearsBp {
	/**
	 * 
	 * @Title: exec   
	 * @Description: 获取欠费下限展示dto
	 * @param: @param id_ents
	 * @param: @return
	 * @param: @throws BizException      
	 * @return: BlLowerlimitOfArrearsDTO 
	 * @author: xy.zhou     
	 * @throws
	 */
	public BlLowerlimitOfArrearsDTO [] exec(String [] id_ents)throws BizException{
		IBlPayOutQryService iBlPayOutQryService =ServiceFinder.find(IBlPayOutQryService.class); 
		PrePaidAccAmtDTO[] accJugeIpByentIds = iBlPayOutQryService.getAccJugeIpByentIds(id_ents);
		//拼装费用数据
		BlLowerlimitOfArrearsDTO[] assemblingBlData = assemblingBlData(accJugeIpByentIds);
		//获取就诊信息
		IEn4BlQryService iEn4BlQryService =ServiceFinder.find(IEn4BlQryService.class);
		IpBasicDTO[] ipBasicInfos = iEn4BlQryService.getIpBasicInfos(id_ents);
		//组装就诊信息
		BlLowerlimitOfArrearsDTO[] assemblingEnData2 = assemblingEnData(assemblingBlData,ipBasicInfos);
		return assemblingEnData2;		
	}
	
	/**
	 * 
	 * @Title: exec   
	 * @Description: 获取欠费下限展示dto
	 * @param: @param id_ents
	 * @param: @return
	 * @param: @throws BizException      
	 * @return: BlLowerlimitOfArrearsDTO 
	 * @author: xy.zhou     
	 * @throws
	 */
	public BlLowerlimitOfArrearsDTO [] findETPatsLowerLimitOfArrears(ETPatInfoDTO etPatInfoDTO)throws BizException{
		
		SqlBuildHelper sql = new SqlBuildHelper();
		if(BlParams.BLST0002() == 1)
		{
			sql.append(" SELECT ");
			sql.append("        nvl(ACC.Prepay_Emgstay, 0) Amt_prepay_remain,");
			sql.append("        nvl(ACC.Cred_Emgstay, 0) + nvl(CRET.ENCRED, 0) AMT_CRED,");
			sql.append("        nvl(ACC.Acc_Lock_Emgstay, 0) AMT_UNCG,");
			//sql.append("        --nvl(ACC.AMT_HP, 0) AMT_HP,");
			sql.append("        nvl(ACC.Prepay_Emgstay, 0) - nvl(ACC.Acc_Lock_Emgstay, 0) AMT_BAL,");
			sql.append("        nvl(ACC.Prepay_Emgstay, 0) + nvl(ACC.Cred_Emgstay, 0) +");
			sql.append("        nvl(CRET.ENCRED, 0) - nvl(ACC.Acc_Lock_Emgstay, 0) Amt_avale,");
			sql.append("        ent.id_ent,");
			sql.append("        ent.id_pat,");
			sql.append("        case");
			sql.append("          when nvl(ACC.Prepay_Emgstay, 0) - nvl(ACC.Acc_Lock_Emgstay, 0) > 0 then");
			sql.append("           'N'");
			sql.append("          when nvl(ACC.Prepay_Emgstay, 0) - nvl(ACC.Acc_Lock_Emgstay, 0) <= 0 then");
			sql.append("           'Y'");
			sql.append("          else");
			sql.append("           'N'");
			sql.append("        end Fg_arrears,");
			sql.append("        ent.name_pat Name,");
			sql.append("        ent.dt_entry Dt_entry,");
			sql.append("        ent.dt_acpt,");
			sql.append("        ent.id_dep_phy,");
			sql.append("        ent.id_dep_nur,");
			sql.append("        depphy.name Name_dep,");
			sql.append("        depnur.name Name_nur,");
			sql.append("        ent.sd_sex_pat,");
			sql.append("        ent.dt_birth_pat,");
			sql.append("        ent.dt_end,");
			sql.append("        ent.fg_ip,");
			sql.append("        ent.id_hp,");
			sql.append("        ent.id_patca,");
			sql.append("        ca.name as Patca,");
			sql.append("        ip.id_bed,");
			sql.append("        ip.name_bed Bed_no,");
			sql.append("        ip.code_amr_ip Mr_no,");
			sql.append("        ip.sd_status,");
			sql.append("        ip.times_ip");
			sql.append("   FROM Pi_Pat_Acc ACC");
			sql.append("  INNER JOIN EN_ENT ENT");
			sql.append("     ON ENT.Id_Pat = ACC.Id_Pat");
			sql.append("  INNER JOIN bd_dep depphy");
			sql.append("     on ent.id_dep_phy = depphy.id_dep");
			sql.append("  INNER JOIN bd_dep depnur");
			sql.append("     on ent.id_dep_phy = depnur.id_dep");
			sql.append("  INNER JOIN pi_pat_ca ca");
			sql.append("     ON ent.id_patca = ca.id_patca");
			sql.append("   Left JOIN en_ent_ip ip");
			sql.append("     ON ent.id_ent = ip.id_ent");
			sql.append("   LEFT JOIN PI_PAT_CRET CRET");
			sql.append("     ON ENT.ID_PATCRET = CRET.ID_PATCRET");
		}
		else if(BlParams.BLST0002() == 2)
		{
			sql.append(" SELECT ");
			sql.append("       nvl(ACC.AMT_PREPAY, 0) Amt_prepay_remain,");
			sql.append("       nvl(ACC.AMT_CRED, 0) + nvl(CRET.ENCRED, 0) AMT_CRED,");
			sql.append("       nvl(ACC.AMT_UNCG, 0) AMT_UNCG,");
			sql.append("       nvl(ACC.AMT_HP, 0) AMT_HP,");
			sql.append("       nvl(ACC.AMT_PREPAY, 0) - nvl(ACC.AMT_UNCG, 0) AMT_BAL,");
			sql.append("       nvl(ACC.AMT_PREPAY, 0) + nvl(ACC.AMT_CRED, 0) + nvl(CRET.ENCRED, 0) - nvl(ACC.AMT_UNCG, 0) Amt_avale,");
			sql.append("       ent.id_ent,");
			sql.append("       ent.id_pat,");
			sql.append("       case");
			sql.append("       when nvl(ACC.AMT_PREPAY, 0) - nvl(ACC.AMT_UNCG, 0) > 0 then");
			sql.append("       'N'");
			sql.append("       when nvl(ACC.AMT_PREPAY, 0) - nvl(ACC.AMT_UNCG, 0) <= 0 then");
			sql.append("       'Y'");
			sql.append("       else");
			sql.append("       'N'");
			sql.append("       end Fg_arrears,");
			sql.append("       ent.name_pat Name,");
			sql.append("       ent.dt_entry Dt_entry,");
			sql.append("       ent.dt_acpt,");
			sql.append("       ent.id_dep_phy,");
			sql.append("       ent.id_dep_nur,");
			sql.append("       depphy.name Name_dep,");
			sql.append("       depnur.name Name_nur,");
			sql.append("       ent.sd_sex_pat,");
			sql.append("       ent.dt_birth_pat,");
			sql.append("       ent.dt_end,");
			sql.append("       ent.fg_ip,");
			sql.append("       ent.id_hp,");
			sql.append("       ent.id_patca,");
			sql.append("       ca.name as Patca,");
			sql.append("       ip.id_bed,");
			sql.append("       ip.name_bed Bed_no,");
			sql.append("       ip.code_amr_ip Mr_no,");
			sql.append("       ip.sd_status,");
			sql.append("       ip.times_ip");
			sql.append("  FROM EN_ENT_ACC ACC");
			sql.append(" INNER JOIN EN_ENT ENT");
			sql.append("    ON ENT.ID_ENT = ACC.ID_ENT");
			sql.append(" INNER JOIN bd_dep depphy");
			sql.append("    on ent.id_dep_phy = depphy.id_dep");
			sql.append(" INNER JOIN bd_dep depnur");
			sql.append("    on ent.id_dep_phy = depnur.id_dep");
			sql.append(" INNER JOIN pi_pat_ca ca");
			sql.append("    ON ent.id_patca = ca.id_patca");
			sql.append("  Left JOIN en_ent_ip ip");
			sql.append("    ON ent.id_ent = ip.id_ent");
			sql.append("  LEFT JOIN PI_PAT_CRET CRET");
			sql.append("    ON ENT.ID_PATCRET = CRET.ID_PATCRET");
		}
		

		sql.append(" WHERE 1=1 and ENT.Code_Entp = '"+IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS+"'");

		if (etPatInfoDTO.getId_dep_nur() != null && !(etPatInfoDTO.getId_dep_nur()).isEmpty()) {
			sql.append(" and ent.id_dep_nur ='" + etPatInfoDTO.getId_dep_nur() + "'");
		}
		if (etPatInfoDTO.getId_patca() != null &&!(etPatInfoDTO.getId_patca()).isEmpty()) {
			sql.append(" and ent.id_patca ='" + etPatInfoDTO.getId_patca() + "'");
		}
		if (etPatInfoDTO.getId_pat() != null &&!(etPatInfoDTO.getId_pat()).isEmpty()) {
			sql.append(" and ent.id_pat ='" + etPatInfoDTO.getId_pat() + "'");
		}
		if (etPatInfoDTO.getFg_ip() != null &&!(etPatInfoDTO.getFg_ip()).isEmpty()) {
			sql.append(" and ent.fg_ip ='" + etPatInfoDTO.getFg_ip() + "'");
		}
		@SuppressWarnings("unchecked")
		List<BlLowerlimitOfArrearsDTO> result = (List<BlLowerlimitOfArrearsDTO>) new DAFacade().execQuery(sql.toString(),
				new BeanListHandler(BlLowerlimitOfArrearsDTO.class));

		if (ListUtil.isEmpty(result))
			return null;

		BlLowerlimitOfArrearsDTO[] balDTOs = result.toArray(new BlLowerlimitOfArrearsDTO[0]);
		return balDTOs;		
	}
	/**
	 * 
	 * @Title: assemblingBlData   
	 * @Description: 组装费用数据  
	 * @param: @param accJugeIpByentIds
	 * @param: @return      
	 * @return: BlLowerlimitOfArrearsDTO[] 
	 * @author: xy.zhou     
	 * @throws
	 */
	private  BlLowerlimitOfArrearsDTO[] assemblingBlData(PrePaidAccAmtDTO[] accJugeIpByentIds){
		BlLowerlimitOfArrearsDTO [] blArrearsDTOs=new BlLowerlimitOfArrearsDTO[accJugeIpByentIds.length];
		for (int i = 0; i < blArrearsDTOs.length; i++) {
			BlLowerlimitOfArrearsDTO blLowerlimitOfArrearsDTO=new BlLowerlimitOfArrearsDTO();
			blLowerlimitOfArrearsDTO.setAmt_prepay_remain(accJugeIpByentIds[i].getAmt_prepay());;//当前押金
			blLowerlimitOfArrearsDTO.setAmt_avale(accJugeIpByentIds[i].getAmt_available());;//可用余额
			blLowerlimitOfArrearsDTO.setFg_arrears(accJugeIpByentIds[i].getFg_arrears());//欠费标志
			blLowerlimitOfArrearsDTO.setArrearslower(accJugeIpByentIds[i].getAmt_limit());//欠费下限 
			blLowerlimitOfArrearsDTO.setId_ent(accJugeIpByentIds[i].getId_ent());
			blArrearsDTOs[i]=blLowerlimitOfArrearsDTO;
			blLowerlimitOfArrearsDTO=null;
		}
		return blArrearsDTOs;
	}
	/**
	 * 
	 * @Title: assemblingEnData   
	 * @Description: 组装就诊数据  
	 * @param: @param assemblingBlData
	 * @param: @param ipBasicInfos
	 * @param: @return      
	 * @return: BlLowerlimitOfArrearsDTO[] 
	 * @author: xy.zhou     
	 * @throws
	 */
	private BlLowerlimitOfArrearsDTO [] assemblingEnData(BlLowerlimitOfArrearsDTO[] assemblingBlData,IpBasicDTO [] ipBasicInfos){
		Map<String, IpBasicDTO> map=new HashMap<>();
		for (int i = 0; i < ipBasicInfos.length; i++) {
			map.put(ipBasicInfos[i].getId_ent(),ipBasicInfos[i]);
		}
		for (int i = 0; i < assemblingBlData.length; i++) {
			IpBasicDTO ipBasicDTO = map.get(assemblingBlData[i].getId_ent());			
				assemblingBlData[i].setName_nur(ipBasicDTO.getName_dep_nur());//病区
				assemblingBlData[i].setName_dep(ipBasicDTO.getName_dep_phy());//科室
				assemblingBlData[i].setName(ipBasicDTO.getName_pat());//姓名
				assemblingBlData[i].setBed_no(ipBasicDTO.getName_bed());//床号
				assemblingBlData[i].setDt_entry(ipBasicDTO.getDt_entry());//入院时间
				assemblingBlData[i].setMr_no(ipBasicDTO.getCode_amr_ip());//病历号
				assemblingBlData[i].setPatca(ipBasicDTO.getName_patca());
		}		
		return assemblingBlData;
	}
}
