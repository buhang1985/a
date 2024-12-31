package iih.bl.st.opfeeout.bp;

import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.params.BlParams;
import iih.bl.st.dto.d.BlOpFeeOutDTO;
import iih.bl.st.dto.d.BlOpFeeOutFileDTO;
import iih.bl.st.dto.d.BlOpfeeInfoDTO;
import iih.bl.st.dto.d.BlStCgInfoDTO;
import iih.bl.st.dto.d.BlStItemInfoDTO;
import iih.bl.st.dto.d.BlStRefundInfoDTO;
import iih.bl.st.opfeeout.bp.qry.GetBlStItemInfoDTOQry;
import iih.bl.st.opfeeout.bp.qry.GetBlStRefundInfoDTOQry;
import iih.bl.st.opfeeout.bp.qry.GetBlopfeeoutfiledtoQry;
import iih.bl.st.opfeeout.bp.qry.GetblStCgInfoDtosQry;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDouble;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class BlOpFeeOutBp {

	/**
	 * 获取门诊就诊列表 2017年6月26日 13:17:24
	 * 
	 * @author liwq
	 * */
	@SuppressWarnings("unchecked")
	public BlOpFeeOutDTO[] getEntOepInfos(String sDate, String eDate,
			String id_pat) throws BizException {
		StringBuilder sql = new StringBuilder();
		sql.append(
				"select distinct(t.id_ent),o.times_op,t.id_pat,p.name,substr(t.dt_acpt,0,10) as dt_acpt,t.id_dep_phy,d.name as name_dep_phy,h.no_hp, ")
				.append(" s.dt_st,s.eu_sttp, case s.eu_sttp when '30' then '门诊收费结算' when '31' then '门诊挂号结算' when '40' then '门诊结算冲账' when '43' then '门诊挂号取消' end as name_sttp, s.id_stoep from en_ent t ")
				.append("INNER join bl_st_oep s on s.id_ent = t.id_ent ")
				.append("INNER JOIN bl_inc_oep inc ON s.id_stoep=INC.id_stoep ")
				.append("left join pi_pat p on p.id_pat = t.id_pat ")
				.append("INNER join en_ent_hp h on h.id_ent = t.id_ent ")
				.append("INNER join en_ent_op o on o.id_ent = t.id_ent ")
				.append("left join bd_dep d on d.id_dep = t.id_dep_phy ")
				.append("where t.code_entp in ('00','01') ")
				.append("and s.dt_st >= ? and s.dt_st <= ? ")
				.append("AND NVL(s.id_paypatoep, '~')!= '~' ")
				.append("and h.id_hp = '")
				.append(IBdPpCodeTypeConst.ID_HP_BJ_BASIC_MEDICAL_INSUR)
				.append("' ").append("and inc.fg_fundpay = 'Y' ")
				.append("and inc.fg_hp_card = 'N' ");
		// .append("AND s.EU_DIRECT='1' ")
		// .append("AND s.FG_CANC='N' ")

		if (!StringUtil.isEmpty(id_pat)) {
			sql.append(" and t.id_pat = ? ");
		}
		sql.append("order by dt_st desc");
		SqlParam sqlp = new SqlParam();
		sqlp.addParam(sDate);
		sqlp.addParam(eDate);
		if (!StringUtil.isEmptyWithTrim(id_pat)) {
			sqlp.addParam(id_pat);
		}
		List<BlOpFeeOutDTO> list = (List<BlOpFeeOutDTO>) new DAFacade()
				.execQuery(sql.toString(), sqlp, new BeanListHandler(
						BlOpFeeOutDTO.class));
		return list.toArray(new BlOpFeeOutDTO[] {});
	}

	/**
	 * 读取就诊数据（导出成文件）
	 * 
	 * @throws BizException
	 * @author Liwq Modified 2017年6月23日19:49:02
	 * */
	public BlOpfeeInfoDTO loadOutEntHpInfos(BlOpFeeOutDTO[] blOpFeeOutDTOArr,
			OperatorInfoDTO operatorInfo) throws BizException {
		BlOpfeeInfoDTO blOpfeeInfoDTO = new BlOpfeeInfoDTO();
		// 收费信息
		List<String> id_stoeplist = new ArrayList<>();
		for (BlOpFeeOutDTO blOpFeeOutDTO : blOpFeeOutDTOArr) {
			id_stoeplist.add(blOpFeeOutDTO.getId_stoep());
		}
		BlOpFeeOutFileDTO[] blPropArOepDOs = (BlOpFeeOutFileDTO[]) AppFwUtil
				.getDORstWithDao(new GetBlopfeeoutfiledtoQry(id_stoeplist),
						BlOpFeeOutFileDTO.class);
		// 收费明细
		BlStItemInfoDTO[] blStItemInfoDTOs = (BlStItemInfoDTO[]) AppFwUtil
				.getDORstWithDao(new GetBlStItemInfoDTOQry(id_stoeplist),
						BlStItemInfoDTO.class);
		FArrayList2 blOpFeeOutFileDTOList = new FArrayList2();
		for (BlOpFeeOutFileDTO blOpFeeOutFileDTO : blPropArOepDOs) {
			Map<String, FDouble> itmMap = new HashMap<>();
			for (BlStItemInfoDTO blStItemInfoDTO : blStItemInfoDTOs) {
				if (blOpFeeOutFileDTO.getId_stoep().equals(
						blStItemInfoDTO.getId_stoep())) {
					itmMap.put(blStItemInfoDTO.getName(),
							blStItemInfoDTO.getAmt());
				}
			}
			// 设置明细信息
			blOpFeeOutFileDTO.setXyfy(itmInit(itmMap.get("西药费")).toString());
			blOpFeeOutFileDTO.setZchy(itmInit(itmMap.get("中成药费")).toString());
			blOpFeeOutFileDTO.setZcy(itmInit(itmMap.get("中草药费")).toString());
			blOpFeeOutFileDTO.setCgjc(itmInit(itmMap.get("检查费")).toString());
			blOpFeeOutFileDTO.setCt(itmInit(itmMap.get("CT费")).toString());
			blOpFeeOutFileDTO.setHc(itmInit(itmMap.get("核磁费")).toString());
			blOpFeeOutFileDTO.setBc(itmInit(itmMap.get("B超费")).toString());
			blOpFeeOutFileDTO.setSyf(itmInit(itmMap.get("输氧费")).toString());
			blOpFeeOutFileDTO.setSsf(itmInit(itmMap.get("手术费")).toString());
			blOpFeeOutFileDTO.setZlf(itmInit(itmMap.get("治疗费")).toString());
			blOpFeeOutFileDTO.setFs(itmInit(itmMap.get("放射费")).toString());
			blOpFeeOutFileDTO.setFy(itmInit(itmMap.get("化验费")).toString());
			blOpFeeOutFileDTO.setSxf(itmInit(itmMap.get("输血费")).toString());
			blOpFeeOutFileDTO.setZqf("0");
			blOpFeeOutFileDTO.setXyf("0");
			blOpFeeOutFileDTO.setXlcs("0");
			blOpFeeOutFileDTO.setSfjd("0");
			blOpFeeOutFileDTO.setClf(itmInit(itmMap.get("材料费")).toString());
			// 其他
			blOpFeeOutFileDTO.setOther((((FDouble) itmInit(itmMap.get("其他")))
					.add((FDouble) itmInit(itmMap.get("自费项目")))
					.add((FDouble) itmInit(itmMap.get("挂号手续费")))
					.add((FDouble) itmInit(itmMap.get("诊疗费")))
					.add((FDouble) itmInit(itmMap.get("抢救费")))
					.add((FDouble) itmInit(itmMap.get("监测费")))).toString());
			blOpFeeOutFileDTOList.add(blOpFeeOutFileDTO);
		}

		blOpfeeInfoDTO.setBlopfeeoutfiledto(blOpFeeOutFileDTOList);
		//获取医保上传药品名称类型
		String drugName= BlParams.BLHP000017();
		
		// 记账明细
		BlStCgInfoDTO[] blStCgInfoDtos = (BlStCgInfoDTO[]) AppFwUtil
				.getDORstWithDao(new GetblStCgInfoDtosQry(id_stoeplist,drugName),
						BlStCgInfoDTO.class);
		FArrayList2 blStCgInfoDtoList = new FArrayList2();
		for (BlStCgInfoDTO blStCgInfoDto : blStCgInfoDtos) {
			blStCgInfoDtoList.add(blStCgInfoDto);
		}
		blOpfeeInfoDTO.setBlstcginfodtoarr(blStCgInfoDtoList);

		// 退费信息
		BlStRefundInfoDTO[] blStRefundInfoDTOs = (BlStRefundInfoDTO[]) AppFwUtil
				.getDORstWithDao(new GetBlStRefundInfoDTOQry(id_stoeplist),
						BlStRefundInfoDTO.class);
		FArrayList2 blStRefundInfoList = new FArrayList2();
		for (BlStRefundInfoDTO blStRefundInfoDTO : blStRefundInfoDTOs) {
			blStRefundInfoList.add(blStRefundInfoDTO);
		}
		blOpfeeInfoDTO.setBlstrefundinfodtoarr(blStRefundInfoList);
		return blOpfeeInfoDTO;

	}

	/***
	 * 如果明细金额为空,给一个初始值0
	 * @param obj
	 * @return liwenqiang
	 */
	
	private Object itmInit(Object obj) {
		if (obj == null) {
			return FDouble.ZERO_DBL.setScale(0, BigDecimal.ROUND_HALF_UP);
		} else {
			return obj;
		}

	}

}
