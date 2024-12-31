package iih.bl.cg.service.s.bp;

import iih.bd.base.utils.AppUtils;
import iih.bd.pp.hpdupitmpri.d.HpDupItmPriDO;
import iih.bd.pp.hpdupitmpri.i.IHpdupitmpriRService;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.entplan.i.IEnthpRService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 过滤医保数据对应重复数据 只收一次金额
 * 
 * @author Administrator
 *
 */
public class FilterHpDtosBP {
	/**
	 * 过滤当前数据
	 * 
	 * @param appendBillParamDTOs
	 * @throws BizException
	 */
	public void exec(BlOrderAppendBillParamDTO[] appendBillParamDTOs) throws BizException {
		// 医嘱编号与对应行数
		Map<String, Integer> hpsrvMap = new HashMap<String, Integer>();
		Map<String, FBoolean> entMapHaveCard = new HashMap<String, FBoolean>();
		// 当前时间
		FDateTime fDateTime = AppUtils.getServerDateTime();
		// 当次划价中的就诊编号
		List<String> enidList = new ArrayList<String>();

		for (BlOrderAppendBillParamDTO billDTO : appendBillParamDTOs) {
			if (enidList.indexOf(billDTO.getId_ent()) == -1 && !StringUtil.isEmpty(billDTO.getId_ent())) {
				enidList.add(billDTO.getId_ent());
			}
		}
		if (enidList.size() == 0)
			return;
		IEnthpRService entServer = ServiceFinder.find(IEnthpRService.class);
		EntHpDO[] entHpDOs = entServer.findByAttrValStrings(EntHpDO.ID_ENT, enidList.toArray(new String[enidList.size()]));
		// 判断如果没有医保就诊数据直接返回
		if (ArrayUtil.isEmpty(entHpDOs))
			return;

		// 如果医保就诊数据中是为持卡状态 直接返回
		for (EntHpDO enhpdo : entHpDOs) {
			if(!entMapHaveCard.containsKey(enhpdo.getId_ent())&&FBoolean.TRUE.equals(enhpdo.getFg_maj()))
				entMapHaveCard.put(enhpdo.getId_ent(), enhpdo.getFg_hp_card());
		}
		// 循环判断获取当前医保的医嘱与行数
		for (BlOrderAppendBillParamDTO billDTO : appendBillParamDTOs) {
			if (!StringUtil.isEmpty(billDTO.getId_hp()) && !"~".equals(billDTO.getId_hp()) && FBoolean.TRUE.equals(entMapHaveCard.get(billDTO.getId_ent())) && FBoolean.FALSE.equals(billDTO.getFg_hpspcl())) {
				// 添加主键 以 服务编号 就诊编号 医保编号
				String srvkey = billDTO.getId_srv() + "," + billDTO.getId_ent() + "," + billDTO.getId_hp();
				int srvCount = 0;
				if (hpsrvMap.containsKey(srvkey)) {
					srvCount = hpsrvMap.get(srvkey);
					hpsrvMap.remove(srvkey);
				}
				srvCount = srvCount + 1;
				hpsrvMap.put(srvkey, srvCount);

			}
		}
		// 如果就诊为空 或者 服务数量为空 则返回
		if (hpsrvMap.size() == 0)
			return;

		List<String> srvIdList = new ArrayList<String>();
		// 将超出数量的服务编号 组成 in条件
		for (Map.Entry<String, Integer> m : hpsrvMap.entrySet()) {
			if (m.getValue() > 1) {
				srvIdList.add(m.getKey());
			}
		}

		// 判断当前是否有重复服务编号
		if (srvIdList.size() != 0) {
			IHpdupitmpriRService dupService = ServiceFinder.find(IHpdupitmpriRService.class);
			StringBuilder sb = new StringBuilder();
			int forCount = 0;
			// 循环条件 添加主键 以 服务编号 就诊编号 医保编号 符合服务与医保编号相同的重复项目时候有
			for (String keyStr : srvIdList) {
				String[] keys = keyStr.split(",");
				if (forCount != 0) {
					sb.append(" OR ");
				}
				sb.append("(");
				sb.append(HpDupItmPriDO.ID_HP + "='" + keys[2] + "'");
				sb.append(" AND " + HpDupItmPriDO.ID_SRV + "='" + keys[0] + "'");
				sb.append(")");
				forCount++;
			}
			sb.append(" AND " + HpDupItmPriDO.FG_OP + "='Y'");
			sb.append(" AND " + HpDupItmPriDO.STARTTIME + "<='" + fDateTime.toLocalString() + "'");
			sb.append(" AND " + HpDupItmPriDO.ENDTIME + ">='" + fDateTime.toLocalString() + "'");

			HpDupItmPriDO[] dupdos = dupService.find(sb.toString(), "", FBoolean.FALSE);
			if (!ArrayUtil.isEmpty(dupdos)) {
				// 循环重复项目的Key （服务编号 就诊编号 医保编号）
				for (String keyStr : srvIdList) {
					String[] keys = keyStr.split(",");
					for (HpDupItmPriDO dupdoDo : dupdos) {
						// 判断当前重复项目时候与 循环 的 医保相同
						if (!keys[2].equals(dupdoDo.getId_hp())) {
							continue;
						}
						int idorcount = 0;
						boolean isSetDto = false;
						// 备选项目
						BlOrderAppendBillParamDTO bakDto = null;
						// 同一医保下 统一就诊下 重复项目 提交数据进行减免设置
						for (BlOrderAppendBillParamDTO dto : appendBillParamDTOs) {
							if (dupdoDo.getId_srv().equals(dto.getId_srv()) && keys[1].equals(dto.getId_ent()) && keys[2].equals(dto.getId_hp())) {
								// 将第一个值设置为默认备选的单收项目
								if (idorcount == 0) {
									bakDto = dto;
									// 如果当前第一个服务为处方内 将已设置标志设置为True
									if (FBoolean.FALSE.equals(dto.getFg_selfPay()))
										isSetDto = true;
								} else {
									// 判断当前 是否已设置医保内的单收项目 如果没设置医保内的项目并且当前项目为医保项目
									if (!isSetDto && FBoolean.FALSE.equals(dto.getFg_selfPay())) {
										// 将第一个项目金额设置为0 并认为当前的项目 为 单收费项目
										bakDto.setPrice(FDouble.ZERO_DBL);
										bakDto.setPrice_ratio(FDouble.ZERO_DBL);
										bakDto.setAmt(FDouble.ZERO_DBL);
										bakDto.setAmt_ratio(FDouble.ZERO_DBL);
										bakDto.setAmt_std(FDouble.ZERO_DBL);
										bakDto.setAmt_hp(FDouble.ZERO_DBL);
										bakDto.setAmt_pat(FDouble.ZERO_DBL);
										bakDto.setRatio_pripat(FDouble.ZERO_DBL);
										isSetDto = true;
									} else {
										dto.setPrice(FDouble.ZERO_DBL);
										dto.setPrice_ratio(FDouble.ZERO_DBL);
										dto.setAmt(FDouble.ZERO_DBL);
										dto.setAmt_ratio(FDouble.ZERO_DBL);
										dto.setAmt_std(FDouble.ZERO_DBL);
										dto.setAmt_hp(FDouble.ZERO_DBL);
										dto.setAmt_pat(FDouble.ZERO_DBL);
										dto.setRatio_pripat(FDouble.ZERO_DBL);
									}
								}
								idorcount++;
							}
						}
					}
				}
			}
		}
	}
}
