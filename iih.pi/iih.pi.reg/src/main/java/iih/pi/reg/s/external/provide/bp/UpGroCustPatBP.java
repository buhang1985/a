package iih.pi.reg.s.external.provide.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.pp.cust.d.CustDO;
import iih.bd.pp.cust.i.ICustDOCudService;
import iih.bd.pp.cust.i.ICustDORService;
import iih.pi.reg.dto.picustpedto.d.PiCustPeDTO;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.i.IPatiCudService;
import iih.pi.reg.pat.i.IPatiRService;
import iih.pi.reg.patcust.d.PiPatCustDO;
import iih.pi.reg.patcust.i.IPatcustRService;
import xap.lui.tools.pinyin.CnToPy;
import xap.lui.tools.pinyin.CnToWB;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 更新团检单位信息
 * 
 * @author houll 2018/11/28
 *
 */
public class UpGroCustPatBP {
	public CustDO[] exec(PiCustPeDTO[] piCustPeDTO) throws BizException {
		if (ArrayUtil.isEmpty(piCustPeDTO) || piCustPeDTO.length <= 0) {
			throw new BizException("入参为空");
		}
		StringBuilder sb = new StringBuilder();
		String whereIn = "";
		for (PiCustPeDTO piCustPeDTO2 : piCustPeDTO) {
			String id_cust = piCustPeDTO2.getId_cust();
			whereIn += (whereIn.length() == 0 ? "" : ",") + ("'" + id_cust + "'");
		}

		if (!StringUtil.isEmptyWithTrim(whereIn)) {
			sb.append(" id_cust in (" + whereIn + ") ");
		} else {
			sb.append(" 1 = 2 ");
		}

		ICustDORService patRService = ServiceFinder.find(ICustDORService.class);
		CustDO[] custDOs = patRService.find(sb.toString(), "", FBoolean.FALSE);
		List<CustDO> patDOList = new ArrayList<CustDO>();

		if (custDOs != null && custDOs.length > 0) {
			for (CustDO custDO : custDOs) {
				String id_cust = custDO.getId_cust();
				for (PiCustPeDTO PiCustPeDTO2 : piCustPeDTO) {
					String idcust = PiCustPeDTO2.getId_cust();
					if (idcust.equals(id_cust)) {
						custDO.setName(PiCustPeDTO2.getCust_name());
						custDO.setCode(PiCustPeDTO2.getCust_code());
					}
					custDO.setStatus(DOStatus.UPDATED);
					patDOList.add(custDO);
				}
			}
			CustDO[] patArr = patDOList.toArray(new CustDO[patDOList.size()]);
			ICustDOCudService patCService = ServiceFinder.find(ICustDOCudService.class);
			CustDO[] update = patCService.update(patArr);
			// 同时更新患者信息
			// 患者信息赋值
			PatiAggDO[] aggDo = this.setPatInfo(update);
			IPatiCudService patiCService = ServiceFinder.find(IPatiCudService.class);
			patiCService.update(aggDo);
			return null;

		} else {
			throw new BizException("更新失败！");
		}
	}

	/**
	 * 同时更新患者信息
	 * 
	 * @param custdos
	 * @return
	 * @throws BizException
	 */
	private PatiAggDO[] setPatInfo(CustDO[] custdos) throws BizException {
		if (ArrayUtil.isEmpty(custdos)) {
			throw new BizException("更新失败！");
		}
		// // 查询患者aggdo
		PatiAggDO[] patiAggDos = this.getIdPat(custdos);
		if (ArrayUtil.isEmpty(custdos)) {
			throw new BizException("更新失败！无对应团体患者信息");
		}
		for (int i = 0; i < custdos.length; i++) {
			PatDO pat = patiAggDos[i].getParentDO();
			pat.setStatus(DOStatus.UPDATED);
			// 名称
			pat.setName(custdos[i].getName());
			pat.setPycode(CnToPy.getPyFirstCode(pat.getName()));// 拼音码
			pat.setWbcode(CnToWB.getWBCode(pat.getName()));// 五笔码
			patiAggDos[i].setParentDO(pat);
		}
		return patiAggDos;
	}

	/**
	 * 根据客户id获取 患者id
	 * 
	 * @param custdos
	 * @return
	 * @throws BizException
	 */
	private PatiAggDO[] getIdPat(CustDO[] custdos) throws BizException {

		String[] id_custs = new String[custdos.length];
		for (int i = 0; i < custdos.length; i++) {
			id_custs[i] = custdos[i].getId_cust();
		}
		IPatcustRService service = ServiceFinder.find(IPatcustRService.class);
		PiPatCustDO[] piPatCustDOs = service.findByAttrValStrings(PiPatCustDO.ID_CUST, id_custs);
		if (ArrayUtil.isEmpty(piPatCustDOs)) {
			throw new BizException("更新失败！ 无团体患者对应关系");
		}
		List<String> idPatlist = new ArrayList<String>();
		for (PiPatCustDO piPatCustDO : piPatCustDOs) {
			idPatlist.add(piPatCustDO.getId_pat());
		}
		IPatiRService patRService = ServiceFinder.find(IPatiRService.class);
		PatiAggDO[] aggDOs = patRService.findByIds(idPatlist.toArray(new String[] {}), FBoolean.FALSE);
		return aggDOs;
	}
}
