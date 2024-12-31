package iih.mi.mc.s.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.core.SqlUtils;

import iih.bd.base.utils.FDoubleUtils;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.mhi.hpsrvselfpayfree.d.FreeMd;
import iih.bd.mhi.hpsrvselfpayfree.d.HpSrvSelfPayFreeDO;
import iih.bd.mhi.hpsrvselfpayfree.i.IHpsrvselfpayfreeRService;
import iih.mi.mc.dto.miselfpayreduce.d.MiSelfPayReduceDTO;
import iih.mi.mc.dto.miselfpayreduce.d.MiSelfPayReduceSrvDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取医保自付减免后金额
 * 
 * @author liming06
 * @since 2019-12-10
 */
public class MiSelfPayReduceAmtBP {
	/**
	 * 获取医保自付减免后金额
	 * 
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	public FMap exec(MiSelfPayReduceDTO miSelfPaydto) throws BizException {
		// 1.参数校验
		validData(miSelfPaydto);
		// 2.获取服务的减免信息
		HashMap<String, HpSrvSelfPayFreeDO> srvFreeMap = this.getHpSrvSelfPayFree(miSelfPaydto);
		// 3.组织返回信息
		FMap fMap = this.getMiSelfPayReduce(miSelfPaydto, srvFreeMap);
		return fMap;
	}

	/**
	 * 参数校验
	 * 
	 * @param miSelfPaydto
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void validData(MiSelfPayReduceDTO miSelfPaydto) throws BizException {
		if (miSelfPaydto == null) {
			throw new BizException("入参不能为空");
		}
		if (StringUtil.isEmpty(miSelfPaydto.getId_hp())) {
//			throw new BizException("入参医保id不能为空");
		}
		if (StringUtil.isEmpty(miSelfPaydto.getCode_entp())) {
//			throw new BizException("入参就诊类型不能为空");
		}
		if (ListUtil.isEmpty(miSelfPaydto.getSrvlist())) {

			for (Object obj : miSelfPaydto.getSrvlist()) {
				MiSelfPayReduceSrvDTO dto = (MiSelfPayReduceSrvDTO) obj;
				if (StringUtil.isEmpty(dto.getId_srv())) {
					throw new BizException("入参服务id不能为空");
				}
				if (dto.getAmt() == null || !FDoubleUtils.isMoreThanZero(dto.getAmt())) {
					throw new BizException("入参金额不能为空或者不能小于0");
				}
			}
		}
	}

	/**
	 * 获取医保自付减免信息
	 * 
	 * @param miSelfPaydto
	 * @return
	 * @throws BizException
	 */
	private HashMap<String, HpSrvSelfPayFreeDO> getHpSrvSelfPayFree(MiSelfPayReduceDTO miSelfPaydto) throws BizException {
		if (StringUtil.isEmpty(miSelfPaydto.getId_hp()) ||StringUtil.isEmpty(miSelfPaydto.getCode_entp()) ) {
			return new HashMap<String, HpSrvSelfPayFreeDO>();
		}
		
		String whereStr = this.getWhere(miSelfPaydto);
		IHpsrvselfpayfreeRService ser = ServiceFinder.find(IHpsrvselfpayfreeRService.class);
		HpSrvSelfPayFreeDO[] dtoArr = ser.find(whereStr, "", FBoolean.FALSE);
		if (ArrayUtil.isEmpty(dtoArr))
			return null;
		HashMap<String, HpSrvSelfPayFreeDO> map = new HashMap<String, HpSrvSelfPayFreeDO>();
		for (HpSrvSelfPayFreeDO dto : dtoArr) {
			String id = dto.getId_srv() + (!StringUtil.isEmpty(dto.getId_mm()) ? dto.getId_mm() : "");
			if (!map.containsKey(id)) {
				map.put(id, dto);
			}
		}
		return map;
	}

	/**
	 * 获取where条件
	 * 
	 * @param miSelfPaydto
	 * @return
	 */
	private String getWhere(MiSelfPayReduceDTO miSelfPaydto) {
		String whereStr = " id_hp='" + miSelfPaydto.getId_hp() + "' ";
		whereStr += this.getWhereStr(miSelfPaydto.getCode_entp());
		if (miSelfPaydto.getSrvlist() != null && miSelfPaydto.getSrvlist().size() > 0) {
			List<String> ids = new ArrayList<String>();
			for (Object obj : miSelfPaydto.getSrvlist()) {
				MiSelfPayReduceSrvDTO dto = (MiSelfPayReduceSrvDTO) obj;
				ids.add(dto.getId_srv() + (!StringUtil.isEmpty(dto.getId_mm()) ? dto.getId_mm() : "~"));
			}
			whereStr += SqlUtils.getInSqlByIds(" and id_srv || nvl(id_mm,'~') ", ids);
		}
		return whereStr;
	}

	/**
	 * 根据就诊类型组织where条件
	 * 
	 * @return
	 */
	private String getWhereStr(String code_entp) {
		String sWhere = "";
		switch (code_entp) {
		case IBdFcDictCodeConst.SD_CODE_ENTP_OP:// 门诊
			sWhere = "fg_use_op";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW:// 急诊流水
			sWhere = "fg_use_er";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID:// 急诊抢救
			sWhere = "fg_use_er1";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS:// 急诊留观
			sWhere = "fg_use_er2";
			break;
		case IBdFcDictCodeConst.SD_CODE_ENTP_IP:// 住院
			sWhere = "fg_use_ip";
			break;
		// case IBdFcDictCodeConst.SD_CODE_ENTP_FA:// 家庭病床
		// sWhere = "fg_entp_fm";
		// break;
		// case IBdFcDictCodeConst.SD_CODE_ENTP_PE:// 体检
		// sWhere = "fg_entp_pe";
		// break;
		}
		return !StringUtil.isEmpty(sWhere) ? " and " + sWhere + "='Y'" : " and 1=2 ";
	}

	/**
	 * 组织返回信息
	 * 
	 * @param miSelfPaydto
	 * @param srvFreeMap
	 * @return
	 * @throws BizException
	 */
	private FMap getMiSelfPayReduce(MiSelfPayReduceDTO miSelfPaydto, HashMap<String, HpSrvSelfPayFreeDO> srvFreeMap) throws BizException {
		FMap map = new FMap();
		for (Object obj : miSelfPaydto.getSrvlist()) {
			MiSelfPayReduceSrvDTO dto = (MiSelfPayReduceSrvDTO) obj;
			String id = dto.getId_srv() + (!StringUtil.isEmpty(dto.getId_mm()) ? dto.getId_mm() : "");
			if (srvFreeMap != null && srvFreeMap.containsKey(id)) {
				HpSrvSelfPayFreeDO hpSrvSelfPayFreeDO = srvFreeMap.get(id);
				// 金额减免
				if (FreeMd.AMT.equals(hpSrvSelfPayFreeDO.getEu_freemd())) {
					if (hpSrvSelfPayFreeDO.getAmt_reduc() == null || !FDoubleUtils.isMoreThanZero(hpSrvSelfPayFreeDO.getAmt_reduc())) {
						throw new BizException("减免金额不能为空或者不能小于0");
					}
					map.put(id, FDoubleUtils.isMoreThanZero(dto.getAmt().sub(hpSrvSelfPayFreeDO.getAmt_reduc())) ? hpSrvSelfPayFreeDO.getAmt_reduc() : dto.getAmt());
				} else {
					// 比例减免
					if (hpSrvSelfPayFreeDO.getReduc_ratio() == null || !FDoubleUtils.isMoreThanZero(hpSrvSelfPayFreeDO.getReduc_ratio())) {
						throw new BizException("减免金额比例不能为空或者不能小于0");
					}
					FDouble amt = dto.getAmt().multiply(hpSrvSelfPayFreeDO.getReduc_ratio());
					map.put(id, FDoubleUtils.isMoreThanZero(amt) && FDoubleUtils.isMoreThanZero(dto.getAmt().sub(amt)) ? amt : new FDouble(0));
				}
			} else {
				// 如果不存在减免，则返回0
				map.put(id, new FDouble(0));
			}
		}
		return map;
	}
}
