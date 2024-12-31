package iih.bl.hp.hpque.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hp.i.IHpMDORService;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.hpsrvorca.d.HpIndicationRuleEnum;
import iih.bd.pp.hpsrvorca.i.IHpsrvorcaRService;
import iih.bl.hp.bdhpindicationdto.d.BdHpIndicationDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class GetSystemNoControlHpIndicationBp {
	/**
	 * 供医生站缓存使用 查询医保计划下的所有不控制判断方式的服务，查询条件: select * from bd_hp_srvorca where
	 * id_hp=? and (eu_hpsrvctrtp='01' or sd_hpsrvtp='2')
	 * 
	 * @param id_hp
	 *            医保计划
	 * @return 组织成BdHpIndicationDTO，
	 *         只填写：Id_srv，Fg_indic，Des_hplimit，Sd_hpsrvtp，Id_hpsrvtp
	 *         ，Code_hpindicjudged
	 * @throws BizException
	 */
	public BdHpIndicationDTO[] exec(String id_hp) throws BizException {
		// 1.查医保计划表
		IHpMDORService iHpMDORService = ServiceFinder.find(IHpMDORService.class);
		HPDO[] hPDO = iHpMDORService.find(" id_hp='" + id_hp + "'", "", FBoolean.TRUE);
		if (hPDO == null || hPDO.length == 0) {
			throw new BizException("没有查询到医保计划");
		}
		if (hPDO[0].getId_par() != null && hPDO[0].getId_par().trim().length() > 0) {
			// 复用医保计划
			hPDO = iHpMDORService.find(" id_hp='" + hPDO[0].getId_par() + "'", "", FBoolean.TRUE);
			if (hPDO == null || hPDO.length == 0) {
				throw new BizException("没有查询到复用的医保计划");
			}
		}

		// 2.查付款策略_医保计划服务或分类 :系统标志为不控制或者丙级
		IHpsrvorcaRService iHpsrvorcaRService = ServiceFinder.find(IHpsrvorcaRService.class);
		HPSrvorcaDO[] hPSrvorcaDOArr = iHpsrvorcaRService
				.find(" id_hp='" + hPDO[0].getId_hp() + "' and (eu_hpsrvctrtp='" + HpIndicationRuleEnum.NO_CONTROL + "' or sd_hpsrvtp='2')", "", FBoolean.TRUE);

		List<BdHpIndicationDTO> bdHpIndicationDTOLst = new ArrayList<BdHpIndicationDTO>();
		// 3.组织成BdHpIndicationDTO，只填写：Id_srv，Fg_indic，Des_hplimit，Sd_hpsrvtp，Id_hpsrvtp，Code_hpindicjudged
		for (HPSrvorcaDO hPSrvorcaDO : hPSrvorcaDOArr) {
			BdHpIndicationDTO bdHpIndicationDTO = new BdHpIndicationDTO();
			if (hPSrvorcaDO.getSd_hpsrvtp() != null && hPSrvorcaDO.getSd_hpsrvtp().equals("2")) // 丙级
			{
				bdHpIndicationDTO.setFg_indic(FBoolean.FALSE);// 保外,系统判断结果
			} else {
				bdHpIndicationDTO.setFg_indic(FBoolean.TRUE);// 保内,系统判断结果
			}
			bdHpIndicationDTO.setId_srv(hPSrvorcaDO.getId_srv());
			bdHpIndicationDTO.setDes_hplimit(hPSrvorcaDOArr[0].getDes()); // 医保限制条件
			bdHpIndicationDTO.setSd_hpsrvtp(hPSrvorcaDOArr[0].getSd_hpsrvtp());
			bdHpIndicationDTO.setId_hpsrvtp(hPSrvorcaDOArr[0].getId_hpsrvtp());
			bdHpIndicationDTO.setCode_hpindicjudged(null);// 判断方式
			bdHpIndicationDTOLst.add(bdHpIndicationDTO);
		}
		return bdHpIndicationDTOLst.toArray(new BdHpIndicationDTO[0]);
	}
}
