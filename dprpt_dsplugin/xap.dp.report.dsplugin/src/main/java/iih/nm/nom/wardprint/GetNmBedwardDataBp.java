package iih.nm.nom.wardprint;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import iih.nm.nom.dto.NmBedwardDTO;
import iih.nm.nom.wardprint.qry.FindNmBedwardRecordsQry;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class GetNmBedwardDataBp {

	public List<NmBedwardDTO> exec(String id_dep_mp, String dt_begin, String dt_end,String is_ward) throws BizException {

		// 1.基础参数校验
		if (!validation(dt_begin, dt_end)) {
			return null;
		}
		
		// 2.对科室数据进行拆分
		List<String> id_dep_mps = getIdDepMps(id_dep_mp);

		// 3.获取病房患者日志信息
		List<NmBedwardDTO> bedwardDTOs = getNmBedwardDTOs(id_dep_mps, dt_begin, dt_end,is_ward);

		// 4.设置日期信息，并添加合计
		setNmBedwardDTOs(bedwardDTOs);

		return bedwardDTOs;
	}

	/**
	 * 基础参数校验
	 * 
	 * @param dt_begin
	 * @param dt_end
	 * @return
	 */
	private boolean validation(String dt_begin, String dt_end) {

		if (StringUtils.isBlank(dt_begin)) {
			return false;
		}
		if (StringUtils.isBlank(dt_end)) {
			return false;
		}
		return true;
	}

	/**
	 * 获取科室id信息
	 * 
	 * @param id_dep_mp
	 * @return
	 */
	private List<String> getIdDepMps(String id_dep_mp) {
		List<String> rtnList = new ArrayList<String>();
		if (StringUtils.isNotBlank(id_dep_mp)) {
			String[] id_dep_mps = id_dep_mp.split(",");
			if (ArrayUtils.isNotEmpty(id_dep_mps)) {
				CollectionUtils.addAll(rtnList, id_dep_mps);
			}
		}
		return rtnList;
	}

	/**
	 * 获取病房患者日志信息
	 * 
	 * @param id_dep_mps
	 * @param dt_begin
	 * @param dt_end
	 * @return
	 * @throws BizException
	 */
	private List<NmBedwardDTO> getNmBedwardDTOs(List<String> id_dep_mps, String dt_begin, String dt_end,String is_ward) throws BizException {
		FindNmBedwardRecordsQry bedwardRecordsQry = new FindNmBedwardRecordsQry(id_dep_mps, dt_begin, dt_end,is_ward);
		@SuppressWarnings("unchecked")
		List<NmBedwardDTO> bedwardDTOs = (List<NmBedwardDTO>) new DAFacade().execQuery(bedwardRecordsQry.getQrySQLStr(), bedwardRecordsQry.getQryParameter(null), new BeanListHandler(NmBedwardDTO.class));
		return bedwardDTOs;
	}

	private void setNmBedwardDTOs(List<NmBedwardDTO> bedwardDTOs) {

		NmBedwardDTO bedwardDTO = new NmBedwardDTO();
		initData(bedwardDTO);
		if (CollectionUtils.isNotEmpty(bedwardDTOs)) {
			for (NmBedwardDTO nmBedwardDTO : bedwardDTOs) {
				FDate dt_record = new FDate(nmBedwardDTO.getDt_record());
				nmBedwardDTO.setIndcater_psn(nmBedwardDTO.getNew_indcater_psn()+nmBedwardDTO.getOriginal_indcater_psn());
				nmBedwardDTO.setIndstch_psn(nmBedwardDTO.getNew_indstch_psn()+nmBedwardDTO.getOriginal_indstch_psn());
				nmBedwardDTO.setIndcvcater_psn(nmBedwardDTO.getNew_indcvcater_psn()+nmBedwardDTO.getOriginal_indcvcater_psn());
				nmBedwardDTO.setTracater_psn(nmBedwardDTO.getNew_tracater_psn()+nmBedwardDTO.getOriginal_tracater_psn());
				nmBedwardDTO.setConstraint_psn(nmBedwardDTO.getNew_constraint_psn()+nmBedwardDTO.getOriginal_constraint_psn());
				nmBedwardDTO.setDt_display(String.valueOf(dt_record.getDay()));
				//sumData(bedwardDTO, nmBedwardDTO);
			}
			
		}
		//bedwardDTOs.add(bedwardDTO);
	}

	/**
	 * 初始化合计DTO
	 * 
	 * @param bedwardDTO
	 */
	private void initData(NmBedwardDTO bedwardDTO) {
		bedwardDTO.setCurrent_psn(0);
		bedwardDTO.setIndcater_psn(0);
		bedwardDTO.setNew_indcater_psn(0);
		bedwardDTO.setOriginal_indcater_psn(0);
		bedwardDTO.setIndcvcater_psn(0);
		bedwardDTO.setNew_indcvcater_psn(0);
		bedwardDTO.setOriginal_indcvcater_psn(0);
		bedwardDTO.setIndstch_psn(0);
		bedwardDTO.setNew_indstch_psn(0);
		bedwardDTO.setOriginal_indstch_psn(0);
		bedwardDTO.setTracater_psn(0);
		bedwardDTO.setNew_tracater_psn(0);
		bedwardDTO.setOriginal_tracater_psn(0);
		bedwardDTO.setConstraint_psn(0);
		bedwardDTO.setNew_constraint_psn(0);
		bedwardDTO.setOriginal_constraint_psn(0);
		bedwardDTO.setDt_display("合计");
	}

	/**
	 * 合计数据
	 * 
	 * @param bedwardDTO
	 * @param nmBedwardDTO
	 */
	private void sumData(NmBedwardDTO bedwardDTO, NmBedwardDTO nmBedwardDTO) {
		int currentPsn = bedwardDTO.getCurrent_psn().intValue() + nmBedwardDTO.getCurrent_psn().intValue();
		bedwardDTO.setCurrent_psn(currentPsn);
		int indcaterPsn = bedwardDTO.getIndcater_psn().intValue() + nmBedwardDTO.getIndcater_psn().intValue();
		bedwardDTO.setIndcater_psn(indcaterPsn);
		int newIndcaterPsn=bedwardDTO.getNew_indcater_psn()+nmBedwardDTO.getNew_indcater_psn();
		bedwardDTO.setNew_indcater_psn(newIndcaterPsn);
		int orIndcaterPsn=bedwardDTO.getOriginal_indcater_psn()+nmBedwardDTO.getOriginal_indcater_psn();
		bedwardDTO.setOriginal_indcater_psn(orIndcaterPsn);
		int indcvcaterPsn = bedwardDTO.getIndcvcater_psn().intValue() + nmBedwardDTO.getIndcvcater_psn().intValue();
		bedwardDTO.setIndcvcater_psn(indcvcaterPsn);
		int newIndcvcaterPsn=bedwardDTO.getNew_indcvcater_psn()+nmBedwardDTO.getNew_indcvcater_psn();
		bedwardDTO.setNew_indcvcater_psn(newIndcvcaterPsn);
		int orIndcvcaterPsn=bedwardDTO.getOriginal_indcvcater_psn()+nmBedwardDTO.getOriginal_indcvcater_psn();
		bedwardDTO.setOriginal_indcvcater_psn(orIndcvcaterPsn);
		int indstchPsn = bedwardDTO.getIndstch_psn().intValue() + nmBedwardDTO.getIndstch_psn().intValue();
		bedwardDTO.setIndstch_psn(indstchPsn);
		int newIndstchPsn = bedwardDTO.getNew_indstch_psn().intValue() + nmBedwardDTO.getNew_indstch_psn().intValue();
		bedwardDTO.setNew_indstch_psn(newIndstchPsn);
		int orIndstchPsn= bedwardDTO.getOriginal_indstch_psn().intValue() + nmBedwardDTO.getOriginal_indstch_psn().intValue();
		bedwardDTO.setOriginal_indstch_psn(orIndstchPsn);
		int tracaterPsn = bedwardDTO.getTracater_psn().intValue() + nmBedwardDTO.getTracater_psn().intValue();
		bedwardDTO.setTracater_psn(tracaterPsn);
		int newTracaterPsn = bedwardDTO.getNew_tracater_psn().intValue() + nmBedwardDTO.getNew_tracater_psn().intValue();
		bedwardDTO.setNew_tracater_psn(newTracaterPsn);
		int orTracaterPsn = bedwardDTO.getOriginal_tracater_psn().intValue() + nmBedwardDTO.getOriginal_tracater_psn().intValue();
		bedwardDTO.setOriginal_tracater_psn(orTracaterPsn);
		int constraintPsn = bedwardDTO.getConstraint_psn().intValue() + nmBedwardDTO.getConstraint_psn().intValue();
		bedwardDTO.setConstraint_psn(constraintPsn);
		int newConstraintPsn = bedwardDTO.getNew_constraint_psn().intValue() + nmBedwardDTO.getNew_constraint_psn().intValue();
		bedwardDTO.setNew_constraint_psn(newConstraintPsn);
		int orConstraintPsn = bedwardDTO.getOriginal_constraint_psn().intValue() + nmBedwardDTO.getOriginal_constraint_psn().intValue();
		bedwardDTO.setOriginal_constraint_psn(orConstraintPsn);
	}
}
