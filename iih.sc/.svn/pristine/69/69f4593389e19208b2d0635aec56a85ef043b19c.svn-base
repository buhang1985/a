package iih.sc.apt.s.bp.ip;

import iih.bd.res.bed.d.Bdbed;
import iih.bd.res.bed.d.BedDTO;
import iih.sc.apt.aptip.d.AptIpDO;
import iih.sc.apt.dto.d.AptIpDTO;
import iih.sc.apt.s.bp.GetDeplNurBp;
import iih.sc.apt.s.ep.AptIpEP;
import iih.sc.apt.s.ep.BedEP;
import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScContextUtils;

import org.apache.commons.lang.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAException;

/***
 * 住院预约确认时更换床位
 * 
 * @author fanlq
 *
 */
public class ChangeBedAfterIpAptBP {

	/***
	 * 住院预约确认时更换床位
	 * 
	 * @param bedDTO 床位信息DTO
	 * @return
	 * @throws BizException
	 */
	public void exec(AptIpDTO ipAptDTO, BedDTO bedDTO) throws BizException {
		// 校验预约信息的有效性
		if (!validate(ipAptDTO, bedDTO)) {
			return;
		}
		// 修改住院预约表中数据
		AptIpEP ep = new AptIpEP();
		AptIpDO aptIpDO = ep.find(ipAptDTO.getId_scaptip());
		if (aptIpDO == null)
			return;
		aptIpDO.setId_bed(bedDTO.getId_bed());// 床位id
		aptIpDO.setId_bedtp(bedDTO.getId_bedtp());// 床位类型id
		aptIpDO.setSd_bedtype(bedDTO.getSd_bedtp());// 床位类型
		aptIpDO.setId_dep_nur_ip(bedDTO.getId_dep_belong());// 入院病区
		aptIpDO.setId_emp_cfm(ScContextUtils.getPsnId());// 计划确认人
		aptIpDO.setDt_cfm(ScAppUtils.getServerDateTime());// 计划确认时间
		aptIpDO.setStatus(DOStatus.UPDATED);
		ep.save(new AptIpDO[] { aptIpDO });

		// 修改床位状态
		BedEP bedep = new BedEP();
		Bdbed oldBed = bedep.findBed(ipAptDTO.getId_bed());
		Bdbed newBed = bedep.findBed(bedDTO.getId_bed());
		oldBed.setFg_appt(FBoolean.FALSE);
		newBed.setFg_appt(FBoolean.TRUE);
		oldBed.setStatus(DOStatus.UPDATED);
		newBed.setStatus(DOStatus.UPDATED);
		bedep.saveBed(new Bdbed[] { oldBed, newBed });
	}

	/**
	 * 校验预约信息的有效性
	 * 
	 * @param aptDTO
	 * @param bedDTO
	 * @throws BizException
	 */
	private boolean validate(AptIpDTO aptDTO, BedDTO bedDTO) throws BizException {
		if (aptDTO == null || bedDTO == null) {
			throw new BizException(IScMsgConst.SC_APT_IP_ISNULL);
		}

		// 2.校验存在业务线的申请科室是否与所选床位的病区相匹配
		String id_dep = aptDTO.getId_dep_phy_ip();// 申请科室
		String id_nur = bedDTO.getId_dep_belong();// 所属病区
		if (!matchDepANDNur(id_dep, id_nur)) {
			throw new BizException(IScMsgConst.SC_APT_IP_NURANDDEP);
		}
		return true;
	}

	/**
	 * 校验存在业务线的申请科室是否与所选床位的病区相匹配
	 * 
	 * @param id_dep
	 * @param id_nur
	 * @throws DAException
	 */
	public Boolean matchDepANDNur(String id_dep, String id_nur) throws DAException {
		GetDeplNurBp bp = new GetDeplNurBp();
		String depNurList = bp.exec(id_dep);
		if (StringUtils.isBlank(depNurList) || depNurList.contains(id_nur)) {
			return true;
		}
		return false;
	}
}
