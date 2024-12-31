package iih.en.pv.s.bp.ip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.en.comm.ep.NbEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnFMapUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.IpBasicDTO;
import iih.en.pv.inpatient.d.NewbornDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.sc.pub.ScGroupControlUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取住院基本信息（病区床位卡）BP
 * 
 * @author zhengcm
 * @date 2016-07-13 11:50:00
 *
 */
public class GetIpListInfoBP {

	/**
	 * 根据条件获取住院基本信息
	 * 
	 * @param cond 查询条件
	 * @return 住院基本信息DTO数组
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public IpBasicDTO[] getIpListByCond(String cond) throws BizException {
		if (EnValidator.isEmpty(cond)) {
			return null;
		}
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT DISTINCT ");
		sql.append("ENT.ID_ENT,");
		sql.append("ENT.NAME_PAT,");
		sql.append("PAT.CODE AS CODE_PAT,");
		sql.append("PAT.ID_PAT,");
		sql.append("PAT.ID_CODE,");
		sql.append("PAT.DT_BIRTH,");
		sql.append("SEX.NAME AS NAME_SEX,");
		sql.append("IP.NAME_BED,");
		sql.append("IP.CODE_AMR_IP,");
		sql.append("IP.FG_NEWBORN,");
		sql.append("ENT.TELNO_PAT AS TEL_PAT,");
		sql.append("PAT.CODE_AMR_OEP,");
		sql.append("ENT.ID_DEP_PHY,");
		sql.append("ENT.ID_DEP_NUR,");
		sql.append("PAT.WBCODE,");
		sql.append("PAT.PYCODE,");
		sql.append("PAT.MNECODE,");
		sql.append(" CASE WHEN APO.ID_OR IS NULL THEN  'N' ELSE 'Y' END ISWAITOUT, ");
		sql.append("BED.ID_DEP_BELONG ");
		sql.append("FROM EN_ENT ENT ");
		sql.append("INNER JOIN EN_ENT_IP IP ON ENT.ID_ENT = IP.ID_ENT ");
		sql.append("INNER JOIN PI_PAT PAT ON PAT.ID_PAT = ENT.ID_PAT ");
		sql.append("INNER JOIN BD_BED BED ON BED.ID_BED = IP.ID_BED ");
		sql.append("INNER JOIN BD_UDIDOC SEX ON SEX.ID_UDIDOC = PAT.ID_SEX ");
		sql.append(" LEFT outer JOIN (SELECT DISTINCT CIOR.ID_EN AS ID_ENT,AP.ID_OR FROM CI_AP_OUT AP INNER JOIN CI_ORDER CIOR  ON AP.ID_OR = CIOR.ID_OR WHERE CIOR.SD_SU_OR IN (?, ?, ?)) APO ");
		sql.append(" ON APO.ID_ENT = ENT.ID_ENT ");
		sql.append(" WHERE ENT.FG_IP = 'Y' ");
		sql.append("AND " + ScGroupControlUtils.getGroupControlFitler(new PatiVisitDO(), "ENT") + " ");
		sql.append("AND " + cond + " ");
		sql.append("ORDER BY IP.NAME_BED");
		SqlParam param = new SqlParam();
		param.addParam(ICiDictCodeConst.SD_SU_CHECKTHROUGH);
		param.addParam(ICiDictCodeConst.SD_SU_CHECKSTOP);
		param.addParam(ICiDictCodeConst.SD_SU_FINISH);
		// 查询数据
		List<IpBasicDTO> list = (List<IpBasicDTO>) new DAFacade().execQuery(sql.toString(), param, new BeanListHandler(
				IpBasicDTO.class));
		if (null == list || list.size() == 0) {
			return null;
		}
		IpBasicDTO[] dtoArr = list.toArray(new IpBasicDTO[] {});
		// 设置患者显示数据
		this.setPatInfo(dtoArr);
		// 设置婴儿待出院
		setNbIsWaitout(dtoArr);
		return dtoArr;
	}

	/**
	 * 设置显示患者信息
	 * 
	 * @author zhengcm
	 * @param ipBasicDTOs 住院基本信息DTO数组
	 * @throws BizException
	 */
	private void setPatInfo(IpBasicDTO[] ipBasicDTOs) throws BizException {
		if (EnValidator.isEmpty(ipBasicDTOs)) {
			return;
		}
		for (IpBasicDTO dto : ipBasicDTOs) {
			String bedName = EnValidator.isEmpty(dto.getName_bed()) ? "" : dto.getName_bed() + "：";
			String patName = EnValidator.isEmpty(dto.getName_pat()) ? "" : dto.getName_pat();
			String codeAmr = EnValidator.isEmpty(dto.getCode_amr_ip()) ? "" : "(" + dto.getCode_amr_ip() + ")";
			dto.setInfo_pat(bedName + patName + codeAmr);
		}
	}
	
	/**
	 * 母亲是待出院，婴儿也设置待出院
	 * @author lilei
	 * @date 2019年12月31日
	 */
	private void setNbIsWaitout(IpBasicDTO[] ipBasicDTOs) throws BizException{
		if(EnValidator.isEmpty(ipBasicDTOs)) return;
		//待出院的母亲就诊id
		List<String> mmIdEnts = new ArrayList<>();
		for(IpBasicDTO dto : ipBasicDTOs){
			if(dto.getIswaitout()!= null && dto.getIswaitout().booleanValue()) mmIdEnts.add(dto.getId_ent());
		}
		if(EnValidator.isEmpty(mmIdEnts)) return;
		NbEP nbep = new NbEP();
		NewbornDO[] nbs = nbep.getNbMoms(mmIdEnts);
		if(EnValidator.isEmpty(nbs)) return;
		//以婴儿就诊id为键
		Map<String, NewbornDO> nbMap = EnFMapUtils.getMap("Id_ent_bb", nbs);
		for (IpBasicDTO dto : ipBasicDTOs) {
			if(nbMap.containsKey(dto.getId_ent())) dto.setIswaitout(FBoolean.TRUE);
		}
	}
}
